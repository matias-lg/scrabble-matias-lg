package cl.uchile.dcc.scrabble.gui.AST.State;

import cl.uchile.dcc.scrabble.gui.AST.INode;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SString;
import cl.uchile.dcc.scrabble.gui.natives.INative;

public class StringState implements State {

  /**
   *
   * @param leftChild left child of caller node, at this point it IS a SString
   * @param rightChild node to add
   * @return new SString containing the result of the expression
   */
  public SString add(INode leftChild, INode rightChild){
    var left = (SString) leftChild;
    System.out.println("We are in StringState's method!");
    INative right = rightChild.eval();
    return left.add(right);
  }

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
}
