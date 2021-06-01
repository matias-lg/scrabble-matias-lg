package cl.uchile.dcc.scrabble.gui.nativeClasses;

import cl.uchile.dcc.scrabble.gui.natives.INative;
import cl.uchile.dcc.scrabble.gui.natives.Ilogical;
import java.util.Objects;

/**
 * Native Scrabble Boolean type
 */
public class SBool implements INative, Ilogical {

  boolean value;

  /**
   * Stores a Java bool
   *
   * @param value bool to store
   */
  public SBool(boolean value) {
    this.value = value;
  }

  /**
   * Gets stored bool
   *
   * @return bool stored
   */
  public boolean getValue() {
    return this.value;
  }

  /**
   * Gets the stored bool as a String
   *
   * @return String "true" if bool: true is stored. "false" if storing a false bool
   */
  @Override
  public String toString() {
    return Boolean.toString(value);
  }

  /**
   * Compare two SBool by their stored bools
   *
   * @param o Object to compare, if its a SBool it should store the same value
   * @return true if both store the same bool
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof SBool)) {
      return false;
    }
    SBool that = (SBool) o;
    return value == that.value;
  }

  /**
   * Representative Hash of a SBool
   *
   * @return hash created using the stored bool
   */
  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  /**
   * Creates a new SString which contains the stored bool as a String
   *
   * @return new SString storing a bool as a String "true" or "false"
   */
  public SString toSString() {
    return new SString(toString());
  }

  /**
   * Creates new SString containing sum of string and saved value as string
   * @param str SString to sum with
   * @return new SString containing sum of strings
   */
  @Override
  public SString sumWithString(SString str) {
    return new SString(str.getValue() + this);
  }

  /**
   * Creates a new SBool containing the negation of current SBool
   * @return new SBool containing the negation of current SBool
   */
  @Override
  public Ilogical not() {
    return new SBool(!getValue());
  }

  /**
   * Logical AND applied byte-per-byte to a Ilogical
   *
   * @param P ILogical to operate with
   * @return Ilogical containing result of AND operation (can be SBool or SBinary)
   */
  @Override
  public Ilogical and(Ilogical P) {
    return P.andWithBool(this);
  }

  /**
   * Logical OR applied byte-per-byte to a Ilogical
   *
   * @param P ILogical to operate with
   * @return Ilogical containing result of OR operation (can be SBool or SBinary)
   */
  @Override
  public Ilogical or(Ilogical P) {
    return P.orWithBool(this);
  }

  /**
   * Result of AND operation between SBool and SBinary
   *
   * @param binary binary number to operate with
   * @return new SBinary containing result of AND operation applied byte-per-byte
   */
  @Override
  public Ilogical andWithBinary(SBinary binary) {
    /* use SBinary implementation */
    return binary.andWithBool(this);
  }

  /**
   * Result of AND operation between two SBool
   *
   * @param bool bool to operate with
   * @return this AND bool
   */
  @Override
  public Ilogical andWithBool(SBool bool) {
    return new SBool(getValue() && bool.getValue());
  }

  /**
   * Result of OR operation between SBool and SBinary
   *
   * @param binary binary number to operate with
   * @return new SBinary containing result of OR operation applied byte-per-byte
   */
  @Override
  public Ilogical orWithBinary(SBinary binary) {
    /* use SBinary implementation */
    return binary.orWithBool(this);
  }

  /**
   * Result of OR operation between two SBool
   *
   * @param bool bool to operate with
   * @return this OR bool
   */
  @Override
  public Ilogical orWithBool(SBool bool) {
    return new SBool(getValue() || bool.getValue());
  }
}
