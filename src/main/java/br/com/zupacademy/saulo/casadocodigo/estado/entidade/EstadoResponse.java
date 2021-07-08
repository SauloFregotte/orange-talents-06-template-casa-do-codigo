package br.com.zupacademy.saulo.casadocodigo.estado.entidade;

import br.com.zupacademy.saulo.casadocodigo.pais.entidade.Pais;

public class EstadoResponse {

    public EstadoResponse(Estado estado) {
        this.nome = estado.getNome();
        this.pais = estado.getPais();
    }

    private String nome;
    private Pais pais;

    public String getNome() {
        return nome;
    }

    public Pais getPais() {
        return pais;
    }
}
