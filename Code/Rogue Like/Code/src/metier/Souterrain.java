package metier;

import controleur.Partie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class Souterrain {
    
    static Souterrain Instance;
    Generation generation;
    List<Salle> lstSalle;
    
    
    public Souterrain(){
         lstSalle = new ArrayList<Salle>();
    }

    public Souterrain(Generation generation){
         lstSalle = new ArrayList<Salle>();
         this.generation = generation;
    }

    public static void setInstance(Souterrain Instance) {
        Souterrain.Instance = Instance;
    }

    public void setGeneration(Generation generation) {
        this.generation = generation;
    }

    public Generation getGeneration() {
        return generation;
    }

    public void setLstSalle(List<Salle> lstSalle) {
        this.lstSalle = lstSalle;
    }

    public List<Salle> getLstSalle() {
        return lstSalle;
    }

    public static Souterrain getInstance() {
        
        if (Instance == null)
             {       Instance = new Souterrain();     
             }
        
        return Instance;
    }
    

}

