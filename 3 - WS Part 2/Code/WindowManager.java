import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.awt.geom.Line2D;
import java.awt.Color;

public class WindowManager {

	private WindowSystem windowSystem;
	private final Color windowColor = Color.LIGHT_GRAY;
    private final Color lineColor = Color.BLUE;
    private final Color squareColor = Color.BLUE;
    private final Color fontHeaderColor = Color.WHITE;

    private final int titleBarHeight = 20;

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
		windowSystem.setSquareColor(squareColor);
	}

	//Add header
	private void addHeaderToWindows(){
		//iterate through simpleWindows
		for (SimpleWindow t:simpleWindows) {
			System.out.println("Adding header to window " + t.getId());
			int titleBarStartX = t.getLeftTopX();
			int titleBarStartY = t.getLeftTopY() - titleBarHeight;
			int titleBarWidth = t.getWidth() + 1;
			Rectangle titleBar = new Rectangle(titleBarStartX, titleBarStartY, titleBarWidth, titleBarHeight);
			t.addNewComponent(titleBar);
		}
	}

}