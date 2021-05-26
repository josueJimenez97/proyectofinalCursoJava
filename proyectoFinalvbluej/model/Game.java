package model;

import java.awt.*;
import java.util.ArrayList;

public class Game implements UnoGame {
    private Player [] players;
    private ArrayList<UnoCard> deck;
    private int direction;
    private ArrayList<UnoCard> cementerio;
    private Player jugadorTurno;
    private int posicionJugTurno;
    private Player champion;
    private boolean cartaCargada;

    public Game(){
        agregarJugadores();
        posicionJugTurno = 0;
        jugadorTurno = players[posicionJugTurno];
        direction = 1;
        deck = new ArrayList();
        agregarAllCards();
        cementerio = new ArrayList();
        shuffle();
        cementerio.add(deck.remove(0));
        Player champion = null;
        cartaCargada = false;
        asignarCartasPlayers();
    }

    private void asignarCartasPlayers(){
        /*players[0].agregarCard();
        players[1].agregarCard();
        players[2].agregarCard();
        players[3].agregarCard();*/
        int pos=0;
        int cont=0;
        while(cont<28){
            int rand= (int)(Math.random()*deck.size());
            players[pos].sacarCarta(deck.remove(rand));
            cont++;
            if(cont%7==0){
                pos++;
            }
        }
    }

    private void agregarJugadores(){
        players = new Player[4];
        players[0]= new Player("JUGADOR 1");
        players[1]= new Player("JUGADOR 2");
        players[2]= new Player("JUGADOR 3");
        players[3]= new Player("JUGADOR 4");
    }

    private void agregarAllCards(){
        agregarCommonCards(Color.BLUE);
        agregarCommonCards(Color.RED);
        agregarCommonCards(Color.GREEN);
        agregarCommonCards(Color.YELLOW);
        agregarSpecialCards();
    }

    @Override

    public Player whoWin() {
        if(champion == null){
            for(int i = 0; i < players.length; i ++){
                if(players[i].getWinner()){
                    champion = players[i];
                }
            }
        }
        return champion;
    }

    @Override
    public ArrayList<UnoCard> getCardsCurrentPlayer(){
        return jugadorTurno.getCards();
    }

    @Override
    public ArrayList<Player> getPlayers() {
        ArrayList<Player> jugadores = new ArrayList();
        for(int i = 0; i<players.length; i ++){
            jugadores.add(players[i]);
        }
        return jugadores;
    }

    @Override
    public UnoCard getCurrentCard() {
        return cementerio.get(cementerio.size()-1);
    }

    @Override
    public Player getCurrentTurn() {
        return jugadorTurno;
    }

    @Override
    public boolean dropCard(UnoCard card){
        boolean res = false;
        UnoCard drop = cementerio.get(cementerio.size()-1);
        if(!card.getValue().equals("C")){
            System.out.println("estamos dropeando");
            //System.out.println("card: "+card.getValue()+" drop :"+drop.getValue());
            //System.out.println("card: "+card.getColor()+" drop :"+drop.getColor());
            if(card.getValue().equals(drop.getValue())||card.getColor()==drop.getColor()){
                jugadorTurno.eliminarCard(card);
                if(card.getValue().equals("R")){
                    direction= direction==0? 1: 0;
                }
                cartaCargada=true;
                nextTurn();
                System.out.println(jugadorTurno.getName());
                
                if(card.getValue().equals("+2")){
                    loadCard();
                    cartaCargada = false;
                    loadCard();
                }
                cementerio.add(card);
                res = true;
            }
        }else{
            jugadorTurno.eliminarCard(card);
            res = true;
            cartaCargada=true;
            nextTurn();
        }
        return res; 
    }

    @Override
    public void loadCard() {
        if(!cartaCargada){
            //jugadorTurno.agregarCard(deck.remove(0));
            int rand= (int)(Math.random()*deck.size());
            jugadorTurno.sacarCarta(deck.remove(rand));
            cartaCargada = true;
        }
    }

    @Override
    public boolean nextTurn() {
        boolean res = false;
        if(cartaCargada && champion == null){
            if(direction == 0){
                posicionJugTurno --; 
                if(posicionJugTurno == -1){
                    posicionJugTurno = 3;
                }
            }else if(direction == 1){
                posicionJugTurno ++;
                posicionJugTurno %= 4;
            }
            jugadorTurno = players[posicionJugTurno];
            res = true;
            cartaCargada = false;
        }

        return res;
    }

    @Override
    public int sizeDeck() {
        return deck.size();
    }

    /*
     * 0 -> Izquierda
     * 1 -> Derecha
     */
    @Override
    public int getDirection() {
        return direction;
    }

    @Override
    public void shuffle() {
        System.out.println(cementerio);
        int help = cementerio.size()-1;
        if(deck.isEmpty() == true){
            for(int i = 0; i < help; i ++){
                int aux = (int)Math.random()*(help);
                deck.add(cementerio.remove(aux));
            }
        }

    }

    private void agregarCommonCards(Color color){
        int cont = 0;
        int help = 1;
        //String value = String.valueOf(help);

        deck.add(new Card("0",color));

        while(cont < 2){
            for(int i = 1; i < 10; i++){
                deck.add(new Card(""+i,color));
                //help++;
            }
            cont++;
        }
    }

    private void agregarSpecialCards(){
        for(int i = 0; i < 4; i++){
            deck.add(new Card("C",Color.BLACK));}
        for(int i = 0; i < 2; i++){
            deck.add(new Card("R",Color.BLUE));
            deck.add(new Card("+2",Color.BLUE));
            deck.add(new Card("R",Color.RED));
            deck.add(new Card("+2",Color.RED));
            deck.add(new Card("R",Color.YELLOW));
            deck.add(new Card("+2",Color.YELLOW));
            deck.add(new Card("R",Color.GREEN));
            deck.add(new Card("+2",Color.GREEN));

        }
    }
}

