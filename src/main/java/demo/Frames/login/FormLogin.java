package demo.Frames.login;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;


import demo.Conexao.Conexao;
import demo.Frames.MainFrame;


public class FormLogin extends JFrame {
    final private Font mainFont = new Font("Arial", Font.BOLD, 18);
    JTextField tfEmail;
    JPasswordField pfPassword;

    public void initialize() {
        /*************** Form Panel ***************/
        JLabel lbLoginForm = new JLabel("Login Form", SwingConstants.CENTER);
        lbLoginForm.setFont(mainFont);

        JLabel lbEmail = new JLabel("Email");
        lbEmail.setFont(mainFont);

        tfEmail = new JTextField();
        tfEmail.setFont(mainFont);

        JLabel lbPassword = new JLabel("Password");
        lbPassword.setFont(mainFont);

        pfPassword = new JPasswordField();
        pfPassword.setFont(mainFont);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0, 1, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        formPanel.add(lbLoginForm);
        formPanel.add(lbEmail);
        formPanel.add(tfEmail);
        formPanel.add(lbPassword);
        formPanel.add(pfPassword);

        /*************** Buttons Panel ***************/
        JButton btnLogin = new JButton("Login");
        btnLogin.setFont(mainFont);
        btnLogin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                String email = tfEmail.getText();
                String password = String.valueOf(pfPassword.getPassword());

                //login user = getAuthenticatedUser(email, password);
               
                try {
                    if (validarLogin(email, password) != false) {
                         MainFrame mainFrame = new MainFrame();
                        mainFrame.iniciar();;
                        dispose();
                        
                       // JOptionPane.showMessageDialog(FormLogin.this, "Login válido", "Try agaain", JOptionPane.YES_OPTION);             
                    }
                    else {
                        JOptionPane.showMessageDialog(FormLogin.this,
                                "Email or Password Invalid",
                                "Try again",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } catch (HeadlessException e1) {
                    
                    e1.printStackTrace();
                } catch (SQLException e1) {
                    
                    e1.printStackTrace();
                }
            }
            
        });

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setFont(mainFont);
        btnCancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                dispose();
            }
            
        });

        JButton btnCadastro = new JButton("Cadastrar-se");
        btnCadastro.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                CadastroLogin botao3 = new CadastroLogin();

                botao3.cadastrar();
            }
            
        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 2, 10, 0));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        buttonsPanel.add(btnLogin);
        buttonsPanel.add(btnCancel);
        buttonsPanel.add(btnCadastro);



        /*************** Initialise the frame ***************/
        add(formPanel, BorderLayout.NORTH);
        add(buttonsPanel, BorderLayout.SOUTH);

        setTitle("Login Form");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(400, 500);
        setMinimumSize(new Dimension(350, 450));
        //setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    public static boolean validarLogin(String email, String password) throws SQLException{
            String sql = "select * from login where email = ? and senha = ? ";
            PreparedStatement ps = null;
            ResultSet scan = null;
            try{
                ps = Conexao.openDatabase().prepareStatement(sql);
                ps.setString(1, email);
                ps.setString(2, password);
                scan = ps.executeQuery();
            }catch(SQLException e){
                e.printStackTrace();
            }
            return scan.next();
    }



    public static void main(String[] args) {
        
        FormLogin loginForm = new FormLogin();
        loginForm.initialize();
    }


    public static boolean validarLogin(boolean originalData, boolean originalData2) {
        return false;
    }


    public void validarLogin(com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String email,
            com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String senha) {
    }
}
