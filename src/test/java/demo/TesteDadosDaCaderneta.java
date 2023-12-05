package demo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import demo.Conexao.Conexao;
import demo.entidade.caderneta;

public class TesteDadosDaCaderneta {
    

    @Test
    public void TesteDadosDaCaderneta() throws Exception{
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
       
    }
}

