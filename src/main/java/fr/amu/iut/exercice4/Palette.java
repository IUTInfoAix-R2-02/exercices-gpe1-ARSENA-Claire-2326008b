package fr.amu.iut.exercice4;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private Label label;
    private Pane panneau;

    //partie basse
    private HBox hBbas;

    // clic bouton vert ++
    private EventHandler<MouseEvent> buttonClickHandlerVert = actionEvent -> {
        label.setText("vert choisi " + nbVert++ + " fois");
    };

    // clic bouton rouge ++
    private EventHandler<MouseEvent> buttonClickHandlerRouge = actionEvent -> {
        label.setText("rouge choisi " + nbRouge++ + " fois");
    };

    // clic bouton bleu ++
    private EventHandler<MouseEvent> buttonClickHandlerBleu = actionEvent -> {
        label.setText("bleu choisi " + nbBleu++ + " fois");
    };

    @Override
    public void start(Stage primaryStage) throws Exception {

        root = new BorderPane();
        label = new Label();
        hBbas = new HBox();
        panneau = new Pane();

        //borderpane
        BorderPane.setAlignment(label, Pos.CENTER);
        root.setTop(label);
        root.setCenter(panneau);
        root.setBottom(hBbas);
        root.setPrefSize(400, 200);
        Scene scene = new Scene(root);



        //bas hbox et de bouton
        rouge = new Button("rouge");
        rouge.addEventHandler(MouseEvent.MOUSE_CLICKED, buttonClickHandlerRouge);
        hBbas.getChildren().add(rouge);

        vert = new Button("vert");
        vert.addEventHandler(MouseEvent.MOUSE_CLICKED, buttonClickHandlerVert);
        hBbas.getChildren().add(vert);

        bleu = new Button("bleu");
        bleu.addEventHandler(MouseEvent.MOUSE_CLICKED, buttonClickHandlerBleu);
        hBbas.getChildren().add(bleu);

        //milieu
        if (nbRouge > nbBleu && nbRouge > nbVert) {
            panneau.setStyle("-fx-background-color: #ff0000");
        } else if (nbVert > nbBleu && nbVert > nbRouge) {
            panneau.setStyle("-fx-background-color: #5dd25d");
        } else if (nbBleu > nbRouge && nbBleu > nbVert) {
            panneau.setStyle("-fx-background-color: #2e69ff");
        }
         else
             panneau.setStyle("-fx-background-color: #ffffff");

        hBbas.setAlignment(Pos.CENTER);
        root.setTop(label);
        root.setBottom(hBbas);
        hBbas.setSpacing(5);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

