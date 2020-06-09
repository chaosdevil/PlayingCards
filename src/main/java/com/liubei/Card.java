package com.liubei;

public class Card {
	// instance variables
	private final int rank;
	private final int suit;

	// constructor
	public Card(int rank, int suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public final String[] ranks = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };

	public final String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };

	public String toString() {
		return ranks[this.rank] + " of " + suits[this.suit];
	}

	public String[] add(String[] ranks, int index) {
		for (int i = 0; i <= index; i++) {
			ranks[i] = "Hello";
		}
		return ranks;
	}

	public boolean equals(Card that) {
		return this.rank == that.rank && this.suit == that.suit;
	}

	public int compareTo(Card that) {
		if (this.suit < that.suit) {
			return -1;
		}

		if (this.suit > that.suit) {
			return 1;
		}

		if (this.rank < that.rank) {
			return -1;
		}

		if (this.rank > that.rank) {
			return 1;
		}

		return 0;
	}

	public int getRank() {
		return this.rank;
	}

	public int getSuit() {
		return this.suit;
	}

	// public int setRank(int rank) {
	// this.rank = rank;
	// return this.rank;
	// }

	// public int setSuit(int suit) {
	// this.suit = suit;
	// return this.suit;
	// }

	// Unit testing
	public static void main(String[] args) {

	}
}