package cl.uchile.dcc.scrabble.gui.nativeClasses;

import cl.uchile.dcc.scrabble.gui.natives.AbstractNative;
import cl.uchile.dcc.scrabble.gui.natives.IInteger;
import cl.uchile.dcc.scrabble.gui.natives.INumber;
import cl.uchile.dcc.scrabble.gui.natives.operations.INumberOperable;
import java.util.Objects;

/**
 * Native Scrabble int, stores a Java int
 */
public class SInt extends AbstractNative implements IInteger, INumberOperable {

  private int value;

  /**
   * Native Scrabble int
   *
   * @param value int to store
   */
  public SInt(int value) {
    this.value = value;
  }

  /**
   * @return encapsulated int
   */
  public int getValue() {
    return this.value;
  }

  /**
   * Converts the stored int to a String
   *
   * @return String from the int stored in value
   */
  @Override
  public String toString() {
    return Integer.toString(getValue());
  }

  /**
   * Compares two SInt
   *
   * @param o Object to compare with
   * @return true if its compared with a SInt which stores the same int
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof SInt)) {
      return false;
    }
    SInt that = (SInt) o;
    return getValue() == that.getValue();
  }

  /**
   * Generates Hash from a SInt using its stored value
   *
   * @return hash created from the stored int
   */
  @Override
  public int hashCode() {
    return Objects.hash(getValue());
  }

  /**
   * Transforms a SInt to a SString which stores the current int as a String
   *
   * @return SString which stores the current int as a String
   */
  @Override
  public SString toSString() {
    String strValue = Integer.toString(this.getValue());
    return new SString(strValue);
  }

  /**
   * Creates new SString containing sum of string and saved value as string
   *
   * @param str SString to sum with
   * @return new SString containing sum of strings
   */
  @Override
  public SString sumWithString(SString str) {
    return new SString(str.getValue() + this);
  }

  /**
   * Transforms a SInt to SFloat storing the current saved int casted as a double
   *
   * @return SFloat which stores the current int as a double
   */
  @Override
  public SFloat toSFloat() {
    return new SFloat(this.getValue());
  }

  /**
   * Creates a SBinary which is equivalent to the current SInt
   *
   * @return new SBinary storing current int as a String of its binary representation
   */
  @Override
  public SBinary toSBinary() {
    var binary = new StringBuilder();
    int abs = Math.abs(this.value);
    do {
      binary.insert(0, (abs % 2) == 1 ? "1" : "0");
      abs /= 2;
    } while (abs > 0);
    if (this.value < 0) {
      /* Fill with 0s */
      String zeros = "0".repeat(Integer.SIZE - binary.length());
      binary.insert(0, zeros);
      /* Set first byte to 1, reverse binary */
      for (int i = Integer.SIZE - 1; i > 0; i--) {
        if (binary.charAt(i) == '0') {
          binary.setCharAt(i, '1');
        } else {
          binary.setCharAt(i, '0');
        }
      }
      binary.setCharAt(0, '1');
      /* Now sum one to the binary */
      int pos = Integer.SIZE - 1;
      while (binary.charAt(pos) == '1') {
        if (pos == 0) {
          break;
        }
        binary.setCharAt(pos, '0');
        pos--;
      }
      binary.setCharAt(pos, '1');
    }
    return new SBinary(binary.toString());
  }

  /**
   * Adds a SInt with other INumber type
   *
   * @param num number to add
   * @return sum of two numbers (SInt when possible)
   */
  public INumber add(INumber num) {
    return num.sumWithInt(this);
  }

  /**
   * Substracts a SInt with other INumber type
   *
   * @param num number to substract
   * @return substraction of two numbers: result of this - num (SInt when possible)
   */
  public INumber subs(INumber num) {
    return num.subsWithInt(this);
  }

  /**
   * Multiplies a SInt with other INumber type
   *
   * @param num number to multiply with
   * @return Product of two numbers: result of this * num (SInt when possible)
   */
  public INumber mult(INumber num) {
    return num.multWithInt(this);
  }

