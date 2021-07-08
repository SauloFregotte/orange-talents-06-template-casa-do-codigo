package br.com.zupacademy.saulo.casadocodigo.livro.entidade;

import java.time.LocalDateTime;

public class LivroResponse {

    public LivroResponse(final Livro livro) {
        id = livro.getId();
        titulo = livro.getTitulo();
        resumo = livro.getResumo();
        sumario = livro.getSumario();
        preco = livro.getPreco();
        numero_paginas = livro.getNumero_paginas();
        isbn = livro.getIsbn();
        data_de_publicacao = livro.getData_de_publicacao();
        categoria = livro.getCategoria().getNome();
        autor = livro.getAutor().getNome();
    }

    private Long id;
    private String titulo;
    private String resumo;
    private String sumario;
    private double preco;
    private int numero_paginas;
    private String isbn;
    private LocalDateTime data_de_publicacao;

    private String categoria;
    private String autor;

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public double getPreco() {
        return preco;
    }

    public int getNumero_paginas() {
        return numero_paginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDateTime getData_de_publicacao() {
        return data_de_publicacao;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getAutor() {
        return autor;
    }
}
