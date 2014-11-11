package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;


import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import metier.Case;


public class  Carte  extends JPanel {
    private JTextArea carte;
    /**
     * @attribute
     * @associates <{String}>
     */
    //private String[] carte;
    public  Carte() {
        super(new FlowLayout()); 
        this.setPreferredSize(new Dimension(100,100));
        this.setBorder(BorderFactory.createLineBorder((Color.black)));
        Font resultFont = new Font("monospaced", Font.PLAIN, 12);
        carte = new JTextArea();
        carte.setEditable(false);
        carte.setFont(resultFont);
        this.add(carte);
    }


    public void setCarte(JTextArea carte) {
        this.carte = carte;
    }

    public JTextArea getCarte() {
        return carte;
    }
    
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
