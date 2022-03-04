package christopher.macias.connect.view;

import christopher.macias.connect.model.Board;
import christopher.macias.connect.model.Player;

import java.io.IOException;


public class Connect4UI {
    ConsoleIO consoleIO = new ConsoleIO();

    public int displayMainMenu() throws IOException {
        ConsoleIO consoleIO = new ConsoleIO();
        while (true) {
            System.out.println(
                    "1 - Human vs Human\n" +
                            "2 - Human vs computer\n" +
                            "3 - computer vs computer\n" +
                            "4 - Music list\n"+
                            "5 - Close Game "
            );
            int selection = consoleIO.promptForInt(1, 6);

            return selection;



        }
    }

    public int selectColumn(Player currentPlayer) throws IOException {
        System.out.println(currentPlayer.getName() + " select your column (1-" + Board.Count_Columns + ")");
        int selection = consoleIO.promptForInt(1, Board.Count_Columns);
        return selection - 1;
    }

    public String promptForPlayerName(int i) throws IOException {

        String makingAName = consoleIO.prompForString("please enter a Name:");


        return makingAName;
    }

    public void displayColumnFull(int column) {
        System.out.println(column);
    }

    public int tryAgain() throws IOException {

        System.out.println(
                "1 - Play Again\n" +
                        "2 - Main Menu\n" +
                        "3 - Score Board\n" +
                        "4 - Exit"
        );
        return consoleIO.promptForInt(1, 3);



    }


}

