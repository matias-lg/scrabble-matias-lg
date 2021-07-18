package cl.uchile.dcc.scrabble.gui.GUI;

import cl.uchile.dcc.scrabble.gui.AST.Factory.Factory;
import cl.uchile.dcc.scrabble.gui.AST.Nodes.Add;
import cl.uchile.dcc.scrabble.gui.AST.Nodes.INode;

/**
 * Controller that App will use, this class will pass and execute all the Scrabble logic
 */
public class Controller {
  private final Factory factory = new Factory();
  private INode currentLeft;
  private INode currentRight;


  public void setCurrentLeft(INode node){
    currentLeft = node;
  }

  public void setCurrentRight(INode node){
    currentRight = node;
  }

}
