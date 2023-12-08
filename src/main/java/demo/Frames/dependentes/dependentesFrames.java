package demo.Frames.dependentes;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import demo.Conexao.Conexao;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class dependentesFrames extends JFrame {
    private JTable tabela;
    private static DefaultTableModel modelo;

    JTextField nome;
    JTextField cpf;
    JTextField idade;

    JLabel lbnome = new JLabel("Nome");
    JLabel lbcpf = new JLabel("Cpf");
    JLabel lbidade = new JLabel("idade");

        
   
    public void iniciaDependentes(){
    
   
    //JPanel infos = new JPanel();
    

    modelo = new DefaultTableModel();
           tabela = new JTable(modelo);
           modelo.addColumn("nome");
           modelo.addColumn("cpf");
           modelo.addColumn("Idade");
        
        try {
            pesquisar();
            
        } catch (Exception e) {
            e.printStackTrace();
        }



    JButton btnCadastraDependentes = new JButton("Cadastrar dependentes");
    btnCadastraDependentes.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
        MenuDependentes cadastra = new MenuDependentes();
        cadastra.cadastra();

      
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

    JButton btnEditarDependente = new JButton("Editar dependentes");
    btnEditarDependente.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            editarDependentes botaoEditar = new editarDependentes();
            botaoEditar.editar();
        }
        
    });

  
    JPanel buttonsPanel = new JPanel();
    buttonsPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
    buttonsPanel.setBackground(Color.YELLOW);
  
    buttonsPanel.add(btnCadastraDependentes);
    buttonsPanel.add(btnVoltar);
    buttonsPanel.add(btnEditarDependente);

    JScrollPane scrollPane = new JScrollPane(tabela);


    //add(infos, BorderLayout.NORTH);
    add(buttonsPanel, BorderLayout.SOUTH);
    add(scrollPane, BorderLayout.CENTER);

    
     setTitle("dashboard");
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
     setSize(1100, 650);
    setLocationRelativeTo(null);
    setVisible(true);
    }


    public static void pesquisar() throws SQLException{
        String sql = "select * from dependentes ";
    
        PreparedStatement ps = null;
        ResultSet scan = null;
        try{
            ps = Conexao.openDatabase().prepareStatement(sql);
            
            scan = ps.executeQuery();

            while (scan.next()) {
                String nome = scan.getString("nome");
                String cpf = scan.getString("cpf");
                String idade = scan.getString("idade");
                
               
               

                
                modelo.addRow(new Object[]{nome, cpf, idade});
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
       
}


    
}
