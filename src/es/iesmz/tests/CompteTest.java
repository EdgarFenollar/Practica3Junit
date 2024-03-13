package es.iesmz.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CompteTest {

    @BeforeEach
    public void before(){
        System.out.println("EXECUTE PROVA");
    }

    // TEST compruebaIBAN

    @Test
    public void test1() {
        Compte c1 = new Compte("prueba", "edgar");
        assertTrue(c1.compruebaIBAN("ES6621000418401234567891"));
    }

    @Test
    public void test2() {
        Compte c1 = new Compte("prueba", "edgar");
        assertTrue(c1.compruebaIBAN("ES6000491500051234567892"));
    }

    @Test
    public void test3() {
        Compte c1 = new Compte("prueba", "edgar");
        assertTrue(c1.compruebaIBAN("ES9420805801101234567891"));
    }

    @Test
    public void test4() {
        Compte c1 = new Compte("prueba", "edgar");
        assertFalse(c1.compruebaIBAN("ES7600246912501234567891"));
    }

    @Test
    public void test5() {
        Compte c1 = new Compte("prueba", "edgar");
        assertFalse(c1.compruebaIBAN("ES4721000418401234567891"));
    }

    @Test
    public void test6() {
        Compte c1 = new Compte("prueba", "edgar");
        assertFalse(c1.compruebaIBAN("ES8200491500051234567892"));
    }

    // TEST generaIBAN

    @Test
    public void test7() {
        Compte c1 = new Compte("prueba", "edgar");
        assertEquals("ES7100302053091234567895", c1.generaIBAN("0030","2053","09","1234567895"));
    }

    @Test
    public void test8() {
        Compte c1 = new Compte("prueba", "edgar");
        assertEquals("ES1000492352082414205416", c1.generaIBAN("0049","2352","08","2414205416"));
    }

    @Test
    public void test9() {
        Compte c1 = new Compte("prueba", "edgar");
        assertEquals("ES1720852066623456789011", c1.generaIBAN("2085","2066","62","3456789011"));
    }

    @Test
    public void test10() {
        Compte c1 = new Compte("prueba", "edgar");
        assertEquals(null, c1.generaIBAN("2085","2066","62","3456AE9011"));
    }

    @Test
    public void test11() {
        Compte c1 = new Compte("prueba", "edgar");
        assertEquals(null, c1.generaIBAN("208","2066","62","3456789011"));
    }

    @Test
    public void test12() {
        Compte c1 = new Compte("prueba", "edgar");
        assertEquals(null, c1.generaIBAN("2080","20A6","62","3456789011"));
    }

    @Test
    public void test13() {
        Compte c1 = new Compte("prueba", "edgar");
        assertEquals(null, c1.generaIBAN("2080","2086","6","3456789011"));
    }

    @Test
    public void test14() {
        Compte c1 = new Compte("prueba", "edgar");
        assertEquals(null, c1.generaIBAN("2080","20A6","63","345678911"));
    }


}
