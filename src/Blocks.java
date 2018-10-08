import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.LinkedList;

public abstract class Blocks extends JButton {

    private boolean isEmpty = false;
    private int widht = 50;
    private int height = widht;
    private int ID; //1-RED  2-Green 3-Blue
    public Dimension blocksDimension = new Dimension(widht,height);

    private static Blocks[][] toPlace(LinkedList<Blocks> color, LinkedList<Blocks> black1, LinkedList<Blocks> black3){
        Blocks[][] blocks = new Blocks[5][5];
        int k = 0;
        for (int i = 0; i <5 ; i+=2) {
            for (int j = 0; j <5 ; j++) {
                blocks[i][j]=color.get(k);
                k++;
            }
        }
        for (int i = 0; i <5 ; i++) {
            blocks[1][i] = black1.get(i);
        }
        for (int i = 0; i <5 ; i++) {
            blocks[3][i] = black3.get(i);
        }


        return  blocks;
    }

    public static Blocks[][] createBlocks(){
        Blocks[][] blocks;
        LinkedList<Blocks> ColorColumn = createColorList();
        LinkedList<Blocks> BlackColumn1 = createBlackList();
        LinkedList<Blocks> BlackColumn3 = createBlackList();
        for (int i = 0; i <2 ; i++) {
            BlackColumn1.add(ColorColumn.get(0));
            ColorColumn.remove(0);
        }
        for (int i = 0; i <2 ; i++) {
            BlackColumn3.add(ColorColumn.get(0));
            ColorColumn.remove(0);
        }
        Collections.shuffle(BlackColumn3);
        Collections.shuffle(BlackColumn1);
        blocks = toPlace(ColorColumn,BlackColumn1,BlackColumn3);


        return blocks;
    }
    private static LinkedList<Blocks> createColorList(){
        LinkedList<Blocks> list = new LinkedList<>();
        for (int i = 0; i <5 ; i++) {
            list.add(new ColorBlock(Color.BLUE));
        }
        for (int i = 0; i <5 ; i++) {
            list.add(new ColorBlock(Color.green));
        }
        for (int i = 0; i <5 ; i++) {
            list.add(new ColorBlock(Color.RED));
        }
        for (int i = 0; i <4 ; i++) {
            list.add(new GreyBlock(Color.gray));
        }
        Collections.shuffle(list);
        return list;
    }
    private static LinkedList<Blocks> createBlackList(){
        LinkedList<Blocks> list = new LinkedList<>();
        for (int i = 0; i <3 ; i++) {
            list.add(new BlackBlock(Color.BLACK));
        }
        return list;
    }
    public static LinkedList<Blocks> createTopBlocks(){
        LinkedList<Blocks> blocks = new LinkedList<>();
        blocks.add(new ColorBlock(Color.RED));
        blocks.add(new ColorBlock(Color.green));
        blocks.add(new ColorBlock(Color.BLUE));
        for (int i = 0; i <blocks.size() ; i++) {
          //  blocks.get(i).setEnabled(false);
        }
        Collections.shuffle(blocks);
        return blocks;
    }



    public int getWidhtBlocks() {
        return widht;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
}
