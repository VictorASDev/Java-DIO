package com.security.security_aula.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.CrossOrigin;

//Define a classe como uma cçasse de configuração
@Configuration
//Permite que ela configure métodos de segurança do Spring Security
@EnableMethodSecurity
@CrossOrigin("*")
public class WebSecurityConfig {

    @Autowired
    private SecurityDatabaseService securityDatabaseService;
    
    @Autowired
    public void globalDetails(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(securityDatabaseService).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }
/*
    @Bean
    public UserDetailsService userDetailsService() {
        //Cria usuários definindo seus nomes, senhas e tipos
        UserDetails user = User.withUsername("user")
                .password("{noop}user123")
                .roles("USER")
                .build();

        UserDetails admin = User.withUsername("admin")
                .password("{noop}admin123")
                .roles("MANAGERS")
                .build();

        //Salva esses usuários na memória
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
        userDetailsManager.createUser(user);
        userDetailsManager.createUser(admin);

        return userDetailsManager;
    }
*/

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/auth").permitAll()
                .requestMatchers(HttpMethod.POST, "/auth").permitAll()
                .requestMatchers("/managers").hasRole("MANAGERS")
                .anyRequest().authenticated()
            )
            .csrf(csrf -> csrf.disable())
            .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
