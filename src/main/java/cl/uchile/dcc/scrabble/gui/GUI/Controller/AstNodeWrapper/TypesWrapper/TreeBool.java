package cl.uchile.dcc.scrabble.gui.GUI.Controller.AstNodeWrapper.TypesWrapper;

import cl.uchile.dcc.scrabble.gui.GUI.Controller.AstNodeWrapper.AstNodeWrapper;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SBool;

public class TreeBool extends TreeType {

  public TreeBool(boolean value) {
    super("Boolean: " + value, new SBool(value));
  }
}
