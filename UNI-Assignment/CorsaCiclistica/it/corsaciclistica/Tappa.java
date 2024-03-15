package it.corsaciclistica;

import java.util.ArrayList;

public class Tappa {
	
	private static final String MSG_ERRORE = "[ERROR]: la sede di arrivo non combacia con l'ultima localita della tappa";
	
	private String nome;
	private ArrayList<Località> listaLocalita = new ArrayList<Località>();
	private boolean circuito;
	private int numeroGiri;
	private String sedeDiArrivo;
	
	
	public Tappa(String nome, ArrayList<Località> listaLocalita) {
		this.nome = nome;
		this.listaLocalita = listaLocalita;
		this.numeroGiri = 1;
	}

	public Tappa() {
		this.numeroGiri = 1;
	}
	
	/**
	 * verifica se ci sono due località uguali nella tappa
	 * @param localita località da controllare se è già presente
	 * @return true se ci sono due località uguale false altrimenti
	 */
	public boolean cercaUguali(Località localita) {
		for (Località i : listaLocalita) {
			if (i.getNome().equals(localita.getNome())) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * controlla che la localita di arrivo della tappa sia uguale
	 * all'ultima citta della lista delle località
	 * @throws SedeDiArrivoException
	 */
	public void controlloCircuito() throws SedeDiArrivoException {
		if(isCircuito()) {
			int valore = getListaLocalita().size()-1;
			String nome = getListaLocalita().get(valore).getNome();
			if(!getSedeDiArrivo().equals(nome)) {
				throw new SedeDiArrivoException(MSG_ERRORE);
			}
		}
	}
	
	/** 
	 * in caso di circuito cambia il numro di giri
	 * @param nuovoNumero
	 */
	public void cambiaNumeroGiri(int nuovoNumero) {
		if(isCircuito()) {
			setNumeroGiri(nuovoNumero);
		}
	}
	
	/**
	 * calcola la distanzza totale del circuito
	 * sia nel caso di circuito che non 
	 * @return totale distanza percorsa
	 */
	public int calcoloDistanzaTotale() {
		int tot = 0;
		if(isCircuito()) {
			for (int i = 0; i < listaLocalita.size(); i++) {
				tot += listaLocalita.get(i).getDistanzaDallaScorsaLocalita();
			}
			tot = tot * numeroGiri;
		} else {
			for (int i = 0; i < listaLocalita.size(); i++) {
				tot += listaLocalita.get(i).getDistanzaDallaScorsaLocalita();
			}
		}
		return tot;
	}
	
	/**
	 * calcola il dislivelo totale della tappa in valore assoluto
	 * @return il valore del dislivello
	 */
	public int calcolaDislivello() {
		int dislivelloTotale = 0;
		for (int i = 0; i < listaLocalita.size(); i++) {
			dislivelloTotale += listaLocalita.get(i).getAltezzaLivelloDelMare();
		}
		dislivelloTotale = Math.abs(dislivelloTotale);
		return dislivelloTotale;
	}
	
	/**
	 * 
	 * @return le informazioni totali sulla tappa
	 */
	public String stampaInfo() {
		String str = "Informazioni della tappa: " + nome;
		int count = 1;
		for (int i = 0; i < listaLocalita.size(); i++) {
			str += "\n " + count + ". " + listaLocalita.get(i).stampaInfo();
			count++;
		}
		str += "\n Distanza toale: " + calcoloDistanzaTotale();
		str += "\n Dislivello toale: " + calcolaDislivello();
		return str;
	}
	
	/** 
	 * aggiunge una nuova località
	 * @param daAggiungere località da aggiungere 
	 */
	public void aggiungiLocalità(Località daAggiungere) {
		listaLocalita.add(daAggiungere);
	}
	
	/**
	 * rimuove una località
	 * @param daRimuovere località da rimuovere
	 */
	public void rimuoviLocalità(Località daRimuovere) {
		listaLocalita.remove(daRimuovere);
	}

	public ArrayList<Località> getListaLocalita() {
		return listaLocalita;
	}

	public void setListaLocalita(ArrayList<Località> listaLocalita) {
		this.listaLocalita = listaLocalita;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isCircuito() {
		return circuito;
	}

	public void setCircuito(boolean circuito) {
		this.circuito = circuito;
	}

	public int getNumeroGiri() {
		return numeroGiri;
	}

	public void setNumeroGiri(int numeroGiri) {
		this.numeroGiri = numeroGiri;
	}

	public String getSedeDiArrivo() {
		return sedeDiArrivo;
	}

	public void setSedeDiArrivo(String sedeDiArrivo) {
		this.sedeDiArrivo = sedeDiArrivo;
	}
	
}
