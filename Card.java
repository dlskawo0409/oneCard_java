package test0901;

public class Card {
	private String shape; 
	private int cardNum;
	
	Card(){
		this("none",0);
	}
	
	public Card(String shape, int cardNum){
		this.shape=shape;
		this.cardNum=cardNum;
	}
	
	public String getShape() {
		return this.shape;
	}
	
	public int getCardNum() {
		return this.cardNum;
	}
}

