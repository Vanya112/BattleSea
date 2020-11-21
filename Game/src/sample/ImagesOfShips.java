package sample;

import java.util.*;
import java.lang.*;
import javafx.event.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.canvas.*;
import javafx.scene.image.*;
import javafx.scene.transform.*;

public class ImagesOfShips extends Field{
    protected int index;
    protected int angle;
    protected Image ship;
    protected double memoryX;
    protected double memoryY;
    protected int locationStart;
    protected int locationEnd;
    protected int lifes;
    protected double LayoutX;
    protected double LayoutY;
    protected ArrayList<Integer> mapShip;

    public int getAngle(){
        return angle;
    }

    public int getLifes(){
        return lifes;
    }

    public ImagesOfShips(){
        this.index = 0;
        this.angle = 90;
        this.memoryY = 0;
        this.memoryX = 0;
        this.locationStart = 1;
        this.locationEnd = 2;
        mapShip = new ArrayList<>();
    }

    public void setImage(){
        if(lifes == 4)
            ship = new Image(this.getClass().getResource("4-palubnik.png").toString());
        else if (lifes == 3)
            ship = new Image(this.getClass().getResource("3-palubnik.png").toString());
        else if (lifes == 2)
            ship = new Image(this.getClass().getResource("2-palubnik.png").toString());
        else if (lifes == 1)
            ship = new Image(this.getClass().getResource("1-palubnik.png").toString());
    }

    public void setAngle(){
        if (locationEnd - locationStart > 4)
            angle = -90;
        else
            angle = 90;
        // System.out.println("angle = " + angle);
    }

    public void drawImage(Canvas canvas1){
        GraphicsContext gc;
        gc = canvas1.getGraphicsContext2D();
        if (lifes == 4 && angle == 90){
            Image myShip = new Image(this.getClass().getResource("4-palubnik.png").toString());
            gc.drawImage(myShip, 200 + (locationStart % 10) * 30, 100 + (locationStart / 10) * 30);
        }
        else if (lifes == 4 && angle < 0){
            Image myShip = new Image(this.getClass().getResource("4-palubnik-90.png").toString());
            gc.drawImage(myShip, 200 + (locationStart % 10) * 30, 100 + (locationStart / 10) * 30);
        }
        else if (lifes == 3 && angle == 90){
            Image myShip = new Image(this.getClass().getResource("3-palubnik.png").toString());
            gc.drawImage(myShip, 200 + (locationStart % 10) * 30, 100 + (locationStart / 10) * 30);
        }
        else if (lifes == 3 && angle < 0){
            Image myShip = new Image(this.getClass().getResource("3-palubnik-90.png").toString());
            gc.drawImage(myShip, 200 + (locationStart % 10) * 30, 100 + (locationStart / 10) * 30);
        }
        else if (lifes == 2 && angle == 90){
            Image myShip = new Image(this.getClass().getResource("2-palubnik.png").toString());
            gc.drawImage(myShip, 200 + (locationStart % 10) * 30, 100 + (locationStart / 10) * 30);
        }
        else if (lifes == 2 && angle < 0){
            Image myShip = new Image(this.getClass().getResource("2-palubnik-90.png").toString());
            gc.drawImage(myShip, 200 + (locationStart % 10) * 30, 100 + (locationStart / 10) * 30);
        }
        else if (lifes == 1) {
            Image myShip = new Image(this.getClass().getResource("1-palubnik.png").toString());
            gc.drawImage(myShip, 200 + (locationStart % 10) * 30, 100 + (locationStart / 10) * 30);
        }

    }

    public void setLifes(int lifes){
        this.lifes = lifes;
    }

    public ArrayList<Integer> getMapShip(){
        return mapShip;
    }

    public void setLocation(){
        locationStart = mapShip.get(0);
        locationEnd = mapShip.get(mapShip.size() - 1);
    }

    public void setMapShip(ArrayList<Integer> info){
        mapShip.clear();
        mapShip.addAll(info);
        locationStart = info.get(0);
        locationEnd = info.get(info.size() - 1);
    }

    public ImagesOfShips(int index, int angle, double memoryX, double memoryY, int locationStart, int locationEnd, int lifes){
        this.index = index;
        this.angle = angle;
        this.memoryX = memoryX;
        this.memoryY = memoryY;
        this.locationStart = locationStart;
        this.locationEnd = locationEnd;
        this.lifes = lifes;
        mapShip = new ArrayList<>();
        int step;
        if (locationEnd - locationStart >= 10)
            step = 10;
        else
            step = 1;
        for (int buffer = locationStart; buffer <= locationEnd; buffer += step)
            mapShip.add(buffer);
        for (int i = locationStart / 10; i <= locationEnd / 10; i++)
            for (int j = locationStart % 10; j <= locationEnd % 10; j++){
                if (i < 0 || j < 0 || i > 9 || j > 9)
                    continue;
                else
                    map[i][j] = 2;
            }
        for (int i = locationStart / 10 - 1; i <= locationEnd / 10 + 1; i++)
            for (int j = locationStart % 10 - 1; j <= locationEnd % 10 + 1; j++){
                if (i < 0 || j < 0 || i > 9 || j > 9)
                    continue;
                else
                    map[i][j]--;
            }
    }

