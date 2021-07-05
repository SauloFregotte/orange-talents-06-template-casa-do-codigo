package br.com.zupacademy.saulo.casadocodigo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Advice {

    //Tratar dados invalido inseridos (validacao email)
    @ExceptionHandler({IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RespostaErro invalidData(IllegalArgumentException e){
        return new RespostaErro("Os dados informados são invalidos!", HttpStatus.BAD_REQUEST.value());
    }

    //Tratar a validacao dos dados do autor
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RespostaErro invalidEntityData(MethodArgumentNotValidException e){
        return new RespostaErro(e.getMessage(), HttpStatus.BAD_REQUEST.value());
    }

    //Tratar validação de campo invalido na entidade:
    // {Autor(email duplicado), Categoria(nome duplicado)}
    @ExceptionHandler({EntityException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RespostaErro invalidEntityField(EntityException e){
        return new RespostaErro(e.getMessage(), HttpStatus.BAD_REQUEST.value());
    }
}
