package cl.uchile.dcc.scrabble.gui.GUI.Controller.AstNodeWrapper.OperationsWrapper;

import cl.uchile.dcc.scrabble.gui.AST.Nodes.INode;
import cl.uchile.dcc.scrabble.gui.AST.Nodes.Or;

public class TreeOr extends TreeOpNode {

  public TreeOr() {
    super("∨", new Or((INode) null, null));
  }
}
