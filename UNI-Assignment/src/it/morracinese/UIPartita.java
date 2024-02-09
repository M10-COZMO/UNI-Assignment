package it.morracinese;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import it.unibs.fp.mylib.InputDati;

public class UIPartita {

	private static final String CONTINUARE_CON_LA_PARTITA = "Continuare con la partita?";
	private static final String SCONFITTA = "HA VINTO IL PC";
	private static final String VITTORIA = "HA VINTO IL GIOCATORE";
	private static final String PATTA = "PATTA";
	private static final String SCEGLI_MOSSA = "Scegli Mossa:\n1. sasso\n2. carta\n3. forbici";
	private static final int PARTITE_MASSIME = 5;
	private static final String INIZIO_PARTITA = "Inizio partita in corso...";
	private static final String PROGRAMMA_TERMINATO = "Programma Terminato";
	
	private int vittorieGiocatore;
	private int vittoriePc;
	private int patte;
	private boolean terminaPartita;
	
	public UIPartita() {
		this.terminaPartita = false;
	}
	
	public void avviaPartita() {
		MorraCinese mc = new MorraCinese();
		int count = 0;
		
		
		System.out.println(INIZIO_PARTITA);
		
		do {
			gestionePartita(mc);
			if(InputDati.yesOrNo(CONTINUARE_CON_LA_PARTITA)) {
				count++;
			} else {
				count = 10;
			}
			if (count == PARTITE_MASSIME) {
				System.out.println("Partite Massime Raggiunte");
			}
		} while (count < PARTITE_MASSIME);
		
		System.out.println("Vittore Giocatore: "+ vittorieGiocatore);
		System.out.println("Vittore PC: "+ vittoriePc);
		System.out.println("Patte: "+ patte);
		System.out.println(PROGRAMMA_TERMINATO);
		try {
			FileWriter fw = new FileWriter(new File("Risultati.txt"));
			fw.write("Vittore Giocatore: "+ vittorieGiocatore);
			fw.write("\nVittore PC: "+ vittoriePc);
			fw.write("\nPatte: "+ patte);
			fw.write("\nStatistica sulle vittorie: " + (double)vittorieGiocatore/(vittoriePc+vittorieGiocatore+patte));
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void gestionePartita(MorraCinese mc) {
		int scelta = InputDati.leggiIntero(SCEGLI_MOSSA);
		mc.setSceltaGiocatore(mc.getMossa(scelta-1));
		mc.generaMossaPc();
		if (mc.patta()) {
			System.out.println(mc.toString());
			System.out.println(PATTA);
			incrementaPatte();
		} else if (mc.vittoria()){
			System.out.println(mc.toString());
			System.out.println(VITTORIA);
			incrementaVittorieGiocatore();
		} else {
			System.out.println(mc.toString());
			System.out.println(SCONFITTA);
			incrementaVittoriePc();
		}
	}
	
	public void incrementaVittorieGiocatore() {
		vittorieGiocatore++;
	}
	public void incrementaVittoriePc() {
		vittoriePc++;
	}

	public void incrementaPatte() {
		patte++;
	}
}
