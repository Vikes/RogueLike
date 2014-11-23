package vue;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Saisie extends JPanel{
    /**Classe de création du JPanel d'entrée des touches de déplacement du jeu*/

    
    private JTextField tfDeplacement = new JTextField(5);
    
    private JLabel jlDeplacement = new JLabel("Votre deplacement (Z,Q,S,D) :");
    private String touche;//Caractère que la personne rentrera pour se déplacer

    /**
     * Méthode qui modifie le JTextField de déplacement
     * @param JTextField de déplacement
     */
   
    public void setTfDeplacement(JTextField tfDeplacement) {
        this.tfDeplacement = tfDeplacement;
    }
    /**
     * Méthode renvoyant JTextField de déplacement
     * @return JTextField de déplacement
     */
    public JTextField getTfDeplacement() {
        return tfDeplacement;
    }
    /**
     * Méthode qui modifie le JLabel de déplacement
     * @param JLabel de déplacement
     */
    public void setJlDeplacement(JLabel jlDeplacement) {
        this.jlDeplacement = jlDeplacement;
    }
    /**
     * Méthode renvoyant le JLabel de déplacement
     * @return JLabel de déplacement
     */
    public JLabel getJlDeplacement() {
        return jlDeplacement;
    }
    /**
     * Méthode qui modifie la touche saisie
     * @param Touche de saisie
     */
    public void setTouche(String touche) {
        this.touche = touche;
    }
    /**
     * Méthode renvoyant la touche saisie
     * @return Touche de saisie
     */
    public String getTouche() {
        return touche;
    }
    /**Constructeur du FlowLayout de saisie*/
    public Saisie(){
        super(new FlowLayout());
        this.add(jlDeplacement);
        this.add(tfDeplacement);
    }
}
