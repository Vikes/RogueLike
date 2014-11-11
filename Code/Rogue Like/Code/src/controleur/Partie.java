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

    private String touche;
    private Boolean finie;
    private static int argentMax;
    Souterrain Souterrain;
    Salle salleActu;
    static Partie Instance;
    Personnage Personnage;

    public Partie(){
        this.finie = false;
        this.Souterrain = new Souterrain(new Progressif(3,0.1,3,0.05,0.05));
        this.Souterrain.getGeneration().genererSouterrain(this.Souterrain);
        this.Personnage = new Personnage("Narkrai");
        salleActu = this.getSouterrain().getLstSalle().get(this.getSouterrain().getLstSalle().size()-1);
        partie();
    }

    public void partie(){
        int x = (int) (Math.random()*this.getSalleActu().getLongueur());
        int y = (int) (Math.random()*this.getSalleActu().getLongueur());
        System.out.println("X : "+x+"Y : "+y);
        this.getPersonnage().setCase(this.getSalleActu().getCase(x,y));
        this.getSalleActu().getCase(x,y).setSymbole('@');
        this.getSalleActu().vision(x,y);
    }
    
    public void mouvement(char c){
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
            if(this.getPersonnage().getCase().getElement()!=null) {
                Case act = this.getPersonnage().getCase();
                if(act.getElement().getType()=="Potion"){
                    Potion p = (Potion) act.getElement();
                    this.getPersonnage().setForcePersonnage(this.getPersonnage().getForcePersonnage()+p.getBonus());
                    act.setElement(null);
                }
                else if(act.getElement().getType()=="Trésor"){
                    Tresor t= (Tresor) act.getElement();
                    this.getPersonnage().setArgentPersonnage(this.getPersonnage().getArgentPersonnage()+t.getArgentTresor());
                    act.setElement(null);
                }
                else if(act.getElement().getType()=="Sortie"){
                    this.setFinie(true);
                }
                else if(act.getElement().getType()=="Monstre"){
                    Monstre m = (Monstre) act.getElement();
                    Double rand = Math.random();
                    Double win = (this.getPersonnage().getForcePersonnage()*1.0)/(this.getPersonnage().getForcePersonnage()+m.getForceMonstre());
                    if(rand<win) {
                        this.getPersonnage().setArgentPersonnage(this.getPersonnage().getArgentPersonnage()+m.getArgentMonstre());
                        act.setElement(null);
                    }
                    else{
                        this.getPersonnage().setEnVie(false);
                    }
                }
            }
            this.getSalleActu().getCase(x,y).setSymbole('@');
            this.getSalleActu().vision(x,y);
        }
    }
    
    public void changersalle(){
       Escalier e = (Escalier) this.getPersonnage().getCase();
       if(!e.isDesc())
       {
           System.out.println("Vers la salle "+e.getSalle().hashCode());
           this.setSalleActu(e.getSalle());
           Escalier es = this.getSalleActu().getEscalier();
           this.getPersonnage().setCase(this.getSalleActu().getCase(es.getPositionX(),es.getPositionY()));
           this.getSalleActu().getCase(es.getPositionX(),es.getPositionY()).setSymbole('@');
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
    
    public void setTouche(String touche) {
        this.touche = touche;
    }

    public String getTouche() {
        return touche;
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
        this.Souterrain = Souterrain;
    }

    public Souterrain getSouterrain() {
        return Souterrain;
    }

    public void setSalleActu(Salle salleActu) {
        this.salleActu = salleActu;
    }

    public Salle getSalleActu() {
        return salleActu;
    }

    public void setPersonnage(Personnage Personnage) {
        this.Personnage = Personnage;
    }

    public Personnage getPersonnage() {
        return Personnage;
    }

    public static Partie getInstance() {
        if (Instance == null) {
            Instance = new Partie();
        }
        return Instance;
    }

    public void commencerPartie() {
        
    }

    public void Combat() {

    }

    public void Mouvement() {

    }
}
