package demo;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import demo.Conexao.Conexao;


public class TesteConexaoComOBanco {
 
    private Conexao conect;

      @Before
    public void setUp()  {
        conect = new Conexao();
        Conexao.openDatabase();
    }

    @Test

    public void TestarConexao(){
       try {
        if(conect != null){
            System.out.println("Conectado");
        }else{
            System.out.println("Não conectado");
        }
       } catch (Exception e) {
        
       } 
    }


    

   /*  @After
    public void FecharConexao(){
        conect = new Conexao();
        try {
            conect.CloseDatabase();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }*/
}
