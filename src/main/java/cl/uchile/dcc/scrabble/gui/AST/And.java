package cl.uchile.dcc.scrabble.gui.AST;

import cl.uchile.dcc.scrabble.gui.AST.State.State;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SBinary;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SBool;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SString;
import cl.uchile.dcc.scrabble.gui.natives.INative;
import cl.uchile.dcc.scrabble.gui.natives.operations.INumberOperable;

public class And extends OpNode {


  public And(SString leftChild,
      INode rightChild) {
    super(leftChild, rightChild);
  }

  public And(INumberOperable leftChild,
      INode rightChild) {
    super(leftChild, rightChild);
  }

  public And(SBinary leftChild,
      INode rightChild) {
    super(leftChild, rightChild);
  }

  public And(SBool leftChild,
      INode rightChild) {
    super(leftChild, rightChild);
  }

  public And(INode leftChild, INode rightChild) {
    super(leftChild, rightChild);
  }

  /**
   * logical AND between left and right childs, evaluating them first
   *
   * @return New INative containing the result of logical AND of left and right childs
   */
  @Override
  public INative eval() {
    return (INative) this.state.and(getLeftChild(), getRightChild());
  }
}
