package br.com.zupacademy.saulo.casadocodigo.categoria.entidade;

public class CategoriaResponseErro {

    private String mensagem;
    private int status;

    public CategoriaResponseErro(String mensagem, int status) {
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
