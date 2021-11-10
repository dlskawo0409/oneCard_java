package test0901;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class onecard {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		Player player1 = new Player();
		Player player2 = new Player();
		
		Deck deck =new Deck();
		Field field = new Field();
		field.changeFieldCard(deck.drawOneCard());

		for(int i=0;i<10;i++) {
			player1.addPlayerDeck(deck.drawOneCard());
		}
		
		for(int i=0;i<10;i++) {
			player2.addPlayerDeck(deck.drawOneCard());
		}
		
	
		String cardShape1, cardShape2;
		int cardNumber1, cardNumber2;
		
		while(true) 
		{	while(true) {
			field.printFieldCard();
			player1.printPlayerDeck();
			
			cardShape1 = sc.next();
			cardNumber1 = sc.nextInt();
			
			
			if(cardShape1.equals("skip") || cardNumber1 == 0) 
			{
				if(deck.LeftCard()!=0)
				{
					player1.addPlayerDeck(deck.drawOneCard());;
				}
				else
				{
					System.out.println("덱의 카드가 모두 소진되어 카드를 가져올 수 없습니다.");
				}
				break;
			}else {
				try {
					if(cardShape1.equals(field.getFieldCardShape())||cardNumber1==field.getFieldCardNum()) {
						field.changeFieldCard(player1.putCard(cardShape1, cardNumber1));
						break;
					}
					else
						System.out.println("낼 수 없는 패입니다.");
					
				}catch(Exception e) {
					System.out.println("패에 존재하지 않는 카드 입니다.");
				}
			}
		}
		while(true) {
			field.printFieldCard();
			player2.printPlayerDeck();
			
			cardShape2 = sc.next();
			cardNumber2 = sc.nextInt();
			
			
			
			if(cardShape2.equals("skip") || cardNumber2 == 0) 
			{
				if(deck.LeftCard()!=0)
				{
					player1.addPlayerDeck(deck.drawOneCard());;
				}
				else
				{
					System.out.println("덱의 카드가 모두 소진되어 카드를 가져올 수 없습니다.");
				}
				break;
			}else {
				try {
					if(cardShape2.equals(field.getFieldCardShape())||cardNumber2==field.getFieldCardNum()) {
						field.changeFieldCard(player2.putCard(cardShape2, cardNumber2));
						break;
					}
					else
						System.out.println("낼 수 없는 패입니다.");
					
				}catch(Exception e) {
					System.out.println("패에 존재하지 않는 카드 입니다.");
				}
			}
		}
			
	if(player1.getPlayerDeckSize() == 0)
	{
		System.out.println("Player 1 win!!");
		break;
	}
	else if(player2.getPlayerDeckSize() == 0)
	{
		System.out.println("Player 2 win!!");
		break;
	}
		
	}
	}	
}





	
	

