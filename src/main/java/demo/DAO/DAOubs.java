package demo.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import demo.Conexao.Conexao;
import demo.entidade.ubs;

public class DAOubs {
    /**
     * @return
     */
    public static List<ubs> getUbs(){
        List <ubs> dados = new ArrayList<ubs>();
        String sql = "select * from ubs";

       PreparedStatement ps = null;
       ResultSet scann = null;
  
       try{
        if(ps == null){
            ps = Conexao.openDatabase().prepareStatement(sql);
            scann = ps.executeQuery();
            while (scann.next()) {
                ubs ubs = new ubs(0, sql, sql);
                ubs.setId(scann.getInt("id"));
                ubs.setEndereco(scann.getString("endereco"));
                ubs.setCep(scann.getString("cep"));

                dados.add(ubs);
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
       return dados;
    }
}
