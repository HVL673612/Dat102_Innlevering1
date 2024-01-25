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
		    System.out.println("Enter film number:");
		    filmNr = scanner.nextInt();
		    scanner.nextLine();
		 
			System.out.println("Enter utgivelse år");
		    lanserigsAar = scanner.nextInt();
		    scanner.nextLine();
		} catch(InputMismatchException e) {
			System.out.println("inputt error, input et number");
			scanner.nextLine();
			return null;
		}
		    
		    System.out.println("Enter Produsent");
		    String prdusent = scanner.nextLine();
		    
		    System.out.println("Enter Tittel");
		    String tittel = scanner.nextLine();
		    
		    System.out.println("eneter Filmselskap");
		    String filmSelskap = scanner.nextLine();
		    
		    System.out.println("Enter sjanger (e.g., ACTION, DRAMA):");
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
			System.out.println("Ingen Filme produsenter med delstrengen "+ delstreng);
		}else {
			for(Film film: filmerMedDelStreng) {
				skrivUtFilm(film);
			}
		}
	}

	// Skriver ut en enkel statistikk som inneholder antall filmer totalt
	// og hvor mange det er i hver sjanger.
	public void skrivUtStatistikk(FilmarkivADT arkiv) {
		System.out.println("antall Filmer i arkivet: "+ arkiv.antall());
		
		for(Sjanger sjanger: Sjanger.values()) {
			System.out.println("antall "+sjanger+ "  Filmer: "+ arkiv.antall(sjanger));
		}
	}
	// osv ... andre metoder

}
