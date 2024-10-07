package Triangle_Algorithms;

import java.awt.Color;
import java.awt.Graphics;

import GraphicsObjects.Point3f;
import GraphicsObjects.Vector3f;

public class ParametricTriangle {

    Point3f A;
    Point3f B;
    Point3f C;

    public ParametricTriangle(Point3f a, Point3f b, Point3f c) {
        this.A = a;
        this.B = b;
        this.C = c;
    }


    // Use parametric equations to draw triangles and fill them with color
    public void drawTriangle(Graphics g) {
        // Calculate the bounding box of the triangle
        int minX = Math.min(Math.min((int)A.x, (int)B.x), (int)C.x);
        int maxX = Math.max(Math.max((int)A.x, (int)B.x), (int)C.x);
        int minY = Math.min(Math.min((int)A.y, (int)B.y), (int)C.y);
        int maxY = Math.max(Math.max((int)A.y, (int)B.y), (int)C.y);

        // Calculate the area of the triangle
        float area = Math.abs((B.x - A.x) * (C.y - A.y) - (C.x - A.x) * (B.y - A.y));

        // Iterate over each pixel in the bounding box
        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                // Calculates the center of gravity coordinates
                float alpha = ((B.y - C.y) * (x - C.x) + (C.x - B.x) * (y - C.y)) / area;
                float beta = ((C.y - A.y) * (x - C.x) + (A.x - C.x) * (y - C.y)) / area;
                float gamma = 1 - alpha - beta;

                // If the point is inside the triangle
                if (alpha >= 0 && beta >= 0 && gamma >= 0) {
                    // Uses the center of gravity coordinates to interpolate the color
                    float R = alpha;
                    float G = beta;
                    float B = gamma;

                    setPixel(g, x, y, R, G, B);
                }
            }
        }
    }

    // An implemented method to adapt to Swing's coordinate system
    private void setPixel(Graphics g, int x, int y, float R, float G, float B) {
        Color pixelColour = new Color(R, G, B);
        g.setColor(pixelColour);
        g.drawRect(x + 500, 500 + y, 1, 1); // + 500 offset is to make the
        // centre 0,0 at centre of the
        // screen
    }

    //implement Distance formulas using your notes , and comment what the method does
    public float Distance(Point3f Check, Point3f Beginning, Point3f End) {
        Vector3f line = End.MinusPoint(Beginning);
        Vector3f point = Check.MinusPoint(Beginning);
        Vector3f cross = line.cross(point);
        return cross.length() / line.length();
    }

}
