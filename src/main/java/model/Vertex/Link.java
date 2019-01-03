package model.Vertex;


public class Link  {

    private double resistance;

    private Vertex next;
    private Vertex prev;
    private String name;


    Link(){
        next = null;
        prev = null;
        name = "Link";
    }

    public boolean isIncluded() {
        return false;
    }

    public void draw() {

    }

    public double getResistance() {
        return resistance;
    }

    public void setResistance(double resistance) {
        this.resistance = resistance;
    }

    public Vertex getNext() {
        return next;
    }

    public Vertex getPrev() {
        return prev;
    }

    public void setNext(Vertex next) {
        this.next = next;
    }

    public void setPrev(Vertex prev) {
        this.prev = prev;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
