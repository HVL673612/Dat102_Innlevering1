package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import java.io.*;
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
		
		// legg inn en del forhåndsdefinerte filmer for å teste metodene
		Film  film1 = new Film(1, 2001, "Produsent1", "Tittel1", "FilmSelskap1", Sjanger.ACTION);
		Film  film2 = new Film(2, 2002, "Produsent2", "Tittel2", "FilmSelskap2", Sjanger.DRAMA);
		
		
		filmarkiv.leggTilFilm(film1);
		filmarkiv.leggTilFilm(film2);
		// ..
		// TODO
		
		//meny ting
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("1. Ligg till Film");
			/*
			 * resten av meny valgene nedover her 
			 */
			int valg = scanner.nextInt();

		}
	}

}
