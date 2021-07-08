package br.com.zupacademy.saulo.casadocodigo.livro.entidade;

import br.com.zupacademy.saulo.casadocodigo.EntityException;
import br.com.zupacademy.saulo.casadocodigo.autor.entidade.Autor;
import br.com.zupacademy.saulo.casadocodigo.categoria.entidade.Categoria;
import br.com.zupacademy.saulo.casadocodigo.livro.RepositoryLivroJPA;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.security.InvalidParameterException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Entity
public class Livro {

    public static Builder builder(){
        return new Builder();
    }

    public Livro(Builder builder) {
        this.titulo = builder.titulo;
        this.resumo = builder.resumo;
        this.sumario = builder.sumario;
        this.preco = builder.preco;
        this.numero_paginas = builder.numero_paginas;
        this.data_de_publicacao = builder.data_de_publicacao;
        this.isbn = builder.isbn;
        this.categoria = builder.categoria;
        this.autor = builder.autor;
    }

    public Livro(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotEmpty
    @Size(max = 150)
    private String titulo;

    @NotBlank
    @NotEmpty
    @Size(max = 500, message = "Resumo não deve ultrapassar 500 caracteres!")
    private String resumo;

    @NotNull
    private String sumario;

    @NotNull
    @Min(value = 20, message = "Preço minimo de 20 U.M.!")
    private double preco;

    @NotNull
    @Min(value = 100, message = "Número minimo de paginas deve ser 100!")
    private int numero_paginas;

    @NotNull
    private String isbn;

    @NotNull
    @Future(message = "Não está no futuro!")
    private LocalDateTime data_de_publicacao;

    //RELACIONAMENTOS
    @NotNull
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    public Livro cadastrar(final RepositoryLivroJPA repositoryLivroJPA){
        verifyPublicationDate();
        verifyIfExistsDuplicatedTitle(repositoryLivroJPA);
        verifyIfExistsDuplicatedISBN(repositoryLivroJPA);
        return repositoryLivroJPA.save(this);
    }

    public List<Object> selectAllLivrosOnlyIdAndTitulo(final RepositoryLivroJPA repositoryLivroJPA){
        return repositoryLivroJPA.findAll()
                .stream()
                .map(livro-> new LivroResponseIdTitulo(livro.id, livro.titulo))
                .collect(Collectors.toList());
    }

    public Livro findLivroById(final RepositoryLivroJPA repositoryLivroJPA, final Long id) {
        return repositoryLivroJPA.findById(id)
                .orElseThrow(() -> {throw new InvalidParameterException("Esse livro não existe ou não está cadastrado!");});
    }

    private void verifyIfExistsDuplicatedTitle(final RepositoryLivroJPA repositoryLivroJPA) {
        repositoryLivroJPA.findFirstLivroByTitulo(titulo)
                .ifPresent(e->{throw new EntityExistsException("Titulo already exists!");});
    }

    private void verifyIfExistsDuplicatedISBN(final RepositoryLivroJPA repositoryLivroJPA) {
        repositoryLivroJPA.findFirstLivroByIsbn(isbn)
                .ifPresent(e->{throw new EntityExistsException("Livro already exists!");});
    }

    private void verifyPublicationDate(){
        if(this.data_de_publicacao.compareTo(LocalDateTime.now())<=0)
            throw new IllegalArgumentException();
    }

    public static class Builder{

        private transient String titulo;
        private transient String resumo;
        private transient String sumario;
        private transient double preco;
        private transient int numero_paginas;
        private transient String isbn;
        private transient LocalDateTime data_de_publicacao;
        private transient Categoria categoria;
        private transient Autor autor;

        public Builder comTitulo(final String titulo) {
            this.titulo = titulo;
            return this;
        }

        public Builder comResumo(final String resumo) {
            this.resumo = resumo;
            return this;
        }

        public Builder comSumario(final String sumario) {
            this.sumario = sumario;
            return this;
        }

        public Builder comPreco(final double preco) {
            this.preco = preco;
            return this;
        }

        public Builder comNumero_paginas(final int numero_paginas) {
            this.numero_paginas = numero_paginas;
            return this;
        }

        public Builder comIsbn(final String isbn) {
            this.isbn = isbn;
            return this;
        }

        public Builder comData_de_publicacao(final LocalDateTime data_de_publicacao) {
            this.data_de_publicacao = data_de_publicacao;
            return this;
        }

        public Builder comCategoria(final Categoria categoria) {
            this.categoria = categoria;
            return this;
        }

        public Builder comAutor(final Autor autor) {
            this.autor = autor;
            return this;
        }

        public Livro build(){
            return new Livro (this);
        }
    }

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

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }
}