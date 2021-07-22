package cl.uchile.dcc.scrabble.gui.GUI.Model.OperationsWrapper;

import cl.uchile.dcc.scrabble.gui.AST.Nodes.INode;
import cl.uchile.dcc.scrabble.gui.AST.Nodes.Not;

public class TreeNot extends TreeOpNode {

  public TreeNot() {
    super("~", new Not((INode) null));
  }
}
