package no.hvl.data102.filmarkiv.klient;

import java.util.InputMismatchException;
import java.util.Scanner;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class Tekstgrensesnitt {

	// Leser inn opplysninger om en film fra tastatur og returnere et Film-objekt
	public Film lesFilm() {
		int filmNr = 0;
		int lanserigsAar = 0;
		Scanner scanner = new Scanner(System.in);
		 
		try {
		    System.out.println("Skriv inn film nummer: ");
		    filmNr = scanner.nextInt();
		    scanner.nextLine();
		 
			System.out.println("Skriv inn utgivelse år: ");
		    lanserigsAar = scanner.nextInt();
		    scanner.nextLine();
		} catch(InputMismatchException e) {
			System.out.println("Feil inndata, skriv et nummer: ");
			scanner.nextLine();
			return null;
		}
		    
		    System.out.println("Skriv inn produsent: ");
		    String prdusent = scanner.nextLine();
		    
		    System.out.println("Skriv inn tittel: ");
		    String tittel = scanner.nextLine();
		    
		    System.out.println("Skriv inn filmselskap: ");
		    String filmSelskap = scanner.nextLine();
		    
		    System.out.println("Skriv inn sjanger (e.g., ACTION, DRAMA): ");
		    String genre = scanner.nextLine();
		    Sjanger sjanger = Sjanger.valueOf(genre.toUpperCase());
//		    scanner.close();
		    
		    return new Film(filmNr, lanserigsAar, prdusent, tittel, filmSelskap, sjanger) ;
		   
			
		}
	

	// Skriver ut en film med alle opplysninger på skjerm (husk tekst for sjanger)
	public void skrivUtFilm(Film film) {
		System.out.println("film nr: "+film.getFilmNr()+" utgivelse år: "+film.getLanserigsAar()
						+"\nTittel: "+ film.getTittel()+" produsent: "+ film.getProdusent()
						+" Sjanger: "+ film.getSjanger());
	}

	// Skriver ut alle filmer med en spesiell delstreng i tittelen
	public void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, String delstreng) {
		Film[] filmerMedDelStreng = arkiv.soekTittel(delstreng);
		
		if(filmerMedDelStreng.length == 0) {
			System.out.println("Ingen Filmer med delstrengen "+ delstreng);
		}else {
			for(Film film: filmerMedDelStreng) {
				skrivUtFilm(film);
			}
		}	
	}

	// Skriver ut alle Filmer av en produsent (produsent er delstreng)
	public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
		Film[] filmerMedDelStreng = arkiv.soekProdusent(delstreng);
		
		if(filmerMedDelStreng.length == 0) {
			System.out.println("Ingen filmprodusenter med delstrengen " + delstreng);
		}else {
			for(Film film: filmerMedDelStreng) {
				skrivUtFilm(film);
			}
		}
	}

	// Skriver ut en enkel statistikk som inneholder antall filmer totalt
	// og hvor mange det er i hver sjanger.
	public void skrivUtStatistikk(FilmarkivADT arkiv) {
		System.out.println("Antall Filmer i arkivet: " + arkiv.antall());
		
		for(Sjanger sjanger: Sjanger.values()) {
			System.out.println("Antall " + sjanger + " Filmer: " + arkiv.antall(sjanger));
		}
	}
	// osv ... andre metoder
	public void sjekkFilmSlettet(int filmNr, boolean sjekk) {
		if(sjekk) {
			System.out.println("Film nr. " + filmNr + " er slettet");
		} else {
			System.out.println("Feil. Film nr. " + filmNr + " er ikke slettet");
		}
	}

}
