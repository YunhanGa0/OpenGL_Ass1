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
		ParametricTriangle MyFirstTriangle = new ParametricTriangle(new Point3f(200, 250, 0), new Point3f(400,150, 0),
				new Point3f(600, 250, 0));

		 MyFirstTriangle.drawTriangle(g);// */
		
		//insert your house drawings  here 

		drawHouse(g);
		//drawCoordinateSystem(g);
	}
	private void drawCoordinateSystem(Graphics g) {
		int centerX = 1300; // 假设屏幕宽度为800
		int centerY = 700; // 假设屏幕高度为600

		g.setColor(Color.LIGHT_GRAY);

		// 绘制垂直线
		for (int x = -1300; x <= 1300; x += 100) {
			g.drawLine(centerX + x, 0, centerX + x, 1400);
		}

		// 绘制水平线
		for (int y = -700; y <= 700; y += 100) {
			g.drawLine(0, centerY - y, 2600, centerY - y);
		}

		// 绘制坐标轴
		g.setColor(Color.BLACK);
		g.drawLine(0, centerY, 2600, centerY);  // X轴
		g.drawLine(centerX, 0, centerX, 1400);  // Y轴

		// 添加刻度标记
		g.setColor(Color.BLACK);
		for (int i = -1300; i <= 1300; i += 100) {
			if (i != 0) {
				g.drawString(Integer.toString(i), centerX + i, centerY );  // X轴刻度
			}
		}
		for (int i = -700; i <= 700; i += 100) {
			if (i != 0) {
				g.drawString(Integer.toString(i), centerX , centerY - i);  // Y轴刻度
			}
		}

		// 标记原点
		g.drawString("O", centerX , centerY );
	}


	private void drawHouse(Graphics g) {
		// 绘制天空
		drawRectangleWithTriangles(g, 0, 0, 800, 400, new Color(135, 206, 235));

		// 绘制草地
		drawRectangleWithTriangles(g, 0, 400, 800, 200, new Color(34, 139, 34));

		// 绘制房子主体
		drawRectangleWithTriangles(g, 200, 250, 400, 300, new Color(210, 180, 140));

		// 绘制烟囱
		drawRectangleWithTriangles(g, 500, 150, 40, 100, Color.GRAY);

		// 绘制屋顶（使用参数化三角形）
		ParametricTriangle1 roof = new ParametricTriangle1(
			new Point3f(200, 250, 0),
			new Point3f(400, 100, 0),
			new Point3f(600, 250, 0)
		);
		roof.drawTriangle(g);

		// 绘制门
		drawRectangleWithTriangles(g, 370, 400, 60, 150, new Color(101, 67, 33));

		// 绘制门把手（正方形）
		drawRectangleWithTriangles(g, 410, 470, 10, 10, Color.YELLOW);

		// 绘制窗户
		// 左窗户
		drawRectangleWithTriangles(g, 260, 300, 80, 80, Color.WHITE);
		// 右窗户
		drawRectangleWithTriangles(g, 480, 300, 80, 80, Color.WHITE);

		// 绘制窗户上的十字
		g.setColor(Color.BLACK);
		// 左窗户
		new ExplicitLine(new Point3f(260, 340, 0), new Point3f(340, 340, 0)).drawLine(g);
		new ImplicitLine(new Point3f(300, 300, 0), new Point3f(300, 380, 0)).drawLine(g);
		// 右窗户
		new ParametricLine(new Point3f(480, 340, 0), new Point3f(560, 340, 0)).drawLine(g);
		new ExplicitLine(new Point3f(520, 300, 0), new Point3f(520, 380, 0)).drawLine(g);

		// 绘制太阳
		drawSun(g, 700, 100, 80);

		// 绘制树
		drawTree(g, 100, 450);
		drawTree(g, 700, 430);
	}


	private void drawTree(Graphics g, int x, int y) {
		drawRectangleWithTriangles(g, x - 10, y, 20, 80, new Color(101, 67, 33));
		for (int i = 0; i < 3; i++) {
			ParametricTriangle1 leaf = new ParametricTriangle1(
					new Point3f(x - 50, y - i * 30, 0),
					new Point3f(x, y - 60 - i * 30, 0),
					new Point3f(x + 50, y - i * 30, 0)
			);
			leaf.drawTriangle(g);
		}
	}

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

	private void drawSun(Graphics g, int centerX, int centerY, int size) {
		Color sunColor = Color.YELLOW;
		Color rayColor = new Color(255, 255, 0, 150); // 半透明的黄色
		
		// 绘制太阳的主体（正方形）
		int halfSize = size / 2;
		drawRectangleWithTriangles(g, centerX - halfSize, centerY - halfSize, size, size, sunColor);
		
		// 添加光芒（使用ParametricLine）
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
			
			// 临时更改Graphics对象的颜色来绘制光芒
			Color originalColor = g.getColor();
			g.setColor(rayColor);
			ray.drawLine(g);
			g.setColor(originalColor);
		}
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
