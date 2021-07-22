package cl.uchile.dcc.scrabble.gui.GUI.Model.TypesWrapper;

import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SNull;

public class TreeNull extends TreeType {

  public TreeNull() {
    super("Empty node", new SNull());
  }
}
