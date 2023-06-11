package br.com.site.news.siteNews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.site.news.siteNews.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long>{

    boolean existsByEmail(String email);
    
}
