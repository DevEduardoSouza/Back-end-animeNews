package br.com.site.news.siteNews.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.site.news.siteNews.model.UserModel;
import br.com.site.news.siteNews.service.IUserService;

@Service
public class UserFacade implements IUserFacade{

    @Autowired
    private IUserService userService;

    @Override
    public List<UserModel> getUsers() {
        // TODO Auto-generated method stub
        return userService.getUsers();
    }

    @Override
    public ResponseEntity<?> registerUser(UserModel user) {
        // TODO Auto-generated method stub
        return userService.registerUser(user);
    }
    
}
