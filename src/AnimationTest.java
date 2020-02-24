import javax.swing.*;
import java.awt.*;

public class AnimationTest {


    int dimension = 600;
    static JFrame fr;






    public static void main(String[] args) {


        AnimationTest gui = new AnimationTest();
        gui.go();


    }

    public void go() {

        fr = new JFrame("ballz");;
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize((int)(dimension * (double)(4/3)), dimension);
        fr.setResizable(false);
        fr.setVisible(true);



        circleDrawer[] drawPanels = new circleDrawer[2];
        drawPanels[0] = new circleDrawer(Color.cyan, 30, 30, -2, 1);
        drawPanels[1] = new circleDrawer(Color.MAGENTA, 400, 400, -1, -1);
        backgroundDrawer b = new backgroundDrawer();
        fr.getContentPane().add(b);
        for (circleDrawer drawPanel : drawPanels) {
            fr.getContentPane().add(drawPanel);
//            System.out.println("tally");
        }




        while (true) {
            b.repaint();

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



            g.setColor(circleColor);
            g.fillOval(x, y, 40, 40);
        }
    }
    class backgroundDrawer extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            System.out.println("debug");
            g.setColor(Color.black);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
        }
    }
}
