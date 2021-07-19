package cl.uchile.dcc.scrabble.gui.GUI.Controller.AstNodeWrapper.TypesWrapper;

import cl.uchile.dcc.scrabble.gui.GUI.Controller.AstNodeWrapper.AstNodeWrapper;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SFloat;

public class TreeFloat extends AstNodeWrapper {
  public TreeFloat(double value){
    super("Float: " + value, new SFloat(value));
  }
}
