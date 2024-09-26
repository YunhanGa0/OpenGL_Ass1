package Line_Algorithms;

import java.awt.Color;
import java.awt.Graphics;

import GraphicsObjects.Point3f;

public class ExplicitLine {
	
	Point3f Start;
	Point3f End;
	float slope; 
	 
	public ExplicitLine(Point3f Start, Point3f End) { 
		this.Start = Start;
		this.End = End;
		slope = getSlope(); // you need to implement this before the class will compile 
	}
	
	// Implement and comment what the method does
	public float getSlope()
	{
		if (End.x - Start.x == 0) {
			return Float.POSITIVE_INFINITY; // 垂直线
		}
		return (End.y - Start.y) / (End.x - Start.x);
	}
	
	// Implement in Explicit form, and comment what the method does
	public void drawLine(Graphics g)
	{
		int x1 = Math.round(Start.x);
		int y1 = Math.round(Start.y);
		int x2 = Math.round(End.x);
		int y2 = Math.round(End.y);
		
		if (Math.abs(slope) <= 1) {
			// 以x为主导轴
			for (int x = Math.min(x1, x2); x <= Math.max(x1, x2); x++) {
				int y = Math.round(slope * (x - x1) + y1);
				setPixel(g, x, y);
			}
		} else {
			// 以y为主导轴
			for (int y = Math.min(y1, y2); y <= Math.max(y1, y2); y++) {
				int x = Math.round((y - y1) / slope + x1);
				setPixel(g, x, y);
			}
		}
	}
	
	//I have implemented this method to adapt Swings coordinate system 
	public void setPixel(Graphics g,int x,int y)  
	{
		g.drawRect(x+500, 500-y, 1,1);  // + 500 offset is to make the centre 0,0 at centre of the screen 
		  
	}

}
