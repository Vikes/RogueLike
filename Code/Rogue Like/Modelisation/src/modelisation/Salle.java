package modelisation;

import java.util.Collection;

public class Salle {
   
    private int largeur;

    private int niveau;

    private int longueur;
    public  Salle Salle(int largeur ,int longueur, int  niveau) {
        this.largeur = largeur;
        this.longueur = longueur;
        this.niveau = niveau;        
    }

    /**
     * @associates <{modelisation.Case}>
     */
    Collection lstCase;
    Escalier endEscalier;

    public int getMonstres() {
     
    }

    public int getOr() {
    
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public int getNiveau() {
        return niveau;
    }
}
