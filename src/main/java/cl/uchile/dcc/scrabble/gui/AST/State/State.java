package cl.uchile.dcc.scrabble.gui.AST.State;

import cl.uchile.dcc.scrabble.gui.AST.INode;
import cl.uchile.dcc.scrabble.gui.natives.INative;

public interface State {

  INative add(INode left, INode right);
  INative subs(INode left, INode right);
  INative div(INode left, INode right);
  INative mult(INode left, INode right);

}
