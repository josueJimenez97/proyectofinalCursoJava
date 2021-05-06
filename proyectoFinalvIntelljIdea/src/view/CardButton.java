package view;

import model.UnoCard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardButton extends JButton implements ActionListener {
    private UnoCard card;
    private MainPanel mainPanel;
    public CardButton(MainPanel mainPanel){
        this.mainPanel=mainPanel;
        addActionListener(this);
        setBorderPainted(false);
        setVisible(false);
    }
    public CardButton(UnoCard card, MainPanel mainPanel){
        this.card= card;
        this.mainPanel= mainPanel;
        if(card.getColor()==Color.RED||card.getColor()==Color.BLUE||card.getColor()==Color.BLACK){
            setForeground(new Color(232,242,239));
        }else{
            setForeground(Color.BLACK);
        }
        setBackground(card.getColor());
        setText(card.getValue()+"");
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("presionaste la carta");
        mainPanel.cardClick(card);
    }
    public String getInfo(){
        return card.getValue()+"";
    }
    public void update(UnoCard card){
        this.card=card;
        this.mainPanel=mainPanel;
        if(card.getColor()==Color.RED||card.getColor()==Color.BLUE||card.getColor()==Color.BLACK){
            setForeground(new Color(232,242,239));
        }else{
            setForeground(Color.BLACK);
        }
        setBackground(card.getColor());
        setText(card.getValue());
        setBorderPainted(true);
        setVisible(true);
    }
    public void delete(){
        card=null;
        setBorderPainted(false);
        setVisible(false);
    }
}
