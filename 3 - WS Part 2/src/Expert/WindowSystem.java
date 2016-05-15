import de.rwth.hci.Graphics.GraphicsEventSystem;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class WindowSystem extends GraphicsEventSystem{

    //window system width and height
    private int windowWidth;
    private int windowHeight;
    //list of Windows in current window system
    private List<SimpleWindow> simpleWindows;
    public List<SimpleWindow> getListWindows(){return simpleWindows;}
    private static WindowManager windowManager;

    //background color
    private final Color backgroundColor = Color.LIGHT_GRAY;

    /*
     * Constructor
     */
    public WindowSystem(int width, int height){
        //save window width and height
        super(width, height);
        super.setBackground(backgroundColor);
        windowWidth = width;
        windowHeight = height;

        //instantiate list and objects
        simpleWindows = new ArrayList<SimpleWindow>();
        windowManager = new WindowManager(this);
    }

    //coordinate converter
    public int setX(float x){ return (int) Math.round(x * windowWidth); }
    public int setY(float y){ return (int) Math.round(y * windowHeight); }

    /*
     * Add new window to simple windows
     */
    public void addNewWindow(float startX, float startY, int width, int height, String title){

        System.out.println("Add new window with properties vector: " + startX + " starty: " + startY + 
                " width: " + width + " height " + height);

        //calculate in coordinates
        int intStartX = setX(startX);
        int intStartY = setY(startY);

        System.out.println("Add new window with coordinates startx: " + intStartX + " starty: " + intStartY + 
                " width: " + width + " height " + height);

        SimpleWindow newWindow = new SimpleWindow(intStartX, intStartY, width,  height, title);
        simpleWindows.add(newWindow);
        System.out.println("Windows list count now " + simpleWindows.size());

        //redraw on adding new window
        requestRepaint();

        //call window manager
        if(windowManager != null){
            windowManager.redrawWindow(newWindow);
        }
    }

    /*
     * override handle paint in parent
     * Set color and draw line using parent methods
     */
    @Override
    protected void handlePaint(){

        //copy list to avoid iterating through list that being updated
        List<SimpleWindow> tempSimpleWindows = new ArrayList<SimpleWindow>(simpleWindows);

        //super.drawString("hello", 0,0);
        for(SimpleWindow t:tempSimpleWindows) {

            int leftTopX = t.getLeftTopX();
            int leftTopY = t.getLeftTopY();
            int rightBottomX = t.getRightBottomX();
            int rightBottomY = t.getRightBottomY();

            //draw shadow first
            if(windowManager != null){
                super.setColor(windowManager.getShadowColor());
                super.fillRect(t.getLeftTopX()+15 , t.getLeftTopY()+15, t.getRightBottomX()+10, t.getRightBottomY()+10);
                super.setColor(t.getFrameColorWindow());
                super.drawRect(leftTopX-2 , leftTopY-2, rightBottomX+1, rightBottomY+1);
                super.setColor(Color.WHITE);
                super.drawRect(leftTopX-1 , leftTopY-1, rightBottomX, rightBottomY);
            }

            //drawing window squares and border
            super.setColor(t.getFillColorWindow());
            super.fillRect(leftTopX , leftTopY, rightBottomX, rightBottomY);

            //draw current window components
            for(RectangleComponent rectangleComponent:t.getRectangleComponents()){

                //draw all the rectangle components
                super.setColor(rectangleComponent.getColor());
                super.fillRect(rectangleComponent.getX(), rectangleComponent.getY(), 
                    rectangleComponent.getX() + rectangleComponent.getWidth(), 
                    rectangleComponent.getY() + rectangleComponent.getHeight());

                //draw the title of the window
                rectangleComponent.setString(rectangleComponent.getString());
                super.setColor(rectangleComponent.getStringColor());
                super.drawString(rectangleComponent.getString(), 
                    rectangleComponent.getX() + rectangleComponent.getStringPaddingLeft(), 
                    rectangleComponent.getY() + rectangleComponent.getStringPaddingTop());
            }
        }
    }

    @Override
    public void handleMouseClicked(int x, int y){
        if(windowManager != null){
            windowManager.handleMouseClicked(x, y);
        }
    }

    @Override
    public void handleMouseDragged(int x, int y){
        if(windowManager != null){
            windowManager.handleMouseDragged(x, y);
        }
    }

    @Override
    public void handleMouseReleased(int x, int y){
        if(windowManager != null){
            windowManager.handleMouseReleased(x, y);
        }
    }

    @Override
    public void handleMousePressed(int x, int y){
        if(windowManager != null){
            windowManager.handleMousePressed(x, y);
        }
    }
}
