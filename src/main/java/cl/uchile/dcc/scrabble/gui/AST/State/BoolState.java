package cl.uchile.dcc.scrabble.gui.AST.State;

import cl.uchile.dcc.scrabble.gui.AST.Nodes.INode;
import cl.uchile.dcc.scrabble.gui.natives.interfaces.INative;
import cl.uchile.dcc.scrabble.gui.natives.interfaces.Ilogical;
import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SBool;

public class BoolState implements State {

  /* start invalid methods */
  @Override
  public INative add(INode left, INode right) {
    return null;
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
  /* end invalid methods */

  /**
   * @param left  left child of caller node, at this point it IS a SBool
   * @param right node to add
   * @return new SBinary containing the result of the logical AND of nodes
   */
  public Ilogical and(INode left, INode right) {
    var leftBool = (SBool) left;
    try {
      Ilogical rightBool = (Ilogical) right;
      return leftBool.and(rightBool);
    }
    /* Incompatible operations return null */ catch (ClassCastException e) {
      return null;
    }
  }

  /**
   * @param left  left child of caller node, at this point it IS a SBool
   * @param right node to add
   * @return new SBinary containing the result of the logical OR of nodes
   */
  public Ilogical or(INode left, INode right) {
    var leftBool = (SBool) left;
    try {
      Ilogical rightBool = (Ilogical) right;
      return leftBool.or(rightBool);
    }
    /* Incompatible operations return null */ catch (ClassCastException e) {
      return null;
    }
  }

  /**
   * @param node left child of caller node, at this point it IS a SBool
   * @return logical negation of left Node
   */
  public Ilogical not(INode node) {
    try {
      var bool = (Ilogical) node;
      return bool.not();
    } catch (ClassCastException e) {
      return null;
    }
  }

}
