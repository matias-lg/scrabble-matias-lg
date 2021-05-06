package cl.uchile.dcc.scrabble.gui.nativeClasses;

import cl.uchile.dcc.scrabble.gui.INative;

import java.util.Objects;

public class ScrabbleBool implements INative {
    boolean value;
    public ScrabbleBool(boolean value){
        this.value = value;
    }

    public boolean getValue(){
        return this.value;
    }

    @Override
    public String toString() {
        return Boolean.toString(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScrabbleBool)) return false;
        ScrabbleBool that = (ScrabbleBool) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
