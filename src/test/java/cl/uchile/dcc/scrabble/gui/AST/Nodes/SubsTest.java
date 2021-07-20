package cl.uchile.dcc.scrabble.gui.AST.Nodes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SBinary;
import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SBool;
import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SFloat;
import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SInt;
import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SString;
import org.junit.jupiter.api.Test;

class SubsTest {

  private final Add testNode = new Add(new SInt(1), new SInt(0)); // int(1)
  private final SFloat testNumber = new SFloat(3);
  private final SBool testBool = new SBool(true);
  private final SBinary testBinary = new SBinary("10"); // 2
  private final SString testString = new SString("test");

  @Test
  void eval() {
    // number
    assertEquals(new SFloat(2), new Subs(testNumber, testNode).eval());
    // bool
    assertNull(new Subs(testBool, testNode).eval());
    // binary
    assertEquals(new SBinary("1"), new Subs(testBinary, testNode).eval());
    // string
    assertNull(new Subs(testString, testNode).eval());
    // node
    assertEquals(new SInt(0), new Subs(testNode, testNode).eval());
  }
}