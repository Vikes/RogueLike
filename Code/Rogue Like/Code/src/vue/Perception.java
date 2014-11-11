package vue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import controleur.Partie;



public class Perception extends JOptionPane{
       
       //
       // Fields
       //
       
       

       //
       // Methods
       //
    public Perception(){
        JOptionPane jop = new JOptionPane();
    }
       
    public static int showPerception(int ForceMonstre,int Or, Perception jop) {
        
        
        int test=jop.showConfirmDialog(null, "Force totale des monstres : "+ForceMonstre+"\nNombre de pièces d'or : "+Or+"\nVoulez-vous emprunter cet escalier ?", "Utilisation d'escalier",
        JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        
        return test;
    }
    
  // public static  void main(String[] args) {
    //   System.out.println("tortue");
      // Perception jop=new Perception();
       //Integer test=showPerception(100,10,jop);
       //System.out.println(test);
   //}

}
