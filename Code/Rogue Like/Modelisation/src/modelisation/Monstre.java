package modelisation;

public class Monstre extends Element {
   
    private int forceMonstre;
    private int argentMonstre;
    private Boolean enVie;

    public void setForceMonstre(int forceMonstre) {
        this.forceMonstre = forceMonstre;
    }

    public int getForceMonstre() {
        return forceMonstre;
    }

    public void setArgentMonstre(int argentMonstre) {
        this.argentMonstre = argentMonstre;
    }

    public int getArgentMonstre() {
        return argentMonstre;
    }

    public void setEnVie(Boolean enVie) {
        this.enVie = enVie;
    }

    public Boolean getEnVie() {
        return enVie;
    }
}
