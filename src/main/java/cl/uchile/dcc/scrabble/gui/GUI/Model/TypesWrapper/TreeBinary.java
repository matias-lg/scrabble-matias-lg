package cl.uchile.dcc.scrabble.gui.GUI.Model.TypesWrapper;

import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SBinary;

public class TreeBinary extends TreeType {

  public TreeBinary(SBinary binary) {
    super(binary.toString(), binary);
  }
}
