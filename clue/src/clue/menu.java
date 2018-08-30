package clue;

import java.util.InputMismatchException;
import java.util.Scanner;

public class menu {
	private int character;
	private char ch;

	public menu() {
		character = 0;
		ch = 'b';
	}

	public void rules() {
		Scanner k = new Scanner(System.in);
		System.out.println("Your job is to solve the mystery of who, where, and how?\n"
				+ "On your turn you can move up, down, left, and rigth.\n"
				+ "when you go into a room you make an assumption of who, and how it happened in that room.\n"
				+ "Once you've gather enough information you ccan make a guess. If you guess wrong then you're out of the game.\n"
				+ "If you guess right then you win");
		k.nextLine();
	}

	public String getCharacter() {
		switch (character) {
		case 0:
			ch = 'c';
			return "Colonel Mustard";
		case 1:
			ch = 'm';
			return "Professor Plum";
		case 2:
			ch = 'g';
			return "Mr. Green";
		case 3:
			ch = 'p';
			return "Mrs. Peacock";
		case 4:
			ch = 's';
			return "Miss Scarlett";
		case 5:
			ch = 'w';
			return "Mrs. White";
		default:
			ch = 'b';
			return "Mr. Black";
		}
	}

	public String getCharacter(int c) {
		switch (c) {
		case 0:
			ch = 'c';
			return "Colonel Mustard";
		case 1:
			ch = 'm';
			return "Professor Plum";
		case 2:
			ch = 'g';
			return "Mr. Green";
		case 3:
			ch = 'p';
			return "Mrs. Peacock";
		case 4:
			ch = 's';
			return "Miss Scarlett";
		case 5:
			ch = 'w';
			return "Mrs. White";
		default:
			ch = 'b';
			return "Mr. Black";
		}
	}

	public void setCharacter(int character) {
		this.character = character;
	}

	public void setCharacter() {
		Scanner k = new Scanner(System.in);
		System.out.println("Which charactor do you want to be?");
		for (int i = 0; i < 6; i++) {
			System.out.println((i + 1) + ") " + getCharacter(i));
		}
		try {
			character = k.nextInt();
			if (character < 1 || character > 6)
				setCharacter();
			character--;
		} catch (InputMismatchException e) {
			System.out.println(e.getMessage());
			setCharacter();
		}
	}

	public void playgame() {
		cards card = new cards(3);
		person[] p = new person[6];
		p[0] = new Col_Must(card);
		p[1] = new Prof_Plum(card);
		p[2] = new Mr_Green(card);
		p[3] = new Mrs_Pea(card);
		p[4] = new Miss_Scar(card);
		p[5] = new Mrs_White(card);
		// System.out.println();
		// System.out.println("Mr. Black");
		card.showcards('b');
		card.setCheck(ch);
		do{
		p[character].moveChar(card);
		}while(!card.isDone());
	}

}
