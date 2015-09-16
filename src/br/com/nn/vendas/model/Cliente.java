package br.com.nn.vendas.model;


public class Cliente extends Pessoa{
    
    private long id;

    public Cliente(String nome, String cpf, Endereco end) {
        super(nome, cpf, end);     
    }
    public Cliente() {
            super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + "nome=" + super.getNome() + "cidade=" + super.getEnd().getCidade() + "}";
    }

    
    
}
