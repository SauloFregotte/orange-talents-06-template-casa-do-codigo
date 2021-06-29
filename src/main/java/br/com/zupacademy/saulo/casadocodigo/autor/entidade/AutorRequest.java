package br.com.zupacademy.saulo.casadocodigo.autor.entidade;

import br.com.zupacademy.saulo.casadocodigo.autor.repositorio.RepositoryAutorJPA;

public class AutorRequest {

    private String nome;

    private String email;

    private String descricao;

    public AutorResponse cadastrar(RepositoryAutorJPA repositoryAutorJPA) {
        if(!Autor.validarEmail(email)) throw new IllegalArgumentException();
        return new AutorResponse(
                new Autor(nome, email, descricao).cadastrar(repositoryAutorJPA)
        );
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "AutorRequest{" +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
