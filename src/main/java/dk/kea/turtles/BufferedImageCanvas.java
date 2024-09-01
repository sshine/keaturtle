package dk.kea.turtles;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class BufferedImageCanvas extends JPanel implements TurtleCanvas {
    private BufferedImage image;

    public BufferedImageCanvas(int width, int height) {
        this.image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    }

    @Override
    public void drawLine(Color color, double x1, double y1, double x2, double y2) {
        Graphics2D g = this.image.createGraphics();
        g.setColor(color);
        g.setStroke(new BasicStroke(3));
        g.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
        g.dispose();
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.image, 0, 0, null);
    }
}