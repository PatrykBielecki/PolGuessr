import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class InstructionScreen extends JFrame{
    InstructionScreen() {

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
            setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("resources/instructionScreen.png")))));
        } catch (IOException e) {
            e.printStackTrace();
        }

        MyButton backToWelcomeScreen = new MyButton("POWRÓT");
        backToWelcomeScreen.setLocation(80, 20);
        add(backToWelcomeScreen);

        setVisible(true);

        backToWelcomeScreen.addActionListener(e -> {
            setVisible(false);
            new WelcomeScreen();
        });

    }

}
