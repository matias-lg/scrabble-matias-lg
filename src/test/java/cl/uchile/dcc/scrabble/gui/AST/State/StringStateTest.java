package cl.uchile.dcc.scrabble.gui.AST.State;

import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import cl.uchile.dcc.scrabble.gui.nativeClasses.SBinary;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SBool;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SFloat;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SInt;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SString;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringStateTest {

  private SInt testInt;
  private SFloat testFloat;
  private SBinary testBin;
  private SString testString;
  private final SBool testTrue = new SBool(true);
  private final SBool testFalse = new SBool(false);
  private Random rng;
  private final StringState stringState = new StringState();

  @BeforeEach
  void setUp() {
    long seed = new Random().nextInt();
    rng = new Random(seed);
    testInt = new SInt(rng.nextInt());
    testFloat = new SFloat(rng.nextDouble());
    testBin = new SBinary("1");
    testString = new SString(random(100, 0, Character.MAX_CODE_POINT, true, true, null, rng));
  }

  @Test
  void add() {
    assertEquals(testString.add(testInt), stringState.add(testString, testInt));
    assertEquals(testString.add(testFloat), stringState.add(testString, testFloat));
    assertEquals(testString.add(testBin), stringState.add(testString, testBin));
  }

  @Test
  void subs() {
    assertNull(stringState.subs(testString, testBin));
    assertNull(stringState.subs(testString, testInt));
    assertNull(stringState.subs(testString, testFloat));

  }

  @Test
  void div() {
    assertNull(stringState.div(testString, testBin));
    assertNull(stringState.div(testString, testInt));
    assertNull(stringState.div(testString, testFloat));
  }

  @Test
  void mult() {
    assertNull(stringState.mult(testString, testBin));
    assertNull(stringState.mult(testString, testInt));
    assertNull(stringState.mult(testString, testFloat));
  }

  @Test
  void and() {
    assertNull(stringState.and(testString, testBin));
    assertNull(stringState.and(testString, testInt));
    assertNull(stringState.and(testString, testFloat));
  }

  @Test
  void or() {
    assertNull(stringState.or(testString, testBin));
    assertNull(stringState.or(testString, testInt));
    assertNull(stringState.or(testString, testFloat));
  }

  @Test
  void not() {
    assertNull(stringState.not(testString));
  }
}