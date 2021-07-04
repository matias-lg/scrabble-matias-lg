package cl.uchile.dcc.scrabble.gui.NativeTypesTests;

import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import cl.uchile.dcc.scrabble.gui.nativeClasses.SBinary;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SBool;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SFloat;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SInt;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SString;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

public class SStringTest {

  private SString testSString;
  private int seed;
  private Random rng;
  private String randomString;
  private final int STR_SIZE = 100;

  @BeforeEach
  public void setUp() {
    seed = new Random().nextInt();
    rng = new Random(seed);
    randomString = random(STR_SIZE, 0, Character.MAX_CODE_POINT, true, true, null, rng);
    testSString = new SString(randomString);
  }

  @RepeatedTest(20)
  public void constructorTest() {
    /* Se crea un SString con string igual al de setUp */
    var expectedScrabbleString = new SString(randomString);
    /* String distinto al de setup */
    String difRandomString;
    /* Se crea un nuevo string en caso de ser igual al creado en setUp */
    do {
      difRandomString = random(STR_SIZE, 0, Character.MAX_CODE_POINT, true, true, null, rng);

    } while (randomString.equals(difRandomString));
    var notExpectedScrabbleString = new SString(difRandomString);

    assertEquals(expectedScrabbleString, testSString);
    assertNotEquals(notExpectedScrabbleString, testSString);

    assertEquals(expectedScrabbleString.hashCode(), testSString.hashCode());
    assertNotEquals(notExpectedScrabbleString.hashCode(), testSString.hashCode());
  }

  @RepeatedTest(20)
  public void toSStringTest() {
    String otherstr;
    do {
      otherstr = random(STR_SIZE, 0, Character.MAX_CODE_POINT, true, true, null, rng);

    } while (randomString.equals(otherstr));
    var otherScrabbleString = new SString(otherstr);
    assertEquals(testSString.toSString(), testSString);
    assertNotEquals(otherScrabbleString, testSString.toSString());
    assertEquals(new SString(otherstr), otherScrabbleString.toSString());
  }

  @RepeatedTest(20)
  public void sumTest(){
    /* Random types */
    int irng = rng.nextInt();
    double drng = rng.nextDouble();
    String brng = random(20, 0, 2, false, true, new char[] {'0', '1'}, rng);
    boolean boolrng = rng.nextBoolean();
    String srng = random(STR_SIZE, 0, Character.MAX_CODE_POINT, true, true, null, rng);
    /* Create random Scrabble types */
    var sint = new SInt(irng);
    var sfloat = new SFloat(drng);
    var sbin = new SBinary(brng);
    var sbool = new SBool(boolrng);
    var sstr = new SString(srng);
    assertEquals(testSString.add(sint), new SString(randomString + irng));
    assertEquals(testSString.add(sfloat), new SString(randomString + drng));
    assertEquals(testSString.add(sbin), new SString(randomString + brng));
    assertEquals(testSString.add(sbool), new SString(randomString + boolrng));
    assertEquals(testSString.add(sstr), new SString(randomString + srng));
  }
}
