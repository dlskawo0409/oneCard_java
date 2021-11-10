package test0901;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
	private ArrayList<Card> deck = new ArrayList<Card>(52);
	
	Deck(){
		deckInit();
	}
	
	private void deckInit(){
		
		for(int i = 0; i < 52; i++) {
			Card temCard;
			if(0 < (i + 1) && (i + 1) <= 13) {
				temCard= new Card("하트",i+1);
			}
			else if(13 < (i + 1) && (i + 1) <= 26) {
				temCard = new Card("스페이드",i+1-13);
			}
			else if(26 < (i + 1) && (i + 1) <= 39) {
				temCard = new Card("다이아몬드",i + 1 - 13 * 2);
			}
			else {
				temCard = new Card("클로버",i + 1 - 13 * 3);
			}
			deck.add(temCard);
		}
		
	}
	
	public Card drawOneCard() {
		Random random = new Random();
		int idx = random.nextInt(deck.size() - 1);
		Card returnCard = deck.get(idx);
		deck.remove(idx);
		return returnCard;
		
	}
	
	public int LeftCard() {
		return deck.size();
	}
	
}

