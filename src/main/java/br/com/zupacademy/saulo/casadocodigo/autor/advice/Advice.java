//package br.com.zupacademy.saulo.casadocodigo.autor.advice;
//
//import br.com.zupacademy.saulo.casadocodigo.autor.entidade.AutorResponseErro;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//@RestControllerAdvice
//public class Advice {
//
//    //Tratar dados invalido inseridos (validacao email)
//    @ExceptionHandler({IllegalArgumentException.class})
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public AutorResponseErro dadosInvalidos(IllegalArgumentException e){
//        return new AutorResponseErro("Os dados informados são invalidos!", HttpStatus.BAD_REQUEST.value());
//    }
//
//    //Tratar a validacao dos dados do autor
//    @ExceptionHandler({MethodArgumentNotValidException.class})
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public AutorResponseErro dadosDoAutorInvalidos(MethodArgumentNotValidException e){
//        return new AutorResponseErro(e.getMessage(), HttpStatus.BAD_REQUEST.value());
//    }
//
//    //Tratar validação duplicata email
//    @ExceptionHandler({AutorException.class})
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public AutorResponseErro emailDuplicado(AutorException e){
//        return new AutorResponseErro(e.getMessage(), HttpStatus.BAD_REQUEST.value());
//    }
//}
