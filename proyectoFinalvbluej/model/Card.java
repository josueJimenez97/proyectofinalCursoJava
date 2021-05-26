package model;

import java.awt.*;
import java.awt.Color;
public class Card implements UnoCard{
    private String value;
    private Color color;
    
    public Card(String value, Color color){
        this.color = color;
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public Color getColor() {
        return color;
    }
}
