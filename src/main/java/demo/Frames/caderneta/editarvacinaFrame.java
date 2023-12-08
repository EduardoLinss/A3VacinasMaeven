package demo.Frames.caderneta;

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
import demo.Frames.alerta.editarAlertaFrame;
import demo.entidade.caderneta;

public class editarvacinaFrame extends JFrame {
    
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

    
    public void editarVacina(){

       
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



                for (caderneta u : NomeDaVacina(pesquisa)) {
               
                formPanel.add(lbnomeVacina);
                formPanel.add(nomeVacinaField= new JTextField(u.getNome()));
                formPanel.add(lbdataAplic);
                formPanel.add(dataAplicField = new JTextField(u.getDataAplic()));
                formPanel.add(lbdose);
                formPanel.add(doseField = new JTextField(u.getDose()));
                formPanel.add(lblocal);
                formPanel.add(localField = new JTextField(u.getLocal()));
                formPanel.add(lbcidade);
                formPanel.add(cidadeField = new JTextField(u.getCidade()));
                
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
                    String doses = doseField.getText();
                    String locais = localField.getText();
                    String cidades = cidadeField.getText();

                if(AtualizaVacinasFrames(nomes, datas, doses, locais, cidades)){
                 JOptionPane.showMessageDialog(editarvacinaFrame.this,
                 "Dados atualizados com sucesso",
                "Sucesso!",
                JOptionPane.OK_OPTION);
                    }
                
                    

                }
                
            });

            JButton btnLimpar = new JButton("Nova edição");
            btnLimpar.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                   removeAll();
                   dispose();
                   editarvacinaFrame reopen = new editarvacinaFrame();
                   reopen.editarVacina();
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

                    }else{
                        JOptionPane.showMessageDialog(editarvacinaFrame.this,
                 "Vacina não encontrada",
                "Erro!",
                JOptionPane.INFORMATION_MESSAGE);     
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
        buttonsPanel.add(lbnomeVacina);
        buttonsPanel.add(vacinaAeditarField);
        buttonsPanel.add(btnPesquisar);
        buttonsPanel.add(btnLimparPesquisa); 
        buttonsPanel.add(btnVoltar);
        
        
           

    
        add(buttonsPanel, BorderLayout.NORTH);
        



        setTitle("dashboard");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
         setSize(1100, 650);
        setLocationRelativeTo(null);
        setVisible(true);

    
    
    }

     public static boolean pesquisar(String nomeVacina) throws SQLException{
        String sql = "select * from caderneta where NomeVacina= ? ";
    
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

public static List<caderneta> NomeDaVacina(String pesquisa){
        List <caderneta> dados = new ArrayList<caderneta>();
        String sql = "select * from caderneta where NomeVacina=?"; 

       PreparedStatement ps = null;
       ResultSet scann = null;
  
       try{
        if(ps == null){
            ps = Conexao.openDatabase().prepareStatement(sql);
            ps.setString(1, pesquisa);
            ps.executeQuery();
            scann = ps.executeQuery();
            while (scann.next()) {
                caderneta caderneta = new caderneta(sql, sql, sql, sql, sql);
               
                caderneta.setNome(scann.getString("NomeVacina"));
                caderneta.setDataAplic(scann.getString("dataAplic"));
                caderneta.setDose(scann.getString("dose"));
                caderneta.setLocal(scann.getString("local"));
                caderneta.setCidade(scann.getString("cidade"));
              

                dados.add(caderneta);
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


   
    public boolean AtualizaVacinasFrames(String nome, String dataAplic, String dose, String local, String cidade){
        String sql = "update caderneta SET NomeVacina=?, dataAplic=?, dose=?, local=?, cidade = ?  WHERE NomeVacina = ?";

        PreparedStatement ps=null;
        String pesquisa = vacinaAeditarField.getText();

        try{
            //ps = Conexao.openDatabase().prepareStatement(sql);

            
            //ps.executeQuery();
            if (ps == null){
            ps = Conexao.openDatabase().prepareStatement(sql);

            ps.setString(1, nome);
            ps.setString(2, dataAplic);
            ps.setString(3, dose);
            ps.setString(4, local);
            ps.setString(5, cidade);
            ps.setString(6, pesquisa);
            ps.execute();
            ps.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return ps != null;
    }
}
