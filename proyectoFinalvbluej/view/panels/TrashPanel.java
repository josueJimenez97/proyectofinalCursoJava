package view.panels;

import model.UnoCard;
import model.UnoGame;
import view.MainPanel;

import javax.swing.*;
import java.awt.*;

public class TrashPanel extends JPanel {
    private UnoGame game;
    private JLabel lbCard;
    public TrashPanel(UnoGame game){
        this.game= game;
        setLayout(new BorderLayout());
        JLabel trashLabel= new JLabel("BASURERO",SwingConstants.CENTER);
        trashLabel.setOpaque(true);
        trashLabel.setForeground(Color.WHITE);
        trashLabel.setBackground(Color.DARK_GRAY);
        add(trashLabel,BorderLayout.NORTH);
        Font font = new Font("SansSerif", Font.BOLD, 20);
        UnoCard card= game.getCurrentCard();
        String text= card.getValue()+"";
        lbCard= new JLabel(text,SwingConstants.CENTER);
        lbCard.setFont(font);
        lbCard.setOpaque(true);
        if(card.getColor()==Color.RED||card.getColor()==Color.BLUE||card.getColor()==Color.BLACK){
            lbCard.setForeground(new Color(232,242,239));
        }else{
            lbCard.setForeground(Color.BLACK);
        }
        lbCard.setBackground(card.getColor());
        add(lbCard,BorderLayout.CENTER);
        JButton btnAux= new JButton("");
        btnAux.setEnabled(false);
        JButton btnAux1= new JButton("");
        btnAux1.setEnabled(false);
        JButton btnAux2= new JButton("");
        btnAux2.setEnabled(false);
        add(btnAux,BorderLayout.EAST);
        add(btnAux1,BorderLayout.WEST);
        add(btnAux2,BorderLayout.SOUTH);
    }

    public void refresh(){
        UnoCard card= game.getCurrentCard();
        String text= card.getValue()+"";
        lbCard.setText(text);if(card.getColor()==Color.RED||card.getColor()==Color.BLUE||card.getColor()==Color.BLACK){
            lbCard.setForeground(new Color(232,242,239));
        }else{
            lbCard.setForeground(Color.BLACK);
        }
        lbCard.setBackground(card.getColor());
    }
}
