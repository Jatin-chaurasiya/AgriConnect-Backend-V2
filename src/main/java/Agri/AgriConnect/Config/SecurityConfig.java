package Agri.AgriConnect.Config;

import Agri.AgriConnect.Security.JwtRequestFilter;
import Agri.AgriConnect.Service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomUserDetailsService customUserDetailsService;
    private final JwtRequestFilter jwtRequestFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .cors(cors -> {})
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth

                        // Public APIs
                        .requestMatchers("/auth/**").permitAll()
                        .requestMatchers("/weather/**").permitAll()
                        .requestMatchers("/chat/**").permitAll()
                        .requestMatchers("/schemes/**").permitAll()
                        .requestMatchers("/api/crop/**").permitAll()
                        .requestMatchers("/crop-planner/**").permitAll()
                        .requestMatchers("/test/send-email").permitAll()

                        // Farmer APIs
                        .requestMatchers("/farmer/**").hasRole("FARMER")
                        .requestMatchers("/profile/farmer/**").hasRole("FARMER")
                        .requestMatchers("/profile/become-provider")
                        .hasRole("FARMER")

                        // Provider APIs
                        .requestMatchers("/provider/**").hasRole("PROVIDER")
                        .requestMatchers("/bookings/provider/**")
                        .hasRole("PROVIDER")
                        .requestMatchers("/profile/provider/**").hasRole("PROVIDER")

                        // Admin APIs
                        .requestMatchers("/admin/**").hasRole("ADMIN")

                        // Temporary Test APIs
                        .requestMatchers("/test/farmer").hasRole("FARMER")
                        .requestMatchers("/test/provider").hasRole("PROVIDER")
                        .requestMatchers("/test/admin").hasRole("ADMIN")

                        .anyRequest().authenticated()
                )
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authenticationProvider(daoAuthenticationProvider())
                .addFilterBefore(jwtRequestFilter,
                        UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {

        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider(customUserDetailsService);

        provider.setPasswordEncoder(passwordEncoder());

        return provider;
    }
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        System.out.println(new BCryptPasswordEncoder().encode("admin123"));

        CorsConfiguration configuration = new CorsConfiguration();

        configuration.setAllowCredentials(true);
        configuration.setAllowedOrigins(
                List.of(
                        "http://localhost:5173",
                        "https://agri-connect-89.netlify.app",
                        "http://agriconnect.jatindev.xyz"
                )
        );

        configuration.setAllowedHeaders(
                java.util.List.of("*")
        );

        configuration.setAllowedMethods(
                java.util.List.of("GET", "POST", "PUT", "DELETE", "OPTIONS")
        );

        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/**", configuration);

        return source;
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(daoAuthenticationProvider());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
