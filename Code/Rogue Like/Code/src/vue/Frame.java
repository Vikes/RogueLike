package vue;

import controleur.Partie;

import vue.Perception;

import java.awt.BorderLayout;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JPanel;

import metier.Case;
import metier.Escalier;
import metier.Tresor;

public class Frame extends JFrame {
    private Partie partie;
    private Caracteristiques carac;
    private Message message;
    private Perception endPerception;
    private Saisie saisie;
    private Carte carte;
    private Option Option;

    public Frame() {
        this.partie = new Partie();
        JPanel jplPrincipal = new JPanel(new BorderLayout());
        carac = new Caracteristiques();
        carte = new Carte();
        message = new Message();
        final Saisie saisie = new Saisie();
        jplPrincipal.add(carac, BorderLayout.EAST);
        jplPrincipal.add(message,BorderLayout.SOUTH);
        List<Case> lstCase = this.partie.getSalleActu().getLstCase();
        System.out.println("Taille de la salle : " + this.partie.getSalleActu().getLongueur());
        carte.setCarteText(lstCase);
        jplPrincipal.add(carte, BorderLayout.CENTER);
        jplPrincipal.add(saisie, BorderLayout.NORTH);
        this.setTitle("Rogue Like");
        this.setContentPane(jplPrincipal);
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getCarac().update();
        saisie.getTfDeplacement().addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 90 || e.getKeyCode() == 81 || e.getKeyCode() == 83 || e.getKeyCode() == 68) {
                    saisie.getTfDeplacement().setText("" + e.getKeyChar());
                    touche(e.getKeyChar());
                }
            }

            public void keyTyped(KeyEvent e) {

            }

            public void keyReleased(KeyEvent e) {

            }
        });
    }

    public void touche(char c) {
        if(!this.getPartie().getFinie()&&this.getPartie().getPersonnage().getEnVie())
        {
            String res = this.getPartie().mouvement(c);
            carte.setCarteText(this.partie.getSalleActu().getLstCase());
            if(res == "salle") {
                Escalier esca = (Escalier) this.getPartie().getPersonnage().getCase();
                Integer orEsca = esca.getOr();
                Integer forceMonstre = esca.getMonstres();
                if (new Perception().showPerception(forceMonstre, orEsca) == 0) {
                    this.getPartie().changersalle();
                    carte.setCarteText(this.partie.getSalleActu().getLstCase());
                    res = "Vous changez de salle";
                }
                else {
                    res = "";
                }
            }
            this.getCarac().update();
            this.getMessage().setMessage(res);
            if(this.getPartie().getFinie()) {
                //popup gg
            }
            if(!this.getPartie().getPersonnage().getEnVie()) {
                //popup dead
            }
        }


    }


    public void setCarac(Caracteristiques carac) {
        this.carac = carac;
    }

    public Caracteristiques getCarac() {
        return carac;
    }

    public void setPartie(Partie Partie) {
        this.partie = Partie;
    }

    public Partie getPartie() {
        return partie;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Message getMessage() {
        return message;
    }

    public static void main(String[] args) {
        Frame f = new Frame();
        f.setVisible(true);
    }
}
