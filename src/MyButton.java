import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

public class MyButton extends JButton implements MouseListener{
    private Font defaultFont = new Font("Gill Sans MT",Font.BOLD,30);
    private Color textColor = Color.decode("#ffffff");
    private Color backgroundColor = Color.decode("#D22B2B");
    private Color hoverColor = Color.decode("#ffffff");
    private Color textHoverColor = Color.decode("#D22B2B");

    public MyButton(String s) {
        s = s.toUpperCase();
        this.setFocusPainted(false);
        this.setText(s);
        this.setBorder(null);
        this.setForeground(textColor);
        this.setBackground(backgroundColor);
        this.setFont(defaultFont);
        this.setOpaque(true);
        this.setSize(300, 70);
        addMouseListener(this);
    }

    @Override public void mouseClicked(MouseEvent me) {}
    @Override public void mouseReleased(MouseEvent me) {}
    @Override public void mousePressed(MouseEvent me) {}

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource()==this) {
            this.setBackground(this.hoverColor);
            this.setForeground(this.textHoverColor);
            this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
    }
    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource()==this) {
            this.setBackground(this.backgroundColor);
            this.setForeground(this.textColor);
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }
}