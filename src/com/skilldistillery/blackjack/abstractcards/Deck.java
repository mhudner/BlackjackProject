package com.skilldistillery.blackjack.abstractcards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private List<Card> cards;

	public Deck() {
		cards = createDeck();
	}

	private List<Card> createDeck() {
		// TODO Auto-generated method stub
		List<Card> deck = new ArrayList<>(52);
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				deck.add(new Card(rank, suit));
			}
		}
		return deck;
	}

	public List<Card> getCards() {
		return cards;
	}

	public int checkDeckSize() {
		return cards.size();
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}

	public Card dealCard() {
		return cards.remove(0);

	}

	public void dealCard(Hand hand) {
		hand.addCard(dealCard());
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

}