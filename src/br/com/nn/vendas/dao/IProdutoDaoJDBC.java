package br.com.nn.vendas.dao;

import br.com.nn.vendas.model.Produto;
import java.util.List;


public interface IProdutoDaoJDBC {
    
    public void cadastrarProduto(Produto p)throws Exception;
    
    public Produto buscarProduto(long id)throws Exception;
    
    public void deletarProduto(Produto p)throws Exception;

    public void alterarProduto(Produto p)throws Exception;
           
    public List<Produto> listarProduto()throws Exception;

}
