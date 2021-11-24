import java.awt.Color;
import java.awt.*;

public class Ellipse extends Figure{
    public int width=0;
    public int height=0;
    public int widthBB;
    public int heightBB;

    public Ellipse (int px, int py, Color c){
        super(c, new Point(4,8));
        setSemiAxisX(px);
        setSemiAxisY(py);
        this.setBoundingBox(px,py);
    }
    public Ellipse (int px, int py, Color c, Point p){
        super(c, p);
        setSemiAxisX(px);
        setSemiAxisY(py);
        this.setBoundingBox(px,py);
        this.origin=p;

    }
    public void setBoundingBox (int heightBB, int widthBB){
        this.heightBB=heightBB;
        this.widthBB=widthBB;
    }

    public void setSemiAxisX(int width) {
        this.width = width;
    }
    public void setSemiAxisY(int height) {
        this.height = height;
    }

    public void getPerimeter(){
    }
    public void getSurface(){
    }

    @Override
    public String toString() {
        return "("+width+","+height+","+color+")";}

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(origin.getX(),origin.getY(),width,height);
    }
}