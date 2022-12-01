import java.util.ArrayList;

public class Player {
    ArrayList<Card> hand;
    int anteBet;
    int playBet;
    int pairPlusBet;
    int totalWinnings;

    Player() {
        this.hand = new ArrayList<Card>();
        this.anteBet = 5;
        this.playBet = 0;
        this.pairPlusBet = 5;
        this.totalWinnings = 0;
    }
}