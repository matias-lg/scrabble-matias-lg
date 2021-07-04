package cl.uchile.dcc.scrabble.gui.AST.Nodes;

import cl.uchile.dcc.scrabble.gui.natives.INative;

/**
 * AST Nodes
 */
public interface INode {

  /**
   * Every Node of the AST must be capable of evaluating its value as a INative
   */
  public INative eval();

}
