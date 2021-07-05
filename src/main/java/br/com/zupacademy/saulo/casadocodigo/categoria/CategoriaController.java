package br.com.zupacademy.saulo.casadocodigo.categoria;

import br.com.zupacademy.saulo.casadocodigo.categoria.entidade.CategoriaRequest;
import br.com.zupacademy.saulo.casadocodigo.categoria.entidade.CategoriaResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CategoriaController {

    private final RepositoryCategoriaJPA repositoryCategoriaJPA;

    public CategoriaController(final RepositoryCategoriaJPA repositoryCategoriaJPA){
        this.repositoryCategoriaJPA = repositoryCategoriaJPA;
    }

    @PostMapping(path = "/cadastrar-categoria")
    @ResponseStatus(HttpStatus.OK)
    public CategoriaResponse cadastrarCategoria(@RequestBody @Valid final CategoriaRequest categoriaRequest){
        return categoriaRequest.cadastrar(repositoryCategoriaJPA);
    }
}
