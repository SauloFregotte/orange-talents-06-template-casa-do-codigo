package br.com.zupacademy.saulo.casadocodigo.estado.entidade;

import br.com.zupacademy.saulo.casadocodigo.EntityException;
import br.com.zupacademy.saulo.casadocodigo.cliente.entidade.Cliente;
import br.com.zupacademy.saulo.casadocodigo.estado.RepositorioEstadoJPA;
import br.com.zupacademy.saulo.casadocodigo.pais.entidade.Pais;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Estado {

    public Estado(final String nome, final Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public Estado() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotEmpty
    @Size(min = 3, max = 150)
    private String nome;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "pais_id")
    private Pais pais;

    @OneToOne(mappedBy = "estado")
    private Cliente cliente;

    public static Estado verifyIfEstadoExistsInThatCountry(final RepositorioEstadoJPA repositorioEstadoJPA, final String nomeEstado, final Pais pais) {
        return repositorioEstadoJPA.findByNomeAndPais(nomeEstado,pais)
                .orElseThrow(()->{throw new EntityException("Estado não cadastrado nesse país!");});
    }

    public Estado cadastrar(final RepositorioEstadoJPA repositorioEstadoJPA){
        verifyIfStateIsUnique(repositorioEstadoJPA);
        return repositorioEstadoJPA.save(this);
    }

    public void verifyIfStateIsUnique(final RepositorioEstadoJPA repositorioEstadoJPA){
        repositorioEstadoJPA.findByNomeAndPais(nome, pais)
                .ifPresent(e->{throw new EntityExistsException("Este estado já pertence ao país!");});
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Pais getPais() {
        return pais;
    }
}
