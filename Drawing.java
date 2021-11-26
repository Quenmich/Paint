import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Drawing extends JPanel implements MouseListener, MouseMotionListener{
    public Color c;
    public ArrayList<Figure> list= new ArrayList<>();
    public int x;
    public int y;
    public String nameFigure;
    public Point Origin;
    public Point End;


    public Drawing() {
        addMouseListener(this);//Constructeur

    }
    public void setColor(Color c) {
        this.c = c;}

    public void setNameFigure (String nameFigure){
        this.nameFigure=nameFigure;
    }

    public ArrayList<Figure> getList(){
        return (list);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent cu) {
    }

    public void mouseMoved(MouseEvent e) {
    }
    @Override
    public void mousePressed(MouseEvent o) {
        Origin = new Point (o.getX(),o.getY());
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        End = new Point(e.getX(), e.getY());
        int width = Math.abs(End.getX() - Origin.getX());
        int height = Math.abs(End.getY() - Origin.getY());

        if (End.getX() < Origin.getX()) {
            if (End.getY() > Origin.getY()) {
                Origin = new Point(End.getX(), Origin.getY()); // Changement du point d'origine
            } else {
                Origin = End;
            }
        }

        if ((End.getX() > Origin.getX()) && (End.getY() < Origin.getY())) {
            Origin = new Point(Origin.getX(), End.getY()); // Changement du point d'origine
        }

        if (nameFigure=="Rectangle"){
            Rectangle re = new Rectangle(width,height,c,Origin);
            list.add(re);
        }

        if (nameFigure == "Square") {
            Square sq = new Square(width,c,Origin);
            list.add(sq);
        }

        if (nameFigure == "Ellipse") {
            Ellipse el = new Ellipse(width,height,c,Origin);
            list.add(el);
        }

        if (nameFigure == "Circle") {
            Circle ci = new Circle(width,c,Origin);
            list.add(ci);
        }
        paintComponent(this.getGraphics());

    }
    @Override
    public void mouseEntered(MouseEvent e) {

    }
    @Override
    public void mouseExited(MouseEvent e) {

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for (int i=0;i<list.size();i++) {
            list.get(i).draw(g);
        }
    }

    public void recallDrawing(ArrayList<Figure> listOpen){
        this.list.clear();
        list=listOpen;
        paintComponent(this.getGraphics());
    }
    public void reset(){
        this.list.clear();
        paintComponent(this.getGraphics());
    }
    public void saveDrawing(){

    }

}
