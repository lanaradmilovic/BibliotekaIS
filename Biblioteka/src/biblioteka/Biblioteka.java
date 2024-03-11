package biblioteka;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import biblioteka.interfejs.BibliotekaInterfejs;
import util.VremenskiServis;

public class Biblioteka implements BibliotekaInterfejs {
	
	private List<Knjiga> knjige = new ArrayList<Knjiga>();
	private VremenskiServis s;
	public Biblioteka(VremenskiServis s) {
		this.s=s;
	}

	@Override
	public LocalDateTime dodajKnjigu(Knjiga k) {
		if (k == null)
			throw new NullPointerException("Knjiga ne sme biti null");
		
		if (knjige.contains(k))
			throw new IllegalArgumentException("Knjiga vec postoji u bilioteci");
		
		knjige.add(k);
		return s.vratiVreme("Beograd");
	}

	@Override
	public LocalDateTime obrisiKnjigu(Knjiga k) {
		if (k == null)
			throw new NullPointerException("Knjiga ne sme biti null");
		
		if (!knjige.contains(k))
			throw new IllegalArgumentException("Knjiga ne postoji u bilioteci");	
		
		knjige.remove(k);
		
		return s.vratiVreme("Beograd");
	}

	@Override
	public List<Knjiga> vratiSveKnjige() {
		return knjige;
	}

	@Override
	public List<Knjiga> pronadjiKnjigu(Autor autor, long isbn, String naslov, String izdavac) {
		if (autor == null && isbn == 0 && naslov == null && izdavac == null)
			throw new IllegalArgumentException("Morate uneti bar jedan kriterijum");
		
		List<Knjiga> rezultati = new ArrayList<Knjiga>();

		for (Knjiga k : knjige)
			if ( k.getNaslov().toUpperCase().contains(naslov.toUpperCase())  )
				rezultati.add(k);
		
		return rezultati;
	}

}
