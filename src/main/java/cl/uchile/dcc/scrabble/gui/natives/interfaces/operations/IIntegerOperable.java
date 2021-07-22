package cl.uchile.dcc.scrabble.gui.natives.interfaces.operations;

import cl.uchile.dcc.scrabble.gui.natives.interfaces.IInteger;
import cl.uchile.dcc.scrabble.gui.natives.interfaces.INumber;

public interface IIntegerOperable extends IInteger {

  INumber add(IInteger num);

  INumber subs(IInteger num);

  INumber mult(IInteger num);

  INumber div(IInteger num);
}
