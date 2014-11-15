package metier;

import java.util.List;
import java.util.ArrayList;

/** Classe représentant la génération progressive */

public class Progressif implements Generation {
    
    private int profMax;                //Profondeur maximum
    private int escalierMax;            //Nombre d'escaliers maximum par salle
    private int minCoffre=25;           //Contenu minimal d'un coffre à la profondeur maximale
    private int maxCoffre=50;           //Contenu maximum d'un coffre à la profondeur maximale
    private int minPot=-1;              //Contenu minimal d'une potion à la profondeur maximale
    private int maxPot=5;               //Contenu maximum d'une potion à la profondeur maximale
    private int minOrMonstre=25;        //Or minimal d'un monstre à la profondeur maximale
    private int minForceMonstre=1;      //Force minimale d'un monstre à la profondeur maximale
    private int maxOrMonstre=50;        //Or maximum d'un monstre à la profondeur maximale
    private int maxForceMonstre=5;      //Force maximum d'un monstre à la profondeur maximale
    private Double probEscalierGen;     //Probabilité de générer un escalier
    private Double probCoffreGen;       //Probabilité de générer un coffre
    private Double probPotGen;          //Probabilité de générer une potion
    private Double probMonsterGen=0.025;//Probabilité de générer un monstre
    private Double probSortieGen=0.05;  //Probabilité de générer une sortie
    private Boolean sortie;             //Boolean pour savoir si la sortie est déjà posée


    /**
     * Constructeur
     * @param profondeur max
     * @param probabilité de générer un escalier
     * @param nombre d'escalier maximum par salle
     * @param probabilité de génerer un coffre
     * @param probabilité de générer une potion
     */
    
    public Progressif(int profMax, Double probEscalierGen, int escalierMax, Double probCoffreGen, Double probPotGen) {
        super();
        this.profMax = profMax;
        this.probEscalierGen = probEscalierGen;
        this.escalierMax = escalierMax;
        this.probCoffreGen = probCoffreGen;
        this.probPotGen = probPotGen;
        this.sortie = false;
    }

    /**
     * Méthode qui modifie la probabilité de générer une sortie
     * @param probabilité générer une sortie
     */
    
    public void setProbSortieGen(Double probSortieGen) {
        this.probSortieGen = probSortieGen;
    }

    /**
     * Méthode renvoyant la probabilité de générer une sortie
     * @return probabilité générer une sortie
     */
    
    public Double getProbSortieGen() {
        return probSortieGen;
    }

    /**
     * Méthode qui modifie le boolean de sortie
     * @param boolean de sortie
     */
    
    public void setSortie(Boolean sortie) {
        this.sortie = sortie;
    }

    /**
     * Méthode qui renvoie le boolean de sortie
     * @return boolean de sortie
     */
    
    public Boolean getSortie() {
        return sortie;
    }

    /**
     * Méthode qui modifie la profondeur maximale
     * @param profondeur maximale
     */
    
    public void setProfMax(int profMax) {
        this.profMax = profMax;
    }
    
    /**
     * Méthode qui renvoie la profondeur maximale
     * @return profondeur maximale
     */
    
    public int getProfMax() {
        return profMax;
    }
    
    /**
     * Méthode qui modifie la probabilité de générer un escalier
     * @param probabilité escalier
     */
    
    public void setProbEscalierGen(Double probEscalierGen) {
        this.probEscalierGen = probEscalierGen;
    }
    
    /**
     * Méthode qui renvoie la probabilité de générer un escalier
     * @return probabilité escalier
     */

    public Double getProbEscalierGen() {
        return probEscalierGen;
    }

    /**
     * Méthode qui modifie le nombre d'escalier maximum par salle
     * @param nombre d'escalier
     */
    
    public void setEscalierMax(int escalierMax) {
        this.escalierMax = escalierMax;
    }

    /**
     * Méthode renvoyant la probabilité de générer une sortie
     * @return probabilité générer une sortie
     */
    
    public int getEscalierMax() {
        return escalierMax;
    }

    /**
     * Méthode qui modifie la probabilité de générer un coffre
     * @param probabilité coffre
     */
    
    public void setProbCoffreGen(Double probCoffreGen) {
        this.probCoffreGen = probCoffreGen;
    }

    /**
     * Méthode renvoyant la probabilité de générer un coffre
     * @return probabilité de générer un coffre
     */
    
    public Double getProbCoffreGen() {
        return probCoffreGen;
    }

    /**
     * Méthode qui modifie la valeur mininale d'un coffre à la profondeur maximale
     * @param valeur mininale d'un coffre
     */
    
