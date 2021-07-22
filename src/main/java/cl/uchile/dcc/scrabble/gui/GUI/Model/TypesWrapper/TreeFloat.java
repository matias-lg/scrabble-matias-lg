package cl.uchile.dcc.scrabble.gui.GUI.Model.TypesWrapper;

import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SFloat;

public class TreeFloat extends TreeType {

  public TreeFloat(SFloat value) {
    super(value.toString(), value);
  }
}
