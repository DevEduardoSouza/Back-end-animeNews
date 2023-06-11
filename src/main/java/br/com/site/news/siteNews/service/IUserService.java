package br.com.site.news.siteNews.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.site.news.siteNews.model.UserModel;

public interface IUserService {
    //
    public abstract List<UserModel> getUsers();
    public abstract ResponseEntity<Object> registerUser(UserModel user);
    
}
