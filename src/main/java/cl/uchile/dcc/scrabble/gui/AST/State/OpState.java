package cl.uchile.dcc.scrabble.gui.AST.State;

import cl.uchile.dcc.scrabble.gui.AST.Add;
import cl.uchile.dcc.scrabble.gui.AST.And;
import cl.uchile.dcc.scrabble.gui.AST.Div;
import cl.uchile.dcc.scrabble.gui.AST.INode;
import cl.uchile.dcc.scrabble.gui.AST.Mult;
import cl.uchile.dcc.scrabble.gui.AST.Not;
import cl.uchile.dcc.scrabble.gui.AST.Or;
import cl.uchile.dcc.scrabble.gui.AST.Subs;
import cl.uchile.dcc.scrabble.gui.natives.INative;
import cl.uchile.dcc.scrabble.gui.natives.Ilogical;
import cl.uchile.dcc.scrabble.gui.natives.operations.INumberOperable;

public class OpState implements State {

  /**
   * @param leftChild  right child node, if this is called it should NOT be a INative
   * @param rightChild right child node, if this is called it should NOT be a INative
   * @return INative of evaluating the sum of two nodes, if operation is invalid NULL
   */
  public INative add(INode leftChild, INode rightChild) {
    /* OpNode already evaluated leftChild and rightChild - We can downcast
    /* Delegate task to Add State */
    var tmp = new Add(leftChild.eval(), rightChild.eval());
    /* For some reason copying from tmp nets the correct type */
    var calculator = new Add(tmp.getLeftChild(), tmp.getRightChild());
    return calculator.eval();
  }

  /**
   * @param left  right child node, if this is called it should NOT be a INative
   * @param right right child node, if this is called it should NOT be a INative
   * @return INative of evaluating the substraction of two nodes, if operation is invalid NULL
   */
  @Override
  public INative subs(INode left, INode right) {
    var tmp = new Subs(left, right);
    var calculator = new Subs(tmp.getLeftChild(), tmp.getRightChild());
    return calculator.eval();
  }

  /**
   * @param left  right child node, if this is called it should NOT be a INative
   * @param right right child node, if this is called it should NOT be a INative
   * @return INative of evaluating the division of two nodes, if operation is invalid NULL
   */
  @Override
  public INative div(INode left, INode right) {
    var tmp = new Div(left, right);
    var calculator = new Div(tmp.getLeftChild(), tmp.getRightChild());
    return calculator.eval();
  }

  /**
   * @param left  right child node, if this is called it should NOT be a INative
   * @param right right child node, if this is called it should NOT be a INative
   * @return INative of evaluating the product of two nodes, if operation is invalid NULL
   */
  @Override
  public INative mult(INode left, INode right) {
    var tmp = new Mult(left, right);
    var calculator = new Mult(tmp.getLeftChild(), tmp.getRightChild());
    return calculator.eval();
  }

  /**
   * @param left  right child node, if this is called it should NOT be a INative
   * @param right right child node, if this is called it should NOT be a INative
   * @return Ilogical of evaluating the logical AND of two nodes, if operation is invalid NULL
   */
  @Override
  public Ilogical and(INode left, INode right) {
    var tmp = new And(left, right);
    var calculator = new And(tmp.getLeftChild(), tmp.getRightChild());
    return (Ilogical) calculator.eval();
  }

  /**
   * @param left  right child node, if this is called it should NOT be a INative
   * @param right right child node, if this is called it should NOT be a INative
   * @return Ilogical of evaluating the logical OR of two nodes, if operation is invalid NULL
   */
  @Override
  public Ilogical or(INode left, INode right) {
    var tmp = new Or(left, right);
    var calculator = new Or(tmp.getLeftChild(), tmp.getRightChild());
    return (Ilogical) calculator.eval();
  }

  @Override
  public Ilogical not(INode node) {
    var tmp = new Not(node);
    var calculator = new Not(tmp.getLeftChild());
    return (Ilogical) calculator.eval();
  }
}
