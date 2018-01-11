package com.lmig.gfc.blackjack.models;

public class FaceCard extends Card {

	private FaceCards rank;

	public FaceCard(Suit suit, FaceCards rank) {
		super(suit);
		this.rank = rank;
	}

	@Override
	public String getRank() {
		return rank.toString();
	}

	@Override
	public int getValue() {
		return 10;
	}
}
