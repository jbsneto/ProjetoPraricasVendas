/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nn.vendas.facade;

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
public class FacadeProdutoTest {
    
    private static Facade instance;
    private static Produto produtoTest;
    private static long idTest;
    
    public FacadeProdutoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        instance = new Facade();
        produtoTest = new Produto("nome", "marca", 999999999, "UN", "425484561", 10, 1.50, 0.80);
        
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
     * Test of ProdutoBuscar method, of class Facade.
     */
    @Test
    public void testProdutoCadastrar() throws Exception {
        System.out.println("ProdutoCadastrar");
        instance.ProdutoCadastrar(produtoTest);
        assertNotNull(instance.ProdutoBuscar(produtoTest.getId()));
        //System.out.println(clienteTest.getId());
    }

    /**
     * Test of ClienteBuscar method, of class Facade.
     */
    @Test
    public void testProdutoBuscar() throws Exception {
        System.out.println("ProdutoBuscar");   
        assertNotNull(instance.ProdutoBuscar(  idTest   ));
    }

    /**
     * Test of ClienteEditar method, of class Facade.
     */
    @Test
    public void testProdutoEditar() throws Exception {
        System.out.println("ProdutoEditar");
  
        Produto p = instance.ProdutoBuscar(  idTest  );
        
        p.setNome("TestJUnit2");
        
        instance.ProdutoEditar(p);
        
        assertEquals(p.getNome(), instance.ProdutoBuscar(  idTest ).getNome());
    }
    
    /**
     * Test of ClienteLista method, of class Facade.
     */
    @Test
    public void testProdutoLista() throws Exception {
        System.out.println("ClienteLista");
        assertNotNull(instance.ProdutoListar());
    }


    /**
     * Test of ClienteDeletar method, of class Facade.
     */
    @Test
    public void testProdutoDeletar() throws Exception {
        System.out.println("ProdutoDeletar");
        Produto p = produtoTest;
        instance.ProdutoCadastrar(p);
        instance.ProdutoDeletar(p);
        assertNull(instance.ProdutoBuscar(p.getId()));
    }
    
}
