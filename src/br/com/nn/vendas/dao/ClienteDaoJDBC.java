package br.com.nn.vendas.dao;

import br.com.nn.vendas.model.Cliente;
import br.com.nn.vendas.model.Endereco;
import br.com.nn.vendas.model.Produto;
import br.com.nn.vendas.util.ConnectionFactory;
import br.com.nn.vendas.util.PropertiesUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDaoJDBC implements IClienteDaoJDBC {
    
    private java.sql.Connection con;
    private ConnectionFactory connection;
    
    
    @Override
    public void cadastrarCliente(Cliente c) throws Exception {
       
       try{
            PreparedStatement st;
            String sql;

            // obtem conexão
            con = ConnectionFactory.getConnection(); 

            // define comando sql
            sql = "insert into cliente (nome, cpf) values (?,?);";

            // "prepara" comando a ser executado (o segundo parametro indica que ao inserir, será possível obter o id gerado no banco)
            st = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            // preenche o statement

            // String nome, String cpf, String end.cidade, String end.bairro, String end.rua, String end.numero, String end.cep
            st.setString(1, c.getNome());
            st.setString(2, c.getCpf());

            // execute o comando
            st.executeUpdate();

            // recupera o id gerado no banco em um "resultSet", objeto que permite ler os resultados de uma consulta
            ResultSet rs = st.getGeneratedKeys();
                
             // se há um próximo (há algum retorno)
            if(rs.next()){
                // recupera o valor retornado (no nosso caso, o id gerado)
                
                long id = rs.getLong(1);

                 sql = "insert into endereco (cidade, bairro, rua, numeroCasa, cep, idcliente) values (?,?,?,?,?,?);";

                 st = con.prepareStatement(sql);

                 st.setString(1, c.getEnd().getCidade());
                 st.setString(2, c.getEnd().getBairro());
                 st.setString(3, c.getEnd().getRua());
                 st.setInt(4, c.getEnd().getNumeroCasa());
                 st.setString(5, c.getEnd().getCep());
                 st.setLong(6, id);

                st.executeUpdate();
                c.setId(rs.getLong(1));  //retornar o id do cara
            }else{
                System.out.println("deu águia");
            }
            
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(PropertiesUtil.getStringValue(PropertiesUtil.MSG_ERRO_CADASTRAR));
        }
    }

    
    @Override
    public Cliente buscarCliente(long id) throws Exception {
        try{
            Cliente c;

            con = ConnectionFactory.getConnection();

            String sql = "select * from cliente where id=?";

            PreparedStatement st = con.prepareStatement(sql);

            st.setLong(1,id);

            ResultSet rs = st.executeQuery();

            //fez cliente
            if(rs.next()){
                
                c = new Cliente(rs.getString("nome"), rs.getString("cpf"), buscarEnderecoCliente(rs.getLong("id")));
                c.setId(rs.getLong("id"));

                con.close();
                return c;
            }
            con.close();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(PropertiesUtil.getStringValue(PropertiesUtil.MSG_ERRO_BUSCAR));
        }
        
    }

    
    @Override
    public void alterarCliente(Cliente c) throws Exception {
        
        try{
            PreparedStatement st;
            String sql;

            // obtem conexão
            con = ConnectionFactory.getConnection();

            // define comando sql
            sql = "update cliente set nome=?, cpf=? where id=?";

            // "prepara" comando a ser executado
            st = con.prepareStatement(sql);

            // preenche o statement
            st.setString(1, c.getNome());
            st.setString(2, c.getCpf());
            st.setLong(3, c.getId());

            // execute o comando
            st.executeUpdate();

            sql = "update endereco set cidade=?, bairro=?, rua=?, numeroCasa=?, cep=? where idcliente=?";

            st = con.prepareStatement(sql);

            st.setString(1, c.getEnd().getCidade());
            st.setString(2, c.getEnd().getBairro());
            st.setString(3, c.getEnd().getRua());
            st.setInt(4, c.getEnd().getNumeroCasa());
            st.setString(5, c.getEnd().getCep());
            st.setLong(6, c.getId());

            st.executeUpdate();

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(PropertiesUtil.getStringValue(PropertiesUtil.MSG_ERRO_EDITAR));
        }
    }
    
        @Override
    public void deletarCliente(Cliente c) throws Exception {
        
        try{
            // obtem conexão
           con = ConnectionFactory.getConnection();

           // define comando sql
           String sql = "delete from cliente where id = ?";

           // "prepara" comando a ser executado
           PreparedStatement st = con.prepareStatement(sql);

           // preenche o statement
           st.setLong(1, c.getId());

           // execute o comando
           st.executeUpdate();
           con.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(PropertiesUtil.getStringValue(PropertiesUtil.MSG_ERRO_DELETAR));
        }
    }
    
    @Override
    public List<Cliente> listarCliente() throws Exception {
        
        try{
            con = ConnectionFactory.getConnection();

            List<Cliente> lista = new ArrayList<Cliente>();

            String sql = "select * from cliente";

            PreparedStatement st = this.con.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            while(rs.next()){
                Cliente c = new Cliente(rs.getString("nome"), rs.getString("cpf"), buscarEnderecoCliente(rs.getLong("id")));
                c.setId(rs.getLong("id"));
                lista.add(c);
            }
            con.close();
            return lista;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(PropertiesUtil.getStringValue(PropertiesUtil.MSG_ERRO_LISTAR));
        }
        
    }
    
    //BUSCA O ENDEREÇO DO CLIENTE NOS MÉTODOS BUSCARCLIENTE E LISTARCLIENTE
    private Endereco buscarEnderecoCliente(long id) throws Exception{
        
        con = ConnectionFactory.getConnection();
        
        String sql = "select * from endereco where idcliente=?";
        
        PreparedStatement st = con.prepareStatement(sql);
        
        st.setLong(1,id);
        
        ResultSet rs = st.executeQuery();
        
        if(rs.next()){
            //fez indereço
            Endereco end = new Endereco(rs.getString("cidade"), rs.getString("bairro"), rs.getString("rua"), rs.getInt("numerocasa"), rs.getString("cep"));
            end.setId(rs.getLong("id"));

            con.close();
            return end;
        }
        con.close();
        return null;
    }
  
}

