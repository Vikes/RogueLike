package metier;

public class Potion extends Element {
    /** Classe repr�sentant les potions du jeu */
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
     * M�thode qui modifie le bonus de la potion
     * @param Bonus de la potion
     */
    
    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
    /**
     * M�thode renvoyant le bonus de la potion
     * @return Bonus de la potion
     */
    public int getBonus() {
        return bonus;
    }
    /**
     * M�thode renvoyant l'�l�ment potion
     * @return El�ment potion
     */
    @Override
    public Element getElement() {
        return this;
    }
    /**
     * M�thode renvoyant le type potion
     * @return Type potion
     */
    @Override
    public String getType() {
        String res = "Potion";
        return res;
    }
}
