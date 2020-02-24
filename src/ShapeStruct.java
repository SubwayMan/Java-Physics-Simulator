import java.awt.*;
public abstract class ShapeStruct {

    public int xMomentum;
    public int yMomentum;
    public int x;
    public int y;
    public int width;
    public int height;
    public Color col;

    public ShapeStruct(int x, int y, int width, int height, Color col){

        this(x, y, width, height, col, 0, 0);

    }

    public ShapeStruct(int x, int y, int width, int height, Color col, int xMomentum, int yMomentum) {

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.col = col;
        this.xMomentum = xMomentum;
        this.yMomentum = yMomentum;

    }

    public abstract void ShapeExec();




}
