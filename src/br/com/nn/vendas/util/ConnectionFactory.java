package br.com.nn.vendas.util;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionFactory {

    
    public static Connection getConnection() {
        try {

            return DriverManager.getConnection(
                    PropertiesUtil.getStringValue(PropertiesUtil.KEY_JDBC_URL), 
                    PropertiesUtil.getStringValue(PropertiesUtil.KEY_JDBC_LOGIN), 
                    PropertiesUtil.getStringValue(PropertiesUtil.KEY_JDBC_SENHA));

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