    public void setMinCoffre(int minCoffre) {
        this.minCoffre = minCoffre;
    }

    /**
     * Méthode renvoyant la valeur mininale d'un coffre à la profondeur maximale
     * @return valeur mininale d'un coffre à la profondeur maximale
     */
    
    public int getMinCoffre() {
        return minCoffre;
    }
    
    /**
     * Méthode qui modifie la valeur maximale d'un coffre à la profondeur maximale
     * @param valeur maximale d'un coffre
     */
    
    public void setMaxCoffre(int maxCoffre) {
        this.maxCoffre = maxCoffre;
    }

    /**
     * Méthode renvoyant la valeur maximale d'un coffre à la profondeur maximale
     * @return valeur maximale d'un coffre à la profondeur maximale
     */
    
    public int getMaxCoffre() {
        return maxCoffre;
    }

    /**
     * Méthode qui modifie la probabilité de générer une potion 
     * @param probabilité potion
     */
    
    public void setProbPotGen(Double probPotGen) {
        this.probPotGen = probPotGen;
    }
    
    /**
     * Méthode renvoyant la probabilité de générer une potion
     * @return probabilité de générer une potion
     */

    public Double getProbPotGen() {
        return probPotGen;
    }

    /**
     * Méthode qui modifie la valeur minimale d'une potion à la profondeur maximale
     * @param valeur minimale d'une potion à la profondeur maximale
     */
    
    public void setMinPot(int minPot) {
        this.minPot = minPot;
    }
    
    /**
     * Méthode renvoyant la valeur minimale d'une potion à la profondeur maximale
     * @return valeur minimale d'une potion à la profondeur maximale
     */
    
    public int getMinPot() {
        return minPot;
    }
    
    /**
     * Méthode qui modifie la valeur maximale d'une potion à la profondeur maximale
     * @param valeur maximale d'une potion à la profondeur maximale
     */
    
    public void setMaxPot(int maxPot) {
        this.maxPot = maxPot;
    }
    
    /**
     * Méthode renvoyant la valeur maximale d'une potion à la profondeur maximale
     * @return valeur maximale d'une potion à la profondeur maximale
     */
    
    public int getMaxPot() {
        return maxPot;
    }

    /**
     * Méthode qui modifie la probabilité de générer un monstre
     * @param probabilité monstre
     */
    
    public void setProbMonsterGen(Double probMonsterGen) {
        this.probMonsterGen = probMonsterGen;
    }
        
    /**
     * Méthode renvoyant la probabilité de générer un monstre
     * @return probabilité monstre
     */

    public Double getProbMonsterGen() {
        return probMonsterGen;
    }
    
    /**
     * Méthode qui modifie la valeur minimale de l'or d'un monstre à la profondeur maximale
     * @param valeur minimale de l'or d'un monstre
     */
    
    public void setMinOrMonstre(int minOrMonstre) {
        this.minOrMonstre = minOrMonstre;
    }
    
    /**
     * Méthode renvoyant la valeur minimale de l'or d'un monstre à la profondeur maximale
     * @return valeur minimale de l'or d'un monstre à la profondeur maximale
     */

    public int getMinOrMonstre() {
        return minOrMonstre;
    }
    
    /**
     * Méthode qui modifie la valeur minimale de force d'un monstre à la profondeur maximale
     * @param valeur minimale de force d'un monstre
     */
    
    public void setMinForceMonstre(int minForceMonstre) {
        this.minForceMonstre = minForceMonstre;
    }

    /**
     * Méthode renvoyant la valeur minimale de force d'un monstre à la profondeur maximale
     * @return valeur minimale de force d'un monstre à la profondeur maximale
     */
    
    public int getMinForceMonstre() {
        return minForceMonstre;
    }
    
    /**
     * Méthode qui modifie la valeur maximale de l'or d'un monstre à la profondeur maximale
     * @param valeur maximale de l'or d'un monstre
     */
    
    public void setMaxOrMonstre(int maxOrMonstre) {
        this.maxOrMonstre = maxOrMonstre;
    }
    
    /**
     * Méthode renvoyant la valeur maximale de l'or d'un monstre à la profondeur maximale
     * @return valeur maximale de l'or d'un monstre
     */
    
    public int getMaxOrMonstre() {
        return maxOrMonstre;
    }

    /**
     * Méthode qui modifie la valeur maximale de force d'un monstre
     * @param valeur maximale de force d'un monstre
     */
    
