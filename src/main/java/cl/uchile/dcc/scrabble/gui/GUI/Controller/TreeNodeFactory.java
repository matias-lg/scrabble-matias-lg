package cl.uchile.dcc.scrabble.gui.GUI.Controller;

import cl.uchile.dcc.scrabble.gui.GUI.Controller.AstNodeWrapper.OperationsWrapper.TreeAdd;
import cl.uchile.dcc.scrabble.gui.GUI.Controller.AstNodeWrapper.OperationsWrapper.TreeAnd;
import cl.uchile.dcc.scrabble.gui.GUI.Controller.AstNodeWrapper.OperationsWrapper.TreeDiv;
import cl.uchile.dcc.scrabble.gui.GUI.Controller.AstNodeWrapper.OperationsWrapper.TreeMult;
import cl.uchile.dcc.scrabble.gui.GUI.Controller.AstNodeWrapper.OperationsWrapper.TreeNot;
import cl.uchile.dcc.scrabble.gui.GUI.Controller.AstNodeWrapper.OperationsWrapper.TreeOpNode;
import cl.uchile.dcc.scrabble.gui.GUI.Controller.AstNodeWrapper.OperationsWrapper.TreeOr;
import cl.uchile.dcc.scrabble.gui.GUI.Controller.AstNodeWrapper.OperationsWrapper.TreeSubs;
import cl.uchile.dcc.scrabble.gui.GUI.Controller.AstNodeWrapper.TypesWrapper.TreeBinary;
import cl.uchile.dcc.scrabble.gui.GUI.Controller.AstNodeWrapper.TypesWrapper.TreeBool;
import cl.uchile.dcc.scrabble.gui.GUI.Controller.AstNodeWrapper.TypesWrapper.TreeFloat;
import cl.uchile.dcc.scrabble.gui.GUI.Controller.AstNodeWrapper.TypesWrapper.TreeInt;
import cl.uchile.dcc.scrabble.gui.GUI.Controller.AstNodeWrapper.TypesWrapper.TreeNull;
import cl.uchile.dcc.scrabble.gui.GUI.Controller.AstNodeWrapper.TypesWrapper.TreeString;

public class TreeNodeFactory {

  /**
   * Helper method that adds two empty childs to a node
   *
   * @param node node to modify
   */
  private static void addEmptyChilds(TreeOpNode node) {
    var emptyNodeLeft = new TreeNull();
    var emptyNodeRight = new TreeNull();
    node.setLeftChild(emptyNodeLeft);
    node.setRightChild(emptyNodeRight);
  }

  /**
   * Helper method that expands a tree node and adds childs
   *
   * @param node node to set up
   */
  private static void setUpNode(TreeOpNode node) {
    node.setExpanded(true);
    addEmptyChilds(node);
  }

  /* BEGIN OPERATION NODE CREATION */

  /**
   * Creates an add node with two empty childs
   *
   * @return new Add node with two childs
   */
  public static TreeAdd createAddNode() {
    var addNode = new TreeAdd();
    setUpNode(addNode);
    return addNode;
  }

  /**
   * Creates an and node with two empty childs
   *
   * @return new And node with two empty childs
   */
  public static TreeAnd createAndNode() {
    var andNode = new TreeAnd();
    setUpNode(andNode);
    return andNode;
  }

  /**
   * Creates a div node with two empty childs
   *
   * @return new Div node with two empty childs
   */
  public static TreeDiv createDivNode() {
    var divNode = new TreeDiv();
    setUpNode(divNode);
    return divNode;
  }

  /**
   * Creates a mult node with two empty childs
   *
   * @return new mult node with two empty childs
   */
  public static TreeMult createMultNode() {
    var multNode = new TreeMult();
    setUpNode(multNode);
    return multNode;
  }

  /**
   * Creates a NOT node with two empty childs
   *
   * @return new not node with two empty childs
   */
  public static TreeNot createNotNode() {
    var notNode = new TreeNot();
    var emptyNode = new TreeNull();
    notNode.setLeftChild(emptyNode);
    notNode.setExpanded(true);
    return notNode;
  }

  /**
   * Creates an OR node with two empty childs
   *
   * @return new OR node with two empty childs
   */
  public static TreeOr createOrNode() {
    var orNode = new TreeOr();
    setUpNode(orNode);
    return orNode;
  }

  /**
   * Creates a Subs node with two empty childs
   *
   * @return new Subs node with two empty childs
   */
  public static TreeSubs createSubsNode() {
    var subsNode = new TreeSubs();
    setUpNode(subsNode);
    return subsNode;
  }
  /* END OPERATION NODE CREATION */


  public static TreeInt createIntNode(int value){
    return new TreeInt(value);
  }

  public static TreeFloat createFloatNode(double value) {
    return new TreeFloat(value);
  }

  public static TreeBinary createBinaryNode(String value){
    return new TreeBinary(value);
  }
  public static TreeString createStringNode(String value){
    return new TreeString(value);
  }

  public static TreeBool createBoolNode(boolean value){
    return new TreeBool(value);
  }
}