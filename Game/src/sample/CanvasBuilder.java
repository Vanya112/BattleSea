package sample;
import javafx.scene.canvas.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.paint.*;
import javafx.scene.image.*;
import javafx.scene.paint.Color;
import javafx.scene.Cursor;

import javafx.scene.control.TextArea;

import java.awt.*;

public class CanvasBuilder extends Field {

    public CanvasBuilder(){
        for (int i = 0; i < 10; i++)
            for (int k = 0; k < 10; k++)
                cells[i][k] = 0;
        for (int k = 0; k < 10; k++){
            coordinatesX[k] = a;
            coordinatesY[k] = b;
            a += 30;
            b += 30;
        }
    }

    public double getCoordinatesX(int i) {
        return coordinatesX[i];
    }

    public double getCoordinatesY(int i) {
        return coordinatesY[i];
    }

    public void setMenuCanvas(Canvas canvas){
        GraphicsContext gc;
        gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.LIGHTGREEN);
        gc.fillRect(0,0,1366,728);
        Image MorBoi = new Image(this.getClass().getResource("MorBoi1.jpg").toString());
        gc.drawImage(MorBoi,0,0 ,1366, 728);
    }

    public void setGameCanvas(Canvas canvas1){
        GraphicsContext gc1;
        gc1 = canvas1.getGraphicsContext2D();
        gc1.fillRect(0, 0, 1366, 728);
        gc1.setFill(Color.LIGHTGREEN);                                      // рисуем поле игры
        gc1.fillRect(0,0,1366,728);
        gc1.setFill(Color.WHITE);
        gc1.fillRect(200,100, 300, 300);
        gc1.fillRect(700,100,300,300);
        gc1.setStroke(Color.GRAY);
        int a = 200, b = 100;
        for (int i = 0; i < 11; i++){
            gc1.strokeLine(a,b,a,b+300);
            gc1.strokeLine(a+500,b,a+500,b+300);
            a += 30;
        }
        a = 200;
        for (int i = 0; i < 11; i++){
            gc1.strokeLine(a,b,a+300,b);
            gc1.strokeLine(a+500,b,a+800,b);
            b += 30;
        }
    }
}
