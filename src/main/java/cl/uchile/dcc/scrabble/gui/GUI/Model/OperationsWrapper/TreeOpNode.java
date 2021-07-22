package cl.uchile.dcc.scrabble.gui.GUI.Model.OperationsWrapper;

import cl.uchile.dcc.scrabble.gui.AST.Nodes.OpNode;
import cl.uchile.dcc.scrabble.gui.GUI.Model.AstNodeWrapper;
import java.util.Objects;

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

  /**
   * Compares two TreeOpNodes by their stored labels
   * @param o object to compare with
   * @return <code>true</code> if both store the same node
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof TreeOpNode)) {
      return false;
    }
    TreeOpNode that = (TreeOpNode) o;
    return Objects.equals(getValue(), that.getValue());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getNode());
  }
}
