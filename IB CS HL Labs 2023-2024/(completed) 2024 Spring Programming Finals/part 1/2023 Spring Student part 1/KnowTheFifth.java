import java.lang.*;
import java.util.*;
import java.lang.Math;
/**
 * @author  Don Allen
 * @version 2023 Wittry Contest
 */
public class KnowTheFifth
{
    public static int find(String[] array, String search){
        for(int i=0; i<array.length; i++){
            if(search.equals(array[i])){
                return i;
            }
        }
        return -1;
    }
    
    public static int find(Card[] array, Card search){
        for(int i=0; i<array.length; i++){
            if(search.getRank()==array[i].getRank() && search.getSuit().equals(array[i].getSuit())){
                return i;
            }
        }
        return -1;
    }
    
    /*
     *    precondition:  !c1.equals(c2)
     */
    public static Card isSmaller(Card c1, Card c2)
    {
       if(c1.getRank()<c2.getRank()){
           return c1;
       }
       if(c1.getRank()>c2.getRank()){
           return c2; 
       }

       String[] suits = {"club", "diamond", "heart", "spade"};
       if(find(suits, c1.getSuit())<find(suits, c2.getSuit())){
           return c1;
       }
       if(find(suits, c1.getSuit())>find(suits, c2.getSuit())){
           return c2;
       }
       
       return c1;
    }
    
    public static boolean firstIsSmaller(Card c1, Card c2)
    {
       if(c1.getRank()<c2.getRank()){
           return true;
       }

       String[] suits = {"club", "diamond", "heart", "spade"};
       if(find(suits, c1.getSuit())<find(suits, c2.getSuit())){
           return true;
       }
       
       return false;
    }
    
    public static Card[] wonderfulCards(Card[] cards){
       Card[] copy = new Card[cards.length];
       for(int i=0; i<cards.length; i++){
           copy[i] = cards[i];
       }
        for(int i=0; i<copy.length; i++){
           for(int j=i+1; j<copy.length; j++){
               if(isSmaller(copy[i], copy[j]).equals(copy[j])){
                   Card temp = copy[i];
                   copy[i] = copy[j];
                   copy[j] = temp;
               }
           }
       }
       return copy; 
    }
    
    /*
 *    preCondition: cards.length() == 5
 *    
 *    return the proper arrangement of the four Cards which indicate the fifth card
 *    if multiple arrangements exist, return any of the arrangements
 */
    public static Card[] notArrangeCards1(Card[] cards)
    {
        if(cards.length!=5){
           System.out.print("yes");
       }
       Card[] ans = new Card[5]; 
       for(int i=0; i<cards.length; i++){
           for(int j=i+1; j<cards.length; j++){
               if(cards[i].getSuit().equals(cards[j].getSuit())){
                   ans[0] = cards[i];
                   cards[i] = new Card("", 0);
                   ans[4] = cards[j];
                   cards[j] = new Card("", 0);
               }
           }
       }
       
       int rank = ans[4].getRank()-ans[0].getRank()-1;
       if(rank<0){
           Card temp = ans[0];
           ans[0] = ans[4];
           ans[4] = temp;
           rank = -1*rank-2;
       }
       if(rank>5){
           Card temp = ans[0];
           ans[0] = ans[4];
           ans[4] = temp;
           rank = 11-rank; 
       }
       if(rank/2>=3){
           System.out.print("yes");
       }
       
       cards = wonderfulCards(cards);
       
       ans[1] = cards[rank/2+2];
       cards[rank/2+2] = new Card("",0);
       cards = wonderfulCards(cards);
       
       if(rank%2==0){
           ans[2] = cards[3];
           ans[3] = cards[4];
       }
       
       if(rank%2==1){
           ans[2] = cards[4];
           ans[3] = cards[3];
       }
       System.out.println(ans[0].getSuit());
       System.out.println(ans[0].getRank());
       System.out.println(ans[1].getSuit());
       System.out.println(ans[1].getRank());
       System.out.println(ans[2].getSuit());
       System.out.println(ans[2].getRank());
       System.out.println(ans[3].getSuit());
       System.out.println(ans[3].getRank());
       System.out.println(ans[4].getSuit());
       System.out.println(ans[4].getRank());
       System.out.println("end");
       return ans;
    }

/*
 *    preCondition: cards.length() == 5
 *    
 *    return the proper arrangement of the four Cards which indicate the fifth card
 *    if multiple arrangements exist, return any of the arrangements
 */
    public static Card[] arrangeCards(Card[] cards)
    {
       ArrayList<String> checkedSuits = new ArrayList<String>(); 
       for(int i=0; i<5; i++){
           if(checkedSuits.contains(cards[i].getSuit())){
               Card temp = cards[0];
               cards[0] = cards[checkedSuits.indexOf(cards[i].getSuit())];
               cards[checkedSuits.indexOf(cards[i].getSuit())] = temp; 
               
               temp = cards[4];
               cards[4] = cards[i];
               cards[i] = temp; 
           }
           checkedSuits.add(cards[i].getSuit());
       }
       
       int rank = cards[4].getRank()-cards[0].getRank()-1;
       if(rank<0){
           Card temp = cards[0];
           cards[0] = cards[4];
           cards[4] = temp;
           rank = -1*rank-2;
       }
       if(rank>5){
           Card temp = cards[0];
           cards[0] = cards[4];
           cards[4] = temp;
           rank = 11-rank; 
       }
       
       Card[] wonderfuledCards = new Card[3];
       for(int i=0; i<3; i++){
           wonderfuledCards[i] = cards[i+1];
       }
       wonderfuledCards = wonderfulCards(wonderfuledCards);
       
       Card temp = cards[1];
       cards[1] = wonderfuledCards[rank/2];
       wonderfuledCards[rank/2] = new Card("",0);
       wonderfuledCards = wonderfulCards(wonderfuledCards);
       
       if(rank%2==0){
           cards[2] = wonderfuledCards[1];
           cards[3] = wonderfuledCards[2];
       }
       
       if(rank%2==1){
           cards[2] = wonderfuledCards[2];
           cards[3] = wonderfuledCards[1];
       }
       
       return cards;
    }

/*
 *      cs.size() == 3
 */
    public int evaluateOrder(Card[] cs)
    {
       Card[] wonderfuled = wonderfulCards(cs);
       int ans = find(wonderfuled, cs[0])*2+1;
       if(isSmaller(cs[1], cs[2]).equals(cs[2])){
           ans++;
       }
       return ans;
    }

/*
 *    cards.length() == 4
 *    
 *    return the card indicate by the four cards in Cards
 */
    public Card name5thCard(Card[] cards)
    {
       String suit = cards[0].getSuit();
       
       Card[] cs = new Card[3];
       for(int i=1; i<4; i++){
           cs[i-1] = cards[i];
       }
       
       int rank = (cards[0].getRank()+evaluateOrder(cs))%13;
       if(rank==0){
           rank = 13;
       }

       return new Card(suit, rank);
    }
}