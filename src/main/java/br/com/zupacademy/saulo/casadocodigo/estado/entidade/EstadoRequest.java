package br.com.zupacademy.saulo.casadocodigo.estado.entidade;

import br.com.zupacademy.saulo.casadocodigo.estado.RepositorioEstadoJPA;
import br.com.zupacademy.saulo.casadocodigo.pais.RepositorioPaisJPA;
import br.com.zupacademy.saulo.casadocodigo.pais.entidade.Pais;

public class EstadoRequest {

    private String nome;
    private String pais;

    public EstadoResponse cadastrar(final RepositorioEstadoJPA repositorioEstadoJPA, RepositorioPaisJPA repositorioPaisJPA){
        return new EstadoResponse(
                new Estado(nome, obtainCountry(repositorioPaisJPA)).cadastrar(repositorioEstadoJPA)
        );
    }

    public Pais obtainCountry(RepositorioPaisJPA repositorioPaisJPA) {
        return Pais.verifyIfPaisExists(repositorioPaisJPA, pais);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
