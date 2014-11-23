package controleur;

import java.util.Collection;

import metier.Case;
import metier.Escalier;
import metier.Monstre;
import metier.Personnage;
import metier.Potion;
import metier.Progressif;
import metier.Salle;
import metier.Souterrain;
import metier.Tresor;

public class Partie {

    private static Partie Instance; //instance actuelle de Partie
    
    private Boolean finie;          //bolean déterminant si la partie est finie ou non
    private Souterrain souterrain;  //souterrain de la partie
    private Salle salleActu;        //salle actuelle de la partie
    private Personnage personnage;  //personnage de la partie
    private int demin;              //nombre de monstre autour du personnage

    /**
     * Constructeur de partie
     */
    
    public Partie(){
        this.finie = false;
        this.souterrain = new Souterrain(new Progressif(3,0.1,3,0.05,0.05));
        this.souterrain.getGeneration().genererSouterrain(this.souterrain);
        this.personnage = new Personnage("Narkrai");
        salleActu = this.getSouterrain().getLstSalle().get(this.getSouterrain().getLstSalle().size()-1);
        Instance = this;
        commencerPartie();
    }
    
    /**
     * Méthode qui modifie le boolean de fin de partie
     * @param boolean
     */
    
    public void setFinie(Boolean finie) {
        this.finie = finie;
    }

    /**
     * Méthode qui retourne le boolean de fin de partie
     * @return boolean
     */
    
    public Boolean getFinie() {
        return finie;
    }
    
    /**
     * Méthode qui modifie le souterrain de partie
     * @param souterrain
     */
    

    public void setSouterrain(Souterrain Souterrain) {
        this.souterrain = Souterrain;
    }

    /**
     * Méthode qui retourne le souterrain de partie
     * @return souterrain
     */
    
    public Souterrain getSouterrain() {
        return souterrain;
    }

    /**
     * Méthode qui modifie la salle actuelle de la partie
     * @param salle
     */
    
    public void setSalleActu(Salle salleActu) {
        this.salleActu = salleActu;
    }

    /**
     * Méthode qui retourne la salle actuelle de la partie
     * @return salle actuelle
     */
    
    public Salle getSalleActu() {
        return salleActu;
    }

    /**
     * Méthode qui modifie le personnage de partie
     * @param personnage
     */
    
    public void setPersonnage(Personnage Personnage) {
        this.personnage = Personnage;
    }

    /**
     * Méthode qui retourne le personnage de partie
     * @return personnage
     */
    
    public Personnage getPersonnage() {
        return personnage;
    }

    /**
     * Méthode qui retourne l'instance unique de partie
     * @return boolean
     */
    
    public static Partie getInstance() {
        if (Instance == null) {
            new Partie();
        }
        return Instance;
    }
    
    /**
     * Méthode qui retourne le nombre de monstre autour du personnage
     * @return nombre de monstre autour du personnage
     */
    
    public int getDemin() {
        return demin;
    }
    
    /**
     * Méthode qui fait commencer la partie
     */
    
    public void commencerPartie(){
        int x = (int) (Math.random()*this.getSalleActu().getLongueur());
        int y = (int) (Math.random()*this.getSalleActu().getLongueur());
        while(this.getSalleActu().getCase(x,y).getElement()!=null) {
            x = (int) (Math.random()*this.getSalleActu().getLongueur());
            y = (int) (Math.random()*this.getSalleActu().getLongueur());
        }
        this.getPersonnage().setCase(this.getSalleActu().getCase(x,y));
        this.setDemin();
        affichermap(x,y);
    }
    
    /** 
     * Méthode qui détermine le nombre de monstre autour du personnage
     */
    
    public void setDemin() {
        int x = this.getPersonnage().getCase().getPositionX();
        int y = this.getPersonnage().getCase().getPositionY();
        int res=0;
        for(int i = -1;i<2;i++) {
            for(int j=-1;j<2;j++) {
                if((x+i<-1||x+i>=this.getSalleActu().getLongueur()||y+j<-1||y+j>=this.getSalleActu().getLongueur())) {
                }
                else {
                    Case c = this.getSalleActu().getCase(x+i,y+j);
                    if((c!=null)&&!(c instanceof Escalier))
                    {
                        if(c.getElement()!=null) {
                            if(this.getSalleActu().getCase(x+i,y+j).getElement().getType()=="Monstre")
                            {
                                res++;
                            }
                        }
                    }
                }
            }
        }
        this.demin = res;
    }
    
    /**
     * Méthode qui permet de faire déplacer le personnage
     * @param caractère de mouvement
     */
    
