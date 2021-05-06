package view.events;

import view.MainPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnStartListener implements ActionListener {
    private MainPanel mainPanel;

    public BtnStartListener(MainPanel mainPanel){
        this.mainPanel= mainPanel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Aqui inicia el juego");
        mainPanel.play();
    }
}
