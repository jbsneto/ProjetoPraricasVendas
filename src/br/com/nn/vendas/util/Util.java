package br.com.nn.vendas.util;

import br.com.nn.vendas.dao.ProdutoDaoJDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Util  {
    
    public static String getDataAtual() { 
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
		Calendar date = Calendar.getInstance();
		return dateFormat.format(date.getTime()); 
	
    }
    
    public static long geraCodProduto(ProdutoDaoJDBC dao) throws Exception  {
        int x = dao.listarProduto().size();
        if(x > 0){
            return dao.listarProduto().get(x-1).getId()+1;
        }
        return 1;
    }
    
    



}
