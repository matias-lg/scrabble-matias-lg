package cl.uchile.dcc.scrabble.gui.AST_Tests;



import static org.junit.jupiter.api.Assertions.assertEquals;

import cl.uchile.dcc.scrabble.gui.AST.Add;
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
  public void constructorTest(){
    var add = new Add(new SInt(3), new SFloat(2));
    assertEquals(new SFloat(5), add.eval());
    add = new Add(new SInt(0), new SInt(1));
    assertEquals(new SInt(1), add.eval());
  }
}
