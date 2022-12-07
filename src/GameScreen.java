import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.io.File;
import java.io.IOException;
public class GameScreen extends JFrame{

    JLabel placeLabel = new JLabel(), pointsLabel = new JLabel();
    Integer points, counter;
    GameScreen() {

        points = 0;
        counter = 0;

        setSize(1280, 1024);
        setTitle("PolGuessr");

        try {
            setIconImage(new ImageIcon(ImageIO.read(new File("resources/userPin.png"))).getImage());
        } catch (IOException e) {
            e.printStackTrace();
        }

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        try {
            setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("resources/gameScreen.png")))));
        } catch (IOException e) {
            e.printStackTrace();
        }

        MyButton nextPlace = new MyButton("ZATWIERDŹ");
        nextPlace.setLocation(490, 880);
        add(nextPlace);

        UserPin userPin = new UserPin();
        add(userPin);
        userPin.setVisible(false);

        CorrectPin correctPin = new CorrectPin();
        add(correctPin);
        correctPin.setVisible(false);

        placeLabel.setText("Wskaż miasto " + correctPin.placeName);
        placeLabel.setSize(1200, 100);
        placeLabel.setLocation(20, 20);
        placeLabel.setFont(new Font("Gill Sans MT",Font.BOLD,40));
        add(placeLabel);

        pointsLabel.setText("Punkty: " + points);
        pointsLabel.setSize(300, 100);
        pointsLabel.setLocation(20, 860);
        pointsLabel.setFont(new Font("Gill Sans MT",Font.BOLD,40));
        add(pointsLabel);

        setVisible(true);

        addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                if(userPin.moveable) {
                    userPin.placed = true;
                    userPin.xPos = e.getX() - 20;
                    userPin.yPos = e.getY() - 70;
                    userPin.setLocation(userPin.xPos, userPin.yPos);
                    userPin.setVisible(true);
                }
            }
        });

        nextPlace.addActionListener(e -> {
            if (correctPin.nextPlace){

                if (counter >= 5){
                    setVisible(false);
                    new ScoreScreen(points);
                }
                else {
                    userPin.placed = false;
                    userPin.moveable = true;
                    correctPin.setVisible(false);
                    nextPlace.setText("SPRAWDŹ");
                    correctPin.generateNextPlace();
                    placeLabel.setText("Wskaż miasto " + correctPin.placeName);
                    correctPin.nextPlace = false;
                    userPin.setVisible(false);
                }
            }
            else {
                if (userPin.placed) {
                    userPin.moveable = false;
                    correctPin.setLocation(correctPin.xPos, correctPin.yPos);
                    correctPin.setVisible(true);
                    nextPlace.setText("DALEJ");
                    correctPin.nextPlace = true;
                    double d = Point2D.distance(userPin.xPos, userPin.yPos, correctPin.xPos, correctPin.yPos) * 0.83720;
                    int pointsForDistance = 1000 - (2 * (int)d);
                    if (pointsForDistance < 0) pointsForDistance = 0;
                    points += pointsForDistance;
                    pointsLabel.setText("Punkty " + points);
                    placeLabel.setText("<html>Miasto " + correctPin.placeName + " znjaduje się " + (int)d + "km od twojego znacznika." +
                            "<br/> Otrzymujesz " + pointsForDistance + " punktów</html>");
                    counter++;
                }
            }
        });
    }
}
