package controller.VIew;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ViewResistor extends VertexView{
    private double X = 0;
    private double Y = 0;
    private ImageView imageView;

    public ViewResistor(Image image){
        imageView = new ImageView(image);
        imageView.setFitWidth(56);
        imageView.setFitHeight(56);
        imageView.setTranslateX(30);
        imageView.setTranslateY(170);
        imageView.setVisible(true);
        imageView.setPreserveRatio(true);
        imageView.setPickOnBounds(true);
        imageView.setOnMousePressed(e -> {
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

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }
}