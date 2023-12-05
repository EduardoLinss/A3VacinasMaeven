package demo.Frames.caderneta;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import demo.Conexao.Conexao;
import demo.DAO.DAOcaderneta;
import demo.entidade.caderneta;

public class cadernetaFrame extends JFrame {
    
    private JTable tabela;
    private static DefaultTableModel modelo;
    public void Caderneta(){
           JPanel infos = new JPanel();

           modelo = new DefaultTableModel();
           tabela = new JTable(modelo);

       
           
           
           modelo.addColumn("Vacina");
           modelo.addColumn("Data de aplicacao");
           modelo.addColumn("Dose");
           modelo.addColumn("Local");
           modelo.addColumn("Cidade");
           

           try {
           /*  for (caderneta u : DAOcaderneta.ConsultaVacinas()) {
                infos.setLayout(new GridLayout(0, 2, 5, 5));
                infos.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
                infos.add(new JLabel("Vacina"));
                infos.add(new JLabel(u.getNome()));
                infos.add(new JLabel("Data de aplicacao"));
                infos.add(new JLabel(u.getDataAplic()));
                infos.add(new JLabel("dose"));
                infos.add(new JLabel(u.getDose()));
                infos.add(new JLabel("local"));
                infos.add(new JLabel(u.getLocal()));
                infos.add(new JLabel("Cidade"));
                infos.add(new JLabel(u.getCidade()));
                
                Component[] labels = infos.getComponents();
                for (int i = 0; i < labels.length; i++) {
                    labels[i].setFont(new Font("Segoe print", Font.BOLD, 18));

            }
   
                
            }*/

            pesquisar();
        } catch (Exception e) {
           
            e.printStackTrace();
        }

        JButton btnCadastrarVacina = new JButton("Cadastrar nova aplicação");
        btnCadastrarVacina.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               cadastrarVacina vacinas = new cadastrarVacina();
               vacinas.cadastrarVacinas();
               dispose();
            }
            
        });

        JButton btnEditarVacina = new JButton("Editar aplicações");
        btnEditarVacina.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                editarvacinaFrame botaoEditarvacinaFrame = new editarvacinaFrame();
                botaoEditarvacinaFrame.editarVacina();
            }
            
        });

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                dispose();

            }
            
        });

        JButton btnEditar = new JButton("Editar aplicação");
        btnEditar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               editarvacinaFrame botaoEditarvacinaFrame = new editarvacinaFrame();
               botaoEditarvacinaFrame.editarVacina();
            }
            
        });

        JScrollPane scrollPane = new JScrollPane(tabela);
        //getContentPane().add(scrollPane, BorderLayout.CENTER);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 2, 10, 0));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        buttonsPanel.add(btnCadastrarVacina);
        buttonsPanel.add(btnVoltar);
        buttonsPanel.add(btnEditar);

        add(infos, BorderLayout.NORTH);
        //add(tabela, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);
    
     setTitle("dashboard");
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
     setSize(1100, 650);
    setLocationRelativeTo(null);
    setVisible(true);
    }


    public static void pesquisar() throws SQLException{
            String sql = "select * from caderneta ";
        
            PreparedStatement ps = null;
            ResultSet scan = null;
            try{
                ps = Conexao.openDatabase().prepareStatement(sql);
                
                scan = ps.executeQuery();

                while (scan.next()) {
                    String nome = scan.getString("NomeVacina");
                    String data = scan.getString("dataAplic");
                    String dose = scan.getString("dose");
                    String local = scan.getString("local");
                    String cidade = scan.getString("cidade");

                    
                    modelo.addRow(new Object[]{nome, data, dose, local, cidade});
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
            
           
    }
}
