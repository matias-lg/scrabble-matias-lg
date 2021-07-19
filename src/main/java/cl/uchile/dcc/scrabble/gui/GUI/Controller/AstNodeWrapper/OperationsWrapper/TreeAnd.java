package cl.uchile.dcc.scrabble.gui.GUI.Controller.AstNodeWrapper.OperationsWrapper;

import cl.uchile.dcc.scrabble.gui.AST.Nodes.And;
import cl.uchile.dcc.scrabble.gui.AST.Nodes.INode;

public class TreeAnd extends TreeOpNode {

  public TreeAnd() {
    super("∧", new And((INode) null, null));
  }
}