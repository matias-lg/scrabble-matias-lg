package cl.uchile.dcc.scrabble.gui.AST.Constant;

import cl.uchile.dcc.scrabble.gui.AST.Constant.Constant;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SString;

public class StringConstant extends Constant {
  public StringConstant(SString string){
    super(string);
  }

  @Override
  public SString eval(){
    return (SString) constant;
  }
}

