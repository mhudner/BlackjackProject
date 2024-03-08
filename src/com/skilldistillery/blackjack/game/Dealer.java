package com.skilldistillery.blackjack.game;

import com.skilldistillery.blackjack.abstractcards.Card;
import com.skilldistillery.blackjack.abstractcards.Deck;

public class Dealer extends Player {
	// DO NOT ADD HAND, ITS ALREADY INHERITED FROM PLAYER

	// DO NOT MAKE A getDeck() method
	private Deck deck;

	// dealer needs to use dealCard method

	public Dealer() {
		// TODO Auto-generated constructor stub
	}

	public Card dealCard() {
		// dealer can deal a card from the deck,
		// create behaviors the dealer can use to interact with its deck
		return null;
	}
}
