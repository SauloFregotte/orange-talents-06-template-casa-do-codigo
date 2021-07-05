package br.com.zupacademy.saulo.casadocodigo.autor;

import br.com.zupacademy.saulo.casadocodigo.autor.entidade.AutorRequest;
import br.com.zupacademy.saulo.casadocodigo.autor.entidade.AutorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class AutorController {

    private final RepositoryAutorJPA repositoryAutorJPA;

    public AutorController(RepositoryAutorJPA repositoryAutorJPA) {
        this.repositoryAutorJPA = repositoryAutorJPA;
    }

    @PostMapping(path = "/cadastrar-autor")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody AutorResponse cadastrarAutor(@RequestBody @Valid final AutorRequest autorRequest){
        return autorRequest.cadastrar(repositoryAutorJPA);
    }
}
