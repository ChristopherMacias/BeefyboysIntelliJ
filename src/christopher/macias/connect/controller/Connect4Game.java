package christopher.macias.connect.controller;

import christopher.macias.connect.model.*;
import christopher.macias.connect.view.Connect4UI;
import christopher.macias.connect.view.ConsoleIO;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.util.Random;

public class Connect4Game {
    private Board board = new Board();
    private Player[] players = new Player[2];
    private Connect4UI connect4UI = new Connect4UI();
    private int whoTurn = 0;
    public Music music = new Music();
    ConsoleIO consoleIO = new ConsoleIO();
    private int yellowWins;
    private int redWins;





    public void run() throws IllegalArgumentException, IOException {
        Music.addSongs();
        boolean bootboot = true;
        while(bootboot) {
            bootboot = false;
            int select = connect4UI.displayMainMenu();
            switch (select) {
                case 1://human vs human
                    //instantiate player and humanPlayer objects

                    players[0] = new HumanPlayer();
                    players[1] = new HumanPlayer();
                    players[0].setTokenColor(TokenColor.Yellow);
                    players[0].setName(connect4UI.promptForPlayerName(0));
                    players[1].setTokenColor(TokenColor.Red);
                    players[1].setName(connect4UI.promptForPlayerName(1));
                    break;

                case 2://human vs AI
                    players[0] = new HumanPlayer();
                    players[1] = new AIPlayer();

                    players[0].setTokenColor(TokenColor.Yellow);
                    players[0].setName(connect4UI.promptForPlayerName(0));
                    players[1].setTokenColor(TokenColor.Red);
                    players[1].setName(connect4UI.promptForPlayerName(0));
                    break;

                case 3://AI vs AI
                    players[0] = new AIPlayer();
                    players[1] = new AIPlayer();

                    players[0].setTokenColor(TokenColor.Yellow);
                    players[0].setName(connect4UI.promptForPlayerName(0));
                    players[1].setTokenColor(TokenColor.Red);
                    players[1].setName(connect4UI.promptForPlayerName(0));
                    break;

                case 4:// Music
                    Music.currentSongs();
                    bootboot = true;
                    System.out.print("press next or prev to change songs.\n Pressing done will take you back to main menu\n");
                    boolean running =true;
                    while (running) {
                        switch (consoleIO.prompForString()) {
                            case "Prev":
                                System.out.println("Prev song");
                                Music.prevSong();
                                Music.currentSongs();


                            case "Next":
                                System.out.print("Next song");
                                Music.nextSong();
                                Music.currentSongs();

                            case "Done":
                                running = false;
                        }
                    }

                    break;

                case 5:
                    return;

            }



        }


        // assign color and give name

        boolean looping = true;

        while (looping) {
            // display the board
            System.out.println(board.toString());
            // deciding whose turn it is
            Player currentPlayer = players[whoTurn];
            boolean placeToken = false;
            do {

                int column = currentPlayer instanceof HumanPlayer ? connect4UI.selectColumn(currentPlayer) : randomlySelectColumn();
                try {
                    board.dropTokenColor(column, currentPlayer.getTokenColor());
                    placeToken = true;

                } catch (ArrayIndexOutOfBoundsException ex) {
                    placeToken = false;
                    if (currentPlayer instanceof HumanPlayer) {
                        connect4UI.displayColumnFull(column);
                    }
                }
            } while (!placeToken);
            //connect4UI.displayPlayersTurn(currentPlayer);
            //allowing the player to take their turn

            if (whoTurn == 0) {

                whoTurn = 1;

            } else {

                whoTurn = 0;
            }
            // checking of game is over (win or draw)
            if (board.checkForWin(TokenColor.Red, 0, 0)) {
                redWins++;
                System.out.println(board.toString());
                System.out.println(players[1].getName()+ " Won");
                System.out.println(players[1].getName()+ " Score: "+ yellowWins + " - " + redWins  +  " :Score "+ players[0].getName()  );
                looping = false;
                Music.stopSong();
                new Connect4Game().run();

            }
            if (board.checkForWin(TokenColor.Yellow, 0, 0)) {
                yellowWins++;
                System.out.println(board.toString());
                System.out.println(players[0].getName() + " Won");
                System.out.println(players[1].getName()+ " Score: "+ yellowWins + " - " + redWins +  " :Score "+ players[0].getName()  );
                looping = false;
                Music.stopSong();
                new Connect4Game().run();
            }



        }

    }


    private int randomlySelectColumn() {
        Random random = new Random();
        return random.nextInt(7);
    }
}
