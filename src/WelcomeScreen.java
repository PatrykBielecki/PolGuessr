import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class WelcomeScreen extends JFrame{

    WelcomeScreen() {

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
            setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("resources/welcomeScreen.png")))));
        } catch (IOException e) {
            e.printStackTrace();
        }

        MyButton goToGameScreen = new MyButton("START");
        goToGameScreen.setLocation(80, 20);
        add(goToGameScreen);

        MyButton goToInstructionScreen = new MyButton("INSTRUKCJA");
        goToInstructionScreen.setLocation(490, 20);
        add(goToInstructionScreen);

        MyButton exit = new MyButton("WYJŚCIE");
        exit.setLocation(900, 20);
        add(exit);

        setVisible(true);

        goToGameScreen.addActionListener(e -> {
            setVisible(false);
            new GameScreen();
        });

        goToInstructionScreen.addActionListener(e -> {
            setVisible(false);
            new InstructionScreen().setVisible(true);
        });

        exit.addActionListener(e -> {
            setVisible(false);
            dispose();
            System.exit(0);
        });

    }
}
