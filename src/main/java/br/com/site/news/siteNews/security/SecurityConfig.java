package br.com.site.news.siteNews.security;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {



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
                .oauth2Login(Customizer.withDefaults())

                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
                .build();
    }
}
