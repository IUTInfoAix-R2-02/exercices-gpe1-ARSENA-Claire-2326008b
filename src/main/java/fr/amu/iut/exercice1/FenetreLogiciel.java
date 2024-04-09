package fr.amu.iut.exercice1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class FenetreLogiciel extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane bp = new BorderPane();

        // menu
        Menu File = new Menu("File");
        Menu Edit = new Menu("Edit");
        Menu Help = new Menu("Help");
        MenuItem New = new MenuItem("New");
        MenuItem Open = new MenuItem("Open");
        MenuItem Save = new MenuItem("Save");
        MenuItem Close = new MenuItem("Close");
        File.getItems().addAll(New, Open, Close, Save);
        MenuItem Cut = new MenuItem("Cut");
        MenuItem Copy = new MenuItem("Copy");
        MenuItem Paste = new MenuItem("Paste");
        Edit.getItems().addAll(Cut, Copy, Paste);
        MenuBar Bar = new MenuBar(File, Edit, Help);

        // partie basse
        Label lBottom = new Label("label de bas de page");
        Separator sep3 = new Separator(Orientation.HORIZONTAL);
        VBox vbBottom = new VBox();
        vbBottom.getChildren().addAll(sep3, lBottom);
        lBottom.setAlignment(Pos.CENTER);

        // partie gauche
        VBox vb = new VBox();
        Label lBoutons = new Label("Boutons :");
        Button b1 = new Button("Bouton 1");
        Button b2 = new Button("Bouton 2");
        Button b3 = new Button("Bouton 3");
        Separator sep1 = new Separator(Orientation.HORIZONTAL);
        Separator sep2 = new Separator(Orientation.VERTICAL);
        vb.getChildren().addAll(lBoutons, b1, b2, b3);

        HBox hbLeft = new HBox();
        hbLeft.getChildren().addAll(vb, sep2);
        VBox.setMargin(vb, new Insets(10.0d));

        // centre
        GridPane gP = new GridPane();
        HBox hbBoutons = new HBox();

        VBox vbCenter = new VBox();
        Button btnSubmit = new Button("Submit");
        Button btnCancel = new Button("Cancel");
        hbBoutons.getChildren().addAll(btnSubmit, btnCancel);
        vbCenter.getChildren().addAll(gP, hbBoutons);
        Label lName = new Label("Name :");
        Label lEmail = new Label("Email :");
        Label lPass = new Label("Password :");
        var nameField = new TextField();
        var emailField = new TextField();
        var passField = new TextField();
        GridPane.setConstraints(lName, 0, 0);
        GridPane.setConstraints(nameField, 1, 0);
        GridPane.setConstraints(lEmail, 0, 1);
        GridPane.setConstraints(emailField, 1, 1);
        GridPane.setConstraints(lPass, 0, 2);
        GridPane.setConstraints(passField, 1, 2);
        gP.getChildren().addAll(lName, nameField, lEmail, emailField, lPass, passField);
        hbBoutons.setSpacing(8);
        vb.setSpacing(10);
        GridPane.setMargin(lName, new Insets(10.0d));
        GridPane.setMargin(lEmail, new Insets(10.0d));
        GridPane.setMargin(lPass, new Insets(10.0d));
        vbCenter.setAlignment(Pos.CENTER);
        gP.setAlignment(Pos.CENTER);
        hbBoutons.setAlignment(Pos.CENTER);
        vb.setAlignment(Pos.CENTER);


        lBottom.setTextAlignment(TextAlignment.CENTER);
        vbBottom.setAlignment(Pos.CENTER);
        bp.setLeft(hbLeft);
        bp.setCenter(vbCenter);
        bp.setBottom(vbBottom);
        bp.setTop(Bar);

        Scene sc = new Scene(bp);
        primaryStage.setScene(sc);
        primaryStage.setWidth(600);
        primaryStage.setHeight(450);
        primaryStage.setTitle("premier exemple contenant les conteneurs");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
