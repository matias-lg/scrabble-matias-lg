package cl.uchile.dcc.scrabble.gui.GUI.Model.TypesWrapper;

import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SString;

public class TreeString extends TreeType {

  public TreeString(SString value) {
    super(value.toString(), value);
  }
}
