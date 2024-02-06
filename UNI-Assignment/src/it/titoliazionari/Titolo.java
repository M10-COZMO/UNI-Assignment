package it.titoliazionari;

import java.util.*;

public class Titolo {

	private String nome;
	private int valore;
	
	public Titolo() {
		
	}
	
	public Titolo(String _nome) {
		this.nome = _nome;
	}
	
	public Titolo(String _nome, int _valore) {
		this.nome = _nome;
		this.valore = _valore;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getValore() {
		return valore;
	}

	public void setValore(int valore) {
		this.valore = valore;
	}

	@Override
	public String toString() {
		return "[" + nome + " " + valore + "]";
	}
	
	public void variazioneValore() {
		Random ran = new Random();
		int variazione = ran.nextInt(100)-50;
		valore += variazione;
	}
	
	public int assegnaValoreRandom() {
		Random random = new Random();
		return random.nextInt(500)+1;
	}
	
	
}
