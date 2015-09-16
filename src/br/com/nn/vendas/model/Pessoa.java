package br.com.nn.vendas.model;


public class Pessoa {
    
    private String nome;
    private String cpf;
    private Endereco end;

    public Pessoa(String nome, String cpf, Endereco end) {
        this.nome = nome;
        this.cpf = cpf;
        this.end = end;     
    }
    
    public Pessoa() {
           
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEnd() {
        return end;
    }

    public void setEnd(Endereco end) {
        this.end = end;
    }
    
    
}
