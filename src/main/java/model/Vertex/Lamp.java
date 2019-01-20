package model.Vertex;

import javafx.scene.image.Image;

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
    public Vertex getTop() {
        return null;
    }

    @Override
    public Vertex getBottom() {
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    public void turnOnElement(){
        this.getElementView().getImageView().setImage(new Image("/elements/lampOn.png"));
    }

    public void turnOffElement(){
        this.getElementView().getImageView().setImage(new Image("/elements/lampOff.png"));
    }

}
