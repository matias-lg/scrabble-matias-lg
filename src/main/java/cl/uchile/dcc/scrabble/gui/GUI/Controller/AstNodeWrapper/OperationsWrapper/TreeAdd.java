package cl.uchile.dcc.scrabble.gui.GUI.Controller.AstNodeWrapper.OperationsWrapper;

import cl.uchile.dcc.scrabble.gui.AST.Nodes.Add;
import cl.uchile.dcc.scrabble.gui.AST.Nodes.INode;

public class TreeAdd extends TreeOpNode{
  public TreeAdd() {
    super("+", new Add( (INode) null, null));
  }
}
