package metier;

import controleur.Partie;

import java.util.Collection;
    
    

public class Souterrain {
    
    static Souterrain Instance;
    /**
     * @associates <{modelisation.Generation}>
     */
    Collection endGeneration;

   

    /**
     * @associates <{modelisation.Salle}>
     */
    Collection lstSalle;
    public Souterrain(){}

    public static Souterrain getInstance() {
        
        if (Instance == null)
             {       Instance = new Souterrain();     
             }
        
        return Instance;
    }
    

}

