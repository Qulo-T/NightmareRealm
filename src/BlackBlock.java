import javax.swing.*;
import java.awt.*;

public class BlackBlock extends Blocks {
    protected BlackBlock(Color color) {
        setPreferredSize(new Dimension(blocksDimension));
       // setBackground(color);
        setBorderPainted(false);
        setEnabled(false);
        ImageIcon icon = new ImageIcon("Black.png");
        setIcon(icon);
        setDisabledIcon(icon);
        setBackground(Color.GRAY);
    }
}
