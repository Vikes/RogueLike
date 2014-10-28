package modelisation;

import java.util.Collection;

public class Souterrain {
    /**
     * @associates <{modelisation.Generation}>
     */
    Collection endGeneration;

    /**
     * @associates <{modelisation.Souterrain}>
     */
    Collection Instance;

    /**
     * @associates <{modelisation.Salle}>
     */
    Collection lstSalle;

    public static Souterrain getInstance() {
    }
}
