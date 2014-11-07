package metier;

public class Monstre extends Element {
   
    private int forceMonstre;
    private int argentMonstre;
    private Boolean enVie;
    
    public Monstre(int force,int argent) {
        this.forceMonstre=force;
        this.argentMonstre=argent;
        this.enVie=true;
    }

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

    @Override
    public Element getElement() {
        Element res=this;
        return res ;
    }

    @Override
    public String getType() {
        String res = "Monstre";
        return res;
    }
}
