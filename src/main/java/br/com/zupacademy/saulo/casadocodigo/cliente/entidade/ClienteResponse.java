package br.com.zupacademy.saulo.casadocodigo.cliente.entidade;

import br.com.zupacademy.saulo.casadocodigo.estado.entidade.Estado;
import br.com.zupacademy.saulo.casadocodigo.pais.entidade.Pais;

public class ClienteResponse {

    public ClienteResponse(Cliente cliente) {
        this.nome = cliente.getNome();
        this.sobrenome = cliente.getSobrenome();
        this.email = cliente.getEmail();
        this.endereco = cliente.getEndereco();
        this.cpf = cliente.getCpf();
        this.complemento = cliente.getComplemento();
        this.cidade = cliente.getCidade();
        this.telefone = cliente.getTelefone();
        this.cep = cliente.getCep();
        this.pais = cliente.getPais();
        this.estado = cliente.getEstado();
    }

    private  String nome;
    private  String sobrenome;
    private  String email;
    private  String cpf;
    private  String endereco;
    private  String complemento;
    private  String cidade;
    private  String telefone;
    private  String cep;
    private  Pais pais;
    private  Estado estado;

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public Pais getPais() {
        return pais;
    }

    public Estado getEstado() {
        return estado;
    }
}
