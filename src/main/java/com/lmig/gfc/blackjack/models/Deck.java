package com.lmig.gfc.blackjack.models;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

	private ArrayList<Card> deck;

	public Deck() {
		deck = new ArrayList<Card>();
	}

	public void createDeck() {
		// loop over the suits, for each suit
		for (Suit suit : Suit.values()) {
			// add an ace card to the deck
			deck.add(new AceCard(suit));

			for (int i = 2; i <= 10; i += 1) {
				deck.add(new NumberCard(suit, i));
			}
			for (FaceCards facecards : FaceCards.values()) {
				deck.add(new FaceCard(suit, facecards));
			}
		}
	}

	public void shuffle() {
		Collections.shuffle(deck);
	}

	public Card draw() {
		return deck.remove(0);
	}

	public int size() {
		return deck.size();
	}

	public ArrayList<Card> getDeck() {
		return deck;
	}

}
