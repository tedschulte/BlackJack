package com.lmig.gfc.blackjack.models;

public class Chips {

	private double money;
	private double playerBet;

	public Chips() {
		money = 500.0;

	}

	public double getPlayerBet() {
		return playerBet;

	}

	public void reduceFromLoss(double playerBet) {
		money = money - playerBet + playerBet;
	}

	public void increaseFromWin(double playerBet) {
		money = money + playerBet + playerBet;
	}

	public void decreaseByBet(double playerBet) {
		money = money - playerBet;
	}

	public void blackjackMoneyWin(double playerBet) {
		money = (money + (playerBet * 0.5));
	}

	public void pushPayout(double playerBet) {
		money = money + playerBet;
	}

	public double getMoney() {
		return money;
	}

	public void depositMoney() {
		money = 500.0;
	}

}
