package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	private int handvalue;
	protected List<Card> hand = new ArrayList<Card>();
	public Hand() {
		
	}

	public Hand(List<Card> hand) {
		for (Card card : hand) {
			this.hand.add(card);
		}
	}

	public void displayHand() {
		for (Card card : hand) {
			System.out.println(card);
		}
	}

	public void addCard(Card card) {
		hand.add(card);
	}

	public void Clear() {
		for (Card card : hand) {
			hand.remove(card);
		}
	}

	abstract int getHandValue();

	@Override
	public String toString() {
		return "Hand [handvalue=" + handvalue + ", hand=" + hand + "]";
	}
}
