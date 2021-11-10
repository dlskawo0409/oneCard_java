package test0901;

import java.util.ArrayList;

public class Field {
	private Card fieldCard = new Card();
	
	Field(){}
	
	public void changeFieldCard(Card newCard){
		fieldCard=newCard;
	}
	
	public void printFieldCard() {
		System.out.println("필드 카드 모양 : " + fieldCard.getShape()
				+ ", 숫자 : " + fieldCard.getCardNum()+"\n");
	}
	
	public String getFieldCardShape() {
		return fieldCard.getShape();
	}
	public int getFieldCardNum() {
		return fieldCard.getCardNum();
	}
	

}

