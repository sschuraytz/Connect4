package Connect4Game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Connect4Component extends JComponent {

    static final int SQUARE_SIZE = 85;
    static final int BORDER_SPACE = 30;
    int width = Connect4Frame.NR_COL * SQUARE_SIZE;
    int height = Connect4Frame.NR_ROW * SQUARE_SIZE;

    public ArrayList<Point> pieces = new ArrayList<>();
    public Board board2 = new Board();

    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        drawBoard(graphics);


        boolean who;

        for (Point piece : pieces) {
            if (pieces.indexOf(piece) % 2 == 0) {
                who = Player.RED_PLAYER;
            } else {
                who = Player.YELLOW_PLAYER;
            }
            drawCirclePiece(graphics, who, piece.x, piece.y);

            if (pieces.indexOf(piece) == pieces.size()) {

            }
        }
    }

    public void drawBoard(Graphics graphics) {
        graphics.setColor(Color.BLUE.darker());
        graphics.fill3DRect(BORDER_SPACE /2, BORDER_SPACE /2 + SQUARE_SIZE, width + BORDER_SPACE /2,
                height + BORDER_SPACE /2, true);

        graphics.setColor(Color.BLACK);
        for (int row = 1; row < Connect4Frame.NR_ROW + 1; row++) {
            for (int col = 0; col < Connect4Frame.NR_COL; col++) {
                graphics.fillOval(BORDER_SPACE + col * SQUARE_SIZE, BORDER_SPACE + row * SQUARE_SIZE,
                        SQUARE_SIZE - BORDER_SPACE /2, SQUARE_SIZE - BORDER_SPACE /2);
            }
        }
    }

    public void drawCirclePiece(Graphics graphics, boolean who, int row, int col) {

        if (who == Player.RED_PLAYER) {
            graphics.setColor(Color.RED);
        }
        else {
            graphics.setColor(Color.YELLOW);
        }
        graphics.fillOval(col * SQUARE_SIZE + BORDER_SPACE,
                (row + 1) * SQUARE_SIZE + BORDER_SPACE,
                SQUARE_SIZE - BORDER_SPACE /2,
                SQUARE_SIZE - BORDER_SPACE /2);
    }
}