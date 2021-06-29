package cl.uchile.dcc.scrabble.gui.AST.State;

import cl.uchile.dcc.scrabble.gui.AST.INode;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SBinary;
import cl.uchile.dcc.scrabble.gui.natives.IInteger;
import cl.uchile.dcc.scrabble.gui.natives.INative;

/* TODO Add boolean operations */
public class BinaryState implements State {

  /**
   *
   * @param left left child of caller node, at this point it IS a SBinary
   * @param right node to add
   * @return new SBinary containing the result of the sum of nodes
   */
  @Override
  public INative add(INode left, INode right) {
    var leftBin = (SBinary) left;
    try {
      IInteger rightInt = (IInteger) right;
      return leftBin.add(rightInt);
    }
    /* Incompatible operations return null */
    catch (ClassCastException e){
      return null;
    }
  }

  @Override
  public INative subs(INode left, INode right) {
    var leftBin = (SBinary) left;
    try {
      IInteger rightInt = (IInteger) right;
      return leftBin.subs(rightInt);
    }
    /* Incompatible operations return null */
    catch (ClassCastException e){
      return null;
    }
  }

  @Override
  public INative div(INode left, INode right) {
    var leftBin = (SBinary) left;
    try {
      IInteger rightInt = (IInteger) right;
      return leftBin.div(rightInt);
    }
    /* Incompatible operations return null */
    catch (ClassCastException e){
      return null;
    }
  }

  @Override
  public INative mult(INode left, INode right) {
    var leftBin = (SBinary) left;
    try {
      IInteger rightInt = (IInteger) right;
      return leftBin.mult(rightInt);
    }
    /* Incompatible operations return null */
    catch (ClassCastException e){
      return null;
    }
  }
}
