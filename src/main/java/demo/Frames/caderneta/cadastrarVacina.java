package demo.Frames.caderneta;
import java.awt.BorderLayout;
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

import demo.DAO.DAOcaderneta;


public class cadastrarVacina extends JFrame {
    JTextField nomeVacinaField;
    JTextField dataAplicField;
    JTextField doseField;
    JTextField localField;
    JTextField cidadeField;


    public void cadastrarVacinas(){
        JLabel lbnomeVacina = new JLabel("Vacina");
        nomeVacinaField = new JTextField();
       

        JLabel lbdataAplic = new JLabel("Data de aplicacao");
        dataAplicField = new JTextField();

        JLabel lbdose = new JLabel("Dose");
        doseField = new JTextField();

         JLabel lblocal = new JLabel("Local");
        localField = new JTextField();

         JLabel lbcidade = new JLabel("Cidade");
        cidadeField = new JTextField();


        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0, 1, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        formPanel.setBounds(100, 300, 300, 100);
        formPanel.add(lbnomeVacina);
        formPanel.add(nomeVacinaField);
        formPanel.add(lbdataAplic);
        formPanel.add(dataAplicField);
        formPanel.add(lbdose);
        formPanel.add(doseField);
        formPanel.add(lblocal);
        formPanel.add(localField);
        formPanel.add(lbcidade);
        formPanel.add(cidadeField);

        
        JButton btncadastrarVacina = new JButton("Cadastrar");
        btncadastrarVacina.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               DAOcaderneta CadastraVacina = new DAOcaderneta();

               String nomeVacina = nomeVacinaField.getText();
               String dataAplic = dataAplicField.getText();
               String dose = doseField.getText();
               String local = localField.getText();
               String cidade = cidadeField.getText();

               CadastraVacina.CadastraVacinasFrame(nomeVacina, dataAplic, dose, local, cidade);

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
        buttonsPanel.add(btncadastrarVacina);
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
