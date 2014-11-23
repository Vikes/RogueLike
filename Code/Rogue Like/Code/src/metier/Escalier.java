package metier;

import java.util.List;

public class Escalier extends Case {
    /** Classe repr�sentant les escaliers du jeu */
    private boolean desc;// Boolean informant si l'escalier est descendant ou non
    Salle Salle;   // Salle dans laquelle est l'escalier

    /**
     * Constructeur
     * @param Position en X de l'escalier
     * @param Position en Y de l'escalier
     * @param Boolean informant si l'escalier est descendant ou non
     * @param Salle dans laquelle l'escalier se trouve
     */
    public Escalier(int posx, int posy, boolean desc, Salle salle) {
        super(posx, posy);
        this.desc = desc;
        this.Salle = salle;
        this.setSymbole();
    }
    /**
     * M�thode renvoyant le type de l'escalier
     * @return Le type de l'escalier
     */
    public String getType() {
        return "Escalier";
    }
    /**
     * Constructeur
     * @param Position en X de l'escalier
     * @param Position en Y de l'escalier
     */
    public Escalier(int posx, int posy) {
        super(posx, posy);
    }
    /**
     * M�thode qui modifie la position en X de la case
     * @param Position en X de la case
     */
    public void setDesc(boolean desc) {
        this.desc = desc;
    }
    /**
     * M�thode renvoyant le Boolean de descente de l'escalier
     * @return Boolean de descente de l'escalier
     */
    public boolean isDesc() {
        return desc;
    }
    /**
     * M�thode qui modifie la salle de l'escalier
     * @param Salle de l'escalier
     */
    public void setSalle(Salle Salle) {
        this.Salle = Salle;
    }
    /**
     * M�thode renvoyant la salle de l'escalier
     * @return Salle de l'escalier
     */
    public Salle getSalle() {
        return Salle;
    }

    /**
     * M�thode renvoyant l'or pr�sent dans la salle et les salles suivantes
     * @return Or pr�sent dans la salle et les salles suivantes
     */
    public int getOr() {

        int res = 0;
        List<Case> listCase = this.getSalle().getLstCase();
        System.out.println(this.getSalle().getNiveau());
        for (int i = 0; i < listCase.size(); i++) {

            Case caseActuelle = listCase.get(i);
            if (caseActuelle.getElement() != null) {
                if (caseActuelle.getElement().getType() == "Tr�sor") {
                    Tresor caseActuelleTresor = (Tresor) caseActuelle.getElement();
                    res += caseActuelleTresor.getArgentTresor();


                }
            } else if (caseActuelle.getType() == "Escalier") {

                Escalier caseActuelleEscalier = (Escalier) caseActuelle;
                if (!caseActuelleEscalier.isDesc()) {

                    res += caseActuelleEscalier.getOr();
                }
            }
        }
        return res;
    }
    /**
     * M�thode renvoyant les monstres pr�sents dans la salle et les salles suivantes
     * @return Monstres pr�sents dans la salle et les salles suivantes
     */
    public int getMonstres() {
        int res = 0;
        List<Case> listCase = this.getSalle().getLstCase();
        for (int i = 0; i < listCase.size(); i++) {
            Case caseActuelle = listCase.get(i);
            if (caseActuelle.getElement() != null) {
                if (caseActuelle.getElement().getType() == "Monstre") {
                    Monstre m = (Monstre) caseActuelle.getElement();
                    res += m.getForceMonstre();
                }
            } else if (caseActuelle.getType() == "Escalier") {
                Escalier caseActuelleEscalier = (Escalier) caseActuelle;
                if (!caseActuelleEscalier.isDesc()) {
                    res+=caseActuelleEscalier.getMonstres();
                }
            }
        }
        return res;
    }

    /**
     * M�thode qui modifie le symbole de l'escalier 
     * @param Symbole de l'escalier 
     */
    public void setSymbole() {
        if (this.isDesc()) {
            super.setSymbole('<');
        } else {
            super.setSymbole('>');
        }
    }
}
