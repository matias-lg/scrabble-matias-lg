package cl.uchile.dcc.scrabble.gui.GUI.Model.TypesWrapper;

import cl.uchile.dcc.scrabble.gui.AST.Nodes.INode;
import cl.uchile.dcc.scrabble.gui.GUI.Model.AstNodeWrapper;

/**
 * Wraps INative nodes
 */
public abstract class TreeType extends AstNodeWrapper {

  public TreeType(String label, INode node) {
    super(label, node);
  }
}
