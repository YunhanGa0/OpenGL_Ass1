package Line_Algorithms;

import java.awt.Color;
import java.awt.Graphics;

import GraphicsObjects.Point3f;
import GraphicsObjects.Vector3f;

public class ImplicitLine {

	Point3f Start;
	Point3f End;

	public ImplicitLine(Point3f Start, Point3f End) {
		this.Start = Start;
		this.End = End;

	}

	// Implement in Explict form , Extra marks for reducing the search space
	// before you draw the line , and comment what the method does 
	public void drawLine(Graphics g) {
		int x1 = Math.round(Start.x);
		int y1 = Math.round(Start.y);
		int x2 = Math.round(End.x);
		int y2 = Math.round(End.y);
		
		int dx = Math.abs(x2 - x1);
		int dy = Math.abs(y2 - y1);
		
		int minX = Math.min(x1, x2);
		int maxX = Math.max(x1, x2);
		int minY = Math.min(y1, y2);
		int maxY = Math.max(y1, y2);
		
		if (dx > dy) {
			for (int x = minX; x <= maxX; x++) {
				for (int y = minY; y <= maxY; y++) {
					if (Math.abs(Distance(new Point3f(x, y, 0), Start, End)) < 0.5f) {
						setPixel(g, x, y);
					}
				}
			}
		} else {
			for (int y = minY; y <= maxY; y++) {
				for (int x = minX; x <= maxX; x++) {
					if (Math.abs(Distance(new Point3f(x, y, 0), Start, End)) < 0.5f) {
						setPixel(g, x, y);
					}
				}
			}
		}
	}

	 
	//implement Distance formulas using your notes , and comment what the method does
	public float Distance(Point3f Check, Point3f Beginning, Point3f End) {
		Vector3f line = End.MinusPoint(Beginning);
		Vector3f point = Check.MinusPoint(Beginning);
		Vector3f cross = line.cross(point);
		return cross.length() / line.length();
	}

	// I have implemented this method to adapt Swings coordinate system
	public void setPixel(Graphics g, int x, int y) {
		g.drawRect(x + 500, 500 + y, 1, 1); // + 500 offset is to make the
											// centre 0,0 at centre of the
											// screen

	}

}
