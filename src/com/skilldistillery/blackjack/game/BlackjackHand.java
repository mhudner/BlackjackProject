package com.skilldistillery.blackjack.game;

import com.skilldistillery.blackjack.abstractcards.Card;
import com.skilldistillery.blackjack.abstractcards.Hand;

public class BlackjackHand extends Hand {

	public int getHandValue() {
		// add up the rank of all the cards in hand
		int totalHandValue = 0;
		for (Card card : cardsInHand) {
			totalHandValue = totalHandValue + card.getValue();
		}
		return totalHandValue;
// How super.cardInHand.get(0).getvalue(); but it has to be different.
	}

	public boolean isBlackJack() {
		if (getHandValue() == 21) {
			System.out.println("BlackJack");
			return true;
		} else {
			return false;
		}
	}

	public boolean isBust() {
		if (getHandValue() > 21) {
			System.out.println("Busted");
			return true;
		} else {
			return false;
		}

	}

}