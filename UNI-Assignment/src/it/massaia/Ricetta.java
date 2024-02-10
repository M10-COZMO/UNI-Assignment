package it.massaia;

import java.util.ArrayList;

public class Ricetta {

	private String nome;
	private ArrayList<Ingrediente> ingredienti = new ArrayList<>();
	private boolean primoPiatto;
	
	public Ricetta(String _nome) {
		this.nome = _nome;	
	}
	
	public void printRicetta() {
		System.out.println(nome);
		for (int i = 0; i < ingredienti.size(); i++) {
			System.out.println(i + ". " + ingredienti.get(i).toString());
		}
	}
	
	public int contaCalorie() {
		int totCalorie = 0;
		for(Ingrediente i : ingredienti) {
			totCalorie += i.getCalorie();
		}
		return totCalorie;
	}
	
	public void aggiungiIngrediente(Ingrediente daAggiungere) {
		ingredienti.add(daAggiungere);
	}
	
	public void rimuoviIngrediente(Ingrediente daRimuovere) {
		ingredienti.remove(daRimuovere);
	}
	
	public Ingrediente selezioneIngrediente(int index) {
		return ingredienti.get(index);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Ingrediente> getIngredienti() {
		return ingredienti;
	}

	public void setIngredienti(ArrayList<Ingrediente> ingredienti) {
		this.ingredienti = ingredienti;
	}

	public boolean isPrimoPiatto() {
		return primoPiatto;
	}

	public void setPrimoPiatto(boolean primoPiatto) {
		this.primoPiatto = primoPiatto;
	}
	
	
}
