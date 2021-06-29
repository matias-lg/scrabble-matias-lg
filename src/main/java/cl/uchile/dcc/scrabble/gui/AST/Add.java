package cl.uchile.dcc.scrabble.gui.AST;

import cl.uchile.dcc.scrabble.gui.AST.State.NumberState;
import cl.uchile.dcc.scrabble.gui.AST.State.OpState;
import cl.uchile.dcc.scrabble.gui.AST.State.State;
import cl.uchile.dcc.scrabble.gui.AST.State.StringState;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SString;
import cl.uchile.dcc.scrabble.gui.natives.IInteger;
import cl.uchile.dcc.scrabble.gui.natives.INative;
import cl.uchile.dcc.scrabble.gui.natives.INumber;
import cl.uchile.dcc.scrabble.gui.natives.operations.INumberOperable;

public class Add extends OpNode {
  private INode leftChild;

  /* int or float */
  public Add(INumberOperable leftChild, INode rightChild){
    super(leftChild, rightChild);
  }

  /* default */
  public Add(INode leftChild, INode rightChild){
    super(leftChild, rightChild);
  }

  /**
   * Sums left and right childs, evaluating them first
   * @return New INative containing the result of adding left and right childs
   */
  @Override
  public INative eval() {
    return this.state.add(getLeftChild(), getRightChild());
  }
}
