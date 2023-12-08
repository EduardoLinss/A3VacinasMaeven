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

import demo.entidade.alerta;


public class editarAlertaFrame extends JFrame {
    
    JTextField vacinaAeditarField;
    JTextField nomeVacinaField;
    JTextField dataAplicField;
    JTextField doseField;
    JTextField localField;
    JTextField cidadeField;
    JLabel lbnomeVacina = new JLabel("Vacina");
    JLabel lbdataAplic = new JLabel("Data de aplicacao");
    JLabel lbdose = new JLabel("Dose");
    JLabel lblocal = new JLabel("Local");
    JLabel lbcidade = new JLabel("Cidade");

    
    public void editar(){

       
        JLabel lbnomeVacinaPesquisar = new JLabel("Digite o nome da vacina");
        vacinaAeditarField = new JTextField();
       

        
        dataAplicField = new JTextField();

        
        doseField = new JTextField();

         
        localField = new JTextField();

         
        cidadeField = new JTextField();


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



                for (alerta u : NomeDaVacina(pesquisa)) {
               
                formPanel.add(lbnomeVacina);
                formPanel.add(nomeVacinaField= new JTextField(u.getNomeVacina()));
                formPanel.add(lbdataAplic);
                formPanel.add(dataAplicField = new JTextField(u.getDataProx()));
                
                
                Component[] labels = formPanel.getComponents();
                for (int i = 0; i < labels.length; i++) {
                    labels[i].setFont(new Font("Arial", Font.BOLD, 18));
            

            }

           
            JButton btnEditar = new JButton("Editar");
            btnEditar.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                   // DAOcaderneta update = new DAOcaderneta();
                    
                    String nomes = nomeVacinaField.getText();
                    String datas = dataAplicField.getText();
                 
                if(AtualizaAlertaFrames(nomes, datas)){
                 JOptionPane.showMessageDialog(editarAlertaFrame.this,
                 "Dados atualizados com sucesso",
                "Sucesso!",
                JOptionPane.INFORMATION_MESSAGE);
                    }
                
                    

                }
                
            });

            JButton btnLimpar = new JButton("Nova edição");
            btnLimpar.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                   removeAll();
                   dispose();
                   editarAlertaFrame reopen = new editarAlertaFrame();
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
                nomeVacinaField.setText(" ");
                dataAplicField.setText(" ");
                doseField.setText(" ");
                localField.setText(" ");
                cidadeField.setText(" ");

                
                
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



        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 2, 10, 0));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        buttonsPanel.add(btnPesquisar, BorderLayout.SOUTH);
        buttonsPanel.add(btnLimparPesquisa, BorderLayout.NORTH);
        buttonsPanel.add(btnVoltar, BorderLayout.SOUTH);
        buttonsPanel.add(lbnomeVacina, BorderLayout.NORTH);
        buttonsPanel.add(vacinaAeditarField);
        
           

    
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
        String pesquisa = vacinaAeditarField.getText();

        try{
            
            if (ps == null){
            ps = Conexao.openDatabase().prepareStatement(sql);

            ps.setString(1, nome);
            ps.setString(2, dataAplic);
     
            ps.setString(3, pesquisa);
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
