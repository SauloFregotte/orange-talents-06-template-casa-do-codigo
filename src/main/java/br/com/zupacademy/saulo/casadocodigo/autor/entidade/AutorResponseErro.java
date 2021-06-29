package br.com.zupacademy.saulo.casadocodigo.autor.entidade;

public class AutorResponseErro {

    private String mensagem;
    private int status;

    public AutorResponseErro(String mensagem, int status) {
        this.mensagem = mensagem;
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public int getStatus() {
        return status;
    }
}
