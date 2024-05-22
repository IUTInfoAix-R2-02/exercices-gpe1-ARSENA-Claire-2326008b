package fr.amu.iut.exercice11;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

@SuppressWarnings("Duplicates")
public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Label texteDuHaut;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private Pane panneau;
    private HBox boutons;

    private Label texteDuBas;

    // clic bouton vert ++
    private EventHandler<MouseEvent> buttonClickHandlerVert = actionEvent -> {
        texteDuHaut.setText("vert choisi " + nbVert++ + " fois");
        panneau.setStyle("-fx-background-color: #64b264");
    };

    // clic bouton rouge ++
    private EventHandler<MouseEvent> buttonClickHandlerRouge = actionEvent -> {
        texteDuHaut.setText("rouge choisi " + nbRouge++ + " fois");
        panneau.setStyle("-fx-background-color: #b70000");

    };

    // clic bouton bleu ++
    private EventHandler<MouseEvent> buttonClickHandlerBleu = actionEvent -> {
        texteDuHaut.setText("bleu choisi " + nbBleu++ + " fois");
        panneau.setStyle("-fx-background-color: #5d81e5");
    };

    @Override
    public void start(Stage primaryStage) {
        root = new BorderPane();
        texteDuHaut = new Label();
        texteDuHaut = new Label();
        texteDuHaut.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        BorderPane.setAlignment(texteDuHaut, Pos.CENTER);

        panneau = new Pane();
        panneau.setPrefSize(400, 200);

        VBox bas = new VBox();
        boutons = new HBox(10);
        boutons.setAlignment(Pos.CENTER);
        boutons.setPadding(new Insets(10, 5, 10, 5));
        texteDuBas = new Label();
        bas.setAlignment(Pos.CENTER_RIGHT);
        bas.getChildren().addAll(boutons, texteDuBas);

        vert = new Button("Vert");
        vert.addEventHandler(MouseEvent.MOUSE_CLICKED, buttonClickHandlerVert);
        bas.getChildren().add(vert);

        rouge = new Button("Rouge");
        rouge.addEventHandler(MouseEvent.MOUSE_CLICKED, buttonClickHandlerRouge);
        bas.getChildren().add(rouge);

        bleu = new Button("Bleu");
        bleu.addEventHandler(MouseEvent.MOUSE_CLICKED, buttonClickHandlerBleu);
        bas.getChildren().add(bleu);

        /* VOTRE CODE ICI */

        boutons.getChildren().addAll(vert, rouge, bleu);

        root.setCenter(panneau);
        root.setTop(texteDuHaut);
        root.setBottom(bas);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

