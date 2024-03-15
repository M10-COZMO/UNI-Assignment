package it.corsaciclistica;

public class Località {

	private String nome;
	private int altezzaLivelloDelMare;
	private int distanzaDallaScorsaLocalita;
	
	public Località() {
		
	}
	
	public Località(String _nome, int _altezzaLivelloDelMare, int _distanzaDallaScorsaLocalita) {
		this.nome = _nome;
		this.altezzaLivelloDelMare = _altezzaLivelloDelMare;
		this.distanzaDallaScorsaLocalita = _distanzaDallaScorsaLocalita;
	}


	public String stampaInfo() {
		String str = "Dati della località: " + nome;
		str += "\n\t Altezza dal livello del mare: " + altezzaLivelloDelMare;
		str += "\n\t Distanza dalla scora località: " + distanzaDallaScorsaLocalita;
		return str;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAltezzaLivelloDelMare() {
		return altezzaLivelloDelMare;
	}

	public void setAltezzaLivelloDelMare(int altezzaLivelloDelMare) {
		this.altezzaLivelloDelMare = altezzaLivelloDelMare;
	}

	public int getDistanzaDallaScorsaLocalita() {
		return distanzaDallaScorsaLocalita;
	}

	public void setDistanzaDallaScorsaLocalita(int distanzaDallaScorsaLocalita) {
		this.distanzaDallaScorsaLocalita = distanzaDallaScorsaLocalita;
	}
	
	
	
	
}
