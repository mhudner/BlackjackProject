package com.skilldistillery.blackjack.abstractcards;

public enum Suit {
  HEARTS("Hearts"), SPADES("Spades"), CLUBS("Clubs"), DIAMONDS("Diamonds");
  private String name;

  Suit(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }
}