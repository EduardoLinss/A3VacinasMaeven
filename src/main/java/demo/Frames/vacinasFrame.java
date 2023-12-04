package demo.Frames;

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
    private static DefaultTableModel modeloTabela;

    public void vacinasFrame(){
        

        modeloTabela = new DefaultTableModel();
        tabela = new JTable(modeloTabela);

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
                      
                       
                        /*for (vacinas u : NomeDaVacina(pesquisa)) {
                            infos.setLayout(new GridLayout(0, 2, 5, 5));
                            infos.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
                            infos.add(new JLabel("Vacina"));
                            infos.add(new JLabel(u.getNomeVacina()));
                            infos.add(new JLabel("Tratamento"));
                            infos.add(new JLabel(u.getTratamento()));*/
                        
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
         
             modeloTabela.setRowCount(0);
            int numeroDeColunas = scan.getMetaData().getColumnCount();

             for (int i = 1; i <= numeroDeColunas; i++) {
                modeloTabela.addColumn(scan.getMetaData().getColumnName(i));

            }

             while (scan.next()) {
                Object[] linha = new Object[numeroDeColunas];
                for (int i = 1; i <= numeroDeColunas; i++) {
                    linha[i - 1] = scan.getObject(i);
                }
                modeloTabela.addRow(linha);
            }
        }
            
            //ps.setString(2, password);
            scan = ps.executeQuery();
        }catch(SQLException e){
            e.printStackTrace();
        }
        
       
}

    public static List<vacinas> NomeDaVacina(String pesquisa){
        List <vacinas> dados = new ArrayList<vacinas>();
        String sql = "select * from vacinas where nomeVacina=?"; 

       PreparedStatement ps = null;
       ResultSet scann = null;
  
       try{
        if(ps == null){
            ps = Conexao.openDatabase().prepareStatement(sql);
            ps.setString(1, pesquisa);
            ps.executeQuery();
            scann = ps.executeQuery();
            while (scann.next()) {
                vacinas vacinas = new vacinas(sql, sql);
               
                vacinas.setId_vacina(scann.getInt("id_Vacina"));
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

}
