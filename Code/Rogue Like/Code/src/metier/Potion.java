package metier;

public class Potion extends Element {
    /** Classe représentant les potions du jeu */
    private int bonus;// Bonus contenus par la potion

    /**
     * Constructeur
     * @param Bonus de la potion
     */
    public Potion(int bonus) {
        super();
        this.bonus = bonus;
    }
    /**
     * Méthode qui modifie le bonus de la potion
     * @param Bonus de la potion
     */
    
    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
    /**
     * Méthode renvoyant le bonus de la potion
     * @return Bonus de la potion
     */
    public int getBonus() {
        return bonus;
    }
    /**
     * Méthode renvoyant l'élément potion
     * @return Elément potion
     */
    @Override
    public Element getElement() {
        return this;
    }
    /**
     * Méthode renvoyant le type potion
     * @return Type potion
     */
    @Override
    public String getType() {
        String res = "Potion";
        return res;
    }
}
