package demo.Frames.dependentes;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import demo.Conexao.Conexao;

import demo.entidade.dependentes;

public class editarDependentes extends JFrame {
    
    JTextField vacinaAeditarField;
    JTextField nome;
    JTextField cpf;
    JTextField idade;
    JLabel lbnomeVacina = new JLabel("NJome");
    JLabel lbdataAplic = new JLabel("Cpf");
    JLabel lbdose = new JLabel("Idade");

    
    public void editar(){

       
        JLabel lbnomeVacinaPesquisar = new JLabel("Digite o nome da vacina");
        vacinaAeditarField = new JTextField();
       

        
        nome = new JTextField();

        
        cpf = new JTextField();

         
        idade = new JTextField();

         
      


        JButton btnPesquisar = new JButton("Pesquisar");
        btnPesquisar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                String pesquisa = vacinaAeditarField.getText();

                try {
                    if(pesquisar(pesquisa) != false ){
                    
                    JPanel formPanel = new JPanel();
                    formPanel.setLayout(new GridLayout(0, 1, 10, 10));
                    formPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
                    formPanel.setBounds(100, 300, 300, 100);
      

                    add(formPanel);



                for (dependentes u : NomeDaVacina(pesquisa)) {
               
                formPanel.add(lbnomeVacina);
                formPanel.add(nome= new JTextField(u.getNome()));
                formPanel.add(lbdataAplic);
                formPanel.add(cpf = new JTextField(u.getCpf()));
                formPanel.add(lbdose);
                formPanel.add(idade = new JTextField(u.getIdade()));
                
                
                Component[] labels = formPanel.getComponents();
                for (int i = 0; i < labels.length; i++) {
                    labels[i].setFont(new Font("Arial", Font.BOLD, 18));
            

            }

           
            JButton btnEditar = new JButton("Editar");
            btnEditar.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                   // DAOcaderneta update = new DAOcaderneta();
                    
                    String nomes = nome.getText();
                    String datas = cpf.getText();
                    String doses = idade.getText();
                  

                if(AtualizaDependentesFrames(nomes, datas, doses)){
                 JOptionPane.showMessageDialog(editarDependentes.this,
                 "Dados atualizados com sucesso",
                "Sucesso!",
                JOptionPane.YES_OPTION);
                    }
                
                    

                }
                
            });

            JButton btnLimpar = new JButton("Nova edição");
            btnLimpar.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                   removeAll();
                   dispose();
                   editarDependentes reopen = new editarDependentes();
                   reopen.editar();
                }
                
            });
            
            formPanel.add(btnEditar);
            formPanel.add(btnLimpar);
                
            }
                

                    setTitle("dashboard");
                    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                    setSize(1100, 650);
                    setLocationRelativeTo(null);
                    setVisible(true);

                    }
                } catch (SQLException e1) {
                    
                    e1.printStackTrace();
                } catch (Exception e1) {
                    
                    e1.printStackTrace();
                }
            }
 
        });

        JButton btnLimparPesquisa = new JButton("Limpar pesquisa");
        btnLimparPesquisa.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                vacinaAeditarField.setText(" ");
                nome.setText(" ");
                idade.setText(" ");
                cpf.setText(" ");
             
                
                
            }
            
        });



        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 2, 10, 0));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        buttonsPanel.add(btnPesquisar);
        buttonsPanel.add(btnLimparPesquisa);
        buttonsPanel.add(lbnomeVacina);
        buttonsPanel.add(vacinaAeditarField);
        
           

    
        add(buttonsPanel, BorderLayout.NORTH);
        



        setTitle("dashboard");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
         setSize(1100, 650);
        setLocationRelativeTo(null);
        setVisible(true);

    
    
    }
public boolean AtualizaDependentesFrames(String nome, String dataAplic, String idade ){
        String sql = "update dependentes SET nome=?, cpf=?, idade=?  WHERE nome = ?";

        PreparedStatement ps=null;
        String pesquisa = vacinaAeditarField.getText();

        try{
            
            if (ps == null){
            ps = Conexao.openDatabase().prepareStatement(sql);

            ps.setString(1, nome);
            ps.setString(2, dataAplic);
            ps.setString(3, idade);
     
            ps.setString(4, pesquisa);
            ps.execute();
            ps.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return ps != null;
    }

    public static boolean pesquisar(String nomeVacina) throws SQLException{
        String sql = "select * from dependentes where nome= ? ";
    
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


    public static List<dependentes> NomeDaVacina(String pesquisa){
        List <dependentes> dados = new ArrayList<dependentes>();
        String sql = "select * from dependentes where nome=?"; 

       PreparedStatement ps = null;
       ResultSet scann = null;
  
       try{
        if(ps == null){
            ps = Conexao.openDatabase().prepareStatement(sql);
            ps.setString(1, pesquisa);
            ps.executeQuery();
            scann = ps.executeQuery();
            while (scann.next()) {
                dependentes dependentes = new dependentes(0, sql, sql, sql);
               
                dependentes.setNome(scann.getString("nome"));
                dependentes.setCpf(scann.getString("cpf"));
                dependentes.setIdade(scann.getString("idade"));
               
              

                dados.add(dependentes);
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
