package vue;

import controleur.Partie;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;


public class Caracteristiques extends JPanel {
    
    private int force;//Force du personnage
    private int nbEnnemis;//Nombre d'ennemis 
    private int gold;//Argent du personnage
    private int niveauAct;//Niveau actuel du personnage 
    private int demin;//Nombre d'ennemis devant le personnage
    private JLabel lblForce = new JLabel();//Label de la force du personnage 
    private JLabel lblGold = new JLabel();//Label de l'argent du personnage
    private JLabel lblNbEnnemis = new JLabel();//Label du nombre d'ennemis
    private JLabel lblNiveau = new JLabel();//Label du niveau actuel du personnage
    private JLabel lblDemin = new JLabel();//Label du nombre d'ennemis devant le personnage


    public Caracteristiques(){
       /**Création du JPanel des caractéristiques relatives au personnage*/
        
        /**
         * Constructeur
         * @param gridLayout de 5/1 cases
         */
        
       super(new GridLayout (5,1,1,5));
       
        Border line = BorderFactory.createLineBorder(Color.DARK_GRAY);
        Border empty = new EmptyBorder(10, 10, 10, 10);
        CompoundBorder border = new CompoundBorder(line, empty);
        this.setBorder(border);
        
        int carac[]=getCaracteristique();
        this.add(lblForce);
        this.add(lblGold);
        this.add(lblNiveau);
        this.add(lblNbEnnemis);
        this.add(lblDemin);
        
    }
    /** insertion des caractéristiques */
    public int[] getCaracteristique() {
        int [] carac = new int[5];
        carac[0] = Partie.getInstance().getPersonnage().getForcePersonnage();
        carac[1] = Partie.getInstance().getPersonnage().getArgentPersonnage();
        carac[2] = Partie.getInstance().getSalleActu().getMonstres();
        carac[3] = Partie.getInstance().getSalleActu().getNiveau();
        carac[4] = Partie.getInstance().getDemin();
        return carac;
    }
    /** Mise à jour des caractéristiques */
    public void update() {
            int[] carac = this.getCaracteristique();
            this.setForce(carac[0]);
            this.setGold(carac[1]);
            this.setNbEnnemis(carac[2]);
            this.setNiveauAct(carac[3]);
            this.setDemin(carac[4]);
            this.getLblForce().setText("Vous avez :" + this.getForce() + " points de force");
            this.getLblGold().setText("Vous avez  :" + this.getGold() + " pièces d'or");
            this.getLblNbEnnemis().setText("Il reste :" + this.getNbEnnemis() + " ennemis dans la salle");
            this.getLblNiveau().setText("Vous êtes au niveau :" + this.getNiveauAct());
            this.getLblDemin().setText("Il y a : " + this.getDemin() +" monstres autour de vous");
        }

    /**
     * Méthode qui modifie le nbr de monstres restant devant le personanges
     * @param Nbr de monstres restant devant le personanges
     */
   
    
    public void setDemin(int demin) {
        this.demin = demin;
    }
     /**
      * Méthode renvoyant le nbr de monstres restant devant le personanges
      * @return Nbr de monstres restant devant le personanges
      */
    public int getDemin() {
        return demin;
    }
    /**
     * Méthode qui modifie le label du nbr de monstres restant devant le personage
     * @param Label du nbr de monstres restant devant le personage
     */
    public void setLblDemin(JLabel lblDemin) {
        this.lblDemin = lblDemin;
    }
    /**
     * Méthode renvoyant le label du nbr de monstres restant devant le personage 
     * @return Label du nbr de monstres restant devant le personage
     */
    public JLabel getLblDemin() {
        return lblDemin;
    }
    /**
     * Méthode qui modifie la force du personnage
     * @param force du personnage
     */
    public void setForce(int force) {
        this.force = force;
    }
    /**
     * Méthode renvoyant la force du personnage
     * @return Force du personnage
     */
    public int getForce() {
        return force;
    }
    /**
     * Méthode renvoyant le nbr de monstres restant dans la salle
     * @return Nbr de monstres restant dans la salle
     */
    public int getNbEnnemis() {
        return nbEnnemis;
    }
    /**
     * Méthode renvoyant l'argent du personnage
     * @return Argent du personnage
     */
    public int getGold() {
        return gold;
    }
    /**
     * Méthode renvoyant le niveau actuel du personnage
     * @return Niveau actuel du personnage
     */
    public int getNiveauAct() {
        return niveauAct;
    }
    /**
     * Méthode qui modifie le nbr de monstres restant dans la salle
     * @param Nbr de monstres restant dans la salle
     */
    public void setNbEnnemis(int nbEnnemis) {
        this.nbEnnemis = nbEnnemis;
    }
    /**
     * Méthode qui modifie l'argent du personnage
     * @param Argent du personnage
     */
    public void setGold(int gold) {
        this.gold = gold;
    }
    /**
     * Méthode qui modifie le niveau actuel du personnage
     * @param Niveau actuel du personnage
     */
    public void setNiveauAct(int niveauAct) {
        this.niveauAct = niveauAct;
    }
    /**
     * Méthode qui modifie le label de la force du perso
     * @param Label de force
     */
    public void setLblForce(JLabel lblForce) {
           this.lblForce = lblForce;
       }
    /**
     * Méthode renvoyant le label de la force du perso
     * @return Label de force
     */
       public JLabel getLblForce() {
           return lblForce;
       }
    /**
     * Méthode qui modifie le label de l'argent du perso 
     * @param Label d'argent
     */
       public void setLblGold(JLabel lblGold) {
           this.lblGold = lblGold;
       }
    /**
     * Méthode renvoyant le label de l'argent du perso 
     * @return Label d'argent
     */
       public JLabel getLblGold() {
           return lblGold;
       }
    /**
     * Méthode qui modifie le label du nombre d'ennemis du perso 
     * @param Label du nombre d'ennemis du perso
     */
       public void setLblNbEnnemis(JLabel lblNbEnnemis) {
           this.lblNbEnnemis = lblNbEnnemis;
       }
    /**
     * Méthode renvoyant le label du nombre d'ennemis du perso
     * @return Label du nombre d'ennemis du perso
     */
       public JLabel getLblNbEnnemis() {
           return lblNbEnnemis;
       }
    /**
     * Méthode qui modifie le label du niveau du perso
     * @param Label du niveau
     */
       public void setLblNiveau(JLabel lblNiveau) {
           this.lblNiveau = lblNiveau;
       }
    /**
     * Méthode renvoyant le label du niveau du perso
     * @return Label du niveau
     */
       public JLabel getLblNiveau() {
           return lblNiveau;
       }
}
