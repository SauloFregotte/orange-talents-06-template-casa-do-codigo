package br.com.zupacademy.saulo.casadocodigo.livro.entidade;

import br.com.zupacademy.saulo.casadocodigo.autor.RepositoryAutorJPA;
import br.com.zupacademy.saulo.casadocodigo.autor.entidade.Autor;
import br.com.zupacademy.saulo.casadocodigo.categoria.RepositoryCategoriaJPA;
import br.com.zupacademy.saulo.casadocodigo.categoria.entidade.Categoria;
import br.com.zupacademy.saulo.casadocodigo.livro.RepositoryLivroJPA;

import java.time.LocalDateTime;

public class LivroRequest {

    private String titulo;
    private String resumo;
    private String sumario;
    private double preco;
    private int numero_paginas;
    private String isbn;
    private LocalDateTime data_de_publicacao;

    private String categoria;
    private String autor;

    public LivroResponse cadastrar(RepositoryLivroJPA repositoryLivroJPA, Categoria categoria, Autor autor) {
        return new LivroResponse(
             Livro.builder()
                    .comTitulo(titulo)
                    .comResumo(resumo)
                    .comPreco(preco)
                    .comNumero_paginas(numero_paginas)
                    .comIsbn(isbn)
                    .comSumario(sumario)
                    .comData_de_publicacao(data_de_publicacao)
                    .comCategoria(categoria)
                    .comAutor(autor)
                    .build()
                    .cadastrar(repositoryLivroJPA)
        );
    }

    public Categoria verifyIfCategoriaExits(RepositoryCategoriaJPA repositoryCategoriaJPA) {
        return Categoria.verifyIfCategoriaExists(repositoryCategoriaJPA, categoria);
    }

    public Autor verifyIfAutorExists(RepositoryAutorJPA repositoryAutorJPA) {
        return Autor.verifyIfAutorExists(repositoryAutorJPA, autor);
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public void setSumario(String sumario) {
        this.sumario = sumario;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setNumero_paginas(int numero_paginas) {
        this.numero_paginas = numero_paginas;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setData_de_publicacao(LocalDateTime data_de_publicacao) {
        this.data_de_publicacao = data_de_publicacao;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
