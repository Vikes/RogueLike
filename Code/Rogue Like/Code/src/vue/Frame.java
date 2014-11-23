package vue;

import controleur.Partie;

import vue.Perception;

import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import metier.Case;
import metier.Escalier;
import metier.Tresor;

public class Frame extends JFrame {
    
    private Partie partie;
    private Caracteristiques carac;
    private Message message;
    private Saisie saisie;
    private Carte carte;
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menu = new JMenu("Menu");
    private JMenuItem nouveau = new JMenuItem("Lancer une nouvelle partie");
    private JMenuItem score = new JMenuItem("Records");
    
    

    public Frame() {
        JPanel jplPrincipal = new JPanel(new BorderLayout());
        carac = new Caracteristiques();
        carte = new Carte();
        saisie = new Saisie();
        message = new Message();
        this.partie = new Partie();
        this.menu.add(nouveau);
        this.menu.add(score);
        this.menuBar.add(menu);
        this.setJMenuBar(menuBar);
        
        this.nouveau.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                Option option = new Option(this);
                System.out.println("Coucou " + option.getTfProfMax().getText());
            }
        });
        jplPrincipal.add(carac, BorderLayout.EAST);
        jplPrincipal.add(message,BorderLayout.SOUTH);
        jplPrincipal.add(carte, BorderLayout.CENTER);
        jplPrincipal.add(saisie, BorderLayout.NORTH);;
        
    
        List<Case> lstCase = this.partie.getSalleActu().getLstCase();
        carte.setCarteText(lstCase);
        
        this.setTitle("Rogue Like");
        this.setContentPane(jplPrincipal);
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getCarac().update();
        saisie.getTfDeplacement().addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 90 || e.getKeyCode() == 81 || e.getKeyCode() == 83 || e.getKeyCode() == 68) {
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
        System.out.println(c);
        if(!this.getPartie().getFinie()&&this.getPartie().getPersonnage().getEnVie())
        {
            this.getSaisie().getTfDeplacement().setText("");
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
                JOptionPane gg = new JOptionPane();
                gg.showMessageDialog(null, " Félicitation ! Vous avez gagné ! "," Victoire ! ",
                JOptionPane.INFORMATION_MESSAGE);
            }
            if(!this.getPartie().getPersonnage().getEnVie()) {
                JOptionPane die = new JOptionPane();
                die.showMessageDialog(null, " Dommage, vous avez perdu ! "," Défaite ! ",
                JOptionPane.INFORMATION_MESSAGE);
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

    public void setSaisie(Saisie saisie) {
        this.saisie = saisie;
    }

    public Saisie getSaisie() {
        return saisie;
    }

    public static void main(String[] args) {
        Frame f = new Frame();
        f.setVisible(true);
    }
    

}
