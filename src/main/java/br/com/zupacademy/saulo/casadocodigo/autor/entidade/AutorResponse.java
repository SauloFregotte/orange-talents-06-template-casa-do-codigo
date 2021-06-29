package br.com.zupacademy.saulo.casadocodigo.autor.entidade;

public class AutorResponse {

    public AutorResponse(final Autor autor){
        nome = autor.getNome();
        email = autor.getEmail();
        descricao = autor.getDescricao();
    }

    private final String nome;

    private final String email;

    private final String descricao;

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
