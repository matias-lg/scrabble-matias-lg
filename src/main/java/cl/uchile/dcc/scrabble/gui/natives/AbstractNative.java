package cl.uchile.dcc.scrabble.gui.natives;

public abstract class AbstractNative implements INative {

  /**
   * Scrabble Natives also represent leafs of the AST
   *
   * @return returns itself
   */
  @Override
  public INative eval() {
    return this;
  }
}
