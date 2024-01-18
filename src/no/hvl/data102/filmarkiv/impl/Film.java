package no.hvl.data102.filmarkiv.impl;

import java.util.Objects;

public class Film {
	
	private int filmNr;
	private int lanserigsAar;
	
	private String produsent;
	private String tittel;
	private String filmSelskap;
	
	private Sjanger sjanger;
	
	public Film() {
	}
	
	public Film(int filmNr, int lanserigsAar, String produsent, String tittel,String filmSelskap, Sjanger sjanger) {
		this.setFilmNr(filmNr);
		this.setLanserigsAar(lanserigsAar);
		this.setProdusent(produsent);
		this.setTittel(tittel);
		this.setSjanger(sjanger);
		this.setFilmSelskap(filmSelskap);
/*		
 *		this.filmNr 		= filmNr;
 *		this.lanserigsAar 	= lanserigsAar;
 *		this.produsent 		= produsent;
 *		this.tittel			= tittel;
 *		this.sjanger		= sjanger;
*/		
	}

	public int getFilmNr() {
		return filmNr;
	}

	public void setFilmNr(int filmNr) {
		this.filmNr = filmNr;
	}

	public int getLanserigsAar() {
		return lanserigsAar;
	}

	public void setLanserigsAar(int lanserigsAar) {
		this.lanserigsAar = lanserigsAar;
	}

	public String getProdusent() {
		return produsent;
	}

	public void setProdusent(String produsent) {
		this.produsent = produsent;
	}

	public String getTittel() {
		return tittel;
	}

	public void setTittel(String tittel) {
		this.tittel = tittel;
	}

	public String getFilmSelskap() {
		return filmSelskap;
	}

	public void setFilmSelskap(String filmSelskap) {
		this.filmSelskap = filmSelskap;
	}

	public Sjanger getSjanger() {
		return sjanger;
	}

	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}

	@Override
	public int hashCode() {
		return Objects.hash(filmNr);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return filmNr == other.filmNr;
	}
	
}
