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
    private Double probMonsterGen=0.025;
    private int minOrMonstre;
    private int minForceMonstre;
    private int maxOrMonstre;
    private int maxForceMonstre;
    private Double probSortieGen=0.05;
    private Double probCaseVideGen;
    private Boolean sortie;


    public Progressif(int profMax, Double probEscalierGen, int escalierMax, Double probCoffreGen, Double probPotGen) {
        super();
        this.profMax = profMax;
        this.probEscalierGen = probEscalierGen;
        this.escalierMax = escalierMax;
        this.probCoffreGen = probCoffreGen;
        this.probPotGen = probPotGen;
        this.sortie = false;
    }


    public void setProbSortieGen(Double probSortieGen) {
        this.probSortieGen = probSortieGen;
    }

    public Double getProbSortieGen() {
        return probSortieGen;
    }

    public void setSortie(Boolean sortie) {
        this.sortie = sortie;
    }

    public Boolean getSortie() {
        return sortie;
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
    
    public void genererSalle(Souterrain souterrain,Salle sallepre,int pronf) {
        int taille = (int)(Math.random() * (15-10))+10;
        int nbescaliers = 0;
        Salle s = new Salle(taille,pronf);
        List<Case> salle = s.getLstCase();
        int i,j;
        int x = (int)(Math.random() * taille);
        int y = (int)(Math.random() * taille);
        Escalier desc = new Escalier(x,y,true,sallepre);
        System.out.println("Seuils : "+ this.getProbEscalierGen() + " " + (this.getProbEscalierGen()+this.getProbCoffreGen()) +" "+(this.getProbEscalierGen()+this.getProbCoffreGen()+this.getProbPotGen()) + " " + (this.getProbEscalierGen()+this.getProbCoffreGen()+this.getProbPotGen()+(this.getProbMonsterGen()*(1+(this.getProfMax()-pronf)/this.getProfMax()))));
        for(i=0;i<taille;i++) {
            for(j=0;j<taille;j++) {
                Case c = new Case(j,i);
                double elem = Math.random(); 
                System.out.print("Case "+ j + " " + i + " " + elem + " ");
                //génération escalier descendant
                if(i==x && j==y) {
                    c = desc;
                }
                //génération escalier
                else if(elem<=this.getProbEscalierGen()) {
                    if(pronf!=0){
                        if(nbescaliers<this.getEscalierMax()) {
                            int tailleSalle = (int)(Math.random() * (15-10))+10;
                            Salle salleSuiv = new Salle(tailleSalle,pronf+1);
                            Escalier e = new Escalier(i,j,false,salleSuiv);
                            System.out.println("Escalier");
                            c = e;
                            genererSalle(souterrain,s,pronf-1);
                            nbescaliers++;
                            this.setProbEscalierGen(this.getProbEscalierGen()/2);
                        }
                    }
                    else {
                        Double gen = Math.random();
                        if(gen<this.getProbSortieGen()&&this.getSortie()==false) {
                            Sortie sortie = new Sortie();
                            c.setElement(sortie);
                            this.setSortie(true);
                        }                                                          
                    }
                }
                //génération coffre
                else if(elem<=(this.getProbEscalierGen()+this.getProbCoffreGen())) {
                    int min = this.getMinCoffre()*2*(this.getProfMax()+1-pronf);
                    int max = this.getMaxCoffre()*2*(this.getProfMax()+1-pronf);
                    int contenu= (int)(Math.random() * (max-min)+min);
                    Tresor t = new Tresor(contenu);
                    c.setElement(t);
                    System.out.println("Trésor");
                }
                //génération potion
                else if(elem<=(this.getProbEscalierGen()+this.getProbCoffreGen()+this.getProbPotGen())) {
                    int min = this.getMinPot()*2*(this.getProfMax()+1-pronf);
                    int max = this.getMaxPot()*2*(this.getProfMax()+1-pronf);
                    int valeur= (int)(Math.random() * (max-min)+min);
                    Potion p = new Potion(valeur);
                    c.setElement(p);
                    System.out.println("Potion");
                }
                //génération monstre
                else if(elem<=(this.getProbEscalierGen()+this.getProbCoffreGen()+this.getProbPotGen()+(this.getProbMonsterGen()*(1+(this.getProfMax()-pronf)/this.getProfMax()))))
                {
                    double maxForce = this.getMaxForceMonstre()*1.25*(this.getProfMax()+1-pronf);
                    double minForce = this.getMinForceMonstre()*1.25*(this.getProfMax()+1-pronf);
                    int maxOr = this.getMaxOrMonstre()*2*(this.getProfMax()+1-pronf);
                    int minOr = this.getMinOrMonstre()*2*(this.getProfMax()+1-pronf);
                    Monstre m = new Monstre((int)(Math.random() * (maxForce-minForce)+minForce),(int)(Math.random() * (maxOr-minOr)+minOr));
                    c.setElement(m);
                    System.out.println("Monstre");
                }
                else {
                    System.out.println("Vide");
                }
                salle.add(c);
            }
        }
        if(this.getSortie()==false) {
            this.setProbSortieGen(this.getProbSortieGen()*2);
        }
        souterrain.getLstSalle().add(s);
    }
    
    public void genererSouterrain(Souterrain souterrain){
            int taille = (int)(Math.random() * (15-10))+10;
            int nbescaliers = 0;
            Salle s = new Salle(taille,this.getProfMax());
            List<Case> salle = s.getLstCase();
            int i,j;
            int x = (int)(Math.random() * taille);
            int y = (int)(Math.random() * taille);
            System.out.println("Seuils : "+ this.getProbEscalierGen() + " " + (this.getProbEscalierGen()+this.getProbCoffreGen()) +" "+(this.getProbEscalierGen()+this.getProbCoffreGen()+this.getProbPotGen()) + " " + (this.getProbEscalierGen()+this.getProbCoffreGen()+this.getProbPotGen()+(this.getProbMonsterGen())));
            for(i=0;i<taille;i++) {
                for(j=0;j<taille;j++) {
                    Case c = new Case(i,j);
                    double elem = Math.random(); 
                    System.out.print("Case "+ i + " " + j + " " + elem + " ");
                    //génération escalier
                    if(elem<=this.getProbEscalierGen()) {
                        if(nbescaliers<this.getEscalierMax()) {
                            int tailleSalle = (int)(Math.random() * (15-10))+10;
                            Salle salleSuiv = new Salle(tailleSalle,1);
                            Escalier e = new Escalier(i,j,false,salleSuiv);
                            System.out.println("Escalier");
                            c = e;
                            genererSalle(souterrain,s,this.getProfMax()-1);
                            nbescaliers++;
                            this.setProbEscalierGen(this.getProbEscalierGen()/2);
                        }

                    }
                    //génération coffre
                    else if(elem<=(this.getProbEscalierGen()+this.getProbCoffreGen())) {
                        int min = this.getMinCoffre();
                        int max = this.getMaxCoffre();
                        int contenu= (int)(Math.random() * (max-min)+min);
                        Tresor t = new Tresor(contenu);
                        c.setElement(t);
                        System.out.println("Trésor");
                    }
                    //génération potion
                    else if(elem<=(this.getProbEscalierGen()+this.getProbCoffreGen()+this.getProbPotGen())) {
                        int min = this.getMinPot();
                        int max = this.getMaxPot();
                        int valeur= (int)(Math.random() * (max-min)+min);
                        Potion p = new Potion(valeur);
                        c.setElement(p);
                        System.out.println("Potion");
                    }
                    //génération monstre
                    else if(elem<=(this.getProbEscalierGen()+this.getProbCoffreGen()+this.getProbPotGen()+(this.getProbMonsterGen()*(2/this.getProfMax()))))
                    {
                        double maxForce = this.getMaxForceMonstre();
                        double minForce = this.getMinForceMonstre();
                        int maxOr = this.getMaxOrMonstre();
                        int minOr = this.getMinOrMonstre();
                        Monstre m = new Monstre((int)(Math.random() * (maxForce-minForce)+minForce),(int)(Math.random() * (maxOr-minOr)+minOr));
                        c.setElement(m);
                        System.out.println("Monstre");
                    }
                    else {
                        System.out.println("Vide");
                    }
                    salle.add(c);
                }
            }
            if(this.getSortie()==false) {
                souterrain.getLstSalle().get(0).getLstCase().get(0).setElement(new Sortie());
            }
            souterrain.getLstSalle().add(s);
        }
    

        /*public static void main(String[] args) {
        Souterrain s = new Souterrain(new Progressif(10,0.1,6,0.01,0.01));
        Progressif p = (Progressif) s.getGeneration();
        p.genererSouterrain(s);
        List<Salle> lst = s.getLstSalle();
        int ligneactuelle = 0;
        Case caseactuelle;
        for(Salle st : lst)
        {
            System.out.println("Taille de la salle : "+st.getLongueur());
            System.out.println("Profondeur de la salle :" + st.getNiveau());
            for(int i = 0;i<st.getLstCase().size();i++) {
                caseactuelle = st.getLstCase().get(i);
                if(caseactuelle.getPositionX()!=ligneactuelle) {
                    ligneactuelle=caseactuelle.getPositionX();
                    System.out.println("");
                }
                System.out.print(caseactuelle.getSymbole()+ " ");
            }
            System.out.println("");
        }
        
    }*/
}
