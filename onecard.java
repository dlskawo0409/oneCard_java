package test0901;

import java.util.Scanner;

public class onecard {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		System.out.print("게임을 플레이할 인원을 적어주세요:");
		
		CardPlay cp=new CardPlay(sc.nextInt());
		
		System.out.print("초기에 나누어줄 카드 숫자를 선정하세요:");
		
		cp.distributeCard(sc.nextInt());
		
		while(true) {
			cp.showTable();
			
			String cardShape=sc.next();
			int cardNum=sc.nextInt();
			if(cp.playerBehavior(cardShape, cardNum)) {
				cp.checkWinnerAndEndGame();
				cp.nextTurn();
			}
				
		}
	}
}

