package com.skilldistillery.blackjack.app;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.skilldistillery.blackjack.game.Dealer;
import com.skilldistillery.blackjack.game.Player;

public class BlackjackApp {

	Scanner kb = new Scanner(System.in);
	boolean gameRunning;
	Player player = new Player();
	Dealer dealer = new Dealer();

// initiate the deck, deal cards to player and dealer
//	p=2c both up d=1up 1down. p chooses to hit or stay till stay. if(player busts = loose) 
// dealer displays card two and plays until at least = 17.
// if scores equal then tie.
// continue play until user types quit.
// Stretch*** track wins with counter
// deck number 
// DicardDeck ;

//************** BLackJackApp run method block 
	private void run() {
		gameRunning = true;

		System.out.println("Welcome Player we are going to play some black jack!!! \n");
		System.out.println("Would you like to see the rules? Y/N");

		String rulesChoice = kb.nextLine();

		try {
			if (rulesChoice.equalsIgnoreCase("Y")) {
				displayRules();
				startGame();
			}
			if (rulesChoice.equalsIgnoreCase("N")) {
				startGame();
			}
		} catch (InputMismatchException e) {
			System.out.println("Not a valid selection");
		} finally {
			kb.close();
		}
	}

	private void startGame() {
		boolean inGame = true;
		while (inGame) {
			int roundCount = 1;
			boolean gameRunning = true;
			while (gameRunning) {
				System.out.println("Round  " + roundCount);
				dealer.shuffleDeck();
				dealCards();
				player.hitOrStay(dealer, kb);
				dealer.hitOrStay();
				// if P > D && P <=21 P wins else if D > P && D <= 21 D wins else is a tie
				if (player.getHandValue() > dealer.getHandValue() && player.getHandValue() <= 21) {
					System.out.println("Player Wins with" + player.getHandValue());
					gameRunning = false;
				} else if (dealer.getHandValue() > player.getHandValue() && dealer.getHandValue() <= 21) {
					System.out.println("Dealer Wins with" + dealer.getHandValue());
					gameRunning = false;
				} else {
					System.out.println("It's a Tie hand");
					gameRunning = false;
				}
			}
			player.clearHand();
			dealer.clearHand();
			// BlackJackHand handOfCards= new BlackJackHand();
			// BlackJackHand.Hand.removeAllCard(cardsInHand);

			System.out.println("\nDo you want to play another round Y/N ?\n");
			String userQuit = kb.nextLine();
			if (userQuit.equalsIgnoreCase("N")) {
				inGame = false;
				System.out.println("Oh good I thought you were getting addicted GOODBYE");
			}
			if (userQuit.equalsIgnoreCase("Y")) {
				inGame = true;
				roundCount = roundCount + 1;
				System.out.println("Lets deal the cards\n");
			}
		}

	} // end while

	// end startGame

	private void dealCards() {

		player.addCard(dealer.dealCard());
		dealer.addCard(dealer.dealCard());
		player.addCard(dealer.dealCard());
		dealer.addCard(dealer.dealCard());
		System.out.println("Your cards: " + player.toString() + " and equal: " + player.getHandValue());
		System.out.println("The dealer has: " + dealer.toString() + " and equal: " + dealer.getHandValue());
	}

//	public void isWinner() {
// if p is == to 21 p has blackjack
// if p <= 21 and is > d p wins
//if d <17 and p is <=21 d hits
// if d <= 21 and d > p d wins
// if d == to 21 d has black jack 
// if p == d its a tie 

//	}

	private void displayRules() {
		System.out.println(
				"\nBlackjack is an incredibly popular, exciting and easy card game to play. \nThe object is to have a hand with a total value higher than the dealer's without going over 21. \nKings, Queens, Jacks and Tens are worth a value of 10. An Ace has the value of 1 or 11. \nThe remaining cards are counted at face value.");
		System.out.println("\n*********************************HOW TO PLAY**************************************\n"
				+ "\nYou are dealt two cards, whilst the dealer is dealt one face up. \nIf your first 2 cards add up to 21 (an Ace and a card valued 10), that's Blackjack! \nIf they have any other total, decide whether you wish to 'draw' or 'stay'. \nYou can continue to draw cards until you are happy with your hand.");
		System.out.println(
				"\nOnce you have taken your turn the dealer draws another card for their hand. \nThey must draw until they reach 17 or more.");
		System.out.println(
				"Once all cards are drawn, whoever has a total closer to 21 wins. \nIf player's hand and dealer's hand have an equal value, it's a tie.");
		System.out.println("\nThen the process starts again. Lets get playing!\n");
	}

//  ************** MAIN *******************
	public static void main(String[] args) {
		BlackjackApp game = new BlackjackApp();
		game.run();
	}

}