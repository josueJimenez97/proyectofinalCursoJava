package view.panels;

import model.UnoGame;
import view.MainPanel;
import view.events.BtnDeckListener;
import view.events.ShuffleMouseAdapter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DeckPanel extends JPanel {
    private UnoGame game;
    private MainPanel mainPanel;
    public DeckPanel(UnoGame game, MainPanel mainPanel){
        this.game= game;
        this.mainPanel= mainPanel;
        setLayout(new BorderLayout());
        JLabel lblShuffle= new JLabel("BARAJAR",SwingConstants.CENTER);
        lblShuffle.setOpaque(true);
        lblShuffle.setBackground(Color.DARK_GRAY);
        lblShuffle.setForeground(Color.WHITE);
        lblShuffle.addMouseListener(new ShuffleMouseAdapter(lblShuffle,game));
        add(lblShuffle,BorderLayout.NORTH);
        ImageIcon imgBaraja= new ImageIcon("unoBack.png");
        JButton btnDeck= new JButton("");
        btnDeck.setIcon(imgBaraja);
        btnDeck.addActionListener(new BtnDeckListener(mainPanel));
        add(btnDeck,BorderLayout.CENTER);
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
}
