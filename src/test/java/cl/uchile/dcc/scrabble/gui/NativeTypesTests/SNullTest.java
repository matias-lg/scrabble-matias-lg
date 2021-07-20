package cl.uchile.dcc.scrabble.gui.NativeTypesTests;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SNull;
import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SString;
import org.junit.jupiter.api.Test;

class SNullTest {
  private final SNull testNull = new SNull();

  @Test
  void toSString() {
    assertNull(testNull.toSString());
  }

  @Test
  void testToString() {
    assertEquals("null", testNull.toString());
  }

  @Test
  void sumWithString() {
    assertNull(testNull.sumWithString(new SString("dummyString!")));
  }
}