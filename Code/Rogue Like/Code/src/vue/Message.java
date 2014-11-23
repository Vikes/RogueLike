package vue;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Message extends JPanel{
    /**Classe de création du JPanel contenant les messages du jeu*/

    private JLabel message;//Label des messages
    /**Création d'un flowlayout contenant les messages*/
    public Message(){
        super(new FlowLayout());
        this.setBorder(BorderFactory.createLineBorder((Color.black)));
        message = new JLabel("Les ténèbres vous traquent ...");
        this.add(message);
    }
    /**
     * Méthode qui modifie le label des messages
     * @param Label des messages
     */
    
    public void setMessage(String message) {
        this.message.setText(message);
    }
    /**
     * Méthode renvoyant le label des messages
     * @return Label des messages
     */
    public JLabel getMessage() {
        return message;
    }
}
