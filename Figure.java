import java.awt.*;
import java.io.Serializable;

public abstract class Figure implements Serializable {
    protected Color color;
    public Point origin;

    public Figure(Color c, Point p) {   //Constructeur
        this.color = c;
        this.origin = p;
    }

    public void getPerimeter(){
    }
    public void getSurface(){
    }

    public Figure(Color c) {   //Constructeur
        this.color = c;
    }

    public abstract void setBoundingBox (int heightBB, int widthBB);

    public abstract void draw (Graphics g);


    @Override
    public String toString() {
        return "("+color+","+origin+")";}
}
