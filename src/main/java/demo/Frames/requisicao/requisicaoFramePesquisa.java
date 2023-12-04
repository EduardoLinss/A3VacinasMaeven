package demo.Frames.requisicao;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import demo.Conexao.Conexao;
import demo.entidade.requsicao;

public class requisicaoFramePesquisa extends JFrame {
    //final private Font mainFont = new Font("Arial", Font.BOLD, 18);
    static JTextField tfpesquisa;
   
    public void pesquisar(){

        


        JLabel lbpesquisaPais = new JLabel("Pesquisar vacinas em outros Paises", SwingConstants.CENTER);
        

        JLabel lbpesquisa = new JLabel("Pesquisar");
        tfpesquisa = new JTextField();
        
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0, 1, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        formPanel.add(lbpesquisaPais);
        formPanel.add(lbpesquisa);
        formPanel.add(tfpesquisa);


        JPanel infos = new JPanel();
        JButton Pesquisar = new JButton("Pesquisar");
        Pesquisar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
   
            try {
                String pesquisa = tfpesquisa.getText();
                    
                    if(pesquisar(pesquisa)!= false){

                        for (requsicao u : getPeloNome(pesquisa)) {
                           // infos.setLayout(new GridLayout(0, 2, 5, 5));
                           // infos.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
                            //infos.add(new JLabel("Pais"));
                            //infos.add(new JLabel(u.getnomePais()));
                            //infos.add(new JLabel("Vacinas necessárias"));
                            //infos.add(new JLabel(u.getVacinas()));
                
                           // Component[] labels = infos.getComponents();
                            //for (int i = 0; i < labels.length; i++) {
                           //     labels[i].setFont(new Font("Segoe print", Font.BOLD, 18));
                
                       // }
                    
                    }          
                        
                
           
        }
            } catch (SQLException e1) {
                    
                    e1.printStackTrace();
                }
            }
            
        });

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                
                dispose();
            }
            
        } );

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 2, 10, 0));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        buttonsPanel.add(Pesquisar);
        buttonsPanel.add(btnVoltar);


        add(formPanel, BorderLayout.NORTH);
        add(infos, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);  


        setTitle("dashboard");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(1100, 650);
        setLocationRelativeTo(null);
        setVisible(true);
        
    }

    public static boolean pesquisar(String tfpesquisa) throws SQLException{
            String sql = "select * from requisicao where NomePais= ? ";
        
            PreparedStatement ps = null;
            ResultSet scan = null;
            try{
                ps = Conexao.openDatabase().prepareStatement(sql);
                ps.setString(1, tfpesquisa);
                
                //ps.setString(2, password);
                scan = ps.executeQuery();
            }catch(SQLException e){
                e.printStackTrace();
            }
            return scan.next();
           
    }

    public static List<requsicao> getPeloNome(String pesquisa){
        List <requsicao> dados = new ArrayList<requsicao>();
        String sql = "select * from requisicao where NomePais=?"; 

       PreparedStatement ps = null;
       ResultSet scann = null;
  
       try{
        if(ps == null){
            ps = Conexao.openDatabase().prepareStatement(sql);
            ps.setString(1, pesquisa);
            ps.executeQuery();
            scann = ps.executeQuery();
            while (scann.next()) {
                requsicao requsicao = new requsicao(sql, sql);
               
                requsicao.setId(scann.getInt("id_pais"));
                requsicao.setnomePais(scann.getString("NomePais"));
                requsicao.setVacinas(scann.getString("vacinas"));
              

                dados.add(requsicao);
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

