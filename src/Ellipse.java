import java.awt.*;

public class Ellipse extends ShapeStruct {

    int diameter;

    public Ellipse(int x, int y, int width, Color col){

        super(x, y, width, 0, col, 0, 0);

    }
    public Ellipse(int x, int y, int width, Color col, int xMomentum, int yMomentum){

        super(x, y, width, 0, col, xMomentum, yMomentum);

    }

    public int[] getData(){
        int[] shapedata = {x, y, width, height};
        return shapedata;
    }

    public Color getColor(){
        return col;
    }

    @Override
    public void ShapeExec() {

        x += xMomentum;
        y += yMomentum;


    }

}
