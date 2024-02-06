package it.titoliazionari;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JTestLotto {

	@Test
	public void testCalcoloDelValoreTotale() {
		Titolo t1 = new Titolo("titolo1", 500);
		Titolo t2 = new Titolo("titolo2", 450);
		Titolo t3 = new Titolo("titolo3", 200);
		Lotto l1 = new Lotto("lotto1");
		l1.aggiungiTitolo(t1);
		l1.aggiungiTitolo(t2);
		l1.aggiungiTitolo(t3);
		int sommaValori = t1.getValore() + t2.getValore() + t3.getValore();
		assertEquals(sommaValori, l1.calcoloDelValoreTotale());
	}
	
	@Test
	public void testVariazioneTitoli() {
		Titolo t1 = new Titolo("titolo1", 500);
		Titolo t2 = new Titolo("titolo2", 450);
		Titolo t3 = new Titolo("titolo3", 200);
		Lotto l1 = new Lotto("lotto1");
		l1.aggiungiTitolo(t1);
		l1.aggiungiTitolo(t2);
		l1.aggiungiTitolo(t3);
		int sommaValori = t1.getValore() + t2.getValore() + t3.getValore();
		assertEquals(sommaValori, l1.calcoloDelValoreTotale());
		l1.variazioneTitoli();
		int sommaValoriDopoVariazione = t1.getValore() + t2.getValore() + t3.getValore();
		assertEquals(sommaValoriDopoVariazione, l1.calcoloDelValoreTotale());
	}

}
