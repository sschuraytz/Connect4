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
        // in case of window resize
        int newBorder = (getWidth() - (SQUARE_SIZE * Connect4Frame.NR_COL));

        graphics.setColor(Color.BLUE.darker());
        graphics.fill3DRect(newBorder/2 - 7,
                            BORDER_SPACE /2,
                            width + BORDER_SPACE /2,
                            height + BORDER_SPACE /2, true);

        graphics.setColor(Color.BLACK);
        for (int row = 0; row < Connect4Frame.NR_ROW; row++) {
            for (int col = 0; col < Connect4Frame.NR_COL; col++) {
                graphics.fillOval(newBorder/2 + col * SQUARE_SIZE + 7,
                                BORDER_SPACE + row * SQUARE_SIZE,
                                SQUARE_SIZE - BORDER_SPACE /2,
                                SQUARE_SIZE - BORDER_SPACE /2);
            }
        }
    }

    public void drawCirclePiece(Graphics graphics, boolean who, int row, int col) {
        int BorderSpaceNew = (getWidth() - (SQUARE_SIZE * Connect4Frame.NR_COL));

        if (who == Player.RED_PLAYER) {
            graphics.setColor(Color.RED);
        }
        else {
            graphics.setColor(Color.YELLOW);
        }
        graphics.fillOval(col * SQUARE_SIZE + BorderSpaceNew/2 + 7,
                        (row) * SQUARE_SIZE + BORDER_SPACE,
                        SQUARE_SIZE - BORDER_SPACE /2,
                        SQUARE_SIZE - BORDER_SPACE /2);
    }
}