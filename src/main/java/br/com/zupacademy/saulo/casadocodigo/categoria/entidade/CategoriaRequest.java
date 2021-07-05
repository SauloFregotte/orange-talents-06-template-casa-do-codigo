package br.com.zupacademy.saulo.casadocodigo.categoria.entidade;

import br.com.zupacademy.saulo.casadocodigo.categoria.RepositoryCategoriaJPA;

public class CategoriaRequest {

    private String nome;

    public CategoriaResponse cadastrar(final RepositoryCategoriaJPA repositoryCategoriaJPA) {
        return new CategoriaResponse(
                new Categoria(nome).cadastrar(repositoryCategoriaJPA)
        );
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
