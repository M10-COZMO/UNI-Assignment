package en.highestcard;

public class Main {

	public static void main(String[] args) {
		
		User user = new User();
		Game game = new Game(user);
		game.startGame();
		

	}

}
