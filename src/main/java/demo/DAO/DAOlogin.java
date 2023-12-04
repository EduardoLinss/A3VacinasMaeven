package demo.DAO;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import demo.Conexao.Conexao;
import demo.entidade.login;

public class DAOlogin {
    

    public void CadastrarUsuario(login login){
        String sql = "insert into login (nome, senha, email, cpf, dataNasc) values (?, ?, ?, ?, ?)";

        PreparedStatement ps = null;

        try {

            if (ps == null){
            ps = Conexao.openDatabase().prepareStatement(sql);
            ps.setString(1, login.getNome());
            ps.setString(2, login.getSenha());
            ps.setString(3, login.getEmail());
            ps.setString(4, login.getCpf());
            ps.setString(5, login.getDataNasc());

            ps.execute();
            ps.close();
            }
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
    }
    public void AtualizarCadastro(login login){
        String sql = "update login SET nome=? WHERE id = ?";

        PreparedStatement ps=null;

        try{
            if (ps == null){
                ps = Conexao.openDatabase().prepareStatement(sql);
                ps.setString(1, login.getNome());
                ps.setInt(2, login.getId());
                ps.execute();
                ps.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    
    public void DeletarCadastro(login login){
        String sql = "Delete from login Where id =?";

        PreparedStatement  ps = null;

        try{
            if (ps == null){
                ps = Conexao.openDatabase().prepareStatement(sql);
                ps.setInt(1, login.getId());
                ps.execute();
                ps.close();
            }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }

   
     public static List<login> consultaLogin(){
        List <login> dados = new ArrayList<login>();
        String sql = "select * from login";

       PreparedStatement ps = null;
       ResultSet scann = null;
  
       try{
        if(ps == null){
            ps = Conexao.openDatabase().prepareStatement(sql);
            scann = ps.executeQuery();
            while (scann.next()) {
                login login = new login(0, sql, sql);
                login.setId(scann.getInt("id"));
                login.setNome(scann.getString("nome"));
                login.setSenha(scann.getString("senha"));
                login.setEmail(scann.getString("email"));
                login.setCpf(scann.getString("cpf"));
                login.setDataNasc(scann.getString("dataNasc"));

                dados.add(login);
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

    /**
     * @return
     * @throws Exception
     */
    public static List<login> consulta() throws Exception{
        List <login> list = new ArrayList<login>();
        
        String sql = "select * from login";

       PreparedStatement ps = null;
       ResultSet scann = null;
        try{
            if(ps == null){
                ps = Conexao.openDatabase().prepareStatement(sql);
                scann = ps.executeQuery();
                while (scann.next()) {
                    login login = new login(0, sql, sql);
                    login.setEmail(scann.getString("email"));
                    //login.setSenha(scann.getString("senha"));
                    list.add(login);
                   
                }

            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            ps.close();
        }
        return list;
    }
    public boolean CadastrarUsuarioFrame(String nomes, String senhas, String emails, String cpfs, String dataNascs) {
        String sql = "insert into login (nome, senha, email, cpf, dataNasc) values (?, ?, ?, ?, ?)";

        PreparedStatement ps = null;

        try {

            if (ps == null){
            ps = Conexao.openDatabase().prepareStatement(sql);
            ps.setString(1, nomes);
            ps.setString(2, senhas);
            ps.setString(3, emails);
            ps.setString(4, cpfs);
            ps.setString(5, dataNascs);

            ps.execute();
            ps.close();
            }
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        return ps != null;

    }
   

    
}





