package cl.uchile.dcc.scrabble.gui.GUI;

import javafx.scene.control.TextInputDialog;

public class PopupFactory {

  /**
   * Helper method to create input dialogs with custom header text
   * @param text custom text for the header
   * @return text input value with header text
   */
  private static TextInputDialog createGenericInputDialog(String text) {
    var td = new TextInputDialog();
    td.setHeaderText(text);
    return td;
  }

  /**
   * Creates a text input dialog for integer button
   * @return Popup for inputting value
   */
  public static TextInputDialog createIntPopUp(){
    return createGenericInputDialog("Enter integer number: ");
  }

  /**
   * Creates a text input for the float button
   * @return Popup for inputting value
   */
  public static TextInputDialog createFloatPopUp(){
    return createGenericInputDialog("Enter Float number: ");
  }

  /**
   * Creates a text input for the Binary button
   * @return Popup for inputting value
   */
  public static TextInputDialog createBinaryPopUp(){
    return createGenericInputDialog("Enter binary number as a string: ");
  }

  /**
   * Creates a text input for the Boolean button
   * @return Popup for inputting value
   */
  public static TextInputDialog createBoolPopUp(){
    return createGenericInputDialog("Enter bool (true/false): ");
  }

  /**
   * Creates a text input for the String button
   * @return Popup for inputting value
   */
  public static TextInputDialog createStringPopUp(){
    return createGenericInputDialog("Enter String: ");
  }
}
