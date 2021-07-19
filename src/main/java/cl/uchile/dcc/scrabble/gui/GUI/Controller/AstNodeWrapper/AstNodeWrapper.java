package cl.uchile.dcc.scrabble.gui.GUI.Controller.AstNodeWrapper;

import cl.uchile.dcc.scrabble.gui.AST.Nodes.INode;
import cl.uchile.dcc.scrabble.gui.natives.INative;
import javafx.scene.control.TreeItem;

/**
 * We extend TreeItem to also allow it to wrap an AST Node
 */
public abstract class AstNodeWrapper extends TreeItem<String> {
  protected INode node;
  public AstNodeWrapper(String label, INode node){
    super(label);
    this.node = node;
  }

  public INode getNode() {
    return node;
  }

  public INative eval(){
    return this.node.eval();
  }

}
