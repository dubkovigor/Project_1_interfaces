package com.company;

import com.company.exeption.AreaExeption;
import com.company.exeption.LightExeption;

public class Main {

    public static void main(String[] args) throws AreaExeption, LightExeption {

        Building b1 = new Building("Здание №1");
        System.out.println(b1.getBuilderName());
        b1.addRoom(" Помещение №1", 10, 1,1,1,1);
        b1.addRoom(" Помещение №2", 100, 8,3,10,4);
    }
}
