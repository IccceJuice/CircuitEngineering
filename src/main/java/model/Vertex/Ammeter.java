package model.Vertex;


public class Ammeter extends Vertex {

    private double amperage = 0;
    private String name = "Ammeter";


    public double getAmperage() {
        return amperage;
    }

    public void setAmperage(double amperage) {
        this.amperage = amperage;
    }

    public void draw() {
        System.out.println(name);
    }
}
