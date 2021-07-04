package cl.uchile.dcc.scrabble.gui.AST.State;

import cl.uchile.dcc.scrabble.gui.AST.Nodes.INode;
import cl.uchile.dcc.scrabble.gui.natives.INumber;
import cl.uchile.dcc.scrabble.gui.natives.Ilogical;
import cl.uchile.dcc.scrabble.gui.natives.operations.INumberOperable;

public class NumberState implements State {

  /**
   * @param leftChild  left child of caller node, at this point it IS a INumber
   * @param rightChild node to add
   * @return new INumber containing the result of the sum of nodes
   */
  public INumber add(INode leftChild, INode rightChild) {
    var left = (INumberOperable) leftChild;
    try {
      INumber right = (INumber) rightChild.eval();
      return left.add(right);
    }
    /* Incompatible operations return null */ catch (ClassCastException e) {
      return null;
    }
  }

  /**
   * @param leftChild  left child of caller node, at this point it IS a INumber
   * @param rightChild node to add
   * @return new INumber containing the result of the substraction of nodes
   */
  public INumber subs(INode leftChild, INode rightChild) {
    var left = (INumberOperable) leftChild;
    try {
      INumber right = (INumber) rightChild.eval();
      return left.subs(right);
    } catch (ClassCastException e) {
      return null;
    }
  }

  /**
   * @param leftChild  left child of caller node, at this point it IS a INumber
   * @param rightChild node to add
   * @return new INumber containing the result of the product of the nodes
   */
  public INumber mult(INode leftChild, INode rightChild) {
    var left = (INumberOperable) leftChild;
    try {
      INumber right = (INumber) rightChild.eval();
      return left.mult(right);
    } catch (ClassCastException e) {
      return null;
    }
  }

  /**
   * @param leftChild  left child of caller node, at this point it IS a INumber
   * @param rightChild node to add
   * @return new INumber containing the result of the expression
   */
  public INumber div(INode leftChild, INode rightChild) {
    var left = (INumberOperable) leftChild;
    try {
      INumber right = (INumber) rightChild.eval();
      return left.div(right);
    } catch (ClassCastException e) {
      return null;
    }
  }

  /* begin incompatible methods */
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
  /* end incompatible methods */

}
