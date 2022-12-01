import java.util.ArrayList;
import java.util.Collections;

public class Deck extends ArrayList<Card> {
	private char[] suit = {'C', 'H', 'D', 'S'};
	Deck() {
		for (int i = 0; i < 4; i++) {
			for (int j = 2; j < 15; j++) {
				this.add(new Card(suit[i], j));
		    }
	 	}
		Collections.shuffle(this);
	}
	
	void newDeck() {
		this.clear();
		for (int i = 0; i < 4; i++) {
			for (int j = 2; j < 15; j++) {
				this.add(new Card(suit[i], j));
			}
		}
		Collections.shuffle(this);
	}
}
