import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

public class Window extends JFrame {
    public Window(String Title,int x,int y){ // Création du constructeur qui créé une fenêtre
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame(Title);
        JPanel panelButton = new JPanel();
        Container contentPanel = this.getContentPane();

        // Barre des menus
        JMenuBar menubar = new JMenuBar();  //Création barre des menus

        // Création d'un nouveau dessin
        Drawing drawing = new Drawing();

        // Création Menu File
        JMenu menu1 = new JMenu("File"); // Nouveau menu File


        JMenuItem Open = new JMenuItem("Open"); //Nouvel Item menu Open
        Open.addActionListener(e -> {
            JFileChooser OpenFile = new JFileChooser("C:\\Users\\qmich\\OneDrive\\Bureau\\ENSEA\\2EME ANNEE\\Informatique\\JAVA\\IdeaProjects\\Paint\\Dessins");
            OpenFile.showOpenDialog(Open);
            try{
                ArrayList<Figure> listOpen = new ArrayList<>();
                String fileName = OpenFile.getSelectedFile().getAbsolutePath();
                FileInputStream fis = new FileInputStream(fileName);
                ObjectInputStream ois = new ObjectInputStream(fis);

                int totFigure = ois.readInt();
                for (int i = 0; i < totFigure; i++) {
                    Figure figure = (Figure) ois.readObject();
                    listOpen.add(figure);
                }
                System.out.println(listOpen);
                drawing.recallDrawing(listOpen);
                ois.close();
            }
            catch (Exception e2){
                e2.printStackTrace();
            }

        });

        menu1.add(Open);

        JMenuItem New = new JMenuItem("New"); //Nouvel Item menu New
        New.addActionListener(e -> drawing.reset());
        menu1.add(New);

        JMenuItem Save = new JMenuItem("Save"); //Nouvel Item menu Save
        Save.setAccelerator(KeyStroke.getKeyStroke('S', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx(), false));
        Save.addActionListener(e -> {
            JFileChooser save = new JFileChooser("C:\\Users\\qmich\\OneDrive\\Bureau\\ENSEA\\2EME ANNEE\\Informatique\\JAVA\\IdeaProjects\\Paint\\Dessins");
            save.showSaveDialog(Save);
            try{
                ArrayList<Figure> listSave;
                listSave = drawing.getList();
                String nameFile = save.getSelectedFile().getAbsolutePath();
                FileOutputStream fos = new FileOutputStream(nameFile);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeInt(listSave.size());
                for (Figure figure : listSave) {
                    oos.writeObject(figure);
                }
                oos.close();
            }
            catch (Exception e2){
                e2.printStackTrace();
            }
        });
        menu1.add(Save);

        JMenuItem Quit = new JMenuItem("Quit"); //Nouvel Item menu Quit
        Quit.addActionListener(e -> System.exit(0));
        menu1.add(Quit);

        menubar.add(menu1);

        // Création Menu A Propos
        JMenu menu2 = new JMenu("About"); // Nouveau menu A propos
        JMenuItem sousmenu2 = new JMenu("Author");
        JButton buttonAuthor = new JButton("Author Name");
        buttonAuthor.addActionListener(e -> {
            String authorName = JOptionPane.showInputDialog(getParent(),"What is your name ?", null);
            buttonAuthor.setText(authorName);
        });
        sousmenu2.add(buttonAuthor); //Ajout de item createur à sousmenu2
        menu2.add(sousmenu2);  //Ajout de sousmenu2 à menu2
        menubar.add(menu2);

        // Création des boutons
        JButton buttonBlack = new JButton("Black");
        buttonBlack.setBackground(Color.BLACK);
        buttonBlack.setForeground(Color.WHITE);
        buttonBlack.addActionListener(e -> drawing.setColor(Color.BLACK));

        JButton buttonRed = new JButton("Red");
        buttonRed.setBackground(Color.RED);
        buttonRed.addActionListener(e -> drawing.setColor(Color.RED));

        JButton buttonGreen = new JButton("Green");
        buttonGreen.setBackground(Color.GREEN);
        buttonGreen.addActionListener (e -> drawing.setColor(Color.GREEN));

        JButton buttonBlue = new JButton("Blue");
        buttonBlue.setBackground(Color.BLUE);
        buttonBlue.setForeground(Color.WHITE);
        buttonBlue.addActionListener(e -> drawing.setColor(Color.BLUE));

        JButton buttonEllipse = new JButton("Ellipse");
        buttonEllipse.addActionListener(e -> drawing.setNameFigure("Ellipse"));

        JButton buttonCircle = new JButton("Circle");
        buttonCircle.addActionListener(e -> drawing.setNameFigure("Circle"));

        JButton buttonYellow = new JButton("Yellow");
        buttonYellow.setBackground (Color.YELLOW);
        buttonYellow.addActionListener(e -> drawing.setColor(Color.YELLOW));

        JButton buttonPink = new JButton("Pink");
        buttonPink.setBackground(Color.PINK);
        buttonPink.addActionListener(e -> drawing.setColor(Color.PINK));

        JButton buttonMagenta = new JButton("Magenta");
        buttonMagenta.setBackground(Color.MAGENTA);
        buttonMagenta.addActionListener(e -> drawing.setColor(Color.MAGENTA));

        JButton buttonOrange = new JButton("Orange");
        buttonOrange.setBackground(Color.ORANGE);
        buttonOrange.addActionListener(e -> drawing.setColor(Color.ORANGE));

        JButton buttonRectangle = new JButton("Rectangle");
        buttonRectangle.addActionListener(e -> drawing.setNameFigure("Rectangle"));

        JButton buttonSquare = new JButton("Square");
        buttonSquare.addActionListener(e -> drawing.setNameFigure("Square"));

        // Création du panelButton
        panelButton.setLayout(new GridLayout(2,6));
        panelButton.add(buttonBlack);
        panelButton.add(buttonRed);
        panelButton.add(buttonGreen);
        panelButton.add(buttonBlue);
        panelButton.add(buttonEllipse);
        panelButton.add(buttonCircle);
        panelButton.add(buttonYellow);
        panelButton.add(buttonPink);
        panelButton.add(buttonMagenta);
        panelButton.add(buttonOrange);
        panelButton.add(buttonRectangle);
        panelButton.add(buttonSquare);



        contentPanel.add(menubar, BorderLayout.NORTH);
        contentPanel.add(drawing);
        contentPanel.add(panelButton, BorderLayout.SOUTH);

        frame.add(contentPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(x,y);
    }

    public static void main (String[] args){
        new Window("Paint",800,600);
    }
}

