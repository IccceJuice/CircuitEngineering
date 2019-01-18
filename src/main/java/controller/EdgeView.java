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
    private boolean height;
    private boolean width;
    EdgeView() {
        line = new Line(startX, startY, endX, endY);
        line.setStrokeWidth(2);
        line.setVisible(true);
        line.setStroke(Color.BLACK);

    }

    public void setStartEl(ElementView startEl) {
        this.startEl = startEl;
    }

    public void setEndEl(ElementView endEl) {
        this.endEl = endEl;
    }

    public Line getLine() {
        return line;
    }
    private void calculateView(){
        if (startEl.getImageView().getTranslateX() < endEl.getImageView().getTranslateX()){
            width = true;
        }
        else {
            width = false;
        }
        if(startEl.getImageView().getTranslateY() < endEl.getImageView().getTranslateY()){
            height = true;
        }
        else {
            height = false;
        }
    }
    
    public void calculatePos(){
        if (startEl.getRotate() == ElementView.Rotate.vertical){
            startX = startEl.getImageView().getTranslateX() + 28;
            startY = startEl.getImageView().getTranslateY();
        }
        else {
            startX = startEl.getImageView().getTranslateX();
            startY = startEl.getImageView().getTranslateY();
        }
    }
}
