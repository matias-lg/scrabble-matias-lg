package cl.uchile.dcc.scrabble.gui.NativeTypesTests;


import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import cl.uchile.dcc.scrabble.gui.nativeClasses.SBinary;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SFloat;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SInt;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SString;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

/*
Test para la clase SInt y sus metodos
 */
public class SFloatTest {

  private SFloat testSFloat;
  private int seed;
  private Random rng;
  private double testDouble;
  private double randomDouble;
  private int randomInt;
  private String randomBin;
  private SFloat randomSF;
  private SInt randomSI;
  private SBinary randomSB;

  @BeforeEach
  public void setUp() {
    seed = new Random().nextInt();
    rng = new Random(seed);
    testDouble = rng.nextDouble();
    testSFloat = new SFloat(testDouble);
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
    double otherDouble;
    do {
      otherDouble = rng.nextDouble();
    }
    while (Double.compare(otherDouble, testDouble) == 0);
    var expected = new SFloat(testDouble);
    var notExpected = new SFloat(otherDouble);

    assertEquals(expected, testSFloat);
    assertNotEquals(notExpected, testSFloat);
    assertEquals(expected.hashCode(), testSFloat.hashCode());
    assertNotEquals(notExpected.hashCode(), testSFloat.hashCode());
  }

  /**
   * El metodo toString de nuestro objeto deberia tener el mismo comportamiento que Double.toString
   */
  @RepeatedTest(20)
  public void toStringTest() {
    double value = testSFloat.getValue();
    String fakeDouble = "2.o";
    String expectedString = Double.toString(value);
    assertEquals(expectedString, testSFloat.toString());
    assertNotEquals(fakeDouble, testSFloat.toString());
  }

  @RepeatedTest(20)
  public void toFloatTest() {
    double expValue = testSFloat.getValue();
    double unexpValue = rng.nextDouble();
    do {
      unexpValue = rng.nextDouble();
    } while (Double.compare(expValue, unexpValue) == 0);
    assertEquals(testSFloat, testSFloat.toSFloat());
    assertNotEquals(testSFloat, new SFloat(unexpValue).toSFloat());
  }

  @RepeatedTest(20)
  public void toSStringTest() {
    String expstr = testSFloat.toString();
    var expected = new SString(expstr);
    var otherFloat = rng.nextDouble();
    do {
      otherFloat = rng.nextDouble();
    } while (otherFloat == testSFloat.getValue());
    var unexpected = new SString(Double.toString(otherFloat));
    assertEquals(expected, testSFloat.toSString());
    assertNotEquals(unexpected, testSFloat.toSString());
  }

  @RepeatedTest(20)
  public void addTest() {
    assertEquals(new SFloat(randomDouble + randomInt), randomSF.add(randomSI));
    assertEquals(new SFloat(randomDouble + Integer.parseInt(randomBin, 2)), randomSF.add(randomSB));
    assertEquals(new SFloat(randomDouble + testDouble), randomSF.add(testSFloat));
  }

  @RepeatedTest(20)
  public void subsTest() {
    assertEquals(new SFloat(randomDouble - randomInt), randomSF.subs(randomSI));
    assertEquals(new SFloat(randomDouble - Integer.parseInt(randomBin, 2)),
        randomSF.subs(randomSB));
    assertEquals(new SFloat(randomDouble - testDouble), randomSF.subs(testSFloat));
  }

  @RepeatedTest(20)
  public void multTest() {
    assertEquals(new SFloat(randomDouble * randomInt), randomSF.mult(randomSI));
    assertEquals(new SFloat(randomDouble * Integer.parseInt(randomBin, 2)),
        randomSF.mult(randomSB));
    assertEquals(new SFloat(randomDouble * testDouble), randomSF.mult(testSFloat));
  }

  @RepeatedTest(20)
  public void divTest() {
    assertEquals(new SFloat(randomDouble / randomInt), randomSF.div(randomSI));
    assertEquals(new SFloat(randomDouble / Integer.parseInt(randomBin, 2)), randomSF.div(randomSB));
    assertEquals(new SFloat(randomDouble / testDouble), randomSF.div(testSFloat));
  }

  @Test
  public void evalTest() {
    SFloat test = new SFloat(1);
    assertEquals(test, test.eval());
  }

}
