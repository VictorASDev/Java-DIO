package dio.spring_security_jwt.security;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JWTFilter extends OncePerRequestFilter {

    private SecurityConfig securityConfig;

    public void setSecurityConfig(SecurityConfig securityConfig) {
        this.securityConfig = securityConfig;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Se for rota pública, ignora o filtro
        if (request.getRequestURI().equals("/login")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = request.getHeader(JWTCreator.HEADER_AUTHORIZATION);
        System.out.println("Token recebido: " + token);

        try {
            if (token != null && !token.isEmpty()) {
                System.out.println("Tentando decodificar o token...");
                JWTObject jwtObject = JWTCreator.create(token, securityConfig.getPrefix(), securityConfig.getKey());
                System.out.println("Objeto criado: " + jwtObject);
                List<SimpleGrantedAuthority> authorities = authorities(jwtObject.getRoles());
                System.out.println(jwtObject.getRoles());
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                        jwtObject.getSubject(), null, authorities
                );
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
            filterChain.doFilter(request, response);
        } catch (ExpiredJwtException e) {
            e.printStackTrace();
            response.sendError(HttpStatus.UNAUTHORIZED.value(), "Token expirado");
        } catch (UnsupportedJwtException | MalformedJwtException e) {
            e.printStackTrace();
            response.sendError(HttpStatus.FORBIDDEN.value(), "Token inválido");
        } catch (io.jsonwebtoken.security.SignatureException e) {
            e.printStackTrace();
            response.sendError(HttpStatus.FORBIDDEN.value(), "Assinatura do token inválida");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Erro ao processar token");
        }
    }

    public List<SimpleGrantedAuthority> authorities(List<String> roles) {
        return roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }
}

