package cl.uchile.dcc.scrabble.gui.AST.Nodes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import cl.uchile.dcc.scrabble.gui.AST.Nodes.Add;
import cl.uchile.dcc.scrabble.gui.AST.Nodes.And;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SBinary;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SBool;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SFloat;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SInt;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SString;
import org.junit.jupiter.api.Test;

class AndTest {
  private final Add testNode = new Add(new SInt(1), new SInt(0)); // int(1)
  private final SFloat testNumber = new SFloat(3);
  private final SBool testBool = new SBool(true);
  private final SBinary testBinary = new SBinary("10"); // 2
  private final SString testString = new SString("test");

  @Test
  void eval() {
    // number
    assertNull(new And(testNumber, testNode).eval());
    // bool
    assertEquals(new SBinary("10"),new And(testBool, testBinary).eval());
    // binary
    assertNull(new And(testBinary, testNode).eval());
    // string
    assertNull(new And(testString, testNode).eval());
    // node
    assertNull(new And(testNode, testNode).eval());
  }

}