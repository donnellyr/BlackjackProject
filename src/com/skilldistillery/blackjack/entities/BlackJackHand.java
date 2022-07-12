package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public class BlackJackHand extends Hand {
	public BlackJackHand(List<Card> hand) {
		super(hand);
		this.hand = hand;
		}
	public BlackJackHand() {
	}
	
	@Override
	public int getHandValue() {
		int handvalue =0;
		for (Card card : hand) {
			handvalue += card.getValue();
		}
		return handvalue;
	}
	public boolean isBust() {
		if (getHandValue() > 21) {
			return true;
		}
		else {
			return false;
		}
		
	}
	public void displayHand() {
		System.out.println("Player Hand");
		for (Card card : hand) {
			System.out.print(card + " ");
			
		}

		System.out.println();
}
	public void newHand() {
		for (Card card : hand) {
			hand.remove(card);
		}
	}
}