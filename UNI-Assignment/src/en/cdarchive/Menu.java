package en.cdarchive;

import java.util.ArrayList;

public class Menu {
	
	private static final String LINE = "-----------------------------------";
	private String title;
	ArrayList<String> voices = new ArrayList<String>();
	
	public Menu(String _title, ArrayList<String> _voices) {
		this.title = _title;
		this.voices = _voices;
	}
	
	public Menu() {
		
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public ArrayList<String> getVoices() {
		return voices;
	}
	
	public void setVoices(ArrayList<String> _voices) {
		this.voices = _voices;
	}

	@Override
	public String toString() {
		return "Menu [title=" + title + ", voices=" + voices + "]";
	}
	
	public void printMenu() {
		System.out.println(LINE);
		System.out.println("| " + title + " |");
		System.out.println(LINE);
		for(int i = 0; i < voices.size(); i++) {
			System.out.println(i + ". " + voices.get(i));
		}
		System.out.println(LINE);
	}
	
	public void addVoice(String voice) {
		voices.add(voice);
	}
	
}