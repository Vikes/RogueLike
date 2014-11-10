package controleur;

import java.util.Collection;

import metier.Personnage;
import metier.Progressif;
import metier.Salle;
import metier.Souterrain;

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
        this.Souterrain = new Souterrain(new Progressif(5,0.1,3,0.05,0.05));
        this.Souterrain.getGeneration().genererSouterrain(this.Souterrain);
        this.Personnage = new Personnage("Narkrai");
        System.out.println("Taille de la liste : "+ (this.getSouterrain().getLstSalle().size()-1));
        salleActu = this.getSouterrain().getLstSalle().get(this.getSouterrain().getLstSalle().size()-1);
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
