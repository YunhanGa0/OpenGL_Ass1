import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import GraphicsObjects.Point3f;
import Line_Algorithms.ExplicitLine;
import Line_Algorithms.ImplicitLine;
import Line_Algorithms.ParametricLine;
import Triangle_Algorithms.ParametricTriangle;
import Triangle_Algorithms.ParametricTriangle1;

/*
 * 
 * This class to test your work and for you to make lines to draw your house , it will not compile till all the methods are complete in the other classes 
 * 
 */
public class Drawing2D extends JPanel {

    public Drawing2D() {
        setBackground(Color.WHITE);
    }

    public void paintComponent(Graphics g) {
        // Get the width and height of the window
        int width = getWidth();
        int height = getHeight();

        super.paintComponent(g);

        g.setColor(Color.BLACK);
        
        drawHouse(g);
    }

    // Draw a coordinate system for reference
    private void drawCoordinateSystem(Graphics g) {
        int centerX = 1300;
        int centerY = 700;

        g.setColor(Color.LIGHT_GRAY);

        // Draw vertical lines
        for (int x = -1300; x <= 1300; x += 100) {
            g.drawLine(centerX + x, 0, centerX + x, 1400);
        }

        // Draw horizontal lines
        for (int y = -700; y <= 700; y += 100) {
            g.drawLine(0, centerY - y, 2600, centerY - y);
        }

        // Draw coordinate axes
        g.setColor(Color.BLACK);
        g.drawLine(0, centerY, 2600, centerY);  // X-axis
        g.drawLine(centerX, 0, centerX, 1400);  // Y-axis

        // Add scale markings
        g.setColor(Color.BLACK);
        for (int i = -1300; i <= 1300; i += 100) {
            if (i != 0) {
                g.drawString(Integer.toString(i), centerX + i, centerY);  // X-axis scale
            }
        }
        for (int i = -700; i <= 700; i += 100) {
            if (i != 0) {
                g.drawString(Integer.toString(i), centerX, centerY - i);  // Y-axis scale
            }
        }

        // Mark the origin
        g.drawString("O", centerX, centerY);
    }

    // Draw the complete house scene
    private void drawHouse(Graphics g) {
        // Draw sky
        drawRectangleWithTriangles(g, 0, 0, 800, 400, new Color(135, 206, 235));

        // Draw grass
        drawRectangleWithTriangles(g, 0, 400, 800, 200, new Color(34, 139, 34));

        // Draw house body
        drawRectangleWithTriangles(g, 200, 250, 400, 300, new Color(210, 180, 140));

        // Draw chimney
        drawRectangleWithTriangles(g, 500, 150, 40, 100, Color.GRAY);

        // Draw roof using parametric triangle
        ParametricTriangle1 roof = new ParametricTriangle1(
            new Point3f(200, 250, 0),
            new Point3f(400, 100, 0),
            new Point3f(600, 250, 0)
        );
        roof.drawTriangle(g);

        // Draw door
        drawRectangleWithTriangles(g, 370, 400, 60, 150, new Color(101, 67, 33));

        // Draw doorknob
        drawRectangleWithTriangles(g, 410, 470, 10, 10, Color.YELLOW);

        // Draw windows
        drawRectangleWithTriangles(g, 260, 300, 80, 80, Color.WHITE);
        drawRectangleWithTriangles(g, 480, 300, 80, 80, Color.WHITE);

        // Draw window crosses
        g.setColor(Color.BLACK);
        new ExplicitLine(new Point3f(260, 340, 0), new Point3f(340, 340, 0)).drawLine(g);
        new ImplicitLine(new Point3f(300, 300, 0), new Point3f(300, 380, 0)).drawLine(g);
        new ParametricLine(new Point3f(480, 340, 0), new Point3f(560, 340, 0)).drawLine(g);
        new ExplicitLine(new Point3f(520, 300, 0), new Point3f(520, 380, 0)).drawLine(g);

        // Draw sun
        drawSun(g, 700, 100, 80);

        // Draw trees
        drawTree(g, 100, 450);
        drawTree(g, 700, 430);
    }

    // Draw a tree at the specified position
    private void drawTree(Graphics g, int x, int y) {
        // Draw tree trunk
        drawRectangleWithTriangles(g, x - 10, y, 20, 80, new Color(101, 67, 33));
        
        // Draw tree leaves (three triangles)
        for (int i = 0; i < 3; i++) {
            ParametricTriangle1 leaf = new ParametricTriangle1(
                new Point3f(x - 50, y - i * 30, 0),
                new Point3f(x, y - 60 - i * 30, 0),
                new Point3f(x + 50, y - i * 30, 0)
            );
            leaf.drawTriangle(g);
        }
    }

    // Draw a rectangle using two triangles
    private void drawRectangleWithTriangles(Graphics g, int x, int y, int width, int height, Color color) {
        ParametricTriangle triangle1 = new ParametricTriangle(
            new Point3f(x, y, 0),
            new Point3f(x + width, y, 0),
            new Point3f(x, y + height, 0),
            color
        );
        ParametricTriangle triangle2 = new ParametricTriangle(
            new Point3f(x + width, y, 0),
            new Point3f(x + width, y + height, 0),
            new Point3f(x, y + height, 0),
            color
        );

        triangle1.drawTriangle(g);
        triangle2.drawTriangle(g);
    }

    // Draw the sun with rays
    private void drawSun(Graphics g, int centerX, int centerY, int size) {
        Color sunColor = Color.YELLOW;
        Color rayColor = new Color(255, 255, 0, 150); // Semi-transparent yellow
        
        // Draw sun body (square)
        int halfSize = size / 2;
        drawRectangleWithTriangles(g, centerX - halfSize, centerY - halfSize, size, size, sunColor);
        
        // Add sun rays using ParametricLine
        int rayLength = size / 2;
        for (int i = 0; i < 8; i++) {
            double angle = Math.PI * i / 4;
            int x1 = (int) (centerX + halfSize * Math.cos(angle));
            int y1 = (int) (centerY + halfSize * Math.sin(angle));
            int x2 = (int) (centerX + (halfSize + rayLength) * Math.cos(angle));
            int y2 = (int) (centerY + (halfSize + rayLength) * Math.sin(angle));
            
            ParametricLine ray = new ParametricLine(
                new Point3f(x1, y1, 0),
                new Point3f(x2, y2, 0)
            );
            
            // Temporarily change Graphics color to draw rays
            Color originalColor = g.getColor();
            g.setColor(rayColor);
            ray.drawLine(g);
            g.setColor(originalColor);
        }
    }

    public static void main(String[] args) {
        Drawing2D panel = new Drawing2D();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("2D Drawing Application");
        frame.setSize(1000, 1000);
        frame.setVisible(true);
        frame.add(panel);
    }
}
