package metier;

public class Sortie extends Element {
    /** Classe représentant la sortie du jeu */
    
    /**
     * Méthode renvoyant l'élément sortie
     * @return Elément sortie
     */
    @Override
    public Element getElement() {
        return this;
    }
    
    /**
     * Méthode renvoyant le type sortie
     * @return Type sortie de l'élément
     */
    @Override
    public String getType() {
        String res = "Sortie";
        return res;
    }
}
