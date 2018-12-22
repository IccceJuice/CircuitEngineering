package controller;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ViewBattery extends ViewVertex {
    private double X = 0;
    private double Y = 0;
    private ImageView imageView;

    ViewBattery(Image image){
        imageView = new ImageView(image);
        imageView.setFitWidth(56);
        imageView.setFitHeight(56);
        imageView.setTranslateX(30);
        imageView.setTranslateY(80);
        imageView.setVisible(true);
        imageView.setPreserveRatio(true);
        imageView.setPickOnBounds(true);
        imageView.setOnMouseClicked(e -> {
            X = imageView.getTranslateX() - e.getSceneX();
            Y = imageView.getTranslateY() - e.getSceneY();
        });
        imageView.setOnMouseDragged(e -> {
            imageView.setTranslateX(X + e.getSceneX());
            imageView.setTranslateY(Y + e.getSceneY());
        });

    }
    public ImageView getImageView() {
        return imageView;
    }
}
