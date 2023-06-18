package br.com.site.news.siteNews.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import br.com.site.news.siteNews.dtos.LoginDto;
import org.apache.catalina.connector.Response;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.site.news.siteNews.dtos.UserDto;
import br.com.site.news.siteNews.facade.IUserFacade;
import br.com.site.news.siteNews.model.UserModel;
import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private IUserFacade userFacade;


    @GetMapping("/listar")
    public List<UserModel> getUsers(){
        return userFacade.getUsers();
    }

    //Cadastar usuário
    @PostMapping("/cadastrar")
    public ResponseEntity<Object> cadastrar(@RequestBody @Valid UserDto userDto){
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userDto, userModel);
        userModel.setRegisterDate(LocalDateTime.now(ZoneId.of("UTC")));

        return userFacade.registerUser(userModel);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody @Valid LoginDto login){
        return ResponseEntity.status(HttpStatus.OK).body("teste");
    }

//    Endpoint home para teste de autenticação


    @GetMapping("/home")
    public String home(@AuthenticationPrincipal OidcUser user){
        return "Rota privada";
    }
    @GetMapping("/cookie")
    public String cookie(@AuthenticationPrincipal OidcUser user){
        return String.format("""
					<h1>Oauth2 🔐  </h1>
				<h3>Principal: %s</h3>
				<h3>Email attribute: %s</h3>
				<h3>Authorities: %s</h3>
				<h3>JWT: %s</h3>
				""", user, user.getAttribute("email"), user.getAuthorities(),
                user.getIdToken().getTokenValue());
    }


    @GetMapping("/public")
    public String publica(){
        return "rota publica";
    }
    
}
