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
    JLabel lblProbEsca = new JLabel("La probabilité de générer un escalier : ");
    JLabel lblProbMonstre = new JLabel("La probabilité de générer un monstre : ");
    JLabel lblProbTresor = new JLabel("La probabilité de générer un trésor : ");
    JLabel lblProbPotion = new JLabel("La probabilité de générer une potion : ");
    public JTextField tfProfMax = new JTextField(5);
    JTextField tfProbEsca = new JTextField(5);
    JTextField tfProbMonstre = new JTextField(5);
    JTextField tfProbTresor = new JTextField(5);
    JTextField tfProbPotion = new JTextField(5);
    
    public Option(final Frame frame){
        JPanel jpOption = new JPanel(new GridLayout(6,5));
        this.setContentPane(jpOption);
        JButton jbOk=new JButton();
        jbOk.setText("Ok");
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        jpOption.add(lblProfMax);
        jpOption.add(tfProfMax);
        jpOption.add(lblProbEsca);
        jpOption.add(tfProbEsca);
        jpOption.add(lblProbMonstre);
        jpOption.add(tfProbMonstre);
        jpOption.add(lblProbTresor);
        jpOption.add(tfProbTresor);
        jpOption.add(lblProbPotion);
        jpOption.add(tfProbPotion);
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
        if(tfProfMax.getText().length()==0 || tfProbEsca.getText().length()==0 || tfProbMonstre.getText().length()==0 ||tfProbTresor.getText().length()==0 ||tfProbPotion.getText().length()==0 )
        {
            JOptionPane alert = new JOptionPane();
            alert.showMessageDialog(null, " Attention champs vide ! "," Erreur ! ",
            JOptionPane.ERROR_MESSAGE);
           
        }
        else{  
                System.out.println(tfProfMax.getText());
                System.out.println(tfProbEsca.getText());
                System.out.println(tfProbMonstre.getText());
                System.out.println(tfProbTresor.getText());
                System.out.println(tfProbPotion.getText());
            }
    }

}
