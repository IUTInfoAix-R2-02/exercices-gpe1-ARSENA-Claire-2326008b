package fr.amu.iut.exercice15;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LoginControl extends GridPane {
    @FXML
    private TextField userId;

    @FXML
    private PasswordField pwd;

    @FXML
    private Button okButton;

    @FXML
    private Button cancelButton;

    private void createBindings() {
        // Le champ du mot de passe ne sera pas éditable si la longueur du nom d'utilisateur est inférieure à 6 caractères
        pwd.disableProperty().bind(userId.textProperty().length().lessThan(6));

        // Le bouton cancel ne sera cliquable que si les deux champs ne sont pas vides
        BooleanBinding bothFieldsEmpty = userId.textProperty().isEmpty().and(pwd.textProperty().isEmpty());
        cancelButton.disableProperty().bind(bothFieldsEmpty);

        // Le bouton ok ne sera cliquable que si le mot de passe a au moins 8 caractères,
        // au moins une majuscule et au moins un chiffre
        BooleanBinding passwordCriteriaMet = pwd.textProperty().length().greaterThanOrEqualTo(8)
                .and(Bindings.createBooleanBinding(() ->
                        pwd.getText().matches(".*\\d.*") && pwd.getText().matches(".*[A-Z].*"), pwd.textProperty()));
        okButton.disableProperty().bind(passwordCriteriaMet.not());
    }

    @FXML
    private void okClicked() {
        System.out.print(userId.getText() + " ");
        for (char c : pwd.getText().toCharArray()) {
            System.out.print("*");
        }
        System.out.println();
    }

    @FXML
    private void cancelClicked() {
        userId.setText("");
        pwd.setText("");
    }
}
