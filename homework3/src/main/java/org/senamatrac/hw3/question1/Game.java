package org.senamatrac.hw3.question1;

import java.util.Objects;
import java.util.Scanner;

public class Game {
    static Player[] players;
    static boolean gameFinished = false;
    static Scanner sc = new Scanner(System.in);

    static void enterPlayerCount() {
        System.out.print("Enter player count: ");
        int playerNumber = sc.nextInt();
        while (playerNumber < 1) {
            System.out.println("It is should be 1 player at least!.");
            System.out.print("Please enter player count: ");
            playerNumber = sc.nextInt();
        }
        players = new Player[playerNumber];
    }

    static void enterPlayers() {
        for (int i = 0; i < players.length; i++) {
            System.out.print((i + 1) + ". player's name:  ");
            String name = sc.next();
            players[i] = new Player(name);
        }
    }

    static int generateRandomNumber(int min, int max) {
        int range = max - min + 1;
        return min + (int) (Math.random() * range);
    }

    static void roundStart() {
        boolean founded = false;
        int randomNumber = generateRandomNumber(1, 100);
        Scanner sc = new Scanner(System.in);

        //Her kullanıcının tahmin sayısı sıfırdan başlatılır.
        for (Player player : players) {
            player.guessCount = 0;
        }

        while (!founded) {  //Continue, until the number is guessed.
            for (Player player : players) { // All players make a guess one-by-one.
                player.guessCount++;
                System.out.print(player.name + ", it is your turn : (" + randomNumber + ")");
                int number = sc.nextInt();

                if (number == randomNumber) { // the number is founded.
                    founded = true;
                    player.wins++;
                    System.out.println("\u001B[31m" + player.name + "\u001B[0m" + " won. Guess count: "+ player.guessCount);

                    break;// the answer is guessed this round finished
                } else if (number < randomNumber) {
                    System.out.printf(" -> Too low, " + player.name + " try later.%n");
                } else {
                    System.out.printf(" -> Too high, " + player.name + " try later.%n");
                }
            }
        }
    }

    static void displayLeaderboard(int gameCount) {
        System.out.println("**********" + "\u001B[36m" + " LEADERBOARD of "+gameCount+ " games " + "\u001B[0m" + "*********");
        for (Player player : players) {
            System.out.println("-->" + player.name + " won " + player.wins + " games.");
        }
    }

    public static void main(String[] args) {
        System.out.println("Have fun!");
        Game.enterPlayerCount();
        Game.enterPlayers();

        int roundCount = 0;

        while (!gameFinished) { //Continue until game is finished.
            System.out.println("------- Round " + ++roundCount + " is started -------");
            Game.roundStart();
            System.out.printf("\nDo you want to play of return match: (y/n) ");
            Scanner sc = new Scanner(System.in);
            String answer = sc.next();

            if (Objects.equals(answer, "n")) {
                gameFinished = true;
            }
        }

        Game.displayLeaderboard(roundCount);
        System.out.println("see you soon :).");
    }
}