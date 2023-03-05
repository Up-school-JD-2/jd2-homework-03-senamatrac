package org.senamatrac.hw3.question1;

public class Player {
    public String name;
    public int guessCount = 0;
    public int wins = 0;

    public Player(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }


}
