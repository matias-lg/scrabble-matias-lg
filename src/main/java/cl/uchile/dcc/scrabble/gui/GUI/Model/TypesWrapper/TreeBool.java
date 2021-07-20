package cl.uchile.dcc.scrabble.gui.GUI.Model.TypesWrapper;

import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SBool;

public class TreeBool extends TreeType {

  public TreeBool(SBool value) {
    super(value.toString(), value);
  }
}
