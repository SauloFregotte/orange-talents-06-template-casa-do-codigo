package br.com.zupacademy.saulo.casadocodigo.cliente.entidade;

import br.com.zupacademy.saulo.casadocodigo.EntityException;
import br.com.zupacademy.saulo.casadocodigo.cliente.RepositoryClienteJPA;
import br.com.zupacademy.saulo.casadocodigo.estado.entidade.Estado;
import br.com.zupacademy.saulo.casadocodigo.pais.entidade.Pais;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.regex.Pattern;

@Entity
public class Cliente {

    public static Builder builder(){
        return new Builder();
    }

    private static final String EMAIL_REGEX_ISO = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
    private static final Pattern pattern = Pattern.compile(EMAIL_REGEX_ISO);

    public static boolean validarFormatoEmail(final String email){
        if(email.trim().equals("")) return false;
        return pattern.matcher(email).find();
    }

    public Cliente(final Builder builder){
        this.nome = builder.nome;
        this.sobrenome = builder.sobrenome;
        this.email = builder.email;
        this.cpf = builder.cpf_cnpj;
        this.endereco = builder.endereco;
        this.complemento = builder.complemento;
        this.cidade = builder.cidade;
        this.telefone = builder.telefone;
        this.cep = builder.cep;
        this.pais = builder.pais;
        this.estado = builder.estado;
    }

    public Cliente(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotEmpty
    @Size(min = 3, max = 150)
    private String nome;

    @NotBlank
    @NotEmpty
    @Size(min = 3, max = 150)
    private String sobrenome;

    @NotBlank
    @NotEmpty
    @Email
    private String email;

    @NotNull
    @CPF
    private String cpf;

    @NotBlank
    @NotEmpty
    private String endereco;

    private String complemento;

    @NotBlank
    @NotEmpty
    private String cidade;

    @NotNull
    private String telefone;

    @NotNull
    @Size(min = 8)
    private String cep;

    @NotNull
    @OneToOne
    @JoinColumn(name = "pais_id", referencedColumnName = "id")
    private Pais pais;

    @NotNull
    @OneToOne
    @JoinColumn(name = "estado_id", referencedColumnName = "id")
    private Estado estado;

    public Cliente cadastrar(final RepositoryClienteJPA repositoryClienteJPA){
        verifyIfCpfIsUnique(repositoryClienteJPA);
        verifyIfEmailIsUnique(repositoryClienteJPA);
        return repositoryClienteJPA.save(this);
    }

    private void verifyIfCpfIsUnique(final RepositoryClienteJPA repositoryClienteJP){
        repositoryClienteJP.findFirstByCpf(cpf)
                .ifPresent(e->{throw new EntityExistsException("Cliente já registrado!");});
    }

    private void verifyIfEmailIsUnique(final RepositoryClienteJPA repositoryClienteJP){
        repositoryClienteJP.findFirstByEmail(email)
                .ifPresent(e->{throw new EntityExistsException("Email já registrado!");});
    }

    public static class Builder{

        private transient String nome;
        private transient String sobrenome;
        private transient String email;
        private transient String cpf_cnpj;
        private transient String endereco;
        private transient String complemento;
        private transient String cidade;
        private transient String telefone;
        private transient String cep;
        private transient Pais pais;
        private transient Estado estado;

        public Builder comNome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder comSobrenome(String sobrenome) {
            this.sobrenome = sobrenome;
            return this;
        }

        public Builder comEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder comCpf_cnpj(String cpf_cnpj) {
            this.cpf_cnpj = cpf_cnpj;
            return this;
        }

        public Builder comEndereco(String endereco) {
            this.endereco = endereco;
            return this;
        }

        public Builder comComplemento(String complemento) {
            this.complemento = complemento;
            return this;
        }

        public Builder comCidade(String cidade) {
            this.cidade = cidade;
            return this;
        }

        public Builder comTelefone(String telefone) {
            this.telefone = telefone;
            return this;
        }

        public Builder comCep(String cep) {
            this.cep = cep;
            return this;
        }

        public Builder comPais(Pais pais) {
            this.pais = pais;
            return this;
        }

        public Builder comEstado(Estado estado) {
            this.estado = estado;
            return this;
        }
        public Cliente build(){
            return new Cliente (this);
        }
    }

    public Long getId() {
        return id;
    }

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
