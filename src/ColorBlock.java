
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorBlock extends Blocks {
    private static ColorBlock actionBlock;


    protected ColorBlock(Color color) {
        setPreferredSize(new Dimension(blocksDimension));
        setBackground(Color.GRAY);
        setBorderPainted(false);
        if (color == Color.RED) {
            setID(1);
            setIcon(new ImageIcon("Red.png"));

        } else if (color == Color.green) {
            setID(2);
            setIcon(new ImageIcon("Green.png"));

        } else if (color == Color.BLUE) {
            setID(3);
            setIcon(new ImageIcon("Blue.png"));

        } else {
            setID(0);
        }
        addMouseListener(new ColorListener());

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {

                actionBlock = (ColorBlock) KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
                int startX = actionBlock.getX() / actionBlock.getWidhtBlocks();
                int startY = actionBlock.getY() / actionBlock.getWidhtBlocks();

                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    Nightmare.replace(startX, startY, startX, startY - 1);
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {

                    Nightmare.replace(startX, startY, startX, startY + 1);
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    Nightmare.replace(startX, startY, startX - 1, startY);
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    Nightmare.replace(startX, startY, startX + 1, startY);
                }

                actionBlock.requestFocus(true);
            }
        });
    }


    public class ColorListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            actionBlock = (ColorBlock) e.getSource();
            actionBlock.setFocusable(true);
        }


    }
}
