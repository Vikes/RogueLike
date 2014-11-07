package metier;

public class Personnage {
   
    private int argentPersonnage;
    private Boolean enVie;
    private int forcePersonnage;
    private String nomPersonnage;
    Case Case;
    
    public Personnage(int argent,int force,String nom) {
        this.argentPersonnage=argent;
        this.forcePersonnage=force;
        this.nomPersonnage=nom;
        this.enVie=true;
    }
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
