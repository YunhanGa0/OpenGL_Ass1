package Triangle_Algorithms;

import java.awt.Color;
import java.awt.Graphics;

import GraphicsObjects.Point3f;

public class ParametricTriangle {

	Point3f A;
	Point3f B;
	Point3f C;
	Color color;

	public ParametricTriangle(Point3f a, Point3f b, Point3f c) {
		A = a;
		B = b;
		C = c;
	}
	 

	// 使用参数方程绘制三角形并填充颜色
	public void drawTriangle(Graphics g) {
		// 计算三角形的边界框
		int minX = Math.min(Math.min((int)A.x, (int)B.x), (int)C.x);
		int maxX = Math.max(Math.max((int)A.x, (int)B.x), (int)C.x);
		int minY = Math.min(Math.min((int)A.y, (int)B.y), (int)C.y);
		int maxY = Math.max(Math.max((int)A.y, (int)B.y), (int)C.y);

		// 计算三角形的面积
		float area = Math.abs((B.x - A.x) * (C.y - A.y) - (C.x - A.x) * (B.y - A.y));

		// 遍历边界框中的每个像素
		for (int x = minX; x <= maxX; x++) {
			for (int y = minY; y <= maxY; y++) {
				// 计算重心坐标
				float alpha = ((B.y - C.y) * (x - C.x) + (C.x - B.x) * (y - C.y)) / area;
				float beta = ((C.y - A.y) * (x - C.x) + (A.x - C.x) * (y - C.y)) / area;
				float gamma = 1 - alpha - beta;

				// 如果点在三角形内部
				if (alpha >= 0 && beta >= 0 && gamma >= 0) {
					// 使用重心坐标插值颜色
					float R = alpha;
					float G = beta;
					float B = gamma;

					setPixel(g, x, y, R, G, B);
				}
			}
		}
	}

	// 已实现的方法，用于适应Swing的坐标系统
	private void setPixel(Graphics g, int x, int y, float R, float G, float B) {
		Color pixelColour = new Color(R, G, B);
		g.setColor(pixelColour);
		g.fillRect(x, y, 1, 1); // 直接使用x和y，不进行坐标转换
	}

}
