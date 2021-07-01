
/**
 * This class reads a shape file.  For the format of this shape file, see the assignment description.
 * Also, please see the shape files ExampleShapes.txt, ExampleShapesStill.txt, and TwoRedCircles.txt
 *
 * @author Nasim Ahmed 952237
 *
 */

import javafx.scene.paint.Color;
import java.io.*;
import java.util.Scanner;

public class ReadShapeFile {

	/**
	 * Reads the data file used by the program and returns the constructed queue
	 * 
	 * @param    <ClosedShape>
	 * @param in the scanner of the file
	 * @param line the current line we are reading from the file
	 * @param parse the scanner used to parse through the current line
	 * @param type  variable that holds the classification of shape that we are dealing with
	 * @return the queue represented by the data file
	 */

	private static Queue<ClosedShape> readDataFile(Scanner in) {
		Queue<ClosedShape> shapeQueue = new Queue<ClosedShape> ();
		//Loops through the lines of the code and parses through them one at a time
		while (in.hasNext()) {
			String line = in.nextLine();
			Scanner parse = new Scanner(line);
			String type = parse.next();
			System.out.println(type);
			parse.close();
			if (type.equals("circle")) {
				shapeQueue.enqueue(ConstructCircle(line));
			} else if (type.equals("oval")) {
				shapeQueue.enqueue(ConstructOval(line));
			} else if(type.equals("square")) {
				shapeQueue.enqueue(ConstructSquare(line));
			}else if(type.equals("rect")) {
				shapeQueue.enqueue(ConstructRectangle(line));
			}else if(type.equals("poly")) {
				shapeQueue.enqueue(ConstructPolygon(line));
			}
			else {
				System.out.println("File/file format is incorrect");
			}
		}
		in.close();
		return shapeQueue;
	}

	/**
	 * Method to read the file and return a queue of shapes from this file. The
	 * program should handle the file not found exception here and shut down the
	 * program gracefully.
	 * 
	 * @param filename the name of the file
	 * @param in scanner to be sent to the other readDataFile method with the file data
	 * @return the queue of shapes from the file
	 */
	public static Queue<ClosedShape> readDataFile(String filename){	
		try {
			File inputFile = new File(filename); //Opens the file
			Scanner in = new Scanner(inputFile);
			return ReadShapeFile.readDataFile(in);
			}catch (FileNotFoundException e){ //In the event of the file not existing
				System.out.println("Error: " + e);
				return null;
			}	
	}
	
	/**
	 * Method to read a line of data about a circle and construct a circle using the Circle class
	 * @param in the scanner holding a line of data about a circle
	 * @return a constructed circle to be put on the queue
	 */
	public static ClosedShape ConstructCircle(String in) {
		Scanner parse = new Scanner(in);
		parse.next(); //skips the first word "circle"
		//Goes through the words one at a time, assining them to their appropriate variable
		int px = Integer.parseInt(parse.next());
		int py = Integer.parseInt(parse.next());
		int vx = Integer.parseInt(parse.next());
		int vy = Integer.parseInt(parse.next());
		boolean filled = Boolean.parseBoolean(parse.next());
		int diameter = Integer.parseInt(parse.next());
		int r = Integer.parseInt(parse.next());
		int g = Integer.parseInt(parse.next());
		int b = Integer.parseInt(parse.next());
		int time = Integer.parseInt(parse.next());
		parse.close();
		//Obtains the Colour using the r g b values
		Color c = Color.rgb(r, g, b);
		//Constructs the Cicle
		Circle shape = new Circle(time, px, py, vx, vy, diameter, c, filled);
		//to print the circle object as a string
		System.out.println(shape.toString());
		return shape;
	}
	
	/**
	 * Method to read a line of data about a Oval and construct an Oval using the Oval class
	 * @param in the scanner holding a line of data about an Oval
	 * @return a constructed Oval to be put on the queue
	 */
	public static ClosedShape ConstructOval(String in) {
		Scanner parse = new Scanner(in);
		parse.next();//skips the first word "oval"
		//Goes through the words one at a time, assining them to their appropriate variable
		int px = Integer.parseInt(parse.next());
		int py = Integer.parseInt(parse.next());
		int vx = Integer.parseInt(parse.next());
		int vy = Integer.parseInt(parse.next());
		boolean filled = Boolean.parseBoolean(parse.next());
		int width = Integer.parseInt(parse.next());
		int height = Integer.parseInt(parse.next());
		int r = Integer.parseInt(parse.next());
		int g = Integer.parseInt(parse.next());
		int b = Integer.parseInt(parse.next());
		int time = Integer.parseInt(parse.next());
		parse.close();
		//Obtains the Colour using the r g b values
		Color c = Color.rgb(r, g, b);
		//Constructs the Oval
		Oval shape = new Oval(time, px, py, vx, vy, width, height, c, filled);
		//to print the oval object as a string
		System.out.println(shape.toString());
		return shape;
	}
	
