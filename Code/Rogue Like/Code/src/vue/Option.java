package vue;

import controleur.Partie;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import metier.Case;

public class Option extends JDialog {
    /**Classe de création du JDialog de séléction des options et de lancement du jeu*/

    JLabel lblProfMax = new JLabel("La profondeur maximum de votre souterrain : ");
    JLabel lblNomPerso = new JLabel("Le nom de votre personnage : ");
    
    public JTextField tfProfMax = new JTextField(5);
    public JTextField tfNomPerso = new JTextField(5);
   
    
    public Option(final Frame frame){
        JPanel jpOption = new JPanel(new GridLayout(6,5));
        this.setContentPane(jpOption);
        JButton jbOk=new JButton();
        jbOk.setText("Ok");
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        jpOption.add(lblProfMax);
        jpOption.add(tfProfMax);       
        jpOption.add(lblNomPerso);
        jpOption.add(tfNomPerso);
        jpOption.add(jbOk);
        
        jbOk.addActionListener(new ActionListener() {
                 public void actionPerformed(ActionEvent e) {
                    confirmer(frame); 
                 }
              });
        
        this.setModal(true);
        this.setTitle("Réglage de lancement du Rogue Like");
        this.setSize(600, 500);
        this.setVisible(true);
        
    }


    public JTextField getTfProfMax() {
        return tfProfMax;
    }
/**
 * Méthode appelée lors de la confirmation des options de lancement du jeu
 * s'opérant avec un jeu de tests sur les champs
 * */
    public void confirmer(Frame frame){
        if(tfProfMax.getText().length()==0 || tfNomPerso.getText().length()==0 )
        {
            JOptionPane alert = new JOptionPane();
            alert.showMessageDialog(null, " Attention champs vide ! "," Erreur ! ",
            JOptionPane.ERROR_MESSAGE);
           
        }
        else{  
                System.out.println(tfProfMax.getText());
                System.out.println(tfNomPerso.getText());
                
            }
    }

}
