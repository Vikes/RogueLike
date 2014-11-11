package metier;


import java.util.Collection;
import java.util.List;

public abstract interface Generation {
    public void genererSalle(Souterrain souterrain,Salle sallepre,int pronf);
    public abstract void genererSouterrain(Souterrain souterrain);
}
