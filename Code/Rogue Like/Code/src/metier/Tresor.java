package metier;

public class Tresor extends Element {
   
    private int argentTresor;

    /**
     * Constructeur
     * @param Argent du tr�sor
     */
    public Tresor(int argentTresor) {
        super();
        this.argentTresor = argentTresor;
    }
    /**
     * M�thode qui modifie l'argent du tr�sor
     * @param Argent du tr�sor
     */
  
    public void setArgentTresor(int argentTresor) {
        this.argentTresor = argentTresor;
    }
    
    /**
     * M�thode renvoyant l'argent du tr�sor
     * @return Argent du tr�sor
     */
    public int getArgentTresor() {
        return argentTresor;
    }
    /**
     * M�thode renvoyant l'�l�ment tr�sor
     * @return El�ment tr�sor
     */
      
    @Override
    public Element getElement() {
        return this;
    }
    /**
    * M�thode renvoyant le type tr�sor
    * @return Type tr�sor de l'�l�ment
    */
    @Override
    public String getType() {
        String res = "Tr�sor";
        return res;
    }
}
