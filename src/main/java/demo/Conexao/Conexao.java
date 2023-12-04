package demo.Conexao;

import java.sql.*;

public class Conexao {
    
    public static String URL =
        "jdbc:mysql://localhost:3306/a3Modelos";

    public static String User = "root";

    public static String Pwd = "";
    

    //objetos de conexao

    public static Connection dbconn = null;
    public static Statement sqlmgr = null;
    public static ResultSet resultsql = null;

    public static Connection openDatabase (){
        try{
            dbconn = DriverManager.getConnection(URL, User, Pwd);
            if (dbconn != null) {
                System.out.println("Conectado com sucesso em: " + URL);
                return dbconn;
                
            }else{
                sqlmgr = dbconn.createStatement();//cria objetos para o sqls
                //get(sqlmgr);

            }
            
            
        } catch (Exception Error)
        {
            System.out.println("Error on connect: "+Error.getMessage());
        }
        return dbconn;

    }
    public void CloseDatabase() throws SQLException{
        sqlmgr.close();
        dbconn.close();
    }

    public int ExecutaQuery(String sql){
       try{
        sqlmgr.executeUpdate(sql);
    }catch (Exception Error)
    {
        System.out.println("Error on connect: " + Error.getMessage());
    }
    return -1;
    }
}