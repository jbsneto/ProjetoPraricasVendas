package br.com.nn.vendas.facade;

import br.com.nn.vendas.model.Cliente;
import br.com.nn.vendas.model.Produto;
import java.util.List;


public interface IFacade {

    public void ClienteCadastrar(Cliente c) throws Exception;
    public Cliente ClienteBuscar(long id) throws Exception;
    public void ClienteEditar(Cliente c) throws Exception;
    public void ClienteDeletar(Cliente c) throws Exception;
    public List<Cliente> ClienteLista () throws Exception;
    
    public void ProdutoCadastrar(Produto p) throws Exception;
    public Produto ProdutoBuscar(long id) throws Exception;
    public void ProdutoEditar(Produto p) throws Exception;
    public void ProdutoDeletar(Produto p) throws Exception;
    public List<Produto> ProdutoListar () throws Exception;
}
