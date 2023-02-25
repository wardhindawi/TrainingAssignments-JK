package com.icsfs.training.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.icsfs.training.oop.entites.Card;
import com.icsfs.training.oop.entites.Game;
import com.icsfs.training.oop.entites.Player;
import com.icsfs.training.oop.service.CardGameService;

public class Day3Practice {

	private static CardGameService cardGameService = new CardGameService();
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		Game game = new Game();
		Player player[] = new Player[4];

		System.out.println("Please Enter Game Name: ");
		game.setName(input.nextLine());

		for (int index = 0; index < player.length; index++) {
			player[index] = cardGameService.enterPlayerName(index);
		}

		List<Card> cards = cardGameService.shuffleCardsDeck();
		game.setPlayers(player);

		for (int index = 0; index < 4; index++) {
			List<Card> tempCards = new ArrayList<Card>();

			for (int i = 0; i < 13; i++) {
				tempCards.add(cards.get(0));
				cards.remove(0);

			}
			game.getPlayers()[index].setCards(tempCards);
		}

		cardGameService.printGameInfo(game);

	}

}
