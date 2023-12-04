package demo.Frames;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import demo.DAO.DAOalerta;
import demo.entidade.alerta;



public class alertaFrame extends JFrame {
    
    public void iniciaAlerta(){
         JPanel infos = new JPanel();
       // ubs ubs = new ubs();
      // DAOubs ubs = new DAOubs();

       for (alerta u : DAOalerta.consultaAlertas()) {
        infos.setLayout(new GridLayout(0, 2, 5, 5));
        infos.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        infos.add(new JLabel("Vacina"));
        infos.add(new JLabel(u.getNomeVacina()));
        infos.add(new JLabel("data de aplicacao"));
        infos.add(new JLabel(u.getDataProx()));

        Component[] labels = infos.getComponents();
        for (int i = 0; i < labels.length; i++) {
            labels[i].setFont(new Font("Segoe print", Font.BOLD, 18));

       }
        
    }   

    add(infos, BorderLayout.NORTH);
    
     setTitle("dashboard");
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
     setSize(1100, 650);
    setLocationRelativeTo(null);
    setVisible(true);
}

}

