package com.skilldistillery.blackjack.app;

import com.skilldistillery.blackjack.entities.BlackJackHand;
import com.skilldistillery.blackjack.entities.Dealer;

public class BlackJackApp {

	public static void main(String[] args) {
		BlackJackApp app = new BlackJackApp();
		app.run();
	}
	public void run() {
		Dealer dealer = new Dealer();
		dealer.newGame();
	}

}
