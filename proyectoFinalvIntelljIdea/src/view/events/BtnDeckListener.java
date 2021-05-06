package view.events;

import view.MainPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnDeckListener implements ActionListener {
    private MainPanel mainPanel;
    public BtnDeckListener(MainPanel mainPanel){
        this.mainPanel= mainPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainPanel.loadingCard();
    }
}
