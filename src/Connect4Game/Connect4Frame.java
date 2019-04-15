package Connect4Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static Connect4Game.Connect4Component.SQUARE_SIZE;

public class Connect4Frame extends JFrame implements MouseListener {

    int mouseClickCounter = 0;
    private Connect4Component connect4Component = new Connect4Component();
    private JLabel welcome = new JLabel("Connect 4 Instructions");
    private JLabel instructions = new JLabel("Be the first player to get four pieces in a row horizontally, vertically or diagonally.");
    private JLabel winnerLabel = new JLabel( " ");

    static final int NR_ROW = 6;
    static final int NR_COL = 7;
    

    public Connect4Frame() {
        setTitle("Connect 4");
        setSize(NR_ROW * 105, (NR_COL + 1) * 110);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel root = new JPanel();
        root.setLayout(new BoxLayout(root, BoxLayout.Y_AXIS));

        JPanel labels = new JPanel();
        labels.setLayout(new BoxLayout(labels, BoxLayout.PAGE_AXIS));
        designHeader(labels);
        root.add(labels);

        JPanel board = new JPanel();
        board.setLayout(new BoxLayout(board, BoxLayout.LINE_AXIS));
        designBoard(board);
        root.add(board);

        setContentPane(root);
        root.addMouseListener(this);
    }

    public void designHeader(JPanel labels) {
        welcome.setFont(new Font("", Font.BOLD, 24));
        welcome.setForeground(Color.BLUE);
        welcome.setAlignmentX(Component.CENTER_ALIGNMENT);
        labels.add(welcome);

        instructions.setAlignmentX(Component.CENTER_ALIGNMENT);
        labels.add(instructions);

        winnerLabel.setFont(new Font("",  Font.PLAIN, 24));
        winnerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        labels.add(winnerLabel);

    }

    public void designBoard(JPanel board) {
        for (int row = 0; row < NR_ROW; row++) {
            for (int col = 0; col < NR_COL; col++) {
                board.add(connect4Component);
            }
        }
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
            connect4Component.board2.makeBackEndMove(who, col, winnerLabel);

            //change graphic image
            connect4Component.pieces.add(new Point(row, col));
            repaint();
        }
    }

    public int getColNumber(int x_coord) {

        int newBorder = getWidth() - (SQUARE_SIZE * NR_COL);
        int col1_end = newBorder /2 + 1 * SQUARE_SIZE;
        int col2_end = newBorder /2 + 2 * SQUARE_SIZE;
        int col3_end = newBorder /2 + 3 * SQUARE_SIZE;
        int col4_end = newBorder /2 + 4 * SQUARE_SIZE;
        int col5_end = newBorder /2 + 5 * SQUARE_SIZE;
        int col6_end = newBorder /2 + 6 * SQUARE_SIZE;
        int col7_end = newBorder /2 + 7 * SQUARE_SIZE;


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
