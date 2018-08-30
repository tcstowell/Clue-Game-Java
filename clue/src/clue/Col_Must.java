package clue;

import java.util.Random;
import java.util.Scanner;

public class Col_Must extends person {
	final private static char who = 'c';

	public Col_Must(cards c) {
		super("Colonel Mustard", who, c, 7, 24);
		c.setcards(3, this);
	}

	@Override
	public void getcards(cards c) {
		c.showcards(who);
	}

	@Override
	public char getcard(int x, cards c) {
		return c.getcard(x);
	}

	public char getchar() {
		return super.getchar();
	}

	public String getName() {
		return super.getName();
	}

	public void moveChar(cards c) {
		Scanner k = new Scanner(System.in);
		int roll;
		int[] where;
		Random r = new Random();
		roll = r.nextInt(10) + 50;// 2;
		c.getBoard();
		c.moveRoom(this);
		do {
			System.out.println("can move " + roll + " spaces");
			System.out.println("e) move up\n" + "s) move left d) secret passage f) move right\n" + "c) move backwards");
			where = super.getWhere();
			switch (k.next()) {
			case "e":
				if (where[0] - 1 >= 0 && c.getBoard(where[0] - 1, where[1]) != '|'
						&& c.getBoard(where[0] - 1, where[1]) != '-' && c.getBoard(where[0] - 1, where[1]) != ' ') {
					c.setchar(where[0] - 1, where[1], who);
					c.fixBoard(where[0], where[1]);
					super.setWhere(where[0] - 1, where[1]);
					roll--;
				}
				break;
			case "s":
				if (where[1] - 1 >= 0 && c.getBoard(where[0], where[1] - 1) != '|'
						&& c.getBoard(where[0], where[1] - 1) != '-' && c.getBoard(where[0], where[1] - 1) != ' ') {
					c.setchar(where[0], where[1] - 1, who);
					c.fixBoard(where[0], where[1]);
					super.setWhere(where[0], where[1] - 1);
					roll--;
				}
				break;
			case "d":
				switch (c.getBoard(where[0], where[1], 1)) {
				case 'C':
					c.setchar(5, 19, who);
					c.fixBoard(where[0], where[1]);
					super.setWhere(5, 19);
					roll = 0;
					break;
				case 'K':
					c.setchar(3, 6, who);
					c.fixBoard(where[0], where[1]);
					super.setWhere(3, 6);
					roll = 0;
					break;
				case 'S':
					c.setchar(18, 20, who);
					c.fixBoard(where[0], where[1]);
					super.setWhere(18, 20);
					roll = 0;
					break;
				case 'O':
					c.setchar(19, 5, who);
					c.fixBoard(where[0], where[1]);
					super.setWhere(19, 5);
					roll = 0;
					break;
				}
				break;
			case "f":
				if (where[1] + 1 < 25 && c.getBoard(where[0], where[1] + 1) != '|'
						&& c.getBoard(where[0], where[1] + 1) != '-' && c.getBoard(where[0], where[1] + 1) != ' ') {
					c.setchar(where[0], where[1] + 1, who);
					c.fixBoard(where[0], where[1]);
					super.setWhere(where[0], where[1] + 1);
					roll--;
				}
				break;
			case "c":
				if (where[0] + 1 < 27 && c.getBoard(where[0] + 1, where[1]) != '|'
						&& c.getBoard(where[0] + 1, where[1]) != '-' && c.getBoard(where[0] + 1, where[1]) != ' ') {
					c.setchar(where[0] + 1, where[1], who);
					c.fixBoard(where[0], where[1]);
					super.setWhere(where[0] + 1, where[1]);
					roll--;
				}
				break;
			default:

			}
			if (!c.isDone()) {
				c.getBoard();
			}
			if (c.isRoom(where[0], where[1]) && !c.isDone()) {
				c.makeGuess(c.getBoard(where[0], where[1], 1), this);
				c.informcard();
				roll = 0;
			}
		} while (roll > 0);
	}
}
