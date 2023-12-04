package demo.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import demo.Conexao.Conexao;
import demo.entidade.alerta;

public class DAOalerta {
    
 public static alerta[] consultaAlertas;


public void AdicionarAlerta(alerta alerta){
        String sql = "insert into alerta (nomeVacina, dataProx) values (?, ?)";

        PreparedStatement ps = null;

        try {

            if (ps == null){
            ps = Conexao.openDatabase().prepareStatement(sql);
            ps.setString(1, alerta.getNomeVacina());
            ps.setString(2, alerta.getDataProx());
           
            ps.execute();
            ps.close();
            }
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
    }
    public void AtualizarAlerta(alerta alerta){
        String sql = "update alerta SET NomeVacina=? WHERE id_Alerta = ?";

        PreparedStatement ps = null;

        try{
            if (ps == null){
                ps = Conexao.openDatabase().prepareStatement(sql);
                ps.setString(1, alerta.getNomeVacina());
                ps.setInt(1, alerta.getId());
                ps.execute();
                ps.close();
            }
        
        } catch(SQLException e){
        e.printStackTrace();
        }
    }

    public void DeletarAlerta(alerta alerta){
        String sql = "Delete from alerta Where id =?";

        PreparedStatement  ps = null;

        try{
            if (ps == null){
                ps = Conexao.openDatabase().prepareStatement(sql);
                ps.setInt(1, alerta.getId());
                ps.execute();
                ps.close();
            }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    
    
        public static List<alerta> consultaAlertas(){
        List <alerta> dados = new ArrayList<alerta>();
        String sql = "select * from alerta";

       PreparedStatement ps = null;
       ResultSet scann = null;
  
       try{
        if(ps == null){
            ps = Conexao.openDatabase().prepareStatement(sql);
            scann = ps.executeQuery();
            while (scann.next()) {
                alerta alerta = new alerta(0, sql, sql);
                alerta.setId(scann.getInt("id_Alerta"));
                alerta.setNomeVacina(scann.getString("NomeVacina"));
                alerta.setdataProc(scann.getString("dataProx"));

                dados.add(alerta);
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

