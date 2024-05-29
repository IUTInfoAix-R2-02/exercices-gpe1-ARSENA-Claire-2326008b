package fr.amu.iut.exercice13;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Personne {

    private final String nom;
    private final IntegerProperty age;

    public Personne(String nom, int age) {
        this.nom = nom;
        this.age = new SimpleIntegerProperty(age);
    }

    public String getNom() {
        return nom;
    }

    public int getAge() {
        return age.get();
    }

    public void setAge(int age) {
        this.age.set(age);
    }

    public IntegerProperty ageProperty() {
        return age;
    }
}
