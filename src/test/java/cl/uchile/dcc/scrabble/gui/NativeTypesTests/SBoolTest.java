package cl.uchile.dcc.scrabble.gui.NativeTypesTests;

import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cl.uchile.dcc.scrabble.gui.nativeClasses.SBinary;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SBool;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SInt;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SString;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class SBoolTest {

  private final int STR_SIZE = 20;
  private SBool scrabbleTrue;
  private SBool scrabbleFalse;
  private Random rng;
  private String randombinary;

  @BeforeEach
  void setUp() {
    scrabbleTrue = new SBool(true);
    scrabbleFalse = new SBool(false);
    int seed = new Random().nextInt();
    rng = new Random(seed);
    randombinary = random(STR_SIZE, 0, 2, false, true, new char[] {'0', '1'}, rng);
  }

  @Test
  void ConstructorTest() {
    var trueBool = new SBool(true);
    var falseBool = new SBool(false);
    assertEquals(trueBool, scrabbleTrue);
    assertEquals(falseBool, scrabbleFalse);
    assertNotEquals(trueBool, scrabbleFalse);
    assertNotEquals(falseBool, scrabbleTrue);
    assertEquals(trueBool.hashCode(), scrabbleTrue.hashCode());
    assertEquals(falseBool.hashCode(), scrabbleFalse.hashCode());
    assertNotEquals(trueBool.hashCode(), falseBool.hashCode());
  }

  @Test
  void BoolTest() {
    assertTrue(scrabbleTrue.getValue());
    assertFalse(scrabbleFalse.getValue());
  }

  @Test
  void toStringTest() {
    String trueStr = "true";
    String falseStr = "false";
    assertEquals(trueStr, scrabbleTrue.toString());
    assertEquals(falseStr, scrabbleFalse.toString());
    assertNotEquals("", scrabbleTrue.toString());
    assertNotEquals(scrabbleFalse.toString(), scrabbleTrue.toString());
  }

  @Test
  void toSStringTest() {
    var trueScrabbleString = new SString("true");
    var falseScrabbleString = new SString("false");
    assertEquals(trueScrabbleString, scrabbleTrue.toSString());
    assertNotEquals(trueScrabbleString, scrabbleFalse.toSString());
    assertEquals(falseScrabbleString, scrabbleFalse.toSString());
    assertNotEquals(falseScrabbleString, scrabbleTrue.toSString());
  }
  @RepeatedTest(20)
  void andTest(){
    /* with SBool */
    assertEquals(scrabbleFalse, scrabbleTrue.and(scrabbleFalse));
    assertEquals(scrabbleFalse, scrabbleFalse.and(scrabbleTrue));
    assertEquals(scrabbleTrue, scrabbleTrue.and(scrabbleTrue));
    assertEquals(scrabbleFalse, scrabbleFalse.and(scrabbleFalse));
    assertNotEquals(scrabbleTrue, scrabbleTrue.and(scrabbleFalse));
    /* with SBinary */
    var zeroBin = new SBinary("0");
    var oneBin = new SBinary("1");
    assertEquals(zeroBin, scrabbleTrue.and(zeroBin));
    assertEquals(oneBin, scrabbleTrue.and(oneBin));
    assertEquals(zeroBin, scrabbleFalse.and(oneBin));
    assertEquals(zeroBin, scrabbleFalse.and(oneBin));
    var someBin = new SBinary(randombinary);
    assertEquals(someBin, scrabbleTrue.and(someBin));
    assertEquals(zeroBin, scrabbleFalse.and(someBin));
  }

  @RepeatedTest(20)
  void orTest(){
    /* with SBool */
    assertEquals(scrabbleTrue, scrabbleTrue.or(scrabbleFalse));
    assertEquals(scrabbleTrue, scrabbleFalse.or(scrabbleTrue));
    assertEquals(scrabbleTrue, scrabbleTrue.or(scrabbleTrue));
    assertEquals(scrabbleFalse, scrabbleFalse.or(scrabbleFalse));
    assertNotEquals(scrabbleFalse, scrabbleTrue.or(scrabbleFalse));
    /* with SBinary */
    var zeroBin = new SBinary("0");
    var oneBin = new SBinary("1");
    assertEquals(oneBin, scrabbleTrue.or(zeroBin));
    assertEquals(oneBin, scrabbleTrue.or(oneBin));
    assertEquals(oneBin, scrabbleFalse.or(oneBin));
    assertEquals(zeroBin, scrabbleFalse.or(zeroBin));
    var someBin = new SBinary(randombinary);
    assertEquals(new SBinary("1".repeat(STR_SIZE)), scrabbleTrue.or(someBin));
    assertEquals(someBin, scrabbleFalse.or(someBin));
  }
  @Test
  void notTest(){
    assertEquals(scrabbleTrue, scrabbleFalse.not());
    assertEquals(scrabbleFalse, scrabbleTrue.not());
  }
}
