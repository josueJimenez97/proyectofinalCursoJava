package model;
import java.util.ArrayList;
public class Deck
{
    private ArrayList <UnoCard> deck;

    public Deck(){
        deck = new ArrayList();

    }
    public void insertCards(Card card){
        deck.add(card);
    }
    public ArrayList<UnoCard> getDeck(){
        return deck;
    }
    public ArrayList<UnoCard> entregarCartas(){
        ArrayList<UnoCard> deckFromPlayer = new ArrayList();
        for(int i = 0; i < 5; i++){
        deckFromPlayer.add(deck.remove((int)(Math.random()* deck.size()-1)));
    }
        return deckFromPlayer;
    }
}
