/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nn.vendas.util;

import java.util.ResourceBundle;

/**
 *
 * @author José
 */
public class PropertiesUtil {
    
    private static final String FILE_NAME = "br.com.nn.vendas.util.conf";
    
    public static final String KEY_JDBC_URL = "jdbc_url";
    public static final String KEY_JDBC_LOGIN = "jdbc_login";
    public static final String KEY_JDBC_SENHA = "jdbc_senha";
    
    public static final String MSG_ERRO_CADASTRAR = "msg_erro_cadastrar";
    public static final String MSG_ERRO_BUSCAR = "msg_erro_buscar";
    public static final String MSG_ERRO_EDITAR = "msg_erro_editar";
    public static final String MSG_ERRO_DELETAR = "msg_erro_deletar";
    public static final String MSG_ERRO_LISTAR = "msg_erro_listar";

    
    private static final ResourceBundle bundle = ResourceBundle.getBundle(FILE_NAME);
    
    public static String getStringValue(String key){
        return bundle.getString(key);
    }
}