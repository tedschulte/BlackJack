package com.lmig.gfc.blackjack.models;

import java.util.LinkedList;
import java.util.List;

public class Hand {

	private LinkedList<Card> cards;

	public Hand() {
		cards = new LinkedList<Card>();
	}

	public void acceptCard(Card card) {
		cards.add(card);
	}

	public List<Card> getCards() {
		return cards;
	}

	public int getTotal() {
		int sum = 0;
		int aces = 0;
		for (Card card : cards) {
			if (card.getValue() == 11)
				aces += 1;
			sum += card.getValue();
		}

		if (sum > 21) {
			while (aces > 0 && sum > 21) {
				sum -= 10;
				aces -= 1;
			}
		}

		return sum;
	}

	public boolean isNotBusted() {
		return getTotal() < 21;
	}

	public boolean isBusted() {
		return getTotal() > 21;
	}

	public boolean removeStandButton() {
		return getTotal() < 22;
	}

	public String getBusted() {
		if (getTotal() > 21) {
			return "BUSTED!";
		} else {
			return "";
		}
	}

	public int getSize() {
		return cards.size();

	}

}
