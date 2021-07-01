
/**
 * Rect.java
 * @version 1.0.0
 * @author Nasim Ahmed 
 */

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Rect(rectangle) is a shape that can be drawn to the screen, either filled
 * with colour or opaque. Its position is determined by its' upper left corner
 */

public class Rect extends ClosedShape {

	// The length of a side of the square
	private int width;
	private int height;

	/**
	 * Creates a rectangle.
	 * 
	 * @param x        The display component's x position.
	 * @param y        The display component's y position.
	 * @param vx       The display component's x velocity.
	 * @param vy       The display component's y velocity.
	 * @param width    The width of the rectangle.
	 * @param height   The height of the rectangle.
	 * @param colour   The line colour or fill colour.
	 * @param isFilled True if the circle is filled with colour, false if opaque.
	 */
	public Rect(int insertionTime, int x, int y, int vx, int vy, int width, int height, Color colour, boolean isFilled) {

		super(insertionTime, x, y, vx, vy, colour, isFilled);
		this.width = width;
		this.height = height;

	}

	/**
	 * Method to convert a rectangle to a string.
	 */
	public String toString() {

		String result = "This is a Rectangle\n";
		result += super.toString();
		result += "Its width is " + this.width + " and its height is " + this.height + "\n";
		return result;

	}

	/**
	 * @param width Resets the width.
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @param height Resets the height.
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return The width of the square.
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @return The height of the square.
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Draw the rectangle on the screen.
	 * 
	 * @param g The graphics object of the scene component.
	 */
	public void draw(GraphicsContext g) {
		g.setFill(colour);
		g.setStroke(colour);
		if (isFilled) {
			g.fillRect(x, y, width, height);
		} else {
			g.strokeRect(x, y, width, height);
		}
	}

}
