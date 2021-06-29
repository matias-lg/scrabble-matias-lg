package cl.uchile.dcc.scrabble.gui.AST.Constant;

import cl.uchile.dcc.scrabble.gui.AST.INode;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SString;
import cl.uchile.dcc.scrabble.gui.natives.INative;

public class Constant implements INode {
  protected INative constant;
  public Constant(INative iNative) {
    this.constant = iNative;
  }

  @Override
  public INative eval() {
    return constant;
  }
}
