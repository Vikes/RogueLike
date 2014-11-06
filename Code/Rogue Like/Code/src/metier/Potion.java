package metier;

public class Potion extends Element {
    /**
     * @attribute
     */
    private int bonus;


    public Potion(int bonus) {
        super();
        this.bonus = bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }
    @Override
    public Element getElement() {
        return this;
    }
    @Override
    public String getType() {
        String res = "Potion";
        return res;
    }
}
