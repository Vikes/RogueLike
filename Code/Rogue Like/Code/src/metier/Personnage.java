package metier;

public class Personnage {
    /** Classe représentant le personnage du jeu */
    private int argentPersonnage;// Argent du personnage
    private Boolean enVie;// Boolean informant si le personnage est en cie ou non 
    private int forcePersonnage;// Force du personnage
    private String nomPersonnage;// Nom du personnage
    Case Case;// Case qu'occupe le personnage
   
    /**
     * Constructeur
     * @param Nom du personnage
     */
    public Personnage(String nom) {
        this.argentPersonnage=0;
        this.forcePersonnage=1;
        this.nomPersonnage=nom;
        this.enVie=true;
    }
    /**
     * Méthode qui modifie l'argent du personnage 
     * @param Argent du personnage 
     */   
    public void setArgentPersonnage(int argentPersonnage) {
        this.argentPersonnage = argentPersonnage;
    }
    /**
     * Méthode renvoyant l'argent du personnage
     * @return Argent du personnage
     */
    public int getArgentPersonnage() {
        return argentPersonnage;
    }
    /**
     * Méthode qui modifie le boolean de vie du personnage 
     * @param Boolean de vie du personnage 
     */   
    public void setEnVie(Boolean enVie) {
        this.enVie = enVie;
    }
    /**
     * Méthode renvoyant le boolean de vie du personnage 
     * @return Boolean de vie du personnage 
     */
    public Boolean getEnVie() {
        return enVie;
    }
    /**
     * Méthode qui modifie la force du personnage
     * @param Force du personnage
     */   
    public void setForcePersonnage(int forcePersonnage) {
        this.forcePersonnage = forcePersonnage;
    }
    /**
     * Méthode renvoyant la force du personnage
     * @return Force du personnage
     */
    public int getForcePersonnage() {
        return forcePersonnage;
    }
    /**
     * Méthode qui modifie le nom du personnage
     * @param Nom du personnage
     */
    public void setNomPersonnage(String nomPersonnage) {
        this.nomPersonnage = nomPersonnage;
    }
    /**
     * Méthode renvoyant le nom du personnage
     * @return Nom du personnage
     */
    public String getNomPersonnage() {
        return nomPersonnage;
    }
    /**
     * Méthode qui modifie la case du personnage
     * @param Case du personnage
     */  
    public void setCase(Case Case) {
        this.Case = Case;
    }
    /**
     * Méthode renvoyant la case du personnage
     * @return Case du personnage
     */
    public Case getCase() {
        return this.Case;
    }
}
