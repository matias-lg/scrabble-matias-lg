package cl.uchile.dcc.scrabble.gui.GUI.Model.TypesWrapper;

import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SInt;

public class TreeInt extends TreeType {

  public TreeInt(SInt value) {
    super(value.toString(), value);
  }
}
