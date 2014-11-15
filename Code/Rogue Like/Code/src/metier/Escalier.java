package metier;

import java.util.List;

public class Escalier extends Case {

    private boolean desc;
    Salle Salle;


    public Escalier(int posx, int posy, boolean desc, Salle salle) {
        super(posx, posy);
        this.desc = desc;
        this.Salle = salle;
        this.setSymbole();
    }

    public String getType() {
        return "Escalier";
    }

    public Escalier(int posx, int posy) {
        super(posx, posy);
    }

    public void setDesc(boolean desc) {
        this.desc = desc;
    }

    public boolean isDesc() {
        return desc;
    }

    public void setSalle(Salle Salle) {
        this.Salle = Salle;
    }

    public Salle getSalle() {
        return Salle;
    }


    public int getOr() {

        int res = 0;
        List<Case> listCase = this.getSalle().getLstCase();
        System.out.println(this.getSalle().getNiveau());
        for (int i = 0; i < listCase.size(); i++) {

            Case caseActuelle = listCase.get(i);
            if (caseActuelle.getElement() != null) {
                if (caseActuelle.getElement().getType() == "Trésor") {
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


    public void setSymbole() {
        if (this.isDesc()) {
            super.setSymbole('<');
        } else {
            super.setSymbole('>');
        }
    }
}
