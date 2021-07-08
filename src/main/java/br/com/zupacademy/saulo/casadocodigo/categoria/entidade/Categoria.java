package br.com.zupacademy.saulo.casadocodigo.categoria.entidade;

//import br.com.zupacademy.saulo.casadocodigo.validator.UniqueValue;
import br.com.zupacademy.saulo.casadocodigo.EntityException;
import br.com.zupacademy.saulo.casadocodigo.categoria.RepositoryCategoriaJPA;
import br.com.zupacademy.saulo.casadocodigo.livro.entidade.Livro;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Optional;

@Entity
public class Categoria {

    private Categoria(){}

    public Categoria(String nome) {
        this.nome = nome;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotEmpty
    @Size(min = 3, max = 150)
    //@UniqueValue(domainClass = Categoria.class, fieldName="nome")
    private String nome;

    @OneToMany(mappedBy = "categoria")
    private List<Livro> livros;

    public Categoria cadastrar(RepositoryCategoriaJPA repositoryCategoriaJPA) {
        verifyIfExistsDuplicatedName(repositoryCategoriaJPA)
                .ifPresent(e->{throw new EntityException("Categoria already exists!");});
        return repositoryCategoriaJPA.save(this);
    }

    private Optional<Categoria> verifyIfExistsDuplicatedName(RepositoryCategoriaJPA repositoryCategoriaJPA) {
        return repositoryCategoriaJPA.findFirstCategoriaByNome(nome);
    }

    public Categoria verifyIfCategoriaExists(RepositoryCategoriaJPA repositoryCategoriaJPA) {
         return repositoryCategoriaJPA.findFirstCategoriaByNome(nome)
                 .orElseThrow(() -> {throw new IllegalArgumentException();});
    }

    public String getNome() {
        return nome;
    }
}
