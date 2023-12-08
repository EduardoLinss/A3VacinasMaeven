package demo.Frames.vacinas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import demo.Conexao.Conexao;
import demo.entidade.vacinas;

public class vacinasFrame extends JFrame {
    JTextField nomeVacinaField;

    private JTable tabela;
    private static DefaultTableModel modelo;
    private JTable tabela2;
    private static DefaultTableModel modelo2;


    public void vacinasFrame(){
        

        JPanel todasAsVacinas = new JPanel();
        todasAsVacinas.setLayout(new GridLayout(0, 1, 10, 10));
        todasAsVacinas.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        modelo2 = new DefaultTableModel();
        tabela2 = new JTable(modelo2);
        modelo2.addColumn("Vacina");
        modelo2.addColumn("Tratamento");

        try {
            Pesquisar3();
        } catch (Exception e) {
            
        }
        JScrollPane scrollPane2 = new JScrollPane(tabela2);
        todasAsVacinas.add(scrollPane2);


        modelo = new DefaultTableModel();
        tabela = new JTable(modelo);
        modelo.addColumn("Vacina");
        modelo.addColumn("Tratamento");


        // Adiciona a tabela a um JScrollPane para permitir rolar os dados
        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        getContentPane().add(scrollPane);
        
        JLabel lbnomeVacina = new JLabel("Digite o nome da vacina");
        nomeVacinaField = new JTextField();
       

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0, 1, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        formPanel.setBounds(100, 300, 300, 100);
        formPanel.add(lbnomeVacina);
        formPanel.add(nomeVacinaField);

        JPanel infos = new JPanel();
        infos.add(scrollPane);

        JButton btnPesquisarVacina = new JButton("Pesquisar");
        btnPesquisarVacina.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               
                   try {

                    String pesquisa = nomeVacinaField.getText();

                    if(pesquisar(pesquisa) != false){
                        
                     
                       Pesquisar2(pesquisa);
                      
                       
    
                        
                    }
                    
                    
                   } catch ( SQLException e1) {
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
            
        });

        Dimension preferedSize = new Dimension(30, 30);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setPreferredSize(preferedSize);
        //buttonsPanel.setLayout(new GridLayout(1, 2, 10, 0));
        //buttonsPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        buttonsPanel.add(btnPesquisarVacina);
        buttonsPanel.add(btnVoltar);


        add(formPanel, BorderLayout.NORTH);
        add(buttonsPanel, BorderLayout.CENTER);
        add(infos, BorderLayout.SOUTH);
        add(todasAsVacinas);

        getContentPane().add(buttonsPanel);
        setTitle("dashboard");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(800, 650);
        setLocationRelativeTo(null);
        setVisible(true);

    }


    public static boolean pesquisar(String nomeVacina) throws SQLException{
        String sql = "select * from vacinas where nomeVacina= ? ";
    
        PreparedStatement ps = null;
        ResultSet scan = null;
        try{
            ps = Conexao.openDatabase().prepareStatement(sql);
            ps.setString(1, nomeVacina);
            
            //ps.setString(2, password);
            scan = ps.executeQuery();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return scan.next();
       
}

 public static void Pesquisar2(String nomeVacina) throws SQLException{
        String sql = "select * from vacinas where nomeVacina= ? ";
    
        PreparedStatement ps = null;
        ResultSet scan = null;
        try{

            if(ps == null){
            ps = Conexao.openDatabase().prepareStatement(sql);
            ps.setString(1, nomeVacina);
            scan = ps.executeQuery();
         
            while(scan.next()){
                String nome = scan.getString("nomeVacina");
                String tratamento = scan.getString("tratamento");
               

                
                modelo.addRow(new Object[]{nome, tratamento});
            }

             
        }
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        
       
}

    public static List<vacinas> NomeDaVacina(){
        List <vacinas> dados = new ArrayList<vacinas>();
        String sql = "select * from vacinas"; 

       PreparedStatement ps = null;
       ResultSet scann = null;
  
       try{
        if(ps == null){
            ps = Conexao.openDatabase().prepareStatement(sql);
            ps.executeQuery();
            scann = ps.executeQuery();
            while (scann.next()) {
                vacinas vacinas = new vacinas(sql, sql);
               
                //vacinas.setId_vacina(scann.getInt("id_Vacina"));
                vacinas.setNomeVacina(scann.getString("nomeVacina"));
                vacinas.setTratamento(scann.getString("tratamento"));
              

                dados.add(vacinas);
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

    public static void Pesquisar3() throws SQLException{
        String sql = "select * from vacinas ";
    
        PreparedStatement ps = null;
        ResultSet scan = null;
        try{

            if(ps == null){
            ps = Conexao.openDatabase().prepareStatement(sql);
            
            scan = ps.executeQuery();
         
            while(scan.next()){
                String nome = scan.getString("nomeVacina");
                String tratamento = scan.getString("tratamento");
               

                
                modelo.addRow(new Object[]{nome, tratamento});
            }

             
        }
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        
       
}

}
