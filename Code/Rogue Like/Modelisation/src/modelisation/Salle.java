package modelisation;

import java.util.Collection;

public class Salle {
   
    private int largeur;
    private int niveau;
    private int longueur;
    Case  lstCase[];
    Escalier endEscalier;

    /**
     * @param largeur
     * @param longueur
     * @param niveau
     * @return
     */
    public  Salle(int largeur ,int longueur, int  niveau) {
        this.largeur = largeur;
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
                res+=c.Element.getElement().getArgentMonstre();
            }
            else if (c.Element.getType()=="Trésor") {
                res+=c.Element.getElement().getArgentTresor();
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
}
