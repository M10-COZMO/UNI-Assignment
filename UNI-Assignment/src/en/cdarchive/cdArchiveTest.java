package en.cdarchive;

public class cdArchiveTest {

	public static void main(String[] args) {
		
		System.out.println("--- Test Song ---");
		Song s1 = new Song("Ciao", 134);
		System.out.println(s1.toMinutes());
		
		Song s2 = new Song("Albero", 216);
		Song s3 = new Song("Sedia", 86);
		CD cd1 = new CD("Titolo1", "Autore1");
		
		System.out.println("--- Test CD ---");
		
		cd1.listSong();
		
		cd1.addSong(s1);
		cd1.addSong(s2);
		cd1.addSong(s3);
		
		cd1.listSong();
		
		cd1.removeSong(1);
		
		cd1.listSong();
		
		System.out.println("-- Specific Number ---");
		System.out.println(cd1.getSong(1));
		System.out.println("--- Random Number ---");
		System.out.println(cd1.randomSong());
		
		System.out.println("--- Test Archive ---");
		Song s4 = new Song("Tavolo", 411);
		Song s5 = new Song("Buongiorno", 198);
		CD cd2 = new CD("Titolo2", "Autore2");
		cd2.addSong(s4);
		cd2.addSong(s5);
		CdArchive cdarchive = new CdArchive();
		cdarchive.listCD();
		cdarchive.addCD(cd1);
		cdarchive.addCD(cd2);
		cdarchive.listCD();
		
		System.out.println("-- Specific Number ---");
		System.out.println(cdarchive.getCD(1));
		System.out.println("--- Random Number ---");
	}
}
