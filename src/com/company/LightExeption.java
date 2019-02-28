package com.company;

class LightExeption extends Exception{

    public LightExeption(String message, int lighting){
        super(message + " " +lighting);
    }
}