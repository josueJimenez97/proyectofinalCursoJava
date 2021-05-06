package model;

import java.awt.*;

public class Card implements UnoCard{
    private int value;
    private Color color;
    public Card(Color color, int value){
        this.value= value;
        this.color=color;
    }
    @Override
    public String getValue() {
        return value+"";
    }

    @Override
    public Color getColor() {
        return color;
    }
}
