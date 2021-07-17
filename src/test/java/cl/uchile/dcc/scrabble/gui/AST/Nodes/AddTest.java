package cl.uchile.dcc.scrabble.gui.AST.Nodes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import cl.uchile.dcc.scrabble.gui.AST.Nodes.Add;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SBinary;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SBool;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SFloat;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SInt;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SString;
import org.junit.jupiter.api.Test;

class AddTest {
  private final Add testNode = new Add(new SInt(1), new SInt(0)); // int(1)
  private final SFloat testNumber = new SFloat(3);
  private final SBool testBool = new SBool(true);
  private final SBinary testBinary = new SBinary("10"); // 2
  private final SString testString = new SString("test");


  @Test
  void eval() {
    // number
    assertEquals(new SFloat(4), new Add(testNumber, testNode).eval());
    // bool
    assertNull(new Add(testBool, testNode).eval());
    // binary
    assertEquals(new SBinary("11"), new Add(testBinary, testNode).eval());
    // string
    assertEquals(new SString("test1"), new Add(testString, testNode).eval());
    // node
    assertEquals(new SInt(2), new Add(testNode, testNode).eval());
  }
}