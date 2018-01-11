package com.lmig.gfc.blackjack.models;

public class Game {

	private double playerBet;
	private Deck deck;
	private Player player;
	private Dealer dealer;
	private Chips chips;

	public Game() {
		player = new Player();
		dealer = new Dealer();
		deck = new Deck();
		chips = new Chips();

		deck.createDeck();
		deck.shuffle();
	}

	public void hitPlayer() {
		Card newCardFromDeck = deck.draw();
		player.accept(newCardFromDeck);
	}

	public void hitDealer() {
		Card newCardFromDeck = deck.draw();
		dealer.accept(newCardFromDeck);
	}

	public void playerStands() {
		while (dealer.getHandTotal() < 17) {
			this.hitDealer();
		}
	}

	public void setUpGame() {
		player.newHand();
		dealer.newHand();
		chips.decreaseByBet(playerBet);
		this.hitPlayer();
		this.hitPlayer();
		this.hitDealer();
	}

	public boolean didPlayerLose() {
		if (player.getHandTotal() > 21) {
			return true;
		} else {
			return false;
		}
	}

	public boolean didPlayerWin() {
		if (player.getHandTotal() > dealer.getHandTotal() && !player.isBusted()) {
			return true;
		} else if (dealer.isBusted()) {
			return true;
		}
		return false;
	}

	public boolean didDealerWin() {
		if (player.isBusted() || (dealer.getHandTotal() > player.getHandTotal() && !dealer.isBusted())) {
			return true;

		} else {
			return false;
		}
	}

	public boolean isPush() {
		if ((player.getHandTotal() == dealer.getHandTotal()) && (!player.isBusted() || !dealer.isBusted())) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isBlackjack() {
		if (player.getHandSize() == 2 && player.getHandTotal() == 21) {
			return true;
		} else {
			return false;
		}
	}

	public boolean outOfCards() {
		return deck.size() == 0;
	}

	public void payout() {
		if (isBlackjack() == true) {
			chips.blackjackMoneyWin(playerBet);
		}
		if (didPlayerWin() == true) {
			chips.increaseFromWin(playerBet);
		}
		if (isPush() == true) {
			chips.pushPayout(playerBet);
		} else {
			chips.reduceFromLoss(playerBet);
		}
	}

	public void makePlayerBet(double bet) {
		playerBet = bet;
	}

	public double getPlayerBet() {
		return playerBet;
	}

	public boolean outOfMoney() {
		return chips.getMoney() <= 0;
	}

	public void moreMoney() {
		chips.depositMoney();
	}

	public void resetGame() {
		player.newHand();
		dealer.newHand();
		this.setUpGame();
	}

	public void newCards() {
		deck.createDeck();
		deck.shuffle();
	}
}
