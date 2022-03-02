package christopher.macias.connect;

import christopher.macias.connect.controller.Connect4Game;


import java.io.IOException;

public class Connect4 {
    public static void main(String[] args) throws IOException {
        Connect4Game connect4 = new Connect4Game();
        connect4.run();
    }

}
