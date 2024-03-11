package biblioteka;

import java.util.Objects;

public class Autor {
	
	//javni tekst
	private String ime;
	
	private String prezime;

	public String getIme() {
		return ime;
	}
	
	public Autor() {}
	
	public Autor(String ime, String prezime) {
		this.setIme(ime);
		this.setPrezime(prezime);
	}

	public void setIme(String ime) {
		if (ime == null) throw new NullPointerException("Ime ne sme biti null.");
		if(ime.isEmpty()) throw new IllegalArgumentException("Ime ne sme biti prazno");
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		if (prezime == null) throw new NullPointerException("prezime ne sme biti null.");
		if(prezime.isEmpty()) throw new IllegalArgumentException("prezime ne sme biti prazno");
		this.prezime = prezime;
	}

	@Override
	public String toString() {
		return "Autor [ime=" + ime + ", prezime=" + prezime + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(ime, prezime);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		return Objects.equals(ime, other.ime) && Objects.equals(prezime, other.prezime);
	}
	
}
