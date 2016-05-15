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
    private int closeButtonLeftX;
    private int closeButtonLeftY;
    private int closeButtonRightX;
    private int getCloseButtonRightY;
    private int titleX;
    private int titleY;

    private final Color headerSquareColor = Color.orange;
    private final Color headerStringColor = Color.BLACK;
    private final Color windowColor = Color.WHITE;
    private final Color closeButtonColor = Color.RED;
    private final Color closeButtonStringColor = Color.WHITE;
    private Color shadowColor = new Color(0f,0f,0f,.5f);

    private final int titleBarHeight = 20;
    private final int closeButtonHeight = 20;
    private final int closeButtonWidth  = 20;

    private SimpleWindow currentActiveWindow;

    private int lastMouseX;
    private int lastMouseY;

    public Color getShadowColor(){ return shadowColor; }

    /*
    * Constructor
    */
    public WindowManager(WindowSystem windowSystem) {
        this.windowSystem = windowSystem;
    }

    /*
    * Add all components to a window
    */
    public void redrawWindow(SimpleWindow t){
        t.setFillColorWindowColor(windowColor);

        //add header bar
        int titleBarLeftX = t.getLeftTopX();
        int titleBarLeftY = t.getLeftTopY();

        int titleBarWidth = t.getWidth();

        int titleX = t.getLeftTopX();
        int titleY = t.getLeftTopY();

        //add title bar
        RectangleComponent titleBar = new RectangleComponent(titleBarLeftX, titleBarLeftY, titleBarWidth,
            titleBarHeight, headerSquareColor);
        titleBar.setString(t.getTitle());
        titleBar.setStringColor(headerStringColor);
        titleBar.setStringPadding(10, 15);
        t.addNewComponent(titleBar);

        int closeButtonLeftX = t.getRightBottomX() - closeButtonWidth;
        int closeButtonLeftY = t.getLeftTopY();

        //add close button
        RectangleComponent closeButton = new RectangleComponent(closeButtonLeftX,closeButtonLeftY,closeButtonWidth,
                closeButtonHeight, closeButtonColor);
        closeButton.setString("X");
        closeButton.setStringColor(closeButtonStringColor);
        closeButton.setStringPadding(7,15);
        closeButton.setIsButton(true);
        closeButton.setValue(ButtonValue.CLOSE);
        t.addNewComponent(closeButton);

        windowSystem.requestRepaint();
    }

    public void handleMouseClicked(int x, int y){
        System.out.println("Window manager - Mouse clicked with x " + x + " and y " + y);
        
        if(currentActiveWindow == null){
            setActiveWindow(x,y);
        }

        if(currentActiveWindow != null){
            List<RectangleComponent> windowComponents = currentActiveWindow.getRectangleComponents();

            //search for clickable component in coordinate x&y, iterate backwards from the most top
            for(int i=windowComponents.size()-1; i >= 0 ;i--){
               RectangleComponent currentComponent = windowComponents.get(i);
               int componentLeftX = (int)currentComponent.getX();
               int componentRightX = componentLeftX + (int)currentComponent.getWidth();
               int componentTopY = (int)currentComponent.getY();
               int componentBottomY = componentTopY + (int)currentComponent.getHeight();

               if((componentLeftX < x && x < componentRightX)
                       && (componentTopY < y && y < componentBottomY) 
                       && currentComponent.isButton())
               {
                   System.out.println("component found with value " + currentComponent.getValue());
                   handleButton(currentComponent.getValue(), currentActiveWindow);
                   break;   
               }
           }
           currentActiveWindow = null;
        }
    }

    public void handleMouseDragged(int x, int y){
        int xDifference = x - lastMouseX;
        int yDifference = y - lastMouseY;
        System.out.println("Window manager - Mouse dragged with x " + x + " and y " + y);
        if(currentActiveWindow == null){
            setActiveWindow(x,y);
        }
        dragWindow(xDifference, yDifference);
        lastMouseX = x;
        lastMouseY = y;
    }

    public void handleMouseReleased(int x, int y){
        System.out.println("Window manager - Mouse released with x " + x + " and y " + y);
        currentActiveWindow = null;
    }

    public void handleMousePressed(int x, int y){
        System.out.println("Window manager - Mouse pressed with x " + x + " and y " + y);
        lastMouseY = y;
        lastMouseX = x;

        if(currentActiveWindow == null){
            setActiveWindow(x,y);
        }

        if(currentActiveWindow != null){
            //reorder window
            windowSystem.getListWindows().remove(currentActiveWindow);
            windowSystem.getListWindows().add(currentActiveWindow);
            windowSystem.requestRepaint();
        }
        
        currentActiveWindow = null;
    }

    /*
    * Check for window positioned in the current x&y coordinate
    */
    private void setActiveWindow(int x, int y){
        //get copy of list of windows
        listWindows = windowSystem.getListWindows();
        //iterate through the windows (backwards since element on tail are on top) and search for one which contains x,y coords
        for(int i=listWindows.size()-1; i >= 0 ;i--){
           SimpleWindow window = listWindows.get(i);
           if((window.getLeftTopX() < x && x < window.getLeftTopX() + window.getWidth())
                   && (window.getLeftTopY() < y && y < window.getLeftTopY()+window.getHeight()) )
           {
               System.out.println("window found " + window.getId());
               currentActiveWindow = window;
               break;   
           }
       }
    }

    /*
    * Move current active window based on differences in position
    */
    public void dragWindow(int xDifference, int yDifference){
        System.out.println("Differences : " + xDifference + " " + yDifference);

        if(currentActiveWindow != null){
            currentActiveWindow.moveWindow(xDifference, yDifference);
            windowSystem.requestRepaint();
        }
    }

    private void handleButton(ButtonValue buttonValue, SimpleWindow window){
        switch(buttonValue){
            case CLOSE:
                windowSystem.getListWindows().remove(window);
                break;
        }
        windowSystem.requestRepaint();
    }
}
