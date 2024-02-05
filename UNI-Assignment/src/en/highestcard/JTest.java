package en.highestcard;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JTest {

	@Test
	public void test() {
		User user = new User();
		Game game = new Game(user);
		int chooseDeck = 1;
		assertEquals(0, game.getChoosenDeck());
	}
}
