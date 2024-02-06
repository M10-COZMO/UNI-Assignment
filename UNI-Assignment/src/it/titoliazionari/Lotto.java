package it.titoliazionari;

import java.util.*;

public class Lotto {
	
	private String nome;
	private ArrayList<Titolo> listaTitoli = new ArrayList<Titolo>();
	
	public Lotto() {
		
	}
	
	public Lotto(String _nome) {
		this.nome = _nome;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void aggiungiTitolo(Titolo titoloDaAggiungere) {
		listaTitoli.add(titoloDaAggiungere);
	}
	
	public void rimuoviTitolo(Titolo titoloDaRimuovere) {
		listaTitoli.remove(titoloDaRimuovere);
	}
	
	public int calcoloDelValoreTotale() {
		int totale = 0;
		for (int i = 0; i < listaTitoli.size(); i++) {
			totale += listaTitoli.get(i).getValore();
		}
		return totale;
	}
	
	public void variazioneTitoli() {
			listaTitoli.get(0).variazioneValore();
			int nuovoValore = listaTitoli.get(0).getValore();
			for(int i = 0; i < listaTitoli.size(); i++) {
				listaTitoli.get(i).setValore(nuovoValore);
			}
	}

	@Override
	public String toString() {
		return nome + ":\n[" + listaTitoli + "]";
	}
	
	public String listaTitoli() {
		return nome + ": -|" + listaTitoli + "|-";
	}
	
	public String stampaTitoli() {
		String str = nome;
		for (int i = 0; i < listaTitoli.size(); i++) {
			str += "\n -  " + i + ". " + listaTitoli.get(i).toString();
		}
		return str;
	}
	
	
}
