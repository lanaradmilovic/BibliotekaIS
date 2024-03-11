package biblioteka;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AutorTest {
	Autor a;

	@BeforeEach
	void setUp() throws Exception {
		a = new Autor();
	}

	@AfterEach
	void tearDown() throws Exception {
		a=null; //dereferenciranje objekta za garbage collector
	}


	@Test
	void testAutor() {
		assertNotNull(a);
		assertNull(a.getIme());
		assertNull(a.getPrezime());
	}

	@Test
	void testAutorStringString() {
		a = new Autor("Pera", "Peric");
		
		assertNotNull(a);
		assertEquals("Pera", a.getIme());
		assertEquals("Peric", a.getPrezime());
	}
	
	@Test
	void testSetIme() {
		a.setIme("Zika");
		
		assertEquals("Zika", a.getIme());
	}
	
	@Test
	void testSetImeNull() {
		Exception e = assertThrows(java.lang.NullPointerException.class, 
				() -> a.setIme(null));
		assertEquals("Ime ne sme biti null.", e.getMessage());
	}
	
	@Test
	void testSetImePrazan() {
		Exception e = assertThrows(java.lang.IllegalArgumentException.class, 
				() -> a.setIme(""));
		assertEquals("Ime ne sme biti prazno", e.getMessage());
	}


	@Test
	void testSetPrezime() {
		a.setPrezime("Peric");
		
		assertEquals("Peric", a.getPrezime());
	}
	
	@Test
	void testSetPrezimeNull() {
		Exception e = assertThrows(java.lang.NullPointerException.class, 
				() -> a.setPrezime(null));
		assertEquals("prezime ne sme biti null.", e.getMessage());
	}
	
	@Test
	void testSetPrezimePrazan() {
		Exception e = assertThrows(java.lang.IllegalArgumentException.class, 
				() -> a.setPrezime(""));
		assertEquals("prezime ne sme biti prazno", e.getMessage());
	}

	@Test
	void testToString() {
		a.setIme("Mika");
		a.setPrezime("Mikic");
		
		String s = a.toString();
		
		assertTrue(s.contains("Mika"));
		assertTrue(s.contains("Mikic"));
	}

	@Test
	void testEqualsObject() {
		Autor b =a;
		assertTrue(a.equals(b)); 
		
	}
	@Test
	void testEqualsObjectNull() {
		assertFalse(a.equals(null)); 
		
	}
	@Test
	void testEqualsObjectDrugaKlasa() {
		assertFalse(a.equals(new Knjiga())); 	
	}
	@Test
	void testEqualsObjectSveOk() {
		a.setIme("Pera");
		a.setPrezime("Peric");
		
		Autor a2 = new Autor("Pera", "Peric");
		assertTrue(a.equals(a2));
	}
	
	@ParameterizedTest
	@CsvSource({
		"Pera, Peric, Pera, Peric, true",
		"Pera, Peric, Mika, Peric, false",
		"Pera, Peric, Pera, Mikic, false",
		"Pera, Peric, Mika, Mikic, false",
	})
	void testEqualsObjectSveOk(String ime1, String prezime1, String ime2, String prezime2, boolean eq) {
		a.setIme(ime1);
		a.setPrezime(prezime1);
		
		Autor a2 = new Autor(ime2, prezime2);
		assertEquals(eq, a.equals(a2));
	}
}
