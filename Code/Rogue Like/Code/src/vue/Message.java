package vue;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Message extends JPanel{
   
    private JLabel message;
    
    public Message(){
        super(new FlowLayout());
        this.setBorder(BorderFactory.createLineBorder((Color.black)));
        message = new JLabel("Les ténèbres vous traquent ...");
        this.add(message);
    }

    public void setMessage(String message) {
        this.message.setText(message);
    }

    public JLabel getMessage() {
        return message;
    }
}
