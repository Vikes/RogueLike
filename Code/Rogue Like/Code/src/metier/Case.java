package metier;

public class Case {
    /** Classe représentant les cases du jeu */
    private int positionX;  // Position en X de la case
    private char symbole;   // Symbole de la case
    private int positionY;  // Position en Y de la case
    private Boolean vue;    // Boolean informant si la case est découverte ou non sur le plateau
    Element Element;        // Element qu'occupe la case 


    /**
     * Constructeur
     * @param Position en X de la case
     * @param Position en Y de la case
     */
    public Case(int positionX, int positionY) {
        super();
        this.positionX = positionX;
        this.positionY = positionY;
        this.symbole = '.';
        vue = false;
    }
    /**
     * Méthode qui modifie la position en X de la case
     * @param Position en X de la case
     */
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }
    /**
     * Méthode renvoyant le type d'un élément
     * @return le type de l'élément testé
     */
    public String getType() {
        return "Case";
    }
    /**
     * Méthode renvoyant la position en X de la case
     * @return la position en X de la case
     */
    public int getPositionX() {
        return positionX;
    }
    /**
     * Méthode qui modifie le symbole de la case
     * @param Symbole de la case
     */
    public void setSymbole(char symbole) {
        this.symbole = symbole;
    }
    
    /**
     * Méthode qui modifie le symbole de la case en fonction du type de l'élément
     */
    public void setSymbole(){
        if(this.getElement()!=null){
            if(this.getElement().getType()=="Potion")
                this.setSymbole('p');
            else if(this.getElement().getType()=="Trésor")
                this.setSymbole('$');
            else if(this.getElement().getType()=="Sortie")
                this.setSymbole('O');
            else if(this.getElement().getType()=="Monstre")
                this.setSymbole('E');
        }
        else
            this.setSymbole('.');
    }
    /**
     * Méthode renvoyant le symbole de la case
     * @return le symbole de la case
     */
    public char getSymbole() {
        return symbole;
    }
    /**
     * Méthode qui modifie la position Y de la case
     * @param Position Y de la case
     */
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
    /**
     * Méthode renvoyant la position en Y de la case
     * @return la position en Y de la case
     */
    public int getPositionY() {
        return positionY;
    }
    /**
     * Méthode qui modifie le boolean de visibilité de la case
     * @param Boolean de visibilité
     */
    public void setVue(Boolean vue) {
        this.vue = vue;
    }
     /**
      * Méthode renvoyant le boolean de visibilité de la case
      * @return Boolean de visibilité
      */
    public Boolean getVue() {
        return vue;
    }
    /**
     * Méthode qui modifie l'élément occupant la case
     * @param Element de la case
     */
    public void setElement(Element Element) {
        this.Element = Element;
        this.setSymbole();
    }
    /**
     * Méthode renvoyant l'élément occupant la case
     * @return Element de la case
     */
    public Element getElement() {
        return Element;
    }
}
   
