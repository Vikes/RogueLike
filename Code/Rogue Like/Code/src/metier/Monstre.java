package metier;

public class Monstre extends Element {
    /** Classe représentant les monstres du jeu */
    private int forceMonstre;// Force des monstres
    private int argentMonstre;// Argent des monstres
    private Boolean enVie;// Boolea informant si le monstre est en vie ou non
    
    /**
     * Constructeur
     * @param Force du monstres
     * @param Argent du monstres
     */
    public Monstre(int force,int argent) {
        this.forceMonstre=force;
        this.argentMonstre=argent;
        this.enVie=true;
    }
    /**
     * Méthode qui modifie la force du monstre
     * @param Force du monstre
     */
    public void setForceMonstre(int forceMonstre) {
        this.forceMonstre = forceMonstre;
    }
    /**
     * Méthode renvoyant la force du monstre
     * @return Force du monstre
     */
    public int getForceMonstre() {
        return forceMonstre;
    }
    /**
     * Méthode qui modifie l'argent du monstre
     * @param Argent du monstre
     */
    public void setArgentMonstre(int argentMonstre) {
        this.argentMonstre = argentMonstre;
    }
    /**
     * Méthode renvoyant l'argent du monstre
     * @return Argent du monstre
     */
    public int getArgentMonstre() {
        return argentMonstre;
    }
    /**
     * Méthode qui modifie le Boolean de vie du monstre
     * @param Boolean de vie
     */
    public void setEnVie(Boolean enVie) {
        this.enVie = enVie;
    }
    /**
     * Méthode renvoyant le Boolean de vie du monstre
     * @return Boolean de vie
     */
    public Boolean getEnVie() {
        return enVie;
    }
    /**
     * Méthode renvoyant l'élément monstre
     * @return Elément monstre
     */
    @Override
    public Element getElement() {
        Element res=this;
        return res ;
    }
    /**
     * Méthode renvoyant le type monstre
     * @return Type monstre
     */
    @Override
    public String getType() {
        String res = "Monstre";
        return res;
    }
}
