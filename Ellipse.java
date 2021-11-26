import java.awt.Color;
import java.awt.*;

public class Ellipse extends Figure{
    public int widthBB;
    public int heightBB;
    protected int semiAxysX;
    protected int semiAxysY;

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
    public void getPerimeter(){
    }
    public void getSurface(){
    }

    public void setBoundingBox (int heightBB, int widthBB){
        this.heightBB=heightBB;
        this.widthBB=widthBB;
    }

    public void setSemiAxisX(int semiAxysX) {
        this.semiAxysX = semiAxysX;
    }
    public void setSemiAxisY(int semiAxysY) {
        this.semiAxysY = semiAxysY;
    }

    @Override
    public String toString() {
        return "("+semiAxysX+","+semiAxysY+","+color+")";}

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(origin.getX(),origin.getY(),semiAxysX,semiAxysY);
    }
}