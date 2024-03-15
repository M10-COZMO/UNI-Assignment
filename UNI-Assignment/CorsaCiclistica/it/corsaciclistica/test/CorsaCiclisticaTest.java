package it.corsaciclistica.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.corsaciclistica.CorsaCiclistica;
import it.corsaciclistica.Località;
import it.corsaciclistica.Tappa;

class CorsaCiclisticaTest {

	@Test
	void getDistanzaDiTest() {
		CorsaCiclistica corsa = new CorsaCiclistica();
		Tappa t1 = new Tappa();
		Località l1 = new Località("Jesi", 10, 0);
		Località l2 = new Località("Ancona", 0, 70);
		t1.aggiungiLocalità(l1);
		t1.aggiungiLocalità(l2);
		Tappa t2 = new Tappa();
		Località l3 = new Località("Senigallia", -1, 0);
		Località l4 = new Località("Marzocca", 2, 30);
		t2.aggiungiLocalità(l3);
		t2.aggiungiLocalità(l4);
		corsa.aggiungiTappa(t1);
		corsa.aggiungiTappa(t2);
		assertEquals(t1.calcoloDistanzaTotale(), corsa.getDistanzaDi(0));
	}
	
	@Test
	void aggiungiTappaTest() {
		CorsaCiclistica corsa = new CorsaCiclistica();
		Tappa t1 = new Tappa();
		Località l1 = new Località("Jesi", 10, 0);
		Località l2 = new Località("Ancona", 0, 70);
		t1.aggiungiLocalità(l1);
		t1.aggiungiLocalità(l2);
		corsa.aggiungiTappa(t1);
		assertEquals(1, corsa.getListaTappe().size());
		Tappa t2 = new Tappa();
		Località l3 = new Località("Senigallia", -1, 0);
		Località l4 = new Località("Marzocca", 2, 30);
		t2.aggiungiLocalità(l3);
		t2.aggiungiLocalità(l4);
		corsa.aggiungiTappa(t2);
		assertNotEquals(1, corsa.getListaTappe().size());
	}

	@Test
	void rimuoviTappaTest() {
		CorsaCiclistica corsa = new CorsaCiclistica();
		Tappa t1 = new Tappa();
		Località l1 = new Località("Jesi", 10, 0);
		Località l2 = new Località("Ancona", 0, 70);
		t1.aggiungiLocalità(l1);
		t1.aggiungiLocalità(l2);
		corsa.aggiungiTappa(t1);
		Località l3 = new Località("Senigallia", -1, 0);
		Località l4 = new Località("Marzocca", 2, 30);
		Tappa t2 = new Tappa();
		t2.aggiungiLocalità(l3);
		t2.aggiungiLocalità(l4);
		corsa.aggiungiTappa(t2);
		assertEquals(2, corsa.getListaTappe().size());
		corsa.rimuoviTappa(0);
		assertNotEquals(2, corsa.getListaTappe().size());
	}

}
