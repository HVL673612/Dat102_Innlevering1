package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import java.util.Arrays;

public class Filmarkiv implements FilmarkivADT {
	
	private static final int DEFAULT_FILM_KAPASITET = 10;
	private Film[] filmArray;
	private int antall;
	
	public Filmarkiv() {
		this(DEFAULT_FILM_KAPASITET);
	}
	
	public Filmarkiv(int størellse) {
		filmArray = new Film[størellse];
		antall = 0;
	}
	@Override
	public Film finnFilm(int nr) {
		for(int i = 0; i < antall; i++) {
			if(filmArray[i].getFilmNr() == nr) {
				return filmArray[i]; 
			}
		}
		return null;
	}
	
	private void UtvidArray() {
		filmArray = Arrays.copyOf(filmArray, filmArray.length*2);
	}
	
	@Override
	public void leggTilFilm(Film nyFilm) {
		if(filmArray.length == antall) {
			UtvidArray();
		}
		filmArray[antall] = nyFilm;
		antall++;
	}
	
	@Override
	public boolean slettFilm(int filmnr) {
		for(int i = 0; i < antall; i++) {
			if(filmArray[i].getFilmNr() == filmnr) {
				filmArray[i] = filmArray[antall - 1];
				filmArray[antall - 1] = null;
				antall--;
				return true;
			}
		}
		return false;
	}
	
	@Override
	public Film[] soekTittel(String delstreng) {
		Film[] titelSok = new Film[antall];
		int index = 0;
		for(int i = 0; i < antall; i++) {
			if(filmArray[i].getTittel().contains(delstreng)) {
				titelSok[index] = filmArray[i];
			}
		}
		
		return trimTab(titelSok, index);
	}
	@Override
	public Film[] soekProdusent(String delstreng) {
		Film[] produsentSok = new Film[antall];
		int index = 0;
		for(int i = 0; i < antall; i++) {
			if(filmArray[i].getProdusent().contains(delstreng)) {
				produsentSok[index] = filmArray[i];
			}
		}
		
		return trimTab(produsentSok, index);
	}
	
	
	@Override
	public int antall(Sjanger sjanger) {
		int antSjanger = 0;
		for(int i = 0; i < antall; i++) {
			if(filmArray[i].getSjanger() == sjanger) {
				antSjanger++;
			}
		}
		return antSjanger;
	}
	
	@Override
	public int antall() {
		return antall;
	}
	
	private Film[] trimTab(Film[] tab, int n) {
	// n er antall elementer
		Film[] nytab = new Film[n];
		int i = 0;
		
		while (i < n) {
			nytab[i] = tab[i];
			i++;
		}
		return nytab;
	}
}
