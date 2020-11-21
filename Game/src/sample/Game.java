package sample;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.paint.Color;
import notation.Information;
import java.util.Stack;

import java.io.FileOutputStream;
import java.util.Map;

import java.util.*;
import java.lang.*;
import java.awt.AWTException;
import java.awt.Robot;

public class Game extends Field
{
    protected Information vocalubary;
    int index3 = 0;
    int index4 = 0;
    int sem = 0;
    protected int level;
    protected int access12 = 0;
    protected int lifes1 = 20;
    protected int lifes2 = 20;
    protected int check = 0;
    ArrayList<Integer> myShipsDestroy = new ArrayList<>();
    ArrayList<Integer> computerShipsDestroy = new ArrayList<>();
    ArrayList<Integer> playerMemory = new ArrayList<>();
    ArrayList<Integer> computerMemory = new ArrayList<>();
    ArrayList<Integer> playerVariables = new ArrayList<>();
    ArrayList<Integer> computerVariables = new ArrayList<>();
    ImagesOfShips[] myShips = new ImagesOfShips[10];
    ImagesOfShips[] computerShips = new ImagesOfShips[10];

    public Game(){
        computerMap = new int[10][10];
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++)
                computerMap[i][j] = 0;
        computerCells = new int[10][10];
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++)
                computerCells[i][j] = 0;
        for (int i = 0; i < 10; i++)
            computerShips[i] = new ImagesOfShips();
        for (int i = 0; i < 10; i++)
            myShips[i] = new ImagesOfShips();
        for (int i = 0; i < 10; i++)
            for (int k = 0; k < 10; k++)
                cells[i][k] = 0;
        for (int k = 0; k < 10; k++){
            coordinatesX[k] = a;
            coordinatesY[k] = b;
            a += 30;
            b += 30;
        }
        int c = 700;
        for (int i = 0; i < 10; i++, c += 30)
            coordinates2X[i] = c;
        level = 1;
    }

    public void initNotation(){
        vocalubary = new Information();
    }

    public void setAccess12(int access12){
        this.access12 = access12;
    }

    public int getAccess12(){
        return access12;
    }

    public void test(Scene scene1, Canvas canvas1, TextArea textArea){
        scene1.setOnKeyPressed(new EventHandler<KeyEvent>() {
            final KeyCombination bKey = new KeyCodeCombination(KeyCode.B);
            final KeyCombination aKey = new KeyCodeCombination(KeyCode.A);
            public void handle(KeyEvent event1) {
                if (bKey.match(event1) && access == 3){
                    System.out.println("Я здесь");
                    textArea.appendText("1) ");
                    int number = 0, i1, i2;
                    GraphicsContext gc1;
                    gc1 = canvas1.getGraphicsContext2D();
                    if (playerVariables.size() > 0){
                        Random rnd = new Random();
                        int point = rnd.nextInt(playerVariables.size());
                        number = playerVariables.get(point);
                    }
                    else
                        number = playerMemory.get(0);
                    i1 = number / 10;
                    i2 = number % 10;
                    if (computerCells[i1][i2] == 0 && computerMap[i1][i2] == 1 && check != 2){
                        sem = 10;
                        playerMemory.remove((Object)(i1 * 10 + i2));
                        gc1.setFill(Color.RED);
                        gc1.fillOval(coordinatesX[i2] + 512.5 , coordinatesY[i1] + 12.5, 5, 5);
                        int index1 = 0;
                        int index2 = -1;
                        int numberOfShip = -1;
                        for (int i = 0; i < 10; i++) {
                            index2 = computerShips[i].IndexOf(i1 * 10 + i2);
                            if (index2 >= 0){
                                numberOfShip = i;
                                break;
                            }
                        }
                        if (index2 >= 0 && index4 < 1 && computerShips[numberOfShip].Size() >= 0){
                            playerMemory.remove((Object)(i1 * 10 + i2));
                            playerVariables.clear();
                            playerVariables.add((i1 - 1) * 10 + i2);
                            playerVariables.add((i1 + 1) * 10 + i2);
                            if (number / 10 == (number - 1) / 10)
                                playerVariables.add(i1 * 10 + i2 - 1);
                            if (number / 10 == (number + 1) / 10)
                                playerVariables.add(i1 * 10 + i2 + 1);
                            computerShipsDestroy.add(i1 * 10 + i2);
                            index4++;
                            for (int k = 0; k < playerVariables.size(); k++)
                                if (playerVariables.get(k) < 0 || playerVariables.get(k) >= 100){
                                    playerVariables.remove((Object)(playerVariables.get(k)));
                                    k--;
                                }
                            for (int k = 0; k < playerVariables.size(); k++)
                                if (computerCells[playerVariables.get(k) / 10][playerVariables.get(k) % 10] == 1){
                                    playerVariables.remove((Object)(playerVariables.get(k)));
                                    k--;
                                }

                            index1 = numberOfShip;
                            computerShips[index1].Remove(i1 * 10 + i2);
                        }
                        else if (index2 >= 0 && index4 >= 1 && computerShips[numberOfShip].Size() >= 0){
                            index1 = numberOfShip;
                            playerMemory.remove((Object)(i1 * 10 + i2));
                            computerShipsDestroy.add(i1 * 10 + i2);
                            playerVariables.clear();
                            int min = computerShipsDestroy.get(0), max = computerShipsDestroy.get(0);
                            for (int k = 1; k < computerShipsDestroy.size(); k++)
                                if (computerShipsDestroy.get(k) < min)
                                    min = computerShipsDestroy.get(k);
                            for (int k = 1; k < computerShipsDestroy.size(); k++)
                                if (computerShipsDestroy.get(k) > max)
                                    max = computerShipsDestroy.get(k);
                            if (max - min < 10){
                                if ((max + 1) / 10 ==  max / 10 && max + 1 < 100){
                                    playerVariables.add(max + 1);
                                }
                                if ((min - 1) / 10 == min / 10 && min - 1 >= 0)
                                    playerVariables.add(min - 1);
                            }
                            else{
                                if (max + 10 < 100)
                                    playerVariables.add(max + 10);
                                if (min - 10 >= 0)
                                    playerVariables.add(min - 10);
                            }
                            int checkNumber = 0;
                            int number1 = 0;
                            number1 = playerVariables.get(0);
                            int number2 = 0;
                            if (playerVariables.size() == 2){
                                number2 = playerVariables.get(1);
                                checkNumber = 1;
                            }
                            if (computerCells[number1 / 10][number1 % 10] == 1)
                                playerVariables.remove((Object)number1);
                            if (computerCells[number2 / 10][number2 % 10] == 1 && checkNumber == 1)
                                playerVariables.remove((Object)number2);
                            index4++;
                            computerShips[index1].Remove(i1 * 10 + i2);
                        }
                        if (computerShips[index1].Size() == 0 ) {
                            playerMemory.remove((Object)(number));
                            computerShipsDestroy.clear();
                            playerVariables.clear();
                            index4 = 0;
                            computerCells[i1][i2] = 1;
                            for (int i = computerShips[index1].locationStart / 10 - 1; i <= computerShips[index1].locationEnd / 10 + 1; i++)
                                for (int j = computerShips[index1].locationStart % 10 - 1; j <= computerShips[index1].locationEnd % 10 + 1; j++) {
                                    if (i < 0 || j < 0 || i > 9 || j > 9)
                                        continue;
                                    if (computerCells[i][j] == 0) {
                                        computerCells[i][j]++;
                                        gc1.setFill(Color.BLUE);
                                        gc1.fillOval(coordinatesX[j] + 512.5, coordinatesY[i] + 12.5, 5, 5);
                                        playerMemory.remove((Object)(i* 10 + j));
                                    }
                                    playerMemory.remove((Object)(i* 10 + j));
                                }
                        }
                    }
                    else if (computerCells[i1][i2] == 0 && computerMap[i1][i2] != 1 && check != 2){
                        sem = 11;
                        playerVariables.remove((Object)(i1 * 10 + i2));
                        playerMemory.remove((Object)(i1 * 10 + i2));
                        gc1.setFill(Color.BLUE);
                        gc1.fillOval(coordinatesX[i2] + 512.5, coordinatesY[i1] + 12.5, 5, 5);
                    }
                    else if (computerCells[i1][i2] == 1 && check != 2){
                        sem = 12;
                        System.out.println("cells != 1 Что-то наверное совершенно точно пошло ну не так");
                    }
                    if (computerCells[i1][i2] == 0)
                        computerCells[i1][i2]++;
                    try {
                        Thread.sleep(700);
                    } catch (InterruptedException ex) {
                        System.err.println("");
                    }
                    if (playerVariables.size() > 0)
                        System.out.println("playerVariables = " + playerVariables);
                    if (computerShipsDestroy.size() > 0)
                        System.out.println("computerShipsDestroy = " + computerShipsDestroy);
                    if (sem == 10){
                        try {
                            Robot rb = new Robot();
                            rb.keyPress('B');
                            rb.delay(300);
                            rb.keyRelease('B');
                        } catch (AWTException ex) {
                            System.err.println("");
                        }
                    }
                    else if (sem != 10){
                        try {
                            Robot rb = new Robot();
                            rb.keyPress('A');
                            rb.delay(200);
                            rb.keyRelease('A');
                        } catch (AWTException ex) {
                            System.err.println("Я тут");
                        }
                    }
                }
                else if (aKey.match(event1) && access == 3){
                    textArea.appendText("2) ");
                    int number, i1, i2;
                    GraphicsContext gc1;
                    gc1 = canvas1.getGraphicsContext2D();
                    if (computerVariables.size() > 0){
                        Random rnd = new Random();
                        int point = rnd.nextInt(computerVariables.size());
                        number = computerVariables.get(point);
                    }
                    else
                        number = computerMemory.get(0);
                    i1 = number / 10;
                    i2 = number % 10;
                    String string = new String();
                    if (cells[i1][i2] == 0 && map[i1][i2] == 1 && check != 2){
                        cells[i1][i2] = 1;
                        textArea.appendText(recursiveReverse(vocalubary.GetKey(i1 * 10 + i2)));
                        textArea.appendText(" ");
                        string = string + "2) " + recursiveReverse(vocalubary.GetKey(i1 * 10 + i2));
                        sem = 10;
                        computerMemory.remove((Object)(i1 * 10 + i2));
                        gc1.setFill(Color.RED);
                        gc1.fillOval(coordinatesX[i2] + 12.5 , coordinatesY[i1] + 12.5, 5, 5);
                        int index1 = 0;
                        int index2 = -1;
                        int numberOfShip = -1;
                        for (int i = 0; i < 10; i++) {
                            index2 = myShips[i].IndexOf(i1 * 10 + i2);
                            if (index2 >= 0){
                                numberOfShip = i;
                                break;
                            }
                        }
                        if (index2 >= 0 && index3 < 1 && myShips[numberOfShip].Size() > 0){
                            computerVariables.clear();
                            computerVariables.add((i1 - 1) * 10 + i2);
                            computerVariables.add((i1 + 1) * 10 + i2);
                            if (number / 10 == (number - 1) / 10)
                                computerVariables.add(i1 * 10 + i2 - 1);
                            if (number / 10 == (number + 1) / 10)
                                computerVariables.add(i1 * 10 + i2 + 1);
                            myShipsDestroy.add(i1 * 10 + i2);
                            index3++;
                            for (int k = 0; k < computerVariables.size(); k++)
                                if (computerVariables.get(k) < 0 || computerVariables.get(k) >= 100){
                                    computerVariables.remove((Object)(computerVariables.get(k)));
                                    k--;
                                }
                            for (int k = 0; k < computerVariables.size(); k++)
                                if (cells[computerVariables.get(k) / 10][computerVariables.get(k) % 10] >= 1){
                                    computerVariables.remove((Object) (computerVariables.get(k)));
                                    k--;
                                }
                            index1 = numberOfShip;
                            myShips[index1].Remove(i1 * 10 + i2);
                        }
                        else if (index2 >= 0 && index3 >= 1 && myShips[numberOfShip].Size() >= 0){
                            index1 = numberOfShip;
                            computerMemory.remove((Object)(i1 * 10 + i2));
                            myShipsDestroy.add(i1 * 10 + i2);
                            computerVariables.clear();
                            int min = myShipsDestroy.get(0), max = myShipsDestroy.get(0);
                            for (int k = 1; k < myShipsDestroy.size(); k++)
                                if (myShipsDestroy.get(k) < min)
                                    min = myShipsDestroy.get(k);
                            for (int k = 1; k < myShipsDestroy.size(); k++)
                                if (myShipsDestroy.get(k) > max)
                                    max = myShipsDestroy.get(k);
                            if (max - min < 10){
                                if ((max + 1) / 10 ==  max / 10 && max + 1 < 100){
                                    computerVariables.add(max + 1);
                                }
                                if ((min - 1) / 10 == min / 10 && min - 1 >= 0)
                                    computerVariables.add(min - 1);
                            }
                            else{
                                if (max + 10 < 100)
                                    computerVariables.add(max + 10);
                                if (min - 10 >= 0)
                                    computerVariables.add(min - 10);
                            }
                            int checkNumber = 0;
                            int number1 = computerVariables.get(0);
                            int number2 = 0;
                            if (computerVariables.size() == 2){
                                number2 = computerVariables.get(1);
                                checkNumber = 1;
                            }
                            if (cells[number1 / 10][number1 % 10] >= 1)
                                computerVariables.remove((Object)number1);
                            if (cells[number2 / 10][number2 % 10] >= 1 && checkNumber == 1)
                                computerVariables.remove((Object)number2);
                            index3++;
                            myShips[index1].Remove(i1 * 10 + i2);
                        }
                        if (myShips[index1].Size() == 0) {
                            cells[i1][i2] = 1;
                            myShipsDestroy.clear();
                            computerVariables.clear();
                            index3 = 0;
                            for (int i = myShips[index1].locationStart / 10 - 1; i <= myShips[index1].locationEnd / 10 + 1; i++)
                                for (int j = myShips[index1].locationStart % 10 - 1; j <= myShips[index1].locationEnd % 10 + 1; j++) {
                                    if (i < 0 || j < 0 || i > 9 || j > 9)
                                        continue;
                                    if (cells[i][j] == 0) {
                                        gc1.setFill(Color.BLUE);
                                        gc1.fillOval(coordinatesX[j] + 12.5, coordinatesY[i] + 12.5, 5, 5);
                                        cells[i][j] = 1;
                                        textArea.appendText(vocalubary.GetKey(i * 10 + j));
                                        textArea.appendText(" ");
                                        string = string +  " " + vocalubary.GetKey(i * 10 + j);
                                        computerMemory.remove((Object)(i* 10 + j));
                                    }
                                    computerMemory.remove((Object)(i* 10 + j));
                                }
                        }
                    }
                    else if (cells[i1][i2] == 0 && map[i1][i2] != 1 && check != 2){
                        cells[i1][i2] = 1;
                        textArea.appendText(vocalubary.GetKey(i1 * 10 + i2));
                        textArea.appendText(" ");
                        string = string + "2) " + vocalubary.GetKey(i1 * 10 + i2);
                        sem = 11;
                        computerVariables.remove((Object)(i1 * 10 + i2));
                        computerMemory.remove((Object)(i1 * 10 + i2));
                        gc1.setFill(Color.BLUE);
                        gc1.fillOval(coordinatesX[i2] + 12.5, coordinatesY[i1] + 12.5, 5, 5);
                    }
                    else if (cells[i1][i2] == 1 && check != 2){
                        sem = 12;
                        System.out.println("cells != 1. Что-то пошло не так." );
                    }
                    vocalubary.addString(string);
                    if (computerVariables.size() > 0)
                        System.out.println("computerVariables = " + computerVariables);
                    if (myShipsDestroy.size() > 0)
                        System.out.println("myShipsDestroy = " + myShipsDestroy);
                    textArea.appendText("\n");
                    try {
                        Thread.sleep(700);
                    } catch (InterruptedException ex) {
                        System.err.println("");
                    }
                    if (sem == 10) {
                        try {
                            Robot rb = new Robot();
                            rb.keyPress('A');
                            rb.delay(300);
                            rb.keyRelease('A');
                        } catch (AWTException ex) {
                            System.err.println("");
                        }
                    }
                    else if (sem != 10){
                        try {
                            Robot rb = new Robot();
                            rb.keyPress('B');
                            rb.delay(200);
                            rb.keyRelease('B');
                        } catch (AWTException ex) {
                            System.err.println("");
                        }
                    }
                }
            }
        });
    }

    static String recursiveReverse(String s) {
        if ((null == s) || (s.length() <= 1)) {
            return s;
        }
        return recursiveReverse(s.substring(1)) + s.charAt(0);
    }

    public void test1(Scene scene1, Canvas canvas1, TextArea textArea){
        scene1.setOnKeyReleased(new EventHandler<KeyEvent>() {
            final KeyCombination aKey = new KeyCodeCombination(KeyCode.A);
            final KeyCombination bKey = new KeyCodeCombination(KeyCode.B);
            public void handle(KeyEvent ke) {
                if (aKey.match(ke) && access == 3){
                    textArea.appendText("2) ");
                    int number, i1, i2;
                    GraphicsContext gc1;
                    gc1 = canvas1.getGraphicsContext2D();
                    if (computerVariables.size() > 0){
                        Random rnd = new Random();
                        int point = rnd.nextInt(computerVariables.size());
                        number = computerVariables.get(point);
                    }
                    else
                        number = computerMemory.get(0);
                    i1 = number / 10;
                    i2 = number % 10;
                    String string = new String();
                    if (cells[i1][i2] == 0 && map[i1][i2] == 1 && check != 2){
                        cells[i1][i2] = 1;
                        textArea.appendText(recursiveReverse(vocalubary.GetKey(i1 * 10 + i2)));
                        textArea.appendText(" ");
                        string = string + "2) " + recursiveReverse(vocalubary.GetKey(i1 * 10 + i2));
                        sem = 10;
                        computerMemory.remove((Object)(i1 * 10 + i2));
                        gc1.setFill(Color.RED);
                        gc1.fillOval(coordinatesX[i2] + 12.5 , coordinatesY[i1] + 12.5, 5, 5);
                        int index1 = 0;
                        int index2 = -1;
                        int numberOfShip = -1;
                        for (int i = 0; i < 10; i++) {
                            index2 = myShips[i].IndexOf(i1 * 10 + i2);
                            if (index2 >= 0){
                                numberOfShip = i;
                                break;
                            }
                        }
                        if (index2 >= 0 && index3 < 1 && myShips[numberOfShip].Size() > 0){
                            computerVariables.clear();
                            computerVariables.add((i1 - 1) * 10 + i2);
                            computerVariables.add((i1 + 1) * 10 + i2);
                            if (number / 10 == (number - 1) / 10)
                                computerVariables.add(i1 * 10 + i2 - 1);
                            if (number / 10 == (number + 1) / 10)
                                computerVariables.add(i1 * 10 + i2 + 1);
                            myShipsDestroy.add(i1 * 10 + i2);
                            index3++;
                            for (int k = 0; k < computerVariables.size(); k++)
                                if (computerVariables.get(k) < 0 || computerVariables.get(k) >= 100){
                                    computerVariables.remove((Object)(computerVariables.get(k)));
                                    k--;
                                }
                            for (int k = 0; k < computerVariables.size(); k++)
                                if (cells[computerVariables.get(k) / 10][computerVariables.get(k) % 10] >= 1){
                                    computerVariables.remove((Object) (computerVariables.get(k)));
                                    k--;
                                }
                            index1 = numberOfShip;
                            myShips[index1].Remove(i1 * 10 + i2);
                        }
                        else if (index2 >= 0 && index3 >= 1 && myShips[numberOfShip].Size() >= 0){
                            index1 = numberOfShip;
                            computerMemory.remove((Object)(i1 * 10 + i2));
                            myShipsDestroy.add(i1 * 10 + i2);
                            computerVariables.clear();
                            int min = myShipsDestroy.get(0), max = myShipsDestroy.get(0);
                            for (int k = 1; k < myShipsDestroy.size(); k++)
                                if (myShipsDestroy.get(k) < min)
                                    min = myShipsDestroy.get(k);
                            for (int k = 1; k < myShipsDestroy.size(); k++)
                                if (myShipsDestroy.get(k) > max)
                                    max = myShipsDestroy.get(k);
                            if (max - min < 10){
                                if ((max + 1) / 10 ==  max / 10 && max + 1 < 100){
                                    computerVariables.add(max + 1);
                                }
                                if ((min - 1) / 10 == min / 10 && min - 1 >= 0)
                                    computerVariables.add(min - 1);
                            }
                            else{
                                if (max + 10 < 100)
                                    computerVariables.add(max + 10);
                                if (min - 10 >= 0)
                                    computerVariables.add(min - 10);
                            }
                            int checkNumber = 0;
                            int number1 = computerVariables.get(0);
                            int number2 = 0;
                            if (computerVariables.size() == 2){
                                number2 = computerVariables.get(1);
                                checkNumber = 1;
                            }
                            if (cells[number1 / 10][number1 % 10] >= 1)
                                computerVariables.remove((Object)number1);
                            if (cells[number2 / 10][number2 % 10] >= 1 && checkNumber == 1)
                                computerVariables.remove((Object)number2);
                            index3++;
                            myShips[index1].Remove(i1 * 10 + i2);
                        }
                        if (myShips[index1].Size() == 0) {
                            cells[i1][i2] = 1;
                            myShipsDestroy.clear();
                            computerVariables.clear();
                            index3 = 0;
                            for (int i = myShips[index1].locationStart / 10 - 1; i <= myShips[index1].locationEnd / 10 + 1; i++)
                                for (int j = myShips[index1].locationStart % 10 - 1; j <= myShips[index1].locationEnd % 10 + 1; j++) {
                                    if (i < 0 || j < 0 || i > 9 || j > 9)
                                        continue;
                                    if (cells[i][j] == 0) {
                                        gc1.setFill(Color.BLUE);
                                        gc1.fillOval(coordinatesX[j] + 12.5, coordinatesY[i] + 12.5, 5, 5);
                                        cells[i][j] = 1;
                                        textArea.appendText(vocalubary.GetKey(i * 10 + j));
                                        textArea.appendText(" ");
                                        string = string +  " " + vocalubary.GetKey(i * 10 + j);
                                        computerMemory.remove((Object)(i* 10 + j));
                                    }
                                    computerMemory.remove((Object)(i* 10 + j));
                                }
                        }
                    }
                    else if (cells[i1][i2] == 0 && map[i1][i2] != 1 && check != 2){
                        cells[i1][i2] = 1;
                        textArea.appendText(vocalubary.GetKey(i1 * 10 + i2));
                        textArea.appendText(" ");
                        string = string + "2) " + vocalubary.GetKey(i1 * 10 + i2);
                        sem = 11;
                        computerVariables.remove((Object)(i1 * 10 + i2));
                        computerMemory.remove((Object)(i1 * 10 + i2));
                        gc1.setFill(Color.BLUE);
                        gc1.fillOval(coordinatesX[i2] + 12.5, coordinatesY[i1] + 12.5, 5, 5);
                    }
                    else if (cells[i1][i2] == 1 && check != 2){
                        sem = 12;
                        System.out.println("cells != 1. Что-то пошло не так." );
                    }
                    vocalubary.addString(string);
                    if (computerVariables.size() > 0)
                        System.out.println("computerVariables = " + computerVariables);
                    if (myShipsDestroy.size() > 0)
                        System.out.println("myShipsDestroy = " + myShipsDestroy);
                    textArea.appendText("\n");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        System.err.println("");
                    }
                    if (sem == 10) {
                        try {
                            Robot rb = new Robot();
                            rb.keyPress('A');
                            rb.delay(100);
                            rb.keyRelease('A');
                        } catch (AWTException ex) {
                            System.err.println("");
                        }
                    }
                    else if (sem != 10){
                        try {
                            Robot rb = new Robot();
                            rb.keyPress('B');
                            rb.delay(100);
                            rb.keyRelease('B');
                        } catch (AWTException ex) {
                            System.err.println("");
                        }
                    }
                }
                else if (bKey.match(ke) && access == 3 && access12 == 1){
                    textArea.appendText("1) ");
                    int number = 0, i1, i2;
                    GraphicsContext gc1;
                    gc1 = canvas1.getGraphicsContext2D();
                    if (playerVariables.size() > 0){
                        Random rnd = new Random();
                        int point = rnd.nextInt(playerVariables.size());
                        number = playerVariables.get(point);
                    }
                    else
                        number = playerMemory.get(0);
                    i1 = number / 10;
                    i2 = number % 10;
                    String string = new String();
                    if (computerCells[i1][i2] == 0 && computerMap[i1][i2] == 1 && check != 2){
                        sem = 10;
                        playerMemory.remove((Object)(i1 * 10 + i2));
                        gc1.setFill(Color.RED);
                        gc1.fillOval(coordinatesX[i2] + 512.5 , coordinatesY[i1] + 12.5, 5, 5);
                        textArea.appendText(recursiveReverse(vocalubary.GetKey(i1 * 10 + i2)));
                        textArea.appendText(" ");
                        string = string + "1) " + recursiveReverse(vocalubary.GetKey(i1 * 10 + i2));
                        int index1 = 0;
                        int index2 = -1;
                        int numberOfShip = -1;
                        for (int i = 0; i < 10; i++) {
                            index2 = computerShips[i].IndexOf(i1 * 10 + i2);
                            if (index2 >= 0){
                                numberOfShip = i;
                                break;
                            }
                        }
                        if (index2 >= 0 && index4 < 1 && computerShips[numberOfShip].Size() >= 0){
                            playerMemory.remove((Object)(i1 * 10 + i2));
                            playerVariables.clear();
                            playerVariables.add((i1 - 1) * 10 + i2);
                            playerVariables.add((i1 + 1) * 10 + i2);
                            if (number / 10 == (number - 1) / 10)
                                playerVariables.add(i1 * 10 + i2 - 1);
                            if (number / 10 == (number + 1) / 10)
                                playerVariables.add(i1 * 10 + i2 + 1);
                            computerShipsDestroy.add(i1 * 10 + i2);
                            index4++;
                            for (int k = 0; k < playerVariables.size(); k++)
                                if (playerVariables.get(k) < 0 || playerVariables.get(k) >= 100){
                                    playerVariables.remove((Object)(playerVariables.get(k)));
                                    k--;
                                }
                            for (int k = 0; k < playerVariables.size(); k++)
                                if (computerCells[playerVariables.get(k) / 10][playerVariables.get(k) % 10] == 1){
                                    playerVariables.remove((Object)(playerVariables.get(k)));
                                    k--;
                                }

                            index1 = numberOfShip;
                            computerShips[index1].Remove(i1 * 10 + i2);
                        }
                        else if (index2 >= 0 && index4 >= 1 && computerShips[numberOfShip].Size() >= 0){
                            index1 = numberOfShip;
                            playerMemory.remove((Object)(i1 * 10 + i2));
                            computerShipsDestroy.add(i1 * 10 + i2);
                            playerVariables.clear();
                            int min = computerShipsDestroy.get(0), max = computerShipsDestroy.get(0);
                            for (int k = 1; k < computerShipsDestroy.size(); k++)
                                if (computerShipsDestroy.get(k) < min)
                                    min = computerShipsDestroy.get(k);
                            for (int k = 1; k < computerShipsDestroy.size(); k++)
                                if (computerShipsDestroy.get(k) > max)
                                    max = computerShipsDestroy.get(k);
                            if (max - min < 10){
                                if ((max + 1) / 10 ==  max / 10 && max + 1 < 100){
                                    playerVariables.add(max + 1);
                                }
                                if ((min - 1) / 10 == min / 10 && min - 1 >= 0)
                                    playerVariables.add(min - 1);
                            }
                            else{
                                if (max + 10 < 100)
                                    playerVariables.add(max + 10);
                                if (min - 10 >= 0)
                                    playerVariables.add(min - 10);
                            }
                            int checkNumber = 0;
                            int number1 = 0;
                            number1 = playerVariables.get(0);
                            int number2 = 0;
                            if (playerVariables.size() == 2){
                                number2 = playerVariables.get(1);
                                checkNumber = 1;
                            }
                            if (computerCells[number1 / 10][number1 % 10] == 1)
                                playerVariables.remove((Object)number1);
                            if (computerCells[number2 / 10][number2 % 10] == 1 && checkNumber == 1)
                                playerVariables.remove((Object)number2);
                            index4++;
                            computerShips[index1].Remove(i1 * 10 + i2);
                        }
                        if (computerShips[index1].Size() == 0 ) {
                            playerMemory.remove((Object)(number));
                            computerShipsDestroy.clear();
                            playerVariables.clear();
                            index4 = 0;
                            computerCells[i1][i2] = 1;
                            for (int i = computerShips[index1].locationStart / 10 - 1; i <= computerShips[index1].locationEnd / 10 + 1; i++)
                                for (int j = computerShips[index1].locationStart % 10 - 1; j <= computerShips[index1].locationEnd % 10 + 1; j++) {
                                    if (i < 0 || j < 0 || i > 9 || j > 9)
                                        continue;
                                    if (computerCells[i][j] == 0) {
                                        computerCells[i][j]++;
                                        gc1.setFill(Color.BLUE);
                                        gc1.fillOval(coordinatesX[j] + 512.5, coordinatesY[i] + 12.5, 5, 5);
                                        playerMemory.remove((Object)(i* 10 + j));
                                        textArea.appendText(vocalubary.GetKey(i * 10 + j));
                                        textArea.appendText(" ");
                                        string = string + " " + vocalubary.GetKey(i * 10 + j);
                                    }
                                    playerMemory.remove((Object)(i* 10 + j));
                                }
                        }
                    }
                    else if (computerCells[i1][i2] == 0 && computerMap[i1][i2] != 1 && check != 2){
                        textArea.appendText(vocalubary.GetKey(i1 * 10 + i2));
                        textArea.appendText(" ");
                        string = string + "1) " + vocalubary.GetKey(i1 * 10 + i2);
                        sem = 11;
                        playerVariables.remove((Object)(i1 * 10 + i2));
                        playerMemory.remove((Object)(i1 * 10 + i2));
                        gc1.setFill(Color.BLUE);
                        gc1.fillOval(coordinatesX[i2] + 512.5, coordinatesY[i1] + 12.5, 5, 5);
                    }
                    else if (computerCells[i1][i2] == 1 && check != 2){
                        sem = 12;
                        System.out.println("cells != 1 Что-то наверное совершенно точно пошло ну не так");
                    }
                    vocalubary.addString(string);
                    textArea.appendText("\n");
                    if (computerCells[i1][i2] == 0)
                        computerCells[i1][i2]++;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        System.err.println("");
                    }
                    if (playerVariables.size() > 0)
                        System.out.println("playerVariables = " + playerVariables);
                    if (computerShipsDestroy.size() > 0)
                        System.out.println("computerShipsDestroy = " + computerShipsDestroy);
                    if (sem == 10){
                        try {
                            Robot rb = new Robot();
                            rb.keyPress('B');
                            rb.delay(100);
                            rb.keyRelease('B');
                        } catch (AWTException ex) {
                            System.err.println("");
                        }
                    }
                    else if (sem != 10){
                        try {
                            Robot rb = new Robot();
                            rb.keyPress('A');
                            rb.delay(100);
                            rb.keyRelease('A');
                        } catch (AWTException ex) {
                            System.err.println("Я тут");
                        }
                    }
                }
            }
        });
    }

    public void getCanvasEvents(Canvas canvas1, TextArea textArea) {
        canvas1.setOnMouseClicked(new EventHandler<MouseEvent>() {          //событие клика по полю
            int i1, i2;
            @Override
            public void handle(MouseEvent event) {
                check = 0;
                if (access == 3 && access12 == 0 && event.getButton().equals(MouseButton.PRIMARY)) {
                    double x1 = event.getX();
                    double y1 = event.getY();
                    if (x1 > 700 && y1 > 100 && x1 < 1000 && y1 < 400) {
                        computerShipsDestroy.clear();
                        playerVariables.clear();
                        double a1 = x1 - 700;
                        double b1 = y1 - 100;
                        a1 = a1 % 30 - 15;
                        x1 = x1 - a1;
                        b1 = b1 % 30 - 15;
                        y1 = y1 - b1;
                        for (int i = 0; i < 10; i++) {
                            if (x1 == coordinatesX[i] + 500 + 15) {
                                i2 = i;
                                break;
                            }
                        }
                        for (int i = 0; i < 10; i++) {
                            if (y1 == coordinatesY[i] + 15) {
                                i1 = i;
                                break;
                            }
                        }
                        String string = new String();
                        GraphicsContext gc1;
                        gc1 = canvas1.getGraphicsContext2D();
                        computerCells[i1][i2]++;
                        if (computerCells[i1][i2] == 1 && computerMap[i1][i2] == 1) {
                            textArea.appendText("1) ");
                            textArea.appendText(recursiveReverse(vocalubary.GetKey(i1 * 10 + i2)));
                            textArea.appendText(" ");
                            string = string + "1) " + recursiveReverse(vocalubary.GetKey(i1 * 10 + i2));
                            sem = 1;
                            gc1.setFill(Color.RED);
                            gc1.fillOval(x1 - 2.5, y1 - 2.5, 5, 5);
                            int index1 = 0;
                            for (int i = 0; i < 10; i++) {
                                int index2 = computerShips[i].IndexOf(i1 * 10 + i2);
                                if (index2 >= 0) {
                                    index1 = i;
                                    computerShips[i].Remove(i1 * 10 + i2);
                                    playerMemory.remove((Object) (i1 * 10 + i2));
                                    break;
                                }
                            }
                            if (computerShips[index1].Size() == 0) {
                                //textArea.appendText("[ ");
                                for (int i1 = computerShips[index1].locationStart / 10 - 1; i1 <= computerShips[index1].locationEnd / 10 + 1; i1++)
                                    for (int j1 = computerShips[index1].locationStart % 10 - 1; j1 <= computerShips[index1].locationEnd % 10 + 1; j1++) {
                                        if (i1 < 0 || j1 < 0 || i1 > 9 || j1 > 9)
                                            continue;
                                        computerCells[i1][j1]++;
                                        if (computerCells[i1][j1] == 1) {
                                            textArea.appendText(vocalubary.GetKey(i1 * 10 + j1));
                                            textArea.appendText(" ");
                                            string = string + " " + vocalubary.GetKey(i1 * 10 + j1);
                                            gc1.setFill(Color.BLUE);
                                            gc1.fillOval(coordinatesX[j1] + 512.5, coordinatesY[i1] + 12.5, 5, 5);
                                            playerMemory.remove((Object) (i1 * 10 + j1));
                                        } else
                                            computerCells[i1][j1]--;
                                        playerMemory.remove((Object)(i1* 10 + j1));
                                    }
                                //textArea.appendText("]");
                            }
                        } else if (computerCells[i1][i2] == 1 && computerMap[i1][i2] != 1) {
                            textArea.appendText("1) ");
                            textArea.appendText(vocalubary.GetKey(i1 * 10 + i2));
                            textArea.appendText(" ");
                            string = string + "1) " + vocalubary.GetKey(i1 * 10 + i2);
                            sem = 0;
                            gc1.setFill(Color.BLUE);
                            gc1.fillOval(x1 - 2.5, y1 - 2.5, 5, 5);
                            playerMemory.remove((Object) (i1 * 10 + i2));
                        } else if (computerCells[i1][i2] != 1) {
                            sem = 2;
                            computerCells[i1][i2]--;
                            check = 2;
                        }
                        if (check != 2)
                            textArea.appendText("\n");
                        vocalubary.addString(string);
                        check = 1;
                    }
                    else
                        sem = 4;
                    if (sem == 0){
                        try {
                            Robot rb = new Robot();
                            rb.keyPress('A');
                            rb.delay(100);
                            rb.keyRelease('A');
                        } catch (AWTException ex) {
                            System.err.println("");
                        }
                    }
                }
            }
        });
    }

    public void setImages(){
        for (int i = 0; i < 10; i++)
            myShips[i].setImage();
    }

    public void drawImages(Canvas canvas1){
        for (int i = 0; i < 10; i++)
            myShips[i].drawImage(canvas1);
    }

    public void setMyShipsLife(){
        myShips[0].setLifes(4);
        for (int i = 1; i < 3; i++)
            myShips[i].setLifes(3);
        for (int i = 3; i < 6; i++)
            myShips[i].setLifes(2);
        for (int i = 6; i < 10; i++)
            myShips[i].setLifes(1);
    }

    public void  nullMap(){
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++)
                computerMap[i][j] = 0;
    }

    public void createMenuEvent(MenuItem menuItem, int level1){
        menuItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e){
                level = level1;
            }});
    }

    public void setLocations(){
        for (int i = 0; i < 10; i++){
            computerShips[i].setLocation();
        }
    }

    public void setMap(){
        map = new int[10][10];
    }

    public void clear(){
        computerMemory.clear();
        playerMemory.clear();
        myShipsDestroy.clear();
        computerShipsDestroy.clear();
        playerVariables.clear();
        computerVariables.clear();
    }

    public void createMemory(){
        if (level != 3){
            computerMemory.clear();
            playerMemory.clear();
            for (int i = 0; i < 100; i++){
                computerMemory.add(i);
                playerMemory.add(i);
            }
            Collections.shuffle(computerMemory);
            Collections.shuffle(playerMemory);
        }
    }

    public void myShuffle(){
        if (level == 3){
            ArrayList<Integer> buffer = new ArrayList<>();
            computerMemory.clear();
            playerMemory.clear();
            int data = 0;
            for (int i = 3; i < 100; i += 4){
                if (data / 10 == i / 10)
                    buffer.add(i);
                else if (data / 10 != i / 10 && data % 10 != 9){
                    i++;
                    buffer.add(i);
                }
                else if (data / 10 != i / 10 && data % 10 == 9){
                    i -= 3;
                    buffer.add(i);
                }
                data = i;
            }
            Collections.shuffle(buffer);
            computerMemory.addAll(buffer);
            Collections.shuffle(buffer);
            playerMemory.addAll(buffer);
            ArrayList<Integer> buffer3 = new ArrayList<>();
           /* data = 0;
            for (int i = 1; i < 100; i += 2){
                if (data / 10 != i / 10 && i % 2 == 0)
                    i++;
                else if (data / 10 != i / 10 && i % 2 == 1)
                    i--;
                int index = buffer.indexOf(i);
                if (index >= 0){
                    data = i;
                    continue;
                }
                else{
                    data = i;
                    buffer3.add(i);
                }
            }
            //System.out.println("buffer3 = " + buffer3);
            Collections.shuffle(buffer3);
            computerMemory.addAll(buffer3);
            Collections.shuffle(buffer3);
            playerMemory.addAll(buffer3);
            buffer.addAll(buffer3);*/
            //System.out.println("buffer = " + buffer);
            //System.out.println("buffer.size() = " + buffer.size());
            ArrayList<Integer> buffer2 = new ArrayList<>();
            for (int i = 0; i < 100; i++)
                if (buffer.indexOf(i) < 0)
                    buffer2.add(i);
            Collections.shuffle(buffer2);
            computerMemory.addAll(buffer2);
            Collections.shuffle(buffer2);
            playerMemory.addAll(buffer2);
        }
    }


    public int countCells(){
        int count = 0;
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++)
                if (computerMap[i][j] == 0)
                    count++;
        return count;
    }

    public boolean check(){
        boolean check1 = false;
        int count = countCells();
        if (level == 1 && count <= 40)
            check1 = true;
        else if(level == 2 && count > 40 && count <= 50)
            check1 = true;
        else if (level == 3 && count >= 50)
            check1 = true;
        return check1;
    }

    public void setMyShips(ImagesOfShips[] info){
        for (int i = 0; i < 10; i++){
            myShips[i].setMapShip(info[i].getMapShip());
            System.out.println();
            myShips[i].showArrayList();
        }
    }

    public void setComputerShips(ImagesOfShips[] info){
        for (int i = 0; i < 10; i++){
            computerShips[i].showArrayList();
        }
    }

    public void setAngles(){
        for (int i = 0; i < 10; i++)
            myShips[i].setAngle();
    }

    public void setAlignment(int life, int index){
        Random rnd = new Random();
        int rotation = rnd.nextInt(2);
        rotation *= 10;
        if (rotation == 0)
            rotation++;
        int X, Y, X1, Y1;
        if (rotation == 10){
            Y = rnd.nextInt(11 - life);
            X = rnd.nextInt(10);
            X1 = X;
            Y1 = Y + life - 1;
        }
        else{
            X = rnd.nextInt(11 - life);
            Y = rnd.nextInt(10);
            X1 = X + life - 1;
            Y1 = Y;
        }
        while(computerMap[Y][X] != 0 || computerMap[Y1][X1] != 0){
            if (rotation == 1){
                X++;
                X1++;
                if (X1 >= 10){
                    X = 0;
                    X1 = life - 1;
                    if (Y == 9){
                        Y = 0;
                        Y1 = 0;
                    }
                    else{
                        Y++;
                        Y1++;
                    }
                }
            }
            else if (rotation == 10){
                Y++;
                Y1++;
                if (Y1 >= 10){
                    Y = 0;
                    Y1 = (life - 1);
                    if (X == 9){
                        X = 0;
                        X1 = 0;
                    }
                    else{
                        X++;
                        X1++;
                    }
                }
            }
        }
        for (int i = Y; i <= Y1; i++)
            for (int j = X; j <= X1; j++)
                computerMap[i][j] = 1;
        for (int i = Y - 1; i <= Y1 + 1; i++)
            for (int j = X - 1; j <= X1 + 1; j++){
                if (i < 0 || j < 0 || i > 9 || j > 9)
                    continue;
                else if (computerMap[i][j] != 1){
                    computerMap[i][j] = -1;
                }
            }
        int numberBegin = Y * 10 + X;
        int numberEnd = Y1 * 10 + X1;
        int step;
        computerShips[index].clearList();
        if (numberEnd - numberBegin >= 10)
            step = 10;
        else
            step = 1;
        for (int buffer = numberBegin; buffer <= numberEnd; buffer += step){
            computerShips[index].Add(buffer);
        }
    }

    void showShips(){
        for (int i = 0; i < 10; i++){
            computerShips[i].showArrayList();
        }
    }

    public void showMap(){
        for (int i = 0; i < 10; i++) {
            System.out.println();
            for (int j = 0; j < 10; j++){
                System.out.print(computerMap[i][j] + "\t\t");
                System.out.print(' ');
            }
        }
    }

    public void initMap(){
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++){
                map[i][j] = 0;
                computerMap[i][j] = 0;
                computerCells[i][j] = 0;
                cells[i][j] = 0;
            }

    }

}