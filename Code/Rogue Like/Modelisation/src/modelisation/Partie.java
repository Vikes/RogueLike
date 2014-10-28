package modelisation;

import java.util.Collection;

public class Partie {
    /**
     * @attribute
     */
    private String touche;

    /**
     * @attribute
     */
    private Boolean finie;

    /**
     * @attribute
     */
    private static int argentMax;
    Souterrain Souterrain;
    Salle salleActu;

    /**
     * @associates <{modelisation.Partie}>
     */
    Collection Instance;
    Personnage Personnage;

    private static Partie getInstance() {
    }

    private void commencerPartie() {
    }

    private void Combat() {
    }

    private void Mouvement() {
    }
}