    public void showArrayList(){
        System.out.println("Содержимое вектора: " + mapShip);
    }

    public void clearList(){
        mapShip.clear();
    }

    public int getLocationStart(){
        return this.locationStart;
    }

    public int getLocationEnd(){
        return this.locationEnd;
    }

    public int IndexOf(int number){
        return mapShip.indexOf((Object)number);
    }

    public void Add(int element){
        mapShip.add(element);
    }

    public int Size(){
        return mapShip.size();
    }

    public boolean contains(int number){
        return mapShip.contains((Object)number);
    }

    public void Remove(int element){
        mapShip.remove((Object)element);
    }

    public void setData(int index, int angle, double memoryX, double memoryY, int locationStart, int locationEnd, int lifes){
        this.index = index;
        this.angle = angle;
        this.memoryX = memoryX;
        this.memoryY = memoryY;
        this.locationStart = locationStart;
        this.locationEnd = locationEnd;
        this.lifes = lifes;
        for (int i = locationStart / 10; i <= locationEnd / 10; i++)
            for (int j = locationStart % 10; j <= locationEnd % 10; j++){
                if (i < 0 || j < 0 || i > 9 || j > 9)
                    continue;
                else
                    map[i][j] = 2;
            }

        for (int i = locationStart / 10 - 1; i <= locationEnd / 10 + 1; i++)
            for (int j = locationStart % 10 - 1; j <= locationEnd % 10 + 1; j++){
                if (i < 0 || j < 0 || i > 9 || j > 9)
                    continue;
                else
                    map[i][j]--;
            }
    }

    public void createImage(ImageView ship, double LayoutX, double LayoutY){
        ship.setLayoutX(LayoutX);
        ship.setLayoutY(LayoutY);
        ship.setTranslateX(0);
        ship.setTranslateY(0);
        ship.setRotate(0);
    }

    public int modul(double x1){
        if (x1 < 0)
            return (int)-x1;
        else
            return (int) x1;
    }

    public int znak(int x1){
        if (x1 < 0)
            return 10;
        else
            return 1;
    }

