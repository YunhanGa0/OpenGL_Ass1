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
		ParametricTriangle MyFirstTriangle = new ParametricTriangle(new Point3f(200, 250, 0), new Point3f(400,150, 0),
				new Point3f(600, 250, 0));

		 MyFirstTriangle.drawTriangle(g);// */
		
		//insert your house drawings  here 

		drawHouse(g);
		drawCoordinateSystem(g);
	}
	private void drawCoordinateSystem(Graphics g) {
    g.setColor(Color.LIGHT_GRAY);
    
    // 绘制垂直线
    for (int x = 0; x <= 800; x += 100) {
        g.drawLine(x, 0, x, 600);
    }
    
    // 绘制水平线
    for (int y = 0; y <= 600; y += 100) {
        g.drawLine(0, y, 800, y);
    }
    
    // 绘制坐标轴
    g.setColor(Color.BLACK);
    g.drawLine(0, 0, 800, 0);  // X轴
    g.drawLine(0, 0, 0, 600);  // Y轴
    
    // 添加刻度标记
    for (int i = 100; i <= 800; i += 100) {
        g.drawString(Integer.toString(i), i, 15);  // X轴刻度
        if (i <= 600) {
            g.drawString(Integer.toString(i), 5, i);  // Y轴刻度
        }
    }
}


	private void drawHouse(Graphics g) {
		// 绘制天空
		fillRectangle(g, 0, 0, 800, 400, new Color(135, 206, 235));

		// 绘制草地
		fillRectangle(g, 0, 400, 800, 200, new Color(34, 139, 34));

		// 绘制房子主体
		fillRectangle(g, 200, 250, 400, 300, new Color(210, 180, 140));

		// 绘制烟囱
		fillRectangle(g, 500, 150, 40, 100, Color.GRAY);

		// 绘制屋顶（使用参数化三角形）
		ParametricTriangle roof = new ParametricTriangle(
				new Point3f(200, 250, 0),
				new Point3f(400, 100, 0),
				new Point3f(600, 250, 0)
		);
		roof.drawTriangle(g);

		// 绘制门
		fillRectangle(g, 370, 400, 60, 150, new Color(101, 67, 33));
		// 绘制门把手（正方形）
		fillRectangle(g, 410, 470, 10, 10, Color.YELLOW);


		// 绘制窗户
		g.setColor(Color.WHITE);
		// 左窗户
		g.fillRect(260, 300, 80, 80);
		// 右窗户
		g.fillRect(480, 300, 80, 80);

		// 绘制窗户上的十字
		g.setColor(Color.BLACK);
		// 左窗户
		g.drawLine(260, 340, 340, 340);
		g.drawLine(300, 300, 300, 380);
		// 右窗户
		g.drawLine(480, 340, 560, 340);
		g.drawLine(520, 300, 520, 380);


		// 绘制太阳
        drawSun(g, 700, 100, 50);

		// 绘制树
		drawTree(g, 100, 450);
		drawTree(g, 670, 430);
	}


	private void drawTree(Graphics g, int x, int y) {
		fillRectangle(g, x - 10, y, 20, 80, new Color(101, 67, 33));
		Color leafColor = new Color(34, 139, 34);
		for (int i = 0; i < 3; i++) {
			ParametricTriangle leaf = new ParametricTriangle(
					new Point3f(x - 50, y - i * 30, 0),
					new Point3f(x, y - 60 - i * 30, 0),
					new Point3f(x + 50, y - i * 30, 0)
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

	private void drawSun(Graphics g, int centerX, int centerY, int radius) {
        g.setColor(Color.YELLOW);
        
        // 绘制12边形作为太阳的主体
        int[] xPoints = new int[12];
        int[] yPoints = new int[12];
        for (int i = 0; i < 12; i++) {
            double angle = Math.PI * 2 * i / 12;
            xPoints[i] = (int) (centerX + radius * Math.cos(angle));
            yPoints[i] = (int) (centerY + radius * Math.sin(angle));
        }
        g.fillPolygon(xPoints, yPoints, 12);
        
        // 添加光芒
        g.setColor(new Color(255, 255, 0, 150)); // 半透明的黄色
        for (int i = 0; i < 12; i++) {
            double angle = Math.PI * 2 * i / 12;
            int x1 = (int) (centerX + radius * Math.cos(angle));
            int y1 = (int) (centerY + radius * Math.sin(angle));
            int x2 = (int) (centerX + radius * 1.5 * Math.cos(angle));
            int y2 = (int) (centerY + radius * 1.5 * Math.sin(angle));
            g.drawLine(x1, y1, x2, y2);
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
