package Triangle_Algorithms;

import java.awt.Color;
import java.awt.Graphics;

import GraphicsObjects.Point3f;
import GraphicsObjects.Vector3f;

public class ParametricTriangle_color extends ParametricTriangle {

	private Color color;

	// Constructor with color parameter
	public ParametricTriangle_color (Point3f a, Point3f b, Point3f c, Color color) {
        super(a, b, c);
		this.color = color;
	}
	 

	// Draw and fill the triangle using parametric equation
	@Override
	public void drawTriangle(Graphics g) {
		if (A == null || B == null || C == null) {
			System.err.println("Error: The points of the triangle are not initialized correctly");
			return;
		}

		// Calculate the bounding box of the triangle
		int minX = Math.min(Math.min((int)A.x, (int)B.x), (int)C.x);
		int maxX = Math.max(Math.max((int)A.x, (int)B.x), (int)C.x);
		int minY = Math.min(Math.min((int)A.y, (int)B.y), (int)C.y);
		int maxY = Math.max(Math.max((int)A.y, (int)B.y), (int)C.y);

		// Calculate the area of the triangle
		float area = Math.abs((B.x - A.x) * (C.y - A.y) - (C.x - A.x) * (B.y - A.y));

		// Iterate through each pixel in the bounding box
		for (int x = minX; x <= maxX; x++) {
			for (int y = minY; y <= maxY; y++) {
				// Calculate barycentric coordinates
				float alpha = ((B.y - C.y) * (x - C.x) + (C.x - B.x) * (y - C.y)) / area;
				float beta = ((C.y - A.y) * (x - C.x) + (A.x - C.x) * (y - C.y)) / area;
				float gamma = 1 - alpha - beta;

				// If the point is inside the triangle
				if (alpha >= 0 && beta >= 0 && gamma >= 0) {
					// Use the specified color instead of interpolating based on barycentric coordinates
					setPixel(g, x, y, color.getRed() / 255f, color.getGreen() / 255f, color.getBlue() / 255f);
				}
			}
		}
	}

	// Set a pixel with the given color, adjusting for Swing's coordinate system
	private void setPixel(Graphics g, int x, int y, float R, float G, float B) {
		Color pixelColour = new Color(R, G, B);
		g.setColor(pixelColour);
		g.drawRect(x + 500, 500 + y, 1, 1); // + 500 offset is to make the
		// centre 0,0 at centre of the
		// screen
	}

	// Calculate the distance from a point to a line defined by two points
	public float Distance(Point3f Check, Point3f Beginning, Point3f End) {
		Vector3f line = End.MinusPoint(Beginning);
		Vector3f point = Check.MinusPoint(Beginning);
		Vector3f cross = line.cross(point);
		return cross.length() / line.length();
	}

}
