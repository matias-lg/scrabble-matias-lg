package cl.uchile.dcc.scrabble.gui.GUI;

import java.io.IOException;
import java.security.cert.PolicyNode;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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
      AnchorPane editorRoot = new AnchorPane();
      root.getChildren().add(editorRoot);

    Scene scene = new Scene(root, 800, 800);
    scene.getStylesheets().add("styles.css");

    stage.setScene(scene);
    stage.show();

    HBox fileRoot = new HBox();
    VBox menu = new VBox();
    menu.prefWidthProperty().bind(scene.widthProperty().multiply(0.15));
    menu.getStyleClass().add("custom-menu");
    menu.setFillWidth(true);

    StackPane titlePanel = new StackPane();
    Text opTitle = new Text("Operations");
    titlePanel.getChildren().add(opTitle);
    titlePanel.getStyleClass().add("operations-title");
    titlePanel.setPrefHeight(25);

    // save the current node
      final Pane[] currentNode = new Pane[1];
      currentNode[0] = root;

    Button addBtn = createMenuButton("Add");
    addBtn.setOnAction(actionEvent -> {
        StackPane addPane = new StackPane();
//        Rectangle body = new Rectangle(350, 350);
//        body.getStyleClass().add("add-pane");
        addPane.getStyleClass().add("add-pane");
        addPane.getChildren().addAll(new Text("Add!"));
        currentNode[0].getChildren().addAll(addPane);
        currentNode[0] = addPane;
    });

    Button subBtn = createMenuButton("Substraction");
    Button divBtn = createMenuButton("Division");
    Button prodBtn = createMenuButton("Product");
    Button andBtn = createMenuButton("And");
    Button orBtn = createMenuButton("Or");
    Button notBtn = createMenuButton("Not");

    StackPane typeTitlePanel = new StackPane();
    Text typeTitle = new Text("Types");
    typeTitlePanel.getChildren().add(typeTitle);
    typeTitlePanel.getStyleClass().add("operations-title");
    typeTitlePanel.setPrefHeight(25);

    Button binaryBtn = createMenuButton("Binary");
    Button boolBtn = createMenuButton("Bool");
    Button floatBtn = createMenuButton("Float");
    Button intBtn = createMenuButton("Int");
    Button strBtn = createMenuButton("String");

    menu.getChildren()
        .addAll(titlePanel, addBtn, subBtn, divBtn, prodBtn, andBtn, orBtn, notBtn, typeTitlePanel,
            intBtn, floatBtn, binaryBtn, boolBtn, strBtn);
    fileRoot.getChildren().add(menu);
    root.getChildren().add(fileRoot);
  }

  private Button createMenuButton(String text) {
    var btn = new Button(text);
    btn.setPrefHeight(35);
    btn.setPrefWidth(150);
    btn.getStyleClass().add("custom-menu-button");
    return btn;
  }

  public static void main(String[] args) {
    launch();
  }

}