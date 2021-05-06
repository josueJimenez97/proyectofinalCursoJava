package view.events;

import model.UnoCard;
import view.MainPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnDropListener implements ActionListener {
    private UnoCard card;
    private MainPanel mainPanel;

    public BtnDropListener(UnoCard card, MainPanel mainPanel){
        this.card= card;
        this.mainPanel= mainPanel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("dropp");
        mainPanel.dropCard(card);
    }
}
