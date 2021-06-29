package br.com.zupacademy.saulo.casadocodigo.autor.entidade;

import br.com.zupacademy.saulo.casadocodigo.autor.repositorio.RepositoryAutorJPA;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.regex.Pattern;

@Entity
public class Autor {

    private static final String EMAIL_REGEX_ISO = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
    private static final Pattern pattern = Pattern.compile(EMAIL_REGEX_ISO);

    public static boolean validarEmail(final String email){
        if(email.trim().equals("")) return false;
        return pattern.matcher(email).find();
    }

    public Autor(final String nome, final String email, final String descricao){
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @NotEmpty
    @Size(min = 3, max = 150)
    private String nome;

    @Email
    @NotNull
    @NotBlank
    @NotEmpty
    private String email;

    @NotNull
    @Size(max = 400)
    private String descricao;

    private LocalDateTime dataDeCriacao = LocalDateTime.now();

    public Autor cadastrar(RepositoryAutorJPA repositoryAutorJPA){
        return repositoryAutorJPA.save(this);
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }
}
