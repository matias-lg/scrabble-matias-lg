package cl.uchile.dcc.scrabble.gui.GUI.Model.OperationsWrapper;

import cl.uchile.dcc.scrabble.gui.AST.Nodes.INode;
import cl.uchile.dcc.scrabble.gui.AST.Nodes.Mult;

public class TreeMult extends TreeOpNode {

  public TreeMult() {
    super("*", new Mult((INode) null, null));
  }
}
