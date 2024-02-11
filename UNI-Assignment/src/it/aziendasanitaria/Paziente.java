package it.aziendasanitaria;

public class Paziente extends Persona{

	private int nTesseraSanitaria;
	private Medico medicoAsseganto;
	
	public Paziente(String nome, String cognome, int nTesseraSanitaria, Medico medicoAsseganto) {
		super(nome, cognome);
		this.nTesseraSanitaria = nTesseraSanitaria;
		this.medicoAsseganto = medicoAsseganto;
	}

	public Paziente(String nome, String cognome) {
		super(nome, cognome);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @return ritorna nome, cognome e il numero della tessera sanitaria
	 */
	public String stampaDati() {
		return getNome() + " " + getCognome() + " " + nTesseraSanitaria;
	}
	
	/**
	 * 
	 * @return tutte le informazioni del paziente
	 */
	public String stampaInfo() {
		String str = "Informazioni di: " + getNome() + " " + getCognome();
		str += "\nNumero di Tessera Sanitaria: " + getnTesseraSanitaria();
		str += "\nMedico di base assegnato: " + getMedicoAsseganto().stampaDati();
		return str;
	}

	public int getnTesseraSanitaria() {
		return nTesseraSanitaria;
	}

	public void setnTesseraSanitaria(int nTesseraSanitaria) {
		this.nTesseraSanitaria = nTesseraSanitaria;
	}

	public Medico getMedicoAsseganto() {
		return medicoAsseganto;
	}

	public void setMedicoAsseganto(Medico medicoAsseganto) {
		this.medicoAsseganto = medicoAsseganto;
	}
	
}
