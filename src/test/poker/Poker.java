package test.poker;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

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
	private List<Card> myRank = new ArrayList<>(15);
	
	{
		myRank.add(new Card("2",   2));
		myRank.add(new Card("3",   3));
		myRank.add(new Card("4",   4));
		myRank.add(new Card("5",   5));
		myRank.add(new Card("6",   6));
		myRank.add(new Card("7",   7));
		myRank.add(new Card("8",   8));
		myRank.add(new Card("9",   9));
		myRank.add(new Card("10", 10));
		myRank.add(new Card("J",  11));
		myRank.add(new Card("Q",  12));
		myRank.add(new Card("K",  13));
		myRank.add(new Card("A",  14));
	}

	static class PokerHand {

		private String handAsString;

		public PokerHand(String hand) {
			handAsString = hand;
		}

		public Boolean isGreaterThan(PokerHand hand2) {
			// This is where you'll implement the poker hand comparison logic
			System.out.println(handAsString);
			System.out.println(hand2.handAsString);
			String[] handArr = handAsString.split(",");
			orderBy(handArr);
			String[] suitArr = new String[5];
			String[] rankArr = new String[5];

			String[] handArr2 = hand2.handAsString.split(",");
			orderBy(handArr2);
			String[] suitArr2 = new String[5];
			String[] rankArr2 = new String[5];

			populateSuitAndRandArrs(handArr, suitArr, rankArr);
			populateSuitAndRandArrs(handArr2, suitArr2, rankArr2);
			/*orderBy(rankArr);
			orderBy(suitArr);
			orderBy(rankArr2);
			orderBy(suitArr2);*/
			boolean flag = isGreaterThan(rankArr, suitArr);
			/*handAsString.length();
    	 String suit = handAsString.substring(1, handAsString.length()); */
			System.out.println(rankArr);
			System.out.println(suitArr);
			System.out.println(rankArr2);
			System.out.println(suitArr2);
			return false;
		}

		private void orderBy(String[] handArray) {
		   for(int i = 0; i < handArray.length - 1; i++) {
			   boolean flg = false;
			   for(int j = 0 ; j < handArray.length - 1 - i; j++ ) {
				   String tmp = handArray[j];
				   String tmp1 = handArray[j+1];
				   String s = getRank(tmp1);
				   String r = getRank(tmp);
				   if(r.compareTo(s) > -1) {
					   handArray[j] = handArray[j+1];
					   handArray[j+1] = tmp;
					   flg = true;
				   }
				   
			   } 
			   if(flg==false) 
				   break;			   
		   }
		}

		private boolean isGreaterThan(String[] rankArr, String[] suitArr) {
			
			return false;
		}

		public static void populateSuitAndRandArrs(String[] handArr, String[] suitArr, String[] rankArr) {
			for (int i = 0 ; i < handArr.length; i++) {
				String card = handArr[i];
				String s = getSuit(card);
				String r = getRank(card);
				suitArr[i] = s;
				rankArr[i] = r;

				System.out.print(rankArr[i]);
				System.out.println(suitArr[i]);
			}    		 
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
	
	final static class Card implements Comparator<Card> {
		private String rank;
		private Integer order;
		private Card(String rank, Integer order) {
			this.rank = rank;
			this.order = order;
		}
		
		@Override
		public int compare(Card o1, Card o2) {
			return o1.getOrder() - o2.getOrder();
		}
		public String getRank() {
			return rank;
		}
		public Integer getOrder() {
			return order;
		}
	}

	public static void testHand1IsGreaterThanHand2(String hand1AsString,
			String hand2AsString,
			Boolean expectedResult) {
		PokerHand hand1 = new PokerHand(hand1AsString);
		PokerHand hand2 = new PokerHand(hand2AsString);
		System.out.println("Hand1[" + hand1 + "] > Hand2[" + hand2 + "] \t-- " +
				"expected: " + expectedResult + ", actual: " + hand1.isGreaterThan(hand2));
	}

	public static void main(String[] args) {
		testHand1IsGreaterThanHand2(
				//"8C,9C,10C,JC,QC", // straight flush
				"10C,8C,JC,9C,QC", // straight flush
				//"6S,7H,8D,9H,10D",
				"8D,10D,6S,7H,9H",
				true);

		if(true) return;

		testHand1IsGreaterThanHand2(
				"4H,4D,4C,4S,JS", //four of a kind
				"6C,6S,KH,AS,AD",
				true);

		testHand1IsGreaterThanHand2(
				"6C,6D,6H,9C,KD",
				"5C,3C,10C,KC,7C", // flush
				false);

		testHand1IsGreaterThanHand2(
				"4H,4D,4C,KC,KD", // full house
				"9D,6S,KH,AS,AD",
				true);

		testHand1IsGreaterThanHand2(
				"6C,6D,6H,9C,KD",
				"2C,3C,4S,5S,6S", // straight
				false);

		testHand1IsGreaterThanHand2(
				"7C,7D,7S,3H,4D", // three of a kind
				"9S,6S,10D,AS,AD",
				true);

		testHand1IsGreaterThanHand2(
				"2S,2D,JH,7S,AC",
				"8C,8H,10S,KH,KS", // two pair
				false);

		testHand1IsGreaterThanHand2(
				"AC,AH,3C,QH,10C", // one pair
				"3S,2D,KH,JS,AD",
				true);
	}
}


