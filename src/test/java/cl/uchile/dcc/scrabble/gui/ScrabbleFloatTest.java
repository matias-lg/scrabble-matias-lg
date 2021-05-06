package cl.uchile.dcc.scrabble.gui;


import cl.uchile.dcc.scrabble.gui.nativeClasses.ScrabbleFloat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/*
Test para la clase ScrabbleInt y sus metodos
 */
public class ScrabbleFloatTest {
    private ScrabbleFloat testScrabbleFloat;
    private int seed;
    private Random rng;
    private double rng_val;

    @BeforeEach
    public void setUp(){
        seed = new Random().nextInt();
        rng = new Random(seed);
        rng_val = rng.nextDouble();
        testScrabbleFloat = new ScrabbleFloat(rng_val);
    }

    @RepeatedTest(20)
    public void constructorTest(){
        double not_expected_val;
        do {
            not_expected_val = rng.nextDouble();
        }
        while (Double.compare(not_expected_val, rng_val) == 0);
        var expectedScrabbleFloat = new ScrabbleFloat(rng_val);
        var notExpectedScrabbleFloat = new ScrabbleFloat(not_expected_val);

        assertEquals(expectedScrabbleFloat, testScrabbleFloat);
        assertNotEquals(notExpectedScrabbleFloat, testScrabbleFloat);
        assertEquals(expectedScrabbleFloat.hashCode(), testScrabbleFloat.hashCode());
    }

    /**
     * El metodo toString de nuestro objeto deberia tener el mismo comportamiento que Double.toString
     */
    @RepeatedTest(20)
    public void toStringTest(){
        double value = testScrabbleFloat.getValue();
        String fakeDouble = "2.o";
        String expectedString = Double.toString(value);
        assertEquals(expectedString, testScrabbleFloat.toString());
        assertNotEquals(fakeDouble, testScrabbleFloat.toString());
    }

}
