package en.cdarchive;

public class Song {
	
	private String title;
	private int length; //in seconds 
	
	public Song(String _title, int _length) {
		this.title = _title;
		this.length = _length;
	}
	
	public Song() {
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String _title) {
		this.title = _title;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int _length) {
		this.length = _length;
	}
	
	public String toMinutes() {
		int minutes;
		int seconds;
		
		minutes = length / 60;
		seconds = length % 60;
		
		return "[" + minutes + ":" + seconds + "]";
	}

	@Override
	public String toString() {
		
		return "Song title: " + title + ", length: " + toMinutes();
	}
	
	

}
