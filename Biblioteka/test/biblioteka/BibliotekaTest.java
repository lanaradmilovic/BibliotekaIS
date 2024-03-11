package biblioteka;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import biblioteka.interfejs.BibliotekaInterfejs;
import biblioteka.interfejs.BibliotekaInterfejsTest;

class BibliotekaTest extends BibliotekaInterfejsTest {
	

	@Override
	public BibliotekaInterfejs getInstance() {
		return new Biblioteka();
	}

}
