package br.com.site.news.siteNews.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginDto {

    @Email(message = "O email está incorreto")
    @NotBlank(message = "Email é obrigatório")
    private String email;

    @Size(min = 8, max = 128, message = "A senha precisa ter no mínimo 8 caracteres e no máximo 128")
    @NotBlank(message = "A senha é obrigatória")
    private String password;
}
