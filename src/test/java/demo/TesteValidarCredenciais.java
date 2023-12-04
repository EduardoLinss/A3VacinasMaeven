package demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import demo.Conexao.Conexao;


import java.sql.*;

public class TesteValidarCredenciais {
   

   
    //private Conexao conect;
 

    /*@Before
    public static void setUp() {
        
        
        Conexao.openDatabase();
    }*/
    @Test
    public void TestCredenciais() {
       

        java.lang.String sql = "select * from login where email = ? and senha = ? ";
        PreparedStatement ps = null;
        ResultSet scan = null;
       
        try {
           ps = Conexao.openDatabase().prepareStatement(sql);
           scan = ps.executeQuery();

            if(scan.next()){
                java.lang.String nome = scan.getString("email");
                java.lang.String idade = scan.getString("senha");

                assertEquals("nfleduardo@gmail.com", nome);
                assertEquals("senha", idade);
                System.out.println("Encontrado");
                
            }else{
                assertEquals("Deveria ter retornado um resultado", true, false);
                System.out.println("Não encontrado");
            }
        } catch (Exception e) {
           
        }
    }
}
