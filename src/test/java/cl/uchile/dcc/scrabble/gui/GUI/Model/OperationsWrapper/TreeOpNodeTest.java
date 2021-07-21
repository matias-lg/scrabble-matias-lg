package cl.uchile.dcc.scrabble.gui.GUI.Model.OperationsWrapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cl.uchile.dcc.scrabble.gui.AST.Nodes.Not;
import cl.uchile.dcc.scrabble.gui.AST.Nodes.OpNode;
import cl.uchile.dcc.scrabble.gui.AST.Nodes.Or;
import cl.uchile.dcc.scrabble.gui.GUI.Model.TypesWrapper.TreeBinary;
import cl.uchile.dcc.scrabble.gui.GUI.Model.TypesWrapper.TreeBool;
import cl.uchile.dcc.scrabble.gui.GUI.Model.TypesWrapper.TreeFloat;
import cl.uchile.dcc.scrabble.gui.GUI.Model.TypesWrapper.TreeInt;
import cl.uchile.dcc.scrabble.gui.GUI.Model.TypesWrapper.TreeNull;
import cl.uchile.dcc.scrabble.gui.GUI.Model.TypesWrapper.TreeString;
import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SBinary;
import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SBool;
import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SFloat;
import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SInt;
import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SNull;
import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TreeOpNodeTest {

  private TreeAdd addTree = new TreeAdd();
  private TreeAnd andTree = new TreeAnd();
  private TreeDiv divTree = new TreeDiv();
  private TreeMult multTree = new TreeMult();
  private TreeNot notTree = new TreeNot();
  private TreeOr orTree = new TreeOr();
  private TreeSubs subsTree = new TreeSubs();

  @BeforeEach
  void setUp() {

  }

  @Test
  void setLeftChild() {
    /* add */
    addTree.setLeftChild(new TreeInt(new SInt(1)));
    var addTreeNode = (OpNode) addTree.getNode();
    assertEquals(new SInt(1), addTreeNode.getLeftChild());

    addTree.setLeftChild(new TreeString(new SString("test")));
    addTreeNode = (OpNode) addTree.getNode();
    assertEquals(new SString("test"), addTreeNode.getLeftChild());
    /* and */
    andTree.setLeftChild(new TreeBinary(new SBinary("1")));
    var andTreeNode = (OpNode) andTree.getNode();
    assertEquals(new SBinary("1"), andTreeNode.getLeftChild());

    andTree.setLeftChild(new TreeBool(new SBool(true)));
    andTreeNode = (OpNode) andTree.getNode();
    assertEquals(new SBool(true), andTreeNode.getLeftChild());
  }

  @Test
  void setRightChild() {
    /* div */
    divTree.setRightChild(new TreeFloat(new SFloat(1)));
    var divTreeNode = (OpNode) divTree.getNode();
    assertEquals(new SFloat(1), divTreeNode.getRightChild());
    /* mult */
    multTree.setRightChild(new TreeBinary(new SBinary("1")));
    var multTreeNode = (OpNode) multTree.getNode();
    assertEquals(new SBinary("1"), multTreeNode.getRightChild());
  }

  @Test
  void getAndSetNode() {
    /* not */
    var notTestNode = new Not(new SBool(true));
    notTree.setNode(notTestNode);
    assertEquals(notTestNode, notTree.getNode());
    /* or */
    var orTestNode = new Or(new SBool(false), new SBinary("1"));
    orTree.setNode(orTestNode);
    assertEquals(orTestNode, orTree.getNode());
  }


  @Test
  void eval() {
    var notTestNode = new Not(new SBool(true));
    notTree.setNode(notTestNode);
    assertEquals(new SBool(false), notTree.eval());

    var orTestNode = new Or(new SBool(false), new SBinary("1"));
    orTree.setNode(orTestNode);
    assertEquals(new SBinary("1"), orTree.eval());
  }

  @Test
  void nullNode() {
    var testNull = new TreeNull();
    assertEquals(new SNull(), testNull.eval());
  }
}