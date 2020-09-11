package test.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.sun.java.swing.plaf.windows.WindowsTreeUI.CollapsedIcon;

import test.poker.Poker.Card;

public class Poker
{

	/*
	 * Given a set of 5 playing card identifiers such as 2H, 7C, QS, 10D, 2D;
	 * determine if this hand is better than some other hand, according to the rules of poker.
	 *
	 * Hands will be a string with 5 cards comma separated,
	 * each card will have 1-2 digits or JQKA and a suit indicator C,D,S,H (i.e. 10C, KH)
	 *
	 * Possible Hand Types Below:
	 *   Straight flush
	 *   Four of a kind
	 *   Full house
	 *   Flush
	 *   Straight
	 *   Three of a kind
	 *   Two pair
	 *   One pair
	 *
	 * The goal of this is to compare between the hand types.
	 * Comparing 2 of the same type (i.e. 2 straights) to determine a winner is outside the scope
	 * and will not be tested.
	 *
	 * Implement PokerHand.isGreaterThan(...) method and return whether or not the first hand wins over the second hand.
	 */

	final String[] RANKS_ARR = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
	final String[] SUIT_ARR =  {"C", "D", "S", "H"}; // CLUB, DIAMOND, SPADE, HEART
	//private static List<Card> myRank = new ArrayList<>(15);
	private static Map<String, Card> myRank = new LinkedHashMap<>(15);
	
	static {
		myRank.put("2",new Card("2",   2));
		myRank.put("3",new Card("3",   3));
		myRank.put("4",new Card("4",   4));
		myRank.put("5",new Card("5",   5));
		myRank.put("6",new Card("6",   6));
		myRank.put("7",new Card("7",   7));
		myRank.put("8",new Card("8",   8));
		myRank.put("9",new Card("9",   9));
		myRank.put("10",new Card("10", 10));
		myRank.put("J",new Card("J",  11));
		myRank.put("Q",new Card("Q",  12));
		myRank.put("K",new Card("K",  13));
		myRank.put("A",new Card("A",  14));
	}

	static class PokerHand {
		
		private String handType;
		private enum Suit {
			CLUB, DIAMOND, SPADE, HEART
		}; 
		
		private String handAsString;

		public PokerHand(String hand, String handType) {
			handAsString = hand;
			this.handType = handType;
		}

		public Boolean isGreaterThan(PokerHand hand2) {
			// This is where you'll implement the poker hand comparison logic
			System.out.println(handAsString);
			System.out.println(hand2.handAsString);
			String[] handArr = handAsString.split(",");
			List<Card> handCard = populateSuitAndRandArrs1(handArr);
			String[] handArr2 = hand2.handAsString.split(",");
			List<Card> handCard2 = populateSuitAndRandArrs1(handArr2);
			//if(true) return true;		

			boolean flag = isGreaterThan(handCard, handCard2);
			
			return flag;
		}
		
		private boolean isGreaterThan(List<Card> handCard, List<Card> handCard2) {
			if(handType.equalsIgnoreCase("straight flush")) {
				boolean firstHand = checkStraightFlush(handCard);
				boolean secondHand = checkStraightFlush(handCard2);
				if(firstHand && !secondHand)
					return true;
			} else if(handType.equalsIgnoreCase("four of a kind")) {
				checkFourOfaKind(handCard);
				checkFourOfaKind(handCard2);
			} else if(handType.equalsIgnoreCase("flush")) {
				checkFlush(handCard);
				checkFlush(handCard2);
			} else if(handType.equalsIgnoreCase("full house")) {
				checkFullHouse(handCard);
				checkFullHouse(handCard2);
			} else if(handType.equalsIgnoreCase("straight")) {
				checkStraight(handCard);
				checkStraight(handCard2);
			} else if(handType.equalsIgnoreCase("three of a kind")) {
				checkThreeOfaKind(handCard);
				checkThreeOfaKind(handCard2);
			} else if(handType.equalsIgnoreCase("two pair")) {
				checkTwoPair(handCard);
				checkTwoPair(handCard2);
			} else if(handType.equalsIgnoreCase("one pair")) {
				checkOnePair(handCard);
				checkOnePair(handCard2);
			}
			
			return false;
		}
		
		private boolean checkStraightFlush(List<Card> handCard) {
			// rules for Straight Flush
			boolean isSorted = isSortedList(handCard);
			String s = "", previous="";
			boolean isSameSuite = true;
			for(Card c : handCard) {
				s = c.getSuit();
				if(!"".equals(previous) ) {
					if(s.equals(previous))
						isSameSuite = true && isSameSuite; 
					else 
						isSameSuite = false;
				}				
				previous = s;
			}			
			return isSorted && isSameSuite;
		}
		
