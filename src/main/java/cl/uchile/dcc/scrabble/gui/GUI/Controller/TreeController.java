package cl.uchile.dcc.scrabble.gui.GUI.Controller;

import cl.uchile.dcc.scrabble.gui.AST.Factory.Factory;
import cl.uchile.dcc.scrabble.gui.AST.Nodes.OpNode;
import cl.uchile.dcc.scrabble.gui.GUI.Model.AstNodeWrapper;
import cl.uchile.dcc.scrabble.gui.natives.interfaces.INative;
import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SNull;

/**
 * Controller that App will use, this class will pass and execute all the Scrabble logic
 */
public class TreeController {

  private final Factory factory = new Factory();
  private AstNodeWrapper activeNode;
  private AstNodeWrapper rootTree;

  public TreeController() {
    this.activeNode = rootTree;
  }

  /**
   * Gets the complete tree
   *
   * @return rootTree, the complete updated tree
   */
  public AstNodeWrapper getRootTree() {
    return this.rootTree;
  }

  /**
   * Gets the current active node
   *
   * @return active node of <code>this</code>
   */
  public AstNodeWrapper getActiveNode() {
    return activeNode;
  }

  /**
   * Sets the active node from the View to replace it / keep adding children
   *
   * @param newActiveNode node that the user has just clicked
   */
  public void setActiveNode(AstNodeWrapper newActiveNode) {
    this.activeNode = newActiveNode;
  }


  /**
   * Helper method that updates the tree replacing active node with a new one
   *
   * @param newNode new node to replace current active
   */
  private void updateTree(AstNodeWrapper newNode) {
    // main tree isnt initialized or user selected the root of the Tree, set to root
    if (rootTree == null || getActiveNode().equals(rootTree)) {
      rootTree = newNode;
      setActiveNode(newNode);
    } else {
      // replace parent state
      var parentChildrenList = getActiveNode().getParent().getChildren();
      int position = parentChildrenList.indexOf(getActiveNode());
      var parent = (AstNodeWrapper) getActiveNode().getParent();
      // Check if its OpNode or a SNative
      if (parent.getNode() instanceof OpNode) {
        OpNode parentNode = (OpNode) parent.getNode();
        // add to left or right
        if (position == 0) {
          parentNode.setLeftChild(newNode.getNode());
        } else {
          parentNode.setRightChild(newNode.getNode());
        }
      } else {
        parent.setNode(newNode.getNode());
      }
      // replace active node with this new add node
      var activeNodeParentsChildren = getActiveNode().getParent().getChildren();
      activeNodeParentsChildren.set(activeNodeParentsChildren.indexOf(getActiveNode()), newNode);
    }
  }

  /* BEGIN REPLAMENT OF ACTIVE NODE WITH OPNODES */

  /**
   * Replaces current active tree node with an Add node
   */
  public void createAddNode() {
    var addNode = TreeNodeFactory.createAddNode();
    updateTree(addNode);
  }

  /**
   * Replaces current active node with an And node
   */
  public void createAndNode() {
    var andNode = TreeNodeFactory.createAndNode();
    updateTree(andNode);
  }

  /**
   * Replaces current active node with a Div node
   */
  public void createDivNode() {
    var divNode = TreeNodeFactory.createDivNode();
    updateTree(divNode);
  }

  /**
   * Replaces current active node with a mult node
   */
  public void createMultNode() {
    var multNode = TreeNodeFactory.createMultNode();
    updateTree(multNode);
  }

  /**
   * Replaces current active node with a NOT node
   */
  public void createNotNode() {
    var notNode = TreeNodeFactory.createNotNode();
    updateTree(notNode);
  }

  /**
   * Replaces current active node with an OR node
   */
  public void createOrNode() {
    var orNode = TreeNodeFactory.createOrNode();
    updateTree(orNode);
  }

  /**
   * Replaces current active node with a Subs node
   */
  public void createSubsNode() {
    var subsNode = TreeNodeFactory.createSubsNode();
    updateTree(subsNode);
  }
  /* END REPLAMENT OF ACTIVE NODE WITH OPNODES */

  /* BEGIN REPLACEMENT OF ACTIVE NODE WITH TYPE NODES */

  /**
   * Replaces current active node with an Int Node
   *
   * @param value number to wrap
   */
  public void createIntNode(int value) {
    var intNode = TreeNodeFactory.createIntNode(factory.createSInt(value));
    updateTree(intNode);
  }

  /**
   * Replaces current active node with a Float Node
   *
   * @param value double to wrap
   */
  public void createFloatNode(double value) {
    var floatNode = TreeNodeFactory.createFloatNode(factory.createSFloat(value));
    updateTree(floatNode);
  }

  /**
   * Replaces current active node with a Binary node
   *
   * @param value binary string to wrap
   */
  public void createBinaryNode(String value) {
    var binaryNode = TreeNodeFactory.createBinaryNode(factory.createSBinary(value));
    updateTree(binaryNode);
  }

  /**
   * Replaces current active node with a String node
   *
   * @param value String to wrap
   */
  public void createStringNode(String value) {
    var stringNode = TreeNodeFactory.createStringNode(factory.createSString(value));
    updateTree(stringNode);
  }

  /**
   * Replaces current active node with a boolean node
   *
   * @param value boolean to wrap
   */
  public void createBoolNode(boolean value) {
    var boolNode = TreeNodeFactory.createBoolNode(factory.createSBool(value));
    updateTree(boolNode);
  }
  /* END REPLACEMENT OF ACTIVE NODE WITH TYPE NODES */

  /**
   * Evaluates rootTree
   *
   * @return INative that contains the result of AST evaluation
   */
  public INative evalTree() {
    try {
      if (rootTree.eval() == null) {
        return new SNull();
      }
      return rootTree.eval();
    }
    // Invalid operations
    catch (StackOverflowError | NullPointerException e) {
      return new SNull();
    }
  }

  /**
   * Empties the tree
   */
  public void clearTree() {
    setActiveNode(rootTree);
    updateTree(TreeNodeFactory.createNullNode());
  }
}
