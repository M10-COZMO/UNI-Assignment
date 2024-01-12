package en.cdarchive;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CD {
	
	private String title;
	private String autor;
	private ArrayList<Song> songList = new ArrayList<Song>();
	
	Scanner in = new Scanner(System.in);
	
	public CD(String _title, String _autor, ArrayList<Song> _songList) {
		this.title = _title;
		this.autor = _autor;
		this.songList = _songList;
	}
	
	public CD(String _title, String _autor) {
		this.title = _title;
		this.autor = _autor;
	}
	
	public CD() {
		
	}

	// getters and setters
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public ArrayList<Song> getSongList() {
		return songList;
	}

	public void setSongList(ArrayList<Song> songList) {
		this.songList = songList;
	}
	
	// required methods
	
	public void addSong(Song songToAdd) {
		songList.add(songToAdd);
	}
	
	public void removeSong(int indexOfTheSong) {
		songList.remove(indexOfTheSong);
	}
	
	public Song getSong(int indexOfTheSong) {
		return songList.get(indexOfTheSong); 
	}		
	
	public void listSong() { 
		if (songList.size() == 0) {
			System.out.println("This cd is empty");
		} else {
			System.out.println("Songs List: ");
			for (int i = 0; i < songList.size(); i++) {
				System.out.println(i + ". " + songList.get(i).toString());
			}
		}
	}
	
	public void showCDInfo() {
		System.out.println("Title: " + title);
		System.out.println("Autor: " + autor);
		listSong();
	}
	
	public Song randomSong() {
		Random random = new Random();
		int randomNumber = random.nextInt(songList.size()); // from 0 to size of the arraylist -1
		return getSong(randomNumber);
	}

	public String printCDInfo() {
		return "Title: " + title + ", Autor: " + autor + ", Number of songs: " + songList.size();
	}
	
	@Override
	public String toString() {
		return "[title: " + title + ", autor: " + autor + ", songList: " + songList + "]";
	}
	
	public void createNewCD() {
		int numberOfSongs = 0;
		System.out.print("Enter the CD title: ");
		title = in.next();
		System.out.print("Enter the CD autor name: ");
		autor = in.next();
		int choise;
		do {
			System.out.print("Do you want to add a new song?\n0 - no\n1 - yes\n-->");
			choise = in.nextInt();
		
			switch (choise) {
			case 1:
				Song song = new Song();
				System.out.print("Insert the song title: ");
				String songTitle;
				songTitle = in.next();
				song.setTitle(songTitle);
				System.out.print("Insert the song length: ");
				int songLength = in.nextInt();
				song.setLength(songLength);
				addSong(song);
				break;
				
			default:
				break;
			}
		} while (choise != 0);
		
		System.out.println("Information about the new CD --> " + toString());
	}
	
	
	
	
	
	
	
	
	
}
