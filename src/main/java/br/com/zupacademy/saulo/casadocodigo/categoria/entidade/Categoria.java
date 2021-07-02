package br.com.zupacademy.saulo.casadocodigo.categoria.entidade;

import br.com.zupacademy.saulo.casadocodigo.categoria.repository.RepositoryCategoriaJPA;
import br.com.zupacademy.saulo.casadocodigo.validator.UniqueValue;
import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Categoria {

    private Categoria(){}

    public Categoria(String nome) {
        this.nome = nome;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @NotEmpty
    @Size(min = 3, max = 150)
    @UniqueValue(domainClass = Categoria.class, fieldName="nome")
    private String nome;

    public Categoria cadastrar(RepositoryCategoriaJPA repositoryCategoriaJPA) {
        return repositoryCategoriaJPA.save(this);
    }

    public String getNome() {
        return nome;
    }
}
