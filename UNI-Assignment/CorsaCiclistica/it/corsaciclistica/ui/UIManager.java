package it.corsaciclistica.ui;

import it.corsaciclistica.CorsaCiclistica;
import it.corsaciclistica.Località;
import it.corsaciclistica.SedeDiArrivoException;
import it.corsaciclistica.Tappa;
import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;

public class UIManager {
	
	private static final String CHIEDI_SEDE_DI_ARRIVO = "E' necessario inserire il nome della città della sede di arrivo";
	private static final String CHIEDI_NUMERO_DI_GIRI_DEL_CIRCUITO = "Inserire il numero di giri: ";
	private static final String CHIEDI_SE_LA_TAPPA_E_CIRCUITO = "La tappa è un circuito?";
	private static final String CHIEDI_CANCELLARE_LOCALITA = "si desidera cancellare la località appena inserita?";
	private static final String LOCALITA_GIA_PRESENTE = "La località è già presente nella mappa.";
	private static final String CHIEDI_DISTANZA_LOCALITA = "Inserire la distanza dalla scorsa località (se è la prima inserire 0)";
	private static final String CHIEDI_DISLIVELLO_DAL_MARE = "Dislivello dal mare: ";
	private static final String CHIEDI_QUANTITA_LOCALITA_DELLA_TAPPA = "Inserire il numero di località dentro la tappa: ";
	private static final String CHIEDI_NOME_TAPPA = "Inserisci il nome della tappa: ";
	private static final String SCELGLIERE_LA_TAPPA_DA_ELIMINARE = "Scelgliere la tappa da eliminare: ";
	private static final String MSG_INIZIALE = "Avvio del programma in corso...";
	private static final String[] MENU_VOCI = {"aggiungi tappa", "rimuovi tappa", "distanza della tappa", "informazioni della tappa", "dati globali della corsa"};
	private static final String MENU_TITOLO = "Scegli tra: ";
	private static final String ARROW = "-->";
	private static final String FINE_PROGRAMMA = "PROGRAMMA TERMINATO";
	private static final String SCELGLIERE_LA_TAPPA = "Scegliere la tappa: ";

	public void avvio() {
		MyMenu menu = new MyMenu(MENU_TITOLO, MENU_VOCI);
		CorsaCiclistica corsa = new CorsaCiclistica();
		boolean fine = false;
		
		System.out.println(MSG_INIZIALE);
		
		do {
			menu.stampaMenu();
			int scelta = InputDati.leggiIntero(ARROW);
			
			switch (scelta) {
			// aggiungi una tappa
			case 1:
				try {
					aggiungereUnaTappa(corsa);
				} catch (SedeDiArrivoException e) {
					e.printStackTrace();
				}
				break;
			// rimuovi una tappa
			case 2:
				rimuoviTappa(corsa);
				break;
			// distanza della tappa
			case 3:
				distanzaDellaTappa(corsa);
				break;
			// informazioni della tappa
			case 4:
				System.out.println(corsa.stampaTappe());
				System.out.println(SCELGLIERE_LA_TAPPA);
				System.out.println(corsa.getInfoDi(scelta));
				break;
			// dati globali della corsa
			case 5:
				System.out.println(corsa.stampaInfo());
				break;
			// esci
			case 0:
				fine = true;
				break;
				
			default:
				break;
			}
			
		} while(fine != true);
		
		System.out.println(FINE_PROGRAMMA);
	}
	
	public void avvioConDati() {
		MyMenu menu = new MyMenu(MENU_TITOLO, MENU_VOCI);
		CorsaCiclistica corsa = creaCorsa();
		boolean fine = false;
		
		System.out.println(MSG_INIZIALE);
		
		do {
			menu.stampaMenu();
			int scelta = InputDati.leggiIntero(ARROW);
			
			switch (scelta) {
			// aggiungi una tappa
			case 1:
				try {
					aggiungereUnaTappa(corsa);
				} catch (SedeDiArrivoException e) {
					e.printStackTrace();
				}
				break;
			// rimuovi una tappa
			case 2:
				rimuoviTappa(corsa);
				break;
			// distanza della tappa
			case 3:
				distanzaDellaTappa(corsa);
				break;
			// informazioni della tappa
			case 4:
				informazioniDellaTappa(corsa);
				break;
			// dati globali della corsa
			case 5:
				System.out.println(corsa.stampaInfo());
				break;
			// esci
			case 0:
				fine = true;
				break;
				
			default:
				break;
			}
			
		} while(fine != true);
		
		System.out.println(FINE_PROGRAMMA);
	}

