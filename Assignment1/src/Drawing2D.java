import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import GraphicsObjects.Point3f;
import Line_Algorithms.ExplicitLine;
import Line_Algorithms.ImplicitLine;
import Line_Algorithms.ParametricLine;
import Triangle_Algorithms.ParametricTriangle_color;
import Triangle_Algorithms.ParametricTriangle;

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

        // Add some grass on the grass
        drawGrass(g);

        // Draw house body (now with two floors)
        drawRectangleWithTriangles(g, 200, 250, 400, 300, new Color(210, 180, 140));
        
        // Draw second floor
        drawRectangleWithTriangles(g, 220, 200, 360, 100, new Color(200, 170, 130));



        // Draw door
        drawRectangleWithTriangles(g, 370, 400, 60, 150, new Color(101, 67, 33));
        drawRectangleWithTriangles(g, 410, 470, 10, 10, Color.YELLOW);  // Door knob

        // Draw windows on the first floor
        drawRectangleWithTriangles(g, 260, 350, 80, 80, Color.WHITE);
        drawRectangleWithTriangles(g, 480, 350, 80, 80, Color.WHITE);

        // Draw windows on the second floor
        drawRectangleWithTriangles(g, 260, 220, 60, 60, Color.WHITE);
        drawRectangleWithTriangles(g, 500, 220, 60, 60, Color.WHITE);



        // Draw balcony
        drawRectangleWithTriangles(g, 340, 250, 140, 20, new Color(180, 150, 110));
        
        // Draw balcony railing
        for (int i = 0; i < 7; i++) {
            int x = 350 + i *20;
            new ParametricLine(new Point3f(x, 250, 0), new Point3f(x, 230, 0)).drawLine(g);
        }
        new ParametricLine(new Point3f(340, 230, 0), new Point3f(480, 230, 0)).drawLine(g);


        // Draw window crosses
        g.setColor(Color.BLACK);
        // First floor windows
        new ExplicitLine(new Point3f(260, 390, 0), new Point3f(340, 390, 0)).drawLine(g);
        new ImplicitLine(new Point3f(300, 350, 0), new Point3f(300, 430, 0)).drawLine(g);
        new ParametricLine(new Point3f(480, 390, 0), new Point3f(560, 390, 0)).drawLine(g);
        new ExplicitLine(new Point3f(520, 350, 0), new Point3f(520, 430, 0)).drawLine(g);
        // Second floor windows
        new ExplicitLine(new Point3f(260, 250, 0), new Point3f(320, 250, 0)).drawLine(g);
        new ImplicitLine(new Point3f(290, 220, 0), new Point3f(290, 280, 0)).drawLine(g);
        new ParametricLine(new Point3f(500, 250, 0), new Point3f(560, 250, 0)).drawLine(g);
        new ExplicitLine(new Point3f(530, 220, 0), new Point3f(530, 280, 0)).drawLine(g);

        // Draw sun
        drawSun(g, 700, 100, 80);

        // Draw trees
        drawTree(g, 100, 450);
        drawTree(g, 700, 430);

        // Draw chimney
        drawRectangleWithTriangles(g, 500, 90, 40, 100, Color.GRAY);

        // Draw roof using parametric triangle
        ParametricTriangle_color roof = new ParametricTriangle_color(
                new Point3f(180, 200, 0),
                new Point3f(400, 50, 0),
                new Point3f(620, 200, 0),
                Color.pink
        );
        roof.drawTriangle(g);

    }

    // Draw a tree at the specified position
    private void drawTree(Graphics g, int x, int y) {
        // Draw tree trunk
        drawRectangleWithTriangles(g, x - 10, y, 20, 80, new Color(101, 67, 33));
        
        // Draw tree leaves (three triangles)
        for (int i = 0; i < 3; i++) {
            ParametricTriangle leaf = new ParametricTriangle(
                new Point3f(x - 50, y - i * 30, 0),
                new Point3f(x, y - 60 - i * 30, 0),
                new Point3f(x + 50, y - i * 30, 0)
            );
            leaf.drawTriangle(g);
        }
    }

    // Draw a rectangle using two triangles
    private void drawRectangleWithTriangles(Graphics g, int x, int y, int width, int height, Color color) {
        ParametricTriangle_color triangle1 = new ParametricTriangle_color(
            new Point3f(x, y, 0),
            new Point3f(x + width, y, 0),
            new Point3f(x, y + height, 0),
            color
        );
        ParametricTriangle_color triangle2 = new ParametricTriangle_color(
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

    // New method: Draw grass
    private void drawGrass(Graphics g) {
        Color darkGreen = new Color(0, 100, 0);
        for (int i = 0; i < 50; i++) {
            int x = (int) (Math.random() * 800);
            int y = (int) (Math.random() * 150) + 450;
            int height = (int) (Math.random() * 20) + 10;

            ParametricLine grass1 = new ParametricLine(new Point3f(x, y, 0), new Point3f(x - 5, y - height, 0));
            ParametricLine grass2 = new ParametricLine(new Point3f(x, y, 0), new Point3f(x + 5, y - height, 0));
            grass1.drawLine(g);
            grass2.drawLine(g);
            g.setColor(darkGreen);
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
