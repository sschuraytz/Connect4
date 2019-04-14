package Connect4Game;

public class PlayGame {

    public static void main(String[] args) {

        Connect4Frame connect4Frame = new Connect4Frame();
        connect4Frame.setVisible(true);
    }

    //TODO - #1
    // abstraction - break up the methods and factor out repeated code for winCheck (vertical, horizontal, diagonal)
    // if (winner) - END game - DON'T LET THEM KEEP PLAYING and say who won
    // TODO - #2
    // Animate piece falling
    // TODO - #3 (optional)
    // Create header/title for the game
}