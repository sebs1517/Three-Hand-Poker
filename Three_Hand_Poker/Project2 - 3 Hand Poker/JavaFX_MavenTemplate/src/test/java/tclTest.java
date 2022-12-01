import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class tclTest {
	
	ArrayList<Card> hand;
	ArrayList<Card> otherHand;
	static int bet = 1;
	
	@BeforeEach
	void setup() {
		hand = new ArrayList<Card>();
		otherHand = new ArrayList<Card>();
	}
	
	@Test
	void singleHighTest() {
		hand.add(new Card('C', 12));
		hand.add(new Card('H', 10));
		hand.add(new Card('S', 6));
		assertEquals(0, ThreeCardLogic.evalHand(hand));
		hand.set(0, new Card('H', 7));
		assertEquals(0, ThreeCardLogic.evalHand(hand));
		assertEquals(0, ThreeCardLogic.evalPPWinnings(hand, bet));
		
	}
	
	@Test
	void pairTest() {
		hand.add(new Card('C', 2));
		hand.add(new Card('D', 10));
		hand.add(new Card('H', 2));
		assertEquals(5, ThreeCardLogic.evalHand(hand));
		hand.set(2, new Card('H', 10));
		assertEquals(5, ThreeCardLogic.evalHand(hand));
		assertEquals(1, ThreeCardLogic.evalPPWinnings(hand, bet));
	}
	
	@Test
	void flushTest() {
		hand.add(new Card('C', 2));
		hand.add(new Card('C', 4));
		hand.add(new Card('C', 10));
		assertEquals(4, ThreeCardLogic.evalHand(hand));
		otherHand.add(new Card('H', 5));
		otherHand.add(new Card('H', 7));
		otherHand.add(new Card('H', 14));
		assertEquals(4, ThreeCardLogic.evalHand(otherHand));
		assertEquals(3, ThreeCardLogic.evalPPWinnings(hand, bet));
		assertEquals(1, ThreeCardLogic.compareHands(otherHand, hand));
	}
	
	@Test
	void threeOfaKindTest() {
		hand.add(new Card('C', 2));
		hand.add(new Card('H', 2));
		hand.add(new Card('D', 2));
		assertEquals(2, ThreeCardLogic.evalHand(hand));
		otherHand.add(new Card('S', 9));
		otherHand.add(new Card('H', 9));
		otherHand.add(new Card('D', 9));
		assertEquals(2, ThreeCardLogic.evalHand(otherHand));
		assertEquals(30, ThreeCardLogic.evalPPWinnings(hand, bet));
		assertEquals(2, ThreeCardLogic.compareHands(hand, otherHand));
	}
	
	@Test
	void straightTest() {
		hand.add(new Card('C', 12));
		hand.add(new Card('H', 11));
		hand.add(new Card('D', 13));
		assertEquals(3, ThreeCardLogic.evalHand(hand));
		hand.clear();
		hand.add(new Card('H', 2));
		hand.add(new Card('C', 3));
		hand.add(new Card('D', 4));
		assertEquals(3, ThreeCardLogic.evalHand(hand));
		assertEquals(6, ThreeCardLogic.evalPPWinnings(hand, bet));
		assertEquals(0, ThreeCardLogic.compareHands(hand, hand));
	}
	
	@Test
	void straightFlushTest() {
		int bet = 1;
		hand.add(new Card('C', 12));
		hand.add(new Card('C', 11));
		hand.add(new Card('C', 13));
		assertEquals(1, ThreeCardLogic.evalHand(hand));
		hand.clear();
		hand.add(new Card('H', 4));
		hand.add(new Card('H', 2));
		hand.add(new Card('H', 3));
		assertEquals(1, ThreeCardLogic.evalHand(hand));
		assertEquals(40, ThreeCardLogic.evalPPWinnings(hand, bet));
	}
	
}