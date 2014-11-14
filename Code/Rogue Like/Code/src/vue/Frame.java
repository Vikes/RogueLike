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
import metier.Message;
import metier.Tresor;

public class Frame extends JFrame {
    private Partie Partie;
    private Caracteristiques Caracteristques;
    private Message Message;
    private Perception endPerception;
    private Saisie saisie;
    private Carte carte;
    private Option Option;

    public Frame() {
        this.Partie = new Partie();
        JPanel jplPrincipal = new JPanel(new BorderLayout());
        Caracteristiques glCarac = new Caracteristiques();
        carte = new Carte();
        final Saisie saisie = new Saisie();
        jplPrincipal.add(glCarac, BorderLayout.SOUTH);
        List<Case> lstCase=this.Partie.getSalleActu().getLstCase();
        System.out.println("Taille de la salle : " + this.Partie.getSalleActu().getLongueur());
        carte.setCarteText(lstCase); 
        jplPrincipal.add(carte, BorderLayout.CENTER);
        jplPrincipal.add(saisie, BorderLayout.NORTH);  
        this.setTitle("Rogue Like");
        this.setContentPane(jplPrincipal);
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        saisie.getTfDeplacement().addKeyListener(new KeyListener(){
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==90||e.getKeyCode()==81||e.getKeyCode()==83||e.getKeyCode()==68){
                    saisie.getTfDeplacement().setText(""+e.getKeyChar());
                    touche(e.getKeyChar());
                }
            }
            public void keyTyped(KeyEvent e){
            
            }
            public void keyReleased(KeyEvent e) {
                
            }
        });   
    }
    
    public void touche(char c){
        this.getPartie().mouvement(c);
        carte.setCarteText(this.Partie.getSalleActu().getLstCase());
        if(this.getPartie().getPersonnage().getCase() instanceof Escalier) {
            Perception perc=new Perception();
            Escalier esca=(Escalier)this.getPartie().getPersonnage().getCase();
            Integer orEsca=esca.getOr();
            Integer forceMonstre=esca.getMonstres();
            if(perc.showPerception(forceMonstre,orEsca)==0) {
                System.out.println("Salle précédente "+this.getPartie().getSalleActu().hashCode());
                this.getPartie().changersalle();            
                System.out.println("Salle actuelle "+this.getPartie().getSalleActu().hashCode());
                this.getPartie().getSalleActu().vision(this.getPartie().getPersonnage().getCase().getPositionX(),this.getPartie().getPersonnage().getCase().getPositionY());
                carte.setCarteText(this.Partie.getSalleActu().getLstCase());
            }
            else
            {
                    
            }
        }
        
        
    }
    
    
    
    public void setPartie(Partie Partie) {
        this.Partie = Partie;
    }

    public Partie getPartie() {
        return Partie;
    }

    public static void main(String[] args) {
        Frame f = new Frame();
        f.setVisible(true);
    }
}
