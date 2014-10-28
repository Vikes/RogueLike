package modelisation;

public class Personnage {
    /**
     * @attribute
     */
    private int argentPersonnage;

    /**
     * @attribute
     */
    private Boolean enVie;

    /**
     * @attribute
     */
    private int forcePersonnage;

    /**
     * @attribute
     */
    private String nomPersonnage;
    Case Case;

    public void setArgentPersonnage(int argentPersonnage) {
        this.argentPersonnage = argentPersonnage;
    }

    public int getArgentPersonnage() {
        return argentPersonnage;
    }

    public void setEnVie(Boolean enVie) {
        this.enVie = enVie;
    }

    public Boolean getEnVie() {
        return enVie;
    }

    public void setForcePersonnage(int forcePersonnage) {
        this.forcePersonnage = forcePersonnage;
    }

    public int getForcePersonnage() {
        return forcePersonnage;
    }

    public void setNomPersonnage(String nomPersonnage) {
        this.nomPersonnage = nomPersonnage;
    }

    public String getNomPersonnage() {
        return nomPersonnage;
    }
}
