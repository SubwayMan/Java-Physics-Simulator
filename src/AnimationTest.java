import javax.swing.*;
import java.awt.*;

public class AnimationTest {


    int dimension = 600;
    static JFrame fr = new JFrame("ballz");






    public static void main(String[] args) {


        AnimationTest gui = new AnimationTest();
        gui.go();


    }

    public void go() {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setResizable(false);
        frame.setVisible(true);



        circleDrawer[] drawPanels = new circleDrawer[1];
        drawPanels[0] = new circleDrawer(Color.cyan, 30, 30, -2, 1);
//        drawPanels[1] = new circleDrawer(Color.MAGENTA, 400, 400, -1, -1);
        for (circleDrawer drawPanel : drawPanels) {
            frame.getContentPane().add(drawPanel);
        }



        while (true) {

            for (circleDrawer drawPanel : drawPanels) {
                drawPanel.repaint();
            }
            try {
                Thread.sleep(7);
            } catch (Exception e) {
                System.out.println("bad");
            }
        }

    }

    class circleDrawer extends JPanel {
        int x, y;
        int xincrement, yincrement;
        Color circleColor;

        public circleDrawer(Color col, int a, int b, int dir1, int dir2) {
            circleColor = col;
            x = a;
            y = b;
            xincrement = dir1;
            yincrement = dir2;
        }



        public void paintComponent(Graphics g) {

            x = x+xincrement;
            y = y+yincrement;



//            System.out.println(this.getWidth());
            if (x + 40 >= this.getWidth() || x <= 0) {
                xincrement *= -1;
            }

            if (y + 40 >= this.getHeight() || y <= 0) {
                yincrement *= -1;
            }


            g.setColor(Color.black);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            g.setColor(circleColor);
            g.fillOval(x, y, 40, 40);
        }
    }
}
