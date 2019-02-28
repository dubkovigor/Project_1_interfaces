package com.company;

import com.company.exeption.AreaExeption;
import com.company.exeption.LightExeption;
import com.company.interfaces.Light;
import com.company.interfaces.Space;

public class Room implements Light, Space {

    private final String room;
    private final int areabuild;
    private final int bulb;
    private final int window;
    private final int table;
    private final int chair;

    private Room(Builder builder) {

        this.room = builder.room;
        this.areabuild = builder.areabuild;
        this.bulb = builder.bulb;
        this.window = builder.window;
        this.table = builder.table;
        this.chair = builder.chair;
    }

    public void getLight()throws LightExeption {

        if(window*lightw+bulb* lightbi < 400)
            throw new LightExeption("Света мало", window*lightw+bulb* lightbi);
        else if (window*lightw + bulb* lightbi >4000)
            throw new LightExeption("Света много",window*lightw+bulb* lightbi);
    }

    @Override
    public void getSq() throws AreaExeption {

        if(areabuild*0.7<table*3+chair*2)
            throw new AreaExeption("Столько занимать нельзя", 100*(table*3+chair*2)/areabuild);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(room).append("\n   ")
                .append("Освещенность = ").append(bulb* lightbi + window*lightw)
                .append("(" + window + "окна по 700 лк," + bulb + " лампочек по 200 лк)")
                .append("\n   Площадь = "+areabuild+"м^2").append(" (занято " + table*size + "м^2, гарантированно свободно " )
                .append(areabuild-table*size + "м^2)\n   ")
                .append("Мебель:\n     ").append("Стол письменный (площадь " + table*size)
                .append("м^2)\n     Кресло мягкое и пушистое(площадь от " + chair*minsize + "м^2 до " + chair*maxsize+"м^2)")
                .append('.');
        return sb.toString();
    }

    static class Builder {

        private String room;
        private int areabuild;
        private int bulb;
        private int window;
        private int table;
        private int chair;


        public Builder setRoom(String room){
            this.room = room;
            return this;
        }

        public Builder setAreaBuild(int areabuild){
            this.areabuild = areabuild;
            return this;
        }

        public Builder setBulb(int bulb){
            this.bulb = bulb;
            return this;
        }

        public Builder setWindow(int window){
            this.window = window;
            return this;
        }

        public Builder setTable(int table){
            this.table = table;
            return this;
        }

        public Builder setChair(int chair){
            this.chair = chair;
            return this;
        }

        public Room build() {
            return new Room(this);
        }

    }
}
