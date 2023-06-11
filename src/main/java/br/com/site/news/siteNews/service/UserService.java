package br.com.site.news.siteNews.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.site.news.siteNews.model.UserModel;
import br.com.site.news.siteNews.repository.UserRepository;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<UserModel> getUsers() {
        // TODO Auto-generated method stub
        return userRepository.findAll();
    }

    @Override
    public ResponseEntity<Object> registerUser(UserModel user) {
       
        // Verificar se o email já existe
        if(userRepository.existsByEmail(user.getEmail())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("O Email já existe");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(userRepository.save(user));
    }
    
}
