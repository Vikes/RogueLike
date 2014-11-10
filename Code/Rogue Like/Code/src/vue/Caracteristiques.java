package vue;

import controleur.Partie;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Caracteristiques extends JPanel {
    
    private int force;
    private int nbEnnemis;
    private int gold;
    private int niveauAct;
    private JLabel lblForce=new JLabel("Force :"+this.getForce());
    private JLabel lblNiveau=new JLabel("Vous �tes au niveau :"+this.getNiveauAct());
    private JLabel lblGold=new JLabel("Vous avec  :"+this.getGold()+" pi�ces d'or");
    private JLabel lblNbEnnemis=new JLabel("Il reste :"+this.getNbEnnemis()+" dans la salle");
    

    public Caracteristiques(){
        
       super(new GridLayout (1,4,1,5));
       
        int carac[]=getCaracteristique();
        this.add(lblForce);
        this.add(lblGold);
        this.add(lblNiveau);
        this.add(lblNbEnnemis);
        
    }
    public int[] getCaracteristique() {
        int [] carac = new int[4];
        carac[0] = Partie.getInstance().getPersonnage().getForcePersonnage();
        carac[1] = Partie.getInstance().getSalleActu().getMonstres();
        carac[2] = Partie.getInstance().getPersonnage().getArgentPersonnage();
        carac[3] = Partie.getInstance().getSalleActu().getNiveau();
        
        return carac;
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
}