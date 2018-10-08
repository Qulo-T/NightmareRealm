
import javax.swing.*;
import java.awt.*;


public class GreyBlock extends Blocks {

     GreyBlock(Color color) {
        setPreferredSize(blocksDimension);
      //  setBackground(color);
        setBorderPainted(false);
        setEmpty(true);
        setEnabled(false);
        setIcon(new ImageIcon("Empty.png"));
        setBackground(Color.GRAY);

    }
}
