package demo.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import demo.Conexao.Conexao;
import demo.entidade.caderneta;
import demo.entidade.dependentes;

public class DAOcaderneta {
       public void CadastraVacina(caderneta caderneta){
        String sql = "insert into caderneta (NomeVacina, dataAplic, dose, local, cidade) values (?, ?, ?, ?, ?)";

        PreparedStatement ps = null;

        try {

            if (ps == null){
            ps = Conexao.openDatabase().prepareStatement(sql);
            ps.setString(1, caderneta.getNome());
            ps.setString(2, caderneta.getDataAplic());
            ps.setString(3, caderneta.getDose());
            ps.setString(4, caderneta.getLocal());
            ps.setString(5, caderneta.getCidade());
            

            ps.execute();
            ps.close();
            }
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
    }
    public void AtualizaVacinas(caderneta caderneta){
        String sql = "update caderneta SET NomeVacina=?, dataAplic=?, dose=?, local=?, cidade = ?  WHERE id = ?";

        PreparedStatement ps=null;

        try{
            if (ps == null){
                ps = Conexao.openDatabase().prepareStatement(sql);
            ps.setString(1, caderneta.getNome());
            ps.setString(2, caderneta.getDataAplic());
            ps.setString(3, caderneta.getDose());
            ps.setString(4, caderneta.getLocal());
            ps.setString(5, caderneta.getCidade());
            
            ps.execute();
            ps.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    
    public void DeletaVacinas(dependentes dependentes){
        String sql = "Delete from dependentes Where id =?";

        PreparedStatement  ps = null;

        try{
            if (ps == null){
                ps = Conexao.openDatabase().prepareStatement(sql);
                ps.setInt(1, dependentes.getId());
                ps.execute();
                ps.close();
            }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }

         public static List<caderneta> ConsultaVacinas() throws Exception{
        List <caderneta> list = new ArrayList<caderneta>();
        
        String sql = "select * from caderneta";

       PreparedStatement ps = null;
       ResultSet scann = null;
        try{
            if(ps == null){
                ps = Conexao.openDatabase().prepareStatement(sql);
                scann = ps.executeQuery();
                while (scann.next()) {
                    caderneta caderneta = new caderneta(0, sql, sql, sql);
                    caderneta.setNome(scann.getString("NomeVacina"));
                    caderneta.setDataAplic(scann.getString("dataAplic"));
                    caderneta.setDose(scann.getString("dose"));
                    caderneta.setLocal(scann.getString("local"));
                    caderneta.setCidade(scann.getString("cidade"));
                    list.add(caderneta);
                   
                }

            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            ps.close();
        }
        return list;
    }


    public void CadastraVacinasFrame(String nomeVacina, String dataAplic, String dose, String local, String cidade) {
        String sql = "insert into caderneta (NomeVacina, dataAplic, dose, local, cidade) values (?, ?, ?, ?, ?)";

   PreparedStatement ps = null;

   try {

       if (ps == null){
       ps = Conexao.openDatabase().prepareStatement(sql);
       ps.setString(1, nomeVacina);
       ps.setString(2, dataAplic);
       ps.setString(3, dose);
       ps.setString(4, local);
       ps.setString(5, cidade);
       

       ps.execute();
       ps.close();
       }
   } catch (SQLException e) {
      
       e.printStackTrace();
   }

   }
   public boolean AtualizaVacinasFrame(String nome, String dataAplic, String dose, String local, String cidade){
        String sql = "update caderneta SET NomeVacina=?, dataAplic=?, dose=?, local=?, cidade = ?  WHERE NomeVacina = ?";

        PreparedStatement ps=null;

        try{
            if (ps == null){
            ps = Conexao.openDatabase().prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, dataAplic);
            ps.setString(3, dose);
            ps.setString(4, local);
            ps.setString(5, cidade);
            
            ps.execute();
            ps.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return ps != null;
    }
}
