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

    private static int argentMax;
    private static Partie Instance;
    
    private Boolean finie;
    private Souterrain souterrain;
    private Salle salleActu;
    private Personnage personnage;

    public Partie(){
        this.finie = false;
        this.souterrain = new Souterrain(new Progressif(3,0.1,3,0.05,0.05));
        this.souterrain.getGeneration().genererSouterrain(this.souterrain);
        this.personnage = new Personnage("Narkrai");
        salleActu = this.getSouterrain().getLstSalle().get(this.getSouterrain().getLstSalle().size()-1);
        Instance = this;
        commencerPartie();
    }

    public void setFinie(Boolean finie) {
        this.finie = finie;
    }

    public Boolean getFinie() {
        return finie;
    }

    public static void setArgentMax(int argentMax) {
        Partie.argentMax = argentMax;
    }

    public static int getArgentMax() {
        return argentMax;
    }

    public void setSouterrain(Souterrain Souterrain) {
        this.souterrain = Souterrain;
    }

    public Souterrain getSouterrain() {
        return souterrain;
    }

    public void setSalleActu(Salle salleActu) {
        this.salleActu = salleActu;
    }

    public Salle getSalleActu() {
        return salleActu;
    }

    public void setPersonnage(Personnage Personnage) {
        this.personnage = Personnage;
    }

    public Personnage getPersonnage() {
        return personnage;
    }

    public static Partie getInstance() {
        if (Instance == null) {
            new Partie();
        }
        return Instance;
    }

    public void commencerPartie(){
        int x = (int) (Math.random()*this.getSalleActu().getLongueur());
        int y = (int) (Math.random()*this.getSalleActu().getLongueur());
        while(this.getSalleActu().getCase(x,y).getElement()!=null) {
            x = (int) (Math.random()*this.getSalleActu().getLongueur());
            y = (int) (Math.random()*this.getSalleActu().getLongueur());
        }
        this.getPersonnage().setCase(this.getSalleActu().getCase(x,y));
        affichermap(x,y);
    }
    
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
                }
            }
            affichermap(x,y);
        }
        return res;
    }
    
    public String combat(Case act) {
        String res ="";
        Monstre m = (Monstre) act.getElement();
        Double rand = Math.random();
        Double win = (this.getPersonnage().getForcePersonnage()*1.0)/(this.getPersonnage().getForcePersonnage()+m.getForceMonstre());
        res+="Vous combattez un monstre de force "+m.getForceMonstre()+ " et vous ";
        System.out.println("Force du monstre : "+m.getForceMonstre());
        System.out.println("Random : "+ rand +" Seuil : "+ win);
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
    
    public String potion(Case act) {
        Potion p = (Potion) act.getElement();
        this.getPersonnage().setForcePersonnage(this.getPersonnage().getForcePersonnage()+p.getBonus());
        System.out.println("Force potion : "+p.getBonus());
        System.out.println("Force perso : "+this.getPersonnage().getForcePersonnage());
        act.setElement(null);
        return "Vous buvez une potion qui vous donne " + p.getBonus() +" de force !";
    }
    
    public String tresor(Case act) {
        Tresor t= (Tresor) act.getElement();
        this.getPersonnage().setArgentPersonnage(this.getPersonnage().getArgentPersonnage()+t.getArgentTresor());
        act.setElement(null);
        return "Vous trouvez " + t.getArgentTresor() + "or dans le coffre !";
    }
    
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
              // if(suiv.getLstCase().get(i) instanceof Escalier) 
                 if(suiv.getLstCase().get(i).getType()=="Escalier"){
                   Escalier pe = (Escalier) suiv.getLstCase().get(i);
                   System.out.println(""+pe.getSalle().hashCode()+" vs "+this.getSalleActu().hashCode());
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
    
    public void affichermap(int x,int y) {
        this.getSalleActu().getCase(x,y).setSymbole('@');
        this.getSalleActu().vision(x,y);
    }
    
}
