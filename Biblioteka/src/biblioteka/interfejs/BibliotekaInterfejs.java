package biblioteka.interfejs;

import java.time.LocalDateTime;
import java.util.List;

import biblioteka.Autor;
import biblioteka.Knjiga;

public interface BibliotekaInterfejs {
	
	public LocalDateTime dodajKnjigu(Knjiga k);
	
	public LocalDateTime obrisiKnjigu(Knjiga k);
	
	public List<Knjiga> vratiSveKnjige();
	
	public List<Knjiga> pronadjiKnjigu(Autor autor, long isbn,
			String naslov, String izdavac);

}
