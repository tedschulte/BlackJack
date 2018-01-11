package com.lmig.gfc.blackjack.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmig.gfc.blackjack.models.Game;

@Controller
public class HomeController {

	private Game game;

	public HomeController() {
		game = new Game();

	}

	@GetMapping("/")
	public ModelAndView showBetScreen() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bet");

		mv.addObject("game", game);
		return mv;
	}

	@PostMapping("/bet")
	public ModelAndView handleBet(double bet) {
		game.makePlayerBet(bet);

		game.setUpGame();

		ModelAndView mv = new ModelAndView();

		mv.addObject("game", game);
		mv.setViewName("redirect:/play");

		return mv;
	}

	@GetMapping("/play")
	public ModelAndView showPlayScreen() {
		ModelAndView mv = new ModelAndView();

		if (game.outOfMoney() == true && game.didPlayerLose()) {
			mv.setViewName("redirect:/noMoney");
		} else if (game.outOfCards() == true) {
			mv.setViewName("redirect:/noCards");

		} else {
			mv.setViewName("play");
		}

		mv.addObject("game", game);

		return mv;
	}

	@PostMapping("/hit")
	public ModelAndView hitPlayerScreen() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("game", game);

		try {
			game.hitPlayer();
			if (game.didPlayerLose()) {
				game.payout();
			}
			mv.setViewName("redirect:/play");
		} catch (Exception e) {
			mv.setViewName("redirect:/over");
		}

		return mv;

	}

	@PostMapping("/stand")
	public ModelAndView hitDealerScreen() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("game", game);

		try {
			game.playerStands();
			game.payout();
		} catch (Exception e) {
		}
		mv.setViewName("redirect:/over");
		return mv;
	}

	@GetMapping("/over")
	public ModelAndView showOverScreen() {
		ModelAndView mv = new ModelAndView();

		mv.addObject("game", game);

		if (game.outOfMoney() == true) {
			mv.setViewName("redirect:/noMoney");
		} else if (game.outOfCards() == true) {
			mv.setViewName("redirect:/noCards");

		} else {
			mv.setViewName("over");
		}
		return mv;
	}

	@PostMapping("/reBet")
	public ModelAndView nextHandScreen(int bet) {
		ModelAndView mv = new ModelAndView();
		game.makePlayerBet(bet);
		game.resetGame();
		
		mv.setViewName("redirect:/play");
		return mv;
	}

	@GetMapping("/noMoney")
	public ModelAndView noMoneyScreen() {
		ModelAndView mv = new ModelAndView();
		game.moreMoney();
		mv.addObject("game", game);
		mv.setViewName("noMoney");
		return mv;
	}

	@GetMapping("/noCards")
	public ModelAndView noCardsScreen() {
		ModelAndView mv = new ModelAndView();
		game.newCards();
		mv.addObject("game", game);
		mv.setViewName("noCards");
		return mv;
	}

}
