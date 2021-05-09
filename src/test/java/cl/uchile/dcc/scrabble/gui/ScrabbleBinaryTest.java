package cl.uchile.dcc.scrabble.gui;

import cl.uchile.dcc.scrabble.gui.nativeClasses.ScrabbleBinary;
import cl.uchile.dcc.scrabble.gui.nativeClasses.ScrabbleString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ScrabbleBinaryTest {
    private ScrabbleBinary testBinary;
    private long seed;
    private Random rng;
    char[] binaries = {'0', '1'};
    String randomString;
    private final int LENGTH = 20;

    @BeforeEach
    public void setUp() {
        seed = new Random().nextInt();
        rng = new Random(seed);
        randomString = random(LENGTH, 0, 2, false, true, binaries, rng);
        testBinary = new ScrabbleBinary(randomString);
    }

    @RepeatedTest(20)
    public void constructorTest() {
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

    @RepeatedTest(20)
    public void toStringTest() {
        String expectedString = testBinary.getValue();
        ScrabbleBinary unexpected;
        String otherBinary;
        do {
            otherBinary = random(LENGTH, 0, 2, false, true, binaries, rng);
        } while (expectedString.equals(otherBinary));
        unexpected = new ScrabbleBinary(otherBinary);
        String fail = "imposible que pase!";

        assertEquals(expectedString, testBinary.toString());
        assertNotEquals(fail, testBinary.toString());
        assertNotEquals(unexpected.toString(), testBinary.toString());
    }

    @RepeatedTest(20)
    public void asScrabbleStringTest() {
        String expectedString = testBinary.getValue();
        var expected = new ScrabbleString(expectedString);
        String otherString;
        do {
            otherString = random(LENGTH, 0, 2, false, true, binaries, rng);
        } while (otherString.equals(expectedString));
        var unexpected = new ScrabbleString(otherString);
        assertEquals(expected, testBinary.asScrabbleString());
        assertNotEquals(unexpected, testBinary.asScrabbleString());
    }

}
