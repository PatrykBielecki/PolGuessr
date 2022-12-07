import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class CorrectPin extends JLabel{

    public int xPos=500, yPos=500;
    public boolean nextPlace = false;
    public String placeName;

    private String[] placeNameArr = {"Świnoujście", "Słupsk", "Elbląg", "Grudziądz", "Włocławek", "Łomża", "Siedlce",
            "Leszno", "Kalisz", "Legnica", "Chełm", "Tarnobrzeg", "Żory", "Tarnów", "Krosno", "Koszalin", "Gdańsk",
            "Szczecin", "Olsztyn", "Bydgoszcz", "Białystok", "Poznań", "Warszawa", "Łódź", "Wrocław", "Lublin",
            "Kielce", "Opole", "Katowice", "Rzeszów", "Kraków", "Toruń"
    };

    private Integer[] xPosArr = {231, 453, 640, 587, 617, 852, 872, 418, 538, 383, 963, 822, 586, 767,
            830, 406, 581, 275, 744, 524, 934, 433, 767, 637, 431, 884, 731, 510, 585, 853, 678, 570
    };

    private Integer[] yPosArr = {207, 133, 173, 263, 371, 305, 435, 474, 486, 555, 562, 633, 698, 703,
            743, 151, 148, 223, 228, 299, 315, 376, 424, 483, 539, 544, 583, 598, 649, 697, 706, 333
    };

    CorrectPin() {
        try {
            setIcon(new ImageIcon(ImageIO.read(new File("resources/correctPin.png"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setSize(25,40);
        generateNextPlace();
    }

    public void generateNextPlace(){

        Random rand = new Random();
        int n = rand.nextInt(32);
        if(placeName == placeNameArr[n]) n = rand.nextInt(32);
        placeName = placeNameArr[n];
        xPos = xPosArr[n];
        yPos = yPosArr[n];

    }

}
