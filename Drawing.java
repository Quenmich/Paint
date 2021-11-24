import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
//import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.EOFException;
import java.util.ArrayList;

public class Drawing extends JPanel implements MouseListener, MouseMotionListener{
    public Color c;
    public ArrayList<Figure> list= new ArrayList<>();
    public ArrayList<Figure> listD= new ArrayList<>();
    public int x;
    public int y;
    public String nameFigure;
    public Point Origin;
    public Point End;
    public Point Current;


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
        Current = new Point(cu.getX(), cu.getY());
        int widthD = Math.abs(Current.getX() - Origin.getX());
        int heightD = Math.abs(Current.getY() - Origin.getY());

        if (Current.getX() < Origin.getX()) {
            if (Current.getY() > Origin.getY()) {
                Origin = new Point(Current.getX(), Origin.getY()); // Changement du point d'origine
            } else {
                Origin = Current;
            }
        }

        if ((Current.getX() > Origin.getX()) && (Current.getY() < Origin.getY())) {
            Origin = new Point(Origin.getX(), Current.getY()); // Changement du point d'origine
        }

        if (nameFigure == "Rectangle"){
            Rectangle rectangle = new Rectangle(widthD,heightD,c,Origin);
            listD.add(rectangle);
        }

        if (nameFigure == "Square") {
            Square square = new Square(widthD,c,Origin);
            listD.add(square);
        }

        if (nameFigure == "Ellipse") {
            Ellipse ellipse = new Ellipse(widthD,heightD,c,Origin);
            listD.add(ellipse);
        }

        if (nameFigure == "Circle") {
            Circle circle = new Circle(widthD,c,Origin);
            listD.add(circle);
        }

        paintComponentDrag(this.getGraphics());

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
            Rectangle rectangle = new Rectangle(width,height,c,Origin);
            list.add(rectangle);
        }

        if (nameFigure == "Square") {
            Square square = new Square(width,c,Origin);
            list.add(square);
        }

        if (nameFigure == "Ellipse") {
            Ellipse ellipse = new Ellipse(width,height,c,Origin);
            list.add(ellipse);
        }

        if (nameFigure == "Circle") {
            Circle circle = new Circle(width,c,Origin);
            list.add(circle);
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
    public void paintComponentDrag(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < listD.size(); i++) {
            listD.get(listD.size()-1).draw(g);
            list.get(i).draw(g);
        }
    }
    public void recallDrawing(ArrayList<Figure> list2){
        this.list.clear();
        list=list2;
        paintComponent(this.getGraphics());
    }
    public void reset(){
        this.list.clear();
        paintComponent(this.getGraphics());
    }
    public void saveDrawing(){

    }

}
