package demo.Frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.BorderFactory;
import javax.swing.BoxLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import demo.Frames.alerta.alertaFrame;
import demo.Frames.caderneta.cadernetaFrame;
import demo.Frames.dependentes.dependentesFrames;
import demo.Frames.login.EditarCadastro;

import demo.Frames.requisicao.requisicaoFramePesquisa;
import demo.Frames.ubs.ubs;
import demo.Frames.vacinas.vacinasFrame;



public class MainFrame extends JFrame {
    final private Font mainFont = new Font("Arial", Font.BOLD, 18);

    JTextField txtUsuario;

  
  
   
    public  void iniciar (){
        
       
        JPanel info = new JPanel();
        info.setLayout(new GridLayout(0, 2, 5, 5));
        
        JLabel usuario = new JLabel("Usuario");
        txtUsuario = new JTextField("nfleduardo@gmail.com");
    


        info.add(txtUsuario);
        info.add(usuario);
        JLabel menuInfo = new JLabel("Menu", SwingConstants.CENTER);
        menuInfo.setFont(mainFont);

        JButton btnUbs = new JButton("Consultar UBS'S");
       btnUbs.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              ubs inicaUbs = new ubs();

             inicaUbs.inicia();
             

            } 
        });

        JButton btnrequisicao = new JButton("Vacinas em outros paises");
        btnrequisicao.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               /*  requisicaoFrame inicaReq = new requisicaoFrame();
                inicaReq.iniciarReq();*/

                requisicaoFramePesquisa chama = new requisicaoFramePesquisa();
                chama.pesquisar();
              
                
            }
            
        });

        JButton btnAlerta = new JButton("Próximas vácinas");
        btnAlerta.setBounds(10, 10, 10, 10);
        btnAlerta.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              alertaFrame iniciaAlerta = new alertaFrame();
              iniciaAlerta.iniciaAlerta();
              
            }
            
        });

        JButton btnDependentes = new JButton("Dependentes");
        btnDependentes.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dependentesFrames iniciaDependentes = new dependentesFrames();
                iniciaDependentes.iniciaDependentes();
                
            }
            
        });

        JButton btnCaderneta = new JButton("Caderneta");
        btnCaderneta.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            cadernetaFrame botaoCaderneta = new cadernetaFrame();
            botaoCaderneta.Caderneta();
            }

        });

        JButton btnVacinas = new JButton("Vacinas e seus tratamentos");
        btnVacinas.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               vacinasFrame botaoVacinas = new vacinasFrame();
               botaoVacinas.vacinasFrame();
            }
            
        });

        JButton btnEditarCadastro = new JButton("Editar Cadastro");
        btnEditarCadastro.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               EditarCadastro botaoEditarCadastro = new EditarCadastro();
               botaoEditarCadastro.EditarCadastro();
            }
            
        });
    
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridBagLayout());      
       // buttonsPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
       buttonsPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 35, 5));
        buttonsPanel.setBounds(10, 10, 30, 30);
        buttonsPanel.setBackground(Color.CYAN);
        buttonsPanel.add(btnUbs);
        buttonsPanel.add(btnrequisicao);
        buttonsPanel.add(btnAlerta);
        buttonsPanel.add(btnDependentes);
        buttonsPanel.add(btnCaderneta);
        buttonsPanel.add(btnVacinas);
        
       
        add(info, BorderLayout.NORTH);
        add(buttonsPanel, BoxLayout.X_AXIS);
        add(btnEditarCadastro, BorderLayout.NORTH);
        
    
       
     
        

        setTitle("dashboard");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(1100, 550);
        setBackground(Color.DARK_GRAY);
        setMinimumSize(new Dimension(350, 450));
        setLocationRelativeTo(null);
        setVisible(true);
    }


    

    



    
    
}
