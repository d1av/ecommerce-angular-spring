package com.davi.shop.config;

import com.davi.shop.security.JwtAuthenticationEntryPoint;
import com.davi.shop.security.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private UserDetailsService userDetailsService;

    private JwtAuthenticationEntryPoint authenticationEntryPoint;

    private JwtAuthenticationFilter authenticationFilter;

    public SecurityConfig(UserDetailsService userDetailsService, JwtAuthenticationEntryPoint authenticationEntryPoint, JwtAuthenticationFilter authenticationFilter) {
        this.userDetailsService = userDetailsService;
        this.authenticationEntryPoint = authenticationEntryPoint;
        this.authenticationFilter = authenticationFilter;
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeHttpRequests(
                        (authorize) ->
                                authorize.requestMatchers("/h2/**").permitAll()
                                        .requestMatchers("/api/orders/**").authenticated()
                                        .requestMatchers(HttpMethod.GET, "/states/**").permitAll()
                                        .requestMatchers(HttpMethod.GET, "/products/**").permitAll()
                                        .requestMatchers(HttpMethod.GET, "/countries/**").permitAll()
                                        .requestMatchers(HttpMethod.GET, "/product-categories/**").permitAll()
                                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                                        .requestMatchers("/v3/api-docs/**",
                                                "/configuration/ui",
                                                "/swagger-resources/**",
                                                "/configuration/security",
                                                "/webjars/**",
                                                "/swagger-ui/**").permitAll()
                                        .requestMatchers("/checkout/**").permitAll()
                                        .requestMatchers("/api/auth/**").permitAll()
                                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                .exceptionHandling(exception -> exception.authenticationEntryPoint(authenticationEntryPoint))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .cors();


        http.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails ramesh = User.builder()
//                .username("ramesh")
//                .password(passwordEncoder().encode("ramesh"))
//                .roles("USER")
//                .build();
//
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password(passwordEncoder().encode("admin"))
//                .roles("ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(ramesh, admin);
//    }
}