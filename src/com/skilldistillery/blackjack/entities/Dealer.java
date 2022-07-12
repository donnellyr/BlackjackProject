package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dealer {
	Scanner sc = new Scanner(System.in);
	BlackJackHand player = new BlackJackHand();
	DealerHand dealer = new DealerHand();
	Deck deckofcards = new Deck();
	List<Card> deck = new ArrayList<>();

	public void newGame() {
		newDeck();
		shuffleDeck();
	}


	public void newDeck() {
		deckofcards.makeDeck();
	}


	public void shuffleDeck() {
		deck = deckofcards.shuffleDeck();
	}

	public Card Deal() {
		Card hit = deck.get(0);
		deck.remove(0);
		return hit;
	}

	public void deckSize() {
		System.out.println(deck.size());
	}
}