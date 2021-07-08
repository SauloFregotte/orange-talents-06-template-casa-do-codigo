package br.com.zupacademy.saulo.casadocodigo.pais.entidade;

import br.com.zupacademy.saulo.casadocodigo.pais.RepositorioPaisJPA;

public class PaisRequest {

    private String nome;

    public PaisResponse cadastrar(final RepositorioPaisJPA repositorioPaisJPA){
        return new PaisResponse(
                new Pais(nome).cadastrar(repositorioPaisJPA)
        );
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
