package it.corsaciclistica.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.corsaciclistica.Località;
import it.corsaciclistica.Tappa;

class TappaTest {

	@Test
	void calcoloDislivelloTest() {
		Tappa t = new Tappa();
		Località l1 = new Località("Jesi", 10, 0);
		Località l2 = new Località("Ancona", 0, 70);
		t.aggiungiLocalità(l1);
		t.aggiungiLocalità(l2);
		assertEquals(true, t.cercaUguali(new Località("Jesi", 10, 70)));
	}
	
	@Test
	void cambioNumeroDiGiriTest() {
		Tappa t = new Tappa();
		Località l1 = new Località("Jesi", 10, 0);
		Località l2 = new Località("Ancona", 0, 70);
		t.aggiungiLocalità(l1);
		t.aggiungiLocalità(l2);
		t.aggiungiLocalità(new Località("Jesi", 10, 70));
		t.setCircuito(true);
		t.setNumeroGiri(3);
		assertEquals(3, t.getNumeroGiri());
	}
	
	@Test
	void calcolaDistanzaTest() {
		Tappa t = new Tappa();
		Località l1 = new Località("Jesi", 10, 0);
		Località l2 = new Località("Ancona", 0, 70);
		t.aggiungiLocalità(l1);
		t.aggiungiLocalità(l2);
		int distanza = l1.getDistanzaDallaScorsaLocalita() + l2.getDistanzaDallaScorsaLocalita();
		assertEquals(distanza,  t.calcoloDistanzaTotale());
		t.aggiungiLocalità(new Località("Jesi", 10, 70));
		t.setCircuito(true);
		t.setNumeroGiri(3);
		assertEquals(420, t.calcoloDistanzaTotale());
	}
	
	@Test
	void calcolaDislivelloTest() {
		Tappa t = new Tappa();
		Località l1 = new Località("Jesi", 10, 0);
		Località l2 = new Località("Ancona", 0, 70);
		Località l3 = new Località("Senigallia", -1, 30);
		t.aggiungiLocalità(l1);
		t.aggiungiLocalità(l2);
		t.aggiungiLocalità(l3);
		int dislivello = l1.getAltezzaLivelloDelMare() + l2.getAltezzaLivelloDelMare() + l3.getAltezzaLivelloDelMare();
		assertEquals(dislivello, t.calcolaDislivello());
	}
	
	@Test
	void rimuoviLocalitaTest() {
		Tappa t = new Tappa();
		Località l1 = new Località("Jesi", 10, 0);
		Località l2 = new Località("Ancona", 0, 70);
		Località l3 = new Località("Senigallia", -1, 30);
		t.aggiungiLocalità(l1);
		t.aggiungiLocalità(l2);
		t.aggiungiLocalità(l3);
		assertEquals(3, t.getListaLocalita().size());
		t.rimuoviLocalità(l1);
		assertNotEquals(3, t.getListaLocalita().size());
	}
	
	@Test
	void AggiungiLocalitaTest() {
		Tappa t = new Tappa();
		Località l1 = new Località("Jesi", 10, 0);
		Località l2 = new Località("Ancona", 0, 70);
		Località l3 = new Località("Senigallia", -1, 30);
		t.aggiungiLocalità(l1);
		t.aggiungiLocalità(l2);
		assertEquals(2, t.getListaLocalita().size());
		t.aggiungiLocalità(l3);
		assertNotEquals(2, t.getListaLocalita().size());
	}
	
	@Test
	void sedeDiArrivoTest() {
		Tappa t = new Tappa();
		Località l1 = new Località("Jesi", 10, 0);
		Località l2 = new Località("Ancona", 0, 70);
		Località l3 = new Località("Senigallia", -1, 30);
		t.aggiungiLocalità(l1);
		t.aggiungiLocalità(l2);
		t.setSedeDiArrivo(l1.getNome());
		t.aggiungiLocalità(new Località("Jesi", 10, 0));
		assertEquals(t.getSedeDiArrivo(), t.getListaLocalita().get(2).getNome());
	}

}
