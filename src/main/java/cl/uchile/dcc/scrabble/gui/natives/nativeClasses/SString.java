package cl.uchile.dcc.scrabble.gui.natives.nativeClasses;

import cl.uchile.dcc.scrabble.gui.natives.interfaces.AbstractNative;
import cl.uchile.dcc.scrabble.gui.natives.interfaces.INative;
import java.util.Objects;

/**
 * Native Scrabble String, stores a Java String
 */
public class SString extends AbstractNative implements INative {

  private String value;

  /**
   * Stores a String
   *
   * @param str String to store in the object
   */
  public SString(String str) {
    this.value = str;
  }

  /**
   * Returns stored string as a string
   *
   * @return string contained in the class
   */
  @Override
  public String toString() {
    return value;
  }

  /**
   * Gets the stored String
   *
   * @return String stored in the SString
   */
  public String getValue() {
    return value;
  }

  /**
   * Compares two SString by their stored Strings
   *
   * @param o Object to compare with
   * @return true if both are SString and store the same String
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof SString)) {
      return false;
    }
    SString that = (SString) o;
    return getValue().equals(that.getValue());
  }

  /**
   * Creates a hash from a SString instance
   *
   * @return Representative hash of a SString created from its stored String
   */
  @Override
  public int hashCode() {
    return Objects.hash(getValue());
  }

  /**
   * Creates a copy of a SString
   *
   * @return new SString storing the same String
   */
  public SString toSString() {
    return new SString(this.value);
  }

  /**
   * Adds any other INative type by their toString method
   *
   * @param nat INative to sum with
   * @return new SString containing sum of strings
   */
  public SString add(INative nat) {
    return nat.sumWithString(this);
  }

  /**
   * Creates new SString containing sum of two strings
   *
   * @param str SString to sum with
   * @return new SString containing sum of strings
   */
  @Override
  public SString sumWithString(SString str) {
    return new SString(str.getValue() + getValue());
  }
}