package com.skilldistillery.blackjack.entities;

import java.util.List;

public class DealerHand extends Hand {
	private int handvalue;

	public DealerHand(List<Card> hand) {
		super(hand);
		// TODO Auto-generated constructor stub
	}

	public DealerHand() {
		// TODO Auto-generated constructor stub
	}

	public int getHandValue() {
		handvalue =0;
		for (Card card : hand) {
			handvalue += card.getValue();
		}
		return handvalue;
	}
	public void displayHand() {
		System.out.println("Dealer Hand");
		for (Card card : hand) {
			System.out.print(card + " ");
		}
		System.out.println();
	}
	public void displayHandPre() {
		System.out.println("Dealer Hand");
		
			System.out.println(hand.get(0) + " and a face down card");
	}

	public boolean isBust() {
		if (getHandValue() > 21) {
			return true;
		} else {
			return false;
		}

	}
}
