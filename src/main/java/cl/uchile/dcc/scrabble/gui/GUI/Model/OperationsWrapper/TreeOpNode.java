package cl.uchile.dcc.scrabble.gui.GUI.Model.OperationsWrapper;

import cl.uchile.dcc.scrabble.gui.AST.Nodes.OpNode;
import cl.uchile.dcc.scrabble.gui.GUI.Model.AstNodeWrapper;

/*
  Wraps OpNodes
 */
public abstract class TreeOpNode extends AstNodeWrapper {

  protected OpNode node = (OpNode) getNode();

  public TreeOpNode(String label, OpNode node) {
    super(label, node);
  }

  /**
   * Sets left tree child also setting its node
   *
   * @param leftChild left child
   */
  public void setLeftChild(AstNodeWrapper leftChild) {
    getChildren().add(leftChild);
    node.setLeftChild(leftChild.getNode());
  }

  /**
   * Sets right tree child also setting its node
   *
   * @param rightChild right child
   */
  public void setRightChild(AstNodeWrapper rightChild) {
    getChildren().add(rightChild);
    node.setRightChild(rightChild.getNode());
  }
}
