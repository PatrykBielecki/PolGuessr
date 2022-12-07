import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class ScoreScreen extends JFrame{

    JLabel pointsLabel = new JLabel();
    String fileName = "wyniki.txt";
    ScoreScreen(Integer points) {

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
            setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("resources/scoreScreen.png")))));
        } catch (IOException e) {
            e.printStackTrace();
        }

        double efficiency = ((double)points / 5000) * 100;
        pointsLabel.setText("<html>Zebrane punkty: " + points + "<br/>" + (int)efficiency + "% skuteczności</html>");
        pointsLabel.setSize(550, 100);
        pointsLabel.setLocation(440, 300);
        pointsLabel.setFont(new Font("Gill Sans MT",Font.BOLD,40));
        add(pointsLabel);

        MyButton goToWelcomeScreen = new MyButton("MENU");
        goToWelcomeScreen.setLocation(80, 20);
        add(goToWelcomeScreen);

        MyButton saveScore = new MyButton("ZAPISZ WYNIK");
        saveScore.setLocation(490, 20);
        add(saveScore);

        MyButton exit = new MyButton("WYJŚCIE");
        exit.setLocation(900, 20);
        add(exit);

        setVisible(true);

        goToWelcomeScreen.addActionListener(e -> {
            setVisible(false);
            new WelcomeScreen();
        });

        saveScore.addActionListener(e -> {
            String s = JOptionPane.showInputDialog("Podaj nazwę użytkownika");
            printToFile(fileName, "Użytkownik: " + s + "\n Wynik: "
                    + points + "\n\n\n");

            saveScore.setEnabled(false);
        });

        exit.addActionListener(e -> {
            setVisible(false);
            dispose();
            System.exit(0);
        });

        setVisible(true);

    }

    public static void printToFile (String fileName, String message) {

        try {
            File outfile = new File(fileName);

            if (!outfile.exists()) {
                System.out.println("No file exists...writing a new file");
                outfile.createNewFile();

            }
            FileWriter fw = new FileWriter(outfile.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(message);

            bw.flush();
            bw.close();

            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
