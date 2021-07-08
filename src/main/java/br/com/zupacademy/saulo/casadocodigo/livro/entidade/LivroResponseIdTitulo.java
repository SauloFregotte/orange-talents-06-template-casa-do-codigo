package br.com.zupacademy.saulo.casadocodigo.livro.entidade;

public class LivroResponseIdTitulo {

    public LivroResponseIdTitulo(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    private Long id;
    private String titulo;

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}
