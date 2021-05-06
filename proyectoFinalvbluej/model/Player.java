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
        boolean res=false;
        if(o instanceof Player){
            Player p= (Player)o;
            res= p.getName().equals(name);
        }
        return res;
    }
}
