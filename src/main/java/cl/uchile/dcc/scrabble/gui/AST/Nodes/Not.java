package cl.uchile.dcc.scrabble.gui.AST.Nodes;

import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SBinary;
import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SBool;
import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SString;
import cl.uchile.dcc.scrabble.gui.natives.interfaces.INative;
import cl.uchile.dcc.scrabble.gui.natives.interfaces.operations.INumberOperable;

public class Not extends OpNode {


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
