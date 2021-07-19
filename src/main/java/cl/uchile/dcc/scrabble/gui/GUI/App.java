package cl.uchile.dcc.scrabble.gui.GUI;

import cl.uchile.dcc.scrabble.gui.GUI.Controller.TreeController;
import cl.uchile.dcc.scrabble.gui.GUI.Controller.TreeWrapperController;
import java.io.IOException;
import java.util.Stack;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

  @Override
  public void start(Stage stage) throws IOException {
    final StackPane root = new StackPane();
    Scene scene = new Scene(root, 800, 800);
    scene.getStylesheets().add("styles.css");
    stage.setScene(scene);
    stage.show();
    stage.setTitle("Scrabble");
    // side menu
    HBox fileRoot = new HBox();
    VBox menu = new VBox();
    menu.prefWidthProperty().bind(scene.widthProperty().multiply(0.15));
    menu.getStyleClass().add("custom-menu");
    menu.setFillWidth(true);
    // remaining space, canvas for tree
    VBox canvas = new VBox();
    canvas.prefWidthProperty().bind(scene.widthProperty().multiply(0.9));
    // connect controller to canvas
    TreeWrapperController controller = new TreeWrapperController(canvas);
    // operations title tile
    StackPane titlePanel = new StackPane();
    Text opTitle = new Text("Operations");
    titlePanel.getChildren().add(opTitle);
    titlePanel.getStyleClass().add("operations-title");
    titlePanel.setPrefHeight(25);
    // create operation buttons and delegate click action to controller
    Button addBtn = createMenuButton("Add");
    addBtn.setOnAction(actionEvent -> controller.createAddNode());

    Button subBtn = createMenuButton("Substraction");
    subBtn.setOnAction(actionEvent -> controller.createSubsNode());

    Button divBtn = createMenuButton("Division");
    divBtn.setOnAction(actionEvent -> controller.createDivNode());

    Button prodBtn = createMenuButton("Product");
    prodBtn.setOnAction(actionEvent -> controller.createMultNode());

    Button andBtn = createMenuButton("And");
    andBtn.setOnAction(actionEvent -> controller.createAndNode());

    Button orBtn = createMenuButton("Or");
    orBtn.setOnAction(actionEvent -> controller.createOrNode());

    Button notBtn = createMenuButton("Not");
    notBtn.setOnAction(actionEvent -> controller.createNotNode());

    // types title tile
    StackPane typeTitlePanel = new StackPane();
    Text typeTitle = new Text("Types");
    typeTitlePanel.getChildren().add(typeTitle);
    typeTitlePanel.getStyleClass().add("operations-title");
    typeTitlePanel.setPrefHeight(25);
    // types buttons
    Button binaryBtn = createMenuButton("Binary");
    Button boolBtn = createMenuButton("Bool");
    Button floatBtn = createMenuButton("Float");
    Button intBtn = createMenuButton("Int");
    Button strBtn = createMenuButton("String");
    // add everything to menu
    menu.getChildren()
        .addAll(titlePanel, addBtn, subBtn, divBtn, prodBtn, andBtn, orBtn, notBtn, typeTitlePanel,
            intBtn, floatBtn, binaryBtn, boolBtn, strBtn);
    fileRoot.getChildren().addAll(menu, canvas);
    root.getChildren().add(fileRoot);
  }

  private Button createMenuButton(String text) {
    var btn = new Button(text);
    btn.setPrefHeight(35);
    btn.setPrefWidth(150);
    btn.getStyleClass().add("custom-menu-button");
    btn.setOnAction(actionEvent -> {
      System.out.println("hola");
    });
    return btn;
  }

  public static void main(String[] args) {
    launch();
  }

}