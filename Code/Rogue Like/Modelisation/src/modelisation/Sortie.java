package modelisation;

public class Sortie extends Element {
    @Override
    public Element getElement() {
        return this;
    }
    @Override
    public String getType() {
        String res = "Sortie";
        return res;
    }
}
