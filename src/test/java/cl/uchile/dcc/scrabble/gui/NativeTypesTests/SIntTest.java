package cl.uchile.dcc.scrabble.gui.NativeTypesTests;

import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import cl.uchile.dcc.scrabble.gui.natives.interfaces.INumber;
import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SBinary;
import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SFloat;
import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SInt;
import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SString;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

/*
Test para la clase SInt y sus metodos
 */
public class SIntTest {

  private static final int BINARY_LENGTH = 100;
  private SInt testSInt;
  private int seed;
  private Random rng;
  private int testInt;
  private double randomDouble;
  private int randomInt;
  private String randomBin;
  private SFloat randomSF;
  private SInt randomSI;
  private SBinary randomSB;

  /*  Se crea un SInt aleatorio en cada iteración con el fin de hacer los test más generales */
  @BeforeEach
  public void setUp() {
    seed = new Random().nextInt();
    rng = new Random(seed);
    testInt = rng.nextInt();
    testSInt = new SInt(testInt);
    /* other types for operations */
    randomDouble = rng.nextDouble();
    randomInt = rng.nextInt();
    randomBin = random(20, 0, 2, false, true, new char[]{'0', '1'}, rng);
    randomSF = new SFloat(randomDouble);
    randomSI = new SInt(randomInt);
    randomSB = new SBinary(randomBin);
  }

  @RepeatedTest(20)
  public void constructorTest() {
    INumber testfail = new SInt(2);
    int otherInt = rng.nextInt();
    var expected = new SInt(testInt);
    SInt notExpected;
    do {
      otherInt = rng.nextInt();
    } while (testInt == otherInt);
    notExpected = new SInt(otherInt);
    assertEquals(expected, testSInt);
    assertEquals(expected.hashCode(), testSInt.hashCode());
    assertNotEquals(notExpected, testSInt);
    assertNotEquals(notExpected.hashCode(), testSInt.hashCode());
  }

  /**
   * El metodo toString de nuestro objeto deberia tener el mismo comportamiento que
   * Integer.toString
   */
  @RepeatedTest(20)
  public void toStringTest() {
    int value = testSInt.getValue();
    String fakeInt = "one";
    String expectedString = Integer.toString(value);
    assertEquals(expectedString, testSInt.toString());
    assertNotEquals(fakeInt, testSInt.toString());
  }

  @RepeatedTest(20)
  public void StringtransformTest() {
    /*
     * Test para SInt -> SString
     * Se crea manualmente un SString con valor el int de setUp en String
     */
    String expStr = Integer.toString(testInt);
    var expected = new SString((expStr));
    /* Se crea manualmente un SString con valor distinto al del int de setUp en String */
    int otherInt;
    String notExpStr;
    do {
      otherInt = rng.nextInt();
    } while (otherInt == testInt);
    notExpStr = Integer.toString(otherInt);
    var notExpected = new SString(notExpStr);

    assertEquals(expected, testSInt.toSString());
    assertNotEquals(notExpected, testSInt.toSString());
  }

  @RepeatedTest(20)
  public void FloatTransformTest() {
        /*
         * Test para SInt --> SFloat
         se hace el cast de testInt a double para crear el SFloat esperado
        */
    double testDouble = testInt;
    double otherDouble;
    var expected = new SFloat(testDouble);
    do {
      otherDouble = rng.nextDouble();
    } while (Double.compare(otherDouble, testDouble) == 0);
    var unexpected = new SFloat(otherDouble);
    assertEquals(expected, new SInt(testInt).toSFloat());
    assertNotEquals(unexpected, new SInt(testInt).toSFloat());
  }

  @RepeatedTest(20)
  public void IntTransformTest() {
        /*
        Test para SInt -> SInt
        Se deberia obtener el mismo objeto
         */
    int otherInt = rng.nextInt();
    SInt expected = new SInt(testInt);
    do {
      otherInt = rng.nextInt();
    } while (testInt == otherInt);
    var notExpected = new SInt(otherInt);
    assertEquals(expected, testSInt.toSInt());
    assertNotEquals(notExpected, testSInt.toSInt());
  }

  @RepeatedTest(100)
  public void BinaryTransformTest() {
        /*
        Test para SInt -> SBinary
         */
    var zeroInt = new SInt(0);
    assertEquals(new SBinary("0"), zeroInt.toSBinary());
    assertEquals(new SBinary("11111111111111111111111111111111"), new SInt(-1).toSBinary());
    assertEquals(new SBinary("01111111111111111111111111111111"),
        new SInt(Integer.MAX_VALUE).toSBinary());
    assertEquals(new SBinary("10000000000000000000000000000000"),
        new SInt(Integer.MIN_VALUE).toSBinary());
    /* test both negative and positive numbers */
    SInt opposite = new SInt(testInt * -1);
    String bin = Integer.toBinaryString(testInt);
    String oppositeBin = Integer.toBinaryString(testInt * -1);
    var sbin = new SBinary(bin);
    var nSbin = new SBinary(oppositeBin);
    assertEquals(sbin, testSInt.toSBinary());
    assertEquals(nSbin, opposite.toSBinary());
  }

  @RepeatedTest(20)
  public void addTest() {
    assertEquals(new SFloat(randomInt + randomDouble), randomSI.add(randomSF));
    assertEquals(new SInt(randomInt + Integer.parseInt(randomBin, 2)), randomSI.add(randomSB));
    assertEquals(new SInt(randomInt + testInt), randomSI.add(testSInt));
  }

  @RepeatedTest(20)
  public void subsTest() {
    assertEquals(new SFloat(randomInt - randomDouble), randomSI.subs(randomSF));
    assertEquals(new SInt(randomInt - Integer.parseInt(randomBin, 2)), randomSI.subs(randomSB));
    assertEquals(new SInt(randomInt - testInt), randomSI.subs(testSInt));
  }

  @RepeatedTest(20)
  public void multTest() {
    assertEquals(new SFloat(randomInt * randomDouble), randomSI.mult(randomSF));
    assertEquals(new SInt(randomInt * Integer.parseInt(randomBin, 2)), randomSI.mult(randomSB));
    assertEquals(new SInt(randomInt * testInt), randomSI.mult(testSInt));
  }

  @RepeatedTest(20)
  public void divTest() {
    assertEquals(new SFloat(randomInt / randomDouble), randomSI.div(randomSF));
    assertEquals(new SInt(randomInt / Integer.parseInt(randomBin, 2)), randomSI.div(randomSB));
    assertEquals(new SInt(randomInt / testInt), randomSI.div(testSInt));
  }
}
