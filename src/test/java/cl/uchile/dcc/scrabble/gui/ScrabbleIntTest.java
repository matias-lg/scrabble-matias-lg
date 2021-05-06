package cl.uchile.dcc.scrabble.gui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ScrabbleIntTest {
    private ScrabbleInt testScrabbleInt;
    private int seed;
    private Random rng;
    private int rng_val;

    @BeforeEach
    public void setUp() {
        seed = new Random().nextInt();
        rng = new Random(seed);
        rng_val = rng.nextInt();
        testScrabbleInt = new ScrabbleInt(rng_val);
    }

    @RepeatedTest(20)
    public void constructorTest() {
        int rng_val2 = rng.nextInt();
        var notExpectedScrabbleInt = new ScrabbleInt(rng_val2);
        do {
            rng_val2 = rng.nextInt();
            notExpectedScrabbleInt = new ScrabbleInt(rng_val2);
        } while (rng_val == rng_val2);

        var expectedScrabbleInt = new ScrabbleInt(rng_val);

        assertEquals(expectedScrabbleInt, testScrabbleInt);
        assertEquals(expectedScrabbleInt.hashCode(), testScrabbleInt.hashCode());
        assertNotEquals(notExpectedScrabbleInt, testScrabbleInt);
    }

}
