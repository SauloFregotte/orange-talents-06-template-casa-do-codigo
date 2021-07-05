package br.com.zupacademy.saulo.casadocodigo.categoria.entidade;

//import br.com.zupacademy.saulo.casadocodigo.validator.UniqueValue;
import br.com.zupacademy.saulo.casadocodigo.EntityException;
import br.com.zupacademy.saulo.casadocodigo.categoria.RepositoryCategoriaJPA;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
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

    public Categoria cadastrar(RepositoryCategoriaJPA repositoryCategoriaJPA) {
        verifyIfExistsDuplicatedName(repositoryCategoriaJPA)
                .ifPresent(e->{throw new EntityException("Não é possivel salvar categorias com nome duplicado!");});
        return repositoryCategoriaJPA.save(this);
    }

    private Optional<Categoria> verifyIfExistsDuplicatedName(RepositoryCategoriaJPA repositoryCategoriaJPA) {
        return repositoryCategoriaJPA.findFirstCategoriaByNome(nome);
    }

    public String getNome() {
        return nome;
    }
}
