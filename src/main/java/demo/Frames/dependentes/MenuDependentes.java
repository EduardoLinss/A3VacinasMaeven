package demo.Frames.dependentes;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import demo.DAO.DAOdependentes;
import demo.entidade.dependentes;

public class MenuDependentes extends JFrame {

    JTextField nome;
    JTextField cpf;
    JTextField idade;
    public void cadastra(){

       
        JLabel lbnome = new JLabel("Nome");
        nome = new JTextField();
       

        JLabel lbcpf = new JLabel("Cpf");
        cpf = new JTextField();

        JLabel lbidade = new JLabel("idade");

        idade = new JTextField();

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0, 1, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        formPanel.setBounds(100, 300, 300, 100);
        formPanel.add(lbnome);
        formPanel.add(nome);
        formPanel.add(lbcpf);
        formPanel.add(cpf);
        formPanel.add(lbidade);
        formPanel.add(idade);

        JButton cadastrar = new JButton("Cadastrar");

        cadastrar.addActionListener(new ActionListener() {

            @Override
            
            public void actionPerformed(ActionEvent e) {
           
            DAOdependentes pessoas = new DAOdependentes();
            
            String nomes = nome.getText();
            String cpfs = cpf.getText();
            String idades = idade.getText();
        
            pessoas.CadastraDependentess(nomes, cpfs, idades);

      
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
        add(buttonsPanel, BorderLayout.SOUTH);


        setTitle("dashboard");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(1100, 650);
        setLocationRelativeTo(null);
        setVisible(true);
        
    }

    public void consultaDependentes(){
            JPanel infos = new JPanel();
           
  
        try {


            
            for (dependentes u : DAOdependentes.consultaDependentes()) {
                infos.setLayout(new GridLayout(5, 2, 5, 5));
               infos.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
                infos.add(new JLabel("Nome"));
                infos.add(new JLabel(u.getNome()));
                infos.add(new JLabel("Cpf"));
                infos.add(new JLabel(u.getCpf()));
                infos.add(new JLabel("Idade"));
                infos.add(new JLabel(u.getIdade()));

                
               
                Component[] labels = infos.getComponents();
                for (int i = 0; i < labels.length; i++) {
                    labels[i].setFont(new Font("Arial", Font.BOLD, 18));
                   
               }
                
            }
        } catch (Exception e1) {
           
            e1.printStackTrace();
        }
        
        //add(infos, BorderLayout.NORTH );
        add(infos);
       

        setTitle("dashboard");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
         setSize(1100, 650);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    
}