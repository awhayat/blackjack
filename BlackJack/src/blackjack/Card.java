package blackjack;

public class Card {
    
    public String name;
    public int value;
    
    public String toString() {
        return this.name;
    }
    
    public Card(String name) {
        this.name = name;
        
        switch (name) {
            case "Ace":
                this.value = 11;
                break;
            case "Two":
                this.value = 2;
                break;
            case "Three":
                this.value = 3;
                break;
            case "Four":
                this.value = 4;
                break;
            case "Five":
                this.value = 5;
                break;
            case "Six":
                this.value = 6;
                break;
            case "Seven":
                this.value = 7;
                break;
            case "Eight":
                this.value = 8;
                break;
            case "Nine":
                this.value = 9;
                break;
            case "Ten":
                this.value = 10;
                break;
            case "Jack":
                this.value = 10;
                break;
            case "Queen":
                this.value = 10;
                break;
            case "King":
                this.value = 10;
                break;
            default:
                break;
        }
    }

}