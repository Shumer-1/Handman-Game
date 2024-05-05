package org.example;

import javafx.animation.PauseTransition;
import javafx.collections.ObservableList;
import javafx.scene.CacheHint;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.util.Duration;

import static org.example.Javafx.*;
import static org.example.GameLogic.*;

public class InputInfo {
    static int counter = 0;

    public static void inputGameWord(){
        Label label = new Label("Игрок " + firstUserName + " введите слово:");
        label.setLayoutX(1000);
        label.setLayoutY(100);
        label.setTextFill(Color.WHITE);
        label.setFont(Font.font("Arial", 32));

        TextField textField = new TextField();
        textField.setLayoutX(1000);
        textField.setLayoutY(140);
        textField.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-font-size: 30px;");

        Button button = new Button("Подтвердить");
        button.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button.setLayoutY(204);
        button.setLayoutX(1000);
        button.setOnAction(event->{
            gamaWord = textField.getText();
            label.setText("Отлично, слово принято!");
            root.getChildren().remove(textField);
            root.getChildren().remove(button);
            PauseTransition delay = new PauseTransition(Duration.seconds(2));
            delay.setOnFinished(wait -> {
                root.getChildren().remove(label);
            });
            delay.play();
        });
        root.getChildren().add(label);
        root.getChildren().add(textField);
        root.getChildren().add(button);
    }


    public static void inputFirstName(){
        Label label = new Label("Введите ваше имя:");
        TextField textField = new TextField();
        label.setLayoutX(20);
        label.setLayoutY(20);
        label.setFont(Font.font("Arial", 20));
        label.setTextFill(Color.WHITE);

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
            label.setTextFill(Color.WHITE);
            ObservableList<Node> children = root.getChildren();
            PauseTransition delay = new PauseTransition(Duration.seconds(2));
            delay.setOnFinished(wait -> {
                root.getChildren().remove(label);
            });
            delay.play();
            children.remove(button);
            children.remove(textField);
            if (counter == 2){
                addBody();
                addHead();
                addLegs();
                addArms();
                inputGameWord();
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
        label.setFont(Font.font("Arial", 20));
        label.setTextFill(Color.WHITE);
        textField.setLayoutX(700);
        textField.setLayoutY(50);
        Button button = new Button("Подтвердить");
        button.setLayoutX(700);
        button.setLayoutY(100);
        button.setOnAction(event -> {
            String inputText = textField.getText(); // Получаем текст из текстового поля
            secondUserName = inputText;
            label.setText(inputText + " взялся за дело!");
            label.setFont(Font.font("Arial", 20));
            label.setTextFill(Color.WHITE);
            PauseTransition delay = new PauseTransition(Duration.seconds(2));
            delay.setOnFinished(wait -> {
                root.getChildren().remove(label);
            });
            delay.play();
            ObservableList<Node> children = root.getChildren();
            children.remove(button);
            children.remove(textField);
            ++counter;
            if (counter == 2){
                addBody();
                addHead();
                addLegs();
                addArms();
                inputGameWord();
            }
        });
        root.getChildren().add(label);
        root.getChildren().add(textField);
        root.getChildren().add(button);
    }
}
