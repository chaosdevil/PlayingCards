package com.liubei;

import java.util.HashMap;

public class CardClient {
	public static void main(String[] args) {
		// Card card = new Card(0, 3);

		// System.out.println(card.toString());

		// Card card1 = new Card(1, 2);
		// Card card2 = new Card(2, 3);

		// System.out.println(card2.compareTo(card1));

		Card[] cards = new Card[52];
		int index = 0;

		for (int suit = 0; suit <= 3; suit++) {
			for (int rank = 0; rank < 13; rank++) {
				cards[index] = new Card(rank, suit);
				index++;
			}
		}

		// printDeck(cards);

		// System.out.println(linearSearch(cards, new Card(3, 0)));
		// System.out.println(linearSearchV2(cards, new Card(3, 0), 0, 0));

		HashMap<Integer, String> deck = new HashMap<>();
		for (int i = 0; i < cards.length; i++) {
			deck.put(i, cards[i].toString());
		}

		System.out.println(deck.size());

	}

	// public static String[] add(Card card, int index) {
	// for (int i = 0; i <= index; i++) {
	// card.ranks[i] = "Hello";
	// }
	// return card.ranks;
	// }

	public void printDeck(Card[] cards) {
		for (int i = 0; i < cards.length; i++) {
			System.out.println(cards[i]);
		}
	}

	// linear search / sequential search {1,2,3,4,5,6,7,8,9,10}
	// Worst case O(N) N = number of all elements in an array O(10)

	public static String linearSearch(Card[] cards, Card target) {
		int step = 1;
		for (int i = 0; i < cards.length; i++) {

			if (cards[i].equals(target)) {
				System.out.printf("Steps used: %d\n", step);
				return "Congratulations, we found " + target;
			}

			step++;
		}

		System.out.printf("Steps used: %d", step);
		return "Sorry, your targe nut found!";
	}

	public static String linearSearchV2(Card[] cards, Card target, int left, int step) {
		// cards 52 {.. } left++
		int n = cards.length;
		Card expectedCard = cards[left];
		// Card expectedCardRight = cards[right];

		if (left >= n) {
			return "Not found";
		}

		if (expectedCard.compareTo(target) == 0) {
			step = left;
			System.out.printf("Steps used: %d\n", step);
			return "Congratulations";
		}

		return linearSearchV2(cards, target, ++left, ++step);
	}

	// binary search
	public static String binarySearch(Card[] cards, Card target) {
		int low = 0;
		int high = cards.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;
			int comp = cards[mid].compareTo(target);

			if (comp == 0) {
				return "Congratulations, we found " + cards[mid];
			} else if (comp < 0) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return "Your card not found";
	}

	// binary search recursive version
	public static String binarySearchRecursive(Card[] cards, Card target, int low, int high) {
		if (high < low) {
			return "Failure! your card not found";
		}

		int mid = (low + high) / 2;
		int comp = cards[mid].compareTo(target);

		if (comp == 0) {
			return "Congratulations, we found " + cards[mid];
		} else if (comp < 0) {
			return binarySearchRecursive(cards, target, mid + 1, high);
		} else {
			return binarySearchRecursive(cards, target, low, mid - 1);
		}
	}

}
