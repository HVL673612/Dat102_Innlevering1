package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import java.io.*;
import java.util.Scanner;

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
			System.out.println("press 1 og enter for å Ligge till Film");
			System.out.println("press 3 ");
			System.out.println("press 4");
			System.out.println("press 5");
			System.out.println("press 6");
			System.out.println("press 7");
			System.out.println("press 8");
			System.out.println("press 9");
			/*
			 * resten av meny valgene nedover her 
			 */
			int valg = scanner.nextInt();
			
			switch(valg) {
			case 1:
				Film nyfilm = tekstgr.lesFilm();
				filmarkiv.leggTilFilm(nyfilm);
				break;
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
				
			}

		}
	}

}
