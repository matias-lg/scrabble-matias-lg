package cl.uchile.dcc.scrabble.gui.GUI.Controller;

import cl.uchile.dcc.scrabble.gui.GUI.Model.OperationsWrapper.TreeAdd;
import cl.uchile.dcc.scrabble.gui.GUI.Model.OperationsWrapper.TreeAnd;
import cl.uchile.dcc.scrabble.gui.GUI.Model.OperationsWrapper.TreeDiv;
import cl.uchile.dcc.scrabble.gui.GUI.Model.OperationsWrapper.TreeMult;
import cl.uchile.dcc.scrabble.gui.GUI.Model.OperationsWrapper.TreeNot;
import cl.uchile.dcc.scrabble.gui.GUI.Model.OperationsWrapper.TreeOpNode;
import cl.uchile.dcc.scrabble.gui.GUI.Model.OperationsWrapper.TreeOr;
import cl.uchile.dcc.scrabble.gui.GUI.Model.OperationsWrapper.TreeSubs;
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
import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SString;

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


  /**
   * Creates an Int node without childs
   *
   * @param value int to save in Tree
   * @return <code>TreeInt</code> containing value
   */
  public static TreeInt createIntNode(SInt value) {
    return new TreeInt(value);
  }

  /**
   * Creates a Float node without childs
   *
   * @param value int to save in Tree
   * @return <code>TreeFloat</code> containing value
   */
  public static TreeFloat createFloatNode(SFloat value) {
    return new TreeFloat(value);
  }

  /**
   * Creates a Binary node without childs
   *
   * @param value binary to save in Tree
   * @return <code>TreeBinary</code> containing value
   */
  public static TreeBinary createBinaryNode(SBinary value) {
    return new TreeBinary(value);
  }

  /**
   * Creates a String node without childs
   *
   * @param value String to save in Tree
   * @return <code>TreeString</code> containing value
   */
  public static TreeString createStringNode(SString value) {
    return new TreeString(value);
  }

  /**
   * Creates a Boolean node without childs
   *
   * @param value boolean to save in Tree
   * @return <code>TreeBool</code> containing value
   */
  public static TreeBool createBoolNode(SBool value) {
    return new TreeBool(value);
  }

  /**
   * Creates a Null Tree node without childs
   * @return New Null Tree node
   */
  public static TreeNull createNullNode(){
    return new TreeNull();
  }
}