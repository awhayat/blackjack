package model;

public class Card {
    public String name;
    public int value;
    
    public String toString() {
        return name;
    }
    
    public Card(String name) {
        this.name = name;

        switch (name) {
            case "Ace" -> this.value = 11;
            case "Two" -> this.value = 2;
            case "Three" -> this.value = 3;
            case "Four" -> this.value = 4;
            case "Five" -> this.value = 5;
            case "Six" -> this.value = 6;
            case "Seven" -> this.value = 7;
            case "Eight" -> this.value = 8;
            case "Nine" -> this.value = 9;
            default -> value = 10;
        }
    }

}
