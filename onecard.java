package test0901;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CardPlay {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      ArrayList<Card> deck = new ArrayList<Card>();
      
      int sum1 = 0;
      int sum2 = 0;
      int cnt = 0;
      
      for(int i = 0; i < 52; i++) {

         deck.add(new Card());
         if(0 < (i + 1) && (i + 1) <= 13) {
            deck.get(i).number = i + 1;
            deck.get(i).shape = "하트";
         }
         else if(13 < (i + 1) && (i + 1) <= 26) {
            deck.get(i).number = i + 1 - 13;
            deck.get(i).shape = "스페이드";
         }
         else if(26 < (i + 1) && (i + 1) <= 39) {
            deck.get(i).number = i + 1 - 13 * 2;
            deck.get(i).shape = "다이아";
         }
         else {
            deck.get(i).number = i + 1 - 13 * 3;
            deck.get(i).shape = "클로버";
         }
         
      }
      
      
      Player player1 = new Player();
      Player player2 = new Player();
      Player Field = new Player();
      Scanner sc = new Scanner(System.in);
      
      String cardShape1, cardShape2;
      int cardNumber1, cardNumber2;
      
      for(int i = 0; i < 10; i++)
      {
         player1.Card_Draw(deck);
         player2.Card_Draw(deck);
      }
      
      Field.Card_Draw(deck);
      
      while(true) 
      {
         System.out.println("필드 카드 모양 : " + Field.playerDeck.get(cnt).shape 
               + ", 숫자 : " + Field.playerDeck.get(cnt).number);
         
         System.out.print("플레이어1 카드 패 : ");
         for(int i = 0; i < player1.playerDeck.size(); i++)
         {
            System.out.print("모양 : " + player1.playerDeck.get(i).shape 
                  + ", 숫자 : " + player1.playerDeck.get(i).number + "\t");
         }
         System.out.println();
         System.out.print("낼 카드를 선택해주세요(낼 카드가 없으면 skip 0을 입력해주세요, skip 0 입력 시 뽑을 카드가 남아있는 경우 카드를 한장 가져옵니다.) : ");
         
         cardShape1 = sc.next();
         cardNumber1 = sc.nextInt();
         
         if(cardShape1.equals("skip") && cardNumber1 == 0) 
         {
            if(!deck.isEmpty())
            {
               player1.Card_Draw(deck);
            }
            else
            {
               System.out.println("덱의 카드가 모두 소진되어 카드를 가져올 수 없습니다.");
            }
            continue;
         }
         
         
         int cardTemp1 = player1.playerDeck.size();
         
         for(int i = 0; i < player1.playerDeck.size(); i++)
         {
            if(player1.playerDeck.get(i).shape.equals(cardShape1) || player1.playerDeck.get(i).number == cardNumber1)
            {
               if(cardShape1.equals( Field.playerDeck.get(cnt).shape) || cardNumber1 == Field.playerDeck.get(cnt).number)
               {
                  Field.playerDeck.add(player1.playerDeck.get(i));
                  player1.playerDeck.remove(player1.playerDeck.get(i));
                  cnt++;
               }
               else
               {
                  System.out.println("카드를 낼 수 없습니다."); 
               }
               break;
            }
            else if(i == player1.playerDeck.size() - 1 
                  && player1.playerDeck.get(i).shape != cardShape1
                  && player1.playerDeck.get(i).number != cardNumber1)
            {
               System.out.println("내려는 카드가 패에 없습니다. 다시 선택해주세요");
            }   
         }
         
         if(cardTemp1 == player1.playerDeck.size()) continue;
         
         
         System.out.println("필드 카드 모양 : " + Field.playerDeck.get(cnt).shape 
               + ", 숫자 : " + Field.playerDeck.get(cnt).number);
         
         System.out.print("플레이어2 카드 패 : ");
         for(int i = 0; i < player2.playerDeck.size(); i++)
         {
            System.out.print("모양 : " + player2.playerDeck.get(i).shape 
                  + ", 숫자 : " + player2.playerDeck.get(i).number+"\t");
         }
         System.out.println();
         System.out.print("낼 카드를 선택해주세요(낼 카드가 없으면 skip 0을 입력해주세요, skip 0 입력 시 뽑을 카드가 남아있는 경우 카드를 한장 가져옵니다.) : ");
         
         cardShape2 = sc.next();
         cardNumber2 = sc.nextInt();
         if(cardShape2.equals("skip") && cardNumber2 == 0) 
         {
            if(!deck.isEmpty())
            {
               player2.Card_Draw(deck);
            }
            else
            {
               System.out.println("덱의 카드가 모두 소진되어 카드를 가져올 수 없습니다.");
            }
            continue;
         }
         
         
         int cardTemp2 = player2.playerDeck.size();
         for(int i = 0; i < player2.playerDeck.size(); i++)
         {
            if(player2.playerDeck.get(i).shape.equals(cardShape2) 
                  || player2.playerDeck.get(i).number == cardNumber2)
            {
               if(cardShape2.equals(Field.playerDeck.get(cnt).shape)  || cardNumber2 == Field.playerDeck.get(cnt).number)
               {
                  Field.playerDeck.add(player2.playerDeck.get(i));
                  player1.playerDeck.remove(player2.playerDeck.get(i));
                  cnt++;
               }
               else
               {
                  System.out.println("카드를 낼 수 없습니다.");
               }
               break;
            }
            else if(i == player2.playerDeck.size() - 1
                  && player2.playerDeck.get(i).shape != cardShape2
                  && player2.playerDeck.get(i).number != cardNumber2)
            {
               System.out.println("내려는 카드가 패에 없습니다. 다시 선택해주세요");
            }   
         }
         
         if(cardTemp2 == player2.playerDeck.size()) continue;
         
         
         if(player1.playerDeck.size() == 0)
         {
            System.out.println("Player 1 win!!");
            break;
         }
         else if(player2.playerDeck.size() == 0)
         {
            System.out.println("Player 2 win!!");
            break;
         }
      }
      
   }
   
}

class Card{
   public String shape;
   public int number;
}


class Player{
   public String name;
   ArrayList<Card> playerDeck = new ArrayList<Card>();
   void Card_Draw(ArrayList<Card> newCard)
   {
      playerDeck.add(new Card());
      
      Random random = new Random();
      
      int idx = playerDeck.size() - 1;
      
      int num = random.nextInt(newCard.size() - 1);
      
      playerDeck.get(idx).shape = newCard.get(num).shape;
      playerDeck.get(idx).number = newCard.get(num).number;
      
      newCard.remove(newCard.get(num));
      
      
   }
   
   
}
