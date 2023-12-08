package demo.Frames.login;

import javax.swing.*;

import demo.Conexao.Conexao;
import demo.DAO.DAOlogin;
import demo.Frames.caderneta.editarvacinaFrame;
import demo.entidade.login;




import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;



public class EditarCadastro extends JFrame {

    FormLogin tela = new FormLogin();
   
    EditarCadastro recebe;
    JTextField nomeusUarioField;
    JTextField senhaUsuarioField;
    JTextField emailUsuarioField;
    JTextField cpfUsuarioField;
    JTextField dataUsuarioField;
    JLabel lbUsuarioNome = new JLabel("Nome");
    JLabel lbSenhaUsuario = new JLabel("Senha");
    JLabel lbEmailUsuario = new JLabel("Email");
    JLabel lbCpfUsuario = new JLabel("Cpf");
    JLabel lbDataUsuario = new JLabel("Data de Nascimento");

    private String t;
  



    
    public void EditarCadastro2(String email) {

        JTextField y = new JTextField(email);
        FormLogin z = new FormLogin();
        
        String b = z.tfEmail.getText();
        JPanel  formPanel = new JPanel();
                formPanel.setLayout(new GridLayout(0, 1, 10, 10));
                formPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
                formPanel.setBounds(100, 300, 300, 100);
        
                try {
                    for (login j :consulta(b)) {
                         formPanel.add(lbUsuarioNome);
                        formPanel.add(nomeusUarioField = new JTextField(j.getNome()));
                        formPanel.add(senhaUsuarioField = new JTextField(j.getSenha()));
                        formPanel.add(emailUsuarioField = new JTextField(j.getEmail()));
                        formPanel.add(cpfUsuarioField = new JTextField(j.getCpf()));
                        formPanel.add(dataUsuarioField = new JTextField(j.getDataNasc()));

                        JButton btnSalvar = new JButton("Salvar");
                        btnSalvar.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                               seila();
                            }
                            
                        }); 
                        add(btnSalvar, BorderLayout.SOUTH);
                    }
                   
                }catch (Exception e){
                    e.printStackTrace();
                }

                add(formPanel, BorderLayout.NORTH);
                setTitle("dashboard");
                setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                 setSize(1100, 650);
                setLocationRelativeTo(null);
                setVisible(true);
        

    }
   

    public void EditarCadastro(){
        
        
        
        JPanel  formPanel = new JPanel();
                formPanel.setLayout(new GridLayout(0, 1, 10, 10));
                formPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
                formPanel.setBounds(100, 300, 300, 100);


                try {
                   

                    for (login u : DAOlogin.consultaLogin()) {
                        
                        formPanel.add(lbUsuarioNome);
                        formPanel.add(nomeusUarioField = new JTextField(u.getNome()));
                        formPanel.add(senhaUsuarioField = new JTextField(u.getSenha()));
                        formPanel.add(emailUsuarioField = new JTextField(u.getEmail()));
                        formPanel.add(cpfUsuarioField = new JTextField(u.getCpf()));
                        formPanel.add(dataUsuarioField = new JTextField(u.getDataNasc()));



                    //if(tela.DadoDoJtextField() != null){
                    JButton btnSalvar = new JButton("Salvar");
                    btnSalvar.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {

                        
                                seila();
                        }
                        
                    });
                    JButton btnVoltar = new JButton("Cancelar"); 
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
                    buttonsPanel.add(btnSalvar);
                    buttonsPanel.add(btnVoltar);
                    add(buttonsPanel, BorderLayout.SOUTH);
                   
                    }//else{
                       // System.out.println("EMAIL");
                    //}
                //}
                   
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            
                add(formPanel, BorderLayout.NORTH);
                

                setTitle("dashboard");
                setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                 setSize(1100, 650);
                setLocationRelativeTo(null);
                setVisible(true);
        
    
    }

    
    public boolean AtualizarCadastroFrame(String nome, String senha, String email, String Cpf, String data){
        String sql = "update login SET nome=?, senha =?, email=?, cpf=?, dataNasc = ?  WHERE email = ?";

        String EMAIL = "nfleduardo@gmail.com";
        

        PreparedStatement ps=null;

        try{
            if (ps == null){
                ps = Conexao.openDatabase().prepareStatement(sql);
                ps.setString(1, nome);
                ps.setString(2,  senha);
                ps.setString(3,  email);
                ps.setString(4,  Cpf);
                ps.setString(5,  data);
                ps.setString(6, EMAIL);
               // ps.setString(6, emailPesquisa );
                ps.execute();
                ps.close();
            }
           
                    
        }catch(SQLException e){
            e.printStackTrace();
        }
        return ps != null;

    }

    public void seila(){
         FormLogin valor = new FormLogin();

                           
                           // String emailPesquisa = valor.DadoDoJtextField();
                            String nome = nomeusUarioField.getText();
                            String senha = senhaUsuarioField.getText();
                            String email = emailUsuarioField.getText();
                            String Cpf = cpfUsuarioField.getText();
                            String data = dataUsuarioField.getText();

                            if(AtualizarCadastroFrame(nome, senha, email, Cpf, data)){
                                  JOptionPane.showMessageDialog(EditarCadastro.this,
                 "Dados atualizados com sucesso",
                "Sucesso!",
                JOptionPane.INFORMATION_MESSAGE);
                            }

                            
    }


    public static List<login> consulta(String x) throws Exception{
        List <login> list = new ArrayList<login>();
        
        String sql = "select * from login where email = ? ";
 
       PreparedStatement ps = null;
       ResultSet scann = null;
        try{
            if(ps == null){
                ps = Conexao.openDatabase().prepareStatement(sql);
                ps.setString(1, x);
                scann = ps.executeQuery();
                while (scann.next()) {
                    login login = new login(0, sql, sql);
                    login.setNome(scann.getString("nome"));
                    login.setEmail(scann.getString("senha"));
                    login.setEmail(scann.getString("email"));
                    login.setCpf(scann.getString("cpf"));
                    login.setDataNasc(scann.getString("dataNasc"));
                    //login.setSenha(scann.getString("senha"));
                    list.add(login);
                   
                }

            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            ps.close();
        }
        return list;
    }

  

}
 