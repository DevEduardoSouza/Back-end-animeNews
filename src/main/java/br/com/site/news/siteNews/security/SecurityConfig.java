package br.com.site.news.siteNews.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf().disable()               //desabilito o csrf pq que que vou tratar o autenticação do usuários
                .authorizeHttpRequests()    //agora as ruequisições http são passiveis de autorização
                .requestMatchers(HttpMethod.POST, "/cadastrar").permitAll() //Especificando quem é liberado
                .requestMatchers(HttpMethod.POST, "/login").permitAll()
                .anyRequest().authenticated().and().cors();

        http.addFilterBefore(new Filter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
