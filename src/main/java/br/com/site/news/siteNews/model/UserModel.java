package br.com.site.news.siteNews.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class UserModel extends AbstractEntity {

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 4, max = 128, message = "O nome precisa ter no mínimo 4 caracteres e no máximo 128")
    private String name;
    
    @NotBlank(message = "Username é obrigatório")
    @Size(min = 4, max = 128, message = "O username precisa ter no mínimo 4 caracteres e no máximo 128")
    private String username;

    @Email(message = "O email está incorreto")
    @Column(unique = true)
    @NotBlank(message = "Email é obrigatório")
    private String email;

    @Size(min = 8, max = 128, message = "A senha precisa ter no mínimo 8 caracteres e no máximo 128")
    @NotBlank(message = "A senha é obrigatória")
    private String password;
}
