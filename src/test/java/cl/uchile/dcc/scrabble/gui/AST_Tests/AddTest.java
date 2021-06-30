package cl.uchile.dcc.scrabble.gui.AST_Tests;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import cl.uchile.dcc.scrabble.gui.AST.Add;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SBinary;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SFloat;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SInt;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AddTest {
  @BeforeEach
  public void setUp(){
    int a = 1+1;
  }
  @Test
  public void NumberTest(){
    var add = new Add(new SInt(3), new SFloat(2));
    assertEquals(new SFloat(5), add.eval());
    add = new Add(new SInt(0), new SInt(1));
    assertEquals(new SInt(1), add.eval());
    /* Two OpNodes as childs */
    var child1 = new Add(new SFloat(10), new SInt(1)); //Sfloat(10) + SInt(1) -> SFloat(11)
    var child2 = new Add(new SBinary("0"), new SInt(1)); // 0 + 1 -> sbin(1)
    var hard = new Add(child1, child2);
    System.out.println(hard.eval());
  }
  @Test
  public void StringTest(){
    var add = new Add(new SString("cuatro"), new Add(new SInt(2), new SFloat(2)));
    var str = add.eval();
    assertEquals(new SString("cuatro4.0"), add.eval());
  }

  @Test public void BinaryTest(){
    /* invalid operation */
    var add = new Add(new SBinary("0"), new SFloat(1));
    var res = add.eval();
    assertNull(res);
    /* valid */
    add = new Add(new SBinary("10"), new SInt(2));
    assertEquals(new SBinary("100"), add.eval());
  }
}
