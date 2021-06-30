package cl.uchile.dcc.scrabble.gui.AST.State;

import cl.uchile.dcc.scrabble.gui.AST.INode;
import cl.uchile.dcc.scrabble.gui.natives.INative;
import cl.uchile.dcc.scrabble.gui.natives.Ilogical;

public interface State {

  INative add(INode left, INode right);

  INative subs(INode left, INode right);

  INative div(INode left, INode right);

  INative mult(INode left, INode right);

  Ilogical and(INode left, INode right);

  Ilogical or(INode left, INode right);

  Ilogical not(INode node);
}
