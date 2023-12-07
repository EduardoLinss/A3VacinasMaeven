package demo.Frames.alerta;

import javax.swing.*;

import demo.DAO.DAOalerta;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cadastrarAlerta extends JFrame{

    JTextField NomeVacina;
    JTextField DataProxAplic;
    

    

    public void CadastrarAlerta(){

        JLabel lbnomeVacina = new JLabel("Vacina");
        NomeVacina = new JTextField();
       

        JLabel lbdataAplic = new JLabel("Data de aplicacao");
        DataProxAplic = new JTextField();

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0, 1, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        formPanel.setBounds(100, 300, 300, 100);
        formPanel.add(lbnomeVacina);
        formPanel.add(NomeVacina);
        formPanel.add(lbdataAplic);
        formPanel.add(DataProxAplic);

        JButton btncadastar = new JButton("Salvar");
        btncadastar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                DAOalerta alerta = new DAOalerta();
                String nomeVacina = NomeVacina.getText();
               String dataAplic = DataProxAplic.getText();

               alerta.CadastraAlertaFrame(nomeVacina, dataAplic);

            }
            
        });

        JButton btnEditar = new JButton("Editar notificacao");
        btnEditar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
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
        buttonsPanel.add(btncadastar);
        buttonsPanel.add(btnVoltar);


        add(formPanel, BorderLayout.NORTH);
        add(buttonsPanel, BorderLayout.SOUTH);


        setTitle("dashboard");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(1100, 650);
        setLocationRelativeTo(null);
        setVisible(true);

    }

}
