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
			System.out.println("Tast 1 for å legge til en film");
			System.out.println("Tast 2 for å søke etter tittel");
			System.out.println("Tast 3 for å søke etter produsent");
			System.out.println("Tast 4 for filmarkiv");
			System.out.println("Tast 5 for å slette film");
			System.out.println("Tast 6 for å stenge scanner");
			
			int valg = scanner.nextInt();
			
			switch(valg) {
			case 1:
				Film nyfilm = tekstgr.lesFilm();
				filmarkiv.leggTilFilm(nyfilm);
				break;
			case 2:
				System.out.println("Skriv inn tittel: ");
				String tittelsok = scanner.next();
				tekstgr.skrivUtFilmDelstrengITittel(filmarkiv,tittelsok);
				break;
			case 3:
				System.out.println("Skriv inn produsent: ");
				String produsentsok = scanner.next();
				tekstgr.skrivUtFilmProdusent(filmarkiv, produsentsok);
				break;
			case 4:
				tekstgr.skrivUtStatistikk(filmarkiv);
			case 5:
				System.out.println("Skriv inn filmnr: ");
				int filmNr = scanner.nextInt();
				boolean sjekk = filmarkiv.slettFilm(filmNr);
				tekstgr.sjekkFilmSlettet(filmNr, sjekk);
				break;
			case 6:
				scanner.close();
				return;
				
				
			}

		}
	}

}
