package cl.uchile.dcc.scrabble.gui.AST.State;

import cl.uchile.dcc.scrabble.gui.AST.INode;
import cl.uchile.dcc.scrabble.gui.natives.INative;

public class OpState implements State {
  public INative add(INode leftChild, INode rightChild) {
    System.out.println("We are in OpState's method!");
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
}
