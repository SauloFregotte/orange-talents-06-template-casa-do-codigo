package br.com.zupacademy.saulo.casadocodigo.categoria.entidade;

public class CategoriaResponse {

    public CategoriaResponse(final Categoria categoria){
        nome = categoria.getNome();
    }

    private String nome;

    public String getNome() {
        return nome;
    }
}
