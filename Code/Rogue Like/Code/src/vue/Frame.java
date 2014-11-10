package vue;

import controleur.Partie;

import java.awt.BorderLayout;

import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JPanel;

import metier.Case;
import metier.Message;
import metier.Tresor;

public class Frame extends JFrame {
    private Partie Partie;
    private Caracteristiques Caracteristques;
    private Message Message;
    private Perception endPerception;
    private Saisie Saisie;
    private Carte Carte;
    private Option Option;

    public Frame() {
        this.Partie = new Partie();
        JPanel jplPrincipal = new JPanel(new BorderLayout());
        Caracteristiques glCarac = new Caracteristiques();
        Carte glCarte = new Carte();
        Saisie saisie = new Saisie();
        jplPrincipal.add(glCarac, BorderLayout.EAST);
        List<Case> lstCase=this.Partie.getSalleActu().getLstCase();
        for (Case c : lstCase) {
                glCarte.add(new JLabel(""+c.getSymbole()));
        }        
        jplPrincipal.add(glCarte, BorderLayout.WEST);
        jplPrincipal.add(saisie, BorderLayout.NORTH);  
        this.setTitle("Rogue Like");
        this.setContentPane(jplPrincipal);
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    }
    
    public static void main(String[] args) {
        Frame f = new Frame();
        f.setVisible(true);
    }
}
