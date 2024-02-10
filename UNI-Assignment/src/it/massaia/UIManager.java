package it.massaia;

import it.unibs.fp.mylib.InputDati;

public class UIManager {

	private static final String AVVIO_PROGRAMMA = "Avvio programma...";
	

	/**
	 * Vado a creare un ricettario con delle ricette
	 * @return il ricettario creato
	 */
	public Ricettario creaRicettario() {
		Ricettario ricettario = new Ricettario();
		
		// ricetta uno
		Ricetta r1 = new Ricetta("Margherita");
		r1.aggiungiIngrediente(new Ingrediente("Impasto", 50));
		r1.aggiungiIngrediente(new Ingrediente("Pomodoro", 25));
		r1.aggiungiIngrediente(new Ingrediente("Basilico", 5));
		r1.aggiungiIngrediente(new Ingrediente("Mzzarella", 40));
		r1.setPrimoPiatto(true);
		ricettario.aggiungiPrimo(r1);
		// ricetta due
		Ricetta r2 = new Ricetta("Pasta all'arrabbiata");
		r2.aggiungiIngrediente(new Ingrediente("Pasta", 75));
		r2.aggiungiIngrediente(new Ingrediente("Pomodoro", 25));
		r2.aggiungiIngrediente(new Ingrediente("Prezzemolo", 5));
		r2.aggiungiIngrediente(new Ingrediente("Peperoncino", 10));
		r2.setPrimoPiatto(true);
		ricettario.aggiungiPrimo(r2);
		// ricetta tre
		Ricetta r3 = new Ricetta("Bruschetta");
		r3.aggiungiIngrediente(new Ingrediente("Pomodorini", 8));
		r3.aggiungiIngrediente(new Ingrediente("olio", 2));
		r3.setPrimoPiatto(false);
		ricettario.aggiungiSecondo(r3);
		//ricetta quattro
		Ricetta r4 = new Ricetta("Cotoletta e Patate");
		r4.aggiungiIngrediente(new Ingrediente("Cotoletta", 50));
		r4.aggiungiIngrediente(new Ingrediente("Patate", 45));
		r4.setPrimoPiatto(false);
		ricettario.aggiungiSecondo(r4);
		
		return ricettario;
	}
	
	public void avvia() {
		System.out.println(AVVIO_PROGRAMMA);
		
		Ricettario r = creaRicettario();
		
		// interazione utente con menu
		int maxCalorie = InputDati.leggiIntero("Inserire la calorie masisme del menu: ");
		Ricetta[] menu = r.ricercaMenu(maxCalorie);
		if (menu[0] != null) {
			System.out.println("primo Piatto: ");
			menu[0].printRicetta();
			System.out.println("secondo piatto: ");
			menu[1].printRicetta();
		} else {
			System.out.println("Ricetta non trovata");
		}
		
		System.out.println("Fne programma");
	}
}