	private void informazioniDellaTappa(CorsaCiclistica corsa) {
		System.out.println(corsa.stampaTappe());
		System.out.println(SCELGLIERE_LA_TAPPA);
		int s = InputDati.leggiIntero(ARROW);
		System.out.println(corsa.getInfoDi(s));
	}

	private void aggiungereUnaTappa(CorsaCiclistica corsa) throws SedeDiArrivoException {
		Tappa tappa = new Tappa();
		System.out.println(CHIEDI_NOME_TAPPA);
		tappa.setNome(InputDati.leggiStringa(ARROW));
		
		System.out.println(CHIEDI_QUANTITA_LOCALITA_DELLA_TAPPA);
		int numeroLocalità = InputDati.leggiIntero(ARROW);
		System.out.println("Inserisci località: ");
		for(int i = 0; i < numeroLocalità; i++) {
			// inserimento dei dati della località
			System.out.println("località " + i);
			System.out.println("Nome: ");
			String nome = InputDati.leggiStringa(ARROW);
			System.out.println(CHIEDI_DISLIVELLO_DAL_MARE);
			int dislivello = InputDati.leggiIntero(ARROW);
			System.out.println(CHIEDI_DISTANZA_LOCALITA);
			int ditanza = InputDati.leggiIntero(ARROW);
			Località l = new Località(nome, dislivello, ditanza);
			// controllo se la località inserita è già presente
			if(tappa.cercaUguali(l)) {
				System.out.println(LOCALITA_GIA_PRESENTE);
				// elimina località
				System.out.println(CHIEDI_CANCELLARE_LOCALITA);
				if(InputDati.yesOrNo(ARROW)) {
					break;
				} else {
					// caso del circuito
					System.out.println(CHIEDI_SE_LA_TAPPA_E_CIRCUITO);
					if(InputDati.yesOrNo(ARROW)) {
						tappa.aggiungiLocalità(l);
						tappa.setCircuito(true);
						System.out.println(CHIEDI_NUMERO_DI_GIRI_DEL_CIRCUITO);
						int nGiri = InputDati.leggiInteroNonNegativo(ARROW);
						tappa.cambiaNumeroGiri(nGiri);
						
						// inserisci la sede di arrivo
						System.out.println(CHIEDI_SEDE_DI_ARRIVO);
						String sede = InputDati.leggiStringa(ARROW);
						tappa.setSedeDiArrivo(sede);
					} else {
						break;
					}
				}
			} else {
				// nel caso non sia già presente aggiunge la localita
				tappa.aggiungiLocalità(l);
			}
		}
		
		tappa.controlloCircuito();
		
		corsa.aggiungiTappa(tappa);
	}
	
	

	private void distanzaDellaTappa(CorsaCiclistica corsa) {
		System.out.println(corsa.stampaTappe());
		System.out.println(SCELGLIERE_LA_TAPPA);
		int nTappa = InputDati.leggiIntero(ARROW);
		System.out.println("distanza totale: " + corsa.getDistanzaDi(nTappa));
	}

	private void rimuoviTappa(CorsaCiclistica corsa) {
		System.out.println(corsa.stampaTappe());
		System.out.println(SCELGLIERE_LA_TAPPA_DA_ELIMINARE);
		int numeroTappa = InputDati.leggiIntero(ARROW);
		corsa.rimuoviTappa(numeroTappa);
	}
	
	private CorsaCiclistica creaCorsa() {
		CorsaCiclistica c = new CorsaCiclistica();
		Tappa t1 = new Tappa();
		t1.setNome("Tappa1");
		t1.aggiungiLocalità(new Località("Jesi", 10, 0));
		t1.aggiungiLocalità(new Località("Ancona", 0, 70));
		t1.aggiungiLocalità(new Località("Senigallia", -1, 30));
		
		Tappa t2 = new Tappa();
		t2.setNome("Tappa2");
		t2.aggiungiLocalità(new Località("Jesi", 10, 0));
		t2.aggiungiLocalità(new Località("Ancona", 0, 70));
		t2.aggiungiLocalità(new Località("Jesi", 10, 70));
		t2.setCircuito(true);
		t2.setNumeroGiri(3);
		
		c.aggiungiTappa(t1);
		c.aggiungiTappa(t2);
		
		return c;
		
	}

}
