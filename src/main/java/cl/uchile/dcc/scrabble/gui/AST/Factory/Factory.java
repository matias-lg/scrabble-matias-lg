package cl.uchile.dcc.scrabble.gui.AST.Factory;

import cl.uchile.dcc.scrabble.gui.AST.Factory.Memory.Memory;
import cl.uchile.dcc.scrabble.gui.AST.Nodes.INode;
import cl.uchile.dcc.scrabble.gui.AST.Nodes.OpNode;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SBinary;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SBool;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SFloat;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SInt;
import cl.uchile.dcc.scrabble.gui.nativeClasses.SString;
import cl.uchile.dcc.scrabble.gui.natives.INative;

public class Factory {
  private final Memory memory = new Memory();
  private INode AST;

  /**
   * Adds a INode's value to memory
   * @param node node to check
   */
  public void writeToMemory(INode node) {
      memory.write(node.eval());
  }

  /**
   * Creates a SFloat and stores it in memory if it isn't already there
   * @param val SFloat value to store
   * @return SFloat instance stored in memory
   */
  public SFloat createSFloat(double val){
    SFloat tmp = new SFloat(val);
    if (!memory.isIn(new SFloat(val))){
      writeToMemory(tmp);
    }
    /* Since isIn uses .equals to check, we can safely cast */
    return (SFloat) memory.get(tmp);
  }

  /**
   * Creates a SInt and stores it in memory if it isn't already there
   * @param val SInt value to store
   * @return SInt instance stored in memory
   */
  public SInt createSInt(int val){
    SInt tmp = new SInt(val);
    if (!memory.isIn(new SInt(val))){
      writeToMemory(tmp);
    }
    return (SInt) memory.get(tmp);
  }

  /**
   * Creates a SBinary and stores it in memory if it isn't already there
   * @param val SBinary value to store
   * @return SBinary instance stored in memory
   */
  public SBinary createSBinary(String val){
    SBinary tmp = new SBinary(val);
    if (!memory.isIn(new SBinary(val))){
      writeToMemory(tmp);
    }
    return (SBinary) memory.get(tmp);
  }

  /**
   * Creates a SString and stores it in memory if it isn't already there
   * @param val SString value to store
   * @return SString instance stored in memory
   */
  public SString createSString(String val){
    SString tmp = new SString(val);
    if (!memory.isIn(new SString(val))){
      writeToMemory(tmp);
    }
    return (SString) memory.get(tmp);
  }

  /**
   * Creates a SBool and stores it in memory if it isn't already there
   * @param val SBool value to store
   * @return SBool instance stored in memory
   */
  public SBool createSBool(boolean val){
    SBool tmp = new SBool(val);
    if (!memory.isIn(new SBool(val))){
      writeToMemory(tmp);
    }
    return (SBool) memory.get(tmp);
  }

  /**
   * sets factory's AST using values stored in factory's memory
   * @param node node to create using memory's stored values
   * @return INode which is not yet evaluated
   */
  public void setAST(INode node){
    INative tmp = node.eval();
    if (!memory.isIn(tmp)){
      writeToMemory(tmp);
    }
    this.AST = node;
  }

  /**
   * Get's created AST
   * @return AST stored in the factory
   */
  public INode getAST(){
    return this.AST;
  }

  /**
   * Evaluates stored AST
   * @return Evaluates stored AST and returns the resulting INative
   */
  public INative evalAst(){
    return this.AST.eval();
  }
}
