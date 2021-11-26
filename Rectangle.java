import java.awt.Color;
import java.awt.*;

public class Rectangle extends Figure{
    public int width=0;
    public int height=0;
    public int heightBB;
    public int widthBB;

    public Rectangle (int px, int py, Color c){
        super(c);
        setLength(py);
        setWidth(px);
        this.setBoundingBox(px,py);

    }
    public Rectangle (int px, int py, Color c, Point p){
        super(c, p);
        setLength(py);
        setWidth(px);
        this.setBoundingBox(px,py);
        this.origin=p;

    }
    public void setBoundingBox (int heightBB, int widthBB){
        this.heightBB=heightBB;
        this.widthBB=widthBB;
    }

    public void setLength(int height) {
        this.height = height;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getWidth() {
        return width;
    }
    public int getLength() {
        return height;
    }

    @Override
    public String toString() {
        return "("+width+","+height+","+color+")";}

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(origin.getX(),origin.getY(),width,height);
    }
}
