package cl.uchile.dcc.scrabble.gui;


import cl.uchile.dcc.scrabble.gui.nativeClasses.ScrabbleFloat;
import cl.uchile.dcc.scrabble.gui.nativeClasses.ScrabbleString;
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
    private double testDouble;

    @BeforeEach
    public void setUp() {
        seed = new Random().nextInt();
        rng = new Random(seed);
        testDouble = rng.nextDouble();
        testScrabbleFloat = new ScrabbleFloat(testDouble);
    }

    @RepeatedTest(20)
    public void constructorTest() {
        double otherDouble;
        do {
            otherDouble = rng.nextDouble();
        }
        while (Double.compare(otherDouble, testDouble) == 0);
        var expected = new ScrabbleFloat(testDouble);
        var notExpected = new ScrabbleFloat(otherDouble);

        assertEquals(expected, testScrabbleFloat);
        assertNotEquals(notExpected, testScrabbleFloat);
        assertEquals(expected.hashCode(), testScrabbleFloat.hashCode());
        assertNotEquals(notExpected.hashCode(), testScrabbleFloat.hashCode());
    }

    /**
     * El metodo toString de nuestro objeto deberia tener el mismo comportamiento que Double.toString
     */
    @RepeatedTest(20)
    public void toStringTest() {
        double value = testScrabbleFloat.getValue();
        String fakeDouble = "2.o";
        String expectedString = Double.toString(value);
        assertEquals(expectedString, testScrabbleFloat.toString());
        assertNotEquals(fakeDouble, testScrabbleFloat.toString());
    }

    @RepeatedTest(20)
    public void toFloatTest() {
        double expValue = testScrabbleFloat.getValue();
        double unexpValue = rng.nextDouble();
        do {
            unexpValue = rng.nextDouble();
        } while (Double.compare(expValue, unexpValue) == 0);
        assertEquals(testScrabbleFloat, testScrabbleFloat.asScrabbleFloat());
        assertNotEquals(testScrabbleFloat, new ScrabbleFloat(unexpValue).asScrabbleFloat());
    }

    @RepeatedTest(20)
    public void toScrabbleStringTest() {
        String expstr = testScrabbleFloat.toString();
        var expected = new ScrabbleString(expstr);
        var otherFloat = rng.nextDouble();
        do {
            otherFloat = rng.nextDouble();
        } while (otherFloat == testScrabbleFloat.getValue());
        var unexpected = new ScrabbleString(Double.toString(otherFloat));
        assertEquals(expected, testScrabbleFloat.asScrabbleString());
        assertNotEquals(unexpected, testScrabbleFloat.asScrabbleString());
    }


}