	/**
	 * Method to read a line of data about a square and construct a square using the Square class
	 * @param in the scanner holding a line of data about a square
	 * @return a constructed square to be put on the queue
	 */
	public static ClosedShape ConstructSquare(String in) {
		Scanner parse = new Scanner(in);
		parse.next(); //skips the first word "square"
		//Goes through the words one at a time, assining them to their appropriate variable
		int px = Integer.parseInt(parse.next());
		int py = Integer.parseInt(parse.next());
		int vx = Integer.parseInt(parse.next());
		int vy = Integer.parseInt(parse.next());
		boolean filled = Boolean.parseBoolean(parse.next());
		int side = Integer.parseInt(parse.next());
		int r = Integer.parseInt(parse.next());
		int g = Integer.parseInt(parse.next());
		int b = Integer.parseInt(parse.next());
		int time = Integer.parseInt(parse.next());
		parse.close();
		//Obtains the Colour using the r g b values
		Color c = Color.rgb(r, g, b);
		//Constructs the Square
		Square shape = new Square(time, px, py, vx, vy, side, c, filled);
		//to print the square object as a string
		System.out.println(shape.toString());
		return shape;
	}
	
	/**
	 * Method to read a line of data about a rectangle and construct an rectangle using the rectangle class
	 * @param in the scanner holding a line of data about an rectangle
	 * @return a constructed rectangle to be put on the queue
	 */
	public static ClosedShape ConstructRectangle(String in) {
		Scanner parse = new Scanner(in);
		parse.next();//skips the first word "rect"
		//Goes through the words one at a time, assining them to their appropriate variable
		int px = Integer.parseInt(parse.next());
		int py = Integer.parseInt(parse.next());
		int vx = Integer.parseInt(parse.next());
		int vy = Integer.parseInt(parse.next());
		boolean filled = Boolean.parseBoolean(parse.next());
		int width = Integer.parseInt(parse.next());
		int height = Integer.parseInt(parse.next());
		int r = Integer.parseInt(parse.next());
		int g = Integer.parseInt(parse.next());
		int b = Integer.parseInt(parse.next());
		int time = Integer.parseInt(parse.next());
		parse.close();
		//Obtains the Colour using the r g b values
		Color c = Color.rgb(r, g, b);
		//Constructs the rectaangle
		Rect shape = new Rect(time, px, py, vx, vy, width, height, c, filled);
		//to print the rectangle object as a string
		System.out.println(shape.toString());
		return shape;
	}
	
	/**
	 * Method to read a line of data about a polygon and construct a polygon using the Polygon class
	 * @param in the scanner holding a line of data about an polygon
	 * @return a constructed polygon to be put on the queue
	 */
	public static ClosedShape ConstructPolygon(String in) {
		Scanner parse = new Scanner(in);
		parse.next();//skips the first word "poly"
		//Goes through the words one at a time, assining them to their appropriate variable
		int px = Integer.parseInt(parse.next());
		int py = Integer.parseInt(parse.next());
		int vx = Integer.parseInt(parse.next());
		int vy = Integer.parseInt(parse.next());
		boolean filled = Boolean.parseBoolean(parse.next());
		int width = Integer.parseInt(parse.next());
		int height = Integer.parseInt(parse.next());
		int r = Integer.parseInt(parse.next());
		int g = Integer.parseInt(parse.next());
		int b = Integer.parseInt(parse.next());
		int time = Integer.parseInt(parse.next());
		parse.close();
		//Obtains the Colour using the r g b values
		Color c = Color.rgb(r, g, b);
		//Constructs the polygon
		Polygon shape = new Polygon(time, px, py, vx, vy, width, height, c, filled);
		//to print the Polygon object as a string
		System.out.println(shape.toString());
		return shape;
	}

}
