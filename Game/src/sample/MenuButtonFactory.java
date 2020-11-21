package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Side;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.control.MenuItem;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MenuButtonFactory extends AbstractButtonFactory {
    protected int level;

    public MenuButtonFactory(){
        this.prefWidth = 10;
        this.prefHeight = 10;
        this.LayoutX = 0;
        this.LayoutY = 0;
        this.level = 1;
    }

    public MenuButtonFactory(String name, double prefWidth, double prefHeight, double LayoutX, double LayoutY, int level){
        this.name = name;
        this.prefWidth = prefWidth;
        this.prefHeight = prefHeight;
        this.LayoutX = LayoutX;
        this.LayoutY = LayoutY;
        this.level = level;
        try {
            Robot rb=new Robot();
            rb.keyPress(KeyEvent.VK_A);
            rb.keyRelease(KeyEvent.VK_A);
        }
        catch (AWTException ex) {System.err.println();}
    }

    public void setComponents(String name, double prefWidth, double prefHeight, double LayoutX, double LayoutY, int level){
        this.name = name;
        this.prefWidth = prefWidth;
        this.prefHeight = prefHeight;
        this.LayoutX = LayoutX;
        this.LayoutY = LayoutY;
        this.level = level;
    }

    public MenuButton createButton(){
        MenuButton button = new MenuButton(this.name);
        button.setStyle(this.style);
        button.setPrefSize(this.prefWidth, this.prefHeight);
        button.setLayoutX(this.LayoutX);
        button.setLayoutY(this.LayoutY);
        button.setCursor(Cursor.HAND);
        button.setWrapText(true);
        button.setPopupSide(Side.LEFT);
        return button;
    }

    public MenuItem createMenuItem(String name1){
        MenuItem item = new MenuItem(name1);
        item.setStyle("-fx-font:bold italic 14pt Times;");
        return item;
    }
}