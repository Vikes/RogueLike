package metier;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

public class Salle {

    private int niveau;
    private int longueur;
    List<Case> lstCase;
    Escalier escalier;

    /**
     * @param largeur
     * @param longueur
     * @param niveau
     * @return
     */
    public Salle (int longueur, int niveau) {
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
                if (c.getElement()!=null && c.getElement().getType() == "Monstre") {
                    res += 1;
                }
        }
        return res;

    }

    public int getOr() {
        int res = 0;
        int i = 0;
        for (Case c : lstCase) {
                 if (c.getElement()!=null && c.Element.getType() == "Trésor") {
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

    public void setEscalier(Escalier endEscalier) {
        this.escalier = endEscalier;
    }

    public Escalier getEscalier() {
        return escalier;
    }

    public void setLstCase(List<Case> lstCase) {
        this.lstCase = lstCase;
    }
    
    public List<Case> getLstCase() {
        return lstCase;
    }
    
    public Case getCase(int X, int Y) {
        boolean trouve = false;
        int i =0;
        Case res = new Case(0,0);
        while(trouve==false && i<this.getLstCase().size()) {
            if(this.getLstCase().get(i).getPositionX()==X) {
                if(this.getLstCase().get(i).getPositionY()==Y) {
                    res = this.getLstCase().get(i);
                    trouve= true;
                }
                else{
                    i++;
                }
            }
            else {
                i+=this.getLongueur();
            }
        }
        //System.out.println("Position dans la liste : "+i);
        return res;
    }
    
    public void vision(int X,int Y) {
        Case vu = this.getCase(X,Y);
        int i,j;
        for(i=-1;i<2;i++) {
            for(j=-1;j<2;j++) {
               // System.out.println("Pour la case X : "+(X+i)+" Y : "+(Y+j));
                if((X+i<-1||X+i>=this.getLongueur()||Y+j<-1||Y+j>=this.getLongueur())) {
                  //  System.out.println("Hors limite case X : "+(X+i)+" Y : "+(Y+j));
                }
                else {
                    this.getCase(X+i,Y+j).setVue(true);
                }
            }
        }
    }
}
