package model;

import java.util.ArrayList;

public interface UnoGame {
    public Player whoWin();
    public ArrayList<UnoCard> getCardsCurrentPlayer();
    public ArrayList<Player> getPlayers();
    public UnoCard getCurrentCard();
    public Player getCurrentTurn();
    public boolean dropCard(UnoCard card);
    public void loadCard();
    public boolean nextTurn();
    public int sizeDeck();
    public int getDirection();
    public void shuffle();
}
