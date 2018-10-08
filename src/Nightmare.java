import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class Nightmare {
    private static JFrame frame = new JFrame("Nightmare Realm");
    private static JPanel rulesPanel = new JPanel();
    private static JPanel gamePanel = new JPanel();
    private static Blocks[][] blocks = Blocks.createBlocks();
    private static LinkedList<Blocks> topBlocks = Blocks.createTopBlocks();

    public static void main(String[] args) {

        rulesPanel.setPreferredSize(new Dimension(250, 150));
        rulesPanel.setLayout(new GridBagLayout());
        rulesPanel.setBackground(Color.GRAY);
        gamePanel.setLayout(new GridBagLayout());
        gamePanel.setBackground(Color.GRAY);
        frame.setLayout(new BorderLayout());
        toPrint(blocks, topBlocks);

        frame.add(rulesPanel, BorderLayout.NORTH);
        frame.add(gamePanel, BorderLayout.CENTER);


        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }

    private static GridBagConstraints setXY(int x, int y, int left) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(left, left, left, left);
        constraints.gridx = x;
        constraints.gridy = y;
        return constraints;
    }


    private static void toPrint(Blocks[][] blocks, LinkedList<Blocks> top) {
        rulesPanel.add(top.get(0), setXY(0, 1, 0));
        rulesPanel.add(top.get(1), setXY(2, 1, top.get(1).getWidhtBlocks()));
        rulesPanel.add(top.get(2), setXY(4, 1, 0));
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                gamePanel.add(blocks[i][j], setXY(i, j, 0));
            }
        }
    }

    protected static void replace(int startX, int startY, int finishX, int finishY) {
        try {

            Blocks startBlock = blocks[startX][startY];
            if (blocks[finishX][finishY].isEmpty()) {
                blocks[startX][startY] = blocks[finishX][finishY];
                blocks[finishX][finishY] = startBlock;
            }
        } catch (Exception e) {

        }
        frameUpdate();
    }

    private static void frameUpdate() {

        frame.remove(gamePanel);
        toPrint(blocks, topBlocks);
        frame.add(gamePanel);
        frame.pack();
        isWinner();

    }

    private static void isWinner() {
        boolean result = true;
        int winID = topBlocks.get(0).getID();
        for (int i = 0; i < 5; i++) {
            int currentID = blocks[0][i].getID();
            if (!(winID == currentID)) {
                result = false;
            }
        }
        winID = topBlocks.get(1).getID();
        for (int i = 0; i < 5; i++) {
            int currentID = blocks[2][i].getID();
            if (!(winID == currentID)) {
                result = false;
            }
        }
         winID = topBlocks.get(2).getID();
        for (int i = 0; i < 5; i++) {
            int currentID = blocks[4][i].getID();
            if (!(winID == currentID)) {
                result = false;
            }
        }
        if (result) {

            JFrame Jframe = new JFrame("Победа");
            JButton button = new JButton("Победа");
            button.setPreferredSize(new Dimension(200,50));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Jframe.dispose();
                    frame.dispose();
                }
            });
            Jframe.add(button);
            Jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            Jframe.pack();
            Jframe.setLocationRelativeTo(null);
            frame.setVisible(false);
            Jframe.setVisible(true);
            Jframe.setAlwaysOnTop(true);
        }
    }


}
