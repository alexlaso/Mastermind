package com.example.mastermind.entity;

import com.example.mastermind.entity.Codigo;

public class Verificador {
    boolean color1Correcto=false, color2Correcto=false, color3Correcto=false, color4Correcto=false, color5Correcto=false;
    boolean color1Existe=false, color2Existe=false, color3Existe=false, color4Existe=false, color5Existe=false;
    public Verificador() {
    }

    public void comprobarPosiciones(Codigo solucion, Codigo intento){
        if(solucion.getColor1()==intento.getColor1()){color1Correcto = true;}
        if(solucion.getColor2()==intento.getColor2()){color2Correcto = true;}
        if(solucion.getColor3()==intento.getColor3()){color3Correcto = true;}
        if(solucion.getColor4()==intento.getColor4()){color4Correcto = true;}
        if(solucion.getColor5()==intento.getColor5()){color5Correcto = true;}
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
        if(intento.getColor1()== solucion.getColor1()|intento.getColor1()== solucion.getColor2()|intento.getColor1()== solucion.getColor3()|intento.getColor1()== solucion.getColor4()|intento.getColor1()== solucion.getColor5()){
            color1Existe=true;
        }
        if(intento.getColor2()== solucion.getColor1()|intento.getColor2()== solucion.getColor2()|intento.getColor2()== solucion.getColor3()|intento.getColor2()== solucion.getColor4()|intento.getColor2()== solucion.getColor5()){
            color2Existe=true;
        }
        if(intento.getColor3()== solucion.getColor1()|intento.getColor3()== solucion.getColor2()|intento.getColor3()== solucion.getColor3()|intento.getColor3()== solucion.getColor4()|intento.getColor3()== solucion.getColor5()){
            color3Existe=true;
        }
        if(intento.getColor4()== solucion.getColor1()|intento.getColor4()== solucion.getColor2()|intento.getColor4()== solucion.getColor3()|intento.getColor4()== solucion.getColor4()|intento.getColor4()== solucion.getColor5()){
            color4Existe=true;
        }
        if(intento.getColor5()== solucion.getColor1()|intento.getColor5()== solucion.getColor2()|intento.getColor5()== solucion.getColor3()|intento.getColor5()== solucion.getColor4()|intento.getColor5()== solucion.getColor5()){
            color5Existe=true;
        }
    }
}
