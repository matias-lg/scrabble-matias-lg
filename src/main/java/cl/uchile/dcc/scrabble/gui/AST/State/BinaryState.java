package cl.uchile.dcc.scrabble.gui.AST.State;

import cl.uchile.dcc.scrabble.gui.AST.INode;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SBinary;
import cl.uchile.dcc.scrabble.gui.natives.IInteger;
import cl.uchile.dcc.scrabble.gui.natives.INative;
import cl.uchile.dcc.scrabble.gui.natives.Ilogical;

public class BinaryState implements State {

  /**
   * @param left  left child of caller node, at this point it IS a SBinary
   * @param right node to add
   * @return new SBinary containing the result of the sum of nodes
   */
  @Override
  public INative add(INode left, INode right) {
    var leftBin = (SBinary) left;
    try {
      IInteger rightInt = (IInteger) right.eval();
      return leftBin.add(rightInt);
    }
    /* Incompatible operations return null */ catch (ClassCastException e) {
      return null;
    }
  }

  /**
   * @param left  left child of caller node, at this point it IS a SBinary
   * @param right node to add
   * @return new SBinary containing the result of the substraction of nodes
   */
  @Override
  public INative subs(INode left, INode right) {
    var leftBin = (SBinary) left;
    try {
      IInteger rightInt = (IInteger) right.eval();
      return leftBin.subs(rightInt);
    }
    /* Incompatible operations return null */ catch (ClassCastException e) {
      return null;
    }
  }

  /**
   * @param left  left child of caller node, at this point it IS a SBinary
   * @param right node to add
   * @return new SBinary containing the result of the division of nodes
   */
  @Override
  public INative div(INode left, INode right) {
    var leftBin = (SBinary) left;
    try {
      IInteger rightInt = (IInteger) right.eval();
      return leftBin.div(rightInt);
    }
    /* Incompatible operations return null */ catch (ClassCastException e) {
      return null;
    }
  }

  /**
   * @param left  left child of caller node, at this point it IS a SBinary
   * @param right node to add
   * @return new SBinary containing the result of the product of nodes
   */
  @Override
  public INative mult(INode left, INode right) {
    var leftBin = (SBinary) left;
    try {
      IInteger rightInt = (IInteger) right.eval();
      return leftBin.mult(rightInt);
    }
    /* Incompatible operations return null */ catch (ClassCastException e) {
      return null;
    }
  }

  /**
   * @param left  left child of caller node, at this point it IS a SBinary
   * @param right node to add
   * @return new SBinary containing the result of the logical AND of nodes
   */
  public Ilogical and(INode left, INode right) {
    var leftBin = (SBinary) left;
    try {
      Ilogical rightBool = (Ilogical) right.eval();
      return leftBin.and(rightBool);
    }
    /* Incompatible operations return null */ catch (ClassCastException e) {
      return null;
    }
  }

  /**
   * @param left  left child of caller node, at this point it IS a SBinary
   * @param right node to add
   * @return new SBinary containing the result of the logical AND of nodes
   */
  public Ilogical or(INode left, INode right) {
    var leftBin = (SBinary) left;
    try {
      Ilogical rightBool = (Ilogical) right.eval();
      return leftBin.or(rightBool);
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
