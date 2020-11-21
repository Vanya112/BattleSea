package sample;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.*;

public class ButtonFactory extends AbstractButtonFactory {

    public ButtonFactory(){
        this.prefWidth = 10;
        this.prefHeight = 10;
        this.LayoutX = 0;
        this.LayoutY = 0;
    }

    public ButtonFactory(String name, double prefWidth, double prefHeight, double LayoutX, double LayoutY){
        this.name = name;
        this.prefWidth = prefWidth;
        this.prefHeight = prefHeight;
        this.LayoutX = LayoutX;
        this.LayoutY = LayoutY;
    }

    public void setComponents(String name, double prefWidth, double prefHeight, double LayoutX, double LayoutY){
        this.name = name;
        this.prefWidth = prefWidth;
        this.prefHeight = prefHeight;
        this.LayoutX = LayoutX;
        this.LayoutY = LayoutY;
    }

    public Button createButton(){
        Button button = new Button(this.name);
        button.setStyle(this.style);
        button.setPrefSize(this.prefWidth, this.prefHeight);
        button.setLayoutX(this.LayoutX);
        button.setLayoutY(this.LayoutY);
        button.setCursor(Cursor.HAND);
        return button;
    }
}
