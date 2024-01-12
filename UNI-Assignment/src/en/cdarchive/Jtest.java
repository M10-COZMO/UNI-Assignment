package en.cdarchive;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Jtest {
	
	/*
	@Test
	void testCreateNewCD() {
		CD cd = new CD();
		cd.createNewCD();
		assertEquals("autore", cd.getAutor());
		assertEquals("titolo", cd.getTitle());
	}
	*/
	
	@Test
	void testSong(){
		Song song = new Song();
		song.setLength(123);
		song.setTitle("TitleOfTheSong");
		assertEquals(123, song.getLength());
		assertEquals("TitleOfTheSong", song.getTitle());
		assertEquals("[2:3]", song.toMinutes());
		assertEquals("Song title: TitleOfTheSong, length: [2:3]", song.toString());
	}
	
	@Test
	void testCD() {
		 CD cd = new CD("Title", "Autor");
		 Song s1 = new Song("Song1", 123);
		 Song s2 = new Song("Song2", 456);
		 cd.addSong(s1);
		 cd.addSong(s2);
		 assertEquals("Title", cd.getTitle());
		 assertEquals("Autor", cd.getAutor());
		 assertTrue(cd.getSongList().size() == 2);
		 cd.removeSong(1);
		 assertTrue(cd.getSongList().size() == 1);
	}
	
	@Test
	void testCdArchive() {
		CdArchive cdarchive = new CdArchive("ArchiveTitle");
		CD cd1 = new CD("Titlecd1", "Autorcd1");
		 Song s1 = new Song("Song1", 123);
		 Song s2 = new Song("Song2", 456);
		 CD cd2 = new CD("Titlecd2", "Autorcd2");
		 Song s3 = new Song("Song3", 789);
		 Song s4 = new Song("Song4", 123);
		cdarchive.addCD(cd1);
		cdarchive.addCD(cd2);
		assertEquals("ArchiveTitle", cdarchive.getTitle());
		 assertTrue(cdarchive.getCDList().size() == 2);
		 cdarchive.removeCD(1);
		 assertTrue(cdarchive.getCDList().size() == 1);
	}

}
