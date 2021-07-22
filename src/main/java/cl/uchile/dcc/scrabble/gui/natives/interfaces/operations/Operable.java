package cl.uchile.dcc.scrabble.gui.natives.interfaces.operations;

import cl.uchile.dcc.scrabble.gui.natives.interfaces.INative;

public interface Operable {

  INative add(INative right);

  INative subs(INative right);

  INative div(INative right);

  INative mult(INative right);

}
