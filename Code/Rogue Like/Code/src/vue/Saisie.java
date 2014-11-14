package vue;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Saisie extends JPanel{
    /**
     * @attribute
     */
    
    private JTextField tfDeplacement = new JTextField(5);
    
    private JLabel jlDeplacement = new JLabel("Votre deplacement (Z,Q,S,D) :");
    private String touche;


    public void setTfDeplacement(JTextField tfDeplacement) {
        this.tfDeplacement = tfDeplacement;
    }

    public JTextField getTfDeplacement() {
        return tfDeplacement;
    }

    public void setJlDeplacement(JLabel jlDeplacement) {
        this.jlDeplacement = jlDeplacement;
    }

    public JLabel getJlDeplacement() {
        return jlDeplacement;
    }

    public void setTouche(String touche) {
        this.touche = touche;
    }

    public String getTouche() {
        return touche;
    }

    public Saisie(){
        super(new FlowLayout());
        this.add(jlDeplacement);
        this.add(tfDeplacement);
    }
}
