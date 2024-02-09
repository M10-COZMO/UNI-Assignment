package it.morracinese;

import java.util.Arrays;

import it.unibs.fp.mylib.EstrazioniCasuali;

public class MorraCinese {

	private String sceltaGiocatore;
	private String sceltaPc;
	private String[] mosse = {"sasso", "carta", "forbici"};
	
	public MorraCinese() {
		
	}
	
	public void generaMossaPc() {
		sceltaPc = mosse[EstrazioniCasuali.estraiIntero(0, 2)];
	}
	
	public String getMossa(int index) {
		return mosse[index];
	}
	
	@Override
	public String toString() {
		return "SceltaGiocatore: " + sceltaGiocatore + "\nSceltaPc: " + sceltaPc;
	}

	public String getSceltaGiocatore() {
		return sceltaGiocatore;
	}

	public void setSceltaGiocatore(String sceltaGiocatore) {
		this.sceltaGiocatore = sceltaGiocatore;
	}

	public String getSceltaPc() {
		return sceltaPc;
	}

	public void setSceltaPc(String sceltaPc) {
		this.sceltaPc = sceltaPc;
	}

	public String[] getMosse() {
		return mosse;
	}

	public void setMosse(String[] mosse) {
		this.mosse = mosse;
	}

	public boolean vittoria() {
		if (sceltaGiocatore.equals(mosse[0]) && sceltaPc.equals(mosse[2])) {
			return true;
		} else if (sceltaGiocatore.equals(mosse[1]) && sceltaPc.equals(mosse[0])) {
			return true;
		} else if (sceltaGiocatore.equals(mosse[2]) && sceltaPc.equals(mosse[1])) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean patta() {
		if (sceltaGiocatore.equals(sceltaPc)) {
			return true;
		} else {
			return false;
		}
	}
}
