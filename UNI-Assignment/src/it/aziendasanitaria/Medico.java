package it.aziendasanitaria;

import java.util.ArrayList;

public class Medico extends Persona{

	private String codice;
	private GiorniDellaSettimana giornoDiRiposo;
	private ArrayList<Paziente> listaPazienti = new ArrayList<Paziente>();
	
	public Medico(String _nome, String _cognome, String _codice, GiorniDellaSettimana _giornoDiRiposo) {
		super(_nome, _cognome);
		this.codice = _codice;
		this.giornoDiRiposo = _giornoDiRiposo;
	}
	
	public Medico(String _nome, String _cognome, String _codice, GiorniDellaSettimana _giornoDiRiposo, ArrayList<Paziente> _listaPazienti) {
		super(_nome, _cognome);
		this.codice = _codice;
		this.giornoDiRiposo = _giornoDiRiposo;
		this.listaPazienti = _listaPazienti;
	}
	
	public Medico(String nome, String cognome) {
		super(nome, cognome);
		
	}
	
	/**
	 * 
	 * @return tutte le informazioni riguardanti il medico
	 */
	public String stampaInfo() {
		String str = "Informazioni di: ";
		str += getNome() + " " + getCognome();
		str += "\n - codice identificativo: " + codice;
		str += "\n - Giorno di riposo: " + giornoDiRiposo;
		for (int i = 0; i < listaPazienti.size(); i++) {
			str += "\n\t" + i + ". " + listaPazienti.get(i).stampaDati();
		}
		return str;
	}
	
	/**
	 * 
	 * @return il nome il cognome e il codice del medico
	 */
	public String stampaDati() {
		return getNome() + " " + getCognome() + " " + codice;
	}
	public void aggiungiPaziente(Paziente daAggiungere) {
		listaPazienti.add(daAggiungere);
	}
	
	public void rimuoviPaziente(Paziente daRimuovere) {
		listaPazienti.remove(daRimuovere);
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public GiorniDellaSettimana getGiornoDiRiposo() {
		return giornoDiRiposo;
	}

	public void setGiornoDiRiposo(GiorniDellaSettimana giornoDiRiposo) {
		this.giornoDiRiposo = giornoDiRiposo;
	}
	
	
	public ArrayList<Paziente> getListaPazienti() {
		return listaPazienti;
	}

	public void setListaPazienti(ArrayList<Paziente> listaPazienti) {
		this.listaPazienti = listaPazienti;
	}


}
