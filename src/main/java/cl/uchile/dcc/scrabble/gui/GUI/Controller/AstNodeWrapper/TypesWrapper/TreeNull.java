package cl.uchile.dcc.scrabble.gui.GUI.Controller.AstNodeWrapper.TypesWrapper;

import cl.uchile.dcc.scrabble.gui.GUI.Controller.AstNodeWrapper.AstNodeWrapper;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SNull;

public class TreeNull extends TreeType {

  public TreeNull() {
    super("Empty node", new SNull());
  }
}
