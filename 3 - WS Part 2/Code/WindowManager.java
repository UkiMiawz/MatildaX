import java.util.ArrayList;
import java.util.List;
import java.awt.geom.Line2D;
import java.awt.Color;

public class WindowManager {

	private WindowSystem windowSystem;

	private final Color windowColor = Color.LIGHT_GRAY;
    private final Color lineColor = Color.BLUE;
    private final Color headerSquareColor = Color.BLUE;
    private final Color fontHeaderColor = Color.WHITE;

    private final int titleBarHeight = 20;
    private final int titleTextMarginX = 5;
    private final int titleTextMarginY = 15;

    private List<SimpleWindow> simpleWindows;

	public WindowManager(WindowSystem windowSystem){
		System.out.println("Window Manager constructor");
		this.windowSystem = windowSystem;
		this.simpleWindows = windowSystem.getSimpleWindows();
		setThemeColors();
		addHeaderToWindows();
	}

	//Set color theme in window system
	private void setThemeColors(){
		System.out.println("Set background color for window system");
		windowSystem.setWindowColor(windowColor);
		windowSystem.setLineColor(lineColor);
		windowSystem.setTitleBarColor(fontHeaderColor);
	}

	//Add header
	private void addHeaderToWindows(){

		//iterate through simpleWindows
		for (SimpleWindow t:simpleWindows) {
			
			//add header bar
			System.out.println("Adding header bar to window " + t.getId());
			int titleBarStartX = t.getLeftTopX();
			int titleBarStartY = t.getLeftTopY() - titleBarHeight;
			int titleBarWidth = t.getWidth() + 1;

			System.out.println("Title bar position now " + titleBarStartX + " " + titleBarStartY);
			RectangleComponent titleBar = new RectangleComponent(titleBarStartX, titleBarStartY, titleBarWidth, 
				titleBarHeight, headerSquareColor);
			t.addNewComponent(titleBar);

			//add string title to header
			StringComponent titleString = new StringComponent(t.getTitle(), titleBarStartX + titleTextMarginX, titleBarStartY + titleTextMarginY);
			t.addNewComponent(titleString);
		}
	}

}