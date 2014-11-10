package metier;


import java.util.Collection;
import java.util.List;

public abstract interface Generation {
     public abstract void genererSalle(Souterrain souterrain,Salle s, int pronf) ;
     public abstract void genererSouterrain(Souterrain souterrain);
}
