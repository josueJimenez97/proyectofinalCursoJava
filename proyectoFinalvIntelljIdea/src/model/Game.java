package model;

import java.awt.*;
import java.util.ArrayList;

public class Game implements UnoGame {
    private static final Color[] COLORS={Color.BLUE,Color.RED,Color.YELLOW,Color.GREEN};
    private ArrayList<UnoCard> cards;
    public Game(){
        cards= new ArrayList<>();
        for(int i=0;i<5;i++){
            int rd= (int)(Math.random()*4);
            cards.add(new Card(COLORS[rd],(char) i));
        }
    }
    @Override
    public Player whoWin() {
        return null;
    }

    @Override
    public ArrayList<UnoCard> getCardsCurrentPlayer() {
        return cards;
    }

    @Override
    public ArrayList<Player> getPlayers() {
        ArrayList<Player> listPlayers= new ArrayList<>();
        listPlayers.add(new Player("Jugador 1"));
        listPlayers.add(new Player("Jugador 2"));
        listPlayers.add(new Player("Jugador 3"));
        listPlayers.add(new Player("Jugador 4"));

        return listPlayers;
    }

    @Override
    public UnoCard getCurrentCard() {
        return new Card(Color.GREEN,9);
    }

    @Override
    public Player getCurrentTurn() {
        return new Player("Jugador 2");
    }

    @Override
    public boolean dropCard(UnoCard card) {
        return false;
    }

    @Override
    public void loadCard() {
        cards.add(new Card(Color.RED,9));
    }

    @Override
    public boolean nextTurn() {
        return false;
    }


    @Override
    public int sizeDeck() {
        return 0;
    }

    /*
    * 0 -> Izquierda
    * 1 -> Derecha
     */
    @Override
    public int getDirection() {
        return 0;
    }

    @Override
    public void shuffle() {

    }
}
