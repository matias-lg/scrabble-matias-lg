package cl.uchile.dcc.scrabble.gui.GUI.Controller.AstNodeWrapper.TypesWrapper;

import cl.uchile.dcc.scrabble.gui.GUI.Controller.AstNodeWrapper.AstNodeWrapper;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SBinary;

public class TreeBinary extends AstNodeWrapper {
  public TreeBinary(String binary){
    super("Binary: " + binary, new SBinary(binary));
  }
}
