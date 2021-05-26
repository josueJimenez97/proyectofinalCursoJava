package model;
import java.util.ArrayList;
public class Player{
    private String name;
    private boolean win;
    private ArrayList<UnoCard> myDeck;
    private Deck aux;
    public Player(String name){
        this.name=name;
        myDeck = new ArrayList();
        win = false;

    }

    @Override
    public String toString(){
        return name;
    }

    public String getName(){
        return name;
    }

    @Override
    public boolean equals(Object otherPlayer){
        boolean res = false;
        if(name.equals(otherPlayer)){
            res = true;
        }else{
            res = false;
        }
        return res;
    }

    public boolean win(ArrayList<Card>myDeck){        
        boolean res = myDeck.isEmpty();
        win = false;

        if(res == true){
            win = true;
        }else{
            win = false;
        }
        return win;
    }

    public boolean getWinner(){
        return win;
    }

    public void setWinner(boolean winn){
        win = winn;
    }

    public void agregarCard(){//UnoCard card){
        //for(int i = 0; i < 5; i++){
        myDeck = aux.entregarCartas();
        //deck.remove((int)(Math.random()* deck.size()-1))
        // }
    }
    public void sacarCarta(UnoCard card){
        myDeck.add(card);
    }

    public ArrayList<UnoCard> getCards(){
        return myDeck;
    }

    public void eliminarCard(UnoCard card){
        myDeck.remove(card);
    }

}
