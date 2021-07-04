package cl.uchile.dcc.scrabble.gui.natives.operations;

import cl.uchile.dcc.scrabble.gui.natives.IInteger;
import cl.uchile.dcc.scrabble.gui.natives.INumber;

public interface IIntegerOperable extends IInteger {

  INumber add(IInteger num);

  INumber subs(IInteger num);

  INumber mult(IInteger num);

  INumber div(IInteger num);
}
