package com.icsfs.training.oop.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.icsfs.training.oop.entites.Card;
import com.icsfs.training.oop.entites.CardType;
import com.icsfs.training.oop.entites.Game;
import com.icsfs.training.oop.entites.Player;

public class CardGameService {
	private static Scanner input = new Scanner(System.in);

	public void printGameInfo(Game game) {
		System.out.println("Game name: " + game.getName());

		for (Player player : game.getPlayers()) {
			System.out.println("Player " + player.getName() + " cards: " + player.getCards());

		}

	}

	public Player enterPlayerName(int index) {
		System.out.println("Please Enter player Name " + (index + 1) + ": ");
		Player playerObj = new Player();
		playerObj.setName(input.nextLine());
		return playerObj;
	}

	public List<Card> shuffleCardsDeck() {
		List<Card> cards = new ArrayList<>();

		int cardTypeFlag = 0;

		for (int i = 1; i < 53; i++) {
			Card card = new Card();
			card.setNumber(i);

			if (i == 14)
				cardTypeFlag = 1;
			else if (i == 27)
				cardTypeFlag = 2;
			else if (i == 40)
				cardTypeFlag = 3;

			switch (cardTypeFlag) {
			case 0:
				card.setType(CardType.CLUBS);
				break;
			case 1:
				card.setType(CardType.DIAMONDS);
				break;
			case 2:
				card.setType(CardType.HEARTS);
				break;
			case 3:
				card.setType(CardType.SPADES);
				break;

			default:
				break;
			}

			cards.add(card);

		}

		Collections.shuffle(cards);

		return cards;

	}
}
