package cl.uchile.dcc.scrabble.gui.AST;

import cl.uchile.dcc.scrabble.gui.AST.State.State;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SBinary;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SBool;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SString;
import cl.uchile.dcc.scrabble.gui.natives.INative;
import cl.uchile.dcc.scrabble.gui.natives.operations.INumberOperable;

public class Subs extends OpNode {

  public Subs(INode leftChild, INode rightChild, State state) {
    super(leftChild, rightChild, state);
  }

  public Subs(SString leftChild,
      INode rightChild) {
    super(leftChild, rightChild);
  }

  public Subs(INumberOperable leftChild,
      INode rightChild) {
    super(leftChild, rightChild);
  }

  public Subs(SBinary leftChild,
      INode rightChild) {
    super(leftChild, rightChild);
  }

  public Subs(SBool leftChild,
      INode rightChild) {
    super(leftChild, rightChild);
  }

  public Subs(INode leftChild, INode rightChild) {
    super(leftChild, rightChild);
  }

  /**
   * Substracts left and right childs, evaluating them first
   *
   * @return New INative containing the result of substraction of left and right childs
   */
  @Override
  public INative eval() {
    return this.state.subs(getLeftChild(), getRightChild());
  }
}
