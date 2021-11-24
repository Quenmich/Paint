import java.awt.Color;
import java.awt.*;

public class Square extends Rectangle{

    public Square (int px, Color c){
        super(px,px,c);
    }

    public Square (int px, Color c, Point p){
        super(px,px,c,p);
    }

    public void setBoundingBox (int heightBB, int widthBB){
        this.heightBB=heightBB;
        this.widthBB=heightBB;
    }

    public void setLength(int height) {
        this.height = height;
    }
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
    }
}
