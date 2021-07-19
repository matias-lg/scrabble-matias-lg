module scrabble.main {
  requires javafx.controls;
  exports cl.uchile.dcc.scrabble.gui;
  exports cl.uchile.dcc.scrabble.gui.GUI;
  exports cl.uchile.dcc.scrabble.gui.GUI.Controller;
  exports cl.uchile.dcc.scrabble.gui.GUI.Controller.AstNodeWrapper;
  exports cl.uchile.dcc.scrabble.gui.AST.Nodes;
  exports cl.uchile.dcc.scrabble.gui.nativeClasses;
  exports cl.uchile.dcc.scrabble.gui.natives;
  exports cl.uchile.dcc.scrabble.gui.GUI.Controller.AstNodeWrapper.OperationsWrapper;

}