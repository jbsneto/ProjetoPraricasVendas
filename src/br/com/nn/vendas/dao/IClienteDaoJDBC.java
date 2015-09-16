package br.com.nn.vendas.dao;

import br.com.nn.vendas.model.Cliente;
import br.com.nn.vendas.model.Endereco;
import br.com.nn.vendas.model.Produto;
import java.util.List;


public interface IClienteDaoJDBC {
 
    public void cadastrarCliente(Cliente c)throws Exception;
    
    public Cliente buscarCliente(long id)throws Exception;
    
    public void deletarCliente(Cliente c)throws Exception; 

    public void alterarCliente(Cliente c)throws Exception;
           
    public List<Cliente> listarCliente()throws Exception;
}
