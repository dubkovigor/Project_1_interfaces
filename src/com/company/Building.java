package com.company;

import java.util.ArrayList;

public class Building {
    private String builderName;

    public String getBuilderName() {
        return builderName;
    }

    private ArrayList<Room> rooms = new ArrayList<Room>();

    public Building(String builderName) {
        this.builderName = builderName;
    }

    public void addRoom(String room, int areabuild, int bulb, int window, int table, int chair) throws LightExeption, AreaExeption {
        Room room2 = new Room.Builder()
                .setRoom(room)
                .setAreaBuild(areabuild)
                .setBulb(bulb)
                .setWindow(window)
                .setTable(table)
                .setChair(chair)
                .build();

        rooms.add(room2);
        room2.getSq();
        room2.getLight();
        System.out.println(room2.toString());
    }
}