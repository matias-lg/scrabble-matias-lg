package cl.uchile.dcc.scrabble.gui.GUI.Controller;

import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.gui.GUI.Model.OperationsWrapper.TreeAdd;
import cl.uchile.dcc.scrabble.gui.GUI.Model.OperationsWrapper.TreeAnd;
import cl.uchile.dcc.scrabble.gui.GUI.Model.OperationsWrapper.TreeDiv;
import cl.uchile.dcc.scrabble.gui.GUI.Model.OperationsWrapper.TreeMult;
import cl.uchile.dcc.scrabble.gui.GUI.Model.OperationsWrapper.TreeNot;
import cl.uchile.dcc.scrabble.gui.GUI.Model.OperationsWrapper.TreeOr;
import cl.uchile.dcc.scrabble.gui.GUI.Model.OperationsWrapper.TreeSubs;
import cl.uchile.dcc.scrabble.gui.GUI.Model.TypesWrapper.TreeBinary;
import cl.uchile.dcc.scrabble.gui.GUI.Model.TypesWrapper.TreeBool;
import cl.uchile.dcc.scrabble.gui.GUI.Model.TypesWrapper.TreeFloat;
import cl.uchile.dcc.scrabble.gui.GUI.Model.TypesWrapper.TreeInt;
import cl.uchile.dcc.scrabble.gui.GUI.Model.TypesWrapper.TreeNull;
import cl.uchile.dcc.scrabble.gui.GUI.Model.TypesWrapper.TreeString;
import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SBinary;
import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SBool;
import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SFloat;
import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SInt;
import cl.uchile.dcc.scrabble.gui.natives.nativeClasses.SString;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class TreeControllerTest {
  private final TreeController controller = new TreeController();
  private Random rng;
  @BeforeEach
  void setUp(){
      long seed = new Random().nextInt();
      rng = new Random(seed);
    }

  @Test
  void getRootTree() {
    // not yet initialized
    assertNull(controller.getRootTree());
    // set rootTree
    controller.createIntNode(1);
    assertNotNull(controller.getRootTree());
    // check correct assignment
    assertEquals(new TreeInt(new SInt(1)), controller.getRootTree());
  }

  @Test
  void getAndSetActiveNode() {
    var testInt = new TreeInt(new SInt(1));
    var testStr = new TreeString(new SString("testing"));
    controller.setActiveNode(testInt);
    assertEquals(testInt, controller.getActiveNode());
    assertNotEquals(testStr, controller.getActiveNode());
    controller.setActiveNode(testStr);
    assertEquals(testStr, controller.getActiveNode());
  }

  @Test
  void createAddNode() {
    controller.createAddNode();
    assertEquals(new TreeAdd(), controller.getActiveNode());
    assertNotEquals(new TreeOr(), controller.getActiveNode());
  }

  @Test
  void createAndNode() {
    controller.createAndNode();
    assertEquals(new TreeAnd(), controller.getActiveNode());
    assertNotEquals(new TreeNot(), controller.getActiveNode());
  }

  @Test
  void createDivNode() {
    controller.createDivNode();
    assertEquals(new TreeDiv(), controller.getActiveNode());
    assertNotEquals(new TreeMult(), controller.getActiveNode());
  }

  @Test
  void createMultNode() {
    controller.createMultNode();
    assertEquals(new TreeMult(), controller.getActiveNode());
    assertNotEquals(new TreeAdd(), controller.getActiveNode());
  }

  @Test
  void createNotNode() {
  controller.createNotNode();
  assertEquals(new TreeNot(), controller.getActiveNode());
  assertNotEquals(new TreeSubs(), controller.getActiveNode());
  }

  @Test
  void createOrNode() {
    controller.createOrNode();
    assertEquals(new TreeOr(), controller.getActiveNode());
    assertNotEquals(new TreeAnd(), controller.getActiveNode());
  }

  @Test
  void createSubsNode() {
    controller.createSubsNode();
    assertEquals(new TreeSubs(), controller.getActiveNode());
    assertNotEquals(new TreeDiv(), controller.getActiveNode());
  }

  @RepeatedTest(20)
  void createIntNode() {
    int randomInt = rng.nextInt();
    controller.createIntNode(randomInt);
    assertEquals(new TreeInt(new SInt(randomInt)), controller.getActiveNode());
  }

  @RepeatedTest(20)
  void createFloatNode() {
    double randomDouble = rng.nextDouble();
    controller.createFloatNode(randomDouble);
    assertEquals(new TreeFloat(new SFloat(randomDouble)), controller.getActiveNode());
  }

  @RepeatedTest(20)
  void createBinaryNode() {
    var randomBinary = random(20, 0, 2, false, true, new char[]{'0',  '1'}, rng);
    controller.createBinaryNode(randomBinary);
    assertEquals(new TreeBinary(new SBinary(randomBinary)), controller.getActiveNode());

  }

  @RepeatedTest(20)
  void createStringNode() {
    String randomString = random(20, 0, Character.MAX_CODE_POINT, true, true, null, rng);
    controller.createStringNode(randomString);
    assertEquals(new TreeString(new SString(randomString)), controller.getActiveNode());
  }

  @Test
  void createBoolNode() {
    controller.createBoolNode(true);
    assertEquals(new TreeBool(new SBool(true)), controller.getActiveNode());
    assertNotEquals(new TreeBool(new SBool(false)), controller.getActiveNode());
  }

  @Test
  /* cant test evalTree since we can only modify inputs from the tree, altough this uses
     already tested methods from AstNodeWrapper and AST package c:
   */
  void evalTree() {
  }

  @Test
  void clearTree() {
    controller.clearTree();
    assertEquals(new TreeNull(), controller.getRootTree());
  }
}