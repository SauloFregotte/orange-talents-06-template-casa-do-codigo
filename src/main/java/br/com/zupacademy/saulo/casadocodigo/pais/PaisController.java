package br.com.zupacademy.saulo.casadocodigo.pais;

import br.com.zupacademy.saulo.casadocodigo.categoria.RepositoryCategoriaJPA;
import br.com.zupacademy.saulo.casadocodigo.categoria.entidade.CategoriaRequest;
import br.com.zupacademy.saulo.casadocodigo.categoria.entidade.CategoriaResponse;
import br.com.zupacademy.saulo.casadocodigo.pais.entidade.Pais;
import br.com.zupacademy.saulo.casadocodigo.pais.entidade.PaisRequest;
import br.com.zupacademy.saulo.casadocodigo.pais.entidade.PaisResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class PaisController {

    private final RepositorioPaisJPA repositorioPaisJPA;

    public PaisController(final RepositorioPaisJPA repositorioPaisJPA){
        this.repositorioPaisJPA = repositorioPaisJPA;
    }

    @PostMapping(path = "/cadastrar-pais")
    @ResponseStatus(HttpStatus.OK)
    public PaisResponse cadastrarCategoria(@RequestBody @Valid final PaisRequest paisRequest){
        return paisRequest.cadastrar(repositorioPaisJPA);
    }
}
