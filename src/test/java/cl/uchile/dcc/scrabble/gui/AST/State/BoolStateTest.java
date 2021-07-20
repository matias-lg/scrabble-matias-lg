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

class BoolStateTest {

  private SInt testInt;
  private SFloat testFloat;
  private SBinary testBin;
  private SString testString;
  private final SBool testTrue = new SBool(true);
  private final SBool testFalse = new SBool(false);
  private Random rng;
  private final BoolState boolState = new BoolState();

  @BeforeEach
  void setUp() {
    long seed = new Random().nextInt();
    rng = new Random(seed);
    testInt = new SInt(rng.nextInt());
    testFloat = new SFloat(rng.nextDouble());
    var randomString = random(20, 0, 2, false, true, new char[]{'0', '1'}, rng);
    testBin = new SBinary(randomString);
    testString = new SString("This is a constant String");
  }

  @Test
  void add() {
    assertNull(boolState.add(testTrue, testBin));
    assertNull(boolState.add(testFalse, testFloat));
    assertNull(boolState.add(testFalse, testInt));
    assertNull(boolState.add(testTrue, testString));

  }

  @Test
  void subs() {
    assertNull(boolState.subs(testTrue, testBin));
    assertNull(boolState.subs(testFalse, testFloat));
    assertNull(boolState.subs(testFalse, testInt));
    assertNull(boolState.subs(testTrue, testString));
  }

  @Test
  void div() {
    assertNull(boolState.div(testTrue, testBin));
    assertNull(boolState.div(testFalse, testFloat));
    assertNull(boolState.div(testFalse, testInt));
    assertNull(boolState.div(testTrue, testString));
  }

  @Test
  void mult() {
    assertNull(boolState.mult(testTrue, testBin));
    assertNull(boolState.mult(testFalse, testFloat));
    assertNull(boolState.mult(testFalse, testInt));
    assertNull(boolState.mult(testTrue, testString));
  }

  @Test
  void and() {
    assertEquals(testTrue.and(testFalse), boolState.and(testTrue, testFalse));
    assertEquals(testTrue.and(testBin), boolState.and(testTrue, testBin));
    assertNull(boolState.and(testFalse, testFloat));
    assertNull(boolState.and(testFalse, testInt));
    assertNull(boolState.and(testTrue, testString));
  }

  @Test
  void or() {
    assertEquals(testTrue.or(testFalse), boolState.or(testTrue, testFalse));
    assertEquals(testTrue.or(testBin), boolState.or(testTrue, testBin));
    assertNull(boolState.or(testFalse, testFloat));
    assertNull(boolState.or(testFalse, testInt));
    assertNull(boolState.or(testTrue, testString));
  }

  @Test
  void not() {
    assertEquals(testTrue.not(), boolState.not(testTrue));
    assertEquals(testFalse.not(), boolState.not(testFalse));
  }
}