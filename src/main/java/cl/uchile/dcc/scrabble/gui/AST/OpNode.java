package cl.uchile.dcc.scrabble.gui.AST;

import cl.uchile.dcc.scrabble.gui.AST.State.NumberState;
import cl.uchile.dcc.scrabble.gui.AST.State.OpState;
import cl.uchile.dcc.scrabble.gui.AST.State.State;
import cl.uchile.dcc.scrabble.gui.AST.State.StringState;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SString;
import cl.uchile.dcc.scrabble.gui.natives.INative;
import cl.uchile.dcc.scrabble.gui.natives.operations.INumberOperable;

/**
 * Tree Node that represents a binary or unary operation. eg: sum, and, or
 */
public abstract class OpNode implements INode {
  protected INode leftChild;
  protected INode rightChild;
  protected State state;

  /* Constructor for testing purposes */
  public OpNode(INode leftChild, INode rightChild, State state){
    this.state = state;
    this.leftChild = leftChild;
    this.rightChild = rightChild;
  }
  /* left is SString, set state to StringState */

  public OpNode(SString leftChild, INode rightChild){
    this.state = new StringState();
    this.leftChild = leftChild;
    this.rightChild = rightChild;
  }
  /* left is Int or float */

  public OpNode(INumberOperable leftChild, INode rightChild){
    this.state = new NumberState();
    this.leftChild = leftChild;
    this.rightChild = rightChild;
  }
  /* default constructor - two nodes */
  public OpNode(INode leftChild, INode rightChild){
    this.state = new OpState();
    this.leftChild = leftChild;
    this.rightChild = rightChild;
  }

  public State getState(){
    return this.state;
  }

  public INode getLeftChild(){
    return leftChild;
  }

  public INode getRightChild(){
    return rightChild;
  }
}
