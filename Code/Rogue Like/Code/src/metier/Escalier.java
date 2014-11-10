package metier;

public class Escalier extends Case {

    private boolean desc;
    Salle Salle;


    public Escalier(int posx, int posy, boolean desc, Salle salle) {
        super(posx, posy);
        this.desc = desc;
        this.Salle = salle;
        this.setSymbole();
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
        return this.Salle.getMonstres();
    }

    
    public void setSymbole() {
        if (this.isDesc()) {
            super.setSymbole('<');
        } else {
            super.setSymbole('>');
        }
    }
}