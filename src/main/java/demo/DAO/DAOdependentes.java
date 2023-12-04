package demo.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import demo.Conexao.Conexao;
import demo.entidade.dependentes;

public class DAOdependentes {
    
    public void CadastraDependentes(dependentes dependentes){
        String sql = "insert into dependentes (nome, cpf, idade) values (?, ?, ?)";

        PreparedStatement ps = null;

        try {

            if (ps == null){
            ps = Conexao.openDatabase().prepareStatement(sql);
            ps.setString(1, dependentes.getNome());
            ps.setString(2, dependentes.getCpf());
            ps.setString(3, dependentes.getIdade());
            

            ps.execute();
            ps.close();
            }
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
    }
    public void AtualizaDependentes(dependentes dependentes){
        String sql = "update dependentes SET nome=?, cpf=?, idade=?  WHERE id = ?";

        PreparedStatement ps=null;

        try{
            if (ps == null){
                ps = Conexao.openDatabase().prepareStatement(sql);
                ps.setString(1, dependentes.getNome());
                ps.setString(2, dependentes.getCpf());
                ps.setString(3, dependentes.getCpf());
                ps.setInt(2, dependentes.getId());
                ps.execute();
                ps.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    
    public void DeletaDependentes(dependentes dependentes){
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

         public static List<dependentes> consultaDependentes() throws Exception{
        List <dependentes> list = new ArrayList<dependentes>();
        
        String sql = "select * from dependentes";

       PreparedStatement ps = null;
       ResultSet scann = null;
        try{
            if(ps == null){
                ps = Conexao.openDatabase().prepareStatement(sql);
                scann = ps.executeQuery();
                while (scann.next()) {
                    dependentes dependentes = new dependentes(0, sql, sql, sql);
                    dependentes.setId(scann.getInt("id_dependente"));
                    dependentes.setNome(scann.getString("nome"));
                    dependentes.setCpf(scann.getString("cpf"));
                    dependentes.setIdade(scann.getString("idade"));
                    list.add(dependentes);
                   
                }

            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            ps.close();
        }
        return list;
    }
        public void CadastraDependentess(String nomes, String cpfs, String idades) {
             String sql = "insert into dependentes (nome, cpf, idade) values (?, ?, ?)";

        PreparedStatement ps = null;

        try {

            if (ps == null){
            ps = Conexao.openDatabase().prepareStatement(sql);
            ps.setString(1, nomes);
            ps.setString(2, cpfs);
            ps.setString(3, idades);
            

            ps.execute();
            ps.close();
            }
        } catch (SQLException e) {
           
            e.printStackTrace();
        }

        }
   
}
