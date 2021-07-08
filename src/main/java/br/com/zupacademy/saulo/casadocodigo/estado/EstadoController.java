package br.com.zupacademy.saulo.casadocodigo.estado;

import br.com.zupacademy.saulo.casadocodigo.estado.entidade.EstadoRequest;
import br.com.zupacademy.saulo.casadocodigo.estado.entidade.EstadoResponse;
import br.com.zupacademy.saulo.casadocodigo.pais.RepositorioPaisJPA;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class EstadoController {

    private final RepositorioEstadoJPA repositorioEstadoJPA;
    private final RepositorioPaisJPA repositorioPaisJPA;

    public EstadoController(final RepositorioEstadoJPA repositorioEstadoJPA, RepositorioPaisJPA repositorioPaisJPA){
        this.repositorioEstadoJPA = repositorioEstadoJPA;
        this.repositorioPaisJPA = repositorioPaisJPA;
    }

    @PostMapping(path = "/cadastrar-estado")
    @ResponseStatus(HttpStatus.OK)
    public EstadoResponse cadastrarCategoria(@RequestBody @Valid final EstadoRequest estadoRequest){
        return estadoRequest.cadastrar(repositorioEstadoJPA, repositorioPaisJPA);
    }
}
