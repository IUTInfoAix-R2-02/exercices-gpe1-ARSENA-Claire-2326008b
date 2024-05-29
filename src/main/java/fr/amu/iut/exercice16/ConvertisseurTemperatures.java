package fr.amu.iut.exercice16;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class ConvertisseurTemperatures extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Initialisation des sliders
        Slider sliderCelsius = createSlider(0, 100, 0, 10, 1);
        Slider sliderFahrenheit = createSlider(0, 212, 32, 20, 1);

        // Initialisation des champs de texte pour afficher les températures
        TextField textCelsius = createTextField();
        TextField textFahrenheit = createTextField();

        // Création des labels pour les unités
        Label labelCelsius = new Label("°C");
        Label labelFahrenheit = new Label("°F");

        // Mise en page des composants pour Celsius
        VBox panneauCelsius = createVBox(labelCelsius, sliderCelsius, textCelsius);

        // Mise en page des composants pour Fahrenheit
        VBox panneauFahrenheit = createVBox(labelFahrenheit, sliderFahrenheit, textFahrenheit);

        // Mise en page principale
        HBox root = new HBox(30, panneauCelsius, panneauFahrenheit);
        root.setPadding(new Insets(20));
        HBox.setHgrow(panneauCelsius, Priority.ALWAYS);
        HBox.setHgrow(panneauFahrenheit, Priority.ALWAYS);

        // Liaison bidirectionnelle des valeurs des sliders et des champs de texte
        bindSliderAndTextField(sliderCelsius, textCelsius);
        bindSliderAndTextField(sliderFahrenheit, textFahrenheit);

        // Liaison bidirectionnelle pour la conversion des températures
        createTemperatureBinding(sliderCelsius, sliderFahrenheit);

        // Configuration de la scène et affichage de la fenêtre
        primaryStage.setScene(new Scene(root, 300, 400));
        primaryStage.setTitle("Convertisseur de Températures");
        primaryStage.show();
    }

    // Méthode utilitaire pour créer un slider avec les paramètres spécifiés
    private Slider createSlider(double min, double max, double value, double majorTickUnit, int minorTickCount) {
        Slider slider = new Slider(min, max, value);
        slider.setOrientation(Orientation.VERTICAL);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setMajorTickUnit(majorTickUnit);
        slider.setMinorTickCount(minorTickCount);
        return slider;
    }

    // Méthode utilitaire pour créer un champ de texte avec une largeur maximale définie
    private TextField createTextField() {
        TextField textField = new TextField();
        textField.setMaxWidth(60);
        return textField;
    }

    // Méthode utilitaire pour créer une VBox avec les composants spécifiés
    private VBox createVBox(Label label, Slider slider, TextField textField) {
        VBox vbox = new VBox(10, label, slider, textField);
        VBox.setVgrow(slider, Priority.ALWAYS);
        return vbox;
    }

    // Méthode utilitaire pour lier bidirectionnellement un slider et un champ de texte
    private void bindSliderAndTextField(Slider slider, TextField textField) {
        Bindings.bindBidirectional(textField.textProperty(), slider.valueProperty(), new NumberStringConverter());
    }

    // Méthode utilitaire pour créer une liaison bidirectionnelle pour la conversion des températures
    private void createTemperatureBinding(Slider sliderCelsius, Slider sliderFahrenheit) {
        sliderCelsius.valueProperty().addListener((obs, oldVal, newVal) -> {
            double celsius = newVal.doubleValue();
            double fahrenheit = celsiusToFahrenheit(celsius);
            if (sliderFahrenheit.getValue() != fahrenheit) {
                sliderFahrenheit.setValue(fahrenheit);
            }
        });

        sliderFahrenheit.valueProperty().addListener((obs, oldVal, newVal) -> {
            double fahrenheit = newVal.doubleValue();
            double celsius = fahrenheitToCelsius(fahrenheit);
            if (sliderCelsius.getValue() != celsius) {
                sliderCelsius.setValue(celsius);
            }
        });
    }

    // Méthode de conversion de Celsius en Fahrenheit
    private double celsiusToFahrenheit(double celsius) {
        return celsius * 9 / 5 + 32;
    }

    // Méthode de conversion de Fahrenheit en Celsius
    private double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}
