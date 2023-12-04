package demo.Frames;
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
import javax.swing.WindowConstants;

import demo.DAO.DAOubs;
import demo.entidade.ubs;

public class ubsFrame extends JFrame {
   // final private Font mainFont = new Font("Segoe print", Font.BOLD, 18);

    public void iniciarUbs(){
         JPanel infos = new JPanel();
       // ubs ubs = new ubs();
      // DAOubs ubs = new DAOubs();

       for (ubs u : DAOubs.getUbs()) {
        infos.setLayout(new GridLayout(0, 4, 5, 5));
        infos.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        infos.add(new JLabel("Endereco"));
        infos.add(new JLabel(u.getEndereco()));
        infos.add(new JLabel("cep"));
        infos.add(new JLabel(u.getCep()));

        Component[] labels = infos.getComponents();
        for (int i = 0; i < labels.length; i++) {
            labels[i].setFont(new Font("Segoe print", Font.BOLD, 18));

       }
        
    } 

    JButton btnVoltar = new JButton();
    btnVoltar.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        dispose();
      }
      
    });

    add(infos, BorderLayout.NORTH);
    add(btnVoltar, BorderLayout.SOUTH);
    
     setTitle("dashboard");
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
     setSize(1100, 650);
    setLocationRelativeTo(null);
    setVisible(true);
}


}
