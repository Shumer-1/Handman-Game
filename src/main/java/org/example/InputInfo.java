package org.example;

import javafx.collections.ObservableList;
import javafx.scene.CacheHint;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

import static org.example.Javafx.*;

public class InputInfo {
    static int counter = 0;
    public static void inputFirstName(){
        Label label = new Label("Введите ваше имя:");
        TextField textField = new TextField();
        label.setLayoutX(20);
        label.setLayoutY(20);
        textField.setLayoutX(20);
        textField.setLayoutY(50);
        Button button = new Button("Подтвердить");
        button.setLayoutX(20);
        button.setLayoutY(100);
        button.setOnAction(event -> {
            ++counter;
            String inputText = textField.getText(); // Получаем текст из текстового поля
            firstUserName = inputText;
            label.setText(inputText + " взялся за дело!");
            label.setFont(Font.font("Arial", 20));
            label.setTextFill(Color.CRIMSON);
            ObservableList<Node> children = root.getChildren();
            children.remove(button);
            children.remove(textField);
            if (counter == 2){
                addBody();
                addHead();
                addLegs();
                addArms();
            }
        });
        root.getChildren().add(label);
        root.getChildren().add(textField);
        root.getChildren().add(button);
    }

    public static void inputSecondName(){
        Label label = new Label("Введите ваше имя:");
        TextField textField = new TextField();
        label.setLayoutX(700);
        label.setLayoutY(20);
        textField.setLayoutX(700);
        textField.setLayoutY(50);
        Button button = new Button("Подтвердить");
        button.setLayoutX(700);
        button.setLayoutY(100);
        button.setOnAction(event -> {
            String inputText = textField.getText(); // Получаем текст из текстового поля
            firstUserName = inputText;
            label.setText(inputText + " взялся за дело!");
            label.setFont(Font.font("Arial", 20));
            label.setTextFill(Color.PURPLE);
            ObservableList<Node> children = root.getChildren();
            children.remove(button);
            children.remove(textField);
            ++counter;
            if (counter == 2){
                addBody();
                addHead();
                addLegs();
                addArms();
            }
        });
        root.getChildren().add(label);
        root.getChildren().add(textField);
        root.getChildren().add(button);
    }
}
