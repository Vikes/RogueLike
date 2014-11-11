package metier;

public class Basique {

    private int profMax;
    private Double probEscalierGen;
    private int escalierMax;
    private Double probCoffreGen;
    private int minCoffre;
    private int maxCoffre;
    private Double probPotGen;
    private int minPot; 
    private int maxPot;
    private Double probMonsterGen;
    private int minOrMonstre;
    private int minForceMonstre;
    private int maxOrMonstre;
    private int maxForceMonstre;
    private Double probCaseVideGen;
    
    public Salle genererSalle(Souterrain souterrain,Salle sallepre,int pronf) {
        return new Salle(5,5);
    }
    
    public void genererSouterrain(Souterrain souterrain){
        
    }
}
