package vue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import controleur.Partie;



public class Perception extends JOptionPane{
       
    /**Classe de cr�ation du JOptionPane du jeu, apparaissant lorsque le personnage passe sur un escalier montant*/
/** Constructeur de JPptionPane*/
    public Perception(){
        JOptionPane jop = new JOptionPane();
    }
    /**
     * M�thode renvoyant 0 si la personne appuie sur le bouton ok, 1 sinon
     * @param Force des monstres derri�re l'escalier
     * @param Or derri�re l'escalier
     * @return Int r�ponse
     */
    public int showPerception(int ForceMonstre,int Or) {
        
        
        int test=this.showConfirmDialog(null, "Force totale des monstres : "+ForceMonstre+"\nNombre de pi�ces d'or : "+Or+"\nVoulez-vous emprunter cet escalier ?", "Utilisation d'escalier",
        JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        
        return test;
    } 


}
