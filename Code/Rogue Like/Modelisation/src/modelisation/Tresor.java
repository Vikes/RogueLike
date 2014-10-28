package modelisation;

public class Tresor extends Element {
    /**
     * @attribute
     */
    private int argentTresor;

    public void setArgentTresor(int argentTresor) {
        this.argentTresor = argentTresor;
    }

    public int getArgentTresor() {
        return argentTresor;
    }
    @Override
    public Element getElement() {
        return this;
    }
    @Override
    public String getType() {
        String res = "Trésor";
        return res;
    }
}
