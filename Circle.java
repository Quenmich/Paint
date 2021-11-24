import java.awt.Color;
import java.awt.*;

public class Circle extends Ellipse{

    public Circle (int px, Color c){
        super(px,px,c);
    }

    public Circle (int px, Color c, Point p){
        super(px,px,c,p);
    }

    public void setBoundingBox (int heightBB, int widthBB){
        this.heightBB=heightBB;
        this.widthBB=heightBB;
    }

    public void setSemiAxisX(int width) {
        this.width = width;
    }
    public void setSemiAxisY(int height) {
        this.height = height;
    }

    @Override
    public void draw(Graphics g){
        super.draw(g);
    }
}

