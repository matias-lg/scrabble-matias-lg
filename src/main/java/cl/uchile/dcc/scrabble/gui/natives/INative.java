package cl.uchile.dcc.scrabble.gui.natives;

import cl.uchile.dcc.scrabble.gui.AST.Nodes.INode;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SString;

/**
 * This interface is implemented by every Native Scrabble Class: String, Number and Boolean
 */
public interface INative extends INode {

  /**
   * Returns the stored value as a String
   *
   * @return Stored value as a String
   */
  String toString();

  /**
   * Converts a native Scrabble type to a SString
   *
   * @return SString which encapsulates a String of the value from caller INative
   */
  INative toSString();

  /**
   * Result of adding a String with an Inative
   *
   * @param str String to sum with
   */
  SString sumWithString(SString str);
}
