package controller;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.util.ArrayList;

public class EdgeView {
    private Line line1 = new Line();
    private Line line2 = new Line();
    private Line line3 = new Line();
    private double startX = 0;
    private double startY = 0;
    private double endX = 0;
    private double endY = 0;
    private VertexView startEl;
    private VertexView endEl;
    private ArrayList<Line> lines = new ArrayList<Line>();

    EdgeView(VertexView startEl, VertexView endEl) {
        this.startEl = startEl;
        this.endEl = endEl;
        calculatePos();
        line1.setStrokeWidth(2);
        line1.setVisible(true);
        line1.setStroke(Color.BLACK);
        line2.setStrokeWidth(2);
        line2.setVisible(true);
        line2.setStroke(Color.BLACK);
        line3.setStrokeWidth(2);
        line3.setVisible(true);
        line3.setStroke(Color.BLACK);
    }

    public ArrayList<Line> getLines() {
        return lines;
    }

    public void calculatePos(){
        if (startEl.getRotate() == VertexView.Rotate.vertical){
            startX = startEl.getImageView().getTranslateX() + 27;
            startY = startEl.getImageView().getTranslateY();
        }

        if (startEl.getRotate() == VertexView.Rotate.horizontal){
            startX = startEl.getImageView().getTranslateX() + 56;
            startY = startEl.getImageView().getTranslateY() + 27;
        }

        if (endEl.getRotate() == VertexView.Rotate.vertical){
            endX = endEl.getImageView().getTranslateX() + 27;
            endY = endEl.getImageView().getTranslateY() + 56;
        }
        if (endEl.getRotate() == VertexView.Rotate.horizontal){
            endX = endEl.getImageView().getTranslateX();
            endY = endEl.getImageView().getTranslateY() + 28;
        }
        calcHigh();
        lines.add(line1);
        lines.add(line2);
        lines.add(line3);
    }
    public void calcHigh(){
        if (startX == endX){
            line1.setStartX(startX);
            line1.setStartY(startY);
            line1.setEndX(endX);
            line1.setEndY(endY);

        }
        if (startX < endX){
            line1.setStartX(startX);
            line1.setStartY(startY);
            line1.setEndX(startX);
            line1.setEndY(endY);
            line2.setStartX(startX);
            line2.setStartY(endY);
            line2.setEndX(endX);
            line2.setEndY(endY);
            line3.setStartX(0);
            line3.setStartY(0);
            line3.setEndX(0);
            line3.setEndY(0);
        }
        if (startY > endY){
            if (startX > endX){
                line1.setStartX(startX);
                line1.setStartY(startY);
                line1.setEndX(endX);
                line1.setEndY(startY);
                line2.setStartX(endX);
                line2.setStartY(startY);
                line2.setEndX(endX);
                line2.setEndY(endY);
                line3.setStartX(0);
                line3.setStartY(0);
                line3.setEndX(0);
                line3.setEndY(0);
            }
        }
        else {
            if (startX > endX){
                line1.setStartX(startX);
                line1.setStartY(startY);
                line1.setEndX(startX);
                line1.setEndY(endY+56);
                line2.setStartX(startX);
                line2.setStartY(endY + 56);
                line2.setEndX(endX);
                line2.setEndY(endY + 56);
                line3.setStartX(endX);
                line3.setStartY(endY + 56);
                line3.setEndX(endX);
                line3.setEndY(endY);
            }
        }
    }
}
