package metier;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

public class Salle {
    /** Classe repr�sentant les salles du jeu */
    private int niveau;//Niveau dans lequel se situe la salle 
    private int longueur;//Longueur de la salle
    List<Case> lstCase;//Liste des cases de la salle
    Escalier escalier;//Escalier menant � cette salle

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
     * M�thode renvoyant le nombre de monstres pr�sents dans la salle 
     * @return Monstres pr�sents dans la salle
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
     * M�thode renvoyant l'or pr�sent dans la salle 
     * @return Or pr�sent dans la salle
     */
    public int getOr() {
        int res = 0;
        int i = 0;
        for (Case c : lstCase) {
                 if (c.getElement()!=null && c.Element.getType() == "Tr�sor") {
                    Tresor t = (Tresor) c.Element.getElement();
                    res += t.getArgentTresor();
                }
        }

        return res;
    }
    /**
     * M�thode qui modifie le niveau de la salle 
     * @param Niveau de la salle
     */
    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }
    /**
     * M�thode renvoyant le niveau de la salle 
     * @return Niveau de la salle
     */
    public int getNiveau() {
        return niveau;
    }
    /**
     * M�thode qui modifie la longueur de la salle 
     * @param Longueur de la salle
     */
    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }
    /**
     * M�thode renvoyant la longueur de la salle  
     * @return Longueur de la salle
     */
    public int getLongueur() {
        return longueur;
    }
    /**
     * M�thode qui l'escalier menant � cette salle 
     * @param Escalier menant � cette salle 
     */
    public void setEscalier(Escalier endEscalier) {
        this.escalier = endEscalier;
    }
    /**
     * M�thode renvoyant l'escalier menant � cette salle 
     * @return Escalier menant � cette salle 
     */
    public Escalier getEscalier() {
        return escalier;
    }
    /**
     * M�thode qui modifie la liste des cases de la salle 
     * @param Liste des cases de la salle 
     */
    public void setLstCase(List<Case> lstCase) {
        this.lstCase = lstCase;
    }
    /**
     * M�thode renvoyant la liste des cases de la salle  
     * @return Liste des cases de la salle  
     */
    public List<Case> getLstCase() {
        return lstCase;
    }
    /**
     * M�thode renvoyant la case � la position X/Y si elle existe, null sinon
     * @return Case � la position X/Y
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
     * M�thode mettant le boolean vision � true pour les case adjacente � la case � la position XY
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
