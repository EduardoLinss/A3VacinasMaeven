package demo.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import demo.Conexao.Conexao;
import demo.entidade.requsicao;

public class DAOrequisicao {
    

    /**
     * @return
     */
    public static List<requsicao> getRequsicaos(){
        List <requsicao> dados = new ArrayList<requsicao>();
        String sql = "select * from requisicao";

       PreparedStatement ps = null;
       ResultSet scann = null;
  
       try{
        if(ps == null){
            ps = Conexao.openDatabase().prepareStatement(sql);
            scann = ps.executeQuery();
            while (scann.next()) {
                requsicao requsicao = new requsicao(0, sql, sql);
                requsicao.setId(scann.getInt("id_pais"));
                requsicao.setnomePais(scann.getString("NomePais"));
                requsicao.setVacinas(scann.getString("vacinas"));

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
       return dados;
    }

 public static List<requsicao> getPeloNome(){
        List <requsicao> dados = new ArrayList<requsicao>();
        String sql = "select * from requisicao where NomePais= ? ";

       PreparedStatement ps = null;
       ResultSet scann = null;
  
       try{
        if(ps == null){
            ps = Conexao.openDatabase().prepareStatement(sql);
            scann = ps.executeQuery();
            while (scann.next()) {
                requsicao requsicao = new requsicao(0, sql, sql);
                requsicao.setId(scann.getInt("id_pais"));
                requsicao.setnomePais(scann.getString("NomePais"));
                requsicao.setVacinas(scann.getString("vacinas"));

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
       return dados;
    }

    public static boolean pesquisar(String pesquisa) throws SQLException{
        String sql = "select * from requisicao where NomePais= ? ";
        PreparedStatement ps = null;
        ResultSet scan = null;
        try{
            ps = Conexao.openDatabase().prepareStatement(sql);
            ps.setString(1, pesquisa);
            //ps.setString(2, password);
            scan = ps.executeQuery();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return scan.next();
}

}
