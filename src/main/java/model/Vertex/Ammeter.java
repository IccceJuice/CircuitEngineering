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

    @Override
    public Vertex getTop() {
        return null;
    }

    @Override
    public Vertex getBottom() {
        return null;
    }

    @Override
    public void turnOnElement() {

    }

    @Override
    public void turnOffElement() {

    }

    @Override
    public String getName() {
        return name;
    }
}
