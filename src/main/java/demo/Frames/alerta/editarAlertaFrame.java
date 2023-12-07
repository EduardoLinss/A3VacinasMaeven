package demo.Frames.alerta;

import javax.swing.*;

import demo.Conexao.Conexao;
import demo.Frames.caderneta.editarvacinaFrame;
import demo.entidade.alerta;
import demo.entidade.caderneta;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class editarAlertaFrame extends JFrame {
    JTextField nomeVacinaField;
    JTextField dataAplicField;
    JTextField vacinaAeditarField;
    JTextField recebeVacina;
    JLabel lbnomeVacina = new JLabel("Vacina");
    JLabel lbdataAplic = new JLabel("Data de aplicacao");
    public void editarAlerta(){

        JLabel lbnomeVacinaPesquisar = new JLabel("Digite o nome da vacina");
        vacinaAeditarField = new JTextField();


        JButton pesquisar = new JButton("Pesquisar");
        pesquisar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            
            String pesquisa = vacinaAeditarField.getText();
                
            try {

                if(pesquisar(pesquisa) != false){


                    JPanel formPanel = new JPanel();
                    formPanel.setLayout(new GridLayout(0, 1, 10, 10));
                    formPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
                    formPanel.setBounds(100, 300, 300, 100);

                    add(formPanel);

                    for (alerta u : NomeDaVacina(pesquisa)) {
                        formPanel.add(lbnomeVacina);
                        formPanel.add(nomeVacinaField= new JTextField(u.getNomeVacina()));
                        formPanel.add(lbdataAplic);
                        formPanel.add(dataAplicField = new JTextField(u.getDataProx()));
                       
                    }

                    
                    
                }
                
            } catch (Exception e1) {
                e1.printStackTrace();
            }

            JButton btnEditar = new JButton("Editar");
            btnEditar.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                   // DAOcaderneta update = new DAOcaderneta();
                    
                    String nomes = nomeVacinaField.getText();
                    String datas = dataAplicField.getText();
                    ;

                    if(AtualizaAlertaFrames(nomes, datas)){
                        JOptionPane.showMessageDialog(editarAlertaFrame.this,
                 "Dados atualizados com sucesso",
                "Sucesso!",
                JOptionPane.YES_OPTION);
                    }
 
                }


                
            });


           


            setTitle("dashboard");
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            setSize(1100, 650);
            setLocationRelativeTo(null);
            setVisible(true);


            }

            
            
        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 2, 10, 0));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        buttonsPanel.add(pesquisar);
        

        add(buttonsPanel, BorderLayout.NORTH);
        



        setTitle("dashboard");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
         setSize(1100, 650);
        setLocationRelativeTo(null);
        setVisible(true);

    }
    
    public boolean AtualizaAlertaFrames(String nome, String dataAplic){
        String sql = "update alerta SET NomeVacina=?, dataProx=?  WHERE NomeVacina = ?";

        PreparedStatement ps=null;
        String pesquisa = recebeVacina.getText();

        try{
            //ps = Conexao.openDatabase().prepareStatement(sql);

            
            //ps.executeQuery();
            if (ps == null){
            ps = Conexao.openDatabase().prepareStatement(sql);

            ps.setString(1, nome);
            ps.setString(2, dataAplic);
     
            ps.setString(6, pesquisa);
            ps.execute();
            ps.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return ps != null;
    }

    public static boolean pesquisar(String nomeVacina) throws SQLException{
        String sql = "select * from alerta where NomeVacina= ? ";
    
        PreparedStatement ps = null;
        ResultSet scan = null;
        try{
            ps = Conexao.openDatabase().prepareStatement(sql);
            ps.setString(1, nomeVacina);
 
            scan = ps.executeQuery();
           
        }catch(SQLException e){
            e.printStackTrace();
        }
        return scan.next();
    }


    public static List<alerta> NomeDaVacina(String pesquisa){
        List <alerta> dados = new ArrayList<alerta>();
        String sql = "select * from alerta where NomeVacina=?"; 

       PreparedStatement ps = null;
       ResultSet scann = null;
  
       try{
        if(ps == null){
            ps = Conexao.openDatabase().prepareStatement(sql);
            ps.setString(1, pesquisa);
            ps.executeQuery();
            scann = ps.executeQuery();
            while (scann.next()) {
                alerta alerta = new alerta(0, sql, sql);
               
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

    
