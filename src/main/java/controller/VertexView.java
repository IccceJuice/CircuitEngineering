package controller;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class VertexView {
    private double imageX = 0;
    private double imageY = 0;
    private double labelX = 0;
    private double labelY = 0;
    private ImageView imageView;
    private Label label;

    public VertexView(double offsetX, double Y, double offsetY, Image image, String text){
        imageView = new ImageView(image);
        label = new Label(text);
        imageView.setFitWidth(56);
        imageView.setFitHeight(56);
        imageView.setTranslateX(30);
        imageView.setTranslateY(Y);
        imageView.setVisible(true);
        imageView.setPreserveRatio(true);
        imageView.setPickOnBounds(true);
        label.setMinSize(20, 12);
        label.setTranslateX(30 + offsetX);
        label.setTranslateY(Y + offsetY);
        label.setVisible(true);
        label.setPickOnBounds(true);
        imageView.setOnMousePressed(e -> {
            imageX = imageView.getTranslateX() - e.getSceneX();
            imageY = imageView.getTranslateY() - e.getSceneY();
            labelX = label.getTranslateX() - e.getSceneX();
            labelY = label.getTranslateY() - e.getSceneY();
        });
        imageView.setOnMouseDragged(e -> {
            imageView.setTranslateX(imageX + e.getSceneX());
            imageView.setTranslateY(imageY + e.getSceneY());
            label.setTranslateX(labelX + e.getSceneX());
            label.setTranslateY(labelY + e.getSceneY());
        });
    }
    public ImageView getImageView() {
        return imageView;
    }


    public void setTextLabel(String text) {
        label.setText(text);
    }

    public Label getLabel() {
        return label;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }
}
