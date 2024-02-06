package it.titoliazionari;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JTestPortafoglio {

	@Test
	public void testCalcoloDelValoreTotale() {
		Titolo t1 = new Titolo("titolo1", 500);
		Titolo t2 = new Titolo("titolo2", 450);
		Titolo t3 = new Titolo("titolo3", 200);
		Lotto l1 = new Lotto("lotto1");
		Lotto l2 = new Lotto("lotto1");
		Portafoglio p1 = new Portafoglio("Portafoglio1");
		l1.aggiungiTitolo(t1);
		l1.aggiungiTitolo(t2);
		l2.aggiungiTitolo(t3);
		p1.aggiungiLotto(l1);
		p1.aggiungiLotto(l2);
		int sommaValori = t1.getValore() + t2.getValore() + t3.getValore();
		assertEquals(sommaValori, p1.calcoloValoreTotale());
	}
	
	@Test
	public void testVariazioneValoriLotti() {
		Titolo t1 = new Titolo("titolo1", 500);
		Titolo t2 = new Titolo("titolo2", 450);
		Titolo t3 = new Titolo("titolo3", 200);
		Lotto l1 = new Lotto("lotto1");
		Lotto l2 = new Lotto("lotto1");
		Portafoglio p1 = new Portafoglio("Portafoglio1");
		l1.aggiungiTitolo(t1);
		l1.aggiungiTitolo(t2);
		l2.aggiungiTitolo(t3);
		p1.aggiungiLotto(l1);
		p1.aggiungiLotto(l2);
		int sommaValori = t1.getValore() + t2.getValore() + t3.getValore();
		assertEquals(sommaValori, p1.calcoloValoreTotale());
		p1.variazioneValoriPortafoglio();
		int sommaValoriDopoVariazione = t1.getValore() + t2.getValore() + t3.getValore();
		assertEquals(sommaValoriDopoVariazione, p1.calcoloValoreTotale());
	}

}
