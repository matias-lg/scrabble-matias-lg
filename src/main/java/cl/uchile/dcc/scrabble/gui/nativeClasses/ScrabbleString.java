package cl.uchile.dcc.scrabble.gui.nativeClasses;

import java.util.Objects;

public class ScrabbleString {
    private String str;
    public ScrabbleString(String str){
        this.str = str;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScrabbleString)) return false;
        ScrabbleString that = (ScrabbleString) o;
        return str.equals(that.str);
    }

    @Override
    public int hashCode() {
        return Objects.hash(str);
    }
}
