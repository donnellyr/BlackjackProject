package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CardTest {
	List<Card> deck = new ArrayList();
	int numcard =0;
	int handvalue =0;
	int dealervalue =0;
	String choice= "";
	Scanner sc = new Scanner(System.in);
  public static void main(String[] args) {
	  CardTest run = new CardTest();
	  
    run.dealer();
  }
public void dealer() {
	makeDeck();
	shuffleDeck();
	System.out.println("How Many cards do you want dealt?");
	numcard = sc.nextInt();
	dealDeck();
	dealDealer();
	if(handvalue < 21) {
			System.out.println("Hit or stay?");
			choice = sc.nextLine();
			choice = sc.nextLine();
			if(choice.equals("Hit")) {
				numcard = 1;
				dealDeck();
			}
			else {
			}
		}
	}

private void dealDealer() {
	numcard = 2;
	System.out.println("Dealer hand");
	for(int i =0; i < numcard; i++) {
		System.out.println(deck.get(i));
		dealervalue += deck.get(i).getValue();
		deck.remove(i);
	}
	System.out.println(deck.size());
	System.out.println("Dealer Value: " + dealervalue);
	if(dealervalue > 21) {
		System.out.println("Dealer BUST");
	}
	// TODO Auto-generated method stub
	
}
public void makeDeck() {
	for (Suit s : Suit.values()) {
		 Rank[] ranks = Rank.values();
		    for(int i=0; i<ranks.length; i++) {
		    	Card newCard = new Card(s, ranks[i], ranks[i].getValue());
		    	deck.add(newCard);
	}

}
	
}
public void shuffleDeck() {
	Collections.shuffle(deck, new Random());
}
public void dealDeck() {
	System.out.println("Player Hand");
	for(int i =0; i < numcard; i++) {
		System.out.println(deck.get(i));
		handvalue += deck.get(i).getValue();
		deck.remove(i);
	}
	System.out.println(deck.size());
	System.out.println("Hand Value: " + handvalue);
	if(handvalue > 21) {
		System.out.println("BUST");
	}
}
}

