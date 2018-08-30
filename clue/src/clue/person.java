package clue;

public abstract class person {
	private String name;
	private char character;
	private int[] where = new int[2];
	cards card;

	public person() {
		setName("Mr. Black");
		character = 'b';
		card.setcard(3, 'b');
		where[0] = 17;
		where[1] = 17;
	}

	public person(String nam, char ch, cards c, int x, int y) {
		setName(nam);
		character = ch;
		where[0] = x;
		where[1] = y;
		c.setchar(where[0], where[1], ch);
	}

	public char getchar() {
		return character;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int[] getWhere() {
		return where;
	}

	public void setWhere(int x, int y) {
		where[0] = x;
		where[1] = y;
	}

	abstract public void getcards(cards c);

	abstract public char getcard(int x, cards c);
	
	abstract public void moveChar(cards c);
}
