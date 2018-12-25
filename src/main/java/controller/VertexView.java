package controller;

import javafx.scene.image.ImageView;
import model.Vertex;


public abstract class VertexView {
    private double X;
    private double Y;
    private ImageView imageView;
    private Vertex vertex;


    public ImageView getImageView() {
        return imageView;
    }
    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public double getY() {
        return Y;
    }

    public double getX() {
        return X;
    }

    public void setY(double y) {
        Y = y;
    }

    public void setX(double x) {
        X = x;
    }

    public Vertex getVertex() {
        return vertex;
    }

    public void setVertex(Vertex vertex) {
        this.vertex = vertex;
    }
}
