import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class dealTest {
    Deck deck;
    Dealer dealer;

    @BeforeEach
    void start() {
        deck = new Deck();
        dealer = new Dealer();
    }

    @Test
    void testDeckIntilization() {
        assertEquals("Deck", dealer.theDeck.getClass().getName(), "Deck class not initialized correctly");
    }
	
    @Test
    void testdealerHand() {
        assertEquals(0, dealer.dealersHand.size(), "Dealer should have nothing on hand");
    }

     @Test
    void testdealerHand1() {
        dealer.dealersHand.add(new Card('S', 8));
        assertEquals(1, dealer.dealersHand.size(), "Dealer hand size should be 1");
    }

    @Test
    void testdealerHand2() {
        dealer.dealersHand.add(new Card('S', 8));
        dealer.dealersHand.add(new Card('H', 12));

        assertEquals(2, dealer.dealersHand.size(), "Dealer hand size should be 2");
    }

    @Test
    void testdealerHand3() {
        dealer.dealersHand.add(new Card('S', 8));
        dealer.dealersHand.add(new Card('H', 12));
        dealer.dealersHand.add(new Card('C', 6));

        assertEquals(3, dealer.dealersHand.size(), "Dealer hand size should be 3");
    }

    @Test
    void testdealerHand4() {
        dealer.dealersHand.add(new Card('S', 8));
        dealer.dealersHand.add(new Card('H', 12));
        dealer.dealersHand.add(new Card('C', 6));
        dealer.dealersHand.clear();

        assertEquals(0, dealer.dealersHand.size(), "Dealer hand size should be 0");
    }


    @Test
    void testNewDeck() {
        deck.newDeck();
        assertEquals("Deck", deck.getClass().getName(), "Deck class not initialized correctly");
    }


}