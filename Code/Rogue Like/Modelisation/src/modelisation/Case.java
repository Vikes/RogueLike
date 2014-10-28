package modelisation;

public class Case {
   
    private int positionX;

    private String symbole;

    private int positionY;

    private Boolean vue;
    Element Element;

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
}
