package com.skilldistillery.blackjack.entities;

public enum Suit {
SPADE("Spade"), HEART("Heart"), CLUB("Club"), DIAMOND("Diamond");
	String type;
	Suit(String type){
		this.type =type;
	}
	public String getType() {
		return type;
	}
	@Override
	public String toString() {
		return this.type;
	}
}
