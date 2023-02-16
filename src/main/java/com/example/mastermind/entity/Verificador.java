package com.example.mastermind.entity;

import com.example.mastermind.entity.Codigo;

public class Verificador {
    boolean color1Correcto, color2Correcto, color3Correcto, color4Correcto, color5Correcto;
    boolean color1Existe, color2Existe, color3Existe, color4Existe, color5Existe;
    public Verificador() {
    }

    public void comprobarPosiciones(Codigo solucion, Codigo intento){
        if(solucion.getColor1().equals(intento.getColor1())){color1Correcto = true;}else{color1Correcto=false;}
        if(solucion.getColor2().equals(intento.getColor2())){color2Correcto = true;}else{color2Correcto=false;}
        if(solucion.getColor3().equals(intento.getColor3())){color3Correcto = true;}else{color3Correcto=false;}
        if(solucion.getColor4().equals(intento.getColor4())){color4Correcto = true;}else{color4Correcto=false;}
        if(solucion.getColor5().equals(intento.getColor5())){color5Correcto = true;}else{color5Correcto=false;}
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

    public void comprobarExistencia(Codigo solucion, Codigo intento){
        if(intento.getColor1().equals(solucion.getColor1())|intento.getColor1().equals(solucion.getColor2())|intento.getColor1().equals(solucion.getColor3())|intento.getColor1().equals(solucion.getColor4())|intento.getColor1().equals(solucion.getColor5())){
            color1Existe=true;
        }
        if(intento.getColor2().equals(solucion.getColor1())|intento.getColor2().equals(solucion.getColor2())|intento.getColor2().equals(solucion.getColor3())|intento.getColor2().equals(solucion.getColor4())|intento.getColor2().equals(solucion.getColor5())){
            color2Existe=true;
        }
        if(intento.getColor3().equals(solucion.getColor1())|intento.getColor3().equals(solucion.getColor2())|intento.getColor3().equals(solucion.getColor3())|intento.getColor3().equals(solucion.getColor4())|intento.getColor3().equals(solucion.getColor5())){
            color3Existe=true;
        }
        if(intento.getColor4().equals(solucion.getColor1())|intento.getColor4().equals(solucion.getColor2())|intento.getColor4().equals(solucion.getColor3())|intento.getColor4().equals(solucion.getColor4())|intento.getColor4().equals(solucion.getColor5())){
            color4Existe=true;
        }
        if(intento.getColor5().equals(solucion.getColor1())|intento.getColor5().equals(solucion.getColor2())|intento.getColor5().equals(solucion.getColor3())|intento.getColor5().equals(solucion.getColor4())|intento.getColor5().equals(solucion.getColor5())){
            color5Existe=true;
        }
    }
}
