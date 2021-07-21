package cl.uchile.dcc.scrabble.gui.AST.State;

import cl.uchile.dcc.scrabble.gui.AST.Nodes.Add;
import cl.uchile.dcc.scrabble.gui.AST.Nodes.And;
import cl.uchile.dcc.scrabble.gui.AST.Nodes.Div;
import cl.uchile.dcc.scrabble.gui.AST.Nodes.INode;
import cl.uchile.dcc.scrabble.gui.AST.Nodes.Mult;
import cl.uchile.dcc.scrabble.gui.AST.Nodes.Not;
import cl.uchile.dcc.scrabble.gui.AST.Nodes.OpNode;
import cl.uchile.dcc.scrabble.gui.AST.Nodes.Or;
import cl.uchile.dcc.scrabble.gui.AST.Nodes.Subs;
import cl.uchile.dcc.scrabble.gui.natives.interfaces.INative;
import cl.uchile.dcc.scrabble.gui.natives.interfaces.Ilogical;
import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SBinary;
import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SBool;
import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SFloat;
import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SInt;
import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SString;

public class OpState implements State {

  /**
   * OpState must be able to switch user's state to calculate node
   *
   * @param stateHandler Operation Node to change state
   * @param child        INative to change state accordingly
   */
  public static void switchState(OpNode stateHandler, INative child) {
    /* FeelsLike código frágil :[ */
    if (child instanceof SBinary) {
      stateHandler.setState(new BinaryState());
    }
    if (child instanceof SBool) {
      stateHandler.setState(new BoolState());
    }
    if (child instanceof SInt || child instanceof SFloat) {
      stateHandler.setState(new NumberState());
    }
    if (child instanceof SString) {
      stateHandler.setState(new StringState());
    }
  }

  /**
   * Calculates the addition of two Nodes
   *
   * @param leftChild  right child node, if this is called it should NOT be a INative
   * @param rightChild right child node, if this is called it should NOT be a INative
   * @return INative of evaluating the sum of two nodes, if operation is invalid NULL
   */
  public INative add(INode leftChild, INode rightChild) {
    INative left = leftChild.eval();
    INative right = rightChild.eval();
    /* Delegate task to Add State */
    var tmp = new Add(left, right);
    /* Switch state to finally get value */
    OpState.switchState(tmp, left);
    return tmp.eval();
  }

  /**
   * Calculates the substraction of two Nodes
   *
   * @param leftChild  right child node, if this is called it should NOT be a INative
   * @param rightChild right child node, if this is called it should NOT be a INative
   * @return INative of evaluating the substraction of two nodes, if operation is invalid NULL
   */
  @Override
  public INative subs(INode leftChild, INode rightChild) {
    INative left = leftChild.eval();
    INative right = rightChild.eval();
    var tmp = new Subs(left, right);
    OpState.switchState(tmp, left);
    return tmp.eval();
  }

  /**
   * Calculates the division of two Nodes
   *
   * @param leftChild  right child node, if this is called it should NOT be a INative
   * @param rightChild right child node, if this is called it should NOT be a INative
   * @return INative of evaluating the division of two nodes, if operation is invalid NULL
   */
  @Override
  public INative div(INode leftChild, INode rightChild) {
    INative left = leftChild.eval();
    INative right = rightChild.eval();
    var tmp = new Div(left, right);
    OpState.switchState(tmp, left);
    return tmp.eval();
  }

  /**
   * Calculates the product of two nodes
   *
   * @param leftChild  right child node, if this is called it should NOT be a INative
   * @param rightChild right child node, if this is called it should NOT be a INative
   * @return INative of evaluating the product of two nodes, if operation is invalid NULL
   */
  @Override
  public INative mult(INode leftChild, INode rightChild) {
    INative left = leftChild.eval();
    INative right = rightChild.eval();
    var tmp = new Mult(left, right);
    OpState.switchState(tmp, left);
    return tmp.eval();
  }

  /**
   * Applies logical AND to two Nodes
   *
   * @param leftChild  right child node, if this is called it should NOT be a INative
   * @param rightChild right child node, if this is called it should NOT be a INative
   * @return Ilogical of evaluating the logical AND of two nodes, if operation is invalid NULL
   */
  @Override
  public Ilogical and(INode leftChild, INode rightChild) {
    INative left = leftChild.eval();
    INative right = rightChild.eval();
    var tmp = new And(left, right);
    OpState.switchState(tmp, left);
    return (Ilogical) tmp.eval();
  }

  /**
   * Applies logical OR to two Nodes
   *
   * @param leftChild  right child node, if this is called it should NOT be a INative
   * @param rightChild right child node, if this is called it should NOT be a INative
   * @return Ilogical of evaluating the logical OR of two nodes, if operation is invalid NULL
   */
  @Override
  public Ilogical or(INode leftChild, INode rightChild) {
    INative left = leftChild.eval();
    INative right = rightChild.eval();
    var tmp = new Or(left, right);
    OpState.switchState(tmp, left);
    return (Ilogical) tmp.eval();
  }

  /**
   * Applies logical NOT to Node
   *
   * @param node Node to do the unary logical operation NOT
   * @return Ilogical of evaluating the logical NOT of current Node
   */
  @Override
  public Ilogical not(INode node) {
    try {
      Ilogical ilogical = (Ilogical) node.eval();
      var tmp = new Not(ilogical);
      OpState.switchState(tmp, ilogical);
      return (Ilogical) tmp.eval();
    } catch (ClassCastException e) {
      return null;
    }
  }
}
