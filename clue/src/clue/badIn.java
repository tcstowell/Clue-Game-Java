package clue;

public class badIn extends Exception{
	public badIn(int n){
		super("Not a given option");
	}
	public badIn(){
		super("Bad Input Exception");
	}
	public badIn(String m){
		super(m);
	}
}
