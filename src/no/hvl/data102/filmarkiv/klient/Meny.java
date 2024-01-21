package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class Meny {

	private Tekstgrensesnitt tekstgr;
	private FilmarkivADT filmarkiv;

	public Meny(FilmarkivADT filmarkiv) {
		tekstgr = new Tekstgrensesnitt();
		this.filmarkiv = filmarkiv;
	}

	public void start() {
		
		Film  film1 = new Film(1, 2001, "Produsent1", "Tittel1", "FilmSelskap1", Sjanger.ACTION);
		Film  film2 = new Film(2, 2002, "Produsent2", "Tittel2", "FilmSelskap2", Sjanger.DRAMA);
		
		
		filmarkiv.leggTilFilm(film1);
		filmarkiv.leggTilFilm(film2);
		// legg inn en del forhåndsdefinerte filmer for å teste metodene
		// ..
		// TODO
	}

}
