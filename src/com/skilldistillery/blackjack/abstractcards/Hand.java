package com.skilldistillery.blackjack.abstractcards;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	// hand has a collection of cards inside of it
	protected List<Card> cardsInHand = new ArrayList<>();

	public Hand() {
		// TODO Auto-generated constructor stub
	}

	public void addCard() {

	}

	public void clear() {

	}

	public abstract int getHandValue();

}
