import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class UserPin extends JLabel {

    public int xPos=0, yPos=0;
    boolean moveable = true, placed = false;
    UserPin() {
        try {
            setIcon(new ImageIcon(ImageIO.read(new File("resources/userPin.png"))));
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        setSize(25,40);
    }

    UserPin(boolean onlyImage) {
        try {
            setIcon(new ImageIcon(ImageIO.read(new File("resources/userPin.png"))));
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        setSize(25,40);
        setVisible(onlyImage);
    }


}
