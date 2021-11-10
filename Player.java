package test0901;

import java.util.ArrayList;

class Player{
	public static int playerCount=0;
	private int playerNum;
	private ArrayList<Card> playerDeck = new ArrayList<Card>(10);
	
	Player(){
		playerCount++;
		this.playerNum=playerCount;
	}
	
	public void addPlayerDeck(Card newCard) {
		playerDeck.add(newCard);
	}
	
	
	public void printPlayerDeck() {
		System.out.printf("플레이어%d 카드 패 : \n",playerNum);
		for(int i = 0; i < playerDeck.size(); i++)
		{
			System.out.print("모양 : " +  playerDeck.get(i).getShape()
					+ ", 숫자 : " + playerDeck.get(i).getCardNum() + "\n");
		}
		System.out.print("낼 카드를 선택해주세요(낼 카드가 없으면 skip 0을 입력해주세요, skip 0 입력 시 뽑을 카드가 남아있는 경우 카드를 한장 가져옵니다.) : ");
		System.out.println();
	}
	
	public Card putCard(String cardShape, int cardNum) throws Exception{
		Card returnCard;
		int i;
		for(i=0;i<playerDeck.size();i++) {
			if(playerDeck.get(i).getShape().equals(cardShape)&&playerDeck.get(i).getCardNum()==cardNum)
				break;
		}
		returnCard=playerDeck.get(i);
		playerDeck.remove(i);
		return returnCard;
	};
	
	public int getPlayerDeckSize() {
		return playerDeck.size();
	}
		
}
