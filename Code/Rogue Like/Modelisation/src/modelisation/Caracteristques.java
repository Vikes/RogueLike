package modelisation;

public class Caracteristques {
    
    private int force;

    private int nbEnnemis;

    private int gold;

    private int niveauAct;

    private int[] getCaracteristique() {
        int [] carac = new int[4];
        carac[0]=Partie.getInstance().Personnage.getForcePersonnage();
        carac[1]=Partie.getInstance().salleActu.getMonstres();
        carac[2]=Partie.getInstance().Personnage.getArgentPersonnage();
        carac[3]=Partie.getInstance().salleActu.getNiveau();
        
        return carac;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public int getForce() {
        return force;
    }

    public int getNbEnnemis() {
        return nbEnnemis;
    }

    public int getGold() {
        return gold;
    }

    public int getNiveauAct() {
        return niveauAct;
    }

    public void setNbEnnemis(int nbEnnemis) {
        this.nbEnnemis = nbEnnemis;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setNiveauAct(int niveauAct) {
        this.niveauAct = niveauAct;
    }
}
