package test.poker;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
		/*private enum Suit {
			CLUB, DIAMOND, SPADE, HEART
		}; */
		
		private String handAsString;

		public PokerHand(String hand, String handType) {
			handAsString = hand;
			this.handType = handType;
		}

		public Boolean isGreaterThan(PokerHand hand2) {
			// This is where you'll implement the poker hand comparison logic
			//System.out.println("=="+handAsString);
			//System.out.println(hand2.handAsString);
			String[] handArr = handAsString.split(",");
			List<Card> handCard = populateSuitAndRandArrs1(handArr);
			String[] handArr2 = hand2.handAsString.split(",");
			List<Card> handCard2 = populateSuitAndRandArrs1(handArr2);

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
				boolean firstHand = checkFourOfaKind(handCard);
				boolean secondHand = checkFourOfaKind(handCard2);
				if(firstHand && !secondHand)
					return true;
			} else if(handType.equalsIgnoreCase("flush")) {
				boolean firstHand =checkFlush(handCard);
				boolean secondHand =checkFlush(handCard2);
				if(firstHand && !secondHand)
					return true;
			} else if(handType.equalsIgnoreCase("full house")) {
				boolean firstHand =checkFullHouse(handCard);
				boolean secondHand =checkFullHouse(handCard2);
				if(firstHand && !secondHand)
					return true;
			} else if(handType.equalsIgnoreCase("straight")) {
				boolean firstHand =checkStraight(handCard);
				boolean secondHand =checkStraight(handCard2);
				if(firstHand && !secondHand)
					return true;
			} else if(handType.equalsIgnoreCase("three of a kind")) {
				boolean firstHand =checkThreeOfaKind(handCard);
				boolean secondHand =checkThreeOfaKind(handCard2);
				if(firstHand && !secondHand)
					return true;
			} else if(handType.equalsIgnoreCase("two pair")) {
				boolean firstHand =checkTwoPair(handCard);
				boolean secondHand =checkTwoPair(handCard2);
				if(firstHand && !secondHand)
					return true;
			} else if(handType.equalsIgnoreCase("one pair")) {
				boolean firstHand =checkOnePair(handCard);
				boolean secondHand =checkOnePair(handCard2);
				if(firstHand && !secondHand)
					return true;
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
			boolean isSequencial = true;
			for(int i = 0; i < handCard.size() - 1; i++) {
				//System.out.println(handCard.get(i).getOrder());
				if((handCard.get(i+1).getOrder() - handCard.get(i).getOrder() == 1) || 
						(handCard.get(i).getOrder() - handCard.get(i+1).getOrder() == 1) ) {
					f = isSequencial && f ;
				} else 
					isSequencial = false;
			}
			//System.out.println(f);
			return isSequencial && f;
		}

		private boolean checkFourOfaKind(List<Card> handCard) {
			// rules for Four of a Kind
			boolean f = false;
			int c2 = 0, c3=0, c4=0, c5=0, c6=0, c7=0, c8=0, c9=0, c10=0, cj=0, cq=0, ck=0, ca=0;
			for(Card c : handCard) {
				String r = c.getRank();
				switch(r) {
				case "2": c2++; break;
				case "3": c3++; break;
				case "4": c4++; break;
				case "5": c5++; break;
				case "6": c6++; break;
				case "7": c7++; break;
				case "8": c8++; break;
				case "9": c9++; break;
				case "10": c10++; break;
				case "J": cj++;  break;
				case "Q": cq++;  break;
				case "K": ck++;  break;
				case "A": ca++;  break;
				}
			}	
			if(c2==4 || c3==4|| c4==4|| c5==4|| c6==4|| c7==4|| c8==4|| c9==4|| c10==4|| cj==4|| cq==4|| ck==4|| ca==4)
				f = true;
			return f;
		}

		private boolean checkFlush(List<Card> handCard) {
			// rules for Flush
			boolean f = false;
			int cl=0, di=0, sp=0, he=0;
			for(Card c : handCard) {				
				String s = c.getSuit();
				//System.out.println(s);
				switch(s) {
				case "C": cl++; break;
				case "D": di++; break;
				case "S": sp++; break;
				case "H": he++; break;
				}
			}
			if(cl==5 || di==5||sp==5||he==5)
			f = true;
			boolean isSorted = !isSortedList(handCard);   // Ranks is sequencial or not
			
			return f&&isSorted;
		}
		
		private boolean checkFullHouse(List<Card> handCard) {
			// rules for Full House
			int c2 = 0, c3=0, c4=0, c5=0, c6=0, c7=0, c8=0, c9=0, c10=0, cj=0, cq=0, ck=0, ca=0;
			for(Card c : handCard) {
				String r = c.getRank();
				switch(r) {
				case "2": c2++; break;
				case "3": c3++; break;
				case "4": c4++; break;
				case "5": c5++; break;
				case "6": c6++; break;
				case "7": c7++; break;
				case "8": c8++; break;
				case "9": c9++; break;
				case "10": c10++; break;
				case "J": cj++;  break;
				case "Q": cq++;  break;
				case "K": ck++;  break;
				case "A": ca++;  break;
				}
			}	
			boolean r1 = false, r2=false;
			if(c2==3 || c3==3|| c4==3|| c5==3|| c6==3|| c7==3|| c8==3|| c9==3|| c10==3|| cj==3|| cq==3|| ck==3|| ca==3)
				r1 = true;
			if(c2==2 || c3==2|| c4==2|| c5==2|| c6==2|| c7==2|| c8==2|| c9==2|| c10==2|| cj==2|| cq==2|| ck==2|| ca==2)
				r2 = true;

			return r1&&r2;
		}
		
		private boolean checkStraight(List<Card> handCard) {
			// rules for Straight
			boolean f = false;
			boolean isSorted = isSortedList(handCard);
			
			int cl=0, di=0, sp=0, he=0;
			for(Card c : handCard) {				
				String s = c.getSuit();
				//System.out.println(s);
				switch(s) {
				case "C": cl++; break;
				case "D": di++; break;
				case "S": sp++; break;
				case "H": he++; break;
				}
			}
			if((cl==2 && (di==1&&sp==1&&he==1)) ||  (di==2 && (cl==1&&sp==1&&he==1)) ||
					 (sp==2 && (cl==1&&di==1&&he==1)) ||  (he==2 && (cl==1&&sp==1&&di==1)))
				f = true;
			//System.out.println("is sequ:"+isSorted +",f:" +f);
			return f&&isSorted;
		}
		
		private boolean checkThreeOfaKind(List<Card> handCard) {
			// rules for Three of a Kind
			int c2 = 0, c3=0, c4=0, c5=0, c6=0, c7=0, c8=0, c9=0, c10=0, cj=0, cq=0, ck=0, ca=0;
			for(Card c : handCard) {
				String r = c.getRank();
				switch(r) {
				case "2": c2++; break;
				case "3": c3++; break;
				case "4": c4++; break;
				case "5": c5++; break;
				case "6": c6++; break;
				case "7": c7++; break;
				case "8": c8++; break;
				case "9": c9++; break;
				case "10": c10++; break;
				case "J": cj++;  break;
				case "Q": cq++;  break;
				case "K": ck++;  break;
				case "A": ca++;  break;
				}
			}	
			boolean r1 = false, r2=false;
			if(c2==3 || c3==3|| c4==3|| c5==3|| c6==3|| c7==3|| c8==3|| c9==3|| c10==3|| cj==3|| cq==3|| ck==3|| ca==3)
				r1 = true;
			if(c2==1 || c3==1|| c4==1|| c5==1|| c6==1|| c7==1|| c8==1|| c9==1|| c10==1|| cj==1|| cq==1|| ck==1|| ca==1)
				r2 = true;
			return r1&&r2;
		}
		
		private boolean checkTwoPair(List<Card> handCard) {
			// rules for Two Pair
			int c2 = 0, c3=0, c4=0, c5=0, c6=0, c7=0, c8=0, c9=0, c10=0, cj=0, cq=0, ck=0, ca=0;
			for(Card c : handCard) {
				String r = c.getRank();
				switch(r) {
				case "2": c2++; break;
				case "3": c3++; break;
				case "4": c4++; break;
				case "5": c5++; break;
				case "6": c6++; break;
				case "7": c7++; break;
				case "8": c8++; break;
				case "9": c9++; break;
				case "10": c10++; break;
				case "J": cj++;  break;
				case "Q": cq++;  break;
				case "K": ck++;  break;
				case "A": ca++;  break;
				}
			}	
			boolean r1 = false;
			if((c2==2 && (c3==2|| c4==2|| c5==2|| c6==2|| c7==2|| c8==2|| c9==2|| c10==2|| cj==2|| cq==2|| ck==2|| ca==2))||
			   (c3==2 && (c2==2|| c4==2|| c5==2|| c6==2|| c7==2|| c8==2|| c9==2|| c10==2|| cj==2|| cq==2|| ck==2|| ca==2))||
			   (c4==2 && (c2==2|| c3==2|| c5==2|| c6==2|| c7==2|| c8==2|| c9==2|| c10==2|| cj==2|| cq==2|| ck==2|| ca==2))||
			   (c5==2 && (c2==2|| c4==2|| c3==2|| c6==2|| c7==2|| c8==2|| c9==2|| c10==2|| cj==2|| cq==2|| ck==2|| ca==2))||
			   (c6==2 && (c2==2|| c4==2|| c5==2|| c3==2|| c7==2|| c8==2|| c9==2|| c10==2|| cj==2|| cq==2|| ck==2|| ca==2))||
			   (c7==2 && (c2==2|| c4==2|| c5==2|| c6==2|| c3==2|| c8==2|| c9==2|| c10==2|| cj==2|| cq==2|| ck==2|| ca==2))||
			   (c8==2 && (c2==2|| c4==2|| c5==2|| c6==2|| c7==2|| c3==2|| c9==2|| c10==2|| cj==2|| cq==2|| ck==2|| ca==2))||
			   (c9==2 && (c2==2|| c4==2|| c5==2|| c6==2|| c7==2|| c8==2|| c3==2|| c10==2|| cj==2|| cq==2|| ck==2|| ca==2))||
			   (c10==2 && (c2==2|| c4==2|| c5==2|| c6==2|| c7==2|| c8==2|| c9==2|| c3==2|| cj==2|| cq==2|| ck==2|| ca==2))||
			   (cj==2 && (c2==2|| c4==2|| c5==2|| c6==2|| c7==2|| c8==2|| c9==2|| c10==2|| c3==2|| cq==2|| ck==2|| ca==2))||
			   (cq==2 && (c2==2|| c4==2|| c5==2|| c6==2|| c7==2|| c8==2|| c9==2|| c10==2|| cj==2|| c3==2|| ck==2|| ca==2))||
			   (ck==2 && (c2==2|| c4==2|| c5==2|| c6==2|| c7==2|| c8==2|| c9==2|| c10==2|| cj==2|| cq==2|| c3==2|| ca==2))||
			   (ca==2 && (c2==2|| c4==2|| c5==2|| c6==2|| c7==2|| c8==2|| c9==2|| c10==2|| cj==2|| cq==2|| ck==2|| c3==2))
			  )
				r1 = true;
			return r1;
		}
		
		private boolean checkOnePair(List<Card> handCard) {
			// rules for One Pair
			int c2 = 0, c3=0, c4=0, c5=0, c6=0, c7=0, c8=0, c9=0, c10=0, cj=0, cq=0, ck=0, ca=0;
			for(Card c : handCard) {
				String r = c.getRank();
				switch(r) {
				case "2": c2++; break;
				case "3": c3++; break;
				case "4": c4++; break;
				case "5": c5++; break;
				case "6": c6++; break;
				case "7": c7++; break;
				case "8": c8++; break;
				case "9": c9++; break;
				case "10": c10++; break;
				case "J": cj++;  break;
				case "Q": cq++;  break;
				case "K": ck++;  break;
				case "A": ca++;  break;
				}
			}	
			boolean r1 = false;
			if((c2==2 && (c3==1|| c4==1|| c5==1|| c6==1|| c7==1|| c8==1|| c9==1|| c10==1|| cj==1|| cq==1|| ck==1|| ca==1))||
			   (c3==2 && (c2==1|| c4==1|| c5==1|| c6==1|| c7==1|| c8==1|| c9==1|| c10==1|| cj==1|| cq==1|| ck==1|| ca==1))||
			   (c4==2 && (c2==1|| c3==1|| c5==1|| c6==1|| c7==1|| c8==1|| c9==1|| c10==1|| cj==1|| cq==1|| ck==1|| ca==1))||
			   (c5==2 && (c2==1|| c4==1|| c3==1|| c6==1|| c7==1|| c8==1|| c9==1|| c10==1|| cj==1|| cq==1|| ck==1|| ca==1))||
			   (c6==2 && (c2==1|| c4==1|| c5==1|| c3==1|| c7==1|| c8==1|| c9==1|| c10==1|| cj==1|| cq==1|| ck==1|| ca==1))||
			   (c7==2 && (c2==1|| c4==1|| c5==1|| c6==1|| c3==1|| c8==1|| c9==1|| c10==1|| cj==1|| cq==1|| ck==1|| ca==1))||
			   (c8==2 && (c2==1|| c4==1|| c5==1|| c6==1|| c7==1|| c3==1|| c9==1|| c10==1|| cj==1|| cq==1|| ck==1|| ca==1))||
			   (c9==2 && (c2==1|| c4==1|| c5==1|| c6==1|| c7==1|| c8==1|| c3==1|| c10==1|| cj==1|| cq==1|| ck==1|| ca==1))||
			   (c10==2 && (c2==1|| c4==1|| c5==1|| c6==1|| c7==1|| c8==1|| c9==1|| c3==1|| cj==1|| cq==1|| ck==1|| ca==1))||
			   (cj==2 && (c2==1|| c4==1|| c5==1|| c6==1|| c7==1|| c8==1|| c9==1|| c10==1|| c3==1|| cq==1|| ck==1|| ca==1))||
			   (cq==2 && (c2==1|| c4==1|| c5==1|| c6==1|| c7==1|| c8==1|| c9==1|| c10==1|| cj==1|| c3==1|| ck==1|| ca==1))||
			   (ck==2 && (c2==1|| c4==1|| c5==1|| c6==1|| c7==1|| c8==1|| c9==1|| c10==1|| cj==1|| cq==1|| c3==1|| ca==1))||
			   (ca==2 && (c2==1|| c4==1|| c5==1|| c6==1|| c7==1|| c8==1|| c9==1|| c10==1|| cj==1|| cq==1|| ck==1|| c3==1))
			  )
				r1 = true;
			return r1;
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
				"expected: " + expectedResult + ", actual: " + hand1.isGreaterThan(hand2) +
				", hand type:" + handType
				);
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
		
		testHand1IsGreaterThanHand2(
				"6C,6D,6H,9C,KD",  
				"5C,3C,10C,KC,7C", // flush
				false, "flush");

		testHand1IsGreaterThanHand2(
				"4H,4D,4C,KC,KD", // full house
				"9D,6S,KH,AS,AD",
				true, "full house");
		
		testHand1IsGreaterThanHand2(
				"6C,6D,6H,9C,KD",     // 
				"2C,3C,4S,5S,6S", // straight
				false, "straight");

		testHand1IsGreaterThanHand2(
				"7C,7D,7S,3H,4D", // three of a kind
				"9S,6S,10D,AS,AD",
				true, "three of a kind");
		//if(true) return;
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


