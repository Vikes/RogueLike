package metier;
import java.util.List;
import java.util.ArrayList;

public class Progressif implements Generation {
    
    private int profMax;
    private Double probEscalierGen;
    private int escalierMax;
    private Double probCoffreGen;
    private int minCoffre=25;
    private int maxCoffre=50;
    private Double probPotGen;
    private int minPot; 
    private int maxPot;
    private Double probMonsterGen=0.1;
    private int minOrMonstre;
    private int minForceMonstre;
    private int maxOrMonstre;
    private int maxForceMonstre;
    private Double probCaseVideGen;


    public Progressif(int profMax, Double probEscalierGen, int escalierMax, Double probCoffreGen, Double probPotGen) {
        super();
        this.profMax = profMax;
        this.probEscalierGen = probEscalierGen;
        this.escalierMax = escalierMax;
        this.probCoffreGen = probCoffreGen;
        this.probPotGen = probPotGen;
    }

    public void setProfMax(int profMax) {
        this.profMax = profMax;
    }

    public int getProfMax() {
        return profMax;
    }

    public void setProbEscalierGen(Double probEscalierGen) {
        this.probEscalierGen = probEscalierGen;
    }

    public Double getProbEscalierGen() {
        return probEscalierGen;
    }

    public void setEscalierMax(int escalierMax) {
        this.escalierMax = escalierMax;
    }

    public int getEscalierMax() {
        return escalierMax;
    }

    public void setProbCoffreGen(Double probCoffreGen) {
        this.probCoffreGen = probCoffreGen;
    }

    public Double getProbCoffreGen() {
        return probCoffreGen;
    }

    public void setMinCoffre(int minCoffre) {
        this.minCoffre = minCoffre;
    }

    public int getMinCoffre() {
        return minCoffre;
    }

    public void setMaxCoffre(int maxCoffre) {
        this.maxCoffre = maxCoffre;
    }

    public int getMaxCoffre() {
        return maxCoffre;
    }

    public void setProbPotGen(Double probPotGen) {
        this.probPotGen = probPotGen;
    }

    public Double getProbPotGen() {
        return probPotGen;
    }

    public void setMinPot(int minPot) {
        this.minPot = minPot;
    }

    public int getMinPot() {
        return minPot;
    }

    public void setMaxPot(int maxPot) {
        this.maxPot = maxPot;
    }

    public int getMaxPot() {
        return maxPot;
    }

    public void setProbMonsterGen(Double probMonsterGen) {
        this.probMonsterGen = probMonsterGen;
    }

    public Double getProbMonsterGen() {
        return probMonsterGen;
    }

    public void setMinOrMonstre(int minOrMonstre) {
        this.minOrMonstre = minOrMonstre;
    }

    public int getMinOrMonstre() {
        return minOrMonstre;
    }

    public void setMinForceMonstre(int minForceMonstre) {
        this.minForceMonstre = minForceMonstre;
    }

    public int getMinForceMonstre() {
        return minForceMonstre;
    }

    public void setMaxOrMonstre(int maxOrMonstre) {
        this.maxOrMonstre = maxOrMonstre;
    }

    public int getMaxOrMonstre() {
        return maxOrMonstre;
    }

    public void setMaxForceMonstre(int maxForceMonstre) {
        this.maxForceMonstre = maxForceMonstre;
    }

    public int getMaxForceMonstre() {
        return maxForceMonstre;
    }

    public void setProbCaseVideGen(Double probCaseVideGen) {
        this.probCaseVideGen = probCaseVideGen;
    }

    public Double getProbCaseVideGen() {
        return probCaseVideGen;
    }
    
    public void genererSalle(Souterrain souterrain,int pronf) {
        int taille = (int)(Math.random() * (15-10))+10;
        Salle s = new Salle(taille,pronf);
        int nbescaliers = 0;
        List<Case> salle = s.getLstCase();
        int i,j;
        for(i=0;i<taille;i++) {
            for(j=0;j<taille;j++) {
                Case c = new Case(i,j);
                double elem = Math.random();
                //génération escalier
                if(elem<=this.getProbEscalierGen()&&pronf!=0) {
                    if(nbescaliers<this.getEscalierMax()) {
                        int tailleSalle = (int)(Math.random() * (15-10))+10;
                        Salle salleSuiv = new Salle(tailleSalle,pronf+1);
                        Escalier e = new Escalier(i,j,false,salleSuiv);
                        genererSalle(souterrain,pronf-1);
                        salle.add(e);
                    }
                }
                //génération coffre
                else if(elem<=(this.getProbEscalierGen()+this.getProbCoffreGen())) {
                    int min = this.getMinCoffre()*2*(this.getProfMax()+1-pronf);
                    int max = this.getMaxCoffre()*2*(this.getProfMax()+1-pronf);
                    int contenu= (int)(Math.random() * (max-min)+min);
                    Tresor t = new Tresor(contenu);
                    c.setElement(t);
                    salle.add(c);
                }
                //génération potion
                else if(elem<=(this.getProbEscalierGen()+this.getProbCoffreGen()+this.getProbPotGen())) {
                    int min = this.getMinPot()*2*(this.getProfMax()+1-pronf);
                    int max = this.getMaxPot()*2*(this.getProfMax()+1-pronf);
                    int valeur= (int)(Math.random() * (max-min)+min);
                    Potion p = new Potion(valeur);
                    c.setElement(p);
                    salle.add(c);
                }
                //génération monstre
                else if(elem<=this.getProbEscalierGen()+this.getProbCoffreGen()+this.getProbPotGen()+(this.getProbMonsterGen()*(pronf/this.getProfMax())))
                {
                    double maxForce = this.getMaxForceMonstre()*1.25*(this.getProfMax()+1-pronf);
                    double minForce = this.getMinForceMonstre()*1.25*(this.getProfMax()+1-pronf);
                    int maxOr = this.getMaxOrMonstre()*2*(this.getProfMax()+1-pronf);
                    int minOr = this.getMinOrMonstre()*2*(this.getProfMax()+1-pronf);
                    Monstre m = new Monstre((int)(Math.random() * (maxForce-minForce)+minForce),(int)(Math.random() * (maxOr-minOr)+minOr));
                }
                else {
                    salle.add(c);
                }
            }
        }
        souterrain.getLstSalle().add(s);
    }
    
    public static void main(String[] args) {
        Souterrain s = new Souterrain(new Progressif(1,0.5,2,0.2,0.2));
        Progressif p = (Progressif) s.getGeneration();
        p.genererSalle(s,1);
        List<Salle> lst = s.getLstSalle();
        Salle salle = lst.get(0);
        System.out.println("Taille de la salle : "+salle.getLongueur());
        int ligneactuelle = 0;
        Case caseactuelle;
        for(int i = 0;i<salle.getLstCase().size();i++) {
            caseactuelle = salle.getLstCase().get(i);
            if(caseactuelle.getPositionX()!=ligneactuelle) {
                ligneactuelle=caseactuelle.getPositionX();
                System.out.println("");
            }
            System.out.print(caseactuelle.getSymbole());
        }
        
    }
    /*public Salle[] genererSouterrain(){
        
    }*/


}
