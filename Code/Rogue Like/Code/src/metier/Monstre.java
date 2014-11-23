package metier;

public class Monstre extends Element {
    /** Classe repr�sentant les monstres du jeu */
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
     * M�thode qui modifie la force du monstre
     * @param Force du monstre
     */
    public void setForceMonstre(int forceMonstre) {
        this.forceMonstre = forceMonstre;
    }
    /**
     * M�thode renvoyant la force du monstre
     * @return Force du monstre
     */
    public int getForceMonstre() {
        return forceMonstre;
    }
    /**
     * M�thode qui modifie l'argent du monstre
     * @param Argent du monstre
     */
    public void setArgentMonstre(int argentMonstre) {
        this.argentMonstre = argentMonstre;
    }
    /**
     * M�thode renvoyant l'argent du monstre
     * @return Argent du monstre
     */
    public int getArgentMonstre() {
        return argentMonstre;
    }
    /**
     * M�thode qui modifie le Boolean de vie du monstre
     * @param Boolean de vie
     */
    public void setEnVie(Boolean enVie) {
        this.enVie = enVie;
    }
    /**
     * M�thode renvoyant le Boolean de vie du monstre
     * @return Boolean de vie
     */
    public Boolean getEnVie() {
        return enVie;
    }
    /**
     * M�thode renvoyant l'�l�ment monstre
     * @return El�ment monstre
     */
    @Override
    public Element getElement() {
        Element res=this;
        return res ;
    }
    /**
     * M�thode renvoyant le type monstre
     * @return Type monstre
     */
    @Override
    public String getType() {
        String res = "Monstre";
        return res;
    }
}
