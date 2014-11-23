package metier;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

public class Salle {
    /** Classe représentant les salles du jeu */
    private int niveau;//Niveau dans lequel se situe la salle 
    private int longueur;//Longueur de la salle
    List<Case> lstCase;//Liste des cases de la salle
    Escalier escalier;//Escalier menant à cette salle

     /**
      * Constructeur
      * @param Longueur de la salle
      * @param Niveau de la salle
      */
    public Salle (int longueur, int niveau) {
        this.longueur = longueur;
        this.niveau = niveau;
        lstCase = new ArrayList<Case>();
    }

    /**
     * Méthode renvoyant le nombre de monstres présents dans la salle 
     * @return Monstres présents dans la salle
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
    /**
     * Méthode renvoyant l'or présent dans la salle 
     * @return Or présent dans la salle
     */
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
    /**
     * Méthode qui modifie le niveau de la salle 
     * @param Niveau de la salle
     */
    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }
    /**
     * Méthode renvoyant le niveau de la salle 
     * @return Niveau de la salle
     */
    public int getNiveau() {
        return niveau;
    }
    /**
     * Méthode qui modifie la longueur de la salle 
     * @param Longueur de la salle
     */
    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }
    /**
     * Méthode renvoyant la longueur de la salle  
     * @return Longueur de la salle
     */
    public int getLongueur() {
        return longueur;
    }
    /**
     * Méthode qui l'escalier menant à cette salle 
     * @param Escalier menant à cette salle 
     */
    public void setEscalier(Escalier endEscalier) {
        this.escalier = endEscalier;
    }
    /**
     * Méthode renvoyant l'escalier menant à cette salle 
     * @return Escalier menant à cette salle 
     */
    public Escalier getEscalier() {
        return escalier;
    }
    /**
     * Méthode qui modifie la liste des cases de la salle 
     * @param Liste des cases de la salle 
     */
    public void setLstCase(List<Case> lstCase) {
        this.lstCase = lstCase;
    }
    /**
     * Méthode renvoyant la liste des cases de la salle  
     * @return Liste des cases de la salle  
     */
    public List<Case> getLstCase() {
        return lstCase;
    }
    /**
     * Méthode renvoyant la case à la position X/Y si elle existe, null sinon
     * @return Case à la position X/Y
     */
    public Case getCase(int X, int Y) {
        boolean trouve = false;
        int i =0;
        Case res = null;
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
    /**
     * Méthode mettant le boolean vision à true pour les case adjacente à la case à la position XY
     */
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
                    if(this.getCase(X+i,Y+j)!=null)
                    this.getCase(X+i,Y+j).setVue(true);
                }
            }
        }
    }
}
