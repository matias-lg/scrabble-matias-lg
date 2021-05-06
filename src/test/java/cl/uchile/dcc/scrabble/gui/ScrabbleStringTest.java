package cl.uchile.dcc.scrabble.gui;

import cl.uchile.dcc.scrabble.gui.nativeClasses.ScrabbleString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ScrabbleStringTest {
    private ScrabbleString testScrabbleString;
    private int seed;
    private Random rng;
    private String randomString;
    private final int STR_SIZE = 100;

    @BeforeEach
    public void setUp(){
        seed = new Random().nextInt();
        rng = new Random(seed);
        randomString = random(STR_SIZE, 0, Character.MAX_CODE_POINT, true, true, null, rng);
        testScrabbleString = new ScrabbleString(randomString);
    }
    @RepeatedTest(20)
    public void constructorTest(){
        /* Se crea un ScrabbleString con string igual al de setUp */
        var expectedScrabbleString = new ScrabbleString(randomString);
        /* String distinto al de setup */
        seed = new Random().nextInt();
        rng = new Random(seed);
        String difRandomString;
        /* Se crea un nuevo string en caso de ser igual al creado en setUp */
        do {
            difRandomString = random(STR_SIZE, 0, Character.MAX_CODE_POINT, true, true, null, rng);

        } while (randomString.equals(difRandomString));
        var notExpectedScrabbleString = new ScrabbleString(difRandomString);

        assertEquals(expectedScrabbleString, testScrabbleString);
        assertNotEquals(notExpectedScrabbleString, testScrabbleString);

        assertEquals(expectedScrabbleString.hashCode(), testScrabbleString.hashCode());
        assertNotEquals(notExpectedScrabbleString.hashCode(), testScrabbleString.hashCode());
    }
}
