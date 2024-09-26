import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import GraphicsObjects.Point3f;
import Line_Algorithms.ExplicitLine;
import Line_Algorithms.ImplicitLine;
import Line_Algorithms.ParametricLine;
import Triangle_Algorithms.ParametricTriangle;

/*
 * 
 * This class to test your work and for you to make lines to draw your house , it will not compile till all the methods are complete in the other classes 
 * 
 */
public class Drawing2D extends JPanel {

	public Drawing2D() // set up graphics window
	{
		setBackground(Color.WHITE);

	}

	public void paintComponent(Graphics g) // draw graphics in the panel
	{
		int width = getWidth(); // width of window in pixels
		int height = getHeight(); // height of window in pixels

		// as swing starts at 0 , 0 , will need to modify drawing

		super.paintComponent(g); // call superclass to make panel display
									// correctly

		g.setColor(Color.BLACK);
		
		//line test code 
		/*
		ExplicitLine FirstLine = new ExplicitLine(new Point3f(0, 0, 0), new Point3f(200, 100, 0));
		ImplicitLine SecondLine = new ImplicitLine(new Point3f(0, 0, 0), new Point3f(200, 200, 0)); // 200
		ParametricLine ThirdLine = new ParametricLine(new Point3f(0, 0, 0), new Point3f(75, 200, 0));
		
		FirstLine.drawLine(g);
		SecondLine.drawLine(g);
		ThirdLine.drawLine(g);
		*/
		// Remove the comments for Explicit line and test it ,
		/*
		ExplicitLine FirstLine = new ExplicitLine(new Point3f(0, 0, 0), new Point3f(200, 100, 0));
		ExplicitLine SecondLine = new ExplicitLine(new Point3f(0, 0, 0), new Point3f(200, 200, 0)); // 200
		ExplicitLine ThirdLine = new ExplicitLine(new Point3f(0, 0, 0), new Point3f(75, 200, 0));
		ExplicitLine FourthLine = new ExplicitLine(new Point3f(0, 0, 0), new Point3f(25, 200, 0));

		FirstLine.drawLine(g);
		SecondLine.drawLine(g);
		ThirdLine.drawLine(g);
		FourthLine.drawLine(g);

		// */

		// Remove the comments for Implicit line and test it
		/*
		ImplicitLine FirstLine = new ImplicitLine(new Point3f(0, 0, 0), new Point3f(200, 100, 0));
		ImplicitLine SecondLine = new ImplicitLine(new Point3f(0, 0, 0), new Point3f(200, 200, 0));
		ImplicitLine ThirdLine = new ImplicitLine(new Point3f(0, 0, 0), new Point3f(75, 200, 0));
		ImplicitLine FourthLine = new ImplicitLine(new Point3f(0, 0, 0), new Point3f(25, 200, 0));

		FirstLine.drawLine(g);
		SecondLine.drawLine(g);
		ThirdLine.drawLine(g);
		FourthLine.drawLine(g);

		// Remove the comments for Parametric line and test it

		ParametricLine FirstLine = new ParametricLine(new Point3f(0, 0, 0), new Point3f(200, 100, 0));
		ParametricLine SecondLine = new ParametricLine(new Point3f(0, 0, 0), new Point3f(200, 200, 0));
		ParametricLine ThirdLine = new ParametricLine(new Point3f(0, 0, 0), new Point3f(75, 200, 0));
		ParametricLine FourthLine = new ParametricLine(new Point3f(0, 0, 0), new Point3f(25, 200, 0));

		FirstLine.drawLine(g);
		SecondLine.drawLine(g);
		ThirdLine.drawLine(g);
		FourthLine.drawLine(g);
		// */

		// Remove the comments for an example of square using Parametric lines
		/*
		ParametricLine FirstLine = new ParametricLine(new Point3f(0, 0, 0), new Point3f(0, 300, 0));
		ParametricLine SecondLine = new ParametricLine(new Point3f(0, 300, 0), new Point3f(300, 300, 0));
		ParametricLine ThirdLine = new ParametricLine(new Point3f(300, 300, 0), new Point3f(300, 0, 0));
		ParametricLine FourthLine = new ParametricLine(new Point3f(300, 0, 0), new Point3f(0, 0, 0));

		FirstLine.drawLine(g);
		SecondLine.drawLine(g);
		ThirdLine.drawLine(g);
		FourthLine.drawLine(g);
		// */
		/*
		ParametricTriangle MyFirstTriangle = new ParametricTriangle(new Point3f(200, 0, 0), new Point3f(400,200, 0),
				new Point3f(200, 370, 0));

		 MyFirstTriangle.drawTriangle(g);// */
		
		//insert your house drawings  here 
		drawHouse(g);
	}

	private void drawHouse(Graphics g) {
		// 绘制天空
		fillRectangle(g, 0, 0, 800, 400, new Color(135, 206, 235));

		// 绘制草地
		fillRectangle(g, 0, 400, 800, 200, new Color(34, 139, 34));

		// 绘制房子主体
		fillRectangle(g, 200, 250, 400, 300, new Color(210, 180, 140));

		// 绘制屋顶（使用参数化三角形）
		ParametricTriangle roof = new ParametricTriangle(
				new Point3f(150, 250, 0),
				new Point3f(650, 250, 0),
				new Point3f(400, 100, 0)
		);
		roof.drawTriangle(g);

		// 绘制门
		fillRectangle(g, 370, 400, 60, 150, new Color(101, 67, 33));
		fillCircle(g, 415, 475, 5, Color.YELLOW);

		// 绘制窗户
		drawWindow(g, 250, 300);
		drawWindow(g, 500, 300);

		// 绘制烟囱
		fillRectangle(g, 500, 150, 40, 100, Color.GRAY);

		// 绘制太阳
		fillCircle(g, 700, 100, 50, Color.YELLOW);

		// 绘制树
		drawTree(g, 100, 450);
		drawTree(g, 650, 430);
	}

	private void drawWindow(Graphics g, int x, int y) {
		fillRectangle(g, x, y, 80, 80, new Color(173, 216, 230));
		drawLine(g, x + 40, y, x + 40, y + 80);
		drawLine(g, x, y + 40, x + 80, y + 40);
	}

	private void drawTree(Graphics g, int x, int y) {
		fillRectangle(g, x - 10, y, 20, 80, new Color(101, 67, 33));
		Color leafColor = new Color(34, 139, 34);
		for (int i = 0; i < 3; i++) {
			ParametricTriangle leaf = new ParametricTriangle(
					new Point3f(x - 50, y - i * 30, 0),
					new Point3f(x + 50, y - i * 30, 0),
					new Point3f(x, y - 60 - i * 30, 0)
			);
			leaf.drawTriangle(g);
		}
	}

	private void fillRectangle(Graphics g, int x, int y, int width, int height, Color color) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}

	private void fillCircle(Graphics g, int x, int y, int radius, Color color) {
		g.setColor(color);
		g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
	}

	private void drawLine(Graphics g, int x1, int y1, int x2, int y2) {
		ParametricLine line = new ParametricLine(new Point3f(x1, y1, 0), new Point3f(x2, y2, 0));
		line.drawLine(g);
	}


	public static void main(String[] args) {
		Drawing2D panel = new Drawing2D();
		JFrame ScreenToDrawOn = new JFrame();
		ScreenToDrawOn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ScreenToDrawOn.setTitle("2D Drawing Application");
		ScreenToDrawOn.setSize(1000, 1000); // window is 500 pixels wide, 400
											// high
		ScreenToDrawOn.setVisible(true);
		ScreenToDrawOn.add(panel);

	}

}
