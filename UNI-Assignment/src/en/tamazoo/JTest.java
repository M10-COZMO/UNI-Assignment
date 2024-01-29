package en.tamazoo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JTest {
	
	@Test
	void testTamagotchi() {
		Tamagotchi tama = new Tamagotchi();
		tama.generateTamaValue();
		assertEquals(false, tama.death());
		
		tama.setSatiety(0);
		assertEquals(true, tama.death());
		
		tama.setSatiety(50);
		tama.setSatisfaction(0);
		assertEquals(true, tama.death());
		
		tama.increaseSatiety(50);
		int valueToTest = 50;
		for (int i = 0; i < 50; i++) {
			valueToTest += (valueToTest * 10)/100;
		}
		assertEquals(valueToTest, tama.getSatiety());
		assertEquals(valueToTest, tama.getSatisfaction());
	}
	

}
