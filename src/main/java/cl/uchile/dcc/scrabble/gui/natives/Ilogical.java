package cl.uchile.dcc.scrabble.gui.natives;

import cl.uchile.dcc.scrabble.gui.nativeClasses.SBinary;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SBool;

public interface Ilogical extends INative {

  Ilogical not();

  Ilogical and(Ilogical P);

  Ilogical or(Ilogical P);

  Ilogical andWithBinary(SBinary binary);

  Ilogical andWithBool(SBool bool);

  Ilogical orWithBinary(SBinary binary);

  Ilogical orWithBool(SBool bool);
}
