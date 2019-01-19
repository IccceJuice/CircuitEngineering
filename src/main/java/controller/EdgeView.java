package controller;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class EdgeView {
    private Line line;
    private double startX = 0;
    private double startY = 0;
    private double endX = 0;
    private double endY = 0;
    private ElementView startEl;
    private ElementView endEl;

    EdgeView(ElementView startEl, ElementView endEl) {
        this.startEl = startEl;
        this.endEl = endEl;
        calculatePos();
        line = new Line(startX, startY, endX, endY);
        line.setStrokeWidth(2);
        line.setVisible(true);
        line.setStroke(Color.BLACK);
        line.setOnMouseClicked(event -> {
            if(event.getClickCount() == 2){

            }
        });
    }

    public Line getLine() {
        return line;
    }

    public void calculatePos(){
        if (startEl.getRotate() == ElementView.Rotate.vertical){
            startX = startEl.getImageView().getTranslateX() + 28;
            startY = startEl.getImageView().getTranslateY();
        }

        if (startEl.getRotate() == ElementView.Rotate.horizontal){
            startX = startEl.getImageView().getTranslateX() + 56;
            startY = startEl.getImageView().getTranslateY() + 27;
        }

        if (endEl.getRotate() == ElementView.Rotate.vertical){
            endX = endEl.getImageView().getTranslateX() + 28;
            endY = endEl.getImageView().getTranslateY() + 56;
        }
        if (endEl.getRotate() == ElementView.Rotate.horizontal){
            endX = endEl.getImageView().getTranslateX();
            endY = endEl.getImageView().getTranslateY() + 27;
        }

    }
}
