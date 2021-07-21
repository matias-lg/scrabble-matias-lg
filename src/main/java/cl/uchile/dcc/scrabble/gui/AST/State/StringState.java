package cl.uchile.dcc.scrabble.gui.AST.State;

import cl.uchile.dcc.scrabble.gui.AST.Nodes.INode;
import cl.uchile.dcc.scrabble.gui.natives.interfaces.INative;
import cl.uchile.dcc.scrabble.gui.natives.interfaces.Ilogical;
import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SString;

public class StringState implements State {

  /**
   * @param leftChild  left child of caller node, at this point it IS a SString
   * @param rightChild node to add
   * @return new SString containing the result of the expression
   */
  public SString add(INode leftChild, INode rightChild) {
    var left = (SString) leftChild;
    INative right = rightChild.eval();
    return left.add(right);
  }

  /* begin invalid operations */
  @Override
  public INative subs(INode left, INode right) {
    return null;
  }

  @Override
  public INative div(INode left, INode right) {
    return null;
  }

  @Override
  public INative mult(INode left, INode right) {
    return null;
  }

  @Override
  public Ilogical and(INode left, INode right) {
    return null;
  }

  @Override
  public Ilogical or(INode left, INode right) {
    return null;
  }

  @Override
  public Ilogical not(INode node) {
    return null;
  }
  /* end invalid operations */

}