    public String mouvement(char c){
        String res = "Les ténèbres vous traquent ...";
        boolean bouge = false;
        int x = this.getPersonnage().getCase().getPositionX();
        int y = this.getPersonnage().getCase().getPositionY();
        if(c=='z') {
            if(x-1!=-1){
                x--;
                bouge = true;
            }
        }
        else if(c=='q') {
            if(y-1!=-1){
                y--;
                bouge = true;
            }
        }
        else if(c=='d') {
            if(y+1!=this.getSalleActu().getLongueur()){
                y++;
                bouge = true;
            }
        }        
        else if(c=='s') {
            if(x+1!=this.getSalleActu().getLongueur()){
                x++;
                bouge = true;
            }
        }
        if(bouge) {
            this.getPersonnage().getCase().setSymbole();
            this.getPersonnage().setCase(this.getSalleActu().getCase(x,y));
            Case act = this.getPersonnage().getCase();
            if(act.getElement()!=null) {
                
                if(act.getElement().getType()=="Potion"){
                   res = potion(act);
                }
                else if(act.getElement().getType()=="Trésor"){
                   res = tresor(act);
                }
                else if(act.getElement().getType()=="Sortie"){
                    this.setFinie(true);
                    res = "Vous avez trouvé la sortie !";
                }
                else if(act.getElement().getType()=="Monstre"){
                   res = combat(act);
                }
            }
            else if(act instanceof Escalier) {
                Escalier e = (Escalier) act;
                if(!e.isDesc()) {
                    res = "salle";
                }
                else{
                    res = "Vous changez de salle";
                    changersalle();
                    x = this.getPersonnage().getCase().getPositionX();
                    y = this.getPersonnage().getCase().getPositionY();
                }
            }
            this.setDemin();
            affichermap(x,y);
        }
        return res;
    }
    
    /**
     *  Méthode qui lance un combat avec le monstre présent sur la case
     *  @param case avec le monstre
     */
    
    public String combat(Case act) {
        String res ="";
        Monstre m = (Monstre) act.getElement();
        Double rand = Math.random();
        Double win = (this.getPersonnage().getForcePersonnage()*1.0)/(this.getPersonnage().getForcePersonnage()+m.getForceMonstre());
        res+="Vous combattez un monstre de force "+m.getForceMonstre()+ " et vous ";
        if(rand<win) {
            this.getPersonnage().setArgentPersonnage(this.getPersonnage().getArgentPersonnage()+m.getArgentMonstre());
            res+="gagnez !";
            act.setElement(null);
        }
        else{
            this.getPersonnage().setEnVie(false);
            res+="perdez ...";
        }
        return res;
    }
    
    /**
     * Méthode qui permet de d'ajouter le bonus de potion au personnage
     * @param case contenant la potion
     */
    
    public String potion(Case act) {
        Potion p = (Potion) act.getElement();
        this.getPersonnage().setForcePersonnage(this.getPersonnage().getForcePersonnage()+p.getBonus());
        System.out.println("Force potion : "+p.getBonus());
        System.out.println("Force perso : "+this.getPersonnage().getForcePersonnage());
        act.setElement(null);
        return "Vous buvez une potion qui vous donne " + p.getBonus() +" de force !";
    }
    
    /**
     * Méthode qui permet d'ajouter le contenu du trésor au personnage
     * @param case contenant le trésor
     */
    
    public String tresor(Case act) {
        Tresor t= (Tresor) act.getElement();
        this.getPersonnage().setArgentPersonnage(this.getPersonnage().getArgentPersonnage()+t.getArgentTresor());
        act.setElement(null);
        return "Vous trouvez " + t.getArgentTresor() + "or dans le coffre !";
    }
    
    /**
     * Méthode qui permet de changer de salle depuis un escalier
     */
    
    public void changersalle(){
       Escalier e = (Escalier) this.getPersonnage().getCase();
       if(!e.isDesc())
       {
           System.out.println("Vers la salle "+e.getSalle().hashCode());
           this.setSalleActu(e.getSalle());
           Escalier es = this.getSalleActu().getEscalier();
           this.getPersonnage().setCase(this.getSalleActu().getCase(es.getPositionX(),es.getPositionY()));
           affichermap(es.getPositionX(),es.getPositionY());
       }
       else {
           Salle suiv = e.getSalle();
           boolean trouve=false;
           int i =0;
           while(trouve==false&&i<suiv.getLstCase().size()) {
                 if(suiv.getLstCase().get(i).getType()=="Escalier"){
                   Escalier pe = (Escalier) suiv.getLstCase().get(i);
                   if(pe.getSalle().hashCode()==this.getSalleActu().hashCode()) {
                       this.setSalleActu(e.getSalle());
                       this.getPersonnage().setCase(this.getSalleActu().getCase(pe.getPositionX(),pe.getPositionY()));
                       this.getSalleActu().getCase(pe.getPositionX(),pe.getPositionY()).setSymbole('@');
                       trouve=true;
                   }
                   else
                   i++;
               }
               else
               i++;
           }
       }
    }

    /**
     * Méthode qui permet de mettre à jour la case du personnage et afficher les cases autour
     * @param position x
     * @param position y
     */
        
    public void affichermap(int x,int y) {
        this.getSalleActu().getCase(x,y).setSymbole('@');
        this.getSalleActu().vision(x,y);
    }
    
}
