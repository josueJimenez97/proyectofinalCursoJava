package model;

public class Player{
    private String name;
    public Player(String name){
        this.name=name;
    }
    @Override
    public String toString(){
        return name;
    }
    public String getName(){
        return name;
    }
    @Override
    public boolean equals(Object o){
        return false;
    }
}
