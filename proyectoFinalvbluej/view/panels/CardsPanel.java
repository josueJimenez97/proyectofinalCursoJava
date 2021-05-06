package view.panels;

import model.UnoCard;
import model.UnoGame;
import view.CardButton;
import view.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CardsPanel extends JPanel {
    private static final Color[] COLORS = {Color.BLUE, Color.RED, Color.YELLOW, Color.GREEN};
    private UnoGame game;
    private MainPanel mainPanel;
    private JPanel auxPanel;
    private CardButton[] cardsButton;

    public CardsPanel(UnoGame game, MainPanel mainPanel) {
        this.game = game;
        cardsButton = new CardButton[12];
        this.mainPanel = mainPanel;
        setLayout(new BorderLayout());


        JLabel lblAux = new JLabel("Tus Cartas", SwingConstants.CENTER);
        lblAux.setOpaque(true);
        lblAux.setBackground(Color.DARK_GRAY);
        lblAux.setForeground(Color.WHITE);
        add(lblAux, BorderLayout.NORTH);
        auxPanel = new JPanel(new FlowLayout());
        add(auxPanel, BorderLayout.CENTER);
        initComponents();
        refresh();
    }

    public void initComponents() {
        refresh();
        for (int i = 0; i < 12; i++) {
            if (cardsButton[i] != null)
                auxPanel.add(cardsButton[i]);
        }
    }

    public void refresh() {
        ArrayList<UnoCard> cards = game.getCardsCurrentPlayer();
        if (cards != null) {
            for (int i = 0; i < 12; i++) {
                if (i < cards.size() && cards.get(i) != null) {
                    if (cardsButton[i] != null) {
                        cardsButton[i].update(cards.get(i));
                    } else {
                        cardsButton[i] = new CardButton(cards.get(i), mainPanel);
                    }
                } else if (cardsButton[i] != null) {
                    cardsButton[i].delete();
                } else {
                    cardsButton[i] = new CardButton(mainPanel);
                }
            }

        }

    }

}

