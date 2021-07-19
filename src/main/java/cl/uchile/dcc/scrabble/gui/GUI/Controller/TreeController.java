package cl.uchile.dcc.scrabble.gui.GUI.Controller;

import cl.uchile.dcc.scrabble.gui.AST.Factory.Factory;
import cl.uchile.dcc.scrabble.gui.AST.Nodes.INode;
import cl.uchile.dcc.scrabble.gui.natives.INative;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

/**
 * Controller that App will use, this class will pass and execute all the Scrabble logic
 */
public class TreeController extends Canvas {
  private final Factory factory = new Factory();
  private final Pane canvas;
  private INode AST;

  private TreeItem<String> activeNode;
  private TreeItem<String> rootTree = new TreeItem<>("Abstract Syntax Tree");
  private TreeView<String> rootTreeView = new TreeView<>(rootTree);

  public TreeController(Pane canvas){
    this.canvas = canvas;
    this.activeNode = rootTree;
    rootTree.setExpanded(true);
    // make tree editable

  }

  /**
   * Gets the current active node
   * @return active node of <code>this</code>
   */
  public TreeItem<String> getActiveNode(){
    return activeNode;
  }

  /**
   * Sets the active node from the View to replace it / keep adding children
   * @param newActiveNode node that the user has just clicked
   */
  public void setActiveNode(TreeItem<String> newActiveNode){
    this.activeNode = newActiveNode;
  }


  /**
   * Replaces current active tree node with an Add node
   */
  public void createAddNode(){
    var addNode = new TreeItem<>("+");
    addNode.setExpanded(true);
    // add 2 empty childs
    for (int i = 1; i < 3; i++){
      var emptyNode = new TreeItem<>("Empty node");
      addNode.getChildren().add(emptyNode);
    }
    // replaces current active node if it isnt the main tree
    if (getActiveNode() != rootTree){
      var activeNodeParentsChildren = getActiveNode().getParent().getChildren();
      activeNodeParentsChildren.set(activeNodeParentsChildren.indexOf(getActiveNode()), addNode);
    }
    else{
      rootTree.getChildren().add(addNode);
      setActiveNode(addNode);
    }
    draw();
  }


  public void draw(){
    var newTreeView = new TreeView<>(rootTree);
    // when clicking on a Node it will be set to active
    newTreeView.getSelectionModel()
        .selectedItemProperty()
        .addListener((observable, oldValue, newValue) -> setActiveNode(newValue));
    var rootTreePane = new StackPane();
    rootTreePane.getChildren().add(newTreeView);
    // replace old tree with updated tree
    System.out.println(getActiveNode());
    canvas.getChildren().clear();
    canvas.getChildren().add(rootTreePane);
  }

  public void setAST(){
    AST = factory.getAST();
  }

  public void createAST(){

  }

//  public INative eval(TreeItem<String> root){
//    root.operation( eval(root.getChildren()[0]), eval(root.getChildren()[1]))
//  }
}
