package clue;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class cards {
	Random r = new Random();
	private final int name = 6;
	private final int weap = 12;
	private final int room = 21;
	private static boolean done = false;
	private char[] check = new char[21];
	private char[] cards = new char[21];
	private char[][][] board = new char[27][25][2];
	private final String[] form = { "Colonel Mustard\t", "Professor Plum\t", "Mr. Green\t\t", "Mrs. Peacock\t\t",
			"Miss Scarlett\t", "Mrs. White\t\t", "knife\t\t", "candlestick\t\t", "revolver\t\t", "rope\t\t",
			"lead pipe\t\t", "pipe wrench\t\t", "Hall\t\t", "Lounge\t\t", "Dining Room\t\t", "Kitchen\t\t",
			"Ballroom\t\t", "Conservatory\t", "Billiard Room\t", "Library\t\t", "Study\t\t" };

	public cards() {
		for (int i = 0; i < cards.length; i++) {
			cards[i] = 'n';
			check[i] = 'n';
		}
		setcards(3, 'b');
		createBoard();
	}

	public cards(int num) {
		for (int i = 0; i < cards.length; i++) {
			cards[i] = 'n';
			check[i] = 'n';
		}
		setcards('b');
		createBoard();
	}

	public cards(int num, char who) {
		for (int i = 0; i < cards.length; i++) {
			cards[i] = 'n';
			check[i] = 'n';
		}
		setcards(num, who);
	}

	public cards(int num, person p) {
		for (int i = 0; i < cards.length; i++) {
			cards[i] = 'n';
			check[i] = 'n';
		}
		setcards(num, p.getchar());
	}

	public void setcards(char who) {
		int rand;
		for (int i = 0; i < 1; i++) {
			rand = r.nextInt(21) % 6;
			if (getcard(rand) == 'n') {
				setcard(rand, who);
			} else
				i--;
		}
		for (int i = 0; i < 1; i++) {
			rand = (r.nextInt(21) % 6) + name;
			if (getcard(rand) == 'n') {
				setcard(rand, who);
			} else
				i--;
		}
		for (int i = 0; i < 1; i++) {
			rand = (r.nextInt(21) % 9) + weap;
			if (getcard(rand) == 'n') {
				setcard(rand, who);
			} else
				i--;
		}
	}

	public void setcards(int num, person p) {
		int rand;
		for (int i = 0; i < num; i++) {
			rand = r.nextInt(21);
			if (getcard(rand) == 'n' && p.getcard(rand, this) == 'n') {
				setcard(rand, p.getchar());
			} else
				i--;
		}
	}

	public void setcards(int num, char who) {
		int rand;
		for (int i = 0; i < num; i++) {
			rand = r.nextInt(21);
			if (getcard(rand) == 'n') {
				setcard(rand, who);
			} else
				i--;
		}
	}

	public char getcard(int x) {
		if (x < 21 || x >= 0)
			return cards[x];
		else
			return 'n';
	}

	public void showcards(char who) {
		for (int i = 0; i < cards.length; i++) {
			if (cards[i] == who)
				System.out.println(form[i]);
		}
	}

	public void setcard(int x, char set) {
		cards[x] = set;
	}

	public void setCheck(char c) {
		for (int i = 0; i < 21; i++) {
			if (cards[i] == c)
				check[i] = cards[i];
		}
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean d) {
		done = d;
	}

	public void makeGuess(char room, person p) {
		boolean t = false;
		int win;
		win = 0;
		int[] n = new int[3];
		int i = 0;
		switch (room) {
		case 'H':
			n[2] = 12;
			System.out.println(form[12]);
			break;
		case 'O':
			n[2] = 13;
			System.out.println(form[13]);
			break;
		case 'D':
			n[2] = 14;
			System.out.println(form[14]);
			break;
		case 'K':
			n[2] = 15;
			System.out.println(form[15]);
			break;
		case 'A':
			n[2] = 16;
			System.out.println(form[16]);
			break;
		case 'C':
			n[2] = 17;
			System.out.println(form[17]);
			break;
		case 'B':
			n[2] = 18;
			System.out.println(form[18]);
			break;
		case 'L':
			n[2] = 19;
			System.out.println(form[19]);
			break;
		case 'S':
			n[2] = 20;
			System.out.println(form[20]);
			break;
		default:
			n[2] = 21;
			System.out.println(form[21]);
		}
		System.out.println("Who is your suspect?");
		for (i = 0; i < name; i++) {
			System.out.print(i + 1 + ") " + form[i]);
			System.out.print(check[i] + "\t");
			System.out.println();
		}
		while (!t) {
			try {
				n[0] = new Scanner(System.in).nextInt() - 1;
				if (n[0] >= 0 && n[0] < 6)
					t = true;
			} catch (InputMismatchException e) {
				System.out.println("Not Valid input");
			}
		}
		System.out.println("What weapon did they use?");
		for (i = name; i < weap; i++) {
			System.out.print(i + 1 - name + ") " + form[i]);
			System.out.print(check[i] + "\t");
			System.out.println();
		}
		t = false;
		while (!t) {
			try {
				n[1] = new Scanner(System.in).nextInt() + name - 1;
				if (n[1] >= name && n[1] < 6 + name)
					t = true;
			} catch (InputMismatchException e) {
				System.out.println("Not Valid input");
			}
		}
		if (cards[n[0]] != 'b') {
			check[n[0]] = cards[n[0]];
		} else {
			check[n[0]] = '?';
			win++;
		}
		if (cards[n[1]] != 'b') {
			check[n[1]] = cards[n[1]];
		} else {
			check[n[1]] = '?';
			win++;
		}
		if (cards[n[2]] != 'b') {
			check[n[2]] = cards[n[2]];
		} else {
			check[n[2]] = '?';
			win++;
		}
		if (win > 2) {
			System.out.println("You guessed right\n" + "YOU WIN!");
			setDone(true);
		}
	}

	public void setchar(int x, int y, char c) {
		board[x][y][0] = c;
	}

	public boolean isRoom(int x, int y) {
		if (board[x][y][1] == 'A' || board[x][y][1] == 'B' || board[x][y][1] == 'C' || board[x][y][1] == 'D'
				|| board[x][y][1] == 'H' || board[x][y][1] == 'K' || board[x][y][1] == 'L' || board[x][y][1] == 'O'
				|| board[x][y][1] == 'S') {
			return true;
		} else
			return false;
	}

	public void moveRoom(person who) {
		Scanner k = new Scanner(System.in);
		int[] w = who.getWhere();
		if (board[w[0]][w[1]][1] == 'A' || board[w[0]][w[1]][1] == 'B' || board[w[0]][w[1]][1] == 'C'
				|| board[w[0]][w[1]][1] == 'D' || board[w[0]][w[1]][1] == 'H' || board[w[0]][w[1]][1] == 'K'
				|| board[w[0]][w[1]][1] == 'L' || board[w[0]][w[1]][1] == 'O' || board[w[0]][w[1]][1] == 'S') {
			System.out.println("e) move up\n" + "s) move left d) secret passage f) move right\n" + "c) move backwards");
			switch (k.next()) {
			case "e":
				switch (getBoard(w[0], w[1], 1)) {
				case 'B':
					setchar(12, 1, who.getchar());
					fixBoard(w[0], w[1]);
					who.setWhere(12, 1);
					break;
				case 'C':
					setchar(19, 5, who.getchar());
					fixBoard(w[0], w[1]);
					who.setWhere(19, 5);
					break;
				case 'A':
					System.out.println("s) move left f) move right\n");
					if (k.next().charAt(0) == 's') {
						setchar(17, 10, who.getchar());
						fixBoard(w[0], w[1]);
						who.setWhere(17, 10);
					} else {
						setchar(17, 15, who.getchar());
						fixBoard(w[0], w[1]);
						who.setWhere(17, 15);
					}
					break;
				case 'K':
					setchar(18, 20, who.getchar());
					fixBoard(w[0], w[1]);
					who.setWhere(18, 20);
					break;
				case 'D':
					setchar(9, 18, who.getchar());
					fixBoard(w[0], w[1]);
					who.setWhere(9, 18);
					break;
				default:
				}
				break;
			case "s":
				switch (getBoard(w[0], w[1], 1)) {
				case 'H':
					setchar(4, 10, who.getchar());
					fixBoard(w[0], w[1]);
					who.setWhere(4, 10);
					break;
				case 'A':
					setchar(19, 9, who.getchar());
					fixBoard(w[0], w[1]);
					who.setWhere(19, 9);
					break;
				case 'D':
					setchar(12, 17, who.getchar());
					fixBoard(w[0], w[1]);
					who.setWhere(12, 17);
					break;
				default:
				}
				break;
			case "d":
				switch (getBoard(w[0], w[1], 1)) {
				case 'C':
					setchar(5, 19, who.getchar());
					fixBoard(w[0], w[1]);
					who.setWhere(5, 19);
					break;
				case 'K':
					setchar(3, 6, who.getchar());
					fixBoard(w[0], w[1]);
					who.setWhere(3, 6);
					break;
				case 'S':
					setchar(18, 20, who.getchar());
					fixBoard(w[0], w[1]);
					who.setWhere(18, 20);
					break;
				case 'O':
					setchar(19, 5, who.getchar());
					fixBoard(w[0], w[1]);
					who.setWhere(19, 5);
					break;
				default:
				}
				break;
			case "f":
				switch (getBoard(w[0], w[1], 1)) {
				case 'L':
					setchar(8, 7, who.getchar());
					fixBoard(w[0], w[1]);
					who.setWhere(8, 7);
					break;
				case 'B':
					setchar(15, 6, who.getchar());
					fixBoard(w[0], w[1]);
					who.setWhere(15, 6);
					break;
				case 'C':
					setchar(19, 5, who.getchar());
					fixBoard(w[0], w[1]);
					who.setWhere(19, 5);
					break;
				case 'A':
					setchar(19, 16, who.getchar());
					fixBoard(w[0], w[1]);
					who.setWhere(19, 16);
					break;
				default:
				}
				break;
			case "c":
				switch (getBoard(w[0], w[1], 1)) {
				case 'S':
					setchar(3, 6, who.getchar());
					fixBoard(w[0], w[1]);
					who.setWhere(3, 6);
					break;
				case 'H':
					System.out.println("s) move left f) move right\n");
					if (k.next().charAt(0) == 's') {
						setchar(6, 12, who.getchar());
						fixBoard(w[0], w[1]);
						who.setWhere(6, 12);
					} else {
						setchar(6, 13, who.getchar());
						fixBoard(w[0], w[1]);
						who.setWhere(6, 13);
					}
					break;
				case 'O':
					setchar(5, 19, who.getchar());
					fixBoard(w[0], w[1]);
					who.setWhere(5, 19);
					break;
				case 'L':
					setchar(10, 3, who.getchar());
					fixBoard(w[0], w[1]);
					who.setWhere(10, 3);
					break;
				default:
				}
				break;
			default:

			}
			getBoard();
		}
	}

	public void informcard() {
		int i;
		for (i = 0; i < name; i++) {
			System.out.print(i + 1 + ") " + form[i]);
			System.out.print(check[i] + "\t");
			System.out.println();
		}
		System.out.println();
		for (i = name; i < weap; i++) {
			System.out.print(i + 1 + ") " + form[i]);
			System.out.print(check[i] + "\t");
			System.out.println();
		}
		System.out.println();
		for (i = weap; i < room; i++) {
			System.out.print(i + 1 + ") " + form[i]);
			System.out.print(check[i] + "\t");
			System.out.println();
		}

	}

	public char getBoard(int x, int y) {
		return board[x][y][0];
	}

	public char getBoard(int x, int y, int z) {
		return board[x][y][z];
	}

	public void getBoard() {
		int i, j;
		for (i = 0; i < 27; i++) {
			for (j = 0; j < 25; j++) {
				System.out.print(board[i][j][0] + "  ");
			}
			System.out.println();
		}

	}

	public void fixBoard(int x, int y) {
		board[x][y][0] = board[x][y][1];
	}

	public void createBoard() {
		int i, j;
		for (i = 0; i < 27; i++) {
			for (j = 0; j < 25; j++) {
				if ((i > 0 && i < 26 && j > 0 && j < 24) || ((i == 5 || i == 18) && j == 0)
						|| (i == 26 && (j == 10 || j == 15)) || (i == 0 && (j == 8 || j == 17))
						|| (j == 24 && (i == 7 || i == 17)))
					board[i][j][0] = '%';
				else
					board[i][j][0] = ' ';
				if (i > 0 && i < 4 && j > 0 && j < 7)
					board[i][j][0] = 'S';
				if (i > 0 && i < 7 && j > 9 && j < 15)
					board[i][j][0] = 'H';
				if (i > 6 && i < 10 && j > 0 && j < 8)
					board[i][j][0] = 'L';
				if (i > 0 && i < 6 && j > 18 && j < 24)
					board[i][j][0] = 'O';
				if (i > 8 && i < 14 && j > 10 && j < 14)
					board[i][j][0] = '?';
				if (i > 8 && i < 15 && j > 16 && j < 24)
					board[i][j][0] = 'D';
				if (i > 11 && i < 16 && j > 0 && j < 7)
					board[i][j][0] = 'B';
				if (i > 18 && i < 25 && j < 6 && j > 0)
					board[i][j][0] = 'C';
				if (i > 16 && i < 25 && j < 17 && j > 8)
					board[i][j][0] = 'A';
				if (i > 17 && i < 25 && j < 24 && j > 19)
					board[i][j][0] = 'K';
			}
		}
		board[10][3][0] = 'L';
		for (i = 0; i < 27; i++) {
			if (i < 4 || (i > 6 && i < 10) || (i > 11 && i < 17) || (i > 19 && i < 26))
				board[i][0][0] = '|';
			if ((i > 11 && i < 15) || i == 16 || (i > 19 && i < 26))
				board[i][6][0] = '|';
			if ((i > 0 && i < 4) || i == 7 || i == 9)
				board[i][7][0] = '|';
			if ((i > 16 && i < 19) || (i > 19 && i < 25))
				board[i][9][0] = '|';
			if ((i > 0 && i < 4) || (i > 4 && i < 7) || (i > 7 && i < 15))
				board[i][10][0] = '|';
			if ((i > 7 && i < 15))
				board[i][14][0] = '|';
			if ((i > 0 && i < 6))
				board[i][15][0] = '|';
			if ((i > 16 && i < 19) || (i > 19 && i < 25))
				board[i][16][0] = '|';
			if ((i > 8 && i < 12) || (i > 12 && i < 15))
				board[i][17][0] = '|';
			if (i < 6)
				board[i][18][0] = '|';
			if (i > 17 && i < 26)
				board[i][19][0] = '|';
			if (i < 6 || (i > 8 && i < 16) || (i > 17 && i < 26))
				board[i][24][0] = '|';
		}
		for (j = 0; j < 25; j++) {
			if (j < 7 || (j > 10 && j < 15) || j > 17)
				board[0][j][0] = '-';
			if (j < 6)
				board[3][j][0] = '-';
			if (j > 19 && j < 27)
				board[5][j][0] = '-';
			if ((j > 0 && j < 7) || (j > 9 && j < 12) || (j > 13 && j < 16))
				board[6][j][0] = '-';
			if ((j > 9 && j < 15))
				board[8][j][0] = '-';
			if ((j > 18 && j < 25))
				board[9][j][0] = '-';
			if ((j > 0 && j < 3) || (j > 3 && j < 7))
				board[10][j][0] = '-';
			if ((j > 1 && j < 7) || j == 0)
				board[12][j][0] = '-';
			if ((j > 9 && j < 15) || (j > 16 && j < 20))
				board[14][j][0] = '-';
			if ((j > 19 && j < 25))
				board[15][j][0] = '-';
			if (j < 7)
				board[16][j][0] = '-';
			if ((j > 10 && j < 15))
				board[17][j][0] = '-';
			if ((j > 20 && j < 25))
				board[18][j][0] = '-';
			if ((j > 0 && j < 5))
				board[19][j][0] = '-';
			if ((j > 8 && j < 11) || (j > 14 && j < 17))
				board[24][j][0] = '-';
			if (j < 7 || (j > 10 && j < 15) || j > 18)
				board[25][j][0] = '-';
		}
		for (i = 0; i < 27; i++) {
			for (j = 0; j < 25; j++) {
				board[i][j][1] = board[i][j][0];
			}
		}
	}
}
