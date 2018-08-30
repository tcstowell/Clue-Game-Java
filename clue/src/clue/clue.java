package clue;

public class clue {
	public static void main(String[] args) {
		menu m = new menu();
		m.setCharacter();
		System.out.println("Welcome, " + m.getCharacter() + "!");
		System.out.println("Glad you could join us to solve this Mystery.");
//		m.rules();
		m.playgame();
	}
}
