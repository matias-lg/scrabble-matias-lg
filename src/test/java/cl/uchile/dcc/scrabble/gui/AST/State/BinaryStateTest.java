package cl.uchile.dcc.scrabble.gui.AST.State;

import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SBinary;
import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SBool;
import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SFloat;
import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SInt;
import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SString;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinaryStateTest {

  private SInt testInt;
  private SFloat testFloat;
  private SBinary testBin;
  private SBinary testBin2;
  private SString testString;
  private SBool testBool;
  private Random rng;
  private final BinaryState binaryState = new BinaryState();

  @BeforeEach
  void setUp() {
    long seed = new Random().nextInt();
    rng = new Random(seed);
    testInt = new SInt(rng.nextInt());
    testFloat = new SFloat(rng.nextDouble());

    var randomString = random(20, 0, 2, false, true, new char[]{'0', '1'}, rng);
    var otherString = random(20, 0, 2, false, true, new char[]{'0', '1'}, rng);
    testBin = new SBinary(randomString);
    testBin2 = new SBinary(otherString);
    testString = new SString("This is a constant String");
    testBool = new SBool(true);
  }

  @Test
  void add() {
    assertEquals(testBin.add(testBin2), binaryState.add(testBin, testBin2));
    assertEquals(testBin.add(testInt), binaryState.add(testBin, testInt));
    assertNull(binaryState.add(testBin, testFloat));
    assertNull(binaryState.add(testBin, testString));
    assertNull(binaryState.add(testBin, testBool));
  }

  @Test
  void subs() {
    assertEquals(testBin.subs(testBin2), binaryState.subs(testBin, testBin2));
    assertEquals(testBin.subs(testInt), binaryState.subs(testBin, testInt));
    assertNull(binaryState.subs(testBin, testFloat));
    assertNull(binaryState.subs(testBin, testString));
    assertNull(binaryState.subs(testBin, testBool));
  }

  @Test
  void div() {
    assertEquals(testBin.div(testBin2), binaryState.div(testBin, testBin2));
    assertEquals(testBin.div(testInt), binaryState.div(testBin, testInt));
    assertNull(binaryState.div(testBin, testFloat));
    assertNull(binaryState.div(testBin, testString));
    assertNull(binaryState.div(testBin, testBool));
  }

  @Test
  void mult() {
    assertEquals(testBin.mult(testBin2), binaryState.mult(testBin, testBin2));
    assertEquals(testBin.mult(testInt), binaryState.mult(testBin, testInt));
    assertNull(binaryState.mult(testBin, testFloat));
    assertNull(binaryState.mult(testBin, testString));
    assertNull(binaryState.mult(testBin, testBool));
  }

  @Test
  void and() {
    assertEquals(testBin.and(testBin2), binaryState.and(testBin, testBin2));
    assertEquals(testBin.and(testBool), binaryState.and(testBin, testBool));
    assertNull(binaryState.and(testBin, testFloat));
    assertNull(binaryState.and(testBin, testString));
    assertNull(binaryState.and(testBin, testInt));

  }

  @Test
  void or() {
    assertEquals(testBin.or(testBin2), binaryState.or(testBin, testBin2));
    assertEquals(testBin.or(testBool), binaryState.or(testBin, testBool));
    assertNull(binaryState.or(testBin, testFloat));
    assertNull(binaryState.or(testBin, testString));
    assertNull(binaryState.or(testBin, testInt));
  }

  @Test
  void not() {
    assertEquals(testBin.not(), binaryState.not(testBin));
    assertEquals(testBin2.not(), binaryState.not(testBin2));
  }
}