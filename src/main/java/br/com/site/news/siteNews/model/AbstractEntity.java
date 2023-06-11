package br.com.site.news.siteNews.model;

import java.util.UUID;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
}
