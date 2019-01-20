package model.Vertex;


public class Voltmeter extends Vertex {

    private String name = "Voltmeter";
    private double voltage = 1;
    private boolean isConnected;

    @Override
    public double getParameter() {
        return voltage;
    }

    @Override
    public void setParameter(double parameter) {
        voltage = parameter;
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

    public boolean isConnected(){
        return isConnected;
    }

    @Override
    public String getName() {
        return name;
    }
}
