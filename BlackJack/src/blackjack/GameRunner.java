package blackjack;
import java.util.*;

public class GameRunner {
    
    static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("Welcome to the casino!");
        System.out.println("The objective of Blackjack is to beat the dealer.\n"
                + "The player whose hand's score is closest to 21 wins.\n"
                + "But watch out, because if you go over 21 you bust.\n"
                + "In the event of a tie, the dealer wins.\n"
                + "Cards from 2-10 have a value equal to their number.\n"
                + "All face cards have a value of 10.\n"
                + "Aces have a value of 11 or 1, depending on which one maximizes your score without going over 21 (The game will automatically do this).\n"
                + "Good Luck!\n");
        
        
        BlackJack.deck = new ArrayList();
        BlackJack.refreshDeck();
        
        BlackJack dealer = new Dealer();

        System.out.println("Enter your name: ");
        String name = input.nextLine();
        System.out.println("Enter your starting balance (must be a whole number value): ");
        int balance = input.nextInt();
        int startBalance = balance;
        BlackJack player = new Player(name, balance);
        
        boolean cheat = false;
        if ((player.name.equals("Roonil Wazlib")) || (player.name.equals("Roonil"))) cheat = true;
        
        
        boolean newHand;
        boolean win;
        int bet;
        
        do {
            newHand = true;
            if (BlackJack.deck.size() < 8) BlackJack.refreshDeck();
            player.hit(true);
            player.hit(true);
            dealer.hit(true);
            dealer.hit(true);
            
            do {
                System.out.println("Enter your bet: ");
                bet = input.nextInt();
                if ((bet < 1) || (bet > (1.5 * player.balance))) System.out.println("Invalid bet.");
            } while ((bet < 1) || (bet > (1.5 * player.balance)));
            
            
            do {
                BlackJack.playerStand = false;
                BlackJack.dealerStand = false;

                System.out.println("\n" + player.name + "'s hand: " + player.hand);
                System.out.println("\nDealer's hand: Hidden card plus " + dealer.hand.subList(1, dealer.hand.size()));

                player.move(player, cheat);
                dealer.move(player, cheat);
            } while ((player.score(false) < 22) && (dealer.score(false) < 22) && (!(BlackJack.playerStand && BlackJack.dealerStand)));

            int playerScore = player.score(false);
            int dealerScore = dealer.score(false);

            System.out.println("\n" + player.name + "'s hand: " + player.hand);
            System.out.println("\nDealer's hand: " + dealer.hand + "\n");
            if (playerScore > 21) {
                System.out.println("You busted with a score of " + playerScore + ".");
                win = false;
            } else if (dealerScore > 21) {
                System.out.println("The dealer busted with a score of " + dealerScore + ". " + "You win!");
                win = true;
            } else if (player.beats(dealer)) {
                System.out.println("You win with a score of " + playerScore + " to " + dealerScore + "!");
                win = true;
            } else if (playerScore == dealerScore) {
                System.out.println("You and the dealer each have a score of " + playerScore + ". " + "The dealer wins.");
                win = false;
            } else {
                System.out.println("The dealer wins with a score of " + dealerScore + " to " + playerScore + ".");
                win = false;
            }
            
            
            if (win) player.balance += bet;
            else player.balance -= bet;
            System.out.println("Your balance is now $" + player.balance + ".");
            
            if (player.balance <= 0) break;
            else {
                System.out.println("Enter 1 to play another hand, or 2 to leave the casino: ");
                int n = input.nextInt();
                if (n != 1) newHand = false;
            }
    
            
            player.hand.clear();
            dealer.hand.clear();
        } while ((balance > 0) && (newHand));
        
        
        if (player.balance < 0) System.out.println("\nYou entered the casino with $" + startBalance + " and left $" + (-1 * player.balance) + " in debt.");
        else System.out.println("\nYou entered the casino with $" + startBalance + " and left with $" + player.balance + ".");
    }

}