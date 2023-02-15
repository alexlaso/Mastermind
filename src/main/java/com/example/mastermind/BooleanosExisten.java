package com.example.mastermind;

import java.io.Serializable;

public class BooleanosExisten implements Serializable {
    boolean color1Existe, color2Existe, color3Existe, color4Existe, color5Existe;

    public BooleanosExisten(boolean color1Existe, boolean color2Existe, boolean color3Existe, boolean color4Existe, boolean color5Existe) {
        this.color1Existe = color1Existe;
        this.color2Existe = color2Existe;
        this.color3Existe = color3Existe;
        this.color4Existe = color4Existe;
        this.color5Existe = color5Existe;
    }

    public BooleanosExisten() {
    }

    @Override
    public String toString() {
        return "BooleanosExisten{" +
                "color1Existe=" + color1Existe +
                ", color2Existe=" + color2Existe +
                ", color3Existe=" + color3Existe +
                ", color4Existe=" + color4Existe +
                ", color5Existe=" + color5Existe +
                '}';
    }

    public boolean isColor1Existe() {
        return color1Existe;
    }

    public void setColor1Existe(boolean color1Existe) {
        this.color1Existe = color1Existe;
    }

    public boolean isColor2Existe() {
        return color2Existe;
    }

    public void setColor2Existe(boolean color2Existe) {
        this.color2Existe = color2Existe;
    }

    public boolean isColor3Existe() {
        return color3Existe;
    }

    public void setColor3Existe(boolean color3Existe) {
        this.color3Existe = color3Existe;
    }

    public boolean isColor4Existe() {
        return color4Existe;
    }

    public void setColor4Existe(boolean color4Existe) {
        this.color4Existe = color4Existe;
    }

    public boolean isColor5Existe() {
        return color5Existe;
    }

    public void setColor5Existe(boolean color5Existe) {
        this.color5Existe = color5Existe;
    }
}
