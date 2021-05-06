package view;

import model.Card;
import model.Player;
import model.UnoCard;
import model.UnoGame;
import view.events.BtnStartListener;
import view.panels.*;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    private UnoGame game;
    private PlayerPanel[] listPlayers;
    private NewsPanel newsPanel;
    private DeckPanel deckPanel;
    private TrashPanel trashPanel;
    private JLabel lblMsg;
    private CardsPanel cardsPanel;
    private CardSelectedPanel cardSelectedPanel;
    private JButton btnStart;
    private JPanel auxPanel;

    public MainPanel(UnoGame game){
        this.game= game;
        setLayout(new GridLayout(3,4));
        addPlayersPanel();
        add(listPlayers[0]);
        ImageIcon imgUno= new ImageIcon("imgUno.png");
        JLabel labelUno= new JLabel();
        labelUno.setIcon(imgUno);
        add(labelUno);
        ImageIcon imgUno2= new ImageIcon("imgUno2.jpg");
        JLabel labelUno2= new JLabel();
        labelUno2.setIcon(imgUno2);
        add(labelUno2);
        add(listPlayers[1]);
        newsPanel= new NewsPanel(game,this);
        newsPanel.setVisible(false);
        deckPanel= new DeckPanel(game,this);
        deckPanel.setVisible(false);
        trashPanel= new TrashPanel(game);
        trashPanel.setVisible(false);
        cardsPanel= new CardsPanel(game,this);
        cardsPanel.setVisible(false);
        cardSelectedPanel= new CardSelectedPanel(null,this);
        cardSelectedPanel.setVisible(false);
        add(newsPanel);
        add(deckPanel);
        add(trashPanel);
        auxPanel = new JPanel();
        lblMsg= new JLabel("Presione Iniciar para jugar...",SwingConstants.CENTER);
        btnStart= new JButton("Iniciar");
        btnStart.addActionListener(new BtnStartListener(this));
        auxPanel.add(lblMsg);
        auxPanel.add(btnStart);
        add(auxPanel);
        add(listPlayers[3]);
        add(cardsPanel);

        add(cardSelectedPanel);
        add(listPlayers[2]);
    }

    private void addPlayersPanel(){
        listPlayers= new PlayerPanel[4];
        int cont=0;
        for(Player p: game.getPlayers()){
            listPlayers[cont]= new PlayerPanel(p.toString());
            cont++;
        }
        changeTurn();
    }
    private void changeTurn(){
        Player p= game.getCurrentTurn();
        for(int i=0;i<listPlayers.length;i++){
            if(p.getName().equals(listPlayers[i].getName())){
                listPlayers[i].yourTurn(true);
            }else{
                listPlayers[i].yourTurn(false);
            }
        }
    }
    public void play(){
        newsPanel.setVisible(true);
        deckPanel.setVisible(true);
        trashPanel.setVisible(true);
        cardsPanel.setVisible(true);
        auxPanel.setVisible(false);
    }

    public void loadingCard(){
        System.out.println("Cargando nueva carta");
        game.loadCard();
        cardsPanel.refresh();
    }
    public void cardClick(UnoCard card){
        cardSelectedPanel.setVisible(true);
        cardSelectedPanel.refresh(card);
    }
    public void dropCard(UnoCard card){
        if(!game.dropCard(card)){
            JOptionPane.showMessageDialog(null,"Selecciona una carta: del mismo color o mismo numero");
        }else{
            nextPlayer();
        }
    }
    public void nextPlayer(){
        if(game.nextTurn()){
            if(game.whoWin()!=null){
                System.out.println("hay ganador");
                JOptionPane.showMessageDialog(null,"El ganador es: "+game.whoWin());
            }else{
                update();
            }
        }else{
            JOptionPane.showMessageDialog(null,"Saca una carta de la baraja");
        }

    }
    public void update(){
        changeTurn();
        newsPanel.refresh();
        cardsPanel.refresh();
        trashPanel.refresh();
        cardSelectedPanel.setVisible(false);
    }
}
