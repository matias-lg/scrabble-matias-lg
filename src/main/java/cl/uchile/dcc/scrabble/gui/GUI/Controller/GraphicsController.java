package cl.uchile.dcc.scrabble.gui.GUI.Controller;

import cl.uchile.dcc.scrabble.gui.GUI.Model.AstNodeWrapper;
import cl.uchile.dcc.scrabble.gui.natives.interfaces.INative;
import javafx.scene.control.TreeView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 * Uses the TreeController to update the view
 */
public class GraphicsController {

  private final Pane canvas;
  private final TreeController controller = new TreeController();

  public GraphicsController(Pane canvas) {
    this.canvas = canvas;
  }


  /**
   * Replaces current active tree node with an Add node and updates the View
   */
  public void createAddNode() {
    controller.createAddNode();
    draw();
  }

  /**
   * Replaces current active node with an And node and updates the View
   */
  public void createSubsNode() {
    controller.createSubsNode();
    draw();
  }

  /**
   * Replaces current active node with a Div node and updates the View
   */
  public void createDivNode() {
    controller.createDivNode();
    draw();
  }

  /**
   * Replaces current active node with a mult node and updates the View
   */
  public void createMultNode() {
    controller.createMultNode();
    draw();
  }

  /**
   * Replaces current active node with a NOT node and updates the View
   */
  public void createAndNode() {
    controller.createAndNode();
    draw();
  }

  /**
   * Replaces current active node with an OR node and updates the View
   */
  public void createOrNode() {
    controller.createOrNode();
    draw();
  }

  /**
   * Replaces current active node with a Subs node and updates the View
   */
  public void createNotNode() {
    controller.createNotNode();
    draw();
  }

  /**
   * Replaces current active node with a float node and updates the View
   *
   * @param inputValue binary string to wrap
   */
  public void createBinaryNode(String inputValue) {
    controller.createBinaryNode(inputValue);
    draw();
  }


  /**
   * Replaces current active node with a Bool node and updates the View
   *
   * @param inputValue boolean value to wrap
   */
  public void createBoolNode(boolean inputValue) {
    controller.createBoolNode(inputValue);
    draw();
  }

  /**
   * Replaces current active node with a float node and updates the View
   *
   * @param inputValue binary string to wrap
   */
  public void createFloatNode(double inputValue) {
    controller.createFloatNode(inputValue);
    draw();
  }

  /**
   * Replaces current active node with an integer node and updates the View
   *
   * @param inputValue integer number to wrap
   */
  public void createIntNode(int inputValue) {
    controller.createIntNode(inputValue);
    draw();
  }

  /**
   * Replaces current active node with a String node and updates the View
   *
   * @param inputValue string to wrap
   */
  public void createStringNode(String inputValue) {
    controller.createStringNode(inputValue);
    draw();
  }

  /**
   * Helper method that updates the view with the updated tree from TreeController
   */
  private void draw() {
    var rootTree = controller.getRootTree();
    var newTreeView = new TreeView<>(rootTree);
    // when clicking on a Node it will be set to active
    newTreeView.getSelectionModel()
        .selectedItemProperty()
        .addListener((observable, oldValue, newValue) -> controller.setActiveNode(
            (AstNodeWrapper) newValue)); // our tree consists only in nodewrappers => safe cast
    var rootTreePane = new StackPane();
    rootTreePane.getChildren().add(newTreeView);
    // replace old tree with updated tree
    canvas.getChildren().clear();
    canvas.getChildren().add(rootTreePane);
  }

  /**
   * Evaluates stored tree in TreeController
   *
   * @return INative which is the result of the evaluation
   */
  public INative evalTree() {
    return controller.evalTree();
  }

  /**
   * Sets the whole Tree to Null
   */
  public void clearTree() {
    controller.clearTree();
  }
}
