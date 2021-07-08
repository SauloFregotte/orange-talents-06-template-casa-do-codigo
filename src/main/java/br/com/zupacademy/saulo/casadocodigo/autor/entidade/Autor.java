package br.com.zupacademy.saulo.casadocodigo.autor.entidade;

//import br.com.zupacademy.saulo.casadocodigo.validator.UniqueValue;
import br.com.zupacademy.saulo.casadocodigo.EntityException;
import br.com.zupacademy.saulo.casadocodigo.autor.RepositoryAutorJPA;
import br.com.zupacademy.saulo.casadocodigo.livro.entidade.Livro;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Entity
public class Autor {

    private static final String EMAIL_REGEX_ISO = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
    private static final Pattern pattern = Pattern.compile(EMAIL_REGEX_ISO);

    public static boolean validarFormatoEmail(final String email){
        if(email.trim().equals("")) return false;
        return pattern.matcher(email).find();
    }
    private Autor(){}

    public Autor(final String nome){
        this.nome = nome;
    }

    public Autor(final String nome, final String email, final String descricao){
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotEmpty
    @Size(min = 3, max = 150)
    private String nome;

    @Email
    @NotBlank
    @NotEmpty
    //@UniqueValue(domainClass = Autor.class, fieldName="email")
    private String email;

    @NotNull
    @Size(max = 400)
    private String descricao;

    @OneToMany(mappedBy = "autor")
    private List<Livro> livros;

    private LocalDateTime dataDeCriacao = LocalDateTime.now();

    public Autor cadastrar(final RepositoryAutorJPA repositoryAutorJPA){
        verifyIfExistsDuplicatedEmail(repositoryAutorJPA)
                .ifPresent(e->{throw new EntityException("Não é possivel salvar autores com email duplicado!");});
        return repositoryAutorJPA.save(this);
    }

    private Optional<Autor> verifyIfExistsDuplicatedEmail(RepositoryAutorJPA repositoryAutorJPA){
        return repositoryAutorJPA.findFirstAutorByEmail(email);
    }

    public Autor verifyIfAutorExists(RepositoryAutorJPA repositoryAutorJPA) {
        return repositoryAutorJPA.findAutorByNome(nome)
                .orElseThrow(() -> {throw new IllegalArgumentException();});
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
