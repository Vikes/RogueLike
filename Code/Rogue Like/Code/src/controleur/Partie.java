package controleur;

import java.util.Collection;

import metier.Personnage;
import metier.Salle;
import metier.Souterrain;

public class Partie {
 
    private String touche;
    private Boolean finie;
    private static int argentMax;
    Souterrain Souterrain;
    Salle salleActu;
    Collection Instance;
    Personnage Personnage;


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

    public void setInstance(Collection Instance) {
        this.Instance = Instance;
    }

    public Collection getInstance1() {
        return Instance;
    }

    public void setPersonnage(Personnage Personnage) {
        this.Personnage = Personnage;
    }

    public Personnage getPersonnage() {
        return Personnage;
    }

    public static Partie getInstance() {
    }

    public void commencerPartie() {
    }

    public void Combat() {
    }

    public void Mouvement() {
    }
}
