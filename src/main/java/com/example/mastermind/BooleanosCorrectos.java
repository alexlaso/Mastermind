package com.example.mastermind;

import java.io.Serializable;

public class BooleanosCorrectos implements Serializable {
    private boolean color1Correcto, color2Correcto, color3Correcto, color4Correcto, color5Correcto;

    public BooleanosCorrectos(boolean color1Correcto, boolean color2Correcto, boolean color3Correcto, boolean color4Correcto, boolean color5Correcto) {
        this.color1Correcto = color1Correcto;
        this.color2Correcto = color2Correcto;
        this.color3Correcto = color3Correcto;
        this.color4Correcto = color4Correcto;
        this.color5Correcto = color5Correcto;
    }

    public BooleanosCorrectos() {
    }

    @Override
    public String toString() {
        return "BooleanosCorrectos{" +
                "color1Correcto=" + color1Correcto +
                ", color2Correcto=" + color2Correcto +
                ", color3Correcto=" + color3Correcto +
                ", color4Correcto=" + color4Correcto +
                ", color5Correcto=" + color5Correcto +
                '}';
    }

    public boolean isColor1Correcto() {
        return color1Correcto;
    }

    public void setColor1Correcto(boolean color1Correcto) {
        this.color1Correcto = color1Correcto;
    }

    public boolean isColor2Correcto() {
        return color2Correcto;
    }

    public void setColor2Correcto(boolean color2Correcto) {
        this.color2Correcto = color2Correcto;
    }

    public boolean isColor3Correcto() {
        return color3Correcto;
    }

    public void setColor3Correcto(boolean color3Correcto) {
        this.color3Correcto = color3Correcto;
    }

    public boolean isColor4Correcto() {
        return color4Correcto;
    }

    public void setColor4Correcto(boolean color4Correcto) {
        this.color4Correcto = color4Correcto;
    }

    public boolean isColor5Correcto() {
        return color5Correcto;
    }

    public void setColor5Correcto(boolean color5Correcto) {
        this.color5Correcto = color5Correcto;
    }
}
