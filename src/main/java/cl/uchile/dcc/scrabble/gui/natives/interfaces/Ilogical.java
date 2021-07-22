package cl.uchile.dcc.scrabble.gui.natives.interfaces;

import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SBinary;
import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SBool;

public interface Ilogical extends INative {

  Ilogical not();

  Ilogical and(Ilogical P);

  Ilogical or(Ilogical P);

  Ilogical andWithBinary(SBinary binary);

  Ilogical andWithBool(SBool bool);

  Ilogical orWithBinary(SBinary binary);

  Ilogical orWithBool(SBool bool);
}
