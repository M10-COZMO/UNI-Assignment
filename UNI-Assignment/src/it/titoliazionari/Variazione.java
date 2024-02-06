package it.titoliazionari;

public class Variazione {

	private int giornatePassate;
	private Portafoglio portafoglio;
	
	public Variazione() {
		
	}
	
	public Variazione(int _giornatePassate) {
		this.giornatePassate = _giornatePassate;
	}
	
	public Variazione(int _giornatePassate, Portafoglio _portafolgio) {
		this.giornatePassate = _giornatePassate;
		this.portafoglio = _portafolgio;
	}

	public int getGiornatePassate() {
		return giornatePassate;
	}

	public void setGiornatePassate(int giornatePassate) {
		this.giornatePassate = giornatePassate;
	}
	
	public void passaGiorno() {
		portafoglio.variazioneValoriPortafoglio();
		portafoglio.calcoloValoreTotale();
		
		System.out.println("Giornate passate dalla creazione del portafolgio: " + giornatePassate);
		portafoglio.stampaLotti();
	}

	public Portafoglio getPortafoglio() {
		return portafoglio;
	}

	public void setPortafoglio(Portafoglio portafoglio) {
		this.portafoglio = portafoglio;
	}
}
