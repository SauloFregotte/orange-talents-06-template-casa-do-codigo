package br.com.zupacademy.saulo.casadocodigo.pais.entidade;

import br.com.zupacademy.saulo.casadocodigo.EntityException;
import br.com.zupacademy.saulo.casadocodigo.cliente.entidade.Cliente;
import br.com.zupacademy.saulo.casadocodigo.estado.entidade.Estado;
import br.com.zupacademy.saulo.casadocodigo.estado.entidade.EstadoRequest;
import br.com.zupacademy.saulo.casadocodigo.pais.RepositorioPaisJPA;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Pais {

    public Pais(final String nome) {
        this.nome = nome;
    }

    private Pais(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotEmpty
    @Size(min = 3, max = 150)
    private String nome;

    @OneToMany(mappedBy = "pais")
    private List<Estado> estado;

    @OneToOne(mappedBy = "pais")
    private Cliente cliente;

    public static Pais verifyIfPaisExists(final RepositorioPaisJPA repositorioPaisJPA, final String nomePais){
        return repositorioPaisJPA.findByNome(nomePais)
                .orElseThrow(()->{throw new EntityException("País não cadastrado!");});
    }

    public Pais cadastrar(RepositorioPaisJPA repositorioPaisJPA){
        verifyUniqueCountry(repositorioPaisJPA);
        return repositorioPaisJPA.save(this);
    }

    private void verifyUniqueCountry(RepositorioPaisJPA repositorioPaisJPA){
        repositorioPaisJPA.findByNome(nome)
                .ifPresent(e->{throw new EntityExistsException("País já cadastrado!");});
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
