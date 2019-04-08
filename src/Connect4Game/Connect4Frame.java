package Connect4Game;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static Connect4Game.Connect4Component.SQUARE_SIZE;
import static Connect4Game.Connect4Component.BORDER_SPACE;

public class Connect4Frame extends JFrame implements MouseListener {

    int mouseClickCounter = 0;
    private Connect4Component connect4Component = new Connect4Component();

    static final int NR_ROW = 6;
    static final int NR_COL = 7;
    int col1_end = BORDER_SPACE /2 + 1 * SQUARE_SIZE;
    int col2_end = BORDER_SPACE /2 + 2 * SQUARE_SIZE;
    int col3_end = BORDER_SPACE /2 + 3 * SQUARE_SIZE;
    int col4_end = BORDER_SPACE /2 + 4 * SQUARE_SIZE;
    int col5_end = BORDER_SPACE /2 + 5 * SQUARE_SIZE;
    int col6_end = BORDER_SPACE /2 + 6 * SQUARE_SIZE;
    int col7_end = BORDER_SPACE /2 + 7 * SQUARE_SIZE;

    public Connect4Frame() {
        setTitle("Connect 4");
        setSize(NR_ROW * 110, (NR_COL + 1) * 110);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel root = new JPanel();
        root.setLayout(new BoxLayout(root, BoxLayout.LINE_AXIS));

        for (int row = 0; row < NR_ROW; row++) {
            for (int col = 0; col < NR_COL; col++) {
                root.add(connect4Component);
            }
        }
        setContentPane(root);
        root.addMouseListener(this);
    }

    public Boolean getPlayer(int mouseClickCounter) {
        Boolean who;
        if (mouseClickCounter % 2 == 0) {
            who = Player.YELLOW_PLAYER;
        }
        else {
            who = Player.RED_PLAYER;
        }
        return who;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        int x_coord = e.getX();
        int col = getColNumber(x_coord);

        if(connect4Component.board2.canMove(col)) {

            mouseClickCounter++;
            Boolean who = getPlayer(mouseClickCounter);

            int row = connect4Component.board2.getRowNumber(col);

            //change cell status
            connect4Component.board2.makeBackEndMove(who, col);

            //change graphic image
            makeGraphicMove(who, row, col);
            }
        }

    public int getColNumber(int x_coord) {
        int col = 0;

        if (x_coord < col1_end) {
            col = 0;
        }
        else if (x_coord < col2_end) {
            col = 1;
        }
        else if (x_coord < col3_end) {
            col = 2;
        }
        else if (x_coord < col4_end) {
            col = 3;
        }
        else if (x_coord < col5_end) {
            col = 4;
        }
        else if (x_coord < col6_end) {
            col = 5;
        }
        else if (x_coord < col7_end) {
            col = 6;
        }
        return col;
    }

    public void makeGraphicMove(boolean who, int y_start, int x_start) {
        connect4Component.drawCirclePiece(who, y_start, x_start);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e){
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}

