package cl.uchile.dcc.scrabble.gui.AST.Nodes;

import cl.uchile.dcc.scrabble.gui.nativeClasses.SBinary;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SBool;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SString;
import cl.uchile.dcc.scrabble.gui.natives.INative;
import cl.uchile.dcc.scrabble.gui.natives.operations.INumberOperable;

public class Mult extends OpNode {


  public Mult(SString leftChild,
      INode rightChild) {
    super(leftChild, rightChild);
  }

  public Mult(INumberOperable leftChild,
      INode rightChild) {
    super(leftChild, rightChild);
  }

  public Mult(SBinary leftChild,
      INode rightChild) {
    super(leftChild, rightChild);
  }

  public Mult(SBool leftChild,
      INode rightChild) {
    super(leftChild, rightChild);
  }

  public Mult(INode leftChild, INode rightChild) {
    super(leftChild, rightChild);
  }

  /**
   * Multiplies left and right childs, evaluating them first
   *
   * @return New INative containing the result of product of left and right childs
   */
  @Override
  public INative eval() {
    return this.state.mult(getLeftChild(), getRightChild());
  }
}
