package it.massaia;

public class Ingrediente {
	
	private String nome;
	private int calorie;
	
	public Ingrediente() {
		
	}
	
	public Ingrediente(String _nome, int _calorie) {
		this.nome = _nome;
		this.calorie = _calorie;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCalorie() {
		return calorie;
	}

	public void setCalorie(int calorie) {
		this.calorie = calorie;
	}

	@Override
	public String toString() {
		return "[" + nome + "|" + calorie + "]";
	}
	
	

}
