package br.com.nn.vendas.model;


public class Endereco {
    
    private long id;
    private String cidade;
    private String bairro;
    private String rua;
    private int numeroCasa;
    private String cep; 
    
    public Endereco(String cidade, String bairro, String rua, int numeroCasa, String cep) {
        
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numeroCasa = numeroCasa;
        this.cep = cep;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    
    
    public Endereco() {
        
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(int numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
    
    
}
