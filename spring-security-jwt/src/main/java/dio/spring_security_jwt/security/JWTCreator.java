package dio.spring_security_jwt.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.List;
import java.util.stream.Collectors;

public class JWTCreator {
    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String ROLES_AUTHORITIES = "authorities";

    // Geração de token
    public static String create(String prefix, String key, JWTObject jwtObject) {
        System.out.println("prefix1: " + prefix);
        System.out.println("key: " + key);
        Key hmacKey = Keys.hmacShaKeyFor(key.getBytes(StandardCharsets.UTF_8));

        String token = Jwts.builder()
                .setSubject(jwtObject.getSubject())
                .setIssuedAt(jwtObject.getIssuedAt())
                .setExpiration(jwtObject.getExpiration())
                .claim(ROLES_AUTHORITIES, checkRoles(jwtObject.getRoles()))
                .signWith(hmacKey, SignatureAlgorithm.HS512)
                .compact();

        return "Bearer " + token;
    }

    // Leitura e validação do token
    public static JWTObject create(String token, String prefix, String key) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, io.jsonwebtoken.security.SignatureException {
        System.out.println("prefix: " + prefix);
        System.out.println("key: " + key);
        System.out.println("token: " + token);

        Key hmacKey = Keys.hmacShaKeyFor(key.getBytes(StandardCharsets.UTF_8));
        token = token.replace(prefix, "").trim();

        Claims claims = Jwts.parser()
                .setSigningKey(hmacKey)
                .build()
                .parseClaimsJws(token)
                .getBody();

        JWTObject object = new JWTObject();
        object.setSubject(claims.getSubject());
        object.setExpiration(claims.getExpiration());
        object.setIssuedAt(claims.getIssuedAt());
        Object rolesObject = claims.get(ROLES_AUTHORITIES);
        List<String> roles = ((List<?>) rolesObject).stream()
                .map(Object::toString)
                .collect(Collectors.toList());
        object.setRoles(roles);

        return object;
    }

    private static List<String> checkRoles(List<String> roles) {
        return roles.stream()
                .map(s -> "ROLE_".concat(s.replaceAll("ROLE_", "")))
                .collect(Collectors.toList());
    }
}
