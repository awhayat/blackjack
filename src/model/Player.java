package model;

import static ui.Main.input;

public class Player extends BlackJack {
    
    public Player(String name, int balance) {
        super();
        this.name = name;
        this.balance = balance;
    }
    
    public void move(BlackJack player, boolean cheat) {
        int move;
        do {
            System.out.println("\nType 1 to hit or 2 to stand.");
            move = input.nextInt();
            if ((move != 1) && (move != 2)) System.out.println("Invalid move.");
        } while ((move != 1) && (move != 2));
            
        if (move == 1) this.hit(false);
        else this.stand();
    }
    
    public void stand() {
        super.stand();
        BlackJack.playerStand = true;
    }

}
