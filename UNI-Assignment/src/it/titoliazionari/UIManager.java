package it.titoliazionari;

import java.util.*;

import en.tamagotchi.Menu;

public class UIManager {
	
	
	
	private static final String CHIEDI_PROSSIMA_GIORNATA = "Passare alla porssima giornata?";
	private static final String PROGRAMMA_TERMINATO = "Programma Terminato";
	private static final int GIORNO_INIZIALE = 0;
	private static final String TITOLI_PER_OGNI_LOTTO = "Per ogni lotto inserire il numero di titoli";
	private static final String CHIEDI_NUMERO_TITOLI_NEL_LOTTO = "Inserire il numero di titoli ma mettere nel lotto ";
	private static final String CHIEDI_NUMERO_LOTTI_NEL_PORTAOFOGLIO = "Inserire il numero di lotti da mettere allinterno del portafolgio:";
	private static final String CHIEDI_NOME_PORTAFOGLIO = "Inserire un nome per il portafoglio:";
	private static final String INIZIO_PROGRAMMA = "Avvio gestione Titoli Azionari...";
	private static final String FRECCIA = "-->";

	public void inizio() {
		Portafoglio portafoglio = new Portafoglio();
		Variazione variazione = new Variazione(GIORNO_INIZIALE, portafoglio);
		System.out.println(INIZIO_PROGRAMMA);
		
		inserisciNomePortafolgio(portafoglio);
		
		inserisciNumeroLottiNelPortafoglio(portafoglio);
		
		inserisciNumeroTitoliPerLotto(portafoglio);
		
		giornate(variazione);
		
		System.out.println(PROGRAMMA_TERMINATO);
	}

	private void giornate(Variazione variazione) {
		Scanner in = new Scanner(System.in);
		boolean proseguire = true;
		Menu menu = new Menu();
		menu.setTitle("SCEGLI");
		menu.addVoice("no");
		menu.addVoice("si");
		do {
			variazione.getPortafoglio().getInfo();
			System.out.println(CHIEDI_PROSSIMA_GIORNATA);
			menu.printMenu();
			int scelta = in.nextInt();
			if (scelta == 0) {
				proseguire = false;
			} else {
				variazione.passaGiorno();
			}
		} while (proseguire == true);
	}

	private void inserisciNumeroTitoliPerLotto(Portafoglio portafoglio) {
		Scanner in = new Scanner(System.in);
		System.out.println(TITOLI_PER_OGNI_LOTTO);
		for(int i = 0; i < portafoglio.getListaLotti().size(); i++) {
			System.out.println(CHIEDI_NUMERO_TITOLI_NEL_LOTTO + i + ": ");
			System.out.print(FRECCIA);
			int numeroTitoli = in.nextInt();
			Random random = new Random();
			int valoreTitoliDelLotto = random.nextInt(500)+1;
			for (int j = 0; j < numeroTitoli; j++) {
				Titolo l = new Titolo("titolo "+j, valoreTitoliDelLotto);
				portafoglio.getListaLotti().get(i).aggiungiTitolo(l);
			}
		}
	}

	private void inserisciNumeroLottiNelPortafoglio(Portafoglio portafoglio) {
		Scanner in = new Scanner(System.in);
		System.out.println(CHIEDI_NUMERO_LOTTI_NEL_PORTAOFOGLIO);
		System.out.print(FRECCIA);
		int numeroLotti = in.nextInt();
		for (int i = 0; i < numeroLotti; i++) {
			Lotto l = new Lotto("Lotto "+i);
			portafoglio.aggiungiLotto(l);
		}
		portafoglio.getInfo();
	}

	private void inserisciNomePortafolgio(Portafoglio portafoglio) {
		Scanner in = new Scanner(System.in);
		System.out.println(CHIEDI_NOME_PORTAFOGLIO);
		System.out.print(FRECCIA);
		String nome = in.next();
		portafoglio.setNome(nome);
	}
}
