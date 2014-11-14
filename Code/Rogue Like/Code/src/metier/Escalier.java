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

    public  String getType(){
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
        return this.Salle.getOr();
    }

    public int getMonstres() {
        int res=0;
        List<Case>  listCase= this.getSalle().getLstCase();
        for(int i = 0;i<listCase.size();i++) 
        {
            Case caseActuelle = listCase.get(i);
            if(caseActuelle.getType()=="Monstre") {
                res+=1;
            }
            else if (caseActuelle.getType()=="Escalier")
            {
                Escalier caseActuelleEscalier= (Escalier) caseActuelle;
                if(!caseActuelleEscalier.isDesc())
                {
                    caseActuelleEscalier.getMonstres();
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
