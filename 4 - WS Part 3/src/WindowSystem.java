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
    public SimpleWindow addNewWindow(SimpleWindow newWindow){

        //calculate in coordinates
        int intStartX = setX(newWindow.getRelativeLetfTopX());
        int intStartY = setY(newWindow.getRelativeLetfTopY());

        //set x & y of new simple window
        newWindow.moveWindow(intStartX, intStartY);
        simpleWindows.add(newWindow);
        System.out.println("Windows list count now " + simpleWindows.size());

        //redraw on adding new window
        requestRepaint();

        //call window manager
        if(windowManager != null){
            windowManager.redrawWindow(newWindow);
        }

        return newWindow;
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
                
                //draw borders
                int titleBarHeight = windowManager.getTitleBarHeight();
                super.setColor(t.getFrameColorWindow());
                super.drawRect(leftTopX-2 , leftTopY-titleBarHeight-2, rightBottomX+1, rightBottomY+1);
                super.setColor(Color.WHITE);
                super.drawRect(leftTopX-1 , leftTopY-titleBarHeight-1, rightBottomX, rightBottomY);
            }

            //drawing window squares and border
            super.setColor(t.getFillColorWindow());
            super.fillRect(leftTopX , leftTopY, rightBottomX, rightBottomY);

            //draw current window components
            for(WindowComponent component:t.getRectangleComponents()){
                //draw all the rectangle components
                drawComponent(component);
            }

            //draw widget
            RATWidget windowWidget = t.getWidget();
            if(windowWidget != null){
                for(RATButton component:windowWidget.getRatButtons()){
                    //draw all the rectangle components
                    drawComponent(component);
                }

                for(RATLabel component:windowWidget.getRatLabels()){
                    //draw all the rectangle components
                    drawComponent(component);
                }
            }
        }
    }

    private void drawComponent(RATLabel component){
        //draw all the rectangle components
        super.setColor(component.getColor());
        super.fillRect(component.getX(), component.getY(), 
            component.getX() + component.getWidth(), 
            component.getY() + component.getHeight());

        //draw the string property of the component
        component.setString(component.getString());
        super.setColor(component.getStringColor());
        super.drawString(component.getString(), 
            component.getX() + component.getStringPaddingLeft(), 
            component.getY() + component.getStringPaddingTop());
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
