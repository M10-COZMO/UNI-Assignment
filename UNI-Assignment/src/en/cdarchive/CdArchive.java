package en.cdarchive;

import java.util.ArrayList;
import java.util.Random;

public class CdArchive {
	
	private String title;
	private ArrayList<CD> cDList = new ArrayList<>();
	
	public CdArchive() {}

	public CdArchive(String _title, ArrayList<CD> _cDList) {
		super();
		this.title = _title;
		cDList = _cDList;
	}
	
	public CdArchive(String _title) {
		super();
		this.title = _title;
	}

	// getters and setters
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ArrayList<CD> getCDList() {
		return cDList;
	}

	public void setCDList(ArrayList<CD> cDList) {
		cDList = cDList;
	}
	
	// required methods
	
	public void addCD(CD cdToAdd) {
		cDList.add(cdToAdd);
	}
	
	public CD getCD(int indexOfTheCD) {
		return cDList.get(indexOfTheCD);
	}
	
	public void printCD(int indexOfTheCD) {
		System.out.println(getCD(indexOfTheCD));
	}
	
	public void listCD() {
		if(cDList.size()==0) {
			System.out.println("This archive is empty.");
		} else {
			System.out.println("CD in the archive:");
			for (int i = 0; i < cDList.size(); i++) {
				System.out.println(i + ". " + cDList.get(i).printCDInfo());
			}
		}
	}
	
	public void removeCD(int indexOfTheSongToRemove) {
		cDList.remove(indexOfTheSongToRemove);
	}
	 
	public void randomCD() {
		Random random = new Random();
		int randomNumber = random.nextInt(cDList.size());
		System.out.println("The random cd is...");
		getCD(randomNumber).showCDInfo();
	}
	
	
}
