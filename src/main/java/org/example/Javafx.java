package org.example;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Javafx extends Application{

    static Pane root;
    static String firstUserName;
    static int weight = 2000;
    static int height = 1100;
    static Scene scene;
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Создание корневого узла (layout) для размещения элементов
        root = new Pane();
        Button button = startWindow();
        button.setOnAction(event->{
            ObservableList<Node> children = root.getChildren();
            children.remove(0);
            children.remove(button);
            mainWindow();
        });
        scene = new Scene(root, weight, height);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Game");
        primaryStage.show();
    }
    public static void mainWindow(){
        addGallows();
        Ellipse loop = addLoop();
        ObservableList<Node> children = root.getChildren();
        children.remove(loop);
        addBody();
        addHead();
        addLegs();
        addArms();
        root.setStyle("-fx-background-color: lightblue;");
        InputInfo.inputFirstName();
        InputInfo.inputSecondName();
    }

    public static Button startWindow(){
        root.setStyle("-fx-background-color: black;");
        Label label = new Label("В-И-С-Е-Л-И-Ц-А");
        label.setLayoutX((double) weight /2-200);
        label.setLayoutY((double) height /2);
        label.setFont(Font.font("Arial", 40));
        label.setTextFill(Color.WHITE);
        Button button = new Button("НАЧАТЬ ИГРУ");
        button.setLayoutX((double) weight / 2);
        button.setLayoutY((double) height / 2 + 100);
        button.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");
        button.setTextFill(Color.WHITE); // Устанавливаем цвет текста
        button.setScaleX(2); // Увеличиваем ширину кнопки в 2 раза
        button.setScaleY(2); // Увеличиваем высоту кнопки в 2 раза
        root.getChildren().add(label);
        root.getChildren().add(button);
        return button;
    }

    public static Ellipse addBody(){
        // овал - тело человека
        Ellipse ellipse = new Ellipse();
        ellipse.setCenterX(550); // + 400
        ellipse.setCenterY(500); // + 400
        ellipse.setRadiusX(40);
        ellipse.setRadiusY(80);
        ellipse.setFill(Color.GRAY);
        ellipse.setStroke(Color.BLACK);
        root.getChildren().add(ellipse);

        return ellipse;
    }

    public static Ellipse addHead() {
        // овал - голова человека
        Ellipse ellipse = new Ellipse();
        ellipse.setCenterX(550); // центр головы по горизонтали такой же, как у тела
        ellipse.setCenterY(430); // центр головы находится над центром тела
        ellipse.setRadiusX(35);
        ellipse.setRadiusY(35);
        ellipse.setFill(Color.RED);
        ellipse.setStroke(Color.BLACK);
        root.getChildren().add(ellipse);
        return ellipse;
    }

    public static Ellipse addLoop(){

        Ellipse ellipse = new Ellipse();
        ellipse.setCenterX(550);
        ellipse.setCenterY(420);
        ellipse.setRadiusX(25);
        ellipse.setRadiusY(30);
        ellipse.setFill(Color.LIGHTBLUE);
        ellipse.setStroke(Color.BLACK);

        root.getChildren().add(ellipse);
        return ellipse;
    }
    public static void addGallows(){
        Rectangle basis = new Rectangle();

        // Устанавливаем координаты верхнего левого угла прямоугольника и его размеры
        basis.setX(150);
        basis.setY(750);
        basis.setWidth(450);
        basis.setHeight(50);

        basis.setFill(Color.BROWN);
        basis.setStroke(Color.BLACK);
        root.getChildren().add(basis);


        Rectangle pillar = new Rectangle();
        pillar.setX(290);
        pillar.setY(300);
        pillar.setWidth(20);
        pillar.setHeight(800-355+5);
        pillar.setFill(Color.BROWN);
        pillar.setStroke(Color.BLACK);
        root.getChildren().add(pillar);

        Rectangle crossbar = new Rectangle();
        crossbar.setX(290);
        crossbar.setY(300);
        crossbar.setWidth(550-290+20);
        crossbar.setHeight(20);
        crossbar.setStroke(Color.BLACK);
        crossbar.setFill(Color.BROWN);
        root.getChildren().add(crossbar);

        Line rope = new Line();
        rope.setStartX(550);
        rope.setStartY(320);
        rope.setEndX(550);
        rope.setEndY(395);
        root.getChildren().add(rope);
    }
    public static void addLegs(){
        Line leftLeg = new Line();
        leftLeg.setStrokeWidth(3);
        leftLeg.setStartY(560);
        leftLeg.setStartX(540);
        leftLeg.setEndX(520);
        leftLeg.setEndY(670);
        root.getChildren().add(leftLeg);


        Line rightLeg = new Line();
        rightLeg.setStrokeWidth(3);
        rightLeg.setStartY(560);
        rightLeg.setStartX(560);
        rightLeg.setEndX(580);
        rightLeg.setEndY(670);
        root.getChildren().add(rightLeg);
    }


    public static void addArms(){
        Line leftArm = new Line();
        leftArm.setStrokeWidth(3);
        leftArm.setStartY(480);
        leftArm.setStartX(514);
        leftArm.setEndX(489);
        leftArm.setEndY(560);
        root.getChildren().add(leftArm);


        Line rightArm = new Line();
        rightArm.setStrokeWidth(3);
        rightArm.setStartY(480);
        rightArm.setStartX(586);
        rightArm.setEndX(611);
        rightArm.setEndY(560);
        root.getChildren().add(rightArm);
    }
    public static void main(String[] args) {
        launch(args);
    }
}