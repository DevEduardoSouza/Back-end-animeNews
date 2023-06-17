package br.com.site.news.siteNews.security;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Value("${CLIENT_ID}")
    private String clientId;

    @Value("${CLIENT_SECRET}")
    private String clientSecret;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
                .authorizeHttpRequests(
                        authorizeConfig -> {
                            authorizeConfig.requestMatchers("/api/logout").permitAll();
                            authorizeConfig.requestMatchers("/api/cadastrar").permitAll();
                            authorizeConfig.requestMatchers("/api/public").permitAll();
                            authorizeConfig.anyRequest().authenticated();
                        }
                )
//                .formLogin(formLogin -> formLogin.loginPage("/api/login")
//                        .permitAll()
//                )
                .formLogin(Customizer.withDefaults())
                .build();
    }
}
