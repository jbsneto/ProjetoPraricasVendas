/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nn.vendas.facade;

import br.com.nn.vendas.model.Cliente;
import br.com.nn.vendas.model.Endereco;
import br.com.nn.vendas.model.Produto;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author José
 */
public class FacadeClienteTest {
    
    private static Facade instance;
    private static Cliente clienteTest;
    private static long idTest;
    
    public FacadeClienteTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        instance = new Facade();
        Endereco end = new Endereco("cidade", "bairro", "rua", 123,"cep");
        clienteTest = new Cliente("ClienteTest", "000.000.000-00", end);
        
        idTest = 1;
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
    /**
     * Test of ClienteCadastrar method, of class Facade.
     */
    @Test
    public void testClienteCadastrar() throws Exception {
        System.out.println("ClienteCadastrar");
        instance.ClienteCadastrar(clienteTest);
        assertNotNull(instance.ClienteBuscar(clienteTest.getId()));
        //System.out.println(clienteTest.getId());
    }

    /**
     * Test of ClienteBuscar method, of class Facade.
     */
    @Test
    public void testClienteBuscar() throws Exception {
        System.out.println("ClienteBuscar");   
        assertNotNull(instance.ClienteBuscar(  idTest   ));
    }

    /**
     * Test of ClienteEditar method, of class Facade.
     */
    @Test
    public void testClienteEditar() throws Exception {
        System.out.println("ClienteEditar");
  
        Cliente cli = instance.ClienteBuscar(  idTest  );
        
        cli.setNome("TestJUnit2");
        cli.getEnd().setCidade("CidadeEditada2");
        
        instance.ClienteEditar(cli);
        
        assertEquals(cli.getNome(), instance.ClienteBuscar(  idTest ).getNome());
        assertEquals(cli.getEnd().getCidade(), instance.ClienteBuscar(  idTest  ).getEnd().getCidade());
    }
    
    /**
     * Test of ClienteLista method, of class Facade.
     */
    @Test
    public void testClienteLista() throws Exception {
        System.out.println("ClienteLista");
        assertNotNull(instance.ClienteLista());
    }


    /**
     * Test of ClienteDeletar method, of class Facade.
     */
    @Test
    public void testClienteDeletar() throws Exception {
        System.out.println("ClienteDeletar");
        Cliente c = clienteTest;
        instance.ClienteCadastrar(c);
        instance.ClienteDeletar(c);
        assertNull(instance.ClienteBuscar(c.getId()));
    }


    
}
