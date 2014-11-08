package vue;

import controleur.Partie;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JPanel;

import metier.Message;

public class Frame extends JFrame {
    Partie Partie;
    Caracteristiques Caracteristques;
    Message Message;
    Perception endPerception;
    Saisie Saisie;
    Carte Carte;
    Option Option;


    private JPanel jplPrincipal = new JPanel(new BorderLayout());
    private Caracteristiques glCarac = new Caracteristiques();
    private Carte glCarte = new Carte();
    private Saisie saisie = new Saisie();
    

    public Frame() {
        
        jplPrincipal.add(glCarac, BorderLayout.EAST);
        jplPrincipal.add(glCarte, BorderLayout.WEST);
        jplPrincipal.add(saisie, BorderLayout.NORTH);
        
                
                
        this.setTitle("Rogue Like");
        this.setContentPane(jplPrincipal);
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
}
