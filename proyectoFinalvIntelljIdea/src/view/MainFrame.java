package view;

import model.UnoGame;

import javax.swing.*;

public class MainFrame extends JFrame {
    private MainPanel mainPanel;
    public MainFrame(UnoGame game){
        setResizable(false);
        setSize(700,500);
        setTitle("Juego Uno");
        mainPanel= new MainPanel(game);
        setLocationRelativeTo(null);
        setVisible(true);
        setContentPane(mainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
