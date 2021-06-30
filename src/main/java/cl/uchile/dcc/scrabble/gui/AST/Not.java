package cl.uchile.dcc.scrabble.gui.AST;

import cl.uchile.dcc.scrabble.gui.AST.State.State;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SBinary;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SBool;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SString;
import cl.uchile.dcc.scrabble.gui.natives.INative;
import cl.uchile.dcc.scrabble.gui.natives.operations.INumberOperable;

public class Not extends OpNode {


  public Not(INode leftChild, INode rightChild, State state) {
    super(leftChild, rightChild, state);
  }

  public Not(SString node) {
    super(node, null);
  }

  public Not(INumberOperable node) {
    super(node, null);
  }

  public Not(SBinary node) {
    super(node, null);
  }

  public Not(SBool node) {
    super(node, null);
  }

  public Not(INode node) {
    super(node, null);
  }

  /**
   * logical NOT of left child, evaluating it first
   *
   * @return New INative containing the result of logical NOT on left child
   */
  @Override
  public INative eval() {
    return (INative) this.state.not(getLeftChild());
  }
}
