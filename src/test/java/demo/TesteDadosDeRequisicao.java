package demo;

import static org.junit.Assert.assertEquals;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import demo.Conexao.Conexao;
import demo.entidade.requsicao;

public class TesteDadosDeRequisicao {
    
    String pesquisa;

 
    @Test
    public void TesteRequisicao(){
        List <requsicao> dados = new ArrayList<requsicao>();
        String sql = "select * from requisicao where NomePais=?"; 
 
       PreparedStatement ps = null;
       ResultSet scann = null;
  
       try{

        if(ps == null){
            
            ps = Conexao.openDatabase().prepareStatement(sql);   
            ps.setString(1, pesquisa);   
            ps.executeQuery();
            scann = ps.executeQuery();
            while (scann.next()) {  
                requsicao requsicao = new requsicao(sql, sql);
               
                requsicao.setId(scann.getInt("id_pais"));
                requsicao.setnomePais(scann.getString("NomePais"));
                requsicao.setVacinas(scann.getString("vacinas"));
              
    assertEquals("Australia", pesquisa);
                dados.add(requsicao);
            }
        }
       }catch (SQLException e){
            e.printStackTrace();
       }finally{
        try{
            if (scann != null){
                scann.close();
            }
            if (ps != null){
                ps.close();
            }
            
        }catch(SQLException e){
        e.printStackTrace();
       }
       }
     
    }
}

