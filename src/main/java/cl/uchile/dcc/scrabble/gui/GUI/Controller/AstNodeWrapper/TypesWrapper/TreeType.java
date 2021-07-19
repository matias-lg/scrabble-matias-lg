package cl.uchile.dcc.scrabble.gui.GUI.Controller.AstNodeWrapper.TypesWrapper;

import cl.uchile.dcc.scrabble.gui.AST.Nodes.INode;
import cl.uchile.dcc.scrabble.gui.GUI.Controller.AstNodeWrapper.AstNodeWrapper;

public abstract class TreeType extends AstNodeWrapper {
  public TreeType(String label, INode node) {
    super(label, node);
  }
}
