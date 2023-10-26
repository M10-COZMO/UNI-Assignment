package en.cdarchive;

import java.util.ArrayList;

public class CD {
	
	private String title;
	private String autor;
	private ArrayList<Song> songList = new ArrayList<Song>();
	
	public CD(String _title, String _autor, ArrayList<Song> _songList) {
		this.title = _title;
		this.autor = _autor;
		this.songList = _songList;
	}
	
	public CD() {
		
	}

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
	
	public void addSong(Song songToAdd) {
		songList.add(songToAdd);
	}
	
	public void removeSong(int indexOfTheSong) {
		songList.remove(indexOfTheSong);
	}
	
	public void getSong(int theSongToGet) {
		songList.get(theSongToGet); 
	}		
	
	public void listSong() { 
		if (songList.size() == 0) {
			System.out.println("This cd is empty");
		} else {
			System.out.println("Songs List");
			for (int i = 0; i < songList.size(); i++) {
				System.out.println(i + ". " + songList.get(i).toString());
			}
		}
	}
	
	
	
	

}
