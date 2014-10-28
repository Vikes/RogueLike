package modelisation;

public class Potion extends Element {
    /**
     * @attribute
     */
    private int bonus;

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }
}
