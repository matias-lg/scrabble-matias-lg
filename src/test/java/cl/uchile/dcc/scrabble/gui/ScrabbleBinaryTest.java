package cl.uchile.dcc.scrabble.gui;

import cl.uchile.dcc.scrabble.gui.nativeClasses.ScrabbleBinary;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Random;

import static org.apache.commons.lang3.RandomStringUtils.random;

public class ScrabbleBinaryTest {
    private ScrabbleBinary testBinary;
    private long seed;
    private Random rng;
    char[] binaries = {'0','1'};
    String randomString;
    private final int LENGTH = 20;

    @BeforeEach
    public void setUp(){
        seed = new Random().nextInt();
        rng = new Random(seed);
        randomString = random(LENGTH, 0, 2, false, true, binaries, rng);
        testBinary = new ScrabbleBinary(randomString);
    }
    @RepeatedTest(20)
    public void constructorTest(){
        seed = new Random().nextInt();
        rng = new Random(seed);
        ScrabbleBinary expected = new ScrabbleBinary(randomString);
        ScrabbleBinary unexpected;
        String difRandomString;
        do {
            difRandomString = random(LENGTH, 0, 2, false, true, binaries, rng);
        } while (difRandomString.equals(randomString));
        unexpected = new ScrabbleBinary(difRandomString);
        assertEquals(expected, testBinary);
        assertNotEquals(unexpected, testBinary);
        assertEquals(expected.hashCode(), testBinary.hashCode());
    }
}
