package com.lmig.gfc.blackjack.models;

public abstract class Card {

	private Suit suit;

	public Card(Suit suit) {
		this.suit = suit;

	}

	public Suit getSuit() {
		return suit;
	}

	public abstract String getRank();

	public abstract int getValue();

}
