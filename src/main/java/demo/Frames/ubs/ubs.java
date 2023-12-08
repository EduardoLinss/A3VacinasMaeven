package demo.Frames.ubs;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import demo.Conexao.Conexao;

public class ubs extends JFrame {

    private JTable tabela;
    private static DefaultTableModel modelo;
    public void inicia(){
        modelo = new DefaultTableModel();
        tabela = new JTable(modelo);
        modelo.addColumn("Endereco");
        modelo.addColumn("Cep");  

        try {
            pesquisar();
        } catch (Exception e) {
           e.printStackTrace();
        }

        JButton btnVoltar = new JButton();
        btnVoltar.addActionListener(new ActionListener() {

           @Override
            public void actionPerformed(ActionEvent e) {
                setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                dispose();
            }
                    
        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 2, 10, 0));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        buttonsPanel.add(btnVoltar);

        JScrollPane scrollPane = new JScrollPane(tabela);

        add(scrollPane, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);
                
        setTitle("dashboard");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(1100, 650);
        setLocationRelativeTo(null);
        setVisible(true);

    }
    public static void pesquisar() throws SQLException{
        String sql = "select * from ubs ";
                  
        PreparedStatement ps = null;
        ResultSet scan = null;
            try{
                ps = Conexao.openDatabase().prepareStatement(sql);
                scan = ps.executeQuery();
                while (scan.next()) {
                    String nome = scan.getString("endereco");
                    String cep = scan.getString("cep");
                    modelo.addRow(new Object[]{nome, cep});
                }
                }catch(SQLException e){
                    e.printStackTrace();
                }
    }
    
}
