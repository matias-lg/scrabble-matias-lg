package cl.uchile.dcc.scrabble.gui.nativeClasses;

import cl.uchile.dcc.scrabble.gui.INative;

import java.util.Objects;

public class ScrabbleBinary implements INative {
    private String value;
    public ScrabbleBinary(String value) throws ExceptionInInitializerError {
        if (!value.matches("^[0,1]*$")) {
            throw new ExceptionInInitializerError("El string debe contener solo 0s o 1s");
        } else {
            this.value = value;
        }
    }

    @Override
    public String toString() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScrabbleBinary)) return false;
        ScrabbleBinary that = (ScrabbleBinary) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
