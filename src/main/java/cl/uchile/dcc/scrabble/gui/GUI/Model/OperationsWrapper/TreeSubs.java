package cl.uchile.dcc.scrabble.gui.GUI.Model.OperationsWrapper;

import cl.uchile.dcc.scrabble.gui.AST.Nodes.INode;
import cl.uchile.dcc.scrabble.gui.AST.Nodes.Subs;

public class TreeSubs extends TreeOpNode {

  public TreeSubs() {
    super("-", new Subs((INode) null, null));
  }
}
