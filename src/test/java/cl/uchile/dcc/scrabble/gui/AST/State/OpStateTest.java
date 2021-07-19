package cl.uchile.dcc.scrabble.gui.AST.State;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import cl.uchile.dcc.scrabble.gui.AST.Nodes.Add;
import cl.uchile.dcc.scrabble.gui.AST.Nodes.Mult;
import cl.uchile.dcc.scrabble.gui.AST.Nodes.Not;
import cl.uchile.dcc.scrabble.gui.AST.Nodes.Or;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SBinary;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SBool;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SFloat;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SInt;
import org.junit.jupiter.api.Test;

class OpStateTest {

  private Add addNode = new Add(new SInt(1), new SFloat(2)); // 3.0
  private Or orNode = new Or(new SBinary("0"), new SBool(true)); // 1
  private Mult multNode = new Mult(new SFloat(1), new SBinary("1")); // 1
  private Not notNode = new Not(new SBool(true));
  private final OpState opState = new OpState();

  @Test
  void add() {
    assertEquals(new SFloat(4.0), opState.add(addNode, orNode));
    assertEquals(new SFloat(4.0), opState.add(multNode, addNode));
    assertNull(opState.add(notNode, addNode));
  }

  @Test
  void subs() {
    assertEquals(new SFloat(2.0), opState.subs(addNode, orNode));
    assertEquals(new SFloat(-2.0), opState.subs(multNode, addNode));
    assertNull(opState.subs(notNode, addNode));
  }

  @Test
  void div() {
    assertEquals(new SFloat(3.0), opState.div(addNode, orNode));
    assertEquals(new SFloat(1.0 / 3.0), opState.div(multNode, addNode));
    assertNull(opState.div(notNode, addNode));
  }

  @Test
  void mult() {
    assertEquals(new SFloat(3.0), opState.mult(addNode, orNode));
    assertEquals(new SFloat(3.0), opState.mult(multNode, addNode));
    assertNull(opState.mult(notNode, addNode));
  }

  @Test
  void and() {
    assertNull(opState.and(addNode, addNode));
    assertNull(opState.and(notNode, addNode));
    assertNull(opState.and(multNode, addNode));
    assertEquals(new SBinary("0"), opState.and(orNode, notNode));
  }

  @Test
  void or() {
    assertNull(opState.or(addNode, addNode));
    assertNull(opState.or(notNode, addNode));
    assertNull(opState.or(multNode, addNode));
    assertEquals(new SBinary("1"), opState.or(orNode, notNode));
  }

  @Test
  void not() {
    assertNull(opState.not(addNode));
    assertNull(opState.not(multNode));
    assertEquals(new SBool(true), opState.not(notNode));
  }
}