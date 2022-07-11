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
		playBlackJack();
	}

	public void playBlackJack() {
		for (int i = 0; i < 2; i++) {
			player.addCard(Deal());
			dealer.addCard(Deal());
		}
		player.displayHand();
		dealer.displayHandPre();
		if (player.getHandValue() == 22 || dealer.getHandValue() == 22) {
			findWinner();
		}
		if (player.getHandValue() == 21 || dealer.getHandValue() == 21) {
			findWinner();
		} else {
			playerChoice();
			if (player.isBust() != true) {
				dealerLogic();
			}
			findWinner();
		}
		player.displayHand();
		dealer.displayHand();
	}

	private void playerChoice() {
		String choice = "";

		while (player.isBust() != true) {
			System.out.println("Hit or Stay?");
			choice = sc.nextLine();
			if (choice.toUpperCase().equals("HIT")) {
				Hit();
				player.displayHand();
			} else {
				break;
			}

		}
	}

	private void dealerLogic() {
		while (dealer.getHandValue() < 17) {
			dealer.addCard(Deal());
			System.out.println("Dealer hits");
			dealer.displayHand();
		}
	}

	private void findWinner() {
		if (player.isBust()) {
			System.out.println("Bust, you lose");
		}
		if (dealer.isBust()) {
			System.out.println("Dealer busts, you win");
		}
		if (player.getHandValue() > dealer.getHandValue() && player.getHandValue() < 22) {
			System.out.println("You Win");
		}
		if (player.getHandValue() < dealer.getHandValue() && dealer.isBust() != true) {
			System.out.println("You lose");
		}
		if (player.getHandValue() == dealer.getHandValue()) {
			System.out.println("Push");
		}
	}

	public void newDeck() {
		deckofcards.makeDeck();
	}

	public void Hit() {
		player.addCard(Deal());
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