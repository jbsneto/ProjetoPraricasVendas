package br.com.nn.vendas.facade;

import br.com.nn.vendas.dao.IClienteDaoJDBC;
import br.com.nn.vendas.dao.IProdutoDaoJDBC;
import br.com.nn.vendas.model.Cliente;
import br.com.nn.vendas.model.Produto;
import br.com.nn.vendas.util.DAOFactory;
import java.util.List;


public class Facade implements IFacade{
    
    private IClienteDaoJDBC daoCliente;
    private IProdutoDaoJDBC daoProduto;
    
    public Facade(){
        daoCliente = DAOFactory.createClienteDao();
        daoProduto = DAOFactory.createProdutoDao();
    }

    @Override
    public void ClienteCadastrar(Cliente c) throws Exception {
        daoCliente.cadastrarCliente(c);
    }

    @Override
    public Cliente ClienteBuscar(long id) throws Exception {
        return daoCliente.buscarCliente(id);
    }

    @Override
    public void ClienteEditar(Cliente c) throws Exception {
        daoCliente.alterarCliente(c);
    }

    @Override
    public void ClienteDeletar(Cliente c) throws Exception {
        daoCliente.deletarCliente(c);
    }
    
    @Override
    public void ProdutoCadastrar(Produto p) throws Exception {
        daoProduto.cadastrarProduto(p);
    }

    @Override
    public Produto ProdutoBuscar(long id) throws Exception {
        return daoProduto.buscarProduto(id);
    }

    @Override
    public void ProdutoEditar(Produto p) throws Exception {
        daoProduto.alterarProduto(p);
    }

    @Override
    public void ProdutoDeletar(Produto p) throws Exception {
        daoProduto.deletarProduto(p);
    }

    @Override
    public List<Cliente> ClienteLista() throws Exception {
        return daoCliente.listarCliente();
    }

    @Override
    public List<Produto> ProdutoListar() throws Exception {
        return daoProduto.listarProduto();
    }  
    
}
