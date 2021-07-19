package cl.uchile.dcc.scrabble.gui.AST.Factory;

import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.junit.jupiter.api.Assertions.assertEquals;

import cl.uchile.dcc.scrabble.gui.AST.Nodes.Add;
import cl.uchile.dcc.scrabble.gui.AST.Nodes.Mult;
import cl.uchile.dcc.scrabble.gui.AST.Nodes.Or;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SBinary;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SBool;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SFloat;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SInt;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SString;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class FactoryTest {

  private final Factory f = new Factory();

  private SInt testInt;
  private SFloat testFloat;
  private SBinary testBin;
  private SString testString;
  private SBool testBool;
  private Random rng;
  private int jint;
  private double jfloat;
  private String randomString;
  private String randomStr;

  @BeforeEach
  void setUp() {
    long seed = new Random().nextInt();
    rng = new Random(seed);
    jfloat = rng.nextDouble();
    jint = rng.nextInt();
    testInt = new SInt(jint);
    testFloat = new SFloat(jfloat);
    randomString = random(20, 0, 2, false, true, new char[]{'0', '1'}, rng);
    testBin = new SBinary(randomString);
    randomStr = random(100, 0, Character.MAX_CODE_POINT, true, true, null, rng);
    testString = new SString(randomStr);
    testBool = new SBool(true);
  }

  @RepeatedTest(20)
  void createSFloat() {
    assertEquals(testFloat, f.createSFloat(jfloat));
  }

  @RepeatedTest(20)
  void createSInt() {
    assertEquals(testInt, f.createSInt(jint));

  }

  @RepeatedTest(20)
  void createSBinary() {
    assertEquals(testBin, f.createSBinary(randomString));
  }

  @RepeatedTest(20)
  void createSString() {
    assertEquals(testString, f.createSString(randomStr));
  }

  @Test
  void createSBool() {
    assertEquals(new SBool(true), f.createSBool(true));
    assertEquals(new SBool(false), f.createSBool(false));

  }

  @Test
  void ASTtest() {
    f.setAST(new Add(new Mult(f.createSFloat(1.0), f.createSInt(10)),
        new Or(f.createSBinary("0"), f.createSBool(true))));
    assertEquals(
        new Add(new Mult(f.createSFloat(1.0), f.createSInt(10)),
            new Or(f.createSBinary("0"), f.createSBool(true))).eval()
        , f.getAST().eval());
    assertEquals(f.createSFloat(11), f.evalAst());
  }
}