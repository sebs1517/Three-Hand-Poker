import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Comparator;

class compByValue implements Comparator<Card> {
	public int compare(Card a, Card b) {
		return a.value - b.value;
	}
}

public class Dealer {
    Deck theDeck;
    ArrayList<Card> dealersHand;

    Dealer() {
        this.theDeck = new Deck();
        this.dealersHand = new ArrayList<Card>();
    }

    public ArrayList<Card> dealHand() {
        ArrayList<Card> temp = new ArrayList<Card>();

        // If cards are less than 34, grab a fresh new deck
        if(theDeck.size() <= 34) {
            theDeck.newDeck();
        }
        // Adds the three cards for the dealers hand by removing from the top of the deck
        for(int i = 0; i < 3; i++) {
            temp.add(theDeck.remove(0));
        }
        Collections.sort(temp, new compByValue());
        return temp;
    }
}