		private boolean isSortedList(List<Card> handCard) {
			boolean f = true;
			for(int i = 0; i < handCard.size() - 1; i++) {
				//System.out.println(handCard.get(i).getOrder());
				if(handCard.get(i).getOrder() > handCard.get(i+1).getOrder()) {
					f = false;
					break;				
				}
			}
			if(f==false) {
				f = true;
				for(int i = 0; i < handCard.size() - 1; i++) {
					//System.out.println(handCard.get(i).getOrder());
					if(handCard.get(i).getOrder() < handCard.get(i+1).getOrder()) {
						f = false;
						break;				}
				}
			}
			//System.out.println(f);
			return f;
		}

		private void checkFourOfaKind(List<Card> handCard) {
			// rules for Four of a Kind
		}

		private void checkFlush(List<Card> handCard) {
			// rules for Flush
		}
		
		private void checkFullHouse(List<Card> handCard) {
			// rules for Full House
		}
		
		private void checkStraight(List<Card> handCard) {
			// rules for Straight 
		}
		
		private void checkThreeOfaKind(List<Card> handCard) {
			// rules for Three of a Kind
		}
		
		private void checkTwoPair(List<Card> handCard) {
			// rules for Two Pair
		}
		
		private void checkOnePair(List<Card> handCard) {
			// rules for One Pair
		}

		public static List<Card> populateSuitAndRandArrs1(String[] handArr) {
			List<Card> handCard = new ArrayList<>();
			
			for (int i = 0 ; i < handArr.length; i++) {
				String card = handArr[i].trim();
				String s = getSuit(card);
				String r = getRank(card);
				Card c = new Card(myRank.get(r));
				c.setSuit(s);
				handCard.add(c);
			}    		 
			//Comparator<Card> c = (o1, o2) -> o2.getOrder() - o1.getOrder();
			//Collections.sort(handCard, c);
			return handCard;
		}
		
		public static String getRank(String str) {
			String result = Optional.ofNullable(str)
					.filter(sStr -> sStr.length() != 0)
					.map(sStr -> sStr.substring(0, sStr.length() - 1))
					.orElse(str);
			return result;
		}

		public static String getSuit(String str) {
			String result = Optional.ofNullable(str)
					.filter(sStr -> sStr.length() != 0)
					.map(sStr -> sStr.substring(sStr.length() - 1))
					.orElse(str);
			return result;
		}

		@Override
		public String toString() {
			return handAsString;
		}
	}
	
	final static class Card  {
		private String rank;
		private Integer order;
		private String suit;
		
		public Card(Card c) {
			this.rank = c.getRank();
			this.order = c.getOrder();
			this.suit = c.getSuit();
		}
		
		public Card(String rank, Integer order) {
			this.rank = rank;
			this.order = order;
		}
		
		public String getRank() {
			return rank;
		}
		public Integer getOrder() {
			return order;
		}

		public String getSuit() {
			return suit;
		}

		public void setSuit(String suit) {
			this.suit = suit;
		}
		
		@Override
		public String toString() {
			return "["+this.rank+this.suit+"]";
		}
	}

	public static void testHand1IsGreaterThanHand2(String hand1AsString,
			String hand2AsString,
			Boolean expectedResult, String handType) {
		PokerHand hand1 = new PokerHand(hand1AsString, handType);
		PokerHand hand2 = new PokerHand(hand2AsString, handType);
		System.out.println("Hand1[" + hand1 + "] > Hand2[" + hand2 + "] \t-- " +
				"expected: " + expectedResult + ", actual: " + hand1.isGreaterThan(hand2));
	}

	public static void main(String[] args) {
		testHand1IsGreaterThanHand2(
				"8C,9C,10C,JC,QC", // straight flush	
				"6S,7H,8D,9H,10D",				
				true, "straight flush");

		testHand1IsGreaterThanHand2(
				"4H,4D,4C,4S,JS", //four of a kind
				"6C,6S,KH,AS,AD",
				true, "four of a kind");
		if(true) return;
		
		testHand1IsGreaterThanHand2(
				"6C,6D,6H,9C,KD",
				"5C,3C,10C,KC,7C", // flush
				false, "flush");

		testHand1IsGreaterThanHand2(
				"4H,4D,4C,KC,KD", // full house
				"9D,6S,KH,AS,AD",
				true, "full house");

		testHand1IsGreaterThanHand2(
				"6C,6D,6H,9C,KD",
				"2C,3C,4S,5S,6S", // straight
				false, "straight");

		testHand1IsGreaterThanHand2(
				"7C,7D,7S,3H,4D", // three of a kind
				"9S,6S,10D,AS,AD",
				true, "three of a kind");

		testHand1IsGreaterThanHand2(
				"2S,2D,JH,7S,AC",
				"8C,8H,10S,KH,KS", // two pair
				false, "two pair");

		testHand1IsGreaterThanHand2(
				"AC,AH,3C,QH,10C", // one pair
				"3S,2D,KH,JS,AD",
				true, "one pair");
	}
}


