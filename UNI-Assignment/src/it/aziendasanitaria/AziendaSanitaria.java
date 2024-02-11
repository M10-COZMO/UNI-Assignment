package it.aziendasanitaria;

import java.util.*;

public class AziendaSanitaria {
	
	private static final String MEDICO_NON_TROVATO = "Il medico cercato non è stato trovato.";
	private String nome;
	private String descrizione;
	private HashMap<String, Medico> listaMedici = new HashMap<String, Medico>();
	private HashMap<Integer, Paziente> listaPazienti = new HashMap<Integer, Paziente>();
	
	public AziendaSanitaria(){
		
	}
	
	public AziendaSanitaria(String _nome, String _descrizione) {
		this.nome = _nome;
		this.descrizione = _descrizione;
	}
	
	public void aggiungiMedico(Medico daAggiungere) {
		listaMedici.put(daAggiungere.getCodice(), daAggiungere);
	}
	
	public void rimuoviMedico(Medico daRimuovere) {
		listaMedici.remove(daRimuovere.getCodice());
	}
	
	public void aggiungiPaziente(Paziente daAggiungere) {
		listaPazienti.put(daAggiungere.getnTesseraSanitaria(), daAggiungere);
	}
	
	public void rimuoviPaziente(Paziente daRimuovere) {
		listaPazienti.remove(daRimuovere.getnTesseraSanitaria());
	}
	
	/**
	 * 
	 * @param ritorna le informazioni del medico, compresa la lista dei suoi pazienti
	 */
	public String cercaMedicoPerCodice(String codice) {
		Medico cercato = null;
		for (Map.Entry<String, Medico> i : listaMedici.entrySet()) {
			if(i.getKey() == codice) {
				cercato = i.getValue();
			}
		}
		if (cercato.equals(null)) {
			return MEDICO_NON_TROVATO;
		} else {
			return cercato.stampaInfo();
		}
	}
	
	public String cercaMedicoPerGiorno(GiorniDellaSettimana giornoCercato) {
		String str = "Lista dei medici disponibili di " + giornoCercato + ": ";
		ArrayList<Medico> listaMediciDisponibili = new ArrayList<Medico>();
		for (Map.Entry<String, Medico> i : listaMedici.entrySet()) {
			if(i.getValue().getGiornoDiRiposo() != giornoCercato) {
				listaMediciDisponibili.add(i.getValue());
			}
		}
		for(int i = 0; i < listaMediciDisponibili.size(); i++) {
			str += "\n\t" + i + ". " + listaMediciDisponibili.get(i).stampaDati();
		}
		return str;
	}
	
	/**
	 * 
	 * @param nTesseraSanitaria numero della tessera sanitaria del paziente ricercato
	 * @return le informazioni del paziente ricercato
	 */
	public String cercaPazientePerTesseraSanitaria(int nTesseraSanitaria) {
		String str = "Informazioni del paziente ricercato: ";
		for (Map.Entry<Integer, Paziente> i : listaPazienti.entrySet()) {
			if(i.getKey() == nTesseraSanitaria) {
				str += "\n" + i.getValue().stampaInfo();
			}
		}
		return str;
	}
	
	/**
	 * Questo metodo va a cambiare il medico di un dato paziente
	 * @param paziente il paziente a cui si vuole riassegnare medico
	 * @param nuovoMedico il nuovo medico del paziente
	 */
	public void riassegnaMedicoAPaziente(Paziente paziente, Medico nuovoMedico) {
		for (Map.Entry<Integer, Paziente> i : listaPazienti.entrySet()) {
			if(i.getKey() == paziente.getnTesseraSanitaria()) {
				i.getValue().setMedicoAsseganto(nuovoMedico);
			}
		}
	}
	
	public String stampaListaMedici() {
		String str = "Lista dei medici: ";
		int count = 0;
		for (Map.Entry<String, Medico> i : listaMedici.entrySet()) {
			str += "\n" + count + ". " + i.getValue().stampaInfo();
			count++;
		}
		return str;
	}
	
	public String stampaListaPazienti() {
		String str = "Lista dei pazienti: ";
		int count = 0;
		for (Map.Entry<Integer, Paziente> i : listaPazienti.entrySet()) {
			str += "\n" + count + ". " + i.getValue().stampaInfo();
			count++;
		}
		return str;
	}
	
	public Medico getMedico(String codice) {
		return listaMedici.get(codice);
		
	}
	
	public Paziente getPaziente(int nTessera) {
		return listaPazienti.get(nTessera);
	}
	
	public HashMap<Integer, Paziente> getListaPazienti() {
		return listaPazienti;
	}
	public void setListaPazienti(HashMap<Integer, Paziente> listaPazienti) {
		this.listaPazienti = listaPazienti;
	}
	public void setListaMedici(HashMap<String, Medico> listaMedici) {
		this.listaMedici = listaMedici;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public HashMap<String, Medico> getListaMedici() {
		return listaMedici;
	}
}
