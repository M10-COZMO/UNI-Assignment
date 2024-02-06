package it.titoliazionari;

import java.util.*;

public class Portafoglio {

	private String nome;
	private ArrayList<Lotto> listaLotti = new ArrayList<Lotto>();
	
	public Portafoglio() {
		
	}
	
	public Portafoglio(String _nome) {
		this.nome = _nome;
	}
	
	public void aggiungiLotto(Lotto lottoDaAggiungere) {
		listaLotti.add(lottoDaAggiungere);
	}
	
	
	public void rimuoviLotto(Lotto lottoDaRimuovere) {
		listaLotti.remove(lottoDaRimuovere);
	}
	
	public int calcoloValoreTotale() {
		int totale = 0;
		for (int i = 0; i < listaLotti.size(); i++) {
			totale += listaLotti.get(i).calcoloDelValoreTotale();
		}
		return totale;
	}
	
	public void variazioneValoriPortafoglio() {
		for (int i = 0; i < listaLotti.size(); i++) {
			listaLotti.get(i).variazioneTitoli();
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return nome + ":\n[" + listaLotti + "]";
	}
	
	public void stampaLotti() {
		System.out.println(nome + ":");
		for (int i = 0; i < listaLotti.size(); i++) {
			System.out.println(" "+ i + ". " + listaLotti.get(i).stampaTitoli());
		}
	}

	public ArrayList<Lotto> getListaLotti() {
		return listaLotti;
	}

	public void setListaLotti(ArrayList<Lotto> listaLotti) {
		this.listaLotti = listaLotti;
	}
}
