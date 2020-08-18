import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

class BWT{
    static Random r = new Random(233666);
}
class SL extends JButton implements ActionListener{
    static List<List<SL>> v = new ArrayList<>();
    int i, j;
    boolean boom;
    SL(int x, int y){
        super();
        i = x; j = y;
        this.addActionListener(this);
        if(BWT.r.nextInt(1000)%5 == 0) boom = true;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(boom){
            setText("B");
            System.out.println("Bomm! Shakalaka!");
        }else{
            int k = 0;
            if(i - 1 >= 0 && j - 1 >= 0) k += v.get(i - 1).get(j - 1).boom? 1: 0;
            if(i + 1 < 16 && j - 1 >= 0) k += v.get(i + 1).get(j - 1).boom? 1: 0;
            if(i - 1 >= 0 && j + 1 < 30) k += v.get(i - 1).get(j + 1).boom? 1: 0;
            if(i + 1 < 16 && j + 1 < 30) k += v.get(i + 1).get(j + 1).boom? 1: 0;
            if(i >= 0 && j - 1 >= 0) k += v.get(i).get(j - 1).boom? 1: 0;
            if(i >= 0 && j + 1 < 30) k += v.get(i).get(j + 1).boom? 1: 0;
            if(i - 1 >= 0 && j >= 0) k += v.get(i - 1).get(j).boom? 1: 0;
            if(i + 1 < 16 && j >= 0) k += v.get(i + 1).get(j).boom? 1: 0;
            setText(Integer.toString(k));
        }
    }
}
class Game extends JFrame{
    Game(){
        setSize(1800, 960);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(16, 30));
        for(int i = 0; i < 16; ++i){
            List<SL> temp = new ArrayList<>();
            for(int j = 0; j < 30; ++j){
                SL jb = new SL(i, j);
                add(jb);
                temp.add(jb);
            }
            SL.v.add(temp);
        }
        setVisible(true);
    }
}
public class JavaMine{
    public static void main(String[] args) throws Exception{
        new Game();
    }
}
