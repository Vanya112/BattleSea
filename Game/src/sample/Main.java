package sample;

import javafx.application.*;
import javafx.scene.*;
import java.awt.color.*;
import javafx.scene.control.TextField;
import javafx.scene.input.*;
import javafx.scene.paint.Color;
import java.awt.Component;
import java.lang.Double.*;
import javafx.scene.Cursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.scene.canvas.*;
import javafx.scene.image.*;
import javafx.geometry.Insets;

import java.io.*;
import java.io.IOException.*;
import java.io.FileNotFoundException.*;

import java.awt.*;
import java.awt.event.InputEvent;
import java.lang.*;
import java.util.*;

public class Main extends Application {
    //@Override
    int Access = 0, numberOfString = 0;
    String name;
    File dir = new File("C:\\Users\\Vanek\\IdeaProjects\\Game\\src\\sample");
    public void start(Stage myStage) throws RuntimeException, AWTException {
        CanvasBuilder canvasBuilder = new CanvasBuilder();         // создание графического интерфейса
        Pane root = new Pane();
        Canvas canvas  = new Canvas(1366, 728);
        canvasBuilder.setMenuCanvas(canvas);             // задаём параметры согласно размерам экрана
        Scene scene = new Scene(root, 1366, 728);
        myStage.setScene(scene);
        ButtonFactory factButton = new ButtonFactory("Новая игра", 350, 30, 1000, 50);
        Button btnNewGame = factButton.createButton();
        factButton.setComponents("Продолжить игру", 350, 30, 1000, 170);
        Button btnContinue = factButton.createButton();
        factButton.setComponents("Сохранить игру", 350, 30, 1000, 230);
        Button btnSave = factButton.createButton();
        factButton.setComponents("Загрузить игру", 350, 30, 1000, 290);
        Button btnLoad = factButton.createButton();
        factButton.setComponents("Выйти из игры", 350, 30, 1000, 350);
        Button btnExit = factButton.createButton();
        factButton.setComponents("Выйти в главное меню", 500, 30, 350, 650);
        Button btnBack = factButton.createButton();
        factButton.setComponents("Начать игру", 500, 30, 350, 570);
        Button btnBegin = factButton.createButton();
        factButton.setComponents("Авто режим", 500, 30, 350, 520);
        Button btnAuto = factButton.createButton();
        MenuButtonFactory factButton2 = new MenuButtonFactory();
        factButton2.setComponents("Уровень сложности", 350, 30, 1000, 110, 1);
        MenuButton btnChoice = factButton2.createButton();
        MenuItem menuItemEasy = factButton2.createMenuItem("Лёгкий");
        MenuItem menuItemMedium = factButton2.createMenuItem("Средний");
        MenuItem menuItemHard = factButton2.createMenuItem("Сложный");
        MenuItem menuItemVeryHard = factButton2.createMenuItem("Очень сложный");
        btnChoice.getItems().addAll(menuItemEasy, menuItemMedium, menuItemHard);
        TextArea textAreaFiles = new TextArea();
        textAreaFiles.setLayoutX(200);
        textAreaFiles.setLayoutY(140);
        //textArea.setCursor(Cursor.TEXT);
        textAreaFiles.setStyle("-fx-background-radius:20;-fx-border-radius:20;-fx-backgroundcolor:#ffefd5;-fx-border-width:3pt;" +
                "-fx-border-color:#cd853f;-fx-fontweight:bold;-fx-font-size:14pt; -fx-font-family:Georgia; -fx-fontstyle:italic");
        textAreaFiles.setPrefSize(300, 450);
        textAreaFiles.setEditable(false);
        textAreaFiles.setWrapText(false);
        TextField textAreaInput = new TextField();
        textAreaInput.setLayoutX(550);
        textAreaInput.setLayoutY(140);
        //textArea.setCursor(Cursor.TEXT);
        textAreaInput.setStyle("-fx-background-radius:20;-fx-border-radius:20;-fx-backgroundcolor:#ffefd5;-fx-border-width:3pt;" +
                "-fx-border-color:#cd853f;-fx-fontweight:bold;-fx-font-size:14pt; -fx-font-family:Georgia; -fx-fontstyle:italic");
        //textAreaInput.setTooltip(new Tooltip("Введите номер файла"));
        textAreaInput.setPromptText("Введите номер файла");
        textAreaInput.setPrefSize(300, 15);
        textAreaInput.setEditable(true);
        //textAreaInput.setWrapText(false);
        Button btnSend = new Button();
        btnSend.setLayoutX(600);
        btnSend.setLayoutY(210);
        btnSend.setText("Загрузить");
        btnSend.setCursor(Cursor.HAND);
        btnSend.setStyle("-fx-font: bold italic 14pt Georgia;-fx-text-fill: white; -fx-background-color: #a0522d;-fx-border-width: 3px;" +
                " -fx-border-color:#f4a460 #800000 #800000 #f4a460;" );
        btnSend.setPrefSize(180,30);
        TextField textFieldSave = new TextField();
        textFieldSave.setLayoutX(550);
        textFieldSave.setLayoutY(140);
        //textArea.setCursor(Cursor.TEXT);
        textFieldSave.setStyle("-fx-background-radius:20;-fx-border-radius:20;-fx-backgroundcolor:#ffefd5;-fx-border-width:3pt;" +
                "-fx-border-color:#cd853f;-fx-fontweight:bold;-fx-font-size:14pt; -fx-font-family:Georgia; -fx-fontstyle:italic");
        //textAreaInput.setTooltip(new Tooltip("Введите номер файла"));
        textFieldSave.setPromptText("Введите номер файла");
        textFieldSave.setPrefSize(300, 15);
        textFieldSave.setEditable(true);
        Button btnSaveGame = new Button();
        btnSaveGame.setLayoutX(600);
        btnSaveGame.setLayoutY(210);
        btnSaveGame.setText("Сохранить");
        btnSaveGame.setCursor(Cursor.HAND);
        btnSaveGame.setStyle("-fx-font: bold italic 14pt Georgia;-fx-text-fill: white; -fx-background-color: #a0522d;-fx-border-width: 3px;" +
                " -fx-border-color:#f4a460 #800000 #800000 #f4a460;" );
        btnSaveGame.setPrefSize(180,30);
        Button btnBackTo = new Button();
        btnBackTo.setLayoutX(600);
        btnBackTo.setLayoutY(270);
        btnBackTo.setText("Назад");
        btnBackTo.setCursor(Cursor.HAND);
        btnBackTo.setStyle("-fx-font: bold italic 14pt Georgia;-fx-text-fill: white; -fx-background-color: #a0522d;-fx-border-width: 3px;" +
                " -fx-border-color:#f4a460 #800000 #800000 #f4a460;" );
        btnBackTo.setPrefSize(180,30);
        Button btnBackBack = new Button();
        btnBackBack.setLayoutX(600);
        btnBackBack.setLayoutY(270);
        btnBackBack.setText("Назад");
        btnBackBack.setCursor(Cursor.HAND);
        btnBackBack.setStyle("-fx-font: bold italic 14pt Georgia;-fx-text-fill: white; -fx-background-color: #a0522d;-fx-border-width: 3px;" +
                " -fx-border-color:#f4a460 #800000 #800000 #f4a460;" );
        btnBackBack.setPrefSize(180,30);
        root.getChildren().addAll(canvas, btnNewGame, btnChoice, btnSave, btnLoad, btnExit, btnContinue);
        myStage.show();
        Pane root1 = new Pane();
        Scene scene1 = new Scene(root1, 1366, 728);
        Game game = new Game();
        game.initNotation();
        game.setMap();
        game.initMap();
        game.setMyShipsLife();
        game.setImages();
        game.createMenuEvent(menuItemEasy, 1);
        game.createMenuEvent(menuItemMedium, 2);
        game.createMenuEvent(menuItemHard, 3);
        ImagesOfShips[] info = new ImagesOfShips[10];
        Canvas canvas1 = new Canvas(1366, 728);
        TextArea textArea = new TextArea();
        textArea.setLayoutX(1050);
        textArea.setLayoutY(100);
        //textArea.setCursor(Cursor.TEXT);
        textArea.setStyle("-fx-background-radius:20;-fx-border-radius:20;-fx-backgroundcolor:#ffefd5;-fx-border-width:3pt;" +
                "-fx-border-color:#cd853f;-fx-fontweight:bold;-fx-font-size:14pt; -fx-font-family:Georgia; -fx-fontstyle:italic");
        textArea.setPrefSize(250, 600);
        textArea.setEditable(false);
        textArea.setWrapText(false);
        game.getCanvasEvents(canvas1, textArea);
        game.test(scene1, canvas1, textArea);
        game.test1(scene1, canvas1, textArea);
        final ImageView[] ships = new ImageView[10];

        btnNewGame.setOnAction(new EventHandler<ActionEvent>() {                    // обработка событий
            @Override
            public void handle(ActionEvent event) {

                if (game.getAccess() == 1 || game.getAccess() == 3){
                    root1.getChildren().removeAll(canvas1, btnBack, btnBegin, btnAuto, textArea);
                    for (int i = 0; i < 10; i++){
                        root1.getChildren().remove(ships[i]);
                    }
                }
                root1.getChildren().clear();
                if (game.getAccess() < 5){
                    textArea.setText("");
                    game.vocalubary.Clear();
                    game.setAccess(1);
                    game.setAccess12(0);
                    canvasBuilder.setGameCanvas(canvas1);
                    Image im = new Image(this.getClass().getResource("4-palubnik.png").toString());
                    Image im1 = new Image(this.getClass().getResource("3-palubnik.png").toString());
                    Image im2 = new Image(this.getClass().getResource("2-palubnik.png").toString());
                    Image im3 = new Image(this.getClass().getResource("1-palubnik.png").toString());
                    ships[0] = new ImageView(im);
                    for (int i = 1; i < 3; i++){
                        ships[i] = new ImageView(im1);
                    }
                    for (int i = 3; i < 6; i++){
                        ships[i] = new ImageView(im2);
                    }
                    for (int i = 6; i < 10; i++){
                        ships[i] = new ImageView(im3);
                    }
                    info[0] = new ImagesOfShips(0, 90, 0, 0, 0,3,4);
                    info[1] = new ImagesOfShips(1,90,0,0,20,22,3);
                    info[2] = new ImagesOfShips(2,90,0,0,24,26,3);
                    info[3] = new ImagesOfShips(3,90,0,0,40,41,2);
                    info[4] = new ImagesOfShips(4,90,0,0,43,44,2);
                    info[5] = new ImagesOfShips(5,90,0,0,46,47,2);
                    info[6] = new ImagesOfShips(6,90,0,0,60,60,1);
                    info[7] = new ImagesOfShips(7,90,0,0,62,62,1);
                    info[8] = new ImagesOfShips(8,90,0,0,64,64,1);
                    info[9] = new ImagesOfShips(9,90,0,0,66,66,1);

                    for (int j = 0; j < 10; j++)
                        info[j].createEvent(ships, j);
                    game.setMap();
                    game.initMap();
                    game.clear();
                    game.createMemory();
                    game.myShuffle();
                    info[0].setData(0, 90, 0, 0, 0,3,4);
                    info[1].setData(1,90,0,0,20,22,3);
                    info[2].setData(2,90,0,0,24,26,3);
                    info[3].setData(3,90,0,0,40,41,2);
                    info[4].setData(4,90,0,0,43,44,2);
                    info[5].setData(5,90,0,0,46,47,2);
                    info[6].setData(6,90,0,0,60,60,1);
                    info[7].setData(7,90,0,0,62,62,1);
                    info[8].setData(8,90,0,0,64,64,1);
                    info[9].setData(9,90,0,0,66,66,1);
                    // инициализация кораблей
                    info[0].createImage(ships[0], 200, 100);
                    info[1].createImage(ships[1], 200, 160);
                    info[2].createImage(ships[2], 320, 160);
                    info[3].createImage(ships[3], 200, 220);
                    info[4].createImage(ships[4], 290, 220);
                    info[5].createImage(ships[5], 380, 220);
                    info[6].createImage(ships[6], 200, 280);
                    info[7].createImage(ships[7], 260, 280);
                    info[8].createImage(ships[8], 320, 280);
                    info[9].createImage(ships[9], 380, 280);
                    for (int j = 0; j < 10; j++)
                        ships[j].setCursor(Cursor.HAND);
                    root1.getChildren().addAll(canvas1, btnBack, btnBegin, btnAuto, textArea);
                    canvas1.setCursor(Cursor.DEFAULT);
                    for (int i = 0; i < 10; i++){
                        root1.getChildren().add(ships[i]);
                    }
                    while(true){
                        game.setAlignment(4,0);
                        for (int i = 1; i < 3; i++)
                            game.setAlignment(3, i);
                        for (int i = 3; i < 6; i++)
                            game.setAlignment(2, i);
                        int count = game.countCells();
                        if (game.check())
                            break;
                        else
                            game.nullMap();
                    }
                    for (int i = 6; i < 10; i++)
                        game.setAlignment(1, i);
                    game.showShips();
                    myStage.setScene(scene1);
                    Access = game.getAccess();
                }
            }
        });

        canvas1.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (game.getAccess() == 3 && game.getAccess12() == 0) {
                    double x1 = event.getX();
                    double y1 = event.getY();
                    if (x1 > 700 && y1 > 100 && x1 < 1000 && y1 < 400)
                        canvas1.setCursor(Cursor.HAND);
                    else
                        canvas1.setCursor(Cursor.DEFAULT);
                }
                else
                    canvas1.setCursor(Cursor.DEFAULT);
            }
        });

        btnContinue.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (game.getAccess() == 1 || game.getAccess() == 3){
                    myStage.setScene(scene1);
                }
            }
        });
        ArrayList<String> listOfFileNames = new ArrayList<>();

        btnLoad.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Access = game.getAccess();
                if (game.getAccess() != 6){
                    textAreaInput.setText("");
                    textAreaFiles.setText("");
                    listOfFileNames.clear();
                    game.setAccess(5);
                    Integer count = 1;
                    for (File file : dir.listFiles()) {
                        try{
                            String fileName = file.getName();
                            String extension = new String("");
                            if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
                                extension += fileName.substring(fileName.lastIndexOf(".") + 1);
                            if (extension.equals("txt")){
                                System.out.println("Content of " + file.getCanonicalPath() + ":");
                                listOfFileNames.add(fileName);
                                textAreaFiles.appendText(count.toString() + " " + fileName + "\n");
                                count++;
                            }
                        }
                        catch(FileNotFoundException e) {

                        }
                        catch(IOException e) {

                        }
                    }
                    root.getChildren().addAll(textAreaInput, textAreaFiles, btnSend, btnBackTo);
                    root.getChildren().removeAll(btnNewGame, btnContinue, btnLoad, btnSave, btnExit, btnChoice);
                }
            }
        });

        btnBackTo.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event){
                game.setAccess(Access);
                System.out.println("Access = " + Access);
                textAreaInput.setText("");
                root.getChildren().removeAll(textAreaInput, textAreaFiles, btnSend, btnBackTo);
                root.getChildren().addAll(btnNewGame, btnContinue, btnLoad, btnSave, btnExit, btnChoice);
            }
        });

        btnBackBack.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event){
                game.setAccess(Access);
                System.out.println("Access = " + Access);
                textFieldSave.setText("");
                root.getChildren().removeAll(textFieldSave, btnSaveGame, btnBackBack);
                root.getChildren().addAll(btnNewGame, btnContinue, btnLoad, btnSave, btnExit, btnChoice);
            }
        });

        scene1.setOnKeyPressed(new EventHandler<KeyEvent>() {
            final KeyCombination cKey = new KeyCodeCombination(KeyCode.C);
            public void handle(KeyEvent event1) {
                if (cKey.match(event1)) {
                    System.out.println("Я здесь");
                        String infoLine = game.vocalubary.getBufferString(numberOfString);
                        String value;
                        final int length = infoLine.length();
                        char[] buffer = new char[length];
                        buffer = infoLine.toCharArray();
                        System.out.println("length = " + length);
                        GraphicsContext gc1;
                        gc1 = canvas1.getGraphicsContext2D();
                        for (int j = 3; j <= length; j += 3) {
                            int check = 0;
                            if (buffer[j] <= '9' && buffer[j] >= '0') {
                                char c = buffer[j];
                                buffer[j] = buffer[j + 1];
                                buffer[j + 1] = c;
                                check = 1;
                            }
                            char[] Value = new char[2];
                            Value[0] = buffer[j];
                            Value[1] = buffer[j + 1];
                            value = String.copyValueOf(Value);
                            System.out.println(value);
                            System.out.println(game.vocalubary.getCoordxComputerKey(value));
                            if (buffer[0] == '1' && check == 0) {
                                gc1.setFill(Color.BLUE);
                                gc1.fillOval(game.vocalubary.getCoordxComputerKey(value), game.vocalubary.getCoordyComputerKey(value), 5, 5);
                            }
                            else if (buffer[0] == '1' && check == 1) {
                                gc1.setFill(Color.RED);
                                gc1.fillOval(game.vocalubary.getCoordxComputerKey(value), game.vocalubary.getCoordyComputerKey(value), 5, 5);
                            }
                            else if (buffer[0] == '2' && check == 0){
                                gc1.setFill(Color.BLUE);
                                gc1.fillOval(game.vocalubary.getCoordxMyKey(value), game.vocalubary.getCoordyMyKey(value), 5, 5);
                            }
                            else if (buffer[0] == '2' && check == 1) {
                                gc1.setFill(Color.RED);
                                gc1.fillOval(game.vocalubary.getCoordxMyKey(value), game.vocalubary.getCoordyMyKey(value), 5, 5);
                            }
                        }
                    textArea.appendText(infoLine);
                    textArea.appendText("\n");
                    if (numberOfString < game.vocalubary.getBufferSize() - 1)
                        try {
                            Robot robot = new Robot();
                            robot.keyPress('C');
                            numberOfString++;
                            robot.delay(700);
                            robot.keyRelease('C');
                        } catch (AWTException e) {
                            System.err.println("Робот-ошибка");
                        }
                    else{
                        numberOfString = 0;
                        game.vocalubary.Clear();
                    }
                }
            }
        });

        btnSend.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event){
                textArea.clear();
                game.setAccess(Access);
                if (Access == 3)
                    game.setAccess(0);
                String str1 = textAreaInput.getText();
                int accessToBack = 2, number = 0;
                canvasBuilder.setGameCanvas(canvas1);
                try {
                    String loadName = new String();
                    Integer i2 = Integer.valueOf(str1);
                    System.out.println("i2 = " + i2);
                    if (i2 > 0 && i2 <= listOfFileNames.size()){
                        number = i2;
                        accessToBack = 0;
                        System.out.println(i2);
                    }
                    else
                        accessToBack = 1;
                }
                catch (NumberFormatException e) {
                    textAreaInput.setText("");
                    System.err.println("Прочитать строку из текстового поля не удалось");
                    System.err.println("Неверный формат строки!");
                }
                if (accessToBack == 0)
                {
                    name = listOfFileNames.get(number - 1);
                    System.out.println(name);
                    try {
                        File reader = new File(name);
                        FileReader fr = new FileReader(reader);
                        BufferedReader loadFile = new BufferedReader(fr);
                        for (int i = 0; i < 10; i++) {
                            char[] locationX = new char[3], locationY = new char[3], lifes = new char[1], scale = new char[1];
                            fr.read(locationX);
                            fr.read();
                            fr.read(locationY);
                            fr.read();
                            fr.read(lifes);
                            fr.read();
                            fr.read(scale);
                            fr.read();
                            GraphicsContext gc;
                            String lifes1 = new String(lifes), locationX1 = new String(locationX), locationY1 = new String(locationY);
                            gc = canvas1.getGraphicsContext2D();
                            Integer life = Integer.valueOf(lifes1);
                            Integer locX = Integer.valueOf(locationX1.toString());
                            Integer locY = Integer.valueOf(locationY1.toString());
                            int angle;
                            if (scale[0] == '+')
                                angle = 90;
                            else
                                angle = -90;
                            if (life == 4 && angle == 90){
                                Image myShip = new Image(this.getClass().getResource("4-palubnik.png").toString());
                                gc.drawImage(myShip, locX, locY);
                            }
                            else if (life == 4 && angle < 0){
                                Image myShip = new Image(this.getClass().getResource("4-palubnik-90.png").toString());
                                gc.drawImage(myShip, locX, locY);
                            }
                            else if (life == 3 && angle == 90){
                                Image myShip = new Image(this.getClass().getResource("3-palubnik.png").toString());
                                gc.drawImage(myShip, locX, locY);
                            }
                            else if (life == 3 && angle < 0){
                                Image myShip = new Image(this.getClass().getResource("3-palubnik-90.png").toString());
                                gc.drawImage(myShip, locX, locY);
                            }
                            else if (life == 2 && angle == 90){
                                Image myShip = new Image(this.getClass().getResource("2-palubnik.png").toString());
                                gc.drawImage(myShip, locX, locY);
                            }
                            else if (life == 2 && angle < 0){
                                Image myShip = new Image(this.getClass().getResource("2-palubnik-90.png").toString());
                                gc.drawImage(myShip, locX, locY);
                            }
                            else if (life == 1) {
                                Image myShip = new Image(this.getClass().getResource("1-palubnik.png").toString());
                                gc.drawImage(myShip, locX, locY);
                            }
                        }
                        char[] buf = new char[2], player = new char[2];
                        char[] symbol = new char[1];
                        GraphicsContext gc1;
                        gc1 = canvas1.getGraphicsContext2D();
                        int i = 3;
                        String Player = String.copyValueOf(player);
                        char[] buffer = new char[50];
                        String fileLine = new String();
                        while(loadFile.ready()){
                            fileLine = loadFile.readLine();
                            System.out.println(fileLine);
                            game.vocalubary.addBufferString(fileLine);
                        }
                        game.vocalubary.showBuffer();
                        fr.close();
                    }
                    catch(FileNotFoundException e){
                        System.err.println("Файл не найден.");
                    }
                    catch(EOFException e){
                        System.err.println("Чё-то в файле пошло не так.");
                    }
                    catch(IOException e){
                        System.err.println("Ошибка ввода-вывода.");
                    }
                    textAreaInput.setText("");
                    System.out.println("Access = " + Access);
                    root.getChildren().removeAll(textAreaInput, textAreaFiles, btnSend, btnBackTo);
                    root.getChildren().addAll(btnNewGame, btnContinue, btnLoad, btnSave, btnExit, btnChoice);
                    root1.getChildren().clear();
                    root1.getChildren().addAll(canvas1, btnBack, textArea);
                    myStage.setScene(scene1);
                    try{
                        Robot robot = new Robot();
                        robot.keyPress('C');
                        robot.delay(1);
                        robot.keyRelease('C');
                    }
                    catch(AWTException e){
                        System.err.println("Робот-ошибка");
                    }
                }
                else
                    textAreaInput.setText("");
            }
        });

        btnSave.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (game.getAccess() == 3){
                    textFieldSave.setText("");
                    game.setAccess(6);
                    root.getChildren().addAll(textFieldSave, btnSaveGame, btnBackBack);
                    root.getChildren().removeAll(btnNewGame, btnContinue, btnLoad, btnSave, btnExit, btnChoice);
                    System.out.println("Access = " + Access);
                }
            }
        });

        btnSaveGame.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event){
                String saveText = new String();
                saveText = textFieldSave.getText();
                if (saveText.equals(""))
                    textFieldSave.appendText("");
                else {
                    saveText += ".txt";
                    game.setAccess(Access);
                    root.getChildren().removeAll(textFieldSave, btnSaveGame, btnBackBack);
                    root.getChildren().addAll(btnNewGame, btnContinue, btnLoad, btnSave, btnExit, btnChoice);
                }
                try{
                    FileWriter fw = new FileWriter( saveText );
                    for (int i = 0; i < 10; i++){
                        Integer start = info[i].getLocationStart();
                        Integer scale = info[i].getAngle();
                        Integer lifes = info[i].getLifes();
                        Integer locationX = 200 + (start % 10) * 30;
                        Integer locationY = 100 + (start / 10) * 30;
                        String data1 = locationX.toString();
                        String data2 = locationY.toString();
                        String data3 = lifes.toString();
                        String data4;
                        if (scale > 0)
                            data4 = "+";
                        else
                            data4 = "-";
                        fw.write(data1);
                        fw.write(" ");
                        fw.write(data2);
                        fw.write(" ");
                        fw.write(data3);
                        fw.write(" ");
                        fw.write(data4);
                        fw.write("\n");
                    }
                    for (int i = 0; i < game.vocalubary.getSize(); i++){
                        fw.write(game.vocalubary.getString(i));
                        fw.write("\n");
                    }
                    fw.close();
                }
                catch(IOException e){
                    System.out.println("Ошибка ввода.");
                }
                textFieldSave.setText("");
                System.out.println("Access = " + Access);
            }
        });

        btnExit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });

        btnBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                myStage.setScene(scene);
            }
        });


        btnBegin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                root1.getChildren().remove(btnBegin);
                for (int i = 0; i < 10; i++)
                    root1.getChildren().remove(ships[i]);
                game.setMyShips(info);
                game.setLocations();
                game.setAngles();
                game.drawImages(canvas1);
                game.setAccess(3);
                Access = game.getAccess();
            }
        });

        btnAuto.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (game.getAccess() == 3 && game.getAccess12() == 0) {
                    game.setAccess12(1);
                    try {
                        Robot rb = new Robot();
                        rb.keyPress('B');
                        rb.delay(100);
                        rb.keyRelease('B');
                    } catch (AWTException ex) {
                        System.err.println("");
                    }
                } else if (game.getAccess() == 3 && game.getAccess12() == 1)
                    game.setAccess12(0);
                Access = game.getAccess();
            }
        });
        myStage.show();
    }

    static String recursiveReverse(String s) {
        if ((null == s) || (s.length() <= 1)) {
            return s;
        }
        return recursiveReverse(s.substring(1)) + s.charAt(0);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
