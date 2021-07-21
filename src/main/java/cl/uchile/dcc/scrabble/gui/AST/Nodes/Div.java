package cl.uchile.dcc.scrabble.gui.AST.Nodes;

import cl.uchile.dcc.scrabble.gui.natives.interfaces.INative;
import cl.uchile.dcc.scrabble.gui.natives.interfaces.operations.INumberOperable;
import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SBinary;
import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SBool;
import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SString;

public class Div extends OpNode {


  public Div(SString leftChild,
      INode rightChild) {
    super(leftChild, rightChild);
  }

  public Div(INumberOperable leftChild,
      INode rightChild) {
    super(leftChild, rightChild);
  }

  public Div(SBinary leftChild,
      INode rightChild) {
    super(leftChild, rightChild);
  }

  public Div(SBool leftChild,
      INode rightChild) {
    super(leftChild, rightChild);
  }

  public Div(INode leftChild, INode rightChild) {
    super(leftChild, rightChild);
  }

  /**
   * Divides left and right childs, evaluating them first
   *
   * @return New INative containing the result of division of left and right childs
   */
  @Override
  public INative eval() {
    return this.state.div(getLeftChild(), getRightChild());
  }
}
