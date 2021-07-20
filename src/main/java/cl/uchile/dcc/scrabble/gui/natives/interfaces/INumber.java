package cl.uchile.dcc.scrabble.gui.natives.interfaces;

import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SFloat;
import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SInt;

/**
 * This interface implements every operation which a native Scrabble number should be able to do
 */
public interface INumber extends INative {

  /* Transformations */
  SFloat toSFloat();
  /* Operations */


  /*Methods for Double Dispatch implementation of above methods */
  INumber sumWithInt(SInt num);

  INumber sumWithFloat(SFloat num);

  INumber subsWithInt(SInt num);

  INumber subsWithFloat(SFloat num);

  INumber multWithInt(SInt num);

  INumber multWithFloat(SFloat num);

  INumber divWithInt(SInt num);

  INumber divWithFloat(SFloat num);
}
