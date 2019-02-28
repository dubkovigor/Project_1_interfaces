package com.company;

public class Room implements Light, Space {

    private final String room;
    private final int areabuild;
    private final int bulb;
    private final int window;
    private final int table;
    private final int chair;

    public Room(String room,int areabuild, int bulb, int window, int table, int chair) {

        this.room = room;
        this.areabuild = areabuild;
        this.bulb = bulb;
        this.window = window;
        this.table = table;
        this.chair = chair;
    }

    public void getLight()throws LightExeption{

        if(window*lightw+bulb*lightb < 400)
            throw new LightExeption("Света мало", window*lightw+bulb*lightb);
        else if (window*lightw + bulb*lightb >4000)
            throw new LightExeption("Света много",window*lightw+bulb*lightb);
    }

    @Override
    public void getSq() throws AreaExeption{

        if(areabuild*0.7<table*3+chair*2)
            throw new AreaExeption("Столько занимать нельзя", 100*(table*3+chair*2)/areabuild);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(room).append("\n   ")
                .append("Освещенность = ").append(bulb*lightb + window*lightw)
                .append("(" + window + "окна по 700 лк," + bulb + " лампочек по 200 лк)")
                .append("\n   Площадь = "+areabuild+"м^2").append(" (занято " + table*size + "м^2, гарантированно свободно " )
                .append(areabuild-table*size + "м^2)\n   ")
                .append("Мебель:\n     ").append("Стол письменный (площадь " + table*size)
                .append("м^2)\n     Кресло мягкое и пушистое(площадь от " + chair*minsize + "м^2 до " + chair*maxsize+"м^2)")
                .append('.');
        return sb.toString();
    }

    public static class Builder {

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
            return new Room(room, areabuild, bulb, window, table, chair);
        }

    }

}