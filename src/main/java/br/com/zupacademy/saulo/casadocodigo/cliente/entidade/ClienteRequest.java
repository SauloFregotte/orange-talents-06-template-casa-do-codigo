package br.com.zupacademy.saulo.casadocodigo.cliente.entidade;

import br.com.zupacademy.saulo.casadocodigo.cliente.RepositoryClienteJPA;
import br.com.zupacademy.saulo.casadocodigo.estado.RepositorioEstadoJPA;
import br.com.zupacademy.saulo.casadocodigo.estado.entidade.Estado;
import br.com.zupacademy.saulo.casadocodigo.pais.RepositorioPaisJPA;
import br.com.zupacademy.saulo.casadocodigo.pais.entidade.Pais;

public class ClienteRequest {

    private String nome;
    private String sobrenome;
    private String email;
    private String cidade;
    private String endereco;
    private String cpf;
    private String telefone;
    private String complemento;
    private String cep;
    private String pais;
    private String estado;

    public ClienteResponse cadastrar(final RepositoryClienteJPA repositoryClienteJPA, final RepositorioPaisJPA repositorioPaisJPA, final RepositorioEstadoJPA repositorioEstadoJPA){
        if(!Cliente.validarFormatoEmail(email)) throw new IllegalArgumentException();
        Pais paisExistente = obtainCountry(repositorioPaisJPA);
        return new ClienteResponse(
                Cliente.builder()
                        .comNome(nome)
                        .comSobrenome(sobrenome)
                        .comEmail(email)
                        .comCpf_cnpj(cpf)
                        .comEndereco(endereco)
                        .comComplemento(complemento)
                        .comCidade(cidade)
                        .comTelefone(telefone)
                        .comCep(cep)
                        .comPais(paisExistente)
                        .comEstado(obtainState(repositorioEstadoJPA, paisExistente))
                        .build()
                        .cadastrar(repositoryClienteJPA)
        );
    }

    private Pais obtainCountry(final RepositorioPaisJPA repositorioPaisJPA){
        return Pais.verifyIfPaisExists(repositorioPaisJPA, pais);
    }

    private Estado obtainState(final RepositorioEstadoJPA repositorioEstadoJPA, final Pais paisExistente){
        return Estado.verifyIfEstadoExistsInThatCountry(repositorioEstadoJPA, estado, paisExistente);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
