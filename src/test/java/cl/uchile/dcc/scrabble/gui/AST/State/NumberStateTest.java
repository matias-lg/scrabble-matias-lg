package cl.uchile.dcc.scrabble.gui.AST.State;

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

class NumberStateTest {

  private SInt testInt;
  private SFloat testFloat;
  private SBinary testBin;
  private SString testString;
  private SBool testBool;
  private Random rng;
  private final NumberState numberState = new NumberState();

  @BeforeEach
  void setUp() {
    long seed = new Random().nextInt();
    rng = new Random(seed);
    testInt = new SInt(rng.nextInt());
    testFloat = new SFloat(rng.nextDouble());
    testBin = new SBinary("101010101");
    testString = new SString("This is a constant String");
    testBool = new SBool(true);
  }

  @Test
  void add() {
    assertEquals(testInt.add(testFloat), numberState.add(testInt, testFloat));
    assertEquals(testInt.add(testBin), numberState.add(testInt, testBin));
    assertNull(numberState.add(testInt, testString));
    assertNull(numberState.add(testFloat, testBool));
  }

  @Test
  void subs() {
    assertEquals(testInt.subs(testFloat), numberState.subs(testInt, testFloat));
    assertEquals(testInt.subs(testBin), numberState.subs(testInt, testBin));
    assertNull(numberState.subs(testInt, testString));
    assertNull(numberState.subs(testFloat, testBool));
  }

  @Test
  void mult() {
    assertEquals(testInt.mult(testFloat), numberState.mult(testInt, testFloat));
    assertEquals(testInt.mult(testBin), numberState.mult(testInt, testBin));
    assertNull(numberState.mult(testInt, testString));
    assertNull(numberState.mult(testFloat, testBool));
  }

  @Test
  void div() {
    assertEquals(testInt.div(testFloat), numberState.div(testInt, testFloat));
    assertEquals(testInt.div(testBin), numberState.div(testInt, testBin));
    assertNull(numberState.div(testInt, testString));
    assertNull(numberState.div(testFloat, testBool));
  }

  @Test
  void and() {
    assertNull(numberState.and(testInt, testFloat));
    assertNull(numberState.and(testInt, testBin));
    assertNull(numberState.and(testInt, testString));
    assertNull(numberState.and(testFloat, testBool));
  }

  @Test
  void or() {
    assertNull(numberState.or(testInt, testFloat));
    assertNull(numberState.or(testInt, testBin));
    assertNull(numberState.or(testInt, testString));
    assertNull(numberState.or(testFloat, testBool));
  }

  @Test
  void not() {
    assertNull(numberState.not(testInt));
    assertNull(numberState.not(testFloat));
  }
}