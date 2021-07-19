package cl.uchile.dcc.scrabble.gui.GUI.Controller.AstNodeWrapper.TypesWrapper;

import cl.uchile.dcc.scrabble.gui.GUI.Controller.AstNodeWrapper.AstNodeWrapper;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SString;

public class TreeString extends AstNodeWrapper {
  public TreeString(String value){
    super("String: "+"'"+value+"'", new SString(value));
  }
}
