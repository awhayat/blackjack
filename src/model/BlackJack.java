package model;

import java.util.ArrayList;

public abstract class BlackJack {
    
    public static ArrayList<Card> deck;
    
    public static void refreshDeck() {
        BlackJack.deck.clear();
        
        String[] names = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                BlackJack.deck.add(new Card(names[i]));
            }
        }
    }
    
    public static boolean playerStand;
    public static boolean dealerStand;
    
    public String name;
    public ArrayList<Card> hand;
    public int balance;
    
    public String toString() {
        return name;
    }
    
    public BlackJack() {
        hand = new ArrayList<>();
    }
    
    public abstract void move(BlackJack player, boolean cheat);
    
    public final void hit(boolean initial) {
        int i = (int) (Math.random() * BlackJack.deck.size());
        this.hand.add(deck.get(i));
        BlackJack.deck.remove(i);
        
        if (!initial) {
            System.out.println(this.name + " " + "hits.");
        }
    }
    
    public void stand() {
        System.out.println(this.name + " " + "stands.");
    }
    
    public int score(boolean hidden) {
        int points = 0;
        int aces = 0;
    
        if (hidden) {
            for (Card card : this.hand.subList(1, this.hand.size())) {
                if (!card.name.equals("Ace")) {
                    points += card.value;
                } else {
                    aces++;
                }
            }
        } else {
            for (Card card : this.hand) {
                if (!card.name.equals("Ace")) {
                    points += card.value;
                } else {
                    aces++;
                }
            }
        }
        
        for (int i = 0; i < aces; i++) {
            if (points < 11) {
                points += 11;
            } else {
                points += 1;
            }
        }
        
        return points;
    }
    
    public boolean beats(BlackJack other) {
        int score1 = this.score(false);
        int score2 = other.score(false);
        
        if (score1 > 21) {
            return false;
        } else if (score2 > 21) {
            return true;
        } else {
            return score1 > score2;
        }
    }

}
