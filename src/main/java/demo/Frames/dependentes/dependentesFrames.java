package demo.Frames.dependentes;
import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class dependentesFrames extends JFrame {
   
   
    public void iniciaDependentes(){
    
   
    //JPanel infos = new JPanel();
    

    JButton btnVerDependentes = new JButton("Ver Dependentes");
   
    btnVerDependentes.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
       
        MenuDependentes consulta = new MenuDependentes();
        consulta.consultaDependentes();
        
     

}
    });

    JButton btnCadastraDependentes = new JButton("Cadastrar dependentes");
  
    btnCadastraDependentes.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
        MenuDependentes cadastra = new MenuDependentes();
        cadastra.cadastra();
        dispose();
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
    buttonsPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
    buttonsPanel.setBackground(Color.YELLOW);
    buttonsPanel.add(btnVerDependentes);
    buttonsPanel.add(btnCadastraDependentes);
    buttonsPanel.add(btnVoltar);


    //add(infos, BorderLayout.NORTH);
    add(buttonsPanel, BorderLayout.SOUTH);

    
     setTitle("dashboard");
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
     setSize(1100, 650);
    setLocationRelativeTo(null);
    setVisible(true);
    }
    
}
