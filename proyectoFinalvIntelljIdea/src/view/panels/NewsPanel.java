package view.panels;

import model.Card;
import model.UnoCard;
import model.UnoGame;
import view.MainPanel;

import javax.swing.*;
import java.awt.*;

public class NewsPanel extends JPanel {
    private JLabel turn,direction,sizeDeck,winner,currentColor;
    private UnoGame game;
    private MainPanel mainPanel;
    public NewsPanel(UnoGame game, MainPanel mainPanel){
        this.game= game;
        this.mainPanel= mainPanel;
        initComponents();

    }
    public void initComponents(){
        turn=new JLabel();
        direction= new JLabel();
        sizeDeck= new JLabel();
        winner= new JLabel();
        currentColor= new JLabel("Color Actual: ");
        currentColor.setOpaque(true);
        add(turn);
        add(direction);
        add(sizeDeck);
        add(winner);
        add(currentColor);
        refresh();
    }
    public void refresh(){
        turn.setText("Turno: "+game.getCurrentTurn());
        String dir= game.getDirection()==0? "Izquierda":"Derecha";
        direction.setText("Sentido: "+dir);
        sizeDeck.setText("Carta en mazo: "+game.sizeDeck());
        winner.setText("Ganador: "+ game.whoWin());
        UnoCard card= game.getCurrentCard();
        if(card.getColor()==Color.RED||card.getColor()==Color.BLUE||card.getColor()==Color.BLACK){
            currentColor.setForeground(new Color(232,242,239));
        }else{
            currentColor.setForeground(Color.BLACK);
        }
        currentColor.setBackground(card.getColor());
    }
}
