package metier;

public class Case {
   
    private int positionX;
    private String symbole;
    private int positionY;
    private Boolean vue;
    Element Element;


    public Case(int positionX, int positionY) {
        super();
        this.positionX = positionX;
        this.positionY = positionY;
        vue = false;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setSymbole(String symbole) {
        this.symbole = symbole;
    }

    public String getSymbole() {
        return symbole;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setVue(Boolean vue) {
        this.vue = vue;
    }

    public Boolean getVue() {
        return vue;
    }
    public void setElement(Element Element) {
        this.Element = Element;
    }

    public Element getElement() {
        return Element;
    }
}
