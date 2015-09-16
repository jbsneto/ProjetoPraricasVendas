package br.com.nn.vendas.model;

import br.com.nn.vendas.dao.ProdutoDaoJDBC;
import br.com.nn.vendas.util.Util;


public class Produto {
    
    private long id;
    private String nome;
    private String marca;
    private long ncm;
    private String unidade;
    private String codBarras;
    private long estoque;
    private double precoVenda;
    private double precoUnitario;

    public Produto(String nome, String marca, long ncm, String unidade, String codBarras, long estoque, double precoVenda, double precoUnitario) {
        this.nome = nome;
        this.marca = marca;
        this.ncm = ncm;
        this.unidade = unidade;
        this.codBarras = codBarras;
        this.estoque = estoque;
        this.precoVenda = precoVenda;
        this.precoUnitario = precoUnitario;
    }
    
    public Produto() {
     
    }
    
  
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public long getNcm() {
        return ncm;
    }

    public void setNcm(long ncm) {
        this.ncm = ncm;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }

    public long getEstoque() {
        return estoque;
    }

    public void setEstoque(long estoque) {
        this.estoque = estoque;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double preco) {
        this.precoVenda = preco;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitarioi(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }
    
    
    
}
