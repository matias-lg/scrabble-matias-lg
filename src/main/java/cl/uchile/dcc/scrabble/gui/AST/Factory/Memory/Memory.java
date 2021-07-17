package cl.uchile.dcc.scrabble.gui.AST.Factory.Memory;

import cl.uchile.dcc.scrabble.gui.natives.INative;
import java.util.ArrayList;

public class Memory {
  private ArrayList<INative> memory = new ArrayList<INative>();

  /**
   * checks if a INative is stored in Memory instance
   * @return true if there's a INative with the same value as input
   */
  public boolean isIn(INative iNative){
    return memory.contains(iNative);
  }

  /**
   * Adds an iNative to the memory array
   * @param iNative add to memory
   */
  public void write(INative iNative){
    memory.add(iNative);
  }

  /**
   *
   * @param iNative INative to get from memory
   * @return iNative stored in memory
   */
  public INative get(INative iNative){
    /* Since we use this method ONLY to search for iNatives that we know are already in memory,
    *  it is safe to use indexOf */
    return this.memory.get(this.memory.indexOf(iNative));
  }
}