    public void createEvent(ImageView[] ships, int j){
        {// функция обработки событий для кораблей
            ships[j].setOnMousePressed(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent event) {
                    if (event.getButton().equals(MouseButton.PRIMARY)) {
                        LayoutX = ships[j].getTranslateX() - event.getSceneX();
                        LayoutY = ships[j].getTranslateY() - event.getSceneY();
                    }
                }
            });
            ships[j].setOnMouseDragged(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent event) {
                    if (event.getButton().equals(MouseButton.PRIMARY)){
                        ships[j].setTranslateX(LayoutX + event.getSceneX());
                        ships[j].setTranslateY(LayoutY + event.getSceneY());
                    }
                }
            });
            ships[j].setOnMouseReleased(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent event) {
                    int[][] timeMap = new int[10][10];
                    int check = 0;
                    if (event.getButton().equals(MouseButton.PRIMARY)) {
                        for (int i = 0; i < 100; i++)
                            timeMap[i/10][i%10] = map[i/10][i%10];
                        int locationStartOld = locationStart, locationEndOld = locationEnd;
                        LayoutX = ships[j].getTranslateX() - (ships[j].getTranslateX() % 30);
                        LayoutY = ships[j].getTranslateY() - (ships[j].getTranslateY() % 30);
                        double translate1 = LayoutX;
                        double translate2 = LayoutY;
                        LayoutX = ships[j].getLayoutX() - 200 + LayoutX;
                        LayoutY = ships[j].getLayoutY() - 100 + LayoutY;
                        if ((LayoutX + lifes * 30 > 300 && angle > 0)  || LayoutX < 0)
                            check = 1;
                        if ((LayoutY + lifes * 30 > 300 && angle < 0) || LayoutY < 0)
                            check = 1;
                        locationStart = (int)LayoutX / 30 + (int)(LayoutY / 30) * 10;
                        locationEnd = locationStart + (lifes - 1) * znak(angle);
                        if (locationStart < 0 || locationEnd > 99)
                            check = 1;
                        if (check == 0) {
                            for (int i = locationStartOld / 10 - 1; i <= locationEndOld / 10 + 1; i++)
                                for (int j = locationStartOld % 10 - 1; j <= locationEndOld % 10 + 1; j++) {
                                    if (i < 0 || j < 0 || i > 9 || j > 9)
                                        continue;
                                    else {
                                        if (timeMap[i][j] < 0)
                                            timeMap[i][j]++;
                                        else if (timeMap[i][j] > 0)
                                            timeMap[i][j]--;
                                    }
                                }
                            for (int i = locationStart / 10; i <= locationEnd / 10; i++)
                                for (int j = locationStart % 10; j <= locationEnd % 10; j++) {
                                    if (timeMap[i][j] != 0) {
                                        check = 1;
                                        break;
                                    }
                                }
                            if (check == 0) {
                                for (int i = locationStart / 10; i <= locationEnd / 10; i++)
                                    for (int j = locationStart % 10; j <= locationEnd % 10; j++) {
                                        timeMap[i][j] = 1;
                                    }
                                for (int i = locationStart / 10 - 1; i <= locationEnd / 10 + 1; i++)
                                    for (int j = locationStart % 10 - 1; j <= locationEnd % 10 + 1; j++) {
                                        if (i < 0 || j < 0 || i > 9 || j > 9)
                                            continue;
                                        else if (timeMap[i][j] != 1) {
                                            timeMap[i][j]--;
                                        }
                                    }
                            }
                        }
                        if (check == 1){
                            locationEnd = locationEndOld;
                            locationStart = locationStartOld;
                        }
                        if (check == 0)
                            for (int i = 0; i < 100; i++)
                                map[i/10][i%10] = timeMap[i/10][i%10];
                        if (check == 1){
                            translate1 = memoryX;
                            translate2 = memoryY;
                        }
                        ships[j].setTranslateX(translate1);
                        ships[j].setTranslateY(translate2);
                        memoryX = translate1;
                        memoryY = translate2;
                        mapShip.clear();
                        int step;
                        if (locationEnd - locationStart >= 10)
                            step = 10;
                        else
                            step = 1;
                        int buffer = locationStart;
                        for (int i = 0; i < lifes; i++){
                            mapShip.add(buffer);
                            buffer += step;
                        }
                    }
                }
            });
            ships[j].setOnMouseClicked(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent event) {
                    int[][] timeMap = new int[10][10];
                    int check = 0;
                    for (int i = 0; i < 100; i++)
                        timeMap[i/10][i%10] = map[i/10][i%10];
                    int locationEndOld = locationEnd;
                    Rotate rotate = new Rotate();
                    if (access != 3)
                        ships[j].getTransforms().add(rotate);
                    if (event.getButton().equals(MouseButton.SECONDARY) && access != 3 && lifes > 1){
                        if ((locationStart + (lifes - 1)) / 10 != locationStart / 10 && angle < 0){
                            locationEnd = locationEndOld;
                            check = 1;
                        }
                        else if (locationStart + (lifes - 1) * 10 > 99 && angle > 0) {
                            locationEnd = locationEndOld;
                            check = 1;
                        }
                        if (check == 0) {
                            angle *= -1;
                            locationEnd = (locationStart + (lifes - 1) * znak(angle));
                            for (int i = locationStart / 10 - 1; i <= locationEndOld / 10 + 1; i++)
                                for (int j = locationStart % 10 - 1; j <= locationEndOld % 10 + 1; j++) {
                                    if (i < 0 || j < 0 || i > 9 || j > 9)
                                        continue;
                                    else {
                                        if (timeMap[i][j] < 0)
                                            timeMap[i][j]++;
                                        else if (timeMap[i][j] > 0)
                                            timeMap[i][j]--;
                                    }
                                }
                            for (int i = locationStart / 10; i <= locationEnd / 10; i++)
                                for (int j = locationStart % 10; j <= locationEnd % 10; j++) {
                                    if (timeMap[i][j] != 0) {
                                        check = 1;
                                        angle *= -1;
                                        locationEnd = locationEndOld;
                                        break;
                                    }
                                }
                            if (check == 0) {
                                for (int i = locationStart / 10; i <= locationEnd / 10; i++)
                                    for (int j = locationStart % 10; j <= locationEnd % 10; j++) {
                                        timeMap[i][j] = 1;
                                    }
                                for (int i = locationStart / 10 - 1; i <= locationEnd / 10 + 1; i++)
                                    for (int j = locationStart % 10 - 1; j <= locationEnd % 10 + 1; j++) {
                                        if (i < 0 || j < 0 || i > 9 || j > 9)
                                            continue;
                                        else if (timeMap[i][j] != 1) {
                                            timeMap[i][j]--;
                                        }
                                    }
                            }
                            if (check == 0){
                                for (int i = 0; i < 100; i++)
                                    map[i/10][i%10] = timeMap[i/10][i%10];
                                rotate.setPivotX(15);
                                rotate.setPivotY(15);
                                rotate.setAngle(-angle);
                                mapShip.clear();
                                int step;
                                if (locationEnd - locationStart >= 10)
                                    step = 10;
                                else
                                    step = 1;
                                int buffer = locationStart;
                                for (int i = 0; i < lifes; i++){
                                    mapShip.add(buffer);
                                    buffer += step;
                                }
                            }
                        }
                    }
                }
            });
        }
    }
}