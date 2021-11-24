import java.io.Serializable;

public class Point implements Serializable {
    private int X;
    private int Y;

    public Point() {   //Constructeur
        this.X = 0;
        this.Y = 0;
    }

    public Point(int a, int b) {
        this.X=a;
        this.Y=b;
    }

    public int getX() {
        return X;
    }
    public int getY() {
        return Y;
    }
}
