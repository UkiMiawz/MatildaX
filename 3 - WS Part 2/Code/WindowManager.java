import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class WindowManager  {

    private List<SimpleWindow> listWindows;
    private WindowSystem windowSystem;

    private int titleBarLeftX;
    private int titleBarLeftY;
    private int titleBarRightX;
    private int titleBarRightY;

    private final Color headerSquareColor = Color.BLUE;
    private final Color windowColor = Color.LIGHT_GRAY;
    private final Color titleBarColor = Color.WHITE;
    private final Color exitButtonColor = Color.RED;
    private final Color borderColor = Color.BLACK;

    private final int titleBarHeight = 20;
    private final int margin = 5;
    private final int titleTextMarginY = 15;

    private final int utilityButtonHeight = titleBarHeight - 2*margin;
    private final int utilityButtonWidth = 15;

    private final String closeButtonText = "x";

    public WindowManager(WindowSystem windowSystem) {
        this.windowSystem = windowSystem;
        listWindows = windowSystem.getListWindows();
        
        for (SimpleWindow t:listWindows) {

            t.setColor(windowColor);
            t.setBorderColor(borderColor);

            //add header bar
            System.out.println("Adding header bar to window " + t.getTitle());
            System.out.println("Window properties " + t.getLeftTopX() + " " + t.getLeftTopY() + " " 
                + t.getWidth() + " " + t.getHeight());

            int titleBarLeftX = t.getLeftTopX();
            int titleBarLeftY = t.getLeftTopY() - titleBarHeight;
            int titleBarWidth = t.getWidth();

            System.out.println("Title bar position now " + titleBarLeftX + " " + titleBarLeftY);
            RectangleComponent titleBar = new RectangleComponent(titleBarLeftX, titleBarLeftY, titleBarWidth, 
                titleBarHeight, headerSquareColor, false);
            t.addNewComponent(titleBar);

            //add border to title bar
            RectangleComponent titleBarBorder = new RectangleComponent(titleBarLeftX-1, titleBarLeftY-1, titleBarWidth+1, 
                titleBarHeight+1, borderColor, true);
            t.addNewComponent(titleBarBorder);

            //add string title to header
            StringComponent titleString = new StringComponent(t.getTitle(), titleBarLeftX + margin, 
                titleBarLeftY + titleTextMarginY, titleBarColor);
            t.addNewComponent(titleString);

            //add close button
            int closeButtonStartX = titleBarLeftX + titleBarWidth - margin - utilityButtonWidth;
            int closeButtonStartY = titleBarLeftY + margin;
            RectangleComponent closeButton = new RectangleComponent(closeButtonStartX, closeButtonStartY, utilityButtonWidth, 
                utilityButtonHeight, exitButtonColor, false);
            t.addNewComponent(closeButton);

            //add close button icon
            StringComponent closeButtonString = new StringComponent(closeButtonText, closeButtonStartX + margin, 
                closeButtonStartY + margin + 3, titleBarColor);
            t.addNewComponent(closeButtonString);

            windowSystem.requestRepaint(titleBarLeftX-1, titleBarLeftY-1, t.getWidth() + 2, t.getHeight() + titleBarHeight + 2);
        }

    }
}
