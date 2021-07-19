package cl.uchile.dcc.scrabble.gui.GUI.Controller.AstNodeWrapper.TypesWrapper;

import cl.uchile.dcc.scrabble.gui.GUI.Controller.AstNodeWrapper.AstNodeWrapper;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SInt;

public class TreeInt extends AstNodeWrapper {
  public TreeInt(int value){
    super("Int: "+ value,new SInt(value));
  }
}
