
/**
 * Polygon.java
 * @version 1.0.0
 * @author Nasim Ahmed
 */

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 * A polygon is a many sided shape, this one has 12 sides
 */

public class Polygon extends ClosedShape {
	// The arrays that hold the x and y values of the points on the polygon
	private double[] xc;
	private double[] yc;
	// The width and height of the polygon
	private int width;
	private int height;

	/**
	 * Creates an S.
	 * 
	 * @param x        The display component's x position.
	 * @param y        The display component's y position.
	 * @param vx       The display component's x velocity.
	 * @param vy       The display component's y velocity.
	 * @param colour   The line colour or fill colour.
	 * @param isFilled True if the circle is filled with colour, false if opaque.
	 */
	public Polygon(int insertionTime, int x, int y, int vx, int vy, int width, int height, Color colour, boolean isFilled) {
		super(insertionTime, x, y, vx, vy, colour, isFilled);
		this.width = width;
		this.height = height;
		// These variables are segments of the width/height that help with calculating
		// the coordinates
		double xSeg = width / 4;
		double ySeg = height / 5;
		// The arrays are filled with x and y coordinates based on the xy position of
		// the shape that is passed into the constructor with the addition of 
		// segments of the width and height
		this.xc = new double[] { x + 2 * xSeg, x + width, x + width, x + 3 * xSeg, x + width, x + width, x + 2 * xSeg,
				x, x, x + xSeg, x, x };
		this.yc = new double[] { y, y + ySeg, y + 2 * ySeg, y + 2.5 * ySeg, y + 3 * ySeg, y + 4 * ySeg, y + height,
				y + 4 * ySeg, y + 3 * ySeg, y + 2.5 * ySeg, y + 2 * ySeg, y + ySeg };

	}

	/**
	 * Method to convert a polygon to a string.
	 */
	public String toString() {
		String result = "This is an S\n";
		result += super.toString();
		result += "Its width is: " + width + "\n" + "Its height is: " + height;
		return result;
	}

	/**
	 * @return x coordinates
	 */
	public String getXC() {
		return xc.toString();
	}

	/**
	 * @return y coordinates
	 */
	public String getYC() {
		return yc.toString();
	}
	
	/**
	 * changes the width of the polygon
	 * @param width to be set
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	
	/**
	 *changes the height of the polygon 
	 * @param height to be set
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
	/**
	 * @return width The width of the polygon
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * @return height The the height of the polygon
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Draw the polygon on the screen.
	 * 
	 * @param g The graphics object of the scene component.
	 */
	public void draw(GraphicsContext g) {
		g.setFill(colour);
		g.setStroke(colour);
		if (isFilled) {
			g.fillPolygon(xc, yc, 12);
		} else {
			g.strokePolygon(xc, yc, 12);
		}

	}

}
