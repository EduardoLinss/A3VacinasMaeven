package demo.Frames.login;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import java.util.ArrayList;
import java.util.List;


import demo.DAO.DAOlogin;


public class CadastroLogin extends JFrame {
    JTextField nome;
    JTextField senha;
    JTextField email;
    JTextField cpf;
    JTextField dataNasc;

   
    public void cadastrar(){


        JLabel lbnome = new JLabel("Nome");
        nome = new JTextField();
       

        JLabel lbsenha = new JLabel("senha");
        senha = new JTextField();

        JLabel lbemail = new JLabel("email");
        email = new JTextField();

        JLabel lbcpf = new JLabel("cpf");
        cpf = new JTextField();
       

        JLabel lbdataNasc = new JLabel("dataNasc");
        dataNasc = new JTextField();


        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0, 1, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        formPanel.setBounds(100, 300, 300, 100);
        formPanel.add(lbnome);
        formPanel.add(nome);
        formPanel.add(lbsenha);
        formPanel.add(senha);
        formPanel.add(lbemail);
        formPanel.add(email);
        formPanel.add(lbcpf);
        formPanel.add(cpf);
        formPanel.add(lbdataNasc);
        formPanel.add(dataNasc);

        JButton cadastrar = new JButton("Cadastrar");

        cadastrar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               
                DAOlogin insert = new DAOlogin();

                String nomes = nome.getText();
                String senhas = senha.getText();
                String emails = email.getText();
                String cpfs = cpf.getText();
                String dataNascs = dataNasc.getText();

              
             if(insert.CadastrarUsuarioFrame(nomes, senhas, emails, cpfs, dataNascs)){
                JOptionPane.showMessageDialog(CadastroLogin.this,
                "Dados validos",
                "Cadastro feito com sucesso",
                JOptionPane.INFORMATION_MESSAGE);
            }
            else 
            {
                JOptionPane.showMessageDialog(CadastroLogin.this,
                "Cadastro não conforme, verifique as infomações",
                "Cadastro não realizado",
                JOptionPane.ERROR_MESSAGE);
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

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 2, 10, 0));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        buttonsPanel.add(cadastrar);
        buttonsPanel.add(btnVoltar);

        add(formPanel, BorderLayout.NORTH);
       // add(cadastrar, BorderLayout.SOUTH);
       add(buttonsPanel, BorderLayout.SOUTH);


        setTitle("dashboard");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
         setSize(1100, 650);
        setLocationRelativeTo(null);
        setVisible(true);
        
    }

}

