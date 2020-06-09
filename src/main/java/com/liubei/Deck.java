package com.liubei;

import java.util.Random;

public class Deck {

	// instance variable
	private Card[] cards;

	// constructor
	public Deck(int n) {
		this.cards = new Card[n];
	}

	// contructor
	public Deck() {
		this.cards = new Card[52]; // empty deck
		int index = 0;
		for (int suit = 0; suit <= 3; suit++) {
			for (int rank = 0; rank < 13; rank++) {
				this.cards[index] = new Card(rank, suit);
				index++;
			}
		}
	}

	public void print() {
		for (int i = 0; i < this.cards.length; i++) {
			System.out.println(this.cards[i]);
		}
	}

	public void swapCards(int i, int j) {
		Card temp = this.cards[i];
		this.cards[i] = this.cards[j];
		this.cards[j] = temp;
	}

	public void shuffle() {
		// choose random number between 0 - 51
		// swap cards[i] and cards[random]
		// until i > length - 1

		for (int i = 0; i < cards.length; i++) {
			Random random = new Random();
			int rand = random.nextInt(this.cards.length);

			swapCards(i, rand);
		}

	}

	public Deck subDeck(int low, int high) {
		Deck sub = new Deck(high - low + 1); // empty deck
		// deck.length = 7
		// sub.length = 4
		// sub.length = 2
		// sub.length = 1

		for (int i = 0; i < sub.cards.length; i++) {
			sub.cards[i] = this.cards[low + i];
		}
		return sub;
	}

	public static Deck merge(Deck d1, Deck d2) {
		// create new deck that is big enough for all cards
		int size = d1.cards.length + d2.cards.length;
		Deck result = new Deck(size);

		int i = 0; // i traces d1
		int j = 0; // j traces d2

		for (int k = 0; k < result.cards.length; k++) {
			if (i > d1.cards.length - 1) {
				// check if i greater than d1.cards.length
				result.cards[k] = d2.cards[j++];
			} else if (j > d2.cards.length - 1) {
				// check if j greater than d2.cards.length
				result.cards[k] = d1.cards[i++];
			} else {
				// check if both rules above don't meet
				if (d1.cards[i].compareTo(d2.cards[j]) < 0) {
					result.cards[k] = d1.cards[i++];
				} else {
					result.cards[k] = d2.cards[j++];
				}
			}
		}
		return result;
	}

	public Deck mergeSort() {
		// find midpoint
		// newdeck.mergeSort
		int low = 0;
		int high = this.cards.length - 1;

		int mid = (high + low) / 2;

		// check if this.cards.length == 1
		if (this.cards.length <= 1) {
			return this;
		}

		// divide deck into 2 subdecks
		Deck d1 = subDeck(low, mid);
		Deck d2 = subDeck(mid + 1, high);

		// sort deck using mergeSort
		d1 = d1.mergeSort();
		d2 = d2.mergeSort();

		// merge two subdecks into a deck and return the deck
		Deck result = merge(d1, d2);

		return result;
	}

	// selection sort
	// insertion sort

	// unit testing
	public static void main(String[] args) {

		Deck newdeck = new Deck(104); // empty deck
		int index = 0;

		for (int i = 0; i < newdeck.cards.length; i++) {
			if (newdeck.cards[i] == null) {
				for (int suit = 0; suit <= 3; suit++) {
					for (int rank = 0; rank < 13; rank++) {
						if (index <= newdeck.cards.length - 1) {
							newdeck.cards[index] = new Card(rank, suit);
							index++;
						} else {
							break;
						}
					}
				}
			}
			i = index;
		}

		// newdeck.print();
		System.out.println("Orignal deck");
		newdeck.print();

		System.out.println("\nShuffled deck\n");
		newdeck.shuffle();
		newdeck.print();

		System.out.println("\nSorting deck\n");
		Deck result = newdeck.mergeSort();
		result.print();
	}
}
