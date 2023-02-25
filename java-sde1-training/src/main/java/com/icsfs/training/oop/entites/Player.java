package com.icsfs.training.oop.entites;

import java.util.Arrays;
import java.util.List;

public class Player {
	private String name;
	private int score;
	private List<Card> cards;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Player [name=");
		builder.append(name);
		builder.append(", score=");
		builder.append(score);
		builder.append(", cards=");
		builder.append(cards);
		builder.append("]");
		return builder.toString();
	}
}
