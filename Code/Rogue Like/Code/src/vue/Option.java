package vue;

import controleur.Partie;

import java.awt.BorderLayout;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JTextField;

import metier.Case;

public class Option extends JFrame {
    
    public Option(){


        JFrame jfOption = new JFrame();
        JPanel jpOption = new JPanel(new GridLayout(5,5));
        this.setContentPane(jpOption);
        JButton jbOk=new JButton();
       

        JLabel lblProfMax = new JLabel("La profondeur maximum de votre souterrain : ");
        JLabel lblProbEsca = new JLabel("La probabilité de générer un escalier : ");
        JLabel lblProbMonstre = new JLabel("La probabilité de générer un monstre : ");
        JLabel lblProbTresor = new JLabel("La probabilité de générer un trésor : ");
        JLabel lblProbPotion = new JLabel("La probabilité de générer une potion : ");
        JTextField tfProfMax = new JTextField(5);
        JTextField tfProbEsca = new JTextField(5);
        JTextField tfProbMonstre = new JTextField(5);
        JTextField tfProbTresor = new JTextField(5);
        JTextField tfProbPotion = new JTextField(5);


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

        this.setTitle("Réglage de lancement du Rogue Like");
        this.setSize(600, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        jbOk.addActionListener(new ActionListener() {
                 public void actionPerformed(ActionEvent e) {
                    
                 }
              });

    }
     public static  void main(String[] args) {
         System.out.println("tortue");
            Option f = new Option();
            f.setVisible(true);
     }
}
