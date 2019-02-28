package com.company;

class AreaExeption extends Exception{

    public AreaExeption(String message, int area){
        super(message + " " + area);
    }
}