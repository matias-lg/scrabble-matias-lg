package cl.uchile.dcc.scrabble.gui.natives.nativeClasses;


import cl.uchile.dcc.scrabble.gui.natives.interfaces.AbstractNative;
import cl.uchile.dcc.scrabble.gui.natives.interfaces.IInteger;
import cl.uchile.dcc.scrabble.gui.natives.interfaces.INumber;
import cl.uchile.dcc.scrabble.gui.natives.interfaces.Ilogical;
import cl.uchile.dcc.scrabble.gui.natives.interfaces.operations.IIntegerOperable;
import java.util.Objects;

/**
 * Native Scrabble Binary
 */
public class SBinary extends AbstractNative implements IIntegerOperable, Ilogical {

  private String value;

  /**
   * Stores a string which represents a binary number, ej: "0101010101"
   *
   * @param value String of only "1"s and "0"s
   */
  public SBinary(String value) {
    this.value = value;
  }

  /**
   * Gets the stored binary as a String
   *
   * @return String of the stored binary
   */
  public String getValue() {
    return value;
  }

  /**
   * Gets the stored binary as a string
   *
   * @return String of the stored binary
   */
  public String toString() {
    return this.value;
  }

  /**
   * Compare two SBinary by their encapsulated String's numerical value
   *
   * @param o Object to compare
   * @return true if both are SBinary and their stored Strings represent the same value, else false
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof SBinary)) {
      return false;
    }
    SBinary that = (SBinary) o;
    /* compare binary Strings as int */
    return Objects.equals(toSInt(), that.toSInt());
  }

  /**
   * Hash that represents the object, created using the stored String's value as int
   *
   * @return hash of stored binary String
   */
  @Override
  public int hashCode() {
    return Objects.hash(toSInt());
  }

  /**
   * Creates a new SString that stores the binary contained in *this*
   *
   * @return new SString that stores the currently stored binary String
   */
  public SString toSString() {
    return new SString(this.value);
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
   * Creates a copy of a SBinary
   *
   * @return new SBinary that stores the same value
   */
  @Override
  public SBinary toSBinary() {
    return new SBinary(this.value);
  }

  /**
   * Creates a SInt storing object's binary String as an int
   *
   * @return SInt storing binary String's value
   */
  @Override
  public SInt toSInt() {
    /* Fill String with zeros or ones to get a 32 byte representation */
    String ones = "1".repeat(Integer.SIZE - value.length());
    String zeros = "0".repeat(Integer.SIZE - value.length());
    String binary;
    binary = zeros + value;
    int result = 0;
    if (binary.charAt(0) == '0') {
      // positive int
      for (int i = binary.length() - 1, j = 0; i > 0; i--, j++) {
        result += (int) Math.pow(2, j) * Character.getNumericValue(binary.charAt(i));
      }
    } else {
      result +=
          -Character.getNumericValue(binary.charAt(0)) * (int) Math.pow(2, binary.length() - 1) - 1;
      for (int i = binary.length() - 1, j = 0; i > 0; i--, j++) {
        result += (int) Math.pow(2, j) * Character.getNumericValue(binary.charAt(i));
      }

    }
    return new SInt(result);
  }

  /**
   * Creates a SFloat storing object's binary String as an int
   *
   * @return SFloat storing binary String's value as a double
   */
  public SFloat toSFloat() {
    return this.toSInt().toSFloat();
  }

  /**
   * Adds a SBinary with other INumber type
   *
   * @param num number to add
   * @return sum of two numbers (SBinary when possible)
   */
  public INumber add(IInteger num) {
    return num.sumWithBinary(this);
  }

  /**
   * Substracts a INumber to a SBinary
   *
   * @param num number to substract
   * @return Substraction: result of this - num (SBinary when possible)
   */
  public INumber subs(IInteger num) {
    return num.subsWithBinary(this);
  }

  /**
   * Multiplies a INumber with a SBinary
   *
   * @param num number to multiply with
   * @return Result of this * num (SBinary when possible)
   */
  public INumber mult(IInteger num) {
    return num.multWithBinary(this);
  }

  /**
   * Division of INumber with a SBinary
   *
   * @param num number to divide with
   * @return result of this/num (SBinary when possible)
   */
  public INumber div(IInteger num) {
    return num.divWithBinary(this);
  }

  /**
   * Sum of a SBinary and SInt
   *
   * @param num SInt to sum with
   * @return SInt which contains result of a SNumber + SInt
   */
  @Override
  public INumber sumWithInt(SInt num) {
    int binvalue = toSInt().getValue();
    int res = binvalue + num.getValue();
    return new SInt(res);
  }

  /**
   * Sum of a SFloat and SBinary
   *
   * @param num SFloat to sum with
   * @return SFloat which contains the result of the sum
   */
  @Override
  public INumber sumWithFloat(SFloat num) {
    double a = num.getValue();
    double b = toSFloat().getValue();
    return new SFloat(a + b);
  }

  /**
   * Sum of a SBinary and SBinary
   *
   * @param num SBinary to sum with
   * @return SBinary which contains the sum of two SBinary
   */
  @Override
  public IInteger sumWithBinary(SBinary num) {
    int a = toSInt().getValue();
    int b = num.toSInt().getValue();
    var result = new SInt(a + b);
    return result.toSBinary();
  }

  /**
   * Substraction of a SInt with a SBinary
   *
   * @param num SInt to substract from
   * @return result of num - this
   */
  @Override
  public INumber subsWithInt(SInt num) {
    int a = num.getValue();
    int b = toSInt().getValue();
    return new SInt(a - b);
  }

  /**
   * Substraction of a SFloat with a SBinary
   *
   * @param num SFloat to substract from
   * @return result of num - this, as SFloat
   */
  @Override
  public INumber subsWithFloat(SFloat num) {
    double a = num.getValue();
    double b = toSFloat().getValue();
    return new SFloat(a - b);
  }

  /**
   * Substraction of a SBinary with another SBinary
   *
   * @param num SBinary to substract from
   * @return result of num - this as a SBinary
   */
  @Override
  public IInteger subsWithBinary(SBinary num) {
    int a = num.toSInt().getValue();
    int b = toSInt().getValue();
    var result = new SInt(a - b);
    return result.toSBinary();
  }

  /**
   * Multiplication of a SInt with a SBinary
   *
   * @param num SInt to multiply with
   * @return result of num * this as a SInt
   */
  @Override
  public INumber multWithInt(SInt num) {
    int a = num.getValue();
    int b = toSInt().getValue();
    return new SInt(a * b);
  }

  /**
   * Multiplication of a SFloat with a SBinary
   *
   * @param num SFloat to multiply with
   * @return result of num * this, as SFloat
   */
  @Override
  public INumber multWithFloat(SFloat num) {
    double a = num.getValue();
    double b = toSFloat().getValue();
    return new SFloat(a * b);
  }

  /**
   * Multiplication of two SBinary
   *
   * @param num SBinary to multiply with
   * @return result of num * this as a SBinary
   */
  @Override
  public IInteger multWithBinary(SBinary num) {
    int a = num.toSInt().getValue();
    int b = toSInt().getValue();
    var result = new SInt(a * b);
    return result.toSBinary();
  }

  /**
   * Division of a SInt with a SBinary
   *
   * @param num SInt to divide with
   * @return result of num / this, as a SInt
   */
  @Override
  public INumber divWithInt(SInt num) {
    int a = num.getValue();
    int b = toSInt().getValue();
    return new SInt(a / b);
  }

  /**
   * Division of a SFloat with a SBinary
   *
   * @param num SFloat to divide with
   * @return result of num / this, as SFloat
   */
  @Override
  public INumber divWithFloat(SFloat num) {
    double a = num.getValue();
    double b = toSFloat().getValue();
    return new SFloat(a / b);
  }

  /**
   * Division of a SBinary with a SBinary
   *
   * @param num SBinary to divide with
   * @return result of num / this, as a SBinary
   */
  @Override
  public IInteger divWithBinary(SBinary num) {
    int a = num.toSInt().getValue();
    int b = toSInt().getValue();
    var result = new SInt(a / b);
    return result.toSBinary();
  }

  /**
   * logic negation applied byte-per-byte to binary number
   *
   * @return New SBinary with 1s instead of 0s and viceversa applied to the original binary
   */
  @Override
  public Ilogical not() {
    StringBuilder notBin = new StringBuilder();
    for (int i = getValue().length() - 1; i >= 0; i--) {
      if (getValue().charAt(i) == '0') {
        notBin.append("1");
      } else {
        notBin.append("0");
      }
    }
    return new SBinary(notBin.reverse().toString());
  }

  /**
   * Logical AND applied byte-per-byte to a binary number
   *
   * @param P ILogical to operate with
   * @return SBinary containing result of AND operation
   */
  @Override
  public Ilogical and(Ilogical P) {
    return P.andWithBinary(this);
  }

  /**
   * Logical OR applied byte-per-byte to a binary number
   *
   * @param P ILogical to operate with
   * @return SBinary containing result of OR operation
   */
  @Override
  public Ilogical or(Ilogical P) {
    return P.orWithBinary(this);
  }

  /**
   * Logical AND between two binary numbers
   *
   * @param binary SBinary to operate with
   * @return new SBinary containing result of AND over corresponding positions: result[i] = this[i]
   * AND binary[i]
   */
  @Override
  public Ilogical andWithBinary(SBinary binary) {
    StringBuilder result = new StringBuilder();
    String largest, small;
    int max, min;
    if (binary.getValue().length() >= getValue().length()) {
      largest = binary.getValue();
      max = binary.getValue().length();
      min = getValue().length();
      /* Add ones to match size, 1 AND x will always return x */
      small = "1".repeat(max - min) + this.getValue();
    } else {
      max = getValue().length();
      min = binary.getValue().length();
      largest = this.getValue();
      small = "1".repeat(max - min) + binary.getValue();
    }
    int count = 0;
    do {
      if (largest.charAt(count) == '1' && small.charAt(count) == '1') {
        result.append("1");
      } else {
        result.append("0");
      }
      count++;
    } while (count < max);
    return new SBinary(result.toString());
  }

  /**
   * Logical AND between SBinary and SBoolean types
   *
   * @param bool SBool to operate with
   * @return new SBinary containing result of AND applied byte by byte
   */
  @Override
  public Ilogical andWithBool(SBool bool) {
    int count = 0;
    StringBuilder result = new StringBuilder();
    if (bool.getValue()) {
      do {
        if (getValue().charAt(count) == '0') {
          result.append("0");
        } else {
          result.append("1");
        }
        count++;
      } while (count < getValue().length());
    } else {
      do {
        result.append("0");
        count++;
      }
      while (count < getValue().length());
    }
    return new SBinary(result.toString());
  }

  /**
   * Logical OR between two binary numbers
   *
   * @param binary SBinary to operate with
   * @return new SBinary containing result of OR over corresponding positions: result[i] = this[i]
   * AND binary[i]
   */
  @Override
  public Ilogical orWithBinary(SBinary binary) {
    StringBuilder result = new StringBuilder();
    String largest, small;
    int max, min;
    if (binary.getValue().length() >= getValue().length()) {
      largest = binary.getValue();
      max = binary.getValue().length();
      min = getValue().length();
      /* Add zeros to match size, 0 OR x will always return x */
      small = "0".repeat(max - min) + this.getValue();
    } else {
      max = getValue().length();
      min = binary.getValue().length();
      largest = this.getValue();
      small = "0".repeat(max - min) + binary.getValue();
    }
    int count = 0;
    do {
      if (largest.charAt(count) == '0' && small.charAt(count) == '0') {
        result.append("0");
      } else {
        result.append("1");
      }
      count++;
    } while (count < max);
    return new SBinary(result.toString());
  }

  /**
   * Logical OR between SBinary and SBoolean types
   *
   * @param bool SBool to operate with
   * @return new SBinary containing result of OR applied byte by byte
   */
  @Override
  public Ilogical orWithBool(SBool bool) {
    int count = 0;
    StringBuilder result = new StringBuilder();
    if (!bool.getValue()) {
      do {
        if (getValue().charAt(count) == '0') {
          result.append("0");
        } else {
          result.append("1");
        }
        count++;
      } while (count < getValue().length());
    } else {
      do {
        result.append("1");
        count++;
      }
      while (count < getValue().length());
    }
    return new SBinary(result.toString());
  }

}