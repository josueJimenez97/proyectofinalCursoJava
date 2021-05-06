package view.events;

import view.MainPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnNextListener implements ActionListener {
    private MainPanel mainPanel;
    public BtnNextListener(MainPanel mainPanel){
        this.mainPanel=mainPanel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("nextt");
        mainPanel.nextPlayer();
    }
}
