package fr.amu.iut.exercice11;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Palette extends Application {

    private IntegerProperty nbVert;
    private IntegerProperty nbRouge;
    private IntegerProperty nbBleu;

    private IntegerProperty nbFois;
    private StringProperty message;
    private StringProperty couleurPanneau;
    private Label texteDuHaut;
    private Button vert;
    private Button rouge;
    private Button bleu;
    private BorderPane root;
    private Pane panneau;
    private HBox boutons;
    private Label texteDuBas;

    private BooleanProperty pasEncoreDeClic;

    // clic bouton vert ++
    private EventHandler<ActionEvent> buttonClickHandlerVert = actionEvent -> {
        nbVert.set(nbVert.get() + 1);
        nbFois.set(nbFois.get() + 1);
        couleurPanneau.set("#64b264");
        texteDuBas.setText("le vert est une jolie couleur!!");
        texteDuBas.setStyle("-fx-text-fill: #64b264;");
    };

    // clic bouton rouge ++
    private EventHandler<ActionEvent> buttonClickHandlerRouge = actionEvent -> {
        nbRouge.set(nbRouge.get() + 1);
        nbFois.set(nbFois.get() + 1);
        couleurPanneau.set("#b70000");
        texteDuBas.setText("le rouge est une jolie couleur!!");
        texteDuBas.setStyle("-fx-text-fill: #b70000;");
    };

    // clic bouton bleu ++
    private EventHandler<ActionEvent> buttonClickHandlerBleu = actionEvent -> {
        nbBleu.set(nbBleu.get() + 1);
        nbFois.set(nbFois.get() + 1);
        couleurPanneau.set("#5d81e5");
        texteDuBas.setText("le bleu est une jolie couleur!!");
        texteDuBas.setStyle("-fx-text-fill: #5d81e5;");
    };

    public Palette() {
        this.nbVert = new SimpleIntegerProperty(0);
        this.nbRouge = new SimpleIntegerProperty(0);
        this.nbBleu = new SimpleIntegerProperty(0);
        this.nbFois = new SimpleIntegerProperty(0);
        this.message = new SimpleStringProperty();
        this.couleurPanneau = new SimpleStringProperty("#000000");
        this.pasEncoreDeClic = new SimpleBooleanProperty(true);
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void createBindings() {
        // Binding pour texteDuHaut
        texteDuHaut.textProperty().bind(
                Bindings.when(pasEncoreDeClic)
                        .then("aucun bouton cliqué")
                        .otherwise(Bindings.concat(
                                "vert choisi ", nbVert.asString(), " fois, ",
                                "rouge choisi ", nbRouge.asString(), " fois, ",
                                "bleu choisi ", nbBleu.asString(), " fois"))
        );

        // Binding pour panneau
        panneau.styleProperty().bind(Bindings.concat("-fx-background-color: ", couleurPanneau));

        // Binding pour pasEncoreDeClic
        pasEncoreDeClic.bind(Bindings.equal(nbFois, 0));
    }

    @Override
    public void start(Stage primaryStage) {
        root = new BorderPane();
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
        vert.setOnAction(buttonClickHandlerVert);
        bas.getChildren().add(vert);

        rouge = new Button("Rouge");
        rouge.setOnAction(buttonClickHandlerRouge);
        bas.getChildren().add(rouge);

        bleu = new Button("Bleu");
        bleu.setOnAction(buttonClickHandlerBleu);
        bas.getChildren().add(bleu);

        boutons.getChildren().addAll(vert, rouge, bleu);

        root.setCenter(panneau);
        root.setTop(texteDuHaut);
        root.setBottom(bas);

        createBindings();

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
