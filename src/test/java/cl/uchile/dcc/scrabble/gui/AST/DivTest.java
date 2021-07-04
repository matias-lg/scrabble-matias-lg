package cl.uchile.dcc.scrabble.gui.AST;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.gui.nativeClasses.SBinary;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SBool;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SFloat;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SInt;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SString;
import org.junit.jupiter.api.Test;

class DivTest {
  private final Add testNode = new Add(new SInt(1), new SInt(0)); // int(1)
  private final SFloat testNumber = new SFloat(3);
  private final SBool testBool = new SBool(true);
  private final SBinary testBinary = new SBinary("10"); // 2
  private final SString testString = new SString("test");

  @Test
  void eval() {
    // number
    assertEquals(new SFloat(3), new Div(testNumber, testNode).eval());
    // bool
    assertNull(new Div(testBool, testNode).eval());
    // binary
    assertEquals(new SBinary("10"), new Div(testBinary, testNode).eval());
    // string
    assertNull(new Div(testString, testNode).eval());
    // node
    assertEquals(new SInt(1), new Div(testNode, testNode).eval());
  }

}