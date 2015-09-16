package br.com.nn.vendas.dao;

import br.com.nn.vendas.model.Cliente;
import br.com.nn.vendas.model.Produto;
import br.com.nn.vendas.util.ConnectionFactory;
import br.com.nn.vendas.util.PropertiesUtil;
import br.com.nn.vendas.util.Util;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ProdutoDaoJDBC implements IProdutoDaoJDBC {
    
    private java.sql.Connection con;
    private ConnectionFactory connection;
    
    
    @Override
    public void cadastrarProduto(Produto p) throws Exception {
       
            PreparedStatement st;
            String sql;
        try{
            // obtem conexão
            con = connection.getConnection(); 
            // define comando sql
            sql = "insert into produto (nome, marca, ncm, unidade, codbarras, estoque, precovenda, precounitario) values (?,?,?,?,?,?,?,?);";
            // "prepara" comando a ser executado
            st = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            // preenche o statement

            // nome, marca, ncm, unidade, codBarras, estoque, precoVenda, precoUnitario
            st.setString(1, p.getNome());
            st.setString(2, p.getMarca());
            st.setLong(3, p.getNcm());
            st.setString(4, p.getUnidade());
            st.setString(5, p.getCodBarras());
            st.setLong(6, p.getEstoque());
            st.setDouble(7, p.getPrecoVenda());
            st.setDouble(8, p.getPrecoUnitario());

            // execute o comando
            st.executeUpdate();
            
            ResultSet rs = st.getGeneratedKeys();
            if(rs.next())
                p.setId(rs.getLong(1));
  
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(PropertiesUtil.getStringValue(PropertiesUtil.MSG_ERRO_CADASTRAR));
        }
    }

    @Override
    public Produto buscarProduto(long id) throws Exception {
        
        try{
            con = ConnectionFactory.getConnection();

            String sql = "select * from produto where id=?";

            PreparedStatement st = this.con.prepareStatement(sql);

            st.setLong(1,id);

            ResultSet rs = st.executeQuery();

            //String nome, String cpf, String end.cidade, String end.bairro, String end.rua, String end.numero, String end.cep
            if(rs.next()){
                
                Produto p = new Produto(rs.getString("nome"),rs.getString("marca"),rs.getLong("ncm"),rs.getString("unidade"),rs.getString("codbarras"),rs.getLong("estoque"),rs.getDouble("precovenda"),rs.getDouble("precounitario"));
                 p.setId(rs.getLong("id"));

                con.close();
                return p;
            }
            con.close();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(PropertiesUtil.getStringValue(PropertiesUtil.MSG_ERRO_BUSCAR));
        }
        
    }
    
    @Override
    public void alterarProduto(Produto p) throws Exception {
       
        try{
            // obtem conexão
           con = connection.getConnection();

           // define comando sql
           String sql = "update produto set nome=?, marca=?, ncm=?, unidade=?, codBarras=?, estoque=?, precoVenda=?, precoUnitario=? where id = ?";

           // "prepara" comando a ser executado
           PreparedStatement st = con.prepareStatement(sql);

           // preenche o statement
           st.setString(1, p.getNome());
           st.setString(2, p.getMarca());
           st.setLong(3, p.getNcm());
           st.setString(4, p.getUnidade());
           st.setString(5, p.getCodBarras());
           st.setLong(6, p.getEstoque());
           st.setDouble(7, p.getPrecoVenda());
           st.setDouble(8, p.getPrecoUnitario());
           st.setLong(9, p.getId());

           // execute o comando
           st.executeUpdate();

           con.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(PropertiesUtil.getStringValue(PropertiesUtil.MSG_ERRO_EDITAR));
        }
    }
    
    @Override
    public void deletarProduto(Produto p) throws Exception {
        
        try{
            // obtem conexão
           con = connection.getConnection();

           // define comando sql
           String sql = "delete from produto where id = ?";

           // "prepara" comando a ser executado
           PreparedStatement st = con.prepareStatement(sql);

           // preenche o statement
           st.setLong(1, p.getId());

           // execute o comando
           st.executeUpdate();

           con.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(PropertiesUtil.getStringValue(PropertiesUtil.MSG_ERRO_DELETAR));
        }
    }
    
    @Override
    public List<Produto> listarProduto() throws Exception {
        
        try{
            con = connection.getConnection();

            List<Produto> lista = new ArrayList<Produto>();

            String sql = "select * from produto";

            PreparedStatement st = this.con.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            while(rs.next()){
                //nome, marca, ncm, unidade, codBarras, estoque, precoVenda, precoUnitario
                Produto p = new Produto(rs.getString("nome"),rs.getString("marca"),rs.getLong("ncm"),rs.getString("unidade"),rs.getString("codBarras"),rs.getLong("estoque"),rs.getDouble("precoVenda"),rs.getDouble("precoUnitario"));
                p.setId(rs.getLong("id"));
                lista.add(p);

            }
            con.close();
            return lista;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(PropertiesUtil.getStringValue(PropertiesUtil.MSG_ERRO_LISTAR));
        }
    }

}