  /**
   * Divides a SInt with other INumber type
   *
   * @param num number to divide with
   * @return Division of two numbers: result of this / num (SInt when possible)
   */
  public INumber div(INumber num) {
    return num.divWithInt(this);
  }

  /**
   * Addition of two Sint
   *
   * @param num SInt to sum with
   * @return Result of num + this
   */
  @Override
  public INumber sumWithInt(SInt num) {
    int a = num.getValue();
    int b = this.getValue();
    return new SInt(a + b);
  }

  /**
   * Addition of a SBinary with a SInt
   *
   * @param num SBinary to sum with
   * @return Result of num + this (as a SBinary)
   */
  @Override
  public IInteger sumWithBinary(SBinary num) {
    int a = num.toSInt().getValue();
    int b = getValue();
    var result = new SInt(a + b);
    return result.toSBinary();
  }

  /**
   * Substraction of a SInt with a SInt
   *
   * @param num SBinary to substract with
   * @return Result of num - this (as a SInt)
   */
  @Override
  public INumber subsWithInt(SInt num) {
    int a = num.getValue();
    int b = getValue();
    return new SInt(a - b);
  }

  /**
   * Substraction of a SBinary with a SInt
   *
   * @param num SBinary to substract with
   * @return Result of num - this (as a SBinary)
   */
  @Override
  public IInteger subsWithBinary(SBinary num) {
    int a = num.toSInt().getValue();
    int b = getValue();
    var result = new SInt(a - b);
    return result.toSBinary();
  }

  /**
   * Multiplication of a SInt with a SInt
   *
   * @param num SInt to multiply with
   * @return Result of num * this (as a SInt)
   */
  @Override
  public INumber multWithInt(SInt num) {
    int a = num.getValue();
    int b = getValue();
    return new SInt(a * b);
  }

  /**
   * Multiplication of a SBinary with a SInt
   *
   * @param num SBinary to multiply with
   * @return Result of num * this (as a SBinary)
   */
  @Override
  public IInteger multWithBinary(SBinary num) {
    int a = num.toSInt().getValue();
    int b = getValue();
    var result = new SInt(a * b);
    return result.toSBinary();
  }

  /**
   * Division of a SInt with a SInt
   *
   * @param num SInt to divide from
   * @return Result of num / this (as a SInt)
   */
  @Override
  public SInt divWithInt(SInt num) {
    int a = num.getValue();
    int b = getValue();
    return new SInt(a / b);
  }

  /**
   * Division of a SBinary with a SInt
   *
   * @param num SBinary to divide from
   * @return Result of num / this (as a SBinary)
   */
  @Override
  public IInteger divWithBinary(SBinary num) {
    int a = num.toSInt().getValue();
    int b = getValue();
    var result = new SInt(a / b);
    return result.toSBinary();
  }


  /**
   * Creates a copy of a SInt
   *
   * @return new SInt storing the same value
   */
  @Override
  public SInt toSInt() {
    return new SInt(this.getValue());
  }

  /**
   * Sum of a SFloat and SInt
   *
   * @param num SFloat to sum with
   * @return Result of this + num (As a SFloat)
   */
  public INumber sumWithFloat(SFloat num) {
    double a = num.getValue();
    double b = getValue();
    return new SFloat(a + b);
  }

  /**
   * Substraction of a SFloat and SInt
   *
   * @param num SFloat to substract from
   * @return Result of num - this (As a SFloat)
   */
  public INumber subsWithFloat(SFloat num) {
    double a = num.getValue();
    double b = getValue();
    return new SFloat(a - b);
  }

  /**
   * Division of a SFloat and SInt
   *
   * @param num SFloat to divide from
   * @return Result of num / this (As a SFloat)
   */
  public INumber divWithFloat(SFloat num) {
    double a = num.getValue();
    double b = getValue();
    return new SFloat(a / b);
  }

  /**
   * Multiplication of a SFloat and SInt
   *
   * @param num SFloat to multiply with
   * @return Result of num * this (As a SFloat)
   */
  public INumber multWithFloat(SFloat num) {
    double a = num.getValue();
    double b = getValue();
    return new SFloat(a * b);
  }
}
