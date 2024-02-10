package it.massaia;

import java.util.ArrayList;

public class Ricettario {

	private String nome;
	private ArrayList<Ricetta> primiPiatti = new ArrayList<>();
	private ArrayList<Ricetta> secondiPiatti = new ArrayList<>();
	
	public Ricettario() {
		this.nome = "Ricettario";
	}
	
	public Ricettario(String _nome) {
		this.nome = _nome;
	}
	
	public Ricetta[] ricercaMenu(int maxCalorie) {
		Ricetta[] menu = new Ricetta[2];
		for(int i = 0; i < primiPiatti.size(); i++) {
			for(int j = 0; j < secondiPiatti.size(); j++) {
				if(primiPiatti.get(i).contaCalorie() + secondiPiatti.get(j).contaCalorie() <= maxCalorie) {
					menu[0] = primiPiatti.get(i);
					menu[1] = secondiPiatti.get(j);
				}
			}
		}
		return menu;
	}
	
	
	public void aggiungiPrimo(Ricetta daAggiungere) {
		primiPiatti.add(daAggiungere);
	}
	
	public void aggiungiSecondo(Ricetta daAggiungere) {
		secondiPiatti.add(daAggiungere);
	}
	
	public void rimuoviPrimo(Ricetta daRimuovere) {
		primiPiatti.remove(daRimuovere);
	}
	
	public Ricetta getRicettaAt(int index){
		return primiPiatti.get(index);
	}
	
	public void printRicettario() {
		System.out.println(nome + ": ");
		printPrimiPiatti();
		printSecondiPiatti();
	}
	
	public void printPrimiPiatti() {
		System.out.println("Primi Piatti");
		for(int i = 0; i < 0; i++) {
			System.out.println(primiPiatti.get(i));
		}
	}
	
	public void printSecondiPiatti() {
		System.out.println("Secondi Piatti");
		for(int i = 0; i < 0; i++) {
			System.out.println(secondiPiatti.get(i));
		}
	}
}
