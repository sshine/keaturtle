package dk.kea.turtles;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class TurtleCanvas extends JPanel {
    private BufferedImage image;

    public TurtleCanvas(int width, int height) {
        this.image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    }

    public void drawLine(Color color, int x1, int y1, int x2, int y2) {
        Graphics2D g = this.image.createGraphics();
        g.setColor(color);
        g.setStroke(new BasicStroke(3));
        g.drawLine(x1, y1, x2, y2);
        g.dispose();
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.image, 0, 0, null);
    }
}