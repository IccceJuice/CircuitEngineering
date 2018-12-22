package controller;

import javafx.scene.image.ImageView;

public abstract class ViewVertex {
    private double X = 0;
    private double Y = 0;
    private ImageView imageView;




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
}
