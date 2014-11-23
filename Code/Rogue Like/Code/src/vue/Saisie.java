package vue;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Saisie extends JPanel{
    /**Classe de cr�ation du JPanel d'entr�e des touches de d�placement du jeu*/

    
    private JTextField tfDeplacement = new JTextField(5);
    
    private JLabel jlDeplacement = new JLabel("Votre deplacement (Z,Q,S,D) :");
    private String touche;//Caract�re que la personne rentrera pour se d�placer

    /**
     * M�thode qui modifie le JTextField de d�placement
     * @param JTextField de d�placement
     */
   
    public void setTfDeplacement(JTextField tfDeplacement) {
        this.tfDeplacement = tfDeplacement;
    }
    /**
     * M�thode renvoyant JTextField de d�placement
     * @return JTextField de d�placement
     */
    public JTextField getTfDeplacement() {
        return tfDeplacement;
    }
    /**
     * M�thode qui modifie le JLabel de d�placement
     * @param JLabel de d�placement
     */
    public void setJlDeplacement(JLabel jlDeplacement) {
        this.jlDeplacement = jlDeplacement;
    }
    /**
     * M�thode renvoyant le JLabel de d�placement
     * @return JLabel de d�placement
     */
    public JLabel getJlDeplacement() {
        return jlDeplacement;
    }
    /**
     * M�thode qui modifie la touche saisie
     * @param Touche de saisie
     */
    public void setTouche(String touche) {
        this.touche = touche;
    }
    /**
     * M�thode renvoyant la touche saisie
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
