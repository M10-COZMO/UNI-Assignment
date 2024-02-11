package it.aziendasanitaria;

import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;

public class UIManager {
	
	private static final String MSG_CHIEDI_CODICE_DEL_NUOVO_MEDICO = "Inserisci il codice del nuovo medico da assegnare al paziente: ";
	private static final String MSG_CHIEDI_TESSERA_SANITARIA = "Inserisci tessera sanitaria del paziente: ";
	private static final String CHIEDI_TESSERA_SANITARIA = "Numero di Tessera Sanitaria";
	private static final String CHIEDI_GIORNO_LIBERO = "Giorno della settima libero (1/2/3/4/5/6/7): ";
	private static final String CHIEDi_CODICE = "Codice: ";
	private static final String CHIEDI_COGNOME = "Cognome: ";
	private static final String CHIEDI_NOME = "Nome: ";
	private static final String MSG_CHIEDIA_DATI_MEDICO = "Inserisci i dati del nuovo medico: ";
	private static final String ARROW = "-->";
	private static final String NOME = "Nome azienda";
	private static final String DESCRIZIONE_AZIENDA = "...breve descrizione dell'azienda...";
	private static final String MENU_TITOLO = "Scegliere una delle seguenti voci:";
	private static final String[] MENU_VOCI = {"aggiungi un medico", "aggiungi un paziente", "stampa lista medici",
			"stamap lista pazienti", "riassegna medico a paziente", "ricerca medico per giorno"};
	private static final String[] LISTA_GIORNI_DELLA_SETTIMANA = {"Lunedì", "Martedì", "Mercoledì", "Giovedì", "Venerdi", "Sabato", "Domenica"};
	private static final String MSG_CHIEDI_DATI_PAZIENTE = "Inserisci i dati del nuovo paziente: ";

	public void avvio() {
		AziendaSanitaria aziendaSanitaria = new AziendaSanitaria(NOME, DESCRIZIONE_AZIENDA);
		MyMenu menu = new MyMenu(MENU_TITOLO,MENU_VOCI);
		boolean fine = false;
		// crea menu di scelte
		// - aggiungi un nuovo medico
		// - aggiungi un nuovo paziente
		// - stampa lista medici
		// - stampa lista pazienti
		// - riassegna medico a paziente
		// - ricerca medico per girono
		// - cerca paziente per codice
		// - cerca paziente per numero di tessera
		do {
			menu.stampaMenu();
			int scelta = InputDati.leggiIntero(ARROW);
			switch (scelta) {
			// aggiungiungere un nuovo medico
			case 1:
				aggiungiUnMedico(aziendaSanitaria);
				break;
			// aggiungere un nuovo paziente
			case 2:
				aggiungiUnPaziente(aziendaSanitaria);
				break;
			// stampa la lista dei medici
			case 3:
				System.out.println(aziendaSanitaria.stampaListaMedici());
				break;
			// stampa la lista dei pazienti
			case 4:
				System.out.println(aziendaSanitaria.stampaListaPazienti());
				break;
			//riassegna medico a paziente
			case 5:
				riassegnaMedicoAPaziente(aziendaSanitaria);
				break;
			// ricerca medico per giorno
			case 6:
				GiorniDellaSettimana giorno = scegliGiornoDellaSettimana(CHIEDI_GIORNO_LIBERO);
				System.out.println(aziendaSanitaria.cercaMedicoPerGiorno(giorno));
				break;
			// caso in cui si voglia uscire
			case 0:
				fine = true;
				break;
				
			default:
				break;
			}
			
		} while (fine != true);
		
		System.out.println("Programma Terminato");		
	}

	private void riassegnaMedicoAPaziente(AziendaSanitaria aziendaSanitaria) {
		System.out.println(MSG_CHIEDI_TESSERA_SANITARIA);
		System.out.println(aziendaSanitaria.stampaListaPazienti());
		int nTessera = InputDati.leggiIntero(ARROW);
		Paziente paziente = aziendaSanitaria.getPaziente(nTessera);
		System.out.println(MSG_CHIEDI_CODICE_DEL_NUOVO_MEDICO);
		System.out.println(aziendaSanitaria.stampaListaMedici());
		String codice = InputDati.leggiStringa(ARROW);
		Medico nuovoMedico = aziendaSanitaria.getMedico(codice);
		aziendaSanitaria.riassegnaMedicoAPaziente(paziente, nuovoMedico);
	}

	private void aggiungiUnPaziente(AziendaSanitaria aziendaSanitaria) {
		System.out.println(MSG_CHIEDI_DATI_PAZIENTE);
		System.out.println(CHIEDI_NOME);
		String nome = InputDati.leggiStringa(ARROW);
		System.out.println(CHIEDI_COGNOME);
		String cognome = InputDati.leggiStringa(ARROW);
		System.out.println(CHIEDI_TESSERA_SANITARIA);
		int numeroTessera = InputDati.leggiIntero(ARROW);
		System.out.println("Inserire il medico da assegnare (selezionare il codice): ");
		System.out.println(aziendaSanitaria.stampaListaMedici());
		String codiceMedico = InputDati.leggiStringa(ARROW);
		Medico medicoDaAssegnare = aziendaSanitaria.getMedico(codiceMedico);
		Paziente paziente = new Paziente(nome, cognome, numeroTessera, medicoDaAssegnare);
		aziendaSanitaria.aggiungiPaziente(paziente);
	}

	private void aggiungiUnMedico(AziendaSanitaria aziendaSanitaria) {
		System.out.println(MSG_CHIEDIA_DATI_MEDICO);
		System.out.println(CHIEDI_NOME);
		String nome = InputDati.leggiStringa(ARROW);
		System.out.println(CHIEDI_COGNOME);
		String cognome = InputDati.leggiStringa(ARROW);
		System.out.println(CHIEDi_CODICE);
		String codice = InputDati.leggiStringa(ARROW);
		GiorniDellaSettimana giorno = scegliGiornoDellaSettimana(CHIEDI_GIORNO_LIBERO);
		Medico medico = new Medico(nome, cognome, codice, giorno);
		aziendaSanitaria.aggiungiMedico(medico);
	}

	private GiorniDellaSettimana scegliGiornoDellaSettimana(String messaggioDaStampare) {
		String messaggio = messaggioDaStampare;
		System.out.println(messaggio);
		int sceltaSettimana = InputDati.leggiIntero(ARROW);
		GiorniDellaSettimana giorno = null;
		switch (sceltaSettimana) {
		case 1:
			giorno = GiorniDellaSettimana.LUNEDI;
			break;
		case 2:
			giorno = GiorniDellaSettimana.MARTEDI;
			break;
		case 3:
			giorno = GiorniDellaSettimana.MERCOLEDI;
			break;
		case 4:
			giorno = GiorniDellaSettimana.GIOVEDI;
			break;
		case 5:
			giorno = GiorniDellaSettimana.VENERDI;
			break;
		case 6:
			giorno = GiorniDellaSettimana.SABATO;
			break;
		case 7:
			giorno = GiorniDellaSettimana.DOMENICA;
			break;

		default:
			break;
		}
		return giorno;
	}

}
