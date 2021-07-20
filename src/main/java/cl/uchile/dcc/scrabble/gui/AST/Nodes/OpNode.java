package cl.uchile.dcc.scrabble.gui.AST.Nodes;

import cl.uchile.dcc.scrabble.gui.AST.State.BinaryState;
import cl.uchile.dcc.scrabble.gui.AST.State.BoolState;
import cl.uchile.dcc.scrabble.gui.AST.State.NumberState;
import cl.uchile.dcc.scrabble.gui.AST.State.OpState;
import cl.uchile.dcc.scrabble.gui.AST.State.State;
import cl.uchile.dcc.scrabble.gui.AST.State.StringState;
import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SBinary;
import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SBool;
import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SString;
import cl.uchile.dcc.scrabble.gui.natives.interfaces.operations.INumberOperable;

/**
 * Tree Node that represents a binary or unary operation. eg: sum, and, or
 */
public abstract class OpNode implements INode {

  protected INode leftChild;
  protected INode rightChild;
  protected State state;


  /* left is SString, set state to StringState */
  public OpNode(SString leftChild, INode rightChild) {
    this.state = new StringState();
    this.leftChild = leftChild;
    this.rightChild = rightChild;
  }

  /* left is Int or float */
  public OpNode(INumberOperable leftChild, INode rightChild) {
    this.state = new NumberState();
    this.leftChild = leftChild;
    this.rightChild = rightChild;
  }

  /* left is Binary */
  public OpNode(SBinary leftChild, INode rightChild) {
    this.state = new BinaryState();
    this.leftChild = leftChild;
    this.rightChild = rightChild;
  }

  /* left is Bool */
  public OpNode(SBool leftChild, INode rightChild) {
    this.state = new BoolState();
    this.leftChild = leftChild;
    this.rightChild = rightChild;
  }

  /* default constructor - two nodes */
  /* Since we can't downcast in runtime we evaluate right away */
  public OpNode(INode leftChild, INode rightChild) {
    this.state = new OpState();
    try {
      this.leftChild = leftChild.eval();
    } catch (Exception e) {
      /* in case leftchild is null keep it like that */
      this.leftChild = null;
    }
    try {
      this.rightChild = rightChild.eval();
    } catch (Exception e) {
      /* set rightChild to null when called by NOT node */
      this.rightChild = null;
    }
  }

  /**
   * Sets a state for OpNode instance
   *
   * @param state state to set the OpNode to
   */
  public void setState(State state) {
    this.state = state;
  }

  /**
   * Gets the current state of the node
   *
   * @return Node's state
   */
  public State getState() {
    return this.state;
  }

  /**
   * Gets Node's left child
   *
   * @return Node's left child
   */
  public INode getLeftChild() {
    return leftChild;
  }

  /**
   * Gets Node's right child
   *
   * @return Node's right child
   */
  public INode getRightChild() {
    return rightChild;
  }

  /**
   * Sets left child of node
   *
   * @param leftChild INode to set as leftChild
   */
  public void setLeftChild(INode leftChild) {
    this.leftChild = leftChild;
  }

  /**
   * Sets right child of node
   *
   * @param rightChild INode to set as rightChild
   */
  public void setRightChild(INode rightChild) {
    this.rightChild = rightChild;
  }
}
