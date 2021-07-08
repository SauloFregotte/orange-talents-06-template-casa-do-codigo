package br.com.zupacademy.saulo.casadocodigo.pais.entidade;

public class PaisResponse {
    public PaisResponse(Pais pais) {
        this.nome = pais.getNome();
    }

    private String nome;

    public String getNome() {
        return nome;
    }
}
