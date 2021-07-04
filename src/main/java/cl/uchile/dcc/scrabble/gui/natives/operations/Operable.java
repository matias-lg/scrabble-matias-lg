package cl.uchile.dcc.scrabble.gui.natives.operations;

import cl.uchile.dcc.scrabble.gui.natives.INative;

public interface Operable {

  INative add(INative right);

  INative subs(INative right);

  INative div(INative right);

  INative mult(INative right);

}
