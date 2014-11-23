package metier;

public class Tresor extends Element {
   
    private int argentTresor;

    /**
     * Constructeur
     * @param Argent du trésor
     */
    public Tresor(int argentTresor) {
        super();
        this.argentTresor = argentTresor;
    }
    /**
     * Méthode qui modifie l'argent du trésor
     * @param Argent du trésor
     */
  
    public void setArgentTresor(int argentTresor) {
        this.argentTresor = argentTresor;
    }
    
    /**
     * Méthode renvoyant l'argent du trésor
     * @return Argent du trésor
     */
    public int getArgentTresor() {
        return argentTresor;
    }
    /**
     * Méthode renvoyant l'élément trésor
     * @return Elément trésor
     */
      
    @Override
    public Element getElement() {
        return this;
    }
    /**
    * Méthode renvoyant le type trésor
    * @return Type trésor de l'élément
    */
    @Override
    public String getType() {
        String res = "Trésor";
        return res;
    }
}
