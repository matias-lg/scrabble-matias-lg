package cl.uchile.dcc.scrabble.gui.AST.Nodes;

import cl.uchile.dcc.scrabble.gui.natives.interfaces.INative;
import cl.uchile.dcc.scrabble.gui.natives.interfaces.operations.INumberOperable;
import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SBinary;
import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SBool;
import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SString;

public class Add extends OpNode {

  public Add(SString leftChild, INode rightChild) {
    super(leftChild, rightChild);
  }

  public Add(INumberOperable leftChild, INode rightChild) {
    super(leftChild, rightChild);
  }

  public Add(SBinary leftChild, INode rightChild) {
    super(leftChild, rightChild);
  }

  public Add(SBool leftChild, INode rightChild) {
    super(leftChild, rightChild);
  }

  public Add(INode leftChild, INode rightChild) {
    super(leftChild, rightChild);
  }

  /**
   * Sums left and right childs, evaluating them first
   *
   * @return New INative containing the result of adding left and right childs
   */
  @Override
  public INative eval() {
    return this.state.add(getLeftChild(), getRightChild());
  }
}
