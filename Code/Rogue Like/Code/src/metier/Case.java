package metier;

public class Case {
    /** Classe repr�sentant les cases du jeu */
    private int positionX;  // Position en X de la case
    private char symbole;   // Symbole de la case
    private int positionY;  // Position en Y de la case
    private Boolean vue;    // Boolean informant si la case est d�couverte ou non sur le plateau
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
     * M�thode qui modifie la position en X de la case
     * @param Position en X de la case
     */
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }
    /**
     * M�thode renvoyant le type d'un �l�ment
     * @return le type de l'�l�ment test�
     */
    public String getType() {
        return "Case";
    }
    /**
     * M�thode renvoyant la position en X de la case
     * @return la position en X de la case
     */
    public int getPositionX() {
        return positionX;
    }
    /**
     * M�thode qui modifie le symbole de la case
     * @param Symbole de la case
     */
    public void setSymbole(char symbole) {
        this.symbole = symbole;
    }
    
    /**
     * M�thode qui modifie le symbole de la case en fonction du type de l'�l�ment
     */
    public void setSymbole(){
        if(this.getElement()!=null){
            if(this.getElement().getType()=="Potion")
                this.setSymbole('p');
            else if(this.getElement().getType()=="Tr�sor")
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
     * M�thode renvoyant le symbole de la case
     * @return le symbole de la case
     */
    public char getSymbole() {
        return symbole;
    }
    /**
     * M�thode qui modifie la position Y de la case
     * @param Position Y de la case
     */
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
    /**
     * M�thode renvoyant la position en Y de la case
     * @return la position en Y de la case
     */
    public int getPositionY() {
        return positionY;
    }
    /**
     * M�thode qui modifie le boolean de visibilit� de la case
     * @param Boolean de visibilit�
     */
    public void setVue(Boolean vue) {
        this.vue = vue;
    }
     /**
      * M�thode renvoyant le boolean de visibilit� de la case
      * @return Boolean de visibilit�
      */
    public Boolean getVue() {
        return vue;
    }
    /**
     * M�thode qui modifie l'�l�ment occupant la case
     * @param Element de la case
     */
    public void setElement(Element Element) {
        this.Element = Element;
        this.setSymbole();
    }
    /**
     * M�thode renvoyant l'�l�ment occupant la case
     * @return Element de la case
     */
    public Element getElement() {
        return Element;
    }
}
   
