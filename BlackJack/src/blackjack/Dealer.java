package blackjack;

public class Dealer extends BlackJack {
    
    public Dealer() {
        super();
        this.name = "Dealer";
        this.balance = 0;
    }
    
    public void move(BlackJack player, boolean cheat) {
        if (cheat) this.hit(false);
        else {
            int playerScore = player.score(true);
            int dealerScore = this.score(false);

            if (dealerScore < 12) {
                this.hit(false);
            } else if (dealerScore > 16) {
                this.stand();
            } else {
                if (playerScore > 6) {
                    this.hit(false);
                } else {
                    this.stand();
                }
            }
        }
        
    }
    
    public void stand() {
        super.stand();
        BlackJack.dealerStand = true;
    }

}