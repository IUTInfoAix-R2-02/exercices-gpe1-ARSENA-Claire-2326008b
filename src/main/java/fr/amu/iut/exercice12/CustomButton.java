package fr.amu.iut.exercice12;

import javafx.scene.control.Button;

class CustomButton extends Button {
    private int counter = 0;
    private String color;

    public CustomButton(String text, String color) {
        super(text);
        this.color = color;
    }

    public void incrementCounter() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }

    public String getColor() {
        return color;
    }
}
