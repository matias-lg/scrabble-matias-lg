package cl.uchile.dcc.scrabble.gui.GUI.Controller;

import cl.uchile.dcc.scrabble.gui.AST.Factory.Factory;
import cl.uchile.dcc.scrabble.gui.AST.Nodes.INode;
import cl.uchile.dcc.scrabble.gui.AST.Nodes.OpNode;
import cl.uchile.dcc.scrabble.gui.GUI.Controller.AstNodeWrapper.AstNodeWrapper;
import cl.uchile.dcc.scrabble.gui.natives.INative;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.TreeView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 * Controller that App will use, this class will pass and execute all the Scrabble logic
 */
public class TreeController extends Canvas {

  private final Pane canvas;
  private AstNodeWrapper activeNode;
  private AstNodeWrapper rootTree;
  private TreeView<String> rootTreeView = new TreeView<>(rootTree);

  public TreeController(Pane canvas) {
    this.canvas = canvas;
    this.activeNode = rootTree;
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
      if (parent.getNode() instanceof OpNode){
        OpNode parentNode = (OpNode) parent.getNode();
        if(position == 0){
        parentNode.setLeftChild(newNode.getNode());}
        else {
        parentNode.setRightChild(newNode.getNode());}
      }
      else{
        parent.setNode(newNode.getNode());
      }
      // replace active node with this new add node
      var activeNodeParentsChildren = getActiveNode().getParent().getChildren();
      activeNodeParentsChildren.set(activeNodeParentsChildren.indexOf(getActiveNode()), newNode);
    }

    draw();
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
   * @param value number to wrap
   */
  public void createIntNode(int value){
    var intNode = TreeNodeFactory.createIntNode(value);
    updateTree(intNode);
  }

  /**
   * Replaces current active node with a Float Node
   * @param value double to wrap
   */
  public void createFloatNode(double value){
    var floatNode = TreeNodeFactory.createFloatNode(value);
    updateTree(floatNode);
  }

  /**
   * Replaces current active node with a float node
   * @param value binary string to wrap
   */
  public void createBinaryNode(String value){
    var binaryNode = TreeNodeFactory.createBinaryNode(value);
    updateTree(binaryNode);
  }

  /**
   * Replaces current active node with a String node
   * @param value String to wrap
   */
  public void createStringNode(String value){
    var stringNode = TreeNodeFactory.createStringNode(value);
    updateTree(stringNode);
  }

  /**
   * Replaces current active node with a boolean node
   * @param value boolean to wrap
   */
  public void createBoolNode(boolean value){
    var boolNode = TreeNodeFactory.createBoolNode(value);
    updateTree(boolNode);
  }


  /* END REPLACEMENT OF ACTIVE NODE WITH TYPE NODES */


  public void draw() {
    var newTreeView = new TreeView<>(rootTree);
    // when clicking on a Node it will be set to active
    newTreeView.getSelectionModel()
        .selectedItemProperty()
        .addListener((observable, oldValue, newValue) -> setActiveNode(
            (AstNodeWrapper) newValue)); // our tree consists only in nodewrappers, safe cast
    var rootTreePane = new StackPane();
    rootTreePane.getChildren().add(newTreeView);
    // replace old tree with updated tree
    System.out.println(getActiveNode());
    canvas.getChildren().clear();
    canvas.getChildren().add(rootTreePane);
  }

  public INative evalTree(){
    return rootTree.getNode().eval();
  }

  public AstNodeWrapper getRootTree() {
    return rootTree;
  }

  //  public INative eval(TreeItem<String> root){
//    root.operation( eval(root.getChildren()[0]), eval(root.getChildren()[1]))
//  }
}
