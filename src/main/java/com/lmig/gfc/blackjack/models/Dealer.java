package com.lmig.gfc.blackjack.models;

public class Dealer {

	private Hand hand;

	public Dealer() {
		hand = new Hand();

	}

	public void accept(Card newCardFromDeck) {
		hand.acceptCard(newCardFromDeck);

	}

	public void newHand() {
		hand = new Hand();
	}

	public String getHidden() {
		if (hand.getCards().size() <= 1) {
			return "HOLE";
		} else {
			return "";
		}
	}

	public boolean isBusted() {
		return hand.getTotal() > 21;
	}

	public int getHandTotal() {
		return hand.getTotal();
	}

	public int getHandSize() {
		return hand.getSize();
	}
}
