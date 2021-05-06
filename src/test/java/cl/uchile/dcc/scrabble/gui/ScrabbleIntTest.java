package cl.uchile.dcc.scrabble.gui;

import cl.uchile.dcc.scrabble.gui.nativeClasses.ScrabbleInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
/*
Test para la clase ScrabbleInt y sus metodos
 */
public class ScrabbleIntTest {
    private ScrabbleInt testScrabbleInt;
    private int seed;
    private Random rng;
    private int rng_val;
    
    /*  Se crea un ScrabbleInt aleatorio en cada iteración con el fin de hacer los test más generales */
    @BeforeEach
    public void setUp() {
        seed = new Random().nextInt();
        rng = new Random(seed);
        rng_val = rng.nextInt();
        testScrabbleInt = new ScrabbleInt(rng_val);
    }

    @RepeatedTest(20)
    public void constructorTest() {
        int expected_value = rng.nextInt();
        var expectedScrabbleInt = new ScrabbleInt(rng_val);
        var notExpectedScrabbleInt = new ScrabbleInt(expected_value);
        do {
            expected_value = rng.nextInt();
            notExpectedScrabbleInt = new ScrabbleInt(expected_value);
        } while (rng_val == expected_value);

        assertEquals(expectedScrabbleInt, testScrabbleInt);
        assertEquals(expectedScrabbleInt.hashCode(), testScrabbleInt.hashCode());
        assertNotEquals(notExpectedScrabbleInt, testScrabbleInt);
        assertNotEquals(notExpectedScrabbleInt.hashCode(), testScrabbleInt.hashCode());
    }

    /**
     * El metodo toString de nuestro objeto deberia tener el mismo comportamiento que Integer.toString
     */
    @RepeatedTest(20)
    public void toStringTest(){
        int value = testScrabbleInt.getValue();
        String fakeInt = "one";
        String expectedString = Integer.toString(value);
        assertEquals(expectedString, testScrabbleInt.toString());
        assertNotEquals(fakeInt, testScrabbleInt.toString());
    }

}
