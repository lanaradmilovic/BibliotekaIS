package biblioteka.interfejs;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import biblioteka.Knjiga;

public abstract class BibliotekaInterfejsTest {
	
	BibliotekaInterfejs b;
	Knjiga k, k2;
	public abstract BibliotekaInterfejs getInstance();

	@BeforeEach
	void setUp() throws Exception {
		b = getInstance();
		
		k = new Knjiga();
		k.setIsbn(1234567890);
		k.setNaslov("Knjiga 1");
		k.setIzdanje(1);
		k.setIzdavac("Laguna");
		
		k2 = new Knjiga();
		k2.setIsbn(1234566700);
		k2.setNaslov("Knjiga 2");
		k2.setIzdanje(1);
		k2.setIzdavac("Vulkan");
	}

	@AfterEach
	void tearDown() throws Exception {
		b=null;
		k=null;
		k2=null;
	}

	@Test
	void testDodajKnjiguNull() {
		assertThrows(java.lang.NullPointerException.class,
				() -> b.dodajKnjigu(null));
	}

	@Test
	void testObrisiKnjiguDuplikat() {
		b.dodajKnjigu(k); //prvi put sve okej
		
		assertThrows(java.lang.IllegalArgumentException.class,
				() -> b.dodajKnjigu(k)); //drugi put greska
	}
	@Test
	void testObrisiKnjiguNull() {
		assertThrows(java.lang.NullPointerException.class,
				() -> b.obrisiKnjigu(null));
	}
	
	@Test
	void testObrisiKnjiguNePostoji() {
		b.dodajKnjigu(k);
		assertThrows(java.lang.IllegalArgumentException.class,
				() -> b.obrisiKnjigu(k2));
	}
	
	@Test
	void testObrisiKnjigu() {
		b.dodajKnjigu(k);
		b.dodajKnjigu(k2);
		
		b.obrisiKnjigu(k);
		List<Knjiga> sve = b.vratiSveKnjige();
		assertEquals(1, sve.size());
		assertEquals(k2, sve.get(0));
	}
	
	@Test
	void testDodajKnjigu() {
		b.dodajKnjigu(k); 
		
		List<Knjiga> sve = b.vratiSveKnjige();
		
		assertEquals(1, sve.size());
		assertEquals(k, sve.get(0));
		
	}
	
	@Test
	void testDodajKnjiguVisePuta() {
		b.dodajKnjigu(k); 
		b.dodajKnjigu(k2); 
		
		List<Knjiga> sve = b.vratiSveKnjige();
		
		assertEquals(2, sve.size());
		assertTrue(sve.contains(k));
		assertTrue(sve.contains(k2));
		
	}

	@Test
	void testPronadjiKnjigu() {
		assertThrows(java.lang.IllegalArgumentException.class, 
				() -> b.pronadjiKnjigu(null, 0, null, null));
	}
	
	@Test
	void testPronadjiKnjiguNemaRezultata() {
		b.dodajKnjigu(k);
		b.dodajKnjigu(k2);
		
		List<Knjiga> rez = b.pronadjiKnjigu(null, 0, "avantura", null);
		assertEquals(0, rez.size());
		
	}

	@Test
	void testPronadjiKnjiguJedna() {
		b.dodajKnjigu(k);
		b.dodajKnjigu(k2);
		
		List<Knjiga> rez = b.pronadjiKnjigu(null, 0, "1", null);
		assertEquals(1, rez.size());
		assertEquals(k, rez.get(0));
		
	}
	
	@Test
	void testPronadjiKnjiguVise() {
		b.dodajKnjigu(k);
		b.dodajKnjigu(k2);
		
		List<Knjiga> rez = b.pronadjiKnjigu(null, 0, "knj", null);
		assertEquals(2, rez.size());
		assertTrue(rez.contains(k));
		assertTrue(rez.contains(k2));
		
	}
}
