package metier;

import java.util.Collection;

public class Salle {
   
    private int niveau;
    private int longueur;
    Case  lstCase[][];
    Escalier endEscalier;

    /**
     * @param largeur
     * @param longueur
     * @param niveau
     * @return
     */
    public  Salle(int longueur, int  niveau) {
        this.longueur = longueur;
        this.niveau = niveau; 
        
    }

    /**
     * @associates <{modelisation.Case}>
     */
    

    public int getMonstres() {
        int res=0;
        
        for ( Case c : lstCase) {
            if(c.Element.getType()== "Monstre" ){
                res+=1;
            }
        }
         return res;
              
    }

    public int getOr() {        
        int res=0;
        
        
        for ( Case c : lstCase) {
            if(c.Element.getType()== "Monstre" ){
                Monstre m = (Monstre) c.Element.getElement();
                res+=m.getArgentMonstre();
            }
            else if (c.Element.getType()=="Trésor") {
                Tresor t = (Tresor) c.Element.getElement();
                res+=t.getArgentTresor();
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


    public void setLstCase(Case[][] lstCase) {
        this.lstCase = lstCase;
    }

    public Case[][] getLstCase() {
        return lstCase;
    }
}