    public void setMaxForceMonstre(int maxForceMonstre) {
        this.maxForceMonstre = maxForceMonstre;
    }
    
    /**
     * Méthode renvoyant la valeur maximale de force d'un monstre
     * @return valeur maximale de force d'un monstre
     */

    public int getMaxForceMonstre() {
        return maxForceMonstre;
    }
 
    /**
     * Méthode qui renvoie la case générée
     * @param positionX
     * @param positionY
     * @param profondeur maximale
     * @param nombre aléatoire
     * @return case avec élément
     */
    
    public Case genererCase(int i, int j,int pronf, double elem){
        Case c = new Case(i,j);
        //génération coffre
        if(elem<=(this.getProbEscalierGen()+this.getProbCoffreGen())) {
            int min = this.getMinCoffre()*2*(this.getProfMax()+1-pronf);
            int max = this.getMaxCoffre()*2*(this.getProfMax()+1-pronf);
            int contenu= (int)(Math.random() * (max-min)+min);
            Tresor t = new Tresor(contenu);
            c.setElement(t);
        }
        //génération potion
        else if(elem<=(this.getProbEscalierGen()+this.getProbCoffreGen()+this.getProbPotGen())) {
            int min = this.getMinPot()*2*(this.getProfMax()+1-pronf);
            int max = this.getMaxPot()*2*(this.getProfMax()+1-pronf);
            int valeur= (int)(Math.random() * (max-min)+min);
            Potion p = new Potion(valeur);
            c.setElement(p);
        }
        //génération monstre
        else if(elem<=(this.getProbEscalierGen()+this.getProbCoffreGen()+this.getProbPotGen()+(this.getProbMonsterGen()*(1+(this.getProfMax()-pronf)/this.getProfMax()))))
        {
            double maxForce = this.getMaxForceMonstre()*1.25*(this.getProfMax()+1-pronf);
            double minForce = this.getMinForceMonstre()*1.25*(this.getProfMax()+1-pronf);
            int maxOr = this.getMaxOrMonstre()*2*(this.getProfMax()+1-pronf);
            int minOr = this.getMinOrMonstre()*2*(this.getProfMax()+1-pronf);
            Monstre m = new Monstre((int)(Math.random() * (maxForce-minForce)+minForce),(int)(Math.random() * (maxOr-minOr)+minOr));
            c.setElement(m);
        }
        return c;
    }
    
    /**
     * Méthode qui génère une salle et la rajoute dans le souterrain
     * @param souterrain
     * @param salle précédente
     * @param profondeur de la salle
     */
    
    public void genererSalle(Souterrain souterrain,Salle sallepre,int pronf) {
        int i,j;
        Case c = new Case(0,0);
        int taille = (int)(Math.random() * (15-10))+10;
        int nbescaliers = 0;
        Salle s = new Salle(taille,pronf);
        int x = (int)(Math.random() * taille);
        int y = (int)(Math.random() * taille);
        Escalier desc = null;
        List<Case> salle = s.getLstCase();
        
        if(sallepre!=null)
            desc = new Escalier(x,y,true,sallepre);
        
        for(i=0;i<taille;i++) {
            for(j=0;j<taille;j++) {
                double elem = Math.random();
                if(sallepre!= null && i==x && j==y) {
                    c = desc;
                    s.setEscalier(desc);
                }
                else if(elem<=this.getProbEscalierGen()) {
                    //génération escalier
                     if(pronf!=0){
                        if(nbescaliers<this.getEscalierMax()) {
                            genererSalle(souterrain,s,pronf-1);
                            Escalier e = new Escalier(i,j,false,souterrain.getLstSalle().get(souterrain.getLstSalle().size()-1));                         
                            c = e;
                            nbescaliers++;
                        }
                        else
                            c = new Case(i,j);
                    }
                    else {
                        Double gen = Math.random();
                        if(gen<this.getProbSortieGen()&&this.getSortie()==false) {
                            Sortie sortie = new Sortie();
                            c.setElement(sortie);
                            this.setSortie(true);
                        }                                                          
                    }
                }
                else {
                    c = genererCase(i,j,pronf,elem);
                }
                salle.add(c);
            }
        }
        if(pronf==0&&this.getSortie()==false) {
            this.setProbSortieGen(this.getProbSortieGen()*1.5);
        }
        souterrain.getLstSalle().add(s);
    }
    
    /**
     * Méthode qui génère le souterrain
     * @param souterrain
     */
    
    public void genererSouterrain(Souterrain souterrain){
        genererSalle(souterrain,null,this.getProfMax());
    }
}
