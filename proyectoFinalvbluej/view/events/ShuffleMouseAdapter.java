package view.events;

import model.UnoGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ShuffleMouseAdapter extends MouseAdapter {
    private JLabel lblShuffle;
    private UnoGame game;

    public ShuffleMouseAdapter(JLabel lblShuffle, UnoGame game) {
        this.lblShuffle = lblShuffle;
        this.game = game;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("barajeando");
        game.shuffle();
    }

    @Override
    public void mouseEntered(MouseEvent ev) {
        System.out.println("El puntero está sobre el botón");
        lblShuffle.setForeground(Color.YELLOW);
    }

    @Override
    public void mouseExited(MouseEvent ev) {
        System.out.println("El puntero ha salido del botón");
        lblShuffle.setForeground(Color.WHITE);
    }

}
