package view.panels;

import model.UnoCard;
import model.UnoGame;
import view.MainPanel;
import view.events.BtnDropListener;
import view.events.BtnNextListener;

import javax.swing.*;
import java.awt.*;

public class CardSelectedPanel extends JPanel {
    private JLabel lblMsg, lblCard;
    private UnoCard card;
    private MainPanel mainPanel;

    public CardSelectedPanel(UnoCard card, MainPanel mainPanel) {
        this.card = card;
        this.mainPanel = mainPanel;
        initComponents();

    }

    public void initComponents() {
        setLayout(new BorderLayout());
        lblMsg = new JLabel("Carta seleccionada: ", SwingConstants.CENTER);
        lblMsg.setOpaque(true);
        lblMsg.setForeground(Color.WHITE);
        lblMsg.setBackground(Color.DARK_GRAY);
        add(lblMsg, BorderLayout.NORTH);
        Font font = new Font("SansSerif", Font.BOLD, 20);
        String text = "";
        lblCard = new JLabel(text, SwingConstants.CENTER);
        lblCard.setFont(font);
        lblCard.setOpaque(true);
        lblCard.setForeground(Color.GRAY);
        add(lblCard, BorderLayout.CENTER);
        JButton aux = new JButton("");
        aux.setEnabled(false);
        aux.setBorderPainted(false);
        JButton aux2 = new JButton("");
        aux2.setEnabled(false);
        aux2.setBorderPainted(false);
        add(aux, BorderLayout.WEST);
        add(aux2, BorderLayout.EAST);
        JButton btnDrop = new JButton("Soltar");
        btnDrop.setForeground(Color.white);
        btnDrop.setBackground(new Color(109, 20, 60));
        btnDrop.addActionListener(new BtnDropListener(card, mainPanel));

        JButton btnNext = new JButton("Paso");
        btnNext.setForeground(Color.white);
        btnNext.setBackground(new Color(109, 20, 60));
        btnNext.addActionListener(new BtnNextListener(mainPanel));
        JPanel auxPanel = new JPanel();
        auxPanel.setLayout(new FlowLayout());
        auxPanel.add(btnDrop);
        auxPanel.add(btnNext);
        add(auxPanel, BorderLayout.SOUTH);
    }

    public void refresh(UnoCard card) {
        this.card= card;
        if(card.getColor()==Color.RED||card.getColor()==Color.BLUE||card.getColor()==Color.BLACK){
            lblCard.setForeground(new Color(232,242,239));
        }else{
            lblCard.setForeground(Color.BLACK);
        }
        lblCard.setBackground(card.getColor());
        lblCard.setText(card.getValue());
    }
}
