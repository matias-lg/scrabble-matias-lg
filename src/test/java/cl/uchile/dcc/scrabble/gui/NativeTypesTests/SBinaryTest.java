package cl.uchile.dcc.scrabble.gui.NativeTypesTests;

import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import cl.uchile.dcc.scrabble.gui.nativeClasses.SBinary;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SBool;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SInt;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SString;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class SBinaryTest {

  private final SBinary ZERO = new SBinary("0");
  private final SBinary ONE = new SBinary("1");
  private SBinary testBinary;
  private Random rng;
  char[] binaries = {'0', '1'};
  String randomString;
  private final int LENGTH = 20;

  @BeforeEach
  public void setUp() {
    long seed = new Random().nextInt();
    rng = new Random(seed);
    randomString = random(LENGTH, 0, 2, false, true, binaries, rng);
    testBinary = new SBinary(randomString);
  }

  @RepeatedTest(20)
  public void constructorTest() {
    SBinary expected = new SBinary(randomString);
    SBinary unexpected;
    String difRandomString;
    do {
      difRandomString = random(LENGTH, 0, 2, false, true, binaries, rng);
    } while (difRandomString.equals(randomString));
    unexpected = new SBinary(difRandomString);
    // equals
    assertEquals(ONE, new SBinary("0000000000001"));
    assertEquals(ZERO, new SBinary("000000000"));
    assertEquals(expected, testBinary);
    assertNotEquals(unexpected, testBinary);
    // hashCode
    assertNotEquals(ONE, ZERO);
    assertEquals(expected.hashCode(), testBinary.hashCode());
  }

  @RepeatedTest(20)
  public void toStringTest() {
    String expectedString = testBinary.getValue();
    SBinary unexpected;
    String otherBinary;
    do {
      otherBinary = random(LENGTH, 0, 2, false, true, binaries, rng);
    } while (expectedString.equals(otherBinary));
    unexpected = new SBinary(otherBinary);
    String fail = "imposible que pase!";

    assertEquals(expectedString, testBinary.toString());
    assertNotEquals(fail, testBinary.toString());
    assertNotEquals(unexpected.toString(), testBinary.toString());
  }

  @RepeatedTest(20)
  public void toSStringTest() {
    String expectedString = testBinary.getValue();
    var expected = new SString(expectedString);
    String otherString;
    do {
      otherString = random(LENGTH, 0, 2, false, true, binaries, rng);
    } while (otherString.equals(expectedString));
    var unexpected = new SString(otherString);
    assertEquals(expected, testBinary.toSString());
    assertNotEquals(unexpected, testBinary.toSString());
  }

  @RepeatedTest(20)
  public void toSBinaryTest() {
    SBinary expected = new SBinary(randomString);
    String otherBinary;
    do {
      otherBinary = random(LENGTH, 0, 2, false, true, binaries, rng);
    } while (testBinary.equals(new SBinary(otherBinary)));
    SBinary unexpected = new SBinary(otherBinary);
    assertEquals(testBinary, testBinary.toSBinary());
    assertEquals(expected.toSBinary(), testBinary);
    assertNotEquals(unexpected.toSBinary(), testBinary.toSBinary());
  }

  @RepeatedTest(100)
  public void toSIntTest() {
    // negatives numbers are also tested
    int negativeInt;
    int posInt = rng.nextInt();
    if (posInt >= 0) {
      negativeInt = posInt * -1;
    } else {
      negativeInt = posInt;
      posInt *= -1;
    }
    var negativeExpected = new SInt(negativeInt);
    var expected = new SInt(posInt);
    // use Java's implementation to get the correct String
    String neg = Integer.toBinaryString(negativeInt);
    String pos = "0"+Integer.toBinaryString(posInt);
    var posBinary = new SBinary(pos);
    var negBinary = new SBinary(neg);
    assertEquals(new SInt(Integer.MAX_VALUE),
        new SBinary("01111111111111111111111111111111").toSInt());
    assertEquals(new SInt(Integer.MIN_VALUE),
        new SBinary("10000000000000000000000000000000").toSInt());
    assertEquals(new SInt(-1), new SBinary("11111111111111111111111111111111").toSInt());
    assertEquals(new SInt(1), ONE.toSInt());
    assertEquals(new SInt(0), ZERO.toSInt());
    assertNotEquals(ZERO.toSInt(), ONE.toSInt());
    assertEquals(expected, posBinary.toSInt(),
        "Expected is: " + expected.getValue() + ". binary passed is:  " + posBinary.toString());
    assertEquals(negativeExpected, negBinary.toSInt(),
        "Expected is: " + negativeExpected.getValue() + ". binary passed is:  " + negBinary
            .toString());

  }

  @RepeatedTest(20)
  public void addTest(){
    /* with SInt */
    SInt zero = new SInt(0);
    int randomInt = rng.nextInt();
    var randSInt = new SInt(randomInt);
    /* use java implementation to get correct value */
    var randSBin = new SBinary(randomString);
    int randomBin = Integer.parseInt(randomString, 2);
    String result = Integer.toBinaryString(randomBin + randomInt);
    var binResult = new SBinary(result);
    assertEquals(ZERO.add(zero), ZERO);
    assertEquals(binResult, randSBin.add(randSInt));
    /* with SBinary */
    int int1 = Integer.parseInt(testBinary.getValue(), 2);
    String bintResult = Integer.toBinaryString(int1 + randomBin);
    SBinary expected = new SBinary(bintResult);
    SBinary actual = (SBinary) testBinary.add(randSBin);
    assertEquals(expected, actual);
  }

  @RepeatedTest(20)
  public void subsTest(){
    /* with SInt */
    SInt zero = new SInt(0);
    int randomInt = rng.nextInt();
    var randSInt = new SInt(randomInt);
    /* use java implementation to get correct value */
    var randSBin = new SBinary(randomString);
    int randomBin = Integer.parseInt(randomString, 2);
    String result = Integer.toBinaryString(randomBin - randomInt);
    var binResult = new SBinary(result);
    assertEquals(ZERO.subs(zero), ZERO);
    assertEquals(binResult, randSBin.subs(randSInt));
    /* with SBinary */
    int int1 = Integer.parseInt(testBinary.getValue(), 2);
    String bintResult = Integer.toBinaryString(int1 - randomBin);
    SBinary expected = new SBinary(bintResult);
    SBinary actual = (SBinary) testBinary.subs(randSBin);
    assertEquals(expected, actual);
  }

  @RepeatedTest(20)
  public void divTest(){
    /* with SInt */
    SInt zero = new SInt(0);
    int randomInt = rng.nextInt();
    var randSInt = new SInt(randomInt);
    /* use java implementation to get correct value */
    var randSBin = new SBinary(randomString);
    int randomBin = Integer.parseInt(randomString, 2);
    String result = Integer.toBinaryString(randomBin / randomInt);
    var binResult = new SBinary(result);
    assertEquals(ZERO.div(ONE), ZERO);
    assertEquals(binResult, randSBin.div(randSInt));
    /* with SBinary */
    int int1 = Integer.parseInt(testBinary.getValue(), 2);
    String bintResult = Integer.toBinaryString(int1 / randomBin);
    SBinary expected = new SBinary(bintResult);
    SBinary actual = (SBinary) testBinary.div(randSBin);
    assertEquals(expected, actual);
  }

  @RepeatedTest(20)
  public void multTest(){
    /* with SInt */
    SInt zero = new SInt(0);
    int randomInt = rng.nextInt();
    var randSInt = new SInt(randomInt);
    /* use java implementation to get correct value */
    var randSBin = new SBinary(randomString);
    int randomBin = Integer.parseInt(randomString, 2);
    String result = Integer.toBinaryString(randomBin * randomInt);
    var binResult = new SBinary(result);
    assertEquals(ZERO.mult(ONE), ZERO);
    assertEquals(binResult, randSBin.mult(randSInt));
    /* with SBinary */
    int int1 = Integer.parseInt(testBinary.getValue(), 2);
    String bintResult = Integer.toBinaryString(int1 * randomBin);
    SBinary expected = new SBinary(bintResult);
    SBinary actual = (SBinary) testBinary.mult(randSBin);
    assertEquals(expected, actual);
  }

  @Test
  public void orTest(){
    /* With SBinary */
      assertEquals(ZERO.or(ONE), new SBinary("1"));
      assertEquals(new SBinary("1110").or(new SBinary("1")), new SBinary("1111"));
      assertEquals(new SBinary("10001").or(new SBinary("1110")), new SBinary("11111"));
      /* With SBool */
    var strue = new SBool(true);
    var sfalse = new SBool(false);
    assertEquals(ONE.or(sfalse), ONE);
    assertEquals(ONE.or(strue), ONE);
    assertEquals(ZERO.or(sfalse), ZERO);
    assertEquals(ZERO.or(strue), ONE);
    assertEquals(new SBinary("1110").or(strue), new SBinary("1111"));
    assertEquals(new SBinary("10001").or(sfalse), new SBinary("10001"));
  }
  @Test
  public void andTest(){
    assertEquals(ZERO.and(ONE), new SBinary("0"));
    assertEquals(new SBinary("1110").and(new SBinary("1")), new SBinary("1110"));
    assertEquals(new SBinary("10001").and(new SBinary("1110")), new SBinary("10000"));
    /* With SBool */
    var strue = new SBool(true);
    var sfalse = new SBool(false);
    assertEquals(ONE.and(sfalse), ZERO);
    assertEquals(ONE.and(strue), ONE);
    assertEquals(ZERO.and(sfalse), ZERO);
    assertEquals(ZERO.and(strue), ZERO);
    assertEquals(new SBinary("1110").and(strue), new SBinary("1110"));
    assertEquals(new SBinary("10001").and(sfalse), new SBinary("00000"));
  }

  @Test
  public void notTest(){
    assertEquals(ONE, ZERO.not());
    assertEquals(ZERO, ONE.not());
    assertEquals(new SBinary("101010"), new SBinary("010101").not());
    assertEquals(new SBinary("11011"), new SBinary("00100").not());
  }
}
