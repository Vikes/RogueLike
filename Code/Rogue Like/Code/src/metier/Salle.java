package metier;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

public class Salle {

    private int niveau;
    private int longueur;
    List<Case> lstCase;
    Escalier endEscalier;

    /**
     * @param largeur
     * @param longueur
     * @param niveau
     * @return
     */
    public Salle(int longueur, int niveau) {
        this.longueur = longueur;
        this.niveau = niveau;
        lstCase = new ArrayList<Case>();
    }

    /**
     * @associates <{modelisation.Case}>
     */


    public int getMonstres() {
        int res = 0;
        int i;
        for (Case c : lstCase) {
                if (c.Element.getType() == "Monstre") {
                    res += 1;
                }
        }
        return res;

    }

    public int getOr() {
        int res = 0;
        int i = 0;
        for (Case c : lstCase) {
                 if (c.Element.getType() == "Trésor") {
                    Tresor t = (Tresor) c.Element.getElement();
                    res += t.getArgentTresor();
                }
        }

        return res;
    }
    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }
    public int getNiveau() {
        return niveau;
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }

    public int getLongueur() {
        return longueur;
    }

    public void setEndEscalier(Escalier endEscalier) {
        this.endEscalier = endEscalier;
    }

    public Escalier getEndEscalier() {
        return endEscalier;
    }

    public void setLstCase(List<Case> lstCase) {
        this.lstCase = lstCase;
    }
    public List<Case> getLstCase() {
        return lstCase;
    }
}
