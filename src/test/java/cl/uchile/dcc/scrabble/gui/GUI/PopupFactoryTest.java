package cl.uchile.dcc.scrabble.gui.GUI;

import static org.junit.jupiter.api.Assertions.*;

import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.HBox;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PopupFactoryTest {
  private final TextInputDialog expectedIntDialog = new TextInputDialog();
  private final TextInputDialog expectedFloatDialog = new TextInputDialog();
  private final TextInputDialog expectedBinaryDialog = new TextInputDialog();
  private final TextInputDialog expectedBoolDialog = new TextInputDialog();
  private final TextInputDialog expectedStringDialog = new TextInputDialog();

  @BeforeEach
  void setUp(){
    expectedIntDialog.setHeaderText("Enter integer number: ");
    expectedFloatDialog.setHeaderText("Enter Float number: ");
    expectedBinaryDialog.setHeaderText("Enter binary number as a string: ");
    expectedBoolDialog.setHeaderText("Enter bool (true/false): ");
    expectedBoolDialog.setHeaderText("Enter String: ");
  }
  @Test
  void createIntPopUp() {
    assertEquals(expectedIntDialog, PopupFactory.createIntPopUp());
  }

  @Test
  void createFloatPopUp() {
    assertEquals(expectedFloatDialog, PopupFactory.createFloatPopUp());
  }

  @Test
  void createBinaryPopUp() {
    assertEquals(expectedBinaryDialog, PopupFactory.createBinaryPopUp());
  }

  @Test
  void createBoolPopUp() {
    assertEquals(expectedBoolDialog, PopupFactory.createBoolPopUp());
  }

  @Test
  void createStringPopUp() {
    assertEquals(expectedStringDialog, PopupFactory.createStringPopUp());
  }
}