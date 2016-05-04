import de.rwth.hci.Graphics.GraphicsEventSystem; 
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class WindowSystem extends GraphicsEventSystem{
	
	//window system width and height
	private int windowWidth;
	private int windowHeight;
	//list of Windows in current window system
	private List<SimpleWindow> simpleWindows;

	//line x and y start position in coordinates
	private int startLineX;
	private int startLineY;
	//line x and y end position in coordinates
	private int endLineX;
	private int endLineY;
	
	/*
	 * Constructor
	 */
	public WindowSystem(int width, int height){
		//save window width and height
		super(width, height);
		windowWidth = width;
		windowHeight = height;
		//instantiate new list
		simpleWindows = new ArrayList<SimpleWindow>();
	}

	/*
	 * (non-Javadoc)
	 * override handle paint in parent
	 * Set color and draw line using parent methods
	 */
	@Override
	protected void handlePaint(){
		System.out.println("Draw line in coordinates: " + startWindowX + 
				" starty: " + startWindowY + " endx: " + endWindowX + " endy " + endWindowY);
		//put set color and draw line here because calling them outside handle paint gives error message
		super.setColor(Color.BLACK);
		super.drawLine(startWindowX, startWindowY, endWindowX, endWindowY);
	}
	
	/*
	 * Translate vector to coordinate
	 */
	public void drawLine(float startX, float startY, float endX, float endY){
		System.out.println("Draw line with startx: " + startX + " starty: " + startY + 
				" endx: " + endX + " endy " + endY);
		//calculate in coordinates
		startLineX = (int)(windowWidth * startX);
		startLineY = (int)(windowHeight * startY);
		endLineX = (int)(windowWidth * endX);
		endLineY = (int)(windowHeight * endY);
		//do the drawing
		handlePaint();
	}
	
	/*
	 * Add new simple window to window system
	 */
	public void AddNewWindow(){
		simpleWindows.add(new SimpleWindow());
	}
}
