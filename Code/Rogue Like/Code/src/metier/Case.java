package metier;

public class Case {
   
    private int positionX;
    private char symbole;
    private int positionY;
    private Boolean vue;
    Element Element;


    public Case(int positionX, int positionY) {
        super();
        this.positionX = positionX;
        this.positionY = positionY;
        this.symbole = '.';
        vue = false;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public String getType() {
        return "Case";
    }
    public int getPositionX() {
        return positionX;
    }

    public void setSymbole(char symbole) {
        this.symbole = symbole;
    }
    
    
    public void setSymbole(){
        if(this.getElement()!=null){
            if(this.getElement().getType()=="Potion")
                this.setSymbole('p');
            else if(this.getElement().getType()=="Trésor")
                this.setSymbole('$');
            else if(this.getElement().getType()=="Sortie")
                this.setSymbole('O');
            else if(this.getElement().getType()=="Monstre")
                this.setSymbole('E');
        }
        else
            this.setSymbole('.');
    }
    
    public char getSymbole() {
        return symbole;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setVue(Boolean vue) {
        this.vue = vue;
    }

    public Boolean getVue() {
        return vue;
    }
    public void setElement(Element Element) {
        this.Element = Element;
        this.setSymbole();
    }
    
    public Element getElement() {
        return Element;
    }
}
   
