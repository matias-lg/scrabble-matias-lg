package cl.uchile.dcc.scrabble.gui.AST.Nodes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import cl.uchile.dcc.scrabble.gui.nativeClasses.SBinary;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SBool;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SFloat;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SInt;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SString;
import org.junit.jupiter.api.Test;

class OrTest {

  private final Add testNode = new Add(new SInt(1), new SInt(0)); // int(1)
  private final SFloat testNumber = new SFloat(3);
  private final SBool testBool = new SBool(true);
  private final SBinary testBinary = new SBinary("10"); // 2
  private final SString testString = new SString("test");

  @Test
  void eval() {
    // number
    assertNull(new Or(testNumber, testNode).eval());
    // bool
    assertEquals(new SBinary("11"), new Or(testBool, testBinary).eval());
    // binary
    assertNull(new Or(testBinary, testNode).eval());
    // string
    assertNull(new Or(testString, testNode).eval());
    // node
    assertNull(new Or(testNode, testNode).eval());
  }

}