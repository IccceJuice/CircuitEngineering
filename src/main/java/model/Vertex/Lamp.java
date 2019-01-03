package model.Vertex;

public class Lamp extends Vertex {

    private String name = "Lamp";
    private boolean isConnected = false;

    private boolean isConnected(){
        return isConnected;
    }

    public void draw() {
        System.out.println(name);
    }

    @Override
    public String getName() {
        return name;
    }
}
