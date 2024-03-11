package com.skilldistillery.blackjack.game;

import com.skilldistillery.blackjack.abstractcards.Card;
import com.skilldistillery.blackjack.abstractcards.Deck;

public class Dealer extends Player {
	private Deck deck = new Deck();

// D shuffles deck and deals cards to P/D
	public Card dealCard() {
		Card card = deck.dealCard();
		return card;
/// show one card and then after the player stays show second, hit until at least 17

	}

// D H/S the will be based on the rules of <17 to decide whether to h/s instead of kb entry like players version.

	public void hitOrStay() {
		System.out.println("The dealer has: " + getHandOfCards() + " and equal: " + getHandValue());
		while (getHandOfCards().getHandValue() < 17) {
			getHandOfCards().addCard(dealCard());
			System.out.println("The dealer hit and has: " + getHandOfCards() + " and equal: " + getHandValue());
			if (getHandOfCards().getHandValue() > 21) {
				System.out.println("The Dealer busted");
				break;
			}
		}
		if (getHandOfCards().getHandValue() <= 21) {
			System.out.println("The dealer stays and has: " + getHandOfCards() + " and equal: " + getHandValue());
		}
	}

//		System.out.println("In dealer hit or stay"); test statement

	public void shuffleDeck() {
		deck.shuffle();
	}
	/// ?????? how can I better test this?
	// public String showDealerCard() {
	// String dealersSecondCard = "Dealers Second Card" +
	// cardsInHand.get(0).toString();
	// return dealersSecondCard;
	// }
}