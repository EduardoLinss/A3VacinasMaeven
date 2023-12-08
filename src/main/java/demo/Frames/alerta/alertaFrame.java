package demo.Frames.alerta;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
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
import demo.entidade.alerta;



public class alertaFrame extends JFrame {
    private JTable tabela;
    private static DefaultTableModel modelo;
    public void iniciaAlerta(){
         JPanel infos = new JPanel();

         
           modelo = new DefaultTableModel();
           tabela = new JTable(modelo);
           modelo.addColumn("Vacina");
           modelo.addColumn("Data de aplicacao");
        
      try {
        pesquisar();
      } catch (Exception e) {
       
      }
         


    JButton btnCadastrar = new JButton("Gerar notificacao");
    btnCadastrar.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            cadastrarAlerta alerta = new cadastrarAlerta();
            alerta.CadastrarAlerta();
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
    JButton btnEditar = new JButton("Editar notificações");
    btnEditar.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            //editarAlertaFrame botaodeEditar = new editarAlertaFrame();
            //botaodeEditar.editarAlerta();

            editarAlertaFrame botaoeditar = new editarAlertaFrame();
            botaoeditar.editar();
        }
        
    });



    JScrollPane scrollPane = new JScrollPane(tabela);

    JPanel buttonsPanel = new JPanel();
    buttonsPanel.setLayout(new GridLayout(1, 2, 10, 0));
    buttonsPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
    buttonsPanel.add(btnCadastrar);
    buttonsPanel.add(btnVoltar);
    buttonsPanel.add(btnEditar);

    add(infos, BorderLayout.NORTH);
    add(scrollPane, BorderLayout.CENTER);
    add(buttonsPanel, BorderLayout.SOUTH);
    
     setTitle("dashboard");
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
     setSize(1100, 650);
    setLocationRelativeTo(null);
    setVisible(true);
}

    public static void pesquisar() throws SQLException{
        String sql = "select * from alerta ";
    
        PreparedStatement ps = null;
        ResultSet scan = null;
        try{
            ps = Conexao.openDatabase().prepareStatement(sql);
            
            scan = ps.executeQuery();

            while (scan.next()) {
                String nome = scan.getString("NomeVacina");
                String data = scan.getString("dataProx");
               

                
                modelo.addRow(new Object[]{nome, data});
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
       
}
}

