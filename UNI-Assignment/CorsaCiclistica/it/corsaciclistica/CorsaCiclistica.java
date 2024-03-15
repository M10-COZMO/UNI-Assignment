package it.corsaciclistica;

import java.util.ArrayList;

public class CorsaCiclistica {
	
	private ArrayList<Tappa> listaTappe = new ArrayList<Tappa>();
	
	public CorsaCiclistica() {
		
	}

	public CorsaCiclistica(ArrayList<Tappa> listaTappe) {
		this.listaTappe = listaTappe;
	}
	
	/**
	 * 
	 * @return una lista delle tappe
	 */
	public String stampaTappe() {
		String str = "Lista Tappe: ";
		for (int i = 0; i < listaTappe.size(); i++) {
			str += "\n " + i + ". " + listaTappe.get(i).getNome();
		}
		return str;
	}
	
	/**
	 * 
	 * @param nTappa indice della tappa desiderata nella lista
	 * @return le informazioni di una tappa
	 */
	public String getInfoDi(int nTappa) {
		return listaTappe.get(nTappa).stampaInfo();
	}
	
	/**
	 * 
	 * @param nTappa indice della tappa desiderata nella lista
	 * @return la distanza totale di una tappa
	 */
	public int getDistanzaDi(int nTappa) {
		return listaTappe.get(nTappa).calcoloDistanzaTotale();
	}
	
	/**
	 * 
	 * @return tutte le informazioni della corsa
	 */
	public String stampaInfo() {
		String str = "Informazioni Corsa";
		for(int i = 0; i < listaTappe.size(); i++) {
			str +=  "\n" + i + ". " + listaTappe.get(i).stampaInfo();
		}
		return str;
	}
	
	/**
	 * 
	 * @param daAggiungere tappa da aggiungere
	 */
	public void aggiungiTappa(Tappa daAggiungere) {
		listaTappe.add(daAggiungere);
	}
	
	/**
	 * 
	 * @param daRimuovere la tappa da rimuovere
	 */
	public void rimuoviTappa(Tappa daRimuovere) {
		listaTappe.remove(daRimuovere);
	}
	
	/**
	 * 
	 * @param daRimuovere l'indice della tappa da rimuovere
	 */
	public void rimuoviTappa(int daRimuovere) {
		listaTappe.remove(daRimuovere);
	}

	public ArrayList<Tappa> getListaTappe() {
		return listaTappe;
	}

	public void setListaTappe(ArrayList<Tappa> listaTappe) {
		this.listaTappe = listaTappe;
	}
	
	
	

}
