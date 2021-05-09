package cl.uchile.dcc.scrabble.gui;

import cl.uchile.dcc.scrabble.gui.nativeClasses.ScrabbleBinary;
import cl.uchile.dcc.scrabble.gui.nativeClasses.ScrabbleFloat;
import cl.uchile.dcc.scrabble.gui.nativeClasses.ScrabbleInt;
import cl.uchile.dcc.scrabble.gui.nativeClasses.ScrabbleString;
import cl.uchile.dcc.scrabble.gui.natives.ScrabbleNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/*
Test para la clase ScrabbleInt y sus metodos
 */
public class ScrabbleIntTest {
    private static final int BINARY_LENGTH = 100;
    private ScrabbleInt testScrabbleInt;
    private int seed;
    private Random rng;
    private int testInt;

    /*  Se crea un ScrabbleInt aleatorio en cada iteración con el fin de hacer los test más generales */
    @BeforeEach
    public void setUp() {
        seed = new Random().nextInt();
        rng = new Random(seed);
        testInt = rng.nextInt();
        testScrabbleInt = new ScrabbleInt(testInt);
    }

    @RepeatedTest(20)
    public void constructorTest() {
        ScrabbleNumber testfail = new ScrabbleInt(2);
        ScrabbleInt lol = new ScrabbleInt(2);
        int otherInt = rng.nextInt();
        var expected = new ScrabbleInt(testInt);
        ScrabbleInt notExpected;
        do {
            otherInt = rng.nextInt();
        } while (testInt == otherInt);
        notExpected = new ScrabbleInt(otherInt);
        assertEquals(expected, testScrabbleInt);
        assertEquals(expected.hashCode(), testScrabbleInt.hashCode());
        assertNotEquals(notExpected, testScrabbleInt);
        assertNotEquals(notExpected.hashCode(), testScrabbleInt.hashCode());
    }

    /**
     * El metodo toString de nuestro objeto deberia tener el mismo comportamiento que Integer.toString
     */
    @RepeatedTest(20)
    public void toStringTest() {
        int value = testScrabbleInt.getValue();
        String fakeInt = "one";
        String expectedString = Integer.toString(value);
        assertEquals(expectedString, testScrabbleInt.toString());
        assertNotEquals(fakeInt, testScrabbleInt.toString());
    }

    @RepeatedTest(20)
    public void StringtransformTest() {
        /*
         * Test para ScrabbleInt -> ScrabbleString
         * Se crea manualmente un ScrabbleString con valor el int de setUp en String
         */
        String expStr = Integer.toString(testInt);
        var expected = new ScrabbleString((expStr));
        /* Se crea manualmente un ScrabbleString con valor distinto al del int de setUp en String */
        int otherInt;
        String notExpStr;
        do {
            otherInt = rng.nextInt();
        } while (otherInt == testInt);
        notExpStr = Integer.toString(otherInt);
        var notExpected = new ScrabbleString(notExpStr);
        System.out.println(testScrabbleInt.asScrabbleString().getValue());


        assertEquals(expected, testScrabbleInt.asScrabbleString());
        assertNotEquals(notExpected, testScrabbleInt.asScrabbleString());
    }

    @RepeatedTest(20)
    public void FloatTransformTest() {
        /*
         * Test para ScrabbleInt --> ScrabbleFloat
         se hace el cast de testInt a double para crear el ScrabbleFloat esperado
        */
        double testDouble = testInt;
        double otherDouble;
        var expected = new ScrabbleFloat(testDouble);
        do {
            otherDouble = rng.nextDouble();
        } while (Double.compare(otherDouble, testDouble) == 0);
        var unexpected = new ScrabbleFloat(otherDouble);
        assertEquals(expected, new ScrabbleInt(testInt).asScrabbleFloat());
        assertNotEquals(unexpected, new ScrabbleInt(testInt).asScrabbleFloat());
    }

    @RepeatedTest(20)
    public void IntTransformTest() {
        /*
        Test para ScrabbleInt -> ScrabbleInt
        Se deberia obtener el mismo objeto
         */
        int otherInt = rng.nextInt();
        ScrabbleInt expected = new ScrabbleInt(testInt);
        do {
            otherInt = rng.nextInt();
        } while (testInt == otherInt);
        var notExpected = new ScrabbleInt(otherInt);
        assertEquals(expected, testScrabbleInt.asScrabbleInt());
        assertNotEquals(notExpected, testScrabbleInt.asScrabbleInt());
    }

    @RepeatedTest(20)
    public void BinaryTransformTest() {
        /*
        Test para ScrabbleInt -> ScrabbleBinary
         */
        var zeroInt = new ScrabbleInt(0);
        assertEquals(new ScrabbleBinary("0"), zeroInt.asScrabbleBinary());
        var randomString = random(BINARY_LENGTH, 0, 2, false, true, new char[]{'0', '1'}, rng);
        /*  */

    }
}
