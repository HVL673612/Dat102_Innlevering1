package no.hvl.data102.filmarkiv.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;
import no.hvl.data102.filmarkiv.impl.Sjanger;


public class FilmarkivTest {
	
	private Filmarkiv filmarkiv;
    private Film film1, film2;

    @BeforeEach
    public void setUp() throws Exception {
        filmarkiv = new Filmarkiv(10);
        film1 = new Film(1, 2001, "Produsent1", "Tittel1", "FilmSelskap1", Sjanger.ACTION);
        film2 = new Film(2, 2002, "Produsent2", "Tittel2", "FilmSelskap2", Sjanger.DRAMA);
        filmarkiv.leggTilFilm(film1);
        filmarkiv.leggTilFilm(film2);
    }

    @Test
    public void testLeggTilOgFinnFilm() {
        filmarkiv.leggTilFilm(new Film(3, 2003, "Produsent3", "Tittel3","FilmSelskap3", Sjanger.SCIFI));
        assertNotNull(filmarkiv.finnFilm(3));
    }

    @Test
    public void testSlettFilm() {
        assertTrue(filmarkiv.slettFilm(1));
        assertNull(filmarkiv.finnFilm(1));
    }

    @Test
    public void testSoekTittel() {
        Film[] funnet = filmarkiv.soekTittel("Tittel1");
        assertEquals(1, funnet.length);
        assertEquals(film1, funnet[0]);
    }

    @Test
    public void testSoekProdusent() {
        Film[] funnet = filmarkiv.soekProdusent("Produsent2");
        assertEquals(1, funnet.length);
        assertEquals(film2, funnet[0]);
    }

    @Test
    public void testAntall() {
        assertEquals(2, filmarkiv.antall());
        assertEquals(1, filmarkiv.antall(Sjanger.ACTION));
        assertEquals(1, filmarkiv.antall(Sjanger.DRAMA));
    }

}
