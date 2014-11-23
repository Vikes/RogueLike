package metier;

public class Sortie extends Element {
    /** Classe repr�sentant la sortie du jeu */
    
    /**
     * M�thode renvoyant l'�l�ment sortie
     * @return El�ment sortie
     */
    @Override
    public Element getElement() {
        return this;
    }
    
    /**
     * M�thode renvoyant le type sortie
     * @return Type sortie de l'�l�ment
     */
    @Override
    public String getType() {
        String res = "Sortie";
        return res;
    }
}
