package br.com.nn.vendas.util;

import br.com.nn.vendas.dao.ClienteDaoJDBC;
import br.com.nn.vendas.dao.ProdutoDaoJDBC;
import br.com.nn.vendas.dao.IClienteDaoJDBC;
import br.com.nn.vendas.dao.IProdutoDaoJDBC;

/*
CRIA UMA FÁBRICA DE DOWN, ELE DA UM NEW EM UM DETERMINADO DAO.
*/
public class DAOFactory {
    
    public static IProdutoDaoJDBC createProdutoDao (){
        return new ProdutoDaoJDBC();
    }
    
    public static IClienteDaoJDBC createClienteDao (){
        return new ClienteDaoJDBC();
    }
}
