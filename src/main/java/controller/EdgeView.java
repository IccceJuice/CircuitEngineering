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
    EdgeView(ElementView startEl, ElementView endEl) {
        this.startEl = startEl;
        this.endEl = endEl;
        calculateView();
        calculatePos();
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
        if (startEl.getRotate() == ElementView.Rotate.vertical && height){
            startX = startEl.getImageView().getTranslateX() + 28;
            startY = startEl.getImageView().getTranslateY();
        }
        if (startEl.getRotate() == ElementView.Rotate.vertical && !height){
            startX = startEl.getImageView().getTranslateX() + 28;
            startY = startEl.getImageView().getTranslateY() + 56;
        }
        if (startEl.getRotate() == ElementView.Rotate.horizontal && width){
            startX = startEl.getImageView().getTranslateX() + 56;
            startY = startEl.getImageView().getTranslateY() + 28;
        }
        if (startEl.getRotate() == ElementView.Rotate.horizontal && !width){
            startX = startEl.getImageView().getTranslateX();
            startY = startEl.getImageView().getTranslateY() + 28;
        }
        if (endEl.getRotate() == ElementView.Rotate.vertical && height){
            endX = endEl.getImageView().getTranslateX() + 28;
            endY = endEl.getImageView().getTranslateY() + 56;
        }
        if (endEl.getRotate() == ElementView.Rotate.vertical && !height){
            endX = endEl.getImageView().getTranslateX() + 28;
            endY = endEl.getImageView().getTranslateY();
        }
        if (endEl.getRotate() == ElementView.Rotate.horizontal && width){
            endX = endEl.getImageView().getTranslateX();
            endY = endEl.getImageView().getTranslateY() + 28;
        }
        if (endEl.getRotate() == ElementView.Rotate.horizontal && !width){
            endX = endEl.getImageView().getTranslateX() + 56;
            endY = endEl.getImageView().getTranslateY() + 28;
        }
    }
}
