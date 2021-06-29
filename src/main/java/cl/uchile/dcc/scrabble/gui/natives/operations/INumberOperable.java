package cl.uchile.dcc.scrabble.gui.natives.operations;

import cl.uchile.dcc.scrabble.gui.natives.INumber;

public interface INumberOperable extends INumber {
  INumber add(INumber num);
  INumber subs(INumber num);
  INumber mult(INumber num);
  INumber div(INumber num);
}
