package demo.Frames.requisicao;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import demo.DAO.DAOrequisicao;
import demo.entidade.requsicao;

public class requisicaoFrame extends JFrame {
    JTextField tfpesquisa;

    public void iniciarReq(){
        

         JPanel infos = new JPanel();   
           
           for (requsicao u : DAOrequisicao.getRequsicaos()) {
            infos.setLayout(new GridLayout(0, 2, 5, 5));
            infos.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
            infos.add(new JLabel("Pais"));
            infos.add(new JLabel(u.getnomePais()));
            infos.add(new JLabel("Vacinas necessárias"));
            infos.add(new JLabel(u.getVacinas()));

            Component[] labels = infos.getComponents();
            for (int i = 0; i < labels.length; i++) {
                labels[i].setFont(new Font("Segoe print", Font.BOLD, 18));

            }
    
            
            }
  
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(new ActionListener() {

         @Override
            public void actionPerformed(ActionEvent e) {
           
         
            dispose();
                
            }
        
        });

    JPanel buttonsPanel = new JPanel();
    buttonsPanel.setLayout(new GridLayout(1, 2, 10, 0));
    buttonsPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
    buttonsPanel.add(btnVoltar);
   

    //add(botaoDePesquisa, BorderLayout.SOUTH);
    add(infos, BorderLayout.NORTH);
    add(buttonsPanel, BorderLayout.SOUTH);
    //add(btnVoltar, BorderLayout.SOUTH);
    
     setTitle("dashboard");
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
     setSize(1100, 650);
    setLocationRelativeTo(null);
    setVisible(true);
    }

    
  

    
}
