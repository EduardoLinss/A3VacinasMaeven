package demo.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import demo.Conexao.Conexao;
import demo.entidade.vacinas;

public class DAOvacinas {
    /**
     * @return
     */
    public static List<vacinas> getVacinas(){
        List <vacinas> dados = new ArrayList<vacinas>();
        String sql = "select * from vacinas";

       PreparedStatement ps = null;
       ResultSet scann = null;
  
       try{
        if(ps == null){
            ps = Conexao.openDatabase().prepareStatement(sql);
            scann = ps.executeQuery();
            while (scann.next()) {
                vacinas vacinas = new vacinas(0, sql, sql);
                vacinas.setId_vacina(scann.getInt("id_Vacina"));
                vacinas.setNomeVacina(scann.getString("nomeVacina"));
                vacinas.setTratamento(scann.getString("tratamento"));

                dados.add(vacinas);
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
