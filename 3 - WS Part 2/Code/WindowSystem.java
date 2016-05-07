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
    private final Color backgroundColor = Color.CYAN;

    /*
     * Constructor
     */
    public WindowSystem(int width, int height){
        //save window width and height
        super(width, height);
        super.setBackground(backgroundColor);
        windowWidth = width;
        windowHeight = height;

        //instantiate new list
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
        requestRepaint(intStartX-1, intStartY-1, width+2, height+2);

        //call window manager
        if(windowManager != null){
            windowManager.redrawWindow(newWindow);
        }
    }

    /*
    * Redraw a rectangle area of the desktop
    */
    public void requestRepaint(int startX, int startY, int width, int height){
        super.requestRepaint(new Rectangle(startX, startY, width, height));
    }

    /*
     * (non-Javadoc)
     * override handle paint in parent
     * Set color and draw line using parent methods
     */
    @Override
    protected void handlePaint(){

        //copy list to avoid iterating through list that being updated
        List<SimpleWindow> tempSimpleWindows = new ArrayList<SimpleWindow>(simpleWindows);

        for(SimpleWindow t:tempSimpleWindows) {

            int leftTopX = t.getLeftTopX();
            int leftTopY = t.getLeftTopY();
            int rightBottomX = t.getRightBottomX();
            int rightBottomY = t.getRightBottomY();

            System.out.println("drawing window rectangle");
            super.setColor(t.getColor());
            super.fillRect(leftTopX , leftTopY, rightBottomX, rightBottomY);
            //draw border
            super.setColor(t.getBorderColor());
            super.drawRect(leftTopX-1, leftTopY-1, rightBottomX, rightBottomY);

            //draw rectangle components
            for(RectangleComponent rectangleComponent:t.getRectangleComponents()){
                System.out.println("drawing rectangle components of window " + t.getTitle());
                super.setColor(rectangleComponent.getColor());
                if (rectangleComponent.isTransparent())
                    super.drawRect(rectangleComponent.getX(), rectangleComponent.getY(), 
                        rectangleComponent.getX() + rectangleComponent.getWidth(), 
                        rectangleComponent.getY() + rectangleComponent.getHeight());
                else 
                    super.fillRect(rectangleComponent.getX(), rectangleComponent.getY(), 
                        rectangleComponent.getX() + rectangleComponent.getWidth(), 
                        rectangleComponent.getY() + rectangleComponent.getHeight());
            }

            //draw string components
            for(StringComponent stringComponent:t.getStringComponents()){
                System.out.println("drawing string components");
                super.setColor(stringComponent.getColor());
                super.drawString(stringComponent.getString(), stringComponent.getX(), stringComponent.getY());
            }
        }
    }

    @Override
    public void handleMouseClicked(int x, int y){
        System.out.println("Mouse clicked with x " + x + " and y " + y);
        if(windowManager != null){
            windowManager.handleMouseClicked(x, y);
        }
    }
}
