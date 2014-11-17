package vue;

import controleur.Partie;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;


public class Caracteristiques extends JPanel {
    
    private int force;
    private int nbEnnemis;
    private int gold;
    private int niveauAct;
    private JLabel lblForce = new JLabel("Vous avez :" + this.getForce() + " points de force");
    private JLabel lblGold = new JLabel("Vous avez  :" + this.getGold() + " pièces d'or");
    private JLabel lblNbEnnemis = new JLabel("Il reste :" + this.getNbEnnemis() + " ennemis dans la salle");
    private JLabel lblNiveau = new JLabel("Vous êtes au niveau :" + this.getNiveauAct());


    public Caracteristiques(){
        
       super(new GridLayout (4,1,1,5));
        Border line = BorderFactory.createLineBorder(Color.DARK_GRAY);
        Border empty = new EmptyBorder(10, 10, 10, 10);
        CompoundBorder border = new CompoundBorder(line, empty);
        this.setBorder(border);
        
        int carac[]=getCaracteristique();
        this.add(lblForce);
        this.add(lblGold);
        this.add(lblNiveau);
        this.add(lblNbEnnemis);
        
    }
    public int[] getCaracteristique() {
        int [] carac = new int[4];
        carac[0] = Partie.getInstance().getPersonnage().getForcePersonnage();
        carac[1] = Partie.getInstance().getPersonnage().getArgentPersonnage();
        carac[2] = Partie.getInstance().getSalleActu().getMonstres();
        carac[3] = Partie.getInstance().getSalleActu().getNiveau();
        
        return carac;
    }
    
    public void update() {
            int[] carac = this.getCaracteristique();
            this.setForce(carac[0]);
            this.setGold(carac[1]);
            this.setNbEnnemis(carac[2]);
            this.setNiveauAct(carac[3]);
            this.getLblForce().setText("Vous avez :" + this.getForce() + " points de force");
            this.getLblGold().setText("Vous avez  :" + this.getGold() + " pièces d'or");
            this.getLblNbEnnemis().setText("Il reste :" + this.getNbEnnemis() + " ennemis dans la salle");
            this.getLblNiveau().setText("Vous êtes au niveau :" + this.getNiveauAct());
        }

    public void setForce(int force) {
        this.force = force;
    }

    public int getForce() {
        return force;
    }

    public int getNbEnnemis() {
        return nbEnnemis;
    }

    public int getGold() {
        return gold;
    }

    public int getNiveauAct() {
        return niveauAct;
    }

    public void setNbEnnemis(int nbEnnemis) {
        this.nbEnnemis = nbEnnemis;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setNiveauAct(int niveauAct) {
        this.niveauAct = niveauAct;
    }
    
    public void setLblForce(JLabel lblForce) {
           this.lblForce = lblForce;
       }

       public JLabel getLblForce() {
           return lblForce;
       }

       public void setLblGold(JLabel lblGold) {
           this.lblGold = lblGold;
       }

       public JLabel getLblGold() {
           return lblGold;
       }

       public void setLblNbEnnemis(JLabel lblNbEnnemis) {
           this.lblNbEnnemis = lblNbEnnemis;
       }

       public JLabel getLblNbEnnemis() {
           return lblNbEnnemis;
       }

       public void setLblNiveau(JLabel lblNiveau) {
           this.lblNiveau = lblNiveau;
       }

       public JLabel getLblNiveau() {
           return lblNiveau;
       }
}
