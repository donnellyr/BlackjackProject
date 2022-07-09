package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
private List <Card> deck = new ArrayList<>();

public Deck() {
	
}
public void makeDeck() {
	for (Suit s : Suit.values()) {
		Rank[] ranks = Rank.values();
		for (int i = 0; i < ranks.length; i++) {
			Card newCard = new Card(s, ranks[i], ranks[i].getValue());
			deck.add(newCard);
		}
	}
}
public List<Card> shuffleDeck() {
 Collections.shuffle(deck, new Random());
 return deck;
}
}
