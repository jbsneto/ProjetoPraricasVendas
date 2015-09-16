package br.com.nn.vendas.test;

import br.com.nn.vendas.util.DAOFactory;
import br.com.nn.vendas.dao.ProdutoDaoJDBC;
import br.com.nn.vendas.dao.IClienteDaoJDBC;
import br.com.nn.vendas.facade.Facade;
import br.com.nn.vendas.facade.IFacade;
import br.com.nn.vendas.model.Cliente;
import br.com.nn.vendas.model.Endereco;
import br.com.nn.vendas.model.Produto;
import java.io.IOException;
import java.util.Scanner;


//String nome, String marca, long ncm, String unidade, String codBarras, long estoque, double precoVenda, double precoUnitario

public class Test {
    

    public static void main(String[] args)throws ClassNotFoundException, IOException, Exception {
                
       IFacade facade = new Facade();
       
      //            CLIENTE
      //
      //CADASTRAR CIENTE
      Endereco end = new Endereco("cidade", "bairro", "rua", 123,"cep");
      Cliente cliente = new Cliente("neto", "000.000.000-00", end);
      facade.ClienteCadastrar(cliente);
        System.out.println(cliente.getId());
       
      //BUSCAR CLIENTE
      System.out.println(facade.ClienteBuscar(10));
      

      //EDITAR CLIENTE
      //Endereco e = new Endereco("c", "b", "r", 1,"c");
      //Cliente c = new Cliente("n", "c", e);
      //c.setId(10);
      //facade.ClienteEditar(c);

       
      //DELETAR CIENTE
      //Cliente c = new Cliente();
      //c.setId(17);
      //facade.ClienteDeletar(c);
        
      //LISTAR CLIENTE
      //System.out.println(facade.ClienteLista());
       
    }
}

