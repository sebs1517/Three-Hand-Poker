import java.util.ArrayList;
import java.util.Collections;

public class ThreeCardLogic {
	// evalHand will check for a flush/three of a kind first
	// then for a straight, then straight flush, finally a pair. if none found, it is just a high
	
	public static int evalHand(ArrayList<Card> hand){
    	Collections.sort(hand, new compByValue());
		boolean flush = true;
    	boolean tok = true;
    	boolean straight = true;
    	boolean pair = false;
    	for (int i = 0; i < 2; i++) {
    		// Checks for a flush, also finds a pair as well
    		if (hand.get(i).suit == hand.get(i+1).suit) {
    			flush = flush && true;
    		} else {
    			flush = false;
    		}
    		
    		// Checks for three of a kind
    		if (hand.get(i).value == hand.get(i+1).value) {
    			tok = tok && true;
    			pair = true;
    		} else {
    			tok = false; 
    		}
    		
    		// Checks for a straight
    		if (hand.get(i).value == hand.get(i+1).value - 1) {
    			straight = straight && true;
    		} else {
    			straight = false;
    		}
    	}
    	
    	// Checking in order of best to worst hand
    	if (straight && flush) {
    		return 1;
    	} else if (tok) {
    		return 2;
    	} else if (straight) {
    		return 3;
    	} else if (flush) {
    		return 4;
    	} else if (pair) {
    		return 5;
    	} else return 0;
    
    }
    public static int evalPPWinnings(ArrayList<Card> hand, int bet){
    	int eval = evalHand(hand);
    	if (eval == 1) {
    		return bet * 40;
    	} else if (eval == 2) {
    		return bet * 30;
    	} else if (eval == 3) {
    		return bet * 6;
    	} else if (eval == 4) {
    		return bet * 3;
    	} else if (eval == 5) {
    		return bet;
    	} else return 0;
    }
    
    // Returns a 2 if Player wins, 1 if Dealer wins, 0 if neither win.
    public static int compareHands(ArrayList<Card> dealer, ArrayList<Card> player){
        int dealerEval = evalHand(dealer);
        int playerEval = evalHand(player);
        // Makes it easier so lower number means better hand
        if (dealerEval == 0) dealerEval = 6;
        if (playerEval == 0) playerEval = 6;
        
        if (playerEval < dealerEval) {
        	return 2;
        } else if (playerEval > dealerEval) {
        	return 1;
        }
        
        // Both hands hold a pair
        if (dealerEval == 5) {
        	// The value of the cards that make a pair
        	int dealerPair = dealer.get(1).value;
        	int playerPair = player.get(1).value;
        	// Holds the value of the card that doesn't form a pair
        	int dealerOther, playerOther;
        	if (dealerPair > playerPair) {
        		return 1;
        	} else if (dealerPair < playerPair) {
        		return 2;
        	} else {
        		if (dealer.get(0).value != dealerPair) {
        			dealerOther = dealer.get(0).value;
        		} else {
        			dealerOther = dealer.get(2).value;
        		}
        		if (player.get(0).value != playerPair) {
        			playerOther = player.get(0).value;
        		} else {
        			playerOther = player.get(2).value;
        		}
        		if (dealerOther > playerOther) {
        			return 1;
        		} else if (dealerOther < playerOther) {
        			return 2;
        		} else {
        			return 0;
        		}
        	}
        }
        
        // Both hands hold a flush or simple high
        if (dealerEval == 4 || dealerEval == 6) {
        	for (int i = 2; i >= 0; i--) {
        		if (dealer.get(i).value > player.get(i).value) {
        			return 1;
        		} else if (dealer.get(i).value < player.get(i).value) {
        			return 2;
        		} else if (i == 0) {
        			return 0;
        		}
        	}
        }
        
        // Both hands hold a straight or straight flush
        if (dealerEval == 3 || dealerEval == 1) {
        	int dVal = dealer.get(2).value;
        	int pVal = player.get(2).value;
        	if (dVal > pVal) {
        		return 1;
        	} else if (dVal < pVal) {
        		return 2;
        	} else return 0;
        }
        
        // Both hands hold a three of a kind
        if (dealerEval == 2) {
        	if (dealer.get(0).value > player.get(0).value) {
        		return 1;
        	} else return 2;
        }

        return 0;
    }
}