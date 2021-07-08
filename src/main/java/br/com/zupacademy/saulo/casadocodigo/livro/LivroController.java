package br.com.zupacademy.saulo.casadocodigo.livro;

import br.com.zupacademy.saulo.casadocodigo.autor.RepositoryAutorJPA;
import br.com.zupacademy.saulo.casadocodigo.autor.entidade.Autor;
import br.com.zupacademy.saulo.casadocodigo.categoria.RepositoryCategoriaJPA;
import br.com.zupacademy.saulo.casadocodigo.categoria.entidade.Categoria;
import br.com.zupacademy.saulo.casadocodigo.livro.entidade.Livro;
import br.com.zupacademy.saulo.casadocodigo.livro.entidade.LivroRequest;
import br.com.zupacademy.saulo.casadocodigo.livro.entidade.LivroResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class LivroController {

    private final RepositoryLivroJPA repositoryLivroJPA;

    private final RepositoryCategoriaJPA repositoryCategoriaJPA;

    private final RepositoryAutorJPA repositoryAutorJPA;

    public LivroController(final RepositoryLivroJPA repositoryLivroJPA, RepositoryCategoriaJPA repositoryCategoriaJPA, RepositoryAutorJPA repositoryAutorJPA){
        this.repositoryLivroJPA = repositoryLivroJPA;
        this.repositoryCategoriaJPA = repositoryCategoriaJPA;
        this.repositoryAutorJPA = repositoryAutorJPA;
    }

    @PostMapping(path = "/cria-livro")
    @ResponseStatus(HttpStatus.OK)
    public LivroResponse criarNovoLivro(@RequestBody @Valid final LivroRequest livroRequest){
        final Categoria categoria = livroRequest.verifyIfCategoriaExits(repositoryCategoriaJPA);
        final Autor autor = livroRequest.verifyIfAutorExists(repositoryAutorJPA);
        return livroRequest.cadastrar(repositoryLivroJPA, categoria, autor);
    }

    @GetMapping(path = "/mostrar-lista-livros")
    @ResponseStatus(HttpStatus.OK)
    public List<Object> mostrarListaLivros(){
        return new Livro().selectAllLivrosOnlyIdAndTitulo(repositoryLivroJPA);
    }

    @GetMapping(path = "/mostra-livro-detalhe/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LivroResponse mostraDetalhesLivro(@PathVariable Long id ){
        return new LivroResponse(new Livro().findLivroById(repositoryLivroJPA, id));
    }

}
