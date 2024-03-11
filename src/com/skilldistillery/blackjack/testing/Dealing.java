package com.skilldistillery.blackjack.testing;

import java.util.List;

import com.skilldistillery.blackjack.abstractcards.Card;
import com.skilldistillery.blackjack.abstractcards.Deck;
import com.skilldistillery.blackjack.game.BlackjackHand;

public class Dealing {

	public Deck deck;
	BlackjackHand dealerHand; // The dealer's hand.
	BlackjackHand playerHand; // The user's hand.

	public static void main(String[] args) {
		Dealing d = new Dealing();
		d.run();
		d.printHandAndValue(null, 0);
	}

	public void run() {
		// A deck of cards. A new deck for each game.

		deck = new Deck();
		dealerHand = new BlackjackHand();
		playerHand = new BlackjackHand();

		/* Shuffle the deck, then deal two cards to each player. */

		deck.shuffle();
		playerHand.addCard(deck.dealCard());
		dealerHand.addCard(deck.dealCard());
		playerHand.addCard(deck.dealCard());
		dealerHand.addCard(deck.dealCard());

		System.out.println(playerHand);
		System.out.println(dealerHand);

	}

	public void printHandAndValue(List<Card> hand, int value) {
		for (Card card : hand) {
			System.out.println(card);
		}
		System.out.println("Total value: " + value);
		System.out.println(dealerHand);
	}

}
