package com.lmig.gfc.blackjack.models;

public class Player {

	private Hand hand;
	private Chips money;

	public Player() {
		hand = new Hand();
		money = new Chips();

	}

	public void accept(Card newCardFromDeck) {
		hand.acceptCard(newCardFromDeck);
	}

	public void newHand() {
		hand = new Hand();
	}

	public Chips getChips() {
		return money;
	}

	public void setChips(Chips chips) {
		this.money = chips;
	}

	public int getHandTotal() {
		return hand.getTotal();
	}

	public boolean isBusted() {
		return hand.getTotal() > 21;
	}

	public int getHandSize() {
		return hand.getSize();
	}
}
