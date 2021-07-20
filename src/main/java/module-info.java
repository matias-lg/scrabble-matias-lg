module scrabble.main {
  requires javafx.controls;
  exports cl.uchile.dcc.scrabble.gui;
  exports cl.uchile.dcc.scrabble.gui.GUI;
  exports cl.uchile.dcc.scrabble.gui.GUI.Controller;
  exports cl.uchile.dcc.scrabble.gui.GUI.Model;
  exports cl.uchile.dcc.scrabble.gui.AST.Nodes;
  exports cl.uchile.dcc.scrabble.gui.natives.nativeClasses;
  //exports cl.uchile.dcc.scrabble.gui.natives;
  exports cl.uchile.dcc.scrabble.gui.GUI.Model.OperationsWrapper;
  exports cl.uchile.dcc.scrabble.gui.natives.interfaces;

}