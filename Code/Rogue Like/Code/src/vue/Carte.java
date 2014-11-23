package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;


import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import metier.Case;


public class  Carte  extends JPanel {
    /**Classe de création de la carte du jeu*/
    private JTextArea carte;
    
    //private String[] carte;
    public  Carte() {
        super(new BorderLayout()); 
        this.setPreferredSize(new Dimension(100,100));
        this.setBorder(BorderFactory.createLineBorder((Color.black)));
        Font resultFont = new Font("monospaced", Font.PLAIN, 12);
        carte = new JTextArea();
        carte.setEditable(false);
        carte.setFont(resultFont);
        this.add(carte,BorderLayout.CENTER);
    }

    /**
     * Méthode qui modifie le JTextArea carte
     * @param JTextArea carte
     */   
    public void setCarte(JTextArea carte) {
        this.carte = carte;
    }
    /**
     * Méthode renvoyant le JTextArea carte
     * @return JTextArea carte
     */
    public JTextArea getCarte() {
        return carte;
    }
    /**
     * Méthode qui modifie le JTextArea carte avec une liste de case
     * @param List<Case> lstCase
     */ 
    public void setCarteText(List<Case> lstCase) {
        String map=" ";
        String map2=" ";
        Case caseactuelle;
        int ligneactuelle = 0;
        for(int i = 0;i<lstCase.size();i++) {
            caseactuelle = lstCase.get(i);
            if(caseactuelle.getPositionX()!=ligneactuelle) {
                ligneactuelle=caseactuelle.getPositionX();
                map=map+"\n ";
                map2+="\n";
            }
            if(caseactuelle.getVue())
            map=map+caseactuelle.getSymbole()+ " ";
            else
            map=map+"  ";
            map2=map2+caseactuelle.getSymbole()+ " ";
        }
        map+="";
        //System.out.println(map2);
        this.getCarte().setText(map);
    }

}
