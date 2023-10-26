package en.cdarchive;

public class cdArchiveTest {

	public static void main(String[] args) {
		
		System.out.println("--- Test Song ---");
		Song s1 = new Song("Ciao", 134);
		System.out.println(s1.toMinutes());
		
		Song s2 = new Song("Albero", 216);
		Song s3 = new Song("Sedia", 86);
		CD cd1 = new CD();
		
		System.out.println("--- Test CD ---");
		
		cd1.listSong();
		
		cd1.addSong(s1);
		cd1.addSong(s2);
		cd1.addSong(s3);
		
		cd1.listSong();
		
		cd1.removeSong(1);
		
		cd1.listSong();
	}
}
