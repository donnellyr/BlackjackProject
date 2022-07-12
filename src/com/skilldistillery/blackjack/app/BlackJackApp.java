package com.skilldistillery.blackjack.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.blackjack.entities.BlackJackHand;
import com.skilldistillery.blackjack.entities.Card;
import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.DealerHand;
import com.skilldistillery.blackjack.entities.Deck;

public class BlackJackApp {
	Scanner sc = new Scanner(System.in);
	BlackJackHand player = new BlackJackHand();
	DealerHand dealerHand = new DealerHand();
	Deck deckofcards = new Deck();
	List<Card> deck = new ArrayList<>();
	Dealer dealer = new Dealer();

	public static void main(String[] args) {
		BlackJackApp app = new BlackJackApp();
		app.run();
	}
	public void run() {
		dealer.newGame();
		playBlackJack();
	}


	public void playBlackJack() {
		for (int i = 0; i < 2; i++) {
			player.addCard(dealer.Deal());
			dealerHand.addCard(dealer.Deal());
		}
		player.displayHand();
		dealerHand.displayHandPre();
		if (player.getHandValue() == 22 || dealerHand.getHandValue() == 22) {
			findWinner();
		}
		if (player.getHandValue() == 21 || dealerHand.getHandValue() == 21) {
			findWinner();
		} else {
			playerChoice();
			if (player.isBust() != true) {
				dealerLogic();
			}
			findWinner();
		}
		player.displayHand();
		dealerHand.displayHand();
	}

	private void playerChoice() {
		String choice = "";

		while (player.isBust() != true) {
			System.out.println("Hit or Stay?");
			choice = sc.nextLine();
			if (choice.toUpperCase().equals("HIT")) {
				player.addCard(dealer.Deal());
				player.displayHand();
			} else {
				break;
			}

		}
	}

	private void dealerLogic() {
		while (dealerHand.getHandValue() < 17) {
			dealerHand.addCard(dealer.Deal());
			System.out.println("Dealer hits");
			dealerHand.displayHand();
		}
	}

	private void findWinner() {
		if (player.isBust()) {
			System.out.println("Bust, you lose");
		}
		if (dealerHand.isBust()) {
			System.out.println("Dealer busts, you win");
		}
		if (player.getHandValue() > dealerHand.getHandValue() && player.getHandValue() < 22) {
			System.out.println("You Win");
		}
		if (player.getHandValue() < dealerHand.getHandValue() && dealerHand.isBust() != true) {
			System.out.println("You lose");
		}
		if (player.getHandValue() == dealerHand.getHandValue()) {
			System.out.println("Push");
		}
	}


}
