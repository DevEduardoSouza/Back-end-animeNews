package br.com.site.news.siteNews.facade;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.site.news.siteNews.model.UserModel;

public interface IUserFacade {
    // 
    public abstract List<UserModel> getUsers();
    public abstract ResponseEntity<Object> registerUser(UserModel user);
}